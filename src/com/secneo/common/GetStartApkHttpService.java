package com.secneo.common;

import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.util.Map;

public class GetStartApkHttpService {

	// ���ռ�
	
	// ��ַ
	//public static final String URL = "http://192.168.3.32:7080/z/";
	 public static String URL = "http://192.168.1.110:1082/z/";
//	 public static String URL = "http://10.4.81.114:1082/z/";
	// public static String URL = "http://120.25.234.216:1082/z/";
	public static final String SaveToServer = URL + "SaveToServer.do?";
	public static final String keepByServer = URL + "keepByServer.do?";
	public static final String queryAndroidInfosByTaskId = URL + "queryAndroidInfosByTaskId.do?";

	// "{\"isReachTopOfEveryDay\":\"true\"}";

	/**
	 * �ڵ��ø÷���ʱ��Ҳ�蹹��һ��Map����
	 * 
	 */
	public static boolean sendGetRequest(String path, Map<String, String> params, String enc) throws Exception {
		StringBuilder sb = new StringBuilder(path);
		sb.append('?');
		// ?method=save&title=435435435&timelength=89&
		// ��Map�е����ݵ������ӵ�StringBuilder��
		for (Map.Entry<String, String> entry : params.entrySet()) {
			// URLEncoder.encode���ַ������Ľ��б��룬��ֹ����
			sb.append(entry.getKey()).append('=').append(URLEncoder.encode(entry.getValue(), enc)).append('&');
		}
		// ȥ�����һ���ַ�&
		sb.deleteCharAt(sb.length() - 1);
		// ����ƴ���·������URL����
		System.out.println("����ĵ�ַΪ =" + sb.toString());
		URL url = new URL(sb.toString());
		HttpURLConnection conn = (HttpURLConnection) url.openConnection();
		// ��������ʽ��GETҪ��д
		conn.setRequestMethod("GET");
		conn.setConnectTimeout(5 * 1000);
		// "200"��������ɹ�
		if (conn.getResponseCode() == 200) {
			return true;
		}
		return false;
	}
}
