package com.x.hook;

import com.x.xphone.MockGpsService;

import android.content.Context;
import android.content.Intent;
import android.os.RemoteException;

public class ServiceUtil {

	public static void startMockGpsService(Context context)
			throws RemoteException {
		Intent intentService = new Intent(context, MockGpsService.class);
		context.startService(intentService);
	}
}
