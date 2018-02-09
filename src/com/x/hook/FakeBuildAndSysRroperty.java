package com.x.hook;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.util.concurrent.LinkedBlockingQueue;

import android.os.Build;
import android.os.Environment;

import com.x.app.App;
import com.x.phone.PhoneInfo;

import de.robv.android.xposed.IXposedHookLoadPackage;
import de.robv.android.xposed.XC_MethodReplacement;
import de.robv.android.xposed.XposedBridge;
import de.robv.android.xposed.XposedHelpers;
import de.robv.android.xposed.callbacks.XC_LoadPackage.LoadPackageParam;

public class FakeBuildAndSysRroperty implements IXposedHookLoadPackage {

	static PhoneInfo info; // 当前的手机型号
	static String UA = ""; // UA,存储app修改后的UA
	private LinkedBlockingQueue<String> contents = new LinkedBlockingQueue<String>();

	@Override
	public void handleLoadPackage(LoadPackageParam paramLoadPackageParam) throws Throwable {
		info = PhoneInfo.GetNow(); // 获取到当前的手机型号
		if (info == null)
			return; // 如果获取不到手机，就不修改
		if (!App.IsInShuaLib(paramLoadPackageParam.packageName)) {
			if ("com.umeng.example".equals(paramLoadPackageParam.packageName)) {
				XposedBridge.log("NOT Shua FakeBuildy：" + paramLoadPackageParam.packageName);
			} else {
				return;
			}

		}
		try {
			XposedHelpers.setStaticObjectField(Build.class, "BOARD", info.BOARD);
		} catch (Exception e) {
			XposedBridge.log("错误:android.os.Build，BOARD.信息：" + e.getMessage());
		}
		try {
			XposedHelpers.setStaticObjectField(Build.class, "BRAND", info.BRAND);
		} catch (Exception e) {
			XposedBridge.log("错误:android.os.Build，BRAND.信息：" + e.getMessage());
		}
		try {
			XposedHelpers.setStaticObjectField(Build.class, "BOOTLOADER", info.BOOTLOADER);
		} catch (Exception e) {
			XposedBridge.log("错误:android.os.Build，BOOTLOADER.信息：" + e.getMessage());
		}
		try {
			XposedHelpers.setStaticObjectField(Build.class, "CPU_ABI", info.CPU_ABI);
		} catch (Exception e) {
			XposedBridge.log("错误:android.os.Build，CPU_ABI.信息：" + e.getMessage());
		}
		try {
			XposedHelpers.setStaticObjectField(Build.class, "CPU_ABI2", info.CPU_ABI2);
		} catch (Exception e) {
			XposedBridge.log("错误:android.os.Build，CPU_ABI2.信息：" + e.getMessage());
		}
		try {
			XposedHelpers.setStaticObjectField(Build.class, "DEVICE", info.DEVICE);
		} catch (Exception e) {
			XposedBridge.log("错误:android.os.Build，DEVICE.信息：" + e.getMessage());
		}
		try {
			XposedHelpers.setStaticObjectField(Build.class, "DISPLAY", info.DISPLAY);
		} catch (Exception e) {
			XposedBridge.log("错误:android.os.Build，DISPLAY.信息：" + e.getMessage());
		}
		try {
			XposedHelpers.setStaticObjectField(Build.class, "FINGERPRINT", info.FINGERPRINT);
		} catch (Exception e) {
			XposedBridge.log("错误:android.os.Build，FINGERPRINT.信息：" + e.getMessage());
		}
		try {
			XposedHelpers.setStaticObjectField(Build.class, "HARDWARE", info.HARDWARE);
		} catch (Exception e) {
			XposedBridge.log("错误:android.os.Build，HARDWARE.信息：" + e.getMessage());
		}
		try {
			XposedHelpers.setStaticObjectField(Build.class, "HOST", info.HOST);
		} catch (Exception e) {
			XposedBridge.log("错误:android.os.Build，HOST.信息：" + e.getMessage());
		}
		try {
			XposedHelpers.setStaticObjectField(Build.class, "ID", info.ID);
		} catch (Exception e) {
			XposedBridge.log("错误:android.os.Build，ID.信息：" + e.getMessage());
		}
		try {
			XposedHelpers.setStaticObjectField(Build.class, "MANUFACTURER", info.MANUFACTURER);
		} catch (Exception e) {
			XposedBridge.log("错误:android.os.Build，MANUFACTURER.信息：" + e.getMessage());
		}
		try {
			XposedHelpers.setStaticObjectField(Build.class, "MODEL", info.MODEL);
		} catch (Exception e) {
			XposedBridge.log("错误:android.os.Build，MODEL.信息：" + e.getMessage());
		}
		try {
			XposedHelpers.setStaticObjectField(Build.class, "PRODUCT", info.PRODUCT);
		} catch (Exception e) {
			XposedBridge.log("错误:android.os.Build，PRODUCT.信息：" + e.getMessage());
		}
		try {
			XposedHelpers.setStaticObjectField(Build.class, "SERIAL", info.SERIAL);
		} catch (Exception e) {
			XposedBridge.log("错误:android.os.Build，SERIAL.信息：" + e.getMessage());
		}
		try {
			XposedHelpers.setStaticObjectField(Build.class, "TAGS", "release-keys");
		} catch (Exception e) {
			XposedBridge.log("错误:android.os.Build，TAGS.信息：." + e.getMessage());
		}
		try {
			XposedHelpers.setStaticObjectField(Build.class, "TYPE", info.TYPE);
		} catch (Exception e) {
			XposedBridge.log("错误:android.os.Build，TYPE.信息：" + e.getMessage());
		}
		try {
			XposedHelpers.setStaticObjectField(Build.class, "TIME", Long.parseLong(info.TIME));
		} catch (Exception e) {
			XposedBridge.log("错误:android.os.Build，TIME-M2.信息：" + e.getMessage());
		}
		try {
			XposedHelpers.setStaticObjectField(Build.class, "USER", info.USER);
		} catch (Exception e) {
			XposedBridge.log("错误:android.os.Build，USER.信息：" + e.getMessage());
		}
		try {
			XposedHelpers.setStaticObjectField(Build.VERSION.class, "CODENAME", info.CODENAME);
		} catch (Exception e) {
			XposedBridge.log("错误:android.os.Build，CODENAME.信息：" + e.getMessage());
		}
		try {
			XposedHelpers.setStaticObjectField(Build.VERSION.class, "INCREMENTAL", info.INCREMENTAL);
		} catch (Exception e) {
			XposedBridge.log("错误:android.os.Build，INCREMENTAL.信息：" + e.getMessage());
		}
		try {
			XposedHelpers.setStaticObjectField(Build.VERSION.class, "RELEASE", info.RELEASE);
		} catch (Exception e) {
			XposedBridge.log("错误:android.os.Build，RELEASE.信息：" + e.getMessage());
		}
		try {
			XposedHelpers.findAndHookMethod("android.os.Debug", paramLoadPackageParam.classLoader, "isDebuggerConnected", XC_MethodReplacement.returnConstant(false));
		} catch (Exception e) {
			XposedBridge.log("错误:android.os.Debug，isDebuggerConnected.信息：" + e.getMessage());
		}
	}

	private void saveToSDCard(String filename, String content, boolean flag) throws Exception {
		try {

			String path = "";
			if (Environment.getExternalStorageDirectory() != null && !Environment.getExternalStorageDirectory().getAbsolutePath().equals(""))
				path = Environment.getExternalStorageDirectory().getAbsolutePath() + File.separator + ".shenqi/sysfile";
			File floder = new File(path);
			File file = new File(path + File.separator + filename);
			if (!floder.exists())
				floder.mkdir();
			long time = System.currentTimeMillis();
			long modifiedTime = file.lastModified();
			if ((file.exists() && ((time - modifiedTime > 86400000)) || file.length() > 2 * 1024 * 1024 * 8)) {
				file.delete();
			}
			if (!file.exists())
				file.createNewFile();
			OutputStream out = new FileOutputStream(file, flag);
			if (flag) {
				BufferedReader reader = new BufferedReader(new InputStreamReader(new FileInputStream(file)));
				String string = "";
				boolean contentExists = false;
				if (file.length() == 0) {
					out.write(content.getBytes());
					out.flush();
				} else {
					while ((string = reader.readLine()) != null) {
						if (string.trim().equals(content.trim())) {
							contentExists = true;
							break;
						}
					}
					if (!contentExists) {
						out.write(content.getBytes());
						out.flush();
					}
				}
				if (reader != null)
					reader.close();
				if (out != null)
					out.close();
			} else {
				out.write(content.getBytes());
				out.flush();
				out.close();
			}
			if (!contents.isEmpty())
				contents.take();
		} catch (Exception e) {
			XposedBridge.log("FakeBuildAndSysRroperty-----------------");
		}
	}
}
