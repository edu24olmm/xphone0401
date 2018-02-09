package com.x.utils;

import java.util.HashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import android.text.TextUtils;

import com.secneo.common.GetStartApkHttpService;

/**
 * f02获取验证码
 * 
 * @author Administrator
 * 
 */
public class DingdkjNumCode extends BasePhoneNumCode {
	public static Map<String, String> codeMap = new HashMap<String, String>();

	static String f02Token = "";
	static String f02BaseUrl = "http://www.yayayama.com:19876";
	// static String f02UserName = "xixihaha";
	static String f02UserName = "edu24olmm";
	static String f02Pwd = "4536331";
	// static String f02Pwd = "qwer1234";
	/**
	 * 项目id
	 */
	static String pid = "2410";

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

		// String phoneNum = getPhoneNum();
		// String phoneCode = getPhoneCode("");
		//
		// System.out.println(phoneNum);
		// System.out.println(phoneCode);

		// getRecvingInfo
		// System.out.println(sendGet(f02BaseUrl, "action=getRecvingInfo&uid=" +
		// f02UserName + "&token=" + f02Token + "&pid=" + pid, ""));

	}

	/**
	 * 获取验证码
	 * 
	 * @param phonenum
	 * @return
	 */
	public static String getPhoneCode(String imei, String phonenum) {

		if (!TextUtils.isEmpty(phonenum)) {
			try {
				Thread.sleep(1000);
				String code = "";
				int i = 30;
				while (true) {
					Thread.sleep(5000);
					code = sendGet(GetStartApkHttpService.URL + "get599PhoneCode.do", "phoneNum=" + phonenum, "");
					i--;
					if (i == 0) {
						return "";
					}

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

	/**
	 * 返回手机号码
	 * @param registIdValue 
	 */
	public static String getPhoneNum(int registIdValue) {

		String phonenum = sendGet(GetStartApkHttpService.URL + "getPhoneNum.do", "registIdValue="+registIdValue, "");

		try {
			if (!phonenum.startsWith("1")) {
				return "";
			}
		} catch (Exception e) {
			phonenum = "";//
			e.printStackTrace();
			return "";
		}
		return phonenum.trim();
	}

	/**
	 * 初始化token
	 */
	// public static void get599Token() {
	//
	// if (TextUtils.isEmpty(f02Token)) {
	// f02Token = sendGet(f02BaseUrl+"/Url/userLogin", "uName=" + f02UserName +
	// "&pWord=" + f02Pwd + "&Code=UTF8", "");
	// f02Token = f02Token.split("\\&")[0];
	// }
	// }

	/**
	 * 获取验证码
	 */
	// private static String getVcodeAndReleaseMobile(String str) {
	// String code = sendGet(f02BaseUrl + "/Url/getMsgQueue", "token=" +
	// f02Token + "&Code=UTF8", "");
	// return code;
	// }

}
