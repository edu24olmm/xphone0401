package com.secneo.common;

import java.io.IOException;

import org.apache.http.client.HttpResponseException;
import org.ksoap2.SoapEnvelope;
import org.ksoap2.serialization.SoapObject;
import org.ksoap2.serialization.SoapPrimitive;
import org.ksoap2.serialization.SoapSerializationEnvelope;
import org.ksoap2.transport.HttpTransportSE;
import org.xmlpull.v1.XmlPullParserException;

import android.os.AsyncTask;

public class GetStartApkWebService extends AsyncTask<String, String, Object> {

	// 名空间
	private static final String NAMESPACE = "http://webservice.secneo.com/";
	// 网址
	private static String URL = "http://192.168.3.32:8080/x/services/helloword";
	// private static String URL =
	// "http://192.168.1.110:8080/x/services/helloword";
//	private static String URL = "http://120.25.234.216:8080/x/services/helloword";
	private static final String SaveToServer = "SaveToServer";
	private static final String keepByServer = "keepByServer";

	// SOAPACTION
	private static String SOAP_ACTION_getApkActivity = "{http://webservice.secneo.com/}SaveToServer";
	private static String SOAP_ACTION_keepByServer = "{http://webservice.secneo.com/}keepByServer";

	public static Object test(String method, String phoneInfo)
			throws HttpResponseException, IOException, XmlPullParserException,
			InterruptedException {

		// handleNetworkOnMainThreadException();

		if (SaveToServer.equalsIgnoreCase(method)) {
			SoapObject rpc = new SoapObject(NAMESPACE, SaveToServer);
			rpc.addProperty("phoneInfo", phoneInfo);
			SoapSerializationEnvelope envelope = new SoapSerializationEnvelope(
					SoapEnvelope.VER10);
			envelope.bodyOut = rpc;
			System.setProperty("http.keepAlive", "false");
			envelope.dotNet = true;
			envelope.setOutputSoapObject(rpc);
			HttpTransportSE ht = new HttpTransportSE(URL, 120000);
			ht.debug = true;
			ht.call(SOAP_ACTION_getApkActivity, envelope);
			SoapPrimitive detail = (SoapPrimitive) envelope.getResponse();
			System.out.println("getApkActivity---------------"
					+ detail.toString());
			return detail.toString();
		} else if (keepByServer.equalsIgnoreCase(method)) {
			SoapObject rpc = new SoapObject(NAMESPACE, keepByServer);
			rpc.addProperty("id", phoneInfo);
			SoapSerializationEnvelope envelope = new SoapSerializationEnvelope(
					SoapEnvelope.VER10);
			envelope.bodyOut = rpc;
			System.setProperty("http.keepAlive", "false");
			envelope.dotNet = true;
			envelope.setOutputSoapObject(rpc);
			HttpTransportSE ht = new HttpTransportSE(URL, 120000);
			ht.debug = true;
			ht.call(SOAP_ACTION_keepByServer, envelope);
			SoapPrimitive detail = (SoapPrimitive) envelope.getResponse();
			if (detail != null) {
				System.out.println("getApkActivity---------------"
						+ detail.toString());
				return detail.toString();
			} else {
				return null;
			}
		}
		return "";
	}

	@Override
	protected Object doInBackground(String... params) {
		// TODO 自动生成的方法存根
		try {
			return test(params[0], params[1]);
		} catch (Exception e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
			return "{\"isReachTopOfEveryDay\":\"true\"}";
		}
	}
}
