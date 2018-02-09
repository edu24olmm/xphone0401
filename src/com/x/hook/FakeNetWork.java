package com.x.hook;

import static de.robv.android.xposed.XposedHelpers.findAndHookMethod;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Random;

import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.wifi.ScanResult;
import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;

import com.x.app.App;
import com.x.phone.PhoneInfo;
import com.x.utils.Util;

import de.robv.android.xposed.IXposedHookLoadPackage;
import de.robv.android.xposed.XC_MethodHook;
import de.robv.android.xposed.XposedBridge;
import de.robv.android.xposed.callbacks.XC_LoadPackage.LoadPackageParam;

public class FakeNetWork implements IXposedHookLoadPackage {
	static PhoneInfo info;
	static boolean fakeConn = true;
	static boolean isMomo = false;

	@Override
	public void handleLoadPackage(final LoadPackageParam paramLoadPackageParam)
			throws Throwable {
		if (!App.IsInShuaLib(paramLoadPackageParam.packageName)) {
			if ("com.umeng.example".equals(paramLoadPackageParam.packageName)) {
				XposedBridge.log("NOT Shua FakeNetWork："
						+ paramLoadPackageParam.packageName);
			} else {
				return;
			}
		}
		info = PhoneInfo.GetNow();

		String IMEIEnd = info.IMEI.charAt(12) + "";
		int imeiend = 4;
		try {
			imeiend = Integer.valueOf(IMEIEnd);
		} catch (Exception e) {
			imeiend = 4;
		}
		imeiend = 4;
		if (imeiend > 8) {
			fakeConn = true;
		} else {
			fakeConn = false;
		}
		try {
			findAndHookMethod(WifiManager.class, "getWifiState",
					new Object[] { new XC_MethodHook() {
						@Override
						protected void beforeHookedMethod(MethodHookParam param)
								throws Throwable {
							// wifi开启时,限制后为关闭;其它状态时,限制后为未知
							if (!isMomo) {
								if (fakeConn) {
									// param.setResult(WifiManager.WIFI_STATE_DISABLED)
									param.setResult(WifiManager.WIFI_STATE_UNKNOWN);
									;
									Util.XLog(param);
								} else {
									param.setResult(WifiManager.WIFI_STATE_ENABLED);
								}
							} else {
								param.setResult(WifiManager.WIFI_STATE_ENABLED);
							}
							return;
						}
					} });

			findAndHookMethod(WifiManager.class, "getScanResults",
					new XC_MethodHook() {
						@Override
						protected void afterHookedMethod(MethodHookParam param)
								throws Throwable {
							param.setResult(new ArrayList<ScanResult>());
							Util.XLog(param);
						}
					});
		} catch (Exception e) {
			XposedBridge.log("错误:FakeNetWork-----------------------");
		}
		try {
			findAndHookMethod(NetworkInfo.class, "getExtraInfo",
					new Object[] { new XC_MethodHook() {
						@Override
						protected void beforeHookedMethod(MethodHookParam param)
								throws Throwable {
							NetworkInfo nw = (NetworkInfo) param.thisObject;
							if (nw.getType() == ConnectivityManager.TYPE_WIFI) {
								// 如果是wifi
								param.setResult(info.SSID);
								return; // 如果
							}
							int networkType = info.NetWorkType;
							String mnc = info.Operator.substring(4, 5);
							Util.XLog(param);
							if (mnc.equals("01")) {
								if (networkType == 1)
									param.setResult("uniwap");
								else if (networkType == 2) {
									param.setResult("uninet");
								} else {
									if (new Random().nextInt(11) < 9)
										param.setResult("3gnet");
									else
										param.setResult("3gwap");
								}
							} else if (mnc.equals("03")) {
								if (networkType == 7) {
									param.setResult("ctwap");
								} else if (networkType == 6) {
									param.setResult("ctnet");
								}

							} else {
								if (networkType == 1) {
									param.setResult("cmwap");
								} else {
									param.setResult("cmnet");
								}
							}
						}
					} });

			findAndHookMethod(NetworkInfo.class, "getType",
					new Object[] { new XC_MethodHook() {
						@Override
						protected void afterHookedMethod(MethodHookParam param)
								throws Throwable {
							Util.XLog(param);

							if (param.getResult() == null) {
								param.setResult(ConnectivityManager.TYPE_MOBILE);// 移动数据
								return;
							}
							if (!isMomo) {
								if (fakeConn) {
									param.setResult(ConnectivityManager.TYPE_MOBILE);// 移动数据
								}
							}
						}
					} });

			findAndHookMethod(NetworkInfo.class, "getTypeName",
					new Object[] { new XC_MethodHook() {
						@Override
						protected void afterHookedMethod(MethodHookParam param)
								throws Throwable {
							Util.XLog(param);
							if (param.getResult() == null) {
								param.setResult("MOBILE");// 移动数据
								return;
							}
							if (!isMomo) {
								if (fakeConn) {
									param.setResult("MOBILE");// 移动数据
								}
							}
						}
					} });

			findAndHookMethod(ConnectivityManager.class,
					"getActiveNetworkInfo", new Object[] { new XC_MethodHook() {
						@Override
						protected void afterHookedMethod(MethodHookParam param)
								throws Throwable {
							if (param.getResult() == null) {
								NetworkInfo ni = NetworkInfo.class
										.getConstructor(NetworkInfo.class)
										.newInstance(param.getResult());
								try {
									Field mNetworkType = NetworkInfo.class
											.getDeclaredField("mNetworkType");
									mNetworkType.setAccessible(true);
									mNetworkType.set(ni,
											ConnectivityManager.TYPE_MOBILE);
								} catch (Exception e) {
								}
								try {
									Field mNetworkType = NetworkInfo.class
											.getDeclaredField("mSubtype");
									mNetworkType.setAccessible(true);
									mNetworkType.set(ni,
											ConnectivityManager.TYPE_MOBILE);
								} catch (Exception e) {
								}
								param.setResult(ni);
								return;
							}
							if (!isMomo) {
								if (fakeConn) {
									Util.XLog(param);
									// // 如果要模拟成MOBILE
									NetworkInfo ni = NetworkInfo.class
											.getConstructor(NetworkInfo.class)
											.newInstance(param.getResult());

									try {
										Field mNetworkType = NetworkInfo.class
												.getDeclaredField("mNetworkType");
										mNetworkType.setAccessible(true);
										mNetworkType
												.set(ni,
														ConnectivityManager.TYPE_MOBILE);
									} catch (Exception e) {
									}
									try {
										Field mNetworkType = NetworkInfo.class
												.getDeclaredField("mSubtype");
										mNetworkType.setAccessible(true);
										mNetworkType
												.set(ni,
														ConnectivityManager.TYPE_MOBILE);
									} catch (Exception e) {
									}
									param.setResult(ni);
								}
							}
						}
					} });

			findAndHookMethod(NetworkInfo.class, "getSubtype",
					new Object[] { new XC_MethodHook() {
						@Override
						protected void beforeHookedMethod(MethodHookParam param)
								throws Throwable {
							Util.XLog(param);
							param.setResult(info.NetWorkType);
						}
					} });

			findAndHookMethod(NetworkInfo.class, "getSubtypeName",
					new Object[] { new XC_MethodHook() {
						@Override
						protected void beforeHookedMethod(MethodHookParam param)
								throws Throwable {
							Util.XLog(param);
							int networkType = info.NetWorkType;
							if (networkType == 1)
								param.setResult("GPRS");
							else if (networkType == 2)
								param.setResult("EDGE");
							else if (networkType == 3)
								param.setResult("UMTS");
							else if (networkType == 6) {
								if (new Random().nextInt(2) == 0)
									param.setResult("CDMA - EvDo rev. A");
								else {
									param.setResult("CDMA EVDO");
								}
							} else if (networkType == 7)
								param.setResult("CDMA - 1xRTT");
							else if (networkType == 8)
								param.setResult("HSDPA");
							else if (networkType == 9)
								param.setResult("HSUPA");
							else if (networkType == 10)
								param.setResult("HSPA");
							else if (networkType == 14)
								param.setResult("CDMA - eHRPD");
							else if (networkType == 15)
								param.setResult("HSPA+");
							else if (networkType == 17)
								param.setResult("TD-SCDMA");
							else if (networkType == 13)
								param.setResult("LTE");
							else
								param.setResult("unknown");
						}
					} });

			findAndHookMethod(NetworkInfo.class, "getReason",
					new Object[] { new XC_MethodHook() {
						@Override
						protected void beforeHookedMethod(MethodHookParam param)
								throws Throwable {
							Util.XLog(param);
							param.setResult("dataEnabled");// 移动数据
						}
					} });
			findAndHookMethod(WifiInfo.class, "getMacAddress",
					new Object[] { new XC_MethodHook() {
						@Override
						protected void beforeHookedMethod(MethodHookParam param)
								throws Throwable {
							Util.XLog(param);
							param.setResult(info.Mac);// 移动数据
						}
					} });
			findAndHookMethod(WifiInfo.class, "getSSID",
					new Object[] { new XC_MethodHook() {
						@Override
						protected void beforeHookedMethod(MethodHookParam param)
								throws Throwable {
							Util.XLog(param);
							param.setResult(info.SSID);// 移动数据
						}
					} });
			findAndHookMethod(WifiInfo.class, "getBSSID",
					new Object[] { new XC_MethodHook() {
						@Override
						protected void beforeHookedMethod(MethodHookParam param)
								throws Throwable {
							Util.XLog(param);
							param.setResult(info.BSSID);// 移动数据
						}
					} });
			findAndHookMethod(WifiInfo.class, "getIpAddress",
					new Object[] { new XC_MethodHook() {
						@Override
						protected void beforeHookedMethod(MethodHookParam param)
								throws Throwable {
							Util.XLog(param);
							param.setResult(info.Ip);// 移动数据
						}
					} });

		} catch (Exception e) {
			XposedBridge.log("错误:FakeNetWork-----------------------");
		}
		try {
			findAndHookMethod("android.net.ConnectivityManager",
					paramLoadPackageParam.classLoader, "getNetworkInfo",
					int.class, new XC_MethodHook() {
						@Override
						protected void afterHookedMethod(MethodHookParam param)
								throws Throwable {
							if (param.getResult() == null) {
								NetworkInfo ni = NetworkInfo.class
										.getConstructor(NetworkInfo.class)
										.newInstance(param.getResult());
								if (param.args.length > 0) {
									// 模拟成mobile
									if ((Integer) param.args[0] == ConnectivityManager.TYPE_WIFI) {
										try {
											Field mState = NetworkInfo.class
													.getDeclaredField("mState");
											mState.setAccessible(true);
											mState.set(
													ni,
													android.net.NetworkInfo.State.DISCONNECTED);
										} catch (Exception e) {
										}
									} else {
										try {
											Field mState = NetworkInfo.class
													.getDeclaredField("mState");
											mState.setAccessible(true);
											mState.set(
													ni,
													android.net.NetworkInfo.State.CONNECTED);
										} catch (Exception e) {
										}
									}
								}
								param.setResult(ni);
								return;
							}
							if (!isMomo) {
								Util.XLog(param);
								if (!fakeConn)
									return;// 如果不修改为移动网络则不修改
								NetworkInfo ni = NetworkInfo.class
										.getConstructor(NetworkInfo.class)
										.newInstance(param.getResult());
								if (param.args.length > 0) {
									// 模拟成mobile
									if ((Integer) param.args[0] == ConnectivityManager.TYPE_WIFI) {
										try {
											Field mState = NetworkInfo.class
													.getDeclaredField("mState");
											mState.setAccessible(true);
											mState.set(
													ni,
													android.net.NetworkInfo.State.DISCONNECTED);
										} catch (Exception e) {
										}
									} else {
										try {
											Field mState = NetworkInfo.class
													.getDeclaredField("mState");
											mState.setAccessible(true);
											mState.set(
													ni,
													android.net.NetworkInfo.State.CONNECTED);
										} catch (Exception e) {
										}
									}
								}
								param.setResult(ni);
							}
						}
					});

			findAndHookMethod("android.net.ConnectivityManager",
					paramLoadPackageParam.classLoader, "getMobileDataEnabled",
					new XC_MethodHook() {
						@Override
						protected void afterHookedMethod(MethodHookParam param)
								throws Throwable {
							Util.XLog(param);
							param.setResult(true);
							// if (!isMomo) {
							// if (fakeConn)
							// param.setResult(true);
							// else param.setResult(false);
							// }
						}
					});

			findAndHookMethod("android.net.ConnectivityManager",
					paramLoadPackageParam.classLoader, "getAllNetworkInfo",
					new XC_MethodHook() {
						@Override
						protected void afterHookedMethod(MethodHookParam param)
								throws Throwable {
							Util.XLog(param);
							// param.setResult(new NetworkInfo[0]); //此API不准试用
						}
					});

		} catch (Exception e) {
			XposedBridge.log("错误:FakeNetWork-----------------------");
		}
	}
}
