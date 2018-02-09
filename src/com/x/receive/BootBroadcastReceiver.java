package com.x.receive;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

import com.x.xphone.MainActivity;

/**
 * 暂时没用上
 * 
 * @author Administrator
 * 
 */
public class BootBroadcastReceiver extends BroadcastReceiver {
	static final String action_boot = "android.intent.action.BOOT_COMPLETED";

	@Override
	public void onReceive(Context context, Intent intent) {
		// TODO 自动生成的方法存根
		if (intent.getAction().equals(action_boot)) {
			Intent ootStartIntent = new Intent(context, MainActivity.class);
			ootStartIntent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
			ootStartIntent.putExtra("startFlag", "1");
			context.startActivity(ootStartIntent);
		}
	}

}
