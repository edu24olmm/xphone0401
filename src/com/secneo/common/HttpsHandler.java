/*
 * Copyright (c) 2013. Kevin Lee (www.buybal.com).
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.secneo.common;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.security.KeyManagementException;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.security.cert.CertificateException;
import java.security.cert.X509Certificate;

import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSession;
import javax.net.ssl.TrustManager;
import javax.net.ssl.X509TrustManager;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.HttpStatus;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.mime.MultipartEntity;
import org.apache.http.entity.mime.content.FileBody;
import org.apache.http.entity.mime.content.StringBody;

import android.app.AlertDialog;
import android.app.AlertDialog.Builder;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.util.Log;
import android.widget.Toast;

import com.google.gson.Gson;
import com.x.phone.PhoneInfo;
import com.x.xphone.R;

/**
 * Created with IntelliJ IDEA. User: william Date: 13-5-9 Time: 上午9:52
 * Mobi:18601920351 Email: lishu@qdcf.com
 */
public class HttpsHandler extends Handler {
	public static final String TAG = HttpsHandler.class.getSimpleName();
	public static final int RESPONSE_SUCCESS = 0x00; // 请求成功
	public static final int RESPONSE_START = 0x01; // 开始请求
	public static final int RESPONSE_ERROR = 0x02; // 请求错误（请求异常）
	public static final int RESPONSE_FAILURE = 0x03; // 请求失败（服务器返回失败）
	public static final int RESPONSE_CONNECT_TIMEOUT = 0x04; // 连接超时
	public static final int RESPONSE_RECEIVE_TIMEOUT = 0x05; // 接收超时
	public static final int RESPONSE_LOGINOUT = 0x06; // 登录超时
	public static final int NOTLOGIN = 5; // 未登录
	public static final int NETERROR = 6; // 网络连接失败
	public static final int REQUEST_DEFAULT = 0;
	public static final int REQUEST_GET_MSG = 1;
	public static final int REQUEST_REGISTER = 2;
	// 上下文
	private Context ctx;
	// 进度对话框
	public ProgressDialog progressDialog;

	private Thread thread;

	@Override
	public void handleMessage(Message msg) {
		switch (msg.what) {
		case HttpsHandler.RESPONSE_LOGINOUT:
			onHttpSessionTimeOut(msg);
			break;
		case HttpsHandler.RESPONSE_START:
			onHttpStart(msg);
			break;
		case HttpsHandler.RESPONSE_FAILURE:
			onHttpFailure(msg);
			break;
		case HttpsHandler.RESPONSE_ERROR:
			onHttpError(msg);
			break;
		case HttpsHandler.RESPONSE_SUCCESS:
			onHttpSuccess(msg);
			break;
		default:
			throw new IllegalArgumentException(ctx.getResources().getString(
					R.string.network_error));
		}
	}

	/**
     *
     */

	/**
	 * 开始发起网络请求，并校验网络状态
	 *
	 * @param msg
	 *            线程返回的消息
	 */
	public void onHttpStart(Message msg) {
		if (progressDialog == null) {
			if (msg.arg1 == 1) {
				return;
			}
			progressDialog = ProgressDialog.show(ctx, ctx.getResources()
					.getString(R.string.dialog_title), ctx.getResources()
					.getString(R.string.progress_content_message), true, false);

		}
	}

	/**
	 * 服务器返回错误信息
	 *
	 * @param msg
	 *            线程返回消息
	 */
	public void onHttpFailure(Message msg) {
		if (msg == null) {
			Toast.makeText(
					ctx,
					ctx.getResources().getString(
							R.string.network_error),
					Toast.LENGTH_SHORT).show();
		}
		if (progressDialog != null) {
			progressDialog.dismiss();
			progressDialog = null;
		}
		if (msg == null) {
			return;
		}
		PhoneInfo response = new Gson().fromJson(
				msg.obj != null ? msg.obj.toString() : null, PhoneInfo.class);
		Toast.makeText(ctx, response != null ? "" : "", Toast.LENGTH_LONG)
				.show();
	}

	/**
	 * 本地发起请求出错
	 *
	 * @param msg
	 *            线程返回消息
	 */
	public void onHttpError(Message msg) {
		if (progressDialog != null) {
			progressDialog.dismiss();
			progressDialog = null;
		}
		AlertDialog.Builder builder = new Builder(ctx);
		builder.setMessage(msg.obj != null ? msg.obj.toString() : null);
		builder.setTitle(ctx.getResources().getString(
				R.string.dialog_title));
		builder.setPositiveButton(
				ctx.getResources().getString(android.R.string.ok),
				new OnClickListener() {
					@Override
					public void onClick(DialogInterface dialog, int which) {
						dialog.dismiss();
						// ((Activity) ctx).finish();
						// android.os.Process.killProcess(android.os.Process.myPid());
						// System.exit(0);
					}
				});
		AlertDialog alertDialog = builder.create();
		alertDialog.setCancelable(false);
		alertDialog.show();
	}

	/**
	 * 网络请求成功
	 *
	 * @param msg
	 *            线程返回消息
	 */
	public void onHttpSuccess(Message msg) {
		if (progressDialog != null) {
			try {
				progressDialog.dismiss();
			} catch (Exception e) {
				e.printStackTrace();
			}
			progressDialog = null;
		}
	}

	//

	/**
	 * 登录超时处理
	 *
	 * @param msg
	 *            线程返回消息
	 */
	public void onHttpSessionTimeOut(Message msg) {
		if (msg == null) {
			return;
		}
		PhoneInfo response = new Gson().fromJson(
				msg.obj != null ? msg.obj.toString() : null, PhoneInfo.class);
		if (progressDialog != null) {
			progressDialog.dismiss();
			progressDialog = null;
		}
		AlertDialog.Builder builder = new Builder(ctx);
		builder.setMessage(response.getRetMsg());
		builder.setTitle("提示");
		builder.create().show();
	}

	/**
	 * 获取服务器数据
	 *
	 * @param ctx
	 *            （Activity）上下文
	 * @param host
	 *            主机地址
	 * @param request
	 *            请求字符串
	 */
	public void getHttpsResponse(Context ctx, String host, String request) {
		this.ctx = ctx;
		// 添加UTF-8编码
		try {
			request = URLEncoder.encode(request, "utf-8");

			new Thread(new RequestRunnable(host + request)).start();
		} catch (UnsupportedEncodingException e) {
			if (Log.isLoggable(TAG, Log.DEBUG)) {
				Log.d(TAG, "UnsupportedEncodingException", e);
			}
		}
	}

	/**
	 * 获取服务器数据, 添加是否显示对话框
	 *
	 * @param ctx
	 *            上下文
	 * @param host
	 *            服务器地址
	 * @param request
	 *            请求字符串
	 * @param hasDialog
	 *            是否含有对话框
	 */
	public void getHttpsResponse(Context ctx, String host, String request,
			Boolean hasDialog) {
		this.ctx = ctx;
		try {
			request = URLEncoder.encode(request, "utf-8");
			if (hasDialog) { // 有对话框
				thread = new Thread(new RequestRunnable(host + request, 0));
				thread.start();
			} else { // 没对话框，leaked window BUG （Activity已经关闭，dialog还在进行异步操作）
				new Thread(new RequestRunnable(host + request, 1)).start();
			}
		} catch (UnsupportedEncodingException e) {
			if (Log.isLoggable(TAG, Log.DEBUG)) {
				Log.d(TAG, "UnsupportedEncodingException", e);
			}
		}
	}

	public void postHttp(Context context, String host, String request, File file) {
		this.ctx = context;
		try {
			request = URLEncoder.encode(request, "utf-8");
			new Thread(new PostHttpRunnable(host, request, file)).start();
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}

	}

	private class PostHttpRunnable implements Runnable {
		private String url = null;
		private int arg1 = 0;
		private String arg2 = null;
		private File file = null;

		public PostHttpRunnable() {
		}

		public PostHttpRunnable(String host, String request, File file) {
			this.url = host;
			this.arg2 = request;
			this.file = file;
		}

		@Override
		public void run() {
			Message msg;
			// 开始发送HTTP消息
			msg = HttpsHandler.this.obtainMessage(HttpsHandler.RESPONSE_START);
			msg.arg1 = this.arg1;
			msg.obj = "";
			HttpsHandler.this.sendMessage(msg);
			try {
				HttpPost post = new HttpPost(url);
				HttpClient client = HttpClientHelper.getHttpClient();
				// MultipartEntityBuilder entity =
				// MultipartEntityBuilder.create();
				// entity.setMode(HttpMultipartMode.BROWSER_COMPATIBLE);
				MultipartEntity entity = new MultipartEntity();
				entity.addPart("reqJson", new StringBody(arg2));
				// entity.addTextBody("reqJson", arg2);
				// 添加文件参数
				if (file != null && file.exists()) {
					entity.addPart("picture", new FileBody(file));
				}
				// post.setEntity(entity.build());
				post.setEntity(entity);
				HttpResponse response = client.execute(post);
				int stateCode = response.getStatusLine().getStatusCode();
				StringBuilder sb = new StringBuilder();
				if (stateCode == HttpStatus.SC_OK) {
					// HTTP通讯成功
					HttpEntity result = response.getEntity();
					if (result != null) {
						InputStream is = result.getContent();
						BufferedReader br = new BufferedReader(
								new InputStreamReader(is));
						String tempLine;
						while ((tempLine = br.readLine()) != null) {
							sb.append(tempLine);
						}
					}
					msg = HttpsHandler.this
							.obtainMessage(HttpsHandler.RESPONSE_SUCCESS);
					msg.arg1 = this.arg1;
					msg.obj = sb.toString();
					HttpsHandler.this.sendMessage(msg);
				}
				post.abort();
			} catch (Exception e) {
				if (Log.isLoggable(TAG, Log.DEBUG)) {
					Log.d(TAG, "NetworkErrorException", e);
				}
				msg = HttpsHandler.this
						.obtainMessage(HttpsHandler.RESPONSE_ERROR);
				msg.obj = ctx.getResources().getString(
						R.string.network_error);
				HttpsHandler.this.sendMessage(msg);
			}
			// catch (UnsupportedEncodingException e) {
			// e.printStackTrace();
			// } catch (ClientProtocolException e) {
			// e.printStackTrace();
			// } catch (IOException e) {
			// e.printStackTrace();
			// }
		}

	}

	private class RequestRunnable implements Runnable {
		private String url;
		private int arg1 = 0;

		/**
		 * 有Dialog的网络请求
		 *
		 * @param url
		 *            网址
		 */
		public RequestRunnable(String url) {
			this.url = url;
		}

		/**
		 * 没有Dialog的网络请求
		 *
		 * @param url
		 *            网址
		 * @param arg1
		 *            0 ：有dialog 1 ：没有dialog
		 */
		public RequestRunnable(String url, int arg1) {
			this.url = url;
			this.arg1 = arg1;
		}

		@SuppressWarnings("unused")
		private HttpURLConnection initHttp(String url)
				throws NoSuchAlgorithmException, KeyManagementException,
				IOException {
			return (HttpURLConnection) new URL(url).openConnection();
		}

		private HttpsURLConnection initHttps(String url)
				throws NoSuchAlgorithmException, KeyManagementException,
				IOException {
			SSLContext sc = SSLContext.getInstance("TLS");
			sc.init(null, new TrustManager[] { new MyTrustManager() },
					new SecureRandom());
			HttpsURLConnection
					.setDefaultSSLSocketFactory(sc.getSocketFactory());
			HttpsURLConnection
					.setDefaultHostnameVerifier(new MyHostnameVerifier());

			return (HttpsURLConnection) new URL(url).openConnection();
		}

		@Override
		public void run() {
			Message msg;
			// 开始发送HTTP消息
			msg = HttpsHandler.this.obtainMessage(HttpsHandler.RESPONSE_START);
			msg.arg1 = this.arg1;
			msg.obj = "";
			HttpsHandler.this.sendMessage(msg);
			try {
				// HttpsURLConnection conn = initHttps(url);
				HttpURLConnection conn = initHttp(url);
				// 设置Session ID
				// String cookies = getLocalCookies();
				// conn.setRequestProperty("Cookie", cookies);
				conn.setDoInput(true);
				conn.setDoOutput(true);
				conn.setRequestMethod("GET");
				conn.setConnectTimeout(60 * 1000); // 连接超时
				conn.setReadTimeout(60 * 1000); // 接收超时
				conn.connect();
				int responseCode = conn.getResponseCode();
				if (responseCode != HttpStatus.SC_OK) {
					if (Log.isLoggable(TAG, Log.DEBUG)) {
						Log.d(TAG, "responseCode" + responseCode);
					}
					msg = HttpsHandler.this
							.obtainMessage(HttpsHandler.RESPONSE_ERROR);
					msg.obj = ctx.getResources().getString(
							 R.string.system_maintenance);
					HttpsHandler.this.sendMessage(msg);
					return;
				}
				BufferedReader br = new BufferedReader(new InputStreamReader(
						conn.getInputStream()));
				StringBuilder sb = new StringBuilder();
				String line;
				while ((line = br.readLine()) != null) {
					sb.append(line);
				}
				// 存储服务器返回的SessionID
				// setLocalCookies(conn);
				// HTTP通讯成功
				msg = HttpsHandler.this
						.obtainMessage(HttpsHandler.RESPONSE_SUCCESS);
				msg.arg1 = this.arg1;
				msg.obj = sb.toString();
				HttpsHandler.this.sendMessage(msg);
			} catch (Exception e) {
				if (Log.isLoggable(TAG, Log.DEBUG)) {
					Log.d(TAG, "NetworkErrorException", e);
				}
				msg = HttpsHandler.this
						.obtainMessage(HttpsHandler.RESPONSE_ERROR);
				msg.obj = ctx.getResources().getString(
						R.string.network_error);
				HttpsHandler.this.sendMessage(msg);
			}
		}
	}

	private class MyHostnameVerifier implements HostnameVerifier {
		@Override
		public boolean verify(String hostname, SSLSession session) {
			if (Log.isLoggable(TAG, Log.DEBUG)) {
				Log.d(TAG, "hostName:" + hostname + "; \nSSLSession: "
						+ session.getPeerHost() + ":" + session.getPeerPort());
			}
			return true;
		}
	}

	private class MyTrustManager implements X509TrustManager {

		@Override
		public void checkClientTrusted(X509Certificate[] chain, String authType)
				throws CertificateException {

		}

		@Override
		public void checkServerTrusted(X509Certificate[] chain, String authType)
				throws CertificateException {

		}

		@Override
		public X509Certificate[] getAcceptedIssuers() {
			// return new X509Certificate[0];
			return null;
		}
	}

	/*
	 * public void onStopHttpResponse() { if(thread != null){ if (progressDialog
	 * != null) { progressDialog.dismiss(); progressDialog = null; } } }
	 */
}
