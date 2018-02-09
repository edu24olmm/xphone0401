package com.x.xphone;

import com.x.crash.CrashHandler;

import android.app.Application;
import android.content.Context;
import android.content.res.Resources;

public class MyApplication extends Application {
	private static MyApplication mcontext;

	@Override
	public void onCreate() {
		super.onCreate();
		mcontext = this;
		CrashHandler crashHandler = CrashHandler.getInstance();
		crashHandler.init(getApplicationContext());
	}

	public static Context getAppContext() {
		return mcontext;
	}

	public static Resources getAppResources() {
		return getAppResources();
	}
}
