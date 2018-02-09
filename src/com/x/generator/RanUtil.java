package com.x.generator;

import java.util.Random;

public class RanUtil {

	
	public static String getRanStr(int length) {
		String chars = "";
		String priChar = ""; // 标记上一个随机生成的字符
		String nextChar ="";
		for (int i = 0; i < length; i++) {
			do{
				nextChar = createRandomChar();
			}while (priChar.equals(nextChar));
			priChar = nextChar;
			chars += priChar;
		}
		return chars;
	}

	
	private static String createRandomChar() {
		String[] chars = new String[] { "A", "B", "C", "D", "E", "F", "0", "1",
				"2", "3", "4", "5", "6", "7", "8", "9", };
		Random rand = new Random();
		int rInt = rand.nextInt(chars.length);
		return chars[rInt];
	}
	
	
	public static String getRanNub(int length) {

		String[] Num = new String[] { "0", "1", "2", "3", "4", "5", "6", "7",
				"8", "9" };
		Random random = new Random();
		
		String s = "";
		for (int j = 0; j < length; j++) {
			int rand = random.nextInt(Num.length);
			s += Num[rand];
		}
		return s;
	}
}
