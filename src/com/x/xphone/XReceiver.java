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
			Log.e("TAG", "ͨ����������MockGps");
			// ��ߵ�XXX.class����Ҫ�����ķ���
			Intent serviceIntent = new Intent(context, MockGpsService.class);
			context.startService(serviceIntent);
		}
		else {
			if (set.AppInstallMonitor) {
				String pkg = getPackageName(intent);
				writeToFile(pkg);
			}
			//���app��װ
//			Setting set= new Setting();
//			if(set.AppInstallMonitor){
//				String pkg=getPackageName(intent);
//				writeToFile(pkg);
//			}
		}
	}

	public void registerReceiver(XReceiver receiver, IntentFilter filter) {
		// TODO �Զ����ɵķ������
		
	}
	
	private static String getPackageName(Intent intent) {
		Uri uri = intent.getData();
		return (uri != null) ? uri.getSchemeSpecificPart() : null;
	}
	
	
	private static boolean writeToFile(String PackageName){
		
		String sddir = Environment.getExternalStorageDirectory().getPath();
		String InstalledPackageFile = sddir + "/.shenqi/InstalledPackage";
		try {
            //��һ��д�ļ��������캯���еĵڶ�������true��ʾ��׷����ʽд�ļ�
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
