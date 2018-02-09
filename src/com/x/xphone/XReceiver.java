package com.x.xphone;

import java.io.FileWriter;
import java.io.IOException;

import com.x.utils.Setting;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.Uri;
import android.os.Environment;
import android.util.Log;
import android.widget.Toast;

public class XReceiver extends BroadcastReceiver {
	final static Setting set=new Setting();
	@Override
	public void onReceive(Context context, Intent intent) {
		if (intent.getAction().equals("com.x.xphone.startgps")) {
			Log.e("TAG", "通过服务启动MockGps");
			// 后边的XXX.class就是要启动的服务
			Intent serviceIntent = new Intent(context, MockGpsService.class);
			context.startService(serviceIntent);
		}
		else {
			if (set.AppInstallMonitor) {
				String pkg = getPackageName(intent);
				writeToFile(pkg);
			}
			//监测app安装
//			Setting set= new Setting();
//			if(set.AppInstallMonitor){
//				String pkg=getPackageName(intent);
//				writeToFile(pkg);
//			}
		}
	}

	public void registerReceiver(XReceiver receiver, IntentFilter filter) {
		// TODO 自动生成的方法存根
		
	}
	
	private static String getPackageName(Intent intent) {
		Uri uri = intent.getData();
		return (uri != null) ? uri.getSchemeSpecificPart() : null;
	}
	
	
	private static boolean writeToFile(String PackageName){
		
		String sddir = Environment.getExternalStorageDirectory().getPath();
		String InstalledPackageFile = sddir + "/.shenqi/InstalledPackage";
		try {
            //打开一个写文件器，构造函数中的第二个参数true表示以追加形式写文件
            FileWriter writer = new FileWriter(InstalledPackageFile, true);
            writer.write(PackageName+"\r\n");
            writer.close();
            return true;
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }
	}
}
