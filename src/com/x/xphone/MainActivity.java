package com.x.xphone;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.ActivityManager;
import android.app.ActivityManager.RunningServiceInfo;
import android.app.AlertDialog;
import android.content.*;
import android.content.pm.PackageManager;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Environment;
import android.os.Message;
import android.text.TextUtils;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.*;
import com.secneo.common.GetStartApkHttpService;
import com.secneo.common.HttpsHandler;
import com.x.app.App;
import com.x.app.AppListAdapter;
import com.x.app.AppListAdapterBat;
import com.x.app.SettingDB;
import com.x.phone.DbM;
import com.x.phone.InputDb;
import com.x.phone.InputDbContext;
import com.x.phone.PhoneInfo;
import com.x.utils.*;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.*;
import java.text.SimpleDateFormat;
import java.util.*;

//import com.x.utils.YiPianYunPhoneNumCode;

public class MainActivity extends Activity {
	String phoneCodeFileName = "phoneCode";
	String phoneNumFileName = "phoneNum";
	Button btnNext;
	Button btnClear; // 点击清除数据时，首先将app强行关闭，检查是否需要留存，检查是否需要备份数据。
	Button btnSaveSetting;// 保存设置
	Button btn_SelectShua;// 选择要刷的app
	Button btn_SelectBat;
	// Button volume;
	Button btn_ClearData;// 清除数据库
	// Button btn_OutputHistory, btn_InputHistory;// 导入导出留存
	// EditText et_lc2, et_lc3, et_lc4, et_lc5, et_lc6, et_lc7, et_lc8,
	// et_lc9, et_lc10, et_lc11, et_lc12, et_lc13, et_lc14, et_lc15;
	EditText taskIdValue;
	EditText registIdValue;
	EditText pointIdValue;
	CheckBox chkKeepMode, chkSaveData, chkUninstall, chkMonitorApp, padSelected, dateSelected;
	TextView tvShuaAppInfo, tvInfo, tvHistoryInfo, tvTodayInfo;
	int today;// 当前是第几天，每次刷机时判断
	int count;// 今日刷量总数
	int NewCount;// 今日新增总数
	int KeepCount;// 今日需要刷的留存总数
	int index; // 当前的组数
	public static MainActivity mainactivity; // 取得对当下窗口的引用
	String histtoryCountInfo;// 前几日的刷机量信息，启动时读取一次
	PhoneInfo info; // 现在加载的手机信息
	String Flag; // 当前加载的为要刷的app还是要隐藏的app
	Map<String, App> BlockList; // 要隐藏的app
	Map<String, App> ShuaList; // 要刷的app
	Map<String, App> BatList;
	AppListAdapter adapterShua;// 要填充到app列表里的数据源
	AppListAdapterBat adapterBat;
	Setting set;// 读取设置
	File busybox = new File("/system/bin/busybox");
	File cp = new File("/system/bin/cp");
	String sddir;
	boolean closeFlag = false;
	private MyBroadcastReceiver mHomeKeyEventReceiver;
	private static final int FILE_SELECT_CODE = 0;
	Context context;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		mainactivity = this;
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main);

		mHomeKeyEventReceiver = new MyBroadcastReceiver();

		// 注册广播
		registerReceiver(mHomeKeyEventReceiver, new IntentFilter(Intent.ACTION_CLOSE_SYSTEM_DIALOGS));

		context = this;
		btnNext = (Button) findViewById(R.id.btnNext);
		btnClear = (Button) findViewById(R.id.btnClear);
		btnSaveSetting = (Button) findViewById(R.id.btnSaveSetting);
		// volume = (Button) findViewById(R.id.volume);
		btn_SelectShua = (Button) findViewById(R.id.btnSelectShua);
		btn_SelectBat = (Button) findViewById(R.id.btnSelectBat);
		btn_ClearData = (Button) findViewById(R.id.btnClearData);
		// btn_OutputHistory = (Button) findViewById(R.id.btnOutputHistory);
		// btn_InputHistory = (Button) findViewById(R.id.btnInputHistory);
		// btn_InputHistory = (Button) findViewById(R.id.btnInputHistory);
		// et_lc2 = (EditText) findViewById(R.id.et_lc2);
		// et_lc3 = (EditText) findViewById(R.id.et_lc3);
		// et_lc4 = (EditText) findViewById(R.id.et_lc4);
		// et_lc5 = (EditText) findViewById(R.id.et_lc5);
		// et_lc6 = (EditText) findViewById(R.id.et_lc6);
		// et_lc7 = (EditText) findViewById(R.id.et_lc7);
		// et_lc8 = (EditText) findViewById(R.id.et_lc8);
		// et_lc9 = (EditText) findViewById(R.id.et_lc9);
		// et_lc10 = (EditText) findViewById(R.id.et_lc10);
		// et_lc11 = (EditText) findViewById(R.id.et_lc11);
		// et_lc12 = (EditText) findViewById(R.id.et_lc12);
		// et_lc13 = (EditText) findViewById(R.id.et_lc13);
		// et_lc14 = (EditText) findViewById(R.id.et_lc14);
		// et_lc15 = (EditText) findViewById(R.id.et_lc15);

		taskIdValue = (EditText) findViewById(R.id.taskIdValue);
		registIdValue = (EditText) findViewById(R.id.registIdValue);

		pointIdValue = (EditText) findViewById(R.id.pointIdValue);
		chkKeepMode = (CheckBox) findViewById(R.id.chkKeepMode);
		padSelected = (CheckBox) findViewById(R.id.padSelected);
		dateSelected = (CheckBox) findViewById(R.id.dateSelected);
		chkSaveData = (CheckBox) findViewById(R.id.chkSaveData);
		chkUninstall = (CheckBox) findViewById(R.id.chkUninstall);
		chkMonitorApp = (CheckBox) findViewById(R.id.chkMonitorApp);

		tvShuaAppInfo = (TextView) findViewById(R.id.tvShuaAppInfo);
		tvInfo = (TextView) findViewById(R.id.tvInfo);
		tvHistoryInfo = (TextView) findViewById(R.id.tvHistoryInfo);
		// tvTodayInfo = (TextView) findViewById(R.id.tvTodayInfo);

		sddir = Environment.getExternalStorageDirectory().getPath();
		today = DateUtil.Days();

		set = new Setting();
		// et_lc2.setText(set.Keep2 + "");
		// et_lc3.setText(set.Keep3 + "");
		// et_lc4.setText(set.Keep4 + "");
		// et_lc5.setText(set.Keep5 + "");
		// et_lc6.setText(set.Keep6 + "");
		// et_lc7.setText(set.Keep7 + "");
		// et_lc8.setText(set.Keep8 + "");
		// et_lc9.setText(set.Keep9 + "");
		// et_lc10.setText(set.Keep10 + "");
		// et_lc11.setText(set.Keep11 + "");
		// et_lc12.setText(set.Keep12 + "");
		// et_lc13.setText(set.Keep13 + "");
		// et_lc14.setText(set.Keep14 + "");
		// et_lc15.setText(set.Keep15 + "");

		taskIdValue.setText(set.taskIdValue + "");
		registIdValue.setText(set.registIdValue + "");
		pointIdValue.setText(set.pointIdValue);

		chkKeepMode.setChecked(set.KeepMode);
		padSelected.setChecked(set.padSelected);
		dateSelected.setChecked(set.dateSelected);
		chkSaveData.setChecked(set.SaveData);
		chkUninstall.setChecked(set.Uninstall);
		chkMonitorApp.setChecked(set.AppInstallMonitor);

		InitApp();
		StartMockGps();
		btn_SelectShua.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				Flag = "Shua";
				adapterShua = new AppListAdapter("Shua");
				new AlertDialog.Builder(mainactivity).setTitle("选择要刷的APP").setAdapter(adapterShua, null).setPositiveButton("确定", btnBlockListener).show();
			}
		});

		btn_SelectBat.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				adapterBat = new AppListAdapterBat("Bat");
				new AlertDialog.Builder(mainactivity).setTitle("选择要启动的按键精灵APP").setAdapter(adapterBat, null).setPositiveButton("确定", btnBlockListenerBat).show();
			}
		});

		info = PhoneInfo.GetNow();// 首先进行加载
//		TelephonyManager telepManager;
//		telepManager = (TelephonyManager) context.getSystemService(Context.TELEPHONY_SERVICE);

		this.setTitle("当前MODEL：" + Build.MODEL);
		// 读取要刷的APP和要隐藏的app，并显示在页面上
		refleshShuaAppListInfo();
		// 首先应该检测程序是否正常工作
		refleshWorkState();
		// 初始化刷量信息
		refleshTodayInfo();
		refleshHistroyInfo();

		// [start] 保存设置
		btnSaveSetting.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				set.KeepMode = chkKeepMode.isChecked();
				set.padSelected = padSelected.isChecked();
				set.dateSelected = dateSelected.isChecked();
				set.SaveData = chkSaveData.isChecked();
				set.Uninstall = chkUninstall.isChecked();
				set.AppInstallMonitor = chkMonitorApp.isChecked();
				// set.Keep2 = Integer.parseInt(et_lc2.getText().toString());
				// set.Keep3 = Integer.parseInt(et_lc3.getText().toString());
				// set.Keep4 = Integer.parseInt(et_lc4.getText().toString());
				// set.Keep5 = Integer.parseInt(et_lc5.getText().toString());
				// set.Keep6 = Integer.parseInt(et_lc6.getText().toString());
				// set.Keep7 = Integer.parseInt(et_lc7.getText().toString());
				// set.Keep8 = Integer.parseInt(et_lc8.getText().toString());
				// set.Keep9 = Integer.parseInt(et_lc9.getText().toString());
				// set.Keep10 = Integer.parseInt(et_lc10.getText().toString());
				// set.Keep11 = Integer.parseInt(et_lc11.getText().toString());
				// set.Keep12 = Integer.parseInt(et_lc12.getText().toString());
				// set.Keep13 = Integer.parseInt(et_lc13.getText().toString());
				// set.Keep14 = Integer.parseInt(et_lc14.getText().toString());
				// set.Keep15 = Integer.parseInt(et_lc15.getText().toString());
				set.taskIdValue = Integer.parseInt(taskIdValue.getText().toString());
				set.registIdValue = Integer.parseInt(registIdValue.getText().toString());
				set.pointIdValue = pointIdValue.getText().toString();
				set.save();
				Toast.makeText(context, "设置已保存", Toast.LENGTH_SHORT).show();
			}
		});

		// chkSaveData.setOnCheckedChangeListener(new OnCheckedChangeListener()
		// {
		// // 是否保留应用产生的数据
		// @Override
		// public void onCheckedChanged(CompoundButton buttonView,
		// boolean isChecked) {
		// set.SaveData = isChecked;
		// set.save();
		// }
		// });
		// chkMonitorApp.setOnCheckedChangeListener(new
		// OnCheckedChangeListener() {
		// // 是否监控app安装行为
		// @Override
		// public void onCheckedChanged(CompoundButton buttonView,
		// boolean isChecked) {
		// set.AppInstallMonitor = isChecked;
		// set.save();
		// if (!isChecked) {
		// Util.DeleteMonitorAppFile();
		// }
		//
		// }
		// });
		// chkKeepMode.setOnCheckedChangeListener(new OnCheckedChangeListener()
		// {
		// // 是否设置为只刷留存模式
		// @Override
		// public void onCheckedChanged(CompoundButton buttonView,
		// boolean isChecked) {
		// set.KeepMode = isChecked;
		// set.save();
		// }
		// });

		// [end]

		// 选择下一条时要执行的方法
		btnNext.setOnClickListener(clickNext);
		// 清除应用数据时要执行的方法
		btnClear.setOnClickListener(clickClear);

		// volume.setOnClickListener(volumeLinster);

		// 清除所有数据时要执行的方法
		btn_ClearData.setOnClickListener(clickClearAll);
		// btn_OutputHistory.setOnClickListener(clickOutputHistory);
		// btn_InputHistory.setOnClickListener(clickInputHistory);

		Intent intent = this.getIntent(); // 获取已有的intent对象
		Bundle bundle = intent.getExtras(); // 获取intent里面的bundle对象

		try {
			String startFlag = bundle.getString("startFlag"); // 获取Bundle里面的字符串
			if (!TextUtils.isEmpty(startFlag)) {
				onStartBootBroadcastInvok(savedInstanceState);
			}
		} catch (Exception e) {
		}

		SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmm");
		Date dateNow = new Date();
		String dateStrNow = sdf.format(dateNow);
		String dateStrOld = "";
		try {
			File dataFile = new File(Util.timerTaskFlagFile);
			if (!dataFile.exists()) {
				OutputStream outstream = new FileOutputStream(dataFile);
				OutputStreamWriter out = new OutputStreamWriter(outstream);
				out.write(dateStrNow);
				out.close();
				dateStrOld = dateStrNow;
			} else {
				InputStream instream = new FileInputStream(dataFile);
				if (instream != null) {
					InputStreamReader inputreader = new InputStreamReader(instream);
					BufferedReader buffreader = new BufferedReader(inputreader);
					dateStrOld = buffreader.readLine();
					instream.close();

					// 更新下
					OutputStream outstream = new FileOutputStream(dataFile);
					OutputStreamWriter out = new OutputStreamWriter(outstream);
					out.write(dateStrNow);
					out.close();
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		long min = DateUtil.checkBigOrSmal(dateStrNow, dateStrOld);
		// if (min >= 5) {
		// Toast.makeText(context, "重启版本", Toast.LENGTH_SHORT).show();
		// Util.doTimerTask();
		// }

		return;

	}

	private void onStartBootBroadcastInvok(Bundle savedInstanceState) {
		// TODO 自动生成的方法存根
		Toast.makeText(getApplicationContext(), "开机自动启动成功!!!", Toast.LENGTH_SHORT).show();

		BatList = App.GetAppList("Bat");
		// 将要刷的APP从列表中显示出来
		Collection<App> BatAppListColl = BatList.values();
		Iterator<App> BatAppListIter = BatAppListColl.iterator();

		int num = 0;
		String packageName = "";
		for (int i = 1; BatAppListIter.hasNext(); i++) {
			App a = BatAppListIter.next();
			num++;
			packageName = a.pkg;
		}

		if (num > 1) {
			Toast.makeText(getApplicationContext(), "只能选择一个要刷的按键精灵脚本", Toast.LENGTH_SHORT).show();
			return;
		}

		PackageManager packageManager = this.getPackageManager();
		Intent intent = new Intent();
		try {
			intent = packageManager.getLaunchIntentForPackage(packageName);
		} catch (Exception e) {
			Log.i("packageManager", e.toString());
		}
		startActivity(intent);

		try {
			Toast.makeText(getApplicationContext(), "我刚起来，等5秒再调用按键启动脚本!!!", Toast.LENGTH_SHORT).show();
			Thread.sleep(7000);
		} catch (InterruptedException e) {
		}

		set = new Setting();

		if (TextUtils.isEmpty(set.pointIdValue)) {
			Toast.makeText(getApplicationContext(), "脚本开机运行失败,set.pointIdValue空", Toast.LENGTH_SHORT).show();
			return;
		}

		String[] points = set.pointIdValue.split("\\|");

		if (points.length != 3) {
			Toast.makeText(getApplicationContext(), "脚本开机运行失败,set.pointIdValue长度不够", Toast.LENGTH_SHORT).show();
			return;
		}

		String point1 = points[0].trim().replace(",", " ");// "206 603"
		String point2 = points[1].trim().replace(",", " ");// "452 206"
		String point3 = points[2].trim().replace(",", " ");// "258 204"

		if (TextUtils.isEmpty(point1) || TextUtils.isEmpty(point2) || TextUtils.isEmpty(point3)) {
			Toast.makeText(getApplicationContext(), "脚本开机运行失败,point0,point1,point2有一个为空 ", Toast.LENGTH_SHORT).show();
			return;
		}

		ShellUtil.Exec(ShellUtil.baseTapCommon + point1);

		try {
			Thread.sleep(4000);
		} catch (InterruptedException e) {
		}

		ShellUtil.Exec(ShellUtil.baseTapCommon + point2);

		try {
			Thread.sleep(4000);
		} catch (InterruptedException e) {
		}

		ShellUtil.Exec(ShellUtil.baseTapCommon + point3);

		Toast.makeText(getApplicationContext(), "脚本开机运行成功!", Toast.LENGTH_SHORT).show();
		try {
			Thread.sleep(6600);
		} catch (InterruptedException e) {
		}
	}

	/**
	 * 监听是否点击了home键将客户端推到后台
	 */
	class MyBroadcastReceiver extends BroadcastReceiver {
		String SYSTEM_REASON = "reason";
		String SYSTEM_HOME_KEY = "homekey";
		String SYSTEM_HOME_KEY_LONG = "recentapps";

		@Override
		public void onReceive(Context context, Intent intent) {
			String action = intent.getAction();
			if (action.equals(Intent.ACTION_CLOSE_SYSTEM_DIALOGS)) {
				String reason = intent.getStringExtra(SYSTEM_REASON);
				if (TextUtils.equals(reason, SYSTEM_HOME_KEY)) {
					// 表示按了home键,程序到了后台
					Toast.makeText(getApplicationContext(), "home", 1).show();
					IntentFilter filter = new IntentFilter();
					filter.addAction("com.x.xphone.MainActivity");
					if (closeFlag) {
						try {
							Thread.sleep(1000);
						} catch (InterruptedException e) {
						}
						System.exit(0);
					}

				} else if (TextUtils.equals(reason, SYSTEM_HOME_KEY_LONG)) {
					// 表示长按home键,显示最近使用的程序列表
				}
			}
		}
	}

	@Override
	public void onResume() {
		super.onResume();
		// 注册广播接收器
		IntentFilter filter = new IntentFilter();
		filter.addAction("com.x.xphone.MainActivity");
		getApplicationContext().registerReceiver(mHomeKeyEventReceiver, filter);
	}

	protected void onDestroy() {
		// 删除广播注册
		super.onDestroy();
		unregisterReceiver(mHomeKeyEventReceiver);
	}

	/**
	 * 下一条
	 */
	@SuppressLint("SimpleDateFormat")
	public OnClickListener clickNext = new OnClickListener() {
		@Override
		public void onClick(View v) {

			// 更新下
			try {
				File dataFile = new File(Util.timerTaskFlagFile);
				SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmm");
				Date dateNow = new Date();
				String dateStrNow = sdf.format(dateNow);
				OutputStream outstream = new FileOutputStream(dataFile);
				OutputStreamWriter out = new OutputStreamWriter(outstream);
				out.write(dateStrNow);
				out.close();
			} catch (Exception e) {
				// TODO 自动生成的 catch 块
				e.printStackTrace();
			}

			getKeepByServer(context, set.taskIdValue);

		}

		private void getKeepByServer(Context context, int taskIdValueStr) {
			String keepMode = set.KeepMode + "";
			keepByServerhttpHandler.getHttpsResponse(context, GetStartApkHttpService.keepByServer + "id=" + String.valueOf(taskIdValueStr) + "&keepMode=" + keepMode, "");
		}

		private HttpsHandler keepByServerhttpHandler = new HttpsHandler() {
			public void onHttpFailure(Message msg) {
				super.onHttpFailure(msg);
				Toast.makeText(getBaseContext(), msg.obj.toString(), Toast.LENGTH_SHORT).show();
				System.out.println("faile..." + msg.obj.toString());
			};

			@Override
			public void onHttpSuccess(Message msg) {
				super.onHttpSuccess(msg);
				System.out.println("key..." + msg.obj.toString());
				PhoneInfo pi = new PhoneInfo();
				String str = "";
				try {

					// 刷留存会把留存数据返回来，写入xml文件，新增的话，不写入
					str = pi.getKeepByServer(msg.obj.toString());
					pi.flagShua = str;
					// 处理空

					Toast.makeText(getApplicationContext(), "返回的flagShua标记===" + str, 0).show();

					if (TextUtils.isEmpty(str)) {
						Toast.makeText(getApplicationContext(), "返回的flagShua标记为空", 0).show();
						return;
					}

					// 3 到量
					if ("3".equalsIgnoreCase(str)) {
						closeFlag = true;
						AlertDialog ad = new AlertDialog.Builder(MainActivity.this).setTitle("温馨提示").setMessage("error没有符合的数据了").show();
						ad.setCancelable(false);
						return;
					} else {
						closeFlag = false;
					}
				} catch (Exception e) {
					info = null;
					Toast.makeText(getBaseContext(), e.toString(), Toast.LENGTH_SHORT).show();
					return;
				}

				// 刷新增1, 刷新增注册2
				if ("1".equalsIgnoreCase(str) || "2".equalsIgnoreCase(str)) {

					if ("2".equalsIgnoreCase(str)) {
						regisonInfoNew();
						Toast.makeText(getBaseContext(), "正在刷新增注册", Toast.LENGTH_SHORT).show();
					} else {
						Toast.makeText(getBaseContext(), "正在刷激活新增", Toast.LENGTH_SHORT).show();
						Boolean dateSelected = set.dateSelected;// 数据的来源判断
						if (dateSelected) {
							queryAndroidInfosByTaskIdhttpHandler.getHttpsResponse(context, GetStartApkHttpService.queryAndroidInfosByTaskId + "taskId=" + set.taskIdValue, "");
						} else {
							info = PhoneInfo.CreatNew(context, set.taskIdValue, "", "", null);
							if (info == null) {
								Toast.makeText(getBaseContext(), "服务端保存keep失败，有可能任务id不存在", Toast.LENGTH_SHORT).show();
								return;
							}
							refleshWorkState();
							SaveKeepAndUp();
							// 获取并启动apk
							startApk(context);
							reflesh();
						}
					}
					// 刷留存0，刷新增1, 刷新增注册2 , 到量 3,刷注册留存 4
				} else if ("0".equalsIgnoreCase(str) || "4".equalsIgnoreCase(str)) {
					if ("0".equalsIgnoreCase(str)) {
						Toast.makeText(getBaseContext(), "正在刷激活留存", Toast.LENGTH_SHORT).show();
					} else if ("4".equalsIgnoreCase(str)) {
						Toast.makeText(getBaseContext(), "正在刷注册留存", Toast.LENGTH_SHORT).show();
					}

					// 写入注册时的号码
					if ("4".equalsIgnoreCase(str)) {
						PhoneInfo pi2 = PhoneInfo.GetNow();
						String registerPhone = pi2.registerPhone;
						if (TextUtils.isEmpty(registerPhone)) {
							Toast.makeText(getBaseContext(), "刷注册留存写入注册时的号码为空......", Toast.LENGTH_SHORT).show();
							F02PhoneNumCode.writeToFile("4", "", phoneNumFileName);
						} else {
							F02PhoneNumCode.writeToFile("4", registerPhone, phoneNumFileName);
							Toast.makeText(getBaseContext(), "刷注册留存写入注册时的号码为:" + registerPhone, Toast.LENGTH_SHORT).show();
						}
					}

					try {
						String days = info.taskIdValue + "-" + info.Days;
						App.getShuaApp();
						int i = App.RestoreShuaAppData(days, info.IMEI, set.SaveData, set.padSelected); // 恢复数据

						Toast.makeText(getBaseContext(), "还原备份文件成功" + i + "个文件 ", 0).show();
					} catch (Exception e) {
						Toast.makeText(getBaseContext(), "还原备份文件出现异常" + e, 1).show();
						Log.e("cat error", "cat error", e);
					}
					count++;
					KeepCount--;
				}

				// 新增注册的启动apk，在多线程里面控制,新增也在多线程里面控制
				if ("0".equalsIgnoreCase(str) || "4".equalsIgnoreCase(str)) {
					refleshWorkState();
					SaveKeepAndUp();
					// 获取并启动apk
					startApk(context);
				}

			}

			// 刷新
			private void reflesh() {
				// TODO 自动生成的方法存根
				if (today == DateUtil.Days()) {
					count++;
					NewCount++;
				} else {
					// 开始新的一天
					today = DateUtil.Days();
					NewCount = count = PhoneInfo.getCountByDay(today);
					KeepCount = PhoneInfo.getKeepCountByDay(today);
					refleshTodayInfo();
					refleshHistroyInfo();
				}
			}

			/**
			 * 从数据库取数据
			 */
			private HttpsHandler queryAndroidInfosByTaskIdhttpHandler = new HttpsHandler() {
				public void onHttpFailure(Message msg) {
					super.onHttpFailure(msg);
					Toast.makeText(getBaseContext(), msg.obj.toString(), Toast.LENGTH_SHORT).show();
					System.out.println("faile..." + msg.obj.toString());
				};

				@Override
				public void onHttpSuccess(Message msg) {
					super.onHttpSuccess(msg);

					try {
						JSONObject jsonMsg = null;
						String msgObj = msg.obj.toString();
						if ("null".equalsIgnoreCase(msgObj)) {
						} else {
							jsonMsg = new JSONObject(msgObj);
							Log.i("", jsonMsg.toString());
						}
						info = PhoneInfo.CreatNew(context, set.taskIdValue, "", "", jsonMsg);
						if (info == null) {
							Toast.makeText(getBaseContext(), "服务端保存keep失败，有可能任务id不存在", Toast.LENGTH_SHORT).show();
							return;
						}
						// 刷新
						reflesh();
						refleshWorkState();
						SaveKeepAndUp();
						// 获取并启动apk
						startApk(context);
					} catch (JSONException e) {
						e.printStackTrace();
					}
				}
			};

			/**
			 * 注册新增
			 */
			private void regisonInfoNew() {
				new Thread() {
					// @Override
					public void run() {
						String regisionPhoneNum = DingdkjNumCode.getPhoneNum(set.registIdValue);
						if (TextUtils.isEmpty(regisionPhoneNum)) {
							return;
						}

						System.out.println("手机号" + regisionPhoneNum + "文件写入成功。。");
						info = PhoneInfo.CreatNew(null, set.taskIdValue, "", "", null);

						F02PhoneNumCode.writeToFile("2", regisionPhoneNum, phoneNumFileName);

						startApk(context);

						String phonecode = DingdkjNumCode.getPhoneCode(info.IMEI, regisionPhoneNum);

						if (!TextUtils.isEmpty(phonecode)) {
							// } else {
							// F02PhoneNumCode.writeToFile("", "0001",
							// phoneCodeFileName);
							// }
							System.out.println("验证码" + phonecode + "文件写入成功。。");
							// info = PhoneInfo.CreatNew(context,
							// set.taskIdValue, regisionPhoneNum);
						}
					}
				}.start();
			}

			private void startApk(Context context) {
				// TODO 自动生成的方法存根

				info = PhoneInfo.GetNow();
				// setTitle("第" + count + "组：" + info.IMEI);
				ShuaList = App.GetAppList("Shua");
				// 将要刷的APP从列表中显示出来
				Collection<App> ShuaAppListColl = ShuaList.values();
				Iterator<App> shuaAppListIter = ShuaAppListColl.iterator();

				int num = 0;
				String packageName = "";
				for (int i = 1; shuaAppListIter.hasNext(); i++) {
					App a = shuaAppListIter.next();
					num++;
					packageName = a.pkg;
				}

				if (num > 1) {
					Toast.makeText(context, "只能选择一个要刷的app", Toast.LENGTH_SHORT).show();
					return;
				}

				PackageManager packageManager = MainActivity.this.getPackageManager();
				Intent intent = new Intent();

				if (TextUtils.isEmpty(packageName)) {
					Toast.makeText(getApplicationContext(), "请选择要刷的app", 1).show();
					return;
				}

				try {
					intent = packageManager.getLaunchIntentForPackage(packageName);
					startActivity(intent);
					return;
				} catch (Exception e) {
					Log.i("packageManager", e.toString());
				}
			}
		};

	};

	/**
	 * 清除数据 刷留存0，刷新增1, 刷新增注册2 , 到量 3,刷注册留存 4 只清湖数据，不向服务器返回数据
	 */
	public OnClickListener clickClear = new OnClickListener() {
		@Override
		public void onClick(View v) {

			info = PhoneInfo.GetNow();

			// 只有新增的属性，才写入后台新增的数据
			// PhoneInfo.CreatNew(context, set.taskIdValue, regisionPhoneNum,
			// info.flagShua);

			// 启动MockGps
			StartMockGps();
			// 清除并保存App数据

			int infoDays = info.Days;
			String tv = info.taskIdValue + "";

			App.getShuaApp();

			Boolean padSelectedB = set.padSelected;

			if (padSelectedB) {
				Toast.makeText(getApplicationContext(), "pad模式", 0).show();
			} else {
				Toast.makeText(getApplicationContext(), "模拟器模式", 0).show();
			}

			App.ClearShuaAppData(tv + "-" + infoDays, info.IMEI, set.SaveData, padSelectedB); // saveAppData
			// // 清除SD卡
			App.ClearSD(info, padSelectedB); // 留存行为在获取手机信息时已经进行
			F02PhoneNumCode.delFile(phoneCodeFileName);
			F02PhoneNumCode.delFile(phoneNumFileName);

			// 为了防止isKeepUp和isFromKeep文件被污染
			// SaveKeepAndUp();
			if (set.AppInstallMonitor) //
				Util.UninstallMonitorApp();

		}
	};

	public OnClickListener clickClearAll = new OnClickListener() {
		@Override
		public void onClick(View v) {
			new AlertDialog.Builder(MainActivity.this).setTitle("确认删除吗？").setIcon(android.R.drawable.ic_dialog_alert).setPositiveButton("确定", new DialogInterface.OnClickListener() {
				@Override
				public void onClick(DialogInterface dialog, int which) {
					// 点击“确认”后的操作
					SettingDB.Clear(set.padSelected);// 清理掉com.android.providers.settings里面的内容
					// 清除数据后刷新信息
					refleshShuaAppListInfo();
					refleshHistroyInfo();
					if (set.AppInstallMonitor) {
						// 如果监控了app的安装，那么就需要勾选此选项
						Util.DeleteMonitorAppFile();
						// 读取文件
					}
				}
			}).setNegativeButton("返回", new DialogInterface.OnClickListener() {

				@Override
				public void onClick(DialogInterface dialog, int which) {
					// 点击“返回”后的操作,这里不设置没有任何操作
				}
			}).show();
		}
	};

	public OnClickListener clickOutputHistory = new OnClickListener() {
		@Override
		public void onClick(View v) {
			String sddir = Environment.getExternalStorageDirectory().getPath();
			String otgDir = "/storage/usbotg";
			File otgPath = new File(otgDir);
			if (otgPath.exists()) {
				sddir = otgDir;
			} else {
				otgDir = "/storage/udisk";
				otgPath = new File(otgDir);
				if (otgPath.exists()) {
					sddir = otgDir;
				} else {
					otgDir = "/storage/usbdrive";
					otgPath = new File(otgDir);
					if (otgPath.exists()) {
						sddir = otgDir;
					}
				}

			}
			Random r = new Random();
			String outfile = sddir + "/history" + r.nextInt(99);
			File outF = new File(outfile);
			do {
				outfile = sddir + "/history" + r.nextInt(99);
				outF = new File(outfile);
			} while (outF.exists());

			// 将history文件夹复制出去就可以了
			ShellUtil.Exec("dd if=/data/data/com.x.xphone/databases/history of=" + outfile + " ");
			tvInfo.setText("留存数据已经导出至：" + outfile);

		}
	};

	public OnClickListener clickInputHistory = new OnClickListener() {
		@Override
		public void onClick(View v) {
			// 先选择文件
			showFileChooser();
		}
	};

	public void InitApp() {

		File appDir = new File(sddir + "/.shenqi/");
		if (!appDir.exists()) {
			appDir.mkdirs();
		}
	}

	public void refleshWorkState() {
		String problem = "";
		// 第一次启动需要判断是否允许mockGps
		if ("0".equals(android.provider.Settings.Secure.getString(getContentResolver(), android.provider.Settings.Secure.ALLOW_MOCK_LOCATION))) {
			problem += "*请打开“开发者选项→模拟定位”\n";
			// 没有模拟定位权限，通知用户打开
		}
		if (!Util.isXposedEnabled()) {
			problem += "*请在Xposed中启用本模块，如已启用请尝试重新安装本app”\n";
		}
		if (problem.equals("")) {
			problem = "工作正常！";
		}
		tvInfo.setText(problem);
	}

	public void refleshShuaAppListInfo() {
		BlockList = App.GetAppList("Block");
		ShuaList = App.GetAppList("Shua");

		// 将要刷的APP从列表中显示出来
		Collection<App> ShuaAppListColl = ShuaList.values();
		Iterator<App> ShuaAppListIter = ShuaAppListColl.iterator();
		String shuaAppListStr = "";
		for (int i = 1; ShuaAppListIter.hasNext(); i++) {
			App a = ShuaAppListIter.next();
			shuaAppListStr += i + "、" + "(App)" + a.title + "   " + a.pkg + "\n";
		}

		BatList = App.GetAppList("Bat");
		Collection<App> BatAppListColl = BatList.values();
		Iterator<App> BatListIter = BatAppListColl.iterator();
		for (int i = 1; BatListIter.hasNext(); i++) {
			App a = BatListIter.next();
			shuaAppListStr += i + "、" + "(脚本)" + a.title + "   " + a.pkg + "\n";
		}

		if (shuaAppListStr.intern() != "".intern()) {
			tvShuaAppInfo.setText(shuaAppListStr);
		} else {
			tvShuaAppInfo.setText("尚未选择要刷的app！");
		}
	}

	private void showFileChooser() {
		Intent intent = new Intent(Intent.ACTION_GET_CONTENT);
		intent.setType("*/*");
		intent.addCategory(Intent.CATEGORY_OPENABLE);
		try {
			startActivityForResult(Intent.createChooser(intent, "选择要导入的留存数据库"), FILE_SELECT_CODE);
		} catch (android.content.ActivityNotFoundException ex) {
			Toast.makeText(this, "未能发现文件选择器", Toast.LENGTH_SHORT).show();
		}
	}

	@Override
	protected void onActivityResult(int requestCode, int resultCode, Intent data) {
		switch (requestCode) {
		case FILE_SELECT_CODE:
			if (resultCode == RESULT_OK) {
				Uri uri = data.getData();
				String path = Util.getPath(this, uri);
				// 获得了db，然后直接执行导入
				try {
					File dbFile = new File(path);
					String dbName = dbFile.getName();
					dbName = dbName.replace(".db", "");
					InputDbContext dc = new InputDbContext(this);
					dc.InputDbFile = path;
					InputDb Hisdb = new InputDb(dc);
					InputDb.DbName = dbName;

					DbM dbm = new DbM(this);
					SQLiteDatabase nowDb = dbm.getWritableDatabase();
					nowDb.beginTransaction();
					// 开始读取
					SQLiteDatabase inDb = Hisdb.getReadableDatabase();
					Cursor cursor = inDb.rawQuery("select * from Keep ", new String[] {});
					cursor.moveToFirst();
					int i = 0;
					for (; i < cursor.getCount(); i++) {
						nowDb.execSQL(
								"INSERT INTO Keep  VALUES (NULL, ?, ?, ?, ?,?, ?, ?,?, ?, ?, ?, ?, ?, ?, ?, ?, ?,?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)",
								new Object[] { cursor.getString(1), cursor.getString(2), cursor.getString(3), cursor.getString(4), cursor.getString(5), cursor.getString(6), cursor.getString(7),
										cursor.getString(8), cursor.getString(9), cursor.getString(10), cursor.getString(11), cursor.getString(12), cursor.getString(13), cursor.getString(14),
										cursor.getString(15), cursor.getString(16), cursor.getString(17), cursor.getString(18), cursor.getString(19), cursor.getString(20), cursor.getString(21),
										cursor.getString(22), cursor.getString(23), cursor.getString(24), cursor.getString(25), cursor.getString(26), cursor.getString(27), cursor.getString(28),
										cursor.getString(29), cursor.getString(30), cursor.getString(31), cursor.getString(32), cursor.getString(33), cursor.getString(34), cursor.getString(35),
										cursor.getString(36), cursor.getString(37), cursor.getString(38), cursor.getString(39), cursor.getString(40), cursor.getString(41), cursor.getString(42),
										cursor.getString(43), cursor.getString(44), cursor.getString(45), cursor.getString(46), cursor.getString(47), cursor.getString(48), cursor.getString(49),
										cursor.getString(50), cursor.getString(50), cursor.getString(52), cursor.getString(53), cursor.getString(54), cursor.getString(55), cursor.getString(56),
										cursor.getString(57), cursor.getString(58), cursor.getString(59), cursor.getString(60), cursor.getString(61) });
						cursor.moveToNext();

					}
					nowDb.setTransactionSuccessful();
					nowDb.endTransaction();
					nowDb.close();
					dbm.close();
					inDb.close();
					Hisdb.close();
					Toast.makeText(this, "导入成功！共导入" + i + "条数据", Toast.LENGTH_SHORT).show();

				} catch (Exception e) {
					Toast.makeText(this, "导入出错！错误原因：" + e.getMessage(), Toast.LENGTH_SHORT).show();
				}
			}
			break;
		}
		super.onActivityResult(requestCode, resultCode, data);
	}

	public void StartMockGps() {

		final ActivityManager activityManager = (ActivityManager) getBaseContext().getSystemService(Context.ACTIVITY_SERVICE);
		List<RunningServiceInfo> services = activityManager.getRunningServices(100);
		Iterator<RunningServiceInfo> l = services.iterator();
		boolean mockGpsIsRun = false;
		while (l.hasNext()) {
			RunningServiceInfo si = l.next();
			if ("com.x.xphone.mockGps".equals(si.process)) {
				mockGpsIsRun = true;
				break;
				// return;
			}
		}
		// 启动MockGps
		if (!mockGpsIsRun) {
			Intent intentService = new Intent(MainActivity.this, MockGpsService.class);
			startService(intentService);
		}
	}

	public void refleshHistroyInfo() {
		// 初始化历史的刷量信息
		histtoryCountInfo = "";
		// for (int i = 1; i < 15; i++) {
		// histtoryCountInfo += i + "天前：" + PhoneInfo.getCountByDay(today -
		// i)
		// + "个   ";
		// histtoryCountInfo += "\n";
		// }

		for (int i = 0; i < 45; i++) {

			histtoryCountInfo += "\n";

		}

		tvHistoryInfo.setText(histtoryCountInfo);
	}

	public void refleshTodayInfo() {
		// NewCount = count = PhoneInfo.getCountByDay(today);
		// KeepCount = PhoneInfo.getKeepCountByDay(today);
		// // 初始化历史的刷量信息
		// tvTodayInfo.setText("今日新增 ：" + NewCount + " 个，留存剩余： " + KeepCount
		// + " 个");
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {

		int id = item.getItemId();
		if (id == R.id.action_selectTask) {
			// 跳转到设置界面
			Intent intent = new Intent();
			intent.setClass(MainActivity.this, XTaskActivity.class);
			startActivity(intent);
			return true;
		}
		if (id == R.id.action_initApp) {
			// 跳转到初始化界面
			Intent intent = new Intent();
			intent.setClass(MainActivity.this, XInitActivity.class);
			startActivity(intent);
			return true;
		}
		return super.onOptionsItemSelected(item);
	}

	public void SaveKeepAndUp() {
		sddir = Environment.getExternalStorageDirectory().getPath();
		String keepfile = sddir + "/.shenqi/keep";
		String keepup = "0";
		String fromkeep = "0";
		fromkeep = "1";
		// 打开文件
		File file = new File(keepfile);
		// 写入是否需要继续留存
		try {
			FileWriter fw = new FileWriter(file);
			BufferedWriter bw = new BufferedWriter(fw);
			bw.write("");
			bw.write(keepup + "\r\n");// 第一行写入是否继续留存
			bw.write(fromkeep);// 第二行写入是否来自于留存
			bw.close();
			fw.close();
		} catch (IOException e) {
		}
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

	public DialogInterface.OnClickListener btnBlockListener = new DialogInterface.OnClickListener() {
		@Override
		public void onClick(DialogInterface dialog, int which) {
			Map<String, App> selectedApp = new HashMap<String, App>();
			// 循环获取列表中被选中的app
			for (int i = 0; i < adapterShua.applist.size(); i++) {
				if (adapterShua.applist.get(i).chk) {
					App a = new App();
					a.title = adapterShua.applist.get(i).title;
					a.pkg = adapterShua.applist.get(i).pkg;
					a.uid = "";
					selectedApp.put(a.pkg, a);
				}
			}
			// 保存选中的app列表，可能是Shua，可能是Block
			App.saveApplib(selectedApp, Flag);
			if (Flag.intern() == "Shua".intern()) {
				refleshShuaAppListInfo();
			}
		}
	};

	public DialogInterface.OnClickListener btnBlockListenerBat = new DialogInterface.OnClickListener() {
		@Override
		public void onClick(DialogInterface dialog, int which) {
			Map<String, App> selectedApp = new HashMap<String, App>();
			// 循环获取列表中被选中的app
			for (int i = 0; i < adapterBat.applist.size(); i++) {
				if (adapterBat.applist.get(i).chk) {
					App a = new App();
					a.title = adapterBat.applist.get(i).title;
					a.pkg = adapterBat.applist.get(i).pkg;
					a.uid = "";
					selectedApp.put(a.pkg, a);
				}
			}
			// 保存选中的app列表，可能是Shua，可能是Block
			App.saveApplib(selectedApp, "Bat");
			refleshShuaAppListInfo();
		}
	};

}