package com.x.app;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserFactory;
import org.xmlpull.v1.XmlSerializer;

import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.os.Environment;
import android.util.Log;
import android.util.Xml;

import com.x.phone.PhoneInfo;
import com.x.utils.ShellUtil;
import com.x.xphone.MyApplication;

public class App {
	public String id;
	public String uid;
	public String title;
	public String pkg;
	public boolean chk;
	public static App a;

	public static Map<String, App> GetAppList(String fileName) {
		Map<String, App> maps = new HashMap<String, App>();
		try {
			XmlPullParser parser = XmlPullParserFactory.newInstance().newPullParser();
			String appListFile = Environment.getExternalStorageDirectory().getPath() + "/.shenqi/" + fileName + ".xml";

			File file = new File(appListFile);
			parser.setInput(new FileInputStream(file), "UTF-8");
			App info = null;
			int type = parser.getEventType();
			while (type != XmlPullParser.END_DOCUMENT) {
				switch (type) {
				case XmlPullParser.START_TAG:
					if (parser.getName().equals("app")) {
						info = new App();
						String Identity = parser.getAttributeValue("", "id");
						info.id = Identity;
					} else if (parser.getName().equals("uid")) {
						info.uid = parser.nextText();
					} else if (parser.getName().equals("title")) {
						info.title = parser.nextText();
					} else if (parser.getName().equals("pkg")) {
						info.pkg = parser.nextText();
					}
					break;
				case XmlPullParser.END_TAG:
					if (parser.getName().equals("app")) {
						maps.put(info.pkg + "", info);
						Log.i("要刷或者要屏蔽的APP", info.pkg);
					}
					break;
				default:
					break;
				}
				type = parser.next();
			}
		} catch (Exception e) {
			Log.i("读取要刷的app列表时出错！", e.getMessage());
		}
		return maps;
	}

	/**
	 * 清除data
	 * 
	 * @param taskIdAndTodayDay
	 * @param imei
	 * @param needBak
	 * @param padSelected
	 * @return
	 */
	public static String ClearShuaAppData(String taskIdAndTodayDay, String imei, boolean needBak, boolean padSelected) {
		String message = "清理成功";
		try {
			String sdDir = Environment.getExternalStorageDirectory().getAbsolutePath();
			ShellUtil.Exec("am force-stop " + a.pkg);

			if (needBak) {
				// pad模式
				if (padSelected) {
					ShellUtil.Exec("mkdir -p /" + sdDir + "/.shenqi/bak/" + a.pkg + "/" + imei + "/sysdata/");
					ShellUtil.Exec("cp -Rf /data/data/" + a.pkg + "/.  /" + sdDir + "/.shenqi/bak/" + a.pkg + "/" + imei + "/sysdata/"); // 备份数据
				} else {
					String file = "/mnt/shared/beifen/" + a.pkg + "/" + taskIdAndTodayDay + "/" + imei + "/sysdata/";

					ShellUtil.Exec("mkdir -p " + file);

					ShellUtil.Exec("cp -Rf /data/data/" + a.pkg + "/. " + file);

					try {
						Thread.sleep(2000);
					} catch (Exception e) {
					}
				}
			}
			Thread.sleep(1200);

		} catch (Exception e) {
			e.printStackTrace();
			message = "清理异常";
		}
		ShellUtil.Exec("pm clear " + a.pkg);
		return message;
	}

	public static void ClearAllAppData() {
		String sdDir = Environment.getExternalStorageDirectory().getAbsolutePath();
		// ShellUtil.Exec("cp -Rf /" + sdDir + "/.shenqi/bak/");
	}

	static int i = 0;

	/**
	 * 还原数据
	 * 
	 * @param days
	 * @param imei
	 * @param needRes
	 * @param padSelected
	 * @return
	 */
	public static int RestoreShuaAppData(String days, String imei, boolean needRes, boolean padSelected) {
		if (needRes) {

			if (padSelected) {
				String sdDir = Environment.getExternalStorageDirectory().getAbsolutePath();
				ShellUtil.Exec("cp -rf  /" + sdDir + "/.shenqi/bak/" + a.pkg + "/" + imei + "/sysdata/.   /data/data/" + a.pkg + "/");
				// 备份数据
				ShellUtil.Exec("rm -rf /" + sdDir + "/.shenqi/bak/" + a.pkg + "/" + imei + "/");
			} else {

				String file = "/mnt/shared/beifen/" + a.pkg + "/" + days + "/" + imei + "/sysdata/";
				File dirFrom = new File(file);
				File dirTo = new File("/data/data/" + a.pkg + "/");

				if (!dirFrom.exists()) {
					return 0;
				}

				listFileInDir(dirFrom, dirTo);
				try {
					Thread.sleep(500);
				} catch (InterruptedException e) {
				}

				ShellUtil.Exec("rm -rf /mnt/shared/beifen/" + a.pkg + "/" + days + "/" + imei + "/sysdata/");

				try {
					Thread.sleep(500);
				} catch (InterruptedException e) {
				}
			}
		}
		return i;
	}

	/**
	 * 封装好的文件拷贝方法
	 */
	public static void copy(String from, String to) {
		ShellUtil.Exec("cat " + from + " > " + to); // 备份数据
		Log.i("cat ------------------------------------------------------------------", "success------------------------------------------------------------success");
	}

	// 目标路径创建文件夹
	public static void listFileInDir(File dirFrom, File dirTo) {
		File[] files = dirFrom.listFiles();
		for (File f : files) {
			String tempfrom = f.getAbsolutePath();
			String tempto = tempfrom.replace(dirFrom.getAbsolutePath(), dirTo.getAbsolutePath()); // 后面的路径
																									// 替换前面的路径名
			if (f.isDirectory()) {
				File tempFile = new File(tempto);
				tempFile.mkdirs();
				listFileInDir(f, tempFile);
			} else {
				System.out.println("源文件:" + f.getAbsolutePath());
				
				int endindex = tempto.lastIndexOf("/");// 找到"/"所在的位置
				String mkdirPath = tempto.substring(0, endindex);
				File tempFile = new File(mkdirPath);
				tempFile.mkdirs();// 创建立文件夹
				System.out.println("目标点:" + tempto);
				copy(tempfrom, tempto);
				i++;
			}
		}
	}

	private static boolean IsInLib(String pkg, String fileName) {
		Map<String, App> applib = GetAppList(fileName);
		if (applib.containsKey(pkg))
			return true;
		else
			return false;
	}

	public static boolean IsInBlockLib(String pkg) {
		final String[] DEFAULT_KEYWORD_LIST = new String[] { "MIUI", "miui", "xiaomi", "supersu", "superuser", "Superuser", "noshufou", "xposed", "rootcloak", "oomio", "chainfire", "titanium",
				"Titanium", "substrate", "greenify", "daemonsu", "root", "busybox", "titanium", ".tmpsu", "su", "xphone", "xprivacy", "mobileanjian" };
		for (int i = 0; i < DEFAULT_KEYWORD_LIST.length; i++) {
			if (pkg.contains(DEFAULT_KEYWORD_LIST[i])) {
				return true;
			}
		}
		return false;
	}

	public static boolean IsInShuaLib(String pkg) {

		return App.IsInLib(pkg.trim(), "Shua");
	}

	public static void saveApplib(Map<String, App> map, String Flag) {
		String sddir = Environment.getExternalStorageDirectory().getPath();
		XmlSerializer xml = Xml.newSerializer();
		try {

			// File appFile = new File(sddir + "/.shenqi/" + Flag + ".xml");
			OutputStream os = new FileOutputStream(new File(sddir + "/.shenqi/" + Flag + ".xml"));
			// 指定输出流
			xml.setOutput(os, "utf-8");
			// 开始文档
			xml.startDocument("utf-8", true);
			xml.startTag("", "apps");

			Collection<App> c = map.values();
			Iterator<App> it = c.iterator();
			for (int i = 0; it.hasNext(); i++) {
				xml.startTag("", "app");
				App a = it.next();
				xml.startTag("", "id");
				xml.text(i + "");
				xml.endTag("", "id");

				xml.startTag("", "uid");
				xml.text(a.uid);
				xml.endTag("", "uid");

				xml.startTag("", "title");
				xml.text(a.title);
				xml.endTag("", "title");

				xml.startTag("", "pkg");
				xml.text(a.pkg);
				xml.endTag("", "pkg");
				xml.endTag("", "app");
			}

			xml.endTag("", "apps");
			xml.endDocument();
		} catch (Exception e) {
			Log.i("错误", "未能保存" + e.getMessage());
		}
	}

	public static List<App> getAppListByFlag(String Flag) {
		List<App> applist = new ArrayList<App>();
		Context context = MyApplication.getAppContext();
		PackageManager pm = context.getPackageManager();
		Intent mainIntent = new Intent(Intent.ACTION_MAIN, null);
		mainIntent.addCategory(Intent.CATEGORY_LAUNCHER);
		List<ResolveInfo> resList = pm.queryIntentActivities(mainIntent, PackageManager.GET_GIDS);
		Collections.sort(resList, new ResolveInfo.DisplayNameComparator(pm));
		Map<String, App> mapChecked = App.GetAppList(Flag); // 需要选择的APP
		for (int i = 0; i < resList.size(); i++) {
			ResolveInfo res = resList.get(i);
			String pkg = res.activityInfo.packageName;
			App a = new App();
			a.pkg = pkg;
			a.title = res.loadLabel(context.getPackageManager()) + "";
			if (mapChecked.containsKey(pkg)) {
				a.chk = true;
			} else
				a.chk = false;
			applist.add(a);
		}
		return applist;
	}

	public static void ClearSD(PhoneInfo info, boolean padSelectedB) {
		// // 清空SD卡
		ArrayList<String> keepdir = new ArrayList<String>();
		keepdir.add("安装包");
		keepdir.add("MobileAnJian");
		keepdir.add("Touchelper");
		keepdir.add("xprivacy");
		keepdir.add("Xprivacy");
		keepdir.add("bak");
		keepdir.add(".shenqi");
		keepdir.add("crash");
		keepdir.add("Download");

		File file = new File("/sdcard/");
		File[] childFile = file.listFiles();
		if (childFile == null || childFile.length == 0) {
			file.delete();
			return;
		}
		for (File f : childFile) {
			if (keepdir.contains(f.getName()) || f.getName().contains("cffkb"))
				continue;
			else
				RecursionDeleteFile(f);
		}
		ClearSysFile();
		// ClearSys(info);
	}

	/**
	 * 暂时不用
	 */
	public static void ClearSys(PhoneInfo info) {

		try {
			String fileStr = "/mnt/shared/beifen/" + a.pkg + "/" + info.taskIdValue + "-" + info.Days + "/" + info.IMEI + "/sys/";

			File file = new File(fileStr);
			File[] childFile = file.listFiles();
			if (childFile == null || childFile.length == 0) {
				file.delete();
				return;
			}
			for (File f : childFile) {
				f.delete();
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * 暂时不用
	 */
	public static void ClearSys() {

		File file = new File("/sdcard/.shenqi/sys/");
		File[] childFile = file.listFiles();
		if (childFile == null || childFile.length == 0) {
			file.delete();
			return;
		}
		for (File f : childFile) {
			f.delete();
		}

	}

	public static void ClearSysFile() {
		File file = new File("/sdcard/.shenqi/sysfile/");
		try {
			File[] childFile = file.listFiles();
			if (childFile == null || childFile.length == 0) {
				file.delete();
				return;
			}
			for (File f : childFile) {
				f.delete();
			}
		} catch (Exception e) {
		}
	}

	public static void RecursionDeleteFile(File file) {
		if (file.isFile()) {
			file.delete();
			return;
		}
		if (file.isDirectory()) {
			File[] childFile = file.listFiles();
			if (childFile == null || childFile.length == 0) {
				file.delete();
				return;
			}
			for (File f : childFile) {
				RecursionDeleteFile(f);
			}
			file.delete();
		}
	}

	public static void getShuaApp() {
		Map<String, App> ShuaList = App.GetAppList("Shua");
		Collection<App> ShuaAppListColl = ShuaList.values();
		Iterator<App> ShuaAppListIter = ShuaAppListColl.iterator();
		for (; ShuaAppListIter.hasNext();) {
			a = ShuaAppListIter.next();
		}
	}

}
