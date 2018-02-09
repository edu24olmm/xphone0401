package com.x.generator;

import java.util.Random;

import android.text.TextUtils;

public class WifiUtil {

	public static String getMac() {
		String multiChars = "";
		String priChar = "";
		String nextChar = "";

		for (int i = 0; i < 12; i++) {

			do {
				nextChar = createRandomChar();
			} while (priChar.equals(nextChar));
			priChar = nextChar;
			multiChars += nextChar;
			if (i == 1 || i == 3 || i == 5 || i == 7 || i == 9) {
				multiChars += ":";
			}
		}
		return multiChars;
	}

	private static String createRandomChar() {
		Random rand = new Random();
		String[] chars = new String[] { "a", "b", "c", "d", "e", "f", "0", "1", "2", "3", "4", "5", "6", "7", "8", "9", };
		int rInt = rand.nextInt(chars.length);
		return chars[rInt];
	}

	private static String[] chars = new String[] { "a", "b", "c", "d", "e", "f", "g", "h", "i", "j", "k", "m", "l", "m", "l", "n", "o", "p", "q", "r", "s", "t", "u", "v", "w", "x", "y", "z", "0",
			"1", "2", "3", "4", "5", "6", "7", "8", "9" };

	public static String getSSID() {
		String s = "";
		Random random = new Random(System.currentTimeMillis());
		int index = random.nextInt(10) + 3;
		Random rand = new Random();
		int priInt = 0;
		for (int i = 0; i < index; i++) {
			int nextInt = rand.nextInt(36);
			do {
				nextInt = rand.nextInt(36);
			} while (nextInt == priInt);
			priInt = nextInt;
			s += chars[priInt];
			if (i == 8)
				s += "-";
		}
		return s;
	}

	public static String getPhoneNum() {
		String start = getPhoneNumStart();
		return start + RanUtil.getRanNub(8);
	}

	public static String getPhoneNumStart() {
		Random rand = new Random();
//		String[] chars = new String[] { "138", "134", "135", "139", "136", "137", "150", "151", "152", "158", "159", "188", "131", "132", "155", "156", "186", "185", "133", "153", "189" };
		
		// ÒÆ¶¯
		String[] chars = new String[] { "134", "135", "139", "136", "138", "157", "137", "150", "151", "152", "158", "159", "188" };
		int rInt = rand.nextInt(chars.length);
		return chars[rInt];
	}

	public static String getIp() {
		String s = "192.168.1.";
		Random random = new Random();
		int end = random.nextInt(236);
		return s + end;
	}

}
