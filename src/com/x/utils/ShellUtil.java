package com.x.utils;

import java.io.DataOutputStream;
import java.io.IOException;
import java.io.OutputStream;

import android.util.Log;

public class ShellUtil {

	public static final String baseTapCommon = "adb shell input tap ";

	public static void Exec(String cmd) {
		DataOutputStream dataOutputStream = null;
		OutputStream outputStream = null;
		try {
			// Ȩ������
			Process p = Runtime.getRuntime().exec("su");
			// ��ȡ�����
			outputStream = p.getOutputStream();
			dataOutputStream = new DataOutputStream(outputStream);
			// ������д��
			Log.i("cmd:", cmd);
			dataOutputStream.writeBytes("su -c ' " + cmd + " '");
			// �ύ����
			dataOutputStream.flush();
			// ����
			// ProcessBuilder pb = new ProcessBuilder("");
			// pb.command(command)

		} catch (Throwable t) {
			t.printStackTrace();
		} finally {
			// �ر�������
			try {
				dataOutputStream.close();
				outputStream.close();
			} catch (IOException e) {
				// TODO �Զ����ɵ� catch ��
				e.printStackTrace();
			}
		}
	}
}
