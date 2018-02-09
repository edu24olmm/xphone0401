package com.x.utils;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

import android.app.ActivityManager;
import android.app.ActivityManager.RunningServiceInfo;
import android.content.ComponentName;
import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.database.Cursor;
import android.net.Uri;
import android.os.Environment;
import android.util.Log;

import com.x.xphone.MainActivity;

import de.robv.android.xposed.XC_MethodHook.MethodHookParam;

public class Util {
	public static String timerTaskFlagFile = Environment.getExternalStorageDirectory().getPath() + "/.shenqi/timerTaskFlag.txt";

	public static String GetScriptPackageName(Context context) {
		PackageManager pm = context.getPackageManager();
		List<PackageInfo> pakageinfos = pm.getInstalledPackages(PackageManager.GET_UNINSTALLED_PACKAGES);
		String scriptPackageNameString = "";
		for (PackageInfo pInfo : pakageinfos) {
			// 我所写的小精灵的包名都已supersu结尾
			if (pInfo.packageName.contains("com") && pInfo.packageName.contains("supersu")) {
				scriptPackageNameString = pInfo.packageName;
				break;
			}
		}
		return scriptPackageNameString;
	}

	public static boolean isXposedEnabled() {
		return true;
	}

	// 定时任务
	public static void doTimerTask() {
		Timer timer = new Timer();
		TimerTask task = new TimerTask() {
			// 要做的事情
			@Override
			public void run() {
//				SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmm");
//				Date dateNow = new Date();
//				String dateStrNow = sdf.format(dateNow);

//				try {
//					InputStream instream = new FileInputStream(timerTaskFlagFile);
//					InputStreamReader inputreader = new InputStreamReader(instream);
//					BufferedReader buffreader = new BufferedReader(inputreader);
//					String dateStrOld = buffreader.readLine();
//					instream.close();
//
//					long min = DateUtil.checkBigOrSmal(dateStrNow, dateStrOld);
//					if (min >= 1) {
						ShellUtil.Exec("reboot");
//					}
//				} catch (Exception e) {
//					e.printStackTrace();
//				}
			}
		};
		timer.schedule(task, 300000, 600000);
	}

	public static String copyFromAssets(Context context, String source, String destination) throws IOException {

		// read file from the apk
		InputStream is = context.getAssets().open(source);
		int size = is.available();
		byte[] buffer = new byte[size];
		is.read(buffer);
		is.close();

		// write files in app private storage
		FileOutputStream output = context.openFileOutput(destination, Context.MODE_PRIVATE);
		output.write(buffer);
		output.close();

		Log.d("错误！", "BusyBox无法安装");

		return context.getFileStreamPath(destination).getAbsolutePath();

	}

	public static boolean UninstallMonitorApp() {
		String sddir = Environment.getExternalStorageDirectory().getPath();
		String InstalledPackage = sddir + "/.shenqi/InstalledPackage";
		File file = new File(InstalledPackage);
		Log.d("util", InstalledPackage);
		BufferedReader reader = null;
		try {
			System.out.println("以行为单位读取文件内容，一次读一整行：");
			reader = new BufferedReader(new FileReader(file));
			String tempString = null;
			// 一次读入一行，直到读入null为文件结束
			while ((tempString = reader.readLine()) != null) {
				Log.d("util", "pm uninstall " + tempString);
				if (!tempString.equals(""))
					ShellUtil.Exec("pm uninstall " + tempString);
				Log.d("util", "pm uninstall " + tempString);
				Log.i("Util", "pm uninstall " + tempString);
			}
			reader.close();
			file.delete();
			return true;
		} catch (IOException e) {
			Log.d("util", "出错了：pm uninstall " + e.getMessage());
			if (reader != null) {
				try {
					reader.close();
					file.delete();
				} catch (IOException e1) {
				}
			}
			return false;
		}
	}

	public static void DeleteMonitorAppFile() {
		String sddir = Environment.getExternalStorageDirectory().getPath();
		String InstalledPackage = sddir + "/.shenqi/InstalledPackage";
		File file = new File(InstalledPackage);
		if (file.exists())
			file.delete();
	}

	public static void StopeScript(Context context) {
		ActivityManager activityManager = (ActivityManager) context.getSystemService(Context.ACTIVITY_SERVICE);
		List<RunningServiceInfo> services = activityManager.getRunningServices(200);

		Iterator<RunningServiceInfo> l = services.iterator();
		while (l.hasNext()) {

			RunningServiceInfo si = (RunningServiceInfo) l.next();
			if (si.process.contains("xiaomi") || si.process.contains("com.android") || si.process.contains("miui") || si.process.contains("system")) {

			} else if (si.process.contains("cyjh") || si.process.contains("cffk")) {
				ComponentName serviceCMP = si.service;
				ShellUtil.Exec(" am force-stop " + serviceCMP.getPackageName());
			}
		}
	}

	public static String getPath(Context context, Uri uri) {

		if ("content".equalsIgnoreCase(uri.getScheme())) {
			String[] projection = { "_data" };
			Cursor cursor = null;

			try {
				cursor = context.getContentResolver().query(uri, projection, null, null, null);
				int column_index = cursor.getColumnIndexOrThrow("_data");
				if (cursor.moveToFirst()) {
					return cursor.getString(column_index);
				}
			} catch (Exception e) {
				// Eat it
			}
		}

		else if ("file".equalsIgnoreCase(uri.getScheme())) {
			return uri.getPath();
		}

		return null;
	}

	public static void XLog(MethodHookParam param) {
		// XposedBridge.log("HOOK:"+DateUtil.Now()+"函数："+param.thisObject.getClass().getName()+"->"+param.method.getName());
	}

	public static void XLog(MethodHookParam param, String info) {
		// XposedBridge.log("HOOK:"+DateUtil.Now()+"函数："+param.thisObject.getClass().getName()+"->"+param.method.getName()+"："+info);
	}

}
