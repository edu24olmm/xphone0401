package com.x.generator;

import java.util.Random;

public class OperatorUtil {
	public String Operator;
	public String OperatorName;
	public String SimSerialNumber;
	public String SubID;
	public int NetWorkType = 1;
	private static String[] firstNum = new String[] { "46000", "46001", "46003" }; // 移动,联通,电信
	private static String[] firstStr = new String[] { "CMCC", "China Unicom", "CTC" };
	private static String[] num = new String[] { "898600", "898601", "898606" };

	// 移动
	// private static String[] firstNum = new String[] { "46000", "46000",
	// "46000" };
	// private static String[] firstStr = new String[] { "CMCC", "GSM", "CMCC"
	// };
	// private static String[] num = new String[] { "898600", "898602", "898600"
	// };

	public static OperatorUtil getNew() {
		OperatorUtil aa = new OperatorUtil();
		Random random = new Random();
		int ran = random.nextInt(10);
		int i = 0;
		if (ran < 5) {
			i = 0;
		} else if (ran < 8) {
			i = 1;
		} else {
			i = 2;
		}
		aa.Operator = firstNum[i];
		aa.OperatorName = firstStr[i];
		aa.SimSerialNumber = num[i] + RanUtil.getRanNub(13);
		aa.SubID = firstNum[i] + RanUtil.getRanNub(11);
		int typeRate = new Random().nextInt(11); // 各种网络的类型
		if (aa.Operator.intern() == "46000".intern()) {
			if (typeRate < 1) {
				aa.NetWorkType = 1; // GPRS
			} else if (typeRate > 0 && typeRate < 6) {
				aa.NetWorkType = 2; // EDGE
			} else if (typeRate > 5 && typeRate < 9) {
				aa.NetWorkType = 17; // TD_SCDMA
			} else {
				aa.NetWorkType = 13; // LTE
			}
		} else if (aa.Operator.intern() == "46001".intern()) {
			if (typeRate < 2) { //
				aa.NetWorkType = 1; // GPRS
			} else if (typeRate > 1 && typeRate < 4) { // 99%的几率是移动2G&&3G
				aa.NetWorkType = 2; // EDGE
			} else if (typeRate > 3 && typeRate < 9) {
				aa.NetWorkType = 8; // HSDPA
			} else {
				aa.NetWorkType = 13; // LTE
			}
		} else if (aa.Operator.intern() == "46003".intern()) {
			if (typeRate < 2) { //
				aa.NetWorkType = 4; // CDMA
			} else if (typeRate > 1 && typeRate < 4) { // 99%的几率是移动2G&&3G
				aa.NetWorkType = 5; // CDMA+
			} else if (typeRate > 3 && typeRate < 9) {
				aa.NetWorkType = 6; // CDMA++
			} else {
				aa.NetWorkType = 13; // LTE
			}
		}

		return aa;
	}

	public static int getNetWorkType(String Operator) {
		int NetWorkType = 1;
		int typeRate = new Random().nextInt(11); // 各种网络的类型
		if ("46000".equals(Operator)) {
			if (typeRate < 1) {
				NetWorkType = 1; // GPRS
			} else if (typeRate > 0 && typeRate < 6) {
				NetWorkType = 2; // EDGE
			} else if (typeRate > 5 && typeRate < 9) {
				NetWorkType = 17; // TD_SCDMA
			} else {
				NetWorkType = 13; // LTE
			}
		} else if ("46001".equals(Operator)) {
			if (typeRate < 2) { //
				NetWorkType = 1; // GPRS
			} else if (typeRate > 1 && typeRate < 4) { // 99%的几率是移动2G&&3G
				NetWorkType = 2; // EDGE
			} else if (typeRate > 3 && typeRate < 9) {
				NetWorkType = 8; // HSDPA
			} else {
				NetWorkType = 13; // LTE
			}
		} else if ("46003".equals(Operator)) {
			if (typeRate < 2) { //
				NetWorkType = 4; // CDMA
			} else if (typeRate > 1 && typeRate < 4) { // 99%的几率是移动2G&&3G
				NetWorkType = 5; // CDMA+
			} else if (typeRate > 3 && typeRate < 9) {
				NetWorkType = 6; // CDMA++
			} else {
				NetWorkType = 13; // LTE
			}
		}
		return NetWorkType;
	}
}
