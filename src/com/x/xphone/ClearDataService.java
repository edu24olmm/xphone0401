
package com.x.xphone;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.util.Log;


public class ClearDataService extends Service {

	@Override
	public void onCreate() {

	}

	@Override
	public int onStartCommand(Intent intent, int flags, int startId) {
		if (intent != null) {
			//准备清楚超过20天的留存和新增数据
			Log.i("数据清理", "清理超过二十天的数据");
//			PhoneInfo.ClearDB(ClearDataService.this);
		}
		return super.onStartCommand(intent, flags, startId);
	}

	@Override
	public void onDestroy() {
	}

	@Override
	public IBinder onBind(Intent intent) {
		// TODO 自动生成的方法存根
		return null;
	}

}
