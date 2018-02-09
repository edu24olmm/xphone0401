package com.x.utils;

import android.annotation.SuppressLint;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

@SuppressLint("SimpleDateFormat")
public class DateUtil {

	public static int DaysBetween(java.util.Date infoDate, java.util.Date date) {
		Calendar cal = Calendar.getInstance();
		cal.setTime(infoDate);
		long time1 = cal.getTimeInMillis();
		cal.setTime(date);
		long time2 = cal.getTimeInMillis();
		long between_days = (time2 - time1) / (1000 * 3600 * 24);

		return Integer.parseInt(String.valueOf(between_days));
	}

	/*
	 * �������ٷ���
	 */
	public static long checkBigOrSmal(String newStr, String oldStr) {
		long nd = 1000 * 24 * 60 * 60;// һ��ĺ�����
		long nh = 1000 * 60 * 60;// һСʱ�ĺ�����
		long nm = 1000 * 60;// һ���ӵĺ�����
		SimpleDateFormat sdf2 = new SimpleDateFormat("yyyyMMddHHmm");
		SimpleDateFormat sdf3 = new SimpleDateFormat("yyyyMMddHHmm");
		long diff = 0;
		try {
			diff = sdf3.parse(newStr).getTime() - sdf2.parse(oldStr).getTime();
		} catch (ParseException e) {
		}
		long min = diff % nd % nh / nm;// �������ٷ���
		return min;
	}

	public static String tomorrow() {
		SimpleDateFormat format = new SimpleDateFormat("yyyyMMdd");
		Date today = new Date();
		Calendar fromCal = Calendar.getInstance();
		fromCal.setTime(today);
		fromCal.add(Calendar.DATE, 1);
		return format.format(fromCal.getTime());
	}

	public static String today() {
		SimpleDateFormat format = new SimpleDateFormat("yyyyMMdd");
		String today = format.format(new Date());
		return today;
	}

	public static String yesterday() {
		SimpleDateFormat format = new SimpleDateFormat("yyyyMMdd");
		Date today = new Date();
		Calendar fromCal = Calendar.getInstance();
		fromCal.setTime(today);
		fromCal.add(Calendar.DATE, -1);
		return format.format(fromCal.getTime());
	}

	public static int Days() {
		SimpleDateFormat format = new SimpleDateFormat("yyyyMMdd");
		java.util.Date startday = new Date();
		try {
			startday = format.parse("20150101");
		} catch (Exception e) {
		}
		java.util.Date today = new Date();
		return DaysBetween(startday, today); // ����ʱ+1
	}

	public static String Now() {
		Date now = new Date();
		SimpleDateFormat dateFormat = new SimpleDateFormat("HH:mm:ss");// ���Է�����޸����ڸ�ʽ
		String nowStr = dateFormat.format(now);
		return nowStr;

	}
}
