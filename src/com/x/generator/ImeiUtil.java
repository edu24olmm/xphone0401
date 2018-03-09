package com.x.generator;

import android.util.Log;

import java.util.Random;

public class ImeiUtil {

	

	public static Random random = new Random();

	public static String Nokia[] = new String[] { "40",// 北京
			"60"// 东莞
	};

	public static String MOTO[] = new String[] { "47" // 香港
			, "80", "81", "82", "83", "84", "85"// 大陆
	};

	public static String Sony[] = new String[] { "61",// 香港
			"62",// 北京
			"63",// 南京
	};

	public static String Siemens[] = new String[] { "37", "38", "39"// 上海
	};

	public static String Samsung[] = new String[] { "89", "90", "92", // 韩国
			"08"// 天津
	};

	public static void main(String[] args) {
		System.out.println(CreateIMEI());
	}


	// 创建IMEI最后一位
	public static String CreateIMEI() {

		String imei_1_1= "86";
		String imei_1_6 = createRandomNumber(4);
		String imei_7_8 = create7_8();
		String imei_9_14 = createRandomNumber(6);

		String imeiString = imei_1_1+imei_1_6 + imei_7_8 + imei_9_14;

		Log.i("qi", imeiString.length() == 14 ? "" : imeiString);
		// String imeiString="35566778898256";//前14位
		char[] imeiChar = imeiString.toCharArray();
		int resultInt = 0;
		for (int i = 0; i < imeiChar.length; i++) {
			int a = Integer.parseInt(String.valueOf(imeiChar[i]));
			i++;
			
			final int temp = Integer.parseInt(String.valueOf(imeiChar[i])) * 2;
			final int b = temp < 10 ? temp : temp - 9;
			resultInt += a + b;
		}
		resultInt %= 10;
		resultInt = resultInt == 0 ? 0 : 10 - resultInt;
		return imeiString + resultInt;
	}

	private static String create7_8() {
		int index;
		switch (random.nextInt(5)) {
		case 0:// Nokia
			index = random.nextInt(2);
			return Nokia[index];
		case 1:// MOTO
			index = random.nextInt(7);
			return MOTO[index];
		case 2: // Sony
			index = random.nextInt(3);
			return Sony[index];
		case 3:// Siemens
			index = random.nextInt(3);
			return Siemens[index];
		case 4:// Samsung
			index = random.nextInt(4);
			return Samsung[index];
		}
		return null;
	}

	public static String createRandomNumber(int index) {

		String[] Num = new String[] { "0", "1", "2", "3", "4", "5", "6", "7",
				"8", "9" };
		Random random = new Random();		
		String s = "";
		for (int j = 0; j < index; j++) {
			int rand = random.nextInt(Num.length);
			s += Num[rand];
		}
		return s;
	}

}
