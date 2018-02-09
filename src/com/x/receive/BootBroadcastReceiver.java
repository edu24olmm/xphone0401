package com.x.receive;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

import com.x.xphone.MainActivity;

/**
 * ��ʱû����
 * 
 * @author Administrator
 * 
 */
public class BootBroadcastReceiver extends BroadcastReceiver {
	static final String action_boot = "android.intent.action.BOOT_COMPLETED";

	@Override
	public void onReceive(Context context, Intent intent) {
		// TODO �Զ����ɵķ������
		if (intent.getAction().equals(action_boot)) {
			Intent ootStartIntent = new Intent(context, MainActivity.class);
			ootStartIntent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
			ootStartIntent.putExtra("startFlag", "1");
			context.startActivity(ootStartIntent);
		}
	}

}
