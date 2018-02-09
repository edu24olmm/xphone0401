
package com.x.xphone;

import com.x.app.App;
import com.x.utils.LocationUtil;

import android.annotation.SuppressLint;
import android.app.Notification;
import android.app.PendingIntent;
import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.location.LocationManager;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.IBinder;
import android.util.Log;

@SuppressLint("NewApi") public class MockGpsService extends Service {

	LocationManager locationManager;
	private Handler mHandler; 
	int delaySec=2000;
	@Override
	public void onCreate() {
		try {
			locationManager = (LocationManager) getApplicationContext()
					.getSystemService(Context.LOCATION_SERVICE);
			if (locationManager.getProvider("mockGps") == null)
				locationManager.addTestProvider("mockGps", false, false, false,
						false, true, true, true, 0, 5);
			locationManager.setTestProviderEnabled("mockGps", true);
			
			//����һ��Handler
			HandlerThread thread = new HandlerThread("MyHandlerThread"); 
			thread.start();//����һ��HandlerThread�������� 
			mHandler = new Handler(thread.getLooper());//ʹ��HandlerThread��looper���󴴽�Handler�����ʹ��Ĭ�ϵĹ��췽�������п�������UI�߳� 
			mHandler.post(sendGpsLocation);//���߳�post��Handler�� 
			
			//����Ϊ��ֹͣ
			Intent i = new Intent(this,MainActivity.class);
            //ע��Intent��flag���ã�FLAG_ACTIVITY_CLEAR_TOP: ���activity���ڵ�ǰ���������У�����ǰ�˵�activity���ᱻ�رգ����ͳ�����ǰ�˵�activity��FLAG_ACTIVITY_SINGLE_TOP: ���activity�Ѿ�����ǰ�����У�����Ҫ�ټ��ء�����������flag��������һ����Ψһ��һ��activity��������棩��������ǰ�ˡ�
            i.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_SINGLE_TOP);
            PendingIntent pi = PendingIntent.getActivity(this, 0, i, 0);           
            Notification myNotify = new Notification.Builder(this) 
                                   .setSmallIcon(R.drawable.ic_launcher) 
                                   .setContentTitle("xphone") 
                                   .setContentText("xGps�Ѿ�����")
                                    .setContentIntent(pi) 
                                   .build();

            myNotify.flags |= Notification.FLAG_NO_CLEAR;
            this.startForeground(1339,myNotify);			
		} catch (Exception e) {
			Log.i("xphone", e.getMessage());
		}
	}

	@Override
	public int onStartCommand(Intent intent, int flags, int startId) {
//		Toast.makeText(getBaseContext(), "MockGPS�Ѿ�������", Toast.LENGTH_LONG).show();
		return super.onStartCommand(intent, flags, startId);
	}

	@Override
	public void onDestroy() {
		//�����߳� 
		mHandler.removeCallbacks(sendGpsLocation); 
		super.onDestroy();
	}

	@Override
	public IBinder onBind(Intent intent) {
		return null;
	}

	Runnable sendGpsLocation = new Runnable() {
		@Override
		public void run() {
			// ----------ģ���ʱ�Ĳ�������ʼ---------------
			do {
				if(App.IsInShuaLib("com.immomo.momo")){
					delaySec=1000;
				}
				locationManager.setTestProviderLocation("mockGps",
						LocationUtil.GetRandomLocation(null));
				try {
					Thread.sleep(delaySec);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			} while (true);
			// ----------ģ���ʱ�Ĳ���������---------------
		}
	};
}
