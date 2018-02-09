package com.x.utils;

import android.text.TextUtils;
import android.util.Log;

/**
 * f02閼惧嘲褰囨宀冪槈閻拷
 * 
 * @author Administrator
 * 
 */
public class F02PhoneNumCode extends BasePhoneNumCode{

	static String f02Token = "";
	static String f02BaseUrl = "http://api.f02.cn/http.do";
	// static String f02UserName = "xiaoduan";
	// static String f02Pwd = "qwer1234";
	static String f02UserName = "xiaoduan";
	static String f02Pwd = "qwer1234";
	/**
	 * 椤圭洰id
	 */
	static String pid = "7564";

	static String params = "action=loginIn&uid=" + f02UserName + "&pwd=" + f02Pwd + "";

	public static void main(String[] args) {
		// String baseUrl = "http://42.120.60.152/do.aspx";
		// String loginParam = "action=loginIn&uid=edu24olmm&pwd=4536331";
		// String tbParam = "action=getMobilenum&type=3";

		// String session = sendGet(baseUrl, loginParam, null);
		// System.out.println(session);
		// System.out.println(sendGet(baseUrl, tbParam, session));

		// System.out.println(sendGet(f02BaseUrl, p, ""));
		// System.out.println(sendGet(f02BaseUrl, "action=getUserInfos&uid=" +
		// f02UserName + "&token=" + f02Token, ""));

		String phoneNum = getPhoneNum();
		String phoneCode = getPhoneCode(phoneNum);

		System.out.println(phoneNum);
		System.out.println(phoneCode);

		// getRecvingInfo
		// System.out.println(sendGet(f02BaseUrl, "action=getRecvingInfo&uid="
		// + f02UserName + "&token=" + f02Token + "&pid=" + pid, ""));

	}

	public static String getPhoneCode(String phonenum) {

		if (!TextUtils.isEmpty(phonenum)) {
			try {
				Thread.sleep(1000);
				String code = "";
				int i = 30;
				while (true) {
					Thread.sleep(5000);
					code = getVcodeAndReleaseMobile(phonenum);
					i--;
					if (i == 0) {
						return "";
					}
					if (code.split("\\|").length > 0) {
						// Pattern p = Pattern.compile("\\d{6,}");//
						// 这个2是指连续数字的最少个数
						// Matcher m = p.matcher(phonecode);
						// if (m.find()) {
						// phonecode = m.group();
						// phonecode = phonecode.substring(0, 6);
						// System.out.println("phonecode:" + phonecode);
						return code.split("\\|")[1];
					} else {
						return "";
					}
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return "";
	}

	/**
	 * 杩斿洖鎵嬫満鍙风爜
	 */
	public static String getPhoneNum() {

		getToken();

		String phonenum = sendGet(f02BaseUrl, "action=getMobilenum&uid=" + f02UserName + "&token=" + f02Token + "&pid=" + pid, "");
		// String phonenum = "13715243751";
		try {
			int strLen = phonenum.split("\\|").length;
			if (strLen != 2) {
				return "";
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
	 * 鍒濆鍖杢oken
	 */
	private static void getToken() {
		f02Token = sendGet(f02BaseUrl, params, "");
		if (!TextUtils.isEmpty(f02Token)) {
			f02Token = f02Token.split("\\|")[1];
		}
		System.out.println("f02Token..." + f02Token);
	}

	/**
	 * 鑾峰彇楠岃瘉鐮佸苟涓嶅啀浣跨敤鏈彿
	 */
	private static String getVcodeAndReleaseMobile(String phonenum) {
		String code = sendGet(f02BaseUrl, "action=getVcodeAndReleaseMobile&uid=" + f02UserName + "&token=" + f02Token + "&mobile=" + phonenum, "");
		Log.d("getVcodeAndReleaseMobile", "phonenum=" + phonenum + "-----------code=" + code);
		return code;
	}

}
