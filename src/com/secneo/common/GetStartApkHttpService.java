package com.secneo.common;

import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.util.Map;

public class GetStartApkHttpService {

	// 名空间
	
	// 网址
	//public static final String URL = "http://192.168.3.32:7080/z/";
	 public static String URL = "http://192.168.1.110:1082/z/";
//	 public static String URL = "http://10.4.81.114:1082/z/";
	// public static String URL = "http://120.25.234.216:1082/z/";
	public static final String SaveToServer = URL + "SaveToServer.do?";
	public static final String keepByServer = URL + "keepByServer.do?";
	public static final String queryAndroidInfosByTaskId = URL + "queryAndroidInfosByTaskId.do?";

	// "{\"isReachTopOfEveryDay\":\"true\"}";

	/**
	 * 在调用该方法时，也需构建一个Map对象
	 * 
	 */
	public static boolean sendGetRequest(String path, Map<String, String> params, String enc) throws Exception {
		StringBuilder sb = new StringBuilder(path);
		sb.append('?');
		// ?method=save&title=435435435&timelength=89&
		// 把Map中的数据迭代附加到StringBuilder中
		for (Map.Entry<String, String> entry : params.entrySet()) {
			// URLEncoder.encode对字符串中文进行编码，防止乱码
			sb.append(entry.getKey()).append('=').append(URLEncoder.encode(entry.getValue(), enc)).append('&');
		}
		// 去掉最后一个字符&
		sb.deleteCharAt(sb.length() - 1);
		// 把组拼完的路径传到URL对象
		System.out.println("请求的地址为 =" + sb.toString());
		URL url = new URL(sb.toString());
		HttpURLConnection conn = (HttpURLConnection) url.openConnection();
		// 设置请求方式，GET要大写
		conn.setRequestMethod("GET");
		conn.setConnectTimeout(5 * 1000);
		// "200"代表请求成功
		if (conn.getResponseCode() == 200) {
			return true;
		}
		return false;
	}
}
