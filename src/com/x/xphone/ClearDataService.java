
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
			//׼���������20����������������
			Log.i("��������", "��������ʮ�������");
//			PhoneInfo.ClearDB(ClearDataService.this);
		}
		return super.onStartCommand(intent, flags, startId);
	}

	@Override
	public void onDestroy() {
	}

	@Override
	public IBinder onBind(Intent intent) {
		// TODO �Զ����ɵķ������
		return null;
	}

}
