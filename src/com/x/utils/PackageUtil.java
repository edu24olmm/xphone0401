
package com.x.utils;

import java.util.Collections;
import java.util.List;

import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;


public class PackageUtil
{
	public static int Get_SDK_Int(){
		return android.os.Build.VERSION.SDK_INT;
	}
	
	
	public static List<ResolveInfo> getAllPagckage(Context context)
	{
		PackageManager pm = context.getPackageManager();

		Intent mainIntent = new Intent(Intent.ACTION_MAIN, null);
		mainIntent.addCategory(Intent.CATEGORY_LAUNCHER);
		
		List<ResolveInfo> resolveInfoList = pm.queryIntentActivities(
				mainIntent, PackageManager.GET_GIDS);
		
		Collections.sort(resolveInfoList,
				new ResolveInfo.DisplayNameComparator(pm));

		return resolveInfoList;
	}
}
