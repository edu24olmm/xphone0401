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
			// 权限设置
			Process p = Runtime.getRuntime().exec("su");
			// 获取输出流
			outputStream = p.getOutputStream();
			dataOutputStream = new DataOutputStream(outputStream);
			// 将命令写入
			Log.i("cmd:", cmd);
			dataOutputStream.writeBytes("su -c ' " + cmd + " '");
			// 提交命令
			dataOutputStream.flush();
			// 测试
			// ProcessBuilder pb = new ProcessBuilder("");
			// pb.command(command)

		} catch (Throwable t) {
			t.printStackTrace();
		} finally {
			// 关闭流操作
			try {
				dataOutputStream.close();
				outputStream.close();
			} catch (IOException e) {
				// TODO 自动生成的 catch 块
				e.printStackTrace();
			}
		}
	}
}
