package com.x.generator;

import java.util.Random;

import android.util.Log;

import com.x.utils.Setting;

public class KeepDaysUtil {
	
	public static int getKeepDays() {
		int keep = 0; // 默认不留存
		Random rand = new Random();
		int ii = rand.nextInt(100);
		Setting set = new Setting();
		Log.i("xphone", ii + "");
		// 根据比例设置留存天数 ,从设置中读取
		if (ii < set.Keep2)
			keep = 1;
		if (ii < set.Keep3)
			keep = 2;
		if (ii < set.Keep4)
			keep = 3;
		if (ii < set.Keep5)
			keep = 4;
		if (ii < set.Keep6)
			keep = 5;
		if (ii < set.Keep7)
			keep = 6;
		if (ii < set.Keep8)
			keep = 7;
		if (ii < set.Keep9)
			keep = 8;
		if (ii < set.Keep10)
			keep = 9;
		if (ii < set.Keep11)
			keep = 10;
		if (ii < set.Keep12)
			keep = 11;
		if (ii < set.Keep13)
			keep = 12;
		if (ii < set.Keep14)
			keep = 13;
		if (ii < set.Keep15)
			keep = 14;
		return keep;
	}
}
