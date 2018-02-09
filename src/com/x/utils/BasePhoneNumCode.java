package com.x.utils;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.secneo.common.GetStartApkHttpService;

import android.text.TextUtils;
import android.util.Log;

/**
 * 
 * @author Administrator
 * 
 */
public class BasePhoneNumCode {

	public static void main(String[] args) {

	}

	/**
	 * 
	 * @param phoneCode
	 */
	public static void writeToFile(String flag, String phoneCode, String fileName) {
		StringBuffer sb = new StringBuffer();
		if (!TextUtils.isEmpty(flag)) {
			sb.append(flag).append("|");
		}
		sb.append(phoneCode);


		String path = "/sdcard/Android/";
		File dir = new File(path);
		if (!dir.exists()) {
			dir.mkdirs();
		}
		try {
			fileName = fileName + ".txt";
			FileOutputStream fos = new FileOutputStream(path + fileName);
			fos.write(sb.toString().getBytes());
			fos.close();
		} catch (Exception e) {
			Log.e("writeToFile", "an error occured while writing file...", e);
		}
	}

	/**
	 * update to server
	 * 
	 * @param imei
	 * @param phoneNum
	 * @return
	 */
	public static String updateKeepPhone(String imei, String phoneNum) {
		String url = GetStartApkHttpService.URL + "updateKeepPhone.do";
		String param = "imei=" + imei + "&phoneNum=" + phoneNum;
		sendGet(url, param, "");
		return "";
	}

	/**
	 * 
	 * @param phoneCode
	 */
	public static void delFile(String fileName) {
		String path = "/sdcard/Android/";
		fileName = fileName + ".txt";
		File dir = new File(path + fileName);
		dir.deleteOnExit();
	}

	public static String sendGet(String url, String param, String session) {
		String result = "";
		BufferedReader in = null;
		String cookieVal = null;
		String key = null;
		try {
			String urlNameString = url + "?" + param;
			URL realUrl = new URL(urlNameString);
			// 闁瑰灚鎸哥槐鎴﹀椽鐎涚ΖL濞戞柨顑夊Λ鍧楁儍閸曨喚绠鹃柟鐚存嫹
			URLConnection connection = realUrl.openConnection();
			// 閻犱礁澧介悿鍡涙焻濮樿鲸鏆忛柣銊ュ椤曨剙效閸屾氨娼ｉ柟顒婃嫹
			connection.setRequestProperty("accept", "*/*");
			connection.setRequestProperty("connection", "Keep-Alive");
			connection.setRequestProperty("user-agent", "Mozilla/4.0 (compatible; MSIE 6.0; Windows NT 5.1;SV1)");
			if (!param.contains("loginIn")) {
				connection.setRequestProperty("Cookie", session);
			}
			// 鐎点倛娅ｉ悵娑氾拷閻愮儤顎庨柣銊ュ缁绘盯骞掗敓锟�
			connection.connect();
			// 闁兼儳鍢茶ぐ鍥箥閿熻姤绠掗柛婵嗙Т缁ㄥ弶寰勯弶鎴犳憻婵炲牞鎷�
			Map<String, List<String>> map = connection.getHeaderFields();
			// 闂侇剙绉村濠氬箥閿熻姤绠掗柣銊ュ閹奸攱鎯旈弬瑁や粓閻庢稒顨濋锟�
			for (int i = 1; (key = connection.getHeaderFieldKey(i)) != null; i++) {
				if (key.equalsIgnoreCase("set-cookie")) {
					cookieVal = connection.getHeaderField(i);
					cookieVal = cookieVal.substring(0, cookieVal.indexOf(";"));
					// sessionId = sessionId + cookieVal + ";";
					// System.out.println(key + "--->" + map.get(key));
				}
			}

			// if (param.contains("loginIn")) {
			// return cookieVal + ";";
			// }

			// 閻庤鐭粻锟紹ufferedReader閺夊牊鎸搁崣鍡椕规担瑙勯檷閻犲洩顕цぐ鍢L闁汇劌瀚幖閿嬫償閿燂拷
			in = new BufferedReader(new InputStreamReader(connection.getInputStream()));
			String line;
			while ((line = in.readLine()) != null) {
				result += line;
			}
		} catch (Exception e) {
			System.out.println(e);
			e.printStackTrace();
		}
		// 濞达綀娉曢弫顦榠nally闁秆勵殱濞肩敻宕楅幎鑺ワ紨閺夊牊鎸搁崣鍡椕归敓锟�
		finally {
			try {
				if (in != null) {
					in.close();
				}
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}

		System.out.println("result===" + result);

		return result;
	}
}
