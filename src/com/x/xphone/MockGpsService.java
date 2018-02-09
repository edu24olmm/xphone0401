
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
			
			//创建一个Handler
			HandlerThread thread = new HandlerThread("MyHandlerThread"); 
			thread.start();//创建一个HandlerThread并启动它 
			mHandler = new Handler(thread.getLooper());//使用HandlerThread的looper对象创建Handler，如果使用默认的构造方法，很有可能阻塞UI线程 
			mHandler.post(sendGpsLocation);//将线程post到Handler中 
			
			//设置为不停止
			Intent i = new Intent(this,MainActivity.class);
            //注意Intent的flag设置：FLAG_ACTIVITY_CLEAR_TOP: 如果activity已在当前任务中运行，在它前端的activity都会被关闭，它就成了最前端的activity。FLAG_ACTIVITY_SINGLE_TOP: 如果activity已经在最前端运行，则不需要再加载。设置这两个flag，就是让一个且唯一的一个activity（服务界面）运行在最前端。
            i.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_SINGLE_TOP);
            PendingIntent pi = PendingIntent.getActivity(this, 0, i, 0);           
            Notification myNotify = new Notification.Builder(this) 
                                   .setSmallIcon(R.drawable.ic_launcher) 
                                   .setContentTitle("xphone") 
                                   .setContentText("xGps已经运行")
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
//		Toast.makeText(getBaseContext(), "MockGPS已经启动！", Toast.LENGTH_LONG).show();
		return super.onStartCommand(intent, flags, startId);
	}

	@Override
	public void onDestroy() {
		//销毁线程 
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
			// ----------模拟耗时的操作，开始---------------
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
			// ----------模拟耗时的操作，结束---------------
		}
	};
}
