package com.x.utils;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import android.text.TextUtils;

/**
 * 
 * @author Administrator
 * 
 */
public class YiPianYunPhoneNumCode extends BasePhoneNumCode {

	static String f02Token = "";
	static String f02BaseUrl = "http://api.ypyun.com/http.do";
	// static String f02UserName = "xiaoduan";
	// static String f02Pwd = "qwer1234";
	static String f02UserName = "edu24olmm";
	static String f02Pwd = "4536331";
	/**
	 * 妞ゅ湱娲癷d
	 */
	static String pid = "8582";

	public static void main(String[] args) {

		String phoneNum = getPhoneNum();
		executeBs(phoneNum);
		//String phoneCode = getPhoneCode(phoneNum);
		System.out.println(phoneNum);
		//System.out.println(phoneCode);
		//
		// // writeToFile("4", phoneCode, "phoneCode");

		// String str = "15019443645;|20AB06B7E9F82F2FD8D4EB7D343E51F9";
		// str = str.replaceAll(";", "");
		// System.out.println(str);

		// getRecvingInfo
		// System.out.println(sendGet(f02BaseUrl, "action=getRecvingInfo&uid="
		// + f02UserName + "&token=" + f02Token + "&pid=" + pid, ""));

	}

	/**
	 * 
	 * @param phonenum
	 * @return
	 */
	public static String getPhoneCode(String imei,String phonenum) {

		if (!TextUtils.isEmpty(phonenum)) {
			try {
				Thread.sleep(1000);
				String code = "";
				int i = 30;

				executeBs(phonenum);

				while (true) {
					Thread.sleep(5000);

					code = getExeResult(phonenum);

					i--;

					if (i == 0) {
						return "";
					}

//					int len = code.split("\\|").length;
//					if (len > 2) {
//						code = code.split("\\|")[1];
//						Pattern p = Pattern.compile("\\d{6,}");//
//						// 杩欎釜2鏄寚杩炵画鏁板瓧鐨勬渶灏戜釜鏁�
//						Matcher m = p.matcher(code);
//						if (m.find()) {
//							code = m.group();
//							code = code.substring(0, 4);
//							System.out.println("phonecode:" + code);
//						}
//						return code;
//					}
					
					if (!TextUtils.isEmpty(code)) {
						Pattern p = Pattern.compile("\\d{6,}");//
						Matcher m = p.matcher(code);
						if (m.find()) {
							code = m.group();
							System.out.println("phonecode:" + code);
							F02PhoneNumCode.writeToFile("", code, "phoneCode");
							BasePhoneNumCode.updateKeepPhone(imei, phonenum);
							return code;
						}
						F02PhoneNumCode.writeToFile("", code, "phoneCode");
						System.out.println(code);
					}
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return "";
	}

	private static String getExeResult(String phonenum) {
		String getExeResult = sendGet(f02BaseUrl, "action=getExeResult&uid=" + f02UserName + "&token=" + f02Token + "&mobile=" + phonenum + "&step=1&pid=" + pid, "");
		return getExeResult;
	}

	/**
	 */
	public static String getPhoneNum() {

		getToken();

		String phonenum = sendGet(f02BaseUrl, "action=getMobilenum&uid=" + f02UserName + "&token=" + f02Token + "&pid=" + pid, "");

		if (phonenum.contains(";")) {
			phonenum = phonenum.replaceAll("\\;", "");
		}

		// String phonenum = "13715243751";
		try {
			int strLen = phonenum.split("\\|").length;
			if (strLen != 2) {
				return phonenum;
			}
			phonenum = phonenum.split("\\|")[0];
		} catch (Exception e) {
			phonenum = "";//
			e.printStackTrace();
			return "";
		}
		return phonenum;
	}

	/**
	 */
	private static void getToken() {
		f02Token = sendGet(f02BaseUrl, "action=loginIn&uid=" + f02UserName + "&pwd=" + f02Pwd, "");
		if (!TextUtils.isEmpty(f02Token)) {
			f02Token = f02Token.split("\\|")[1];
		}
		System.out.println("f02Token..." + f02Token);
	}

	/**
	 * executeBs
	 */
	private static String executeBs(String phonenum) {
		// http://api.ypyun.com/http.do?action=executeBs&uid=鐢ㄦ埛鍚�token=浠ょ墝&pid=椤圭洰ID&mobile=鎵嬫満鍙风爜&step=x
		String executeBs = sendGet(f02BaseUrl, "action=executeBs&uid=" + f02UserName + "&token=" + f02Token + "&mobile=" + phonenum + "&step=1&pid=" + pid, "");
		return executeBs;
	}

}
