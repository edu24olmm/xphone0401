package com.x.xphone;

import java.util.Collection;
import java.util.Iterator;
import java.util.Map;

import com.x.app.App;
import com.x.utils.Setting;
import com.x.utils.ShellUtil;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.media.AudioManager;
import android.os.Bundle;
import android.os.Message;
import android.util.Log;
import android.widget.Toast;

public class BootBroadcastActivity extends Activity {
	Map<String, App> BatList;
	Setting set;

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		Toast.makeText(getApplicationContext(), "开机自动启动成功!!!",
				Toast.LENGTH_SHORT).show();

		BatList = App.GetAppList("Bat");
		// 将要刷的APP从列表中显示出来
		Collection<App> BatAppListColl = BatList.values();
		Iterator<App> BatAppListIter = BatAppListColl.iterator();

		int num = 0;
		String packageName = "";
		for (int i = 1; BatAppListIter.hasNext(); i++) {
			App a = BatAppListIter.next();
			num++;
			packageName = a.pkg;
		}

		if (num > 1) {
			Toast.makeText(getApplicationContext(), "只能选择一个要刷的按键精灵脚本",
					Toast.LENGTH_SHORT).show();
			return;
		}

		PackageManager packageManager = BootBroadcastActivity.this
				.getPackageManager();
		Intent intent = new Intent();
		try {
			intent = packageManager.getLaunchIntentForPackage(packageName);
		} catch (Exception e) {
			Log.i("packageManager", e.toString());
		}
		startActivity(intent);
		
		System.out.println("_++++++++++++++++++++++_+_+_+_            _+_+_+_+_+                /*");

		try {
			Toast.makeText(getApplicationContext(), "我刚起来，等5秒再调用按键启动脚本!!!",
					Toast.LENGTH_SHORT).show();
			Thread.sleep(5000);
		} catch (InterruptedException e) {
		}

		set = new Setting();

		ShellUtil.Exec(ShellUtil.baseTapCommon + "206 603");

		try {
			Thread.sleep(4000);
		} catch (InterruptedException e) {
		}

		ShellUtil.Exec(ShellUtil.baseTapCommon + "452 206");

		try {
			Thread.sleep(4000);
		} catch (InterruptedException e) {
		}

		ShellUtil.Exec(ShellUtil.baseTapCommon + "258 204");

		try {
			Thread.sleep(4000);
		} catch (InterruptedException e) {
		}
	}

}
