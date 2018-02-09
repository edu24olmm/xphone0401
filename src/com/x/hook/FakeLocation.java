package com.x.hook;

import static de.robv.android.xposed.XposedHelpers.findAndHookMethod;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.WeakHashMap;

import android.app.AndroidAppHelper;
import android.app.PendingIntent;
import android.content.Context;
import android.location.Criteria;
import android.location.GpsSatellite;
import android.location.GpsStatus;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Binder;
import android.os.Bundle;
import android.os.IInterface;
import android.os.Looper;
import android.util.Log;
import com.x.app.App;
import com.x.phone.PhoneInfo;
import com.x.utils.LocationUtil;
import de.robv.android.xposed.IXposedHookLoadPackage;
import de.robv.android.xposed.XC_MethodHook;
import de.robv.android.xposed.XposedBridge;
import de.robv.android.xposed.XC_MethodHook.MethodHookParam;
import de.robv.android.xposed.XposedHelpers;
import de.robv.android.xposed.callbacks.XC_LoadPackage;
import de.robv.android.xposed.callbacks.XC_LoadPackage.LoadPackageParam;

public class FakeLocation implements IXposedHookLoadPackage {

	static final Map<Object, Object> mMapProxy = new WeakHashMap<Object, Object>();
	static Context context;
	static PhoneInfo info;

	public void handleLoadPackage(final XC_LoadPackage.LoadPackageParam paramLoadPackageParam) {
		info = PhoneInfo.GetNow(); // 获取到当前的手机型号
		if (info == null)
			return; // 如果获取不到手机，就不修改

		if (!App.IsInShuaLib(paramLoadPackageParam.packageName)) {
			if ("com.umeng.example".equals(paramLoadPackageParam.packageName)) {
				XposedBridge.log("NOT Shua FakeLoca：" + paramLoadPackageParam.packageName);
			} else {
				return;
			}
		}
		// initContext(paramLoadPackageParam);
		initLocation(paramLoadPackageParam); // 修改地理位置
	}

	private void initContext(final LoadPackageParam paramLoadPackageParam) {
		try {
			XposedHelpers.findAndHookMethod(android.app.Application.class, "onCreate", new Object[] { new XC_MethodHook() {
				@Override
				protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
					if (context == null) {
						try {
							context = (Context) param.thisObject;
							// ServiceUtil.startMockGpsService(context);
							XposedBridge.log("服务已经启动");
							Log.i("GPS问题：", "MOCKGps已经启动");
						} catch (Exception e) {
							// e.getMessage();
							Log.i("GPS问题：", "MOCKGps启动出错" + e.getMessage());
							XposedBridge.log("启动服务出错了：" + e.getMessage());
						}
					}
				}
			} });
		} catch (Exception e) {
			XposedBridge.log("错误:onCreate，信息：" + e.getMessage());
		}
		if (context == null) {
			try {
				XposedHelpers.findAndHookMethod(android.content.ContextWrapper.class, "getApplicationContext", new Object[] { new XC_MethodHook() {
					@Override
					protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
						if (context == null)
							context = (Context) param.getResult();
						// ServiceUtil.startMockGpsService(context);
					}
				} });
			} catch (Exception e) {
				XposedBridge.log("错误:FakeLocation-----------------------");
			}
		}
		if (context == null) {
			try {
				XposedHelpers.findAndHookMethod(android.app.Activity.class, "getSystemService", String.class, new Object[] { new XC_MethodHook() {
					@Override
					protected void afterHookedMethod(MethodHookParam param) throws Throwable {
						if (context == null)
							context = (Context) param.thisObject;
						// ServiceUtil.startMockGpsService(context);
					}
				} });
			} catch (Exception e) {
				XposedBridge.log("FakeLocation-----------------");
			}
		}
		if (context == null) {
			try {
				context = AndroidAppHelper.currentApplication();
			} catch (Exception e) {
				XposedBridge.log("错误:FakeLocation-----------------------");
			}
		}
	}

	private void initLocation_bak(final LoadPackageParam paramLoadPackageParam) {
		// android.location.LocationManager
		try {

			findAndHookMethod("android.location.LocationManager", null, "removeUpdates", LocationListener.class, new XC_MethodHook() {
				@Override
				protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
					unproxyLocationListener(param, 0, true); // 取消代理
				}
			});
			findAndHookMethod("android.location.LocationManager", null, "removeUpdates", PendingIntent.class, new XC_MethodHook() {
				@Override
				protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
					unproxyLocationListener(param, 0, true); // 取消代理
				}
			});

			// [start] requestLocationUpdates的几个重载函数

			XC_MethodHook requestLocationUpdatesHook = new XC_MethodHook() {
				@Override
				protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
					if (param.args.length > 3 && param.args[0] instanceof String && param.args[1] instanceof Long && param.args[2] instanceof Float) {
						if (!param.args[0].equals("mockGps")) {
							XposedBridge.log("请求，Provider：" + param.args[0].toString());
							param.args[0] = "mockGps"; // 将gps修改为
							param.args[2] = 0.0f;
						}
					} else {
						// proxyLocationListener(param, 3,
						// LocationListener.class);
						// XposedBridge.log("1请求requestLocationUpdates，Provider："+param.args[0].toString());
					}
				}
			};

			findAndHookMethod("android.location.LocationManager", null, "requestLocationUpdates", String.class, long.class, float.class, LocationListener.class, requestLocationUpdatesHook);
			findAndHookMethod("android.location.LocationManager", null, "requestLocationUpdates", String.class, long.class, float.class, LocationListener.class, Looper.class,
					requestLocationUpdatesHook);
			findAndHookMethod("android.location.LocationManager", null, "requestLocationUpdates", long.class, float.class, Criteria.class, LocationListener.class, Looper.class,
					requestLocationUpdatesHook);
			findAndHookMethod("android.location.LocationManager", null, "requestLocationUpdates", String.class, long.class, float.class, PendingIntent.class, requestLocationUpdatesHook);

			findAndHookMethod("android.location.LocationManager", null, "requestLocationUpdates", long.class, float.class, Criteria.class, PendingIntent.class, requestLocationUpdatesHook);
			findAndHookMethod("android.location.LocationManager", null, "requestLocationUpdates", long.class, float.class, Criteria.class, PendingIntent.class, requestLocationUpdatesHook);

			// [end]

			// [start] requestSingleUpdate的几个重载函数
			XC_MethodHook requestSingleUpdateHook = new XC_MethodHook() {
				@Override
				protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
					if (param.args.length > 0 && param.args[0] instanceof String) {
						param.args[0] = "mockGps";
					}
				}
			};

			findAndHookMethod("android.location.LocationManager", null, "requestSingleUpdate", String.class, LocationListener.class, Looper.class, requestSingleUpdateHook);

			findAndHookMethod("android.location.LocationManager", null, "requestSingleUpdate", Criteria.class, LocationListener.class, Looper.class, requestSingleUpdateHook);
			findAndHookMethod("android.location.LocationManager", null, "requestSingleUpdate", String.class, PendingIntent.class, requestSingleUpdateHook);
			findAndHookMethod("android.location.LocationManager", null, "requestSingleUpdate", Criteria.class, PendingIntent.class, requestSingleUpdateHook);
			// [end]

			// LocationManager ,after
			findAndHookMethod("android.location.LocationManager", null, "getAllProviders", new XC_MethodHook() {
				@Override
				protected void afterHookedMethod(MethodHookParam param) throws Throwable {
					List<String> aa = new ArrayList<String>();
					aa.add(LocationManager.GPS_PROVIDER);
				}
			});
			findAndHookMethod("android.location.LocationManager", null, "getLastKnownLocation", String.class, new XC_MethodHook() {
				@Override
				protected void afterHookedMethod(MethodHookParam param) throws Throwable {
					// 改变经纬度
					Location loc = (Location) param.getResult();
					if (loc != null) {
						loc.setLatitude(info.Lat);
						loc.setAltitude(info.Alt);
						loc.setLongitude(info.Lon);
						param.setResult(loc);
					}
				}
			});

			findAndHookMethod("android.location.LocationManager", null, "getGpsStatus", GpsStatus.class, new XC_MethodHook() {
				@Override
				protected void afterHookedMethod(MethodHookParam param) throws Throwable {
					if (param.getResult() instanceof GpsStatus) {
						android.location.GpsStatus status = (GpsStatus) param.getResult();
						try {
							Field mSatellites = status.getClass().getDeclaredField("mSatellites");
							mSatellites.setAccessible(true);
							mSatellites.set(status, new GpsSatellite[0]);
						} catch (Throwable ex) {
						}
					}
				}
			});

			findAndHookMethod("android.location.LocationManager", null, "isProviderEnabled", String.class, new XC_MethodHook() {
				@Override
				protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
					if (param.args.length > 0) {
						String provider = (String) param.args[0];
						if (provider.equals(LocationManager.GPS_PROVIDER)) {
							param.setResult(true);
						} else {
							param.setResult(false);
						}
						return;
					}
				}
			});

		} catch (Exception e) {
			XposedBridge.log("错误:FakeLocation--LocationManager，信息：" + e.getMessage());
		}

		// LocationManagerService

		try {
			findAndHookMethod("com.android.server.LocationManagerService", null, "removeUpdates", "android.location.ILocationListener", PendingIntent.class, String.class, new XC_MethodHook() {
				@Override
				protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
					if (param.args.length > 1) {
						if (param.args[0] != null) // ILocationListener
							unproxyLocationListener(param, 0, false);
						else if (param.args[1] != null) // PendingIntent
							param.setResult(null);
					}
				}
			});
		} catch (Exception e) {
			XposedBridge.log("错误:FakeLocation--LocationManagerService，信息：" + e.getMessage());
		}
		try {
			findAndHookMethod("com.android.server.LocationManagerService", null, "requestLocationUpdates", "android.location.LocationRequest", "android.location.ILocationListener",
					PendingIntent.class, String.class, new XC_MethodHook() {
						@Override
						protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
							if (param.args[0] != null)
								try {
									Method setProvider = (Class.forName("android.location.LocationRequest")).getDeclaredMethod("setProvider", String.class);
									setProvider.setAccessible(true);
									setProvider.invoke((Class.forName("android.location.LocationRequest")).cast(param.args[0]), "mockGps");
								} catch (Exception e) {
									XposedBridge.log("错误：LocationManagerService.requestLocationUpdates");
								}
						}
					});

			// LocationManagerService after
			findAndHookMethod("com.android.server.LocationManagerService", null, "getLastLocation", "android.location.LocationRequest", String.class, new XC_MethodHook() {
				@Override
				protected void afterHookedMethod(MethodHookParam param) throws Throwable {
					// 改变经纬度
					Location location = (Location) param.getResult();
					param.setResult(LocationUtil.GetRandomLocation(location));
				}
			});

			findAndHookMethod("com.android.server.LocationManagerService", null, "isProviderEnabled", String.class, new XC_MethodHook() {
				@Override
				protected void afterHookedMethod(MethodHookParam param) throws Throwable {
					if (param.args.length > 0) {
						String provider = (String) param.args[0];
						if (provider.equals(LocationManager.GPS_PROVIDER))
							param.setResult(true);
						else
							param.setResult(false);

					}
				}
			});

			findAndHookMethod("com.android.server.LocationManagerService", null, "sendExtraCommand", String.class, String.class, Bundle.class, new XC_MethodHook() {
				@Override
				protected void afterHookedMethod(MethodHookParam param) throws Throwable {
					if (param.args.length > 0) {
						// String provider = (String) param.args[0];
						param.setResult(false);
					}
				}
			});
			findAndHookMethod("com.android.server.LocationManagerService", null, "getProviders", Criteria.class, boolean.class, new XC_MethodHook() {
				@Override
				protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
					List<String> list = new ArrayList<String>();
					list.add(LocationManager.GPS_PROVIDER);
					param.setResult(list);
				}
			});

			findAndHookMethod("com.android.server.LocationManagerService", null, "getBestProvider", Criteria.class, boolean.class, new XC_MethodHook() {
				@Override
				protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
					param.setResult(LocationManager.GPS_PROVIDER);
				}
			});

		} catch (Exception e) {
			XposedBridge.log("错误:FakeLocation--LocationManagerService，信息：" + e.getMessage());
		}
	}

	@SuppressWarnings("unused")
	private void proxyLocationListener(MethodHookParam param, int arg, Class<?> interfaze, boolean client) throws Throwable {
		if (param.args.length > arg)
			if (param.args[arg] instanceof PendingIntent)
				param.setResult(null);

			else if (param.args[arg] != null && param.thisObject != null) {
				if (client) {
					Object key = param.args[arg];
					synchronized (mMapProxy) {
						// Reuse existing proxy
						if (mMapProxy.containsKey(key)) {
							param.args[arg] = mMapProxy.get(key);
							return;
						}

						// Already proxied
						if (mMapProxy.containsValue(key)) {
							return;
						}
					}

					// Create proxy
					Object proxy = new ProxyLocationListener(Binder.getCallingUid(), (LocationListener) param.args[arg]);

					// Use proxy
					synchronized (mMapProxy) {
						mMapProxy.put(key, proxy);
					}
					param.args[arg] = proxy;
				} else {
					// Create proxy
					ClassLoader cl = param.thisObject.getClass().getClassLoader();
					InvocationHandler ih = new OnLocationChangedHandler(Binder.getCallingUid(), param.args[arg]);
					Object proxy = Proxy.newProxyInstance(cl, new Class<?>[] { interfaze }, ih);

					Object key = param.args[arg];
					if (key instanceof IInterface)
						key = ((IInterface) key).asBinder();

					// Use proxy
					synchronized (mMapProxy) {
						mMapProxy.put(key, proxy);
					}
					param.args[arg] = proxy;
				}
			}
	}

	private void unproxyLocationListener(MethodHookParam param, int arg, boolean client) {
		if (param.args.length > arg)
			if (param.args[arg] instanceof PendingIntent)
				param.setResult(null);

			else if (param.args[arg] != null) {
				if (client) {
					Object key = param.args[arg];
					synchronized (mMapProxy) {
						if (mMapProxy.containsKey(key)) {
							param.args[arg] = mMapProxy.get(key);
						}
					}
				} else {
					Object key = param.args[arg];
					if (key instanceof IInterface)
						key = ((IInterface) key).asBinder();

					synchronized (mMapProxy) {
						if (mMapProxy.containsKey(key))
							param.args[arg] = mMapProxy.get(key);
					}
				}
			}
	}

	private class OnLocationChangedHandler implements InvocationHandler {
		private int mUid;
		private Object mTarget;

		public OnLocationChangedHandler(int uid, Object target) {
			mUid = uid;
			mTarget = target;
		}

		public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
			if ("onLocationChanged".equals(method.getName()))
				args[0] = LocationUtil.GetRandomLocation((Location) args[0]);
			return method.invoke(mTarget, args);
		}
	}

	private static class ProxyLocationListener implements LocationListener {
		private int mUid;
		private LocationListener mListener;

		public ProxyLocationListener(int uid, LocationListener listener) {
			mUid = uid;
			mListener = listener;
		}

		@Override
		public void onLocationChanged(Location location) {
			Location fakeLocation = LocationUtil.GetRandomLocation(location);
			mListener.onLocationChanged(fakeLocation);
		}

		@Override
		public void onProviderDisabled(String provider) {
			mListener.onProviderDisabled(provider);
		}

		@Override
		public void onProviderEnabled(String provider) {
			mListener.onProviderEnabled(provider);
		}

		@Override
		public void onStatusChanged(String provider, int status, Bundle extras) {
			mListener.onStatusChanged(provider, status, extras);
		}
	}

	// [end]

	public void initLocation(XC_LoadPackage.LoadPackageParam paramLoadPackageParam) {

		Log.i("FakeLocation", "initLocation.......XC_LoadPackage.LoadPackageParam paramLoadPackageParam...........");

		try {
			Object[] arrayOfObject9 = new Object[2];
			arrayOfObject9[0] = LocationListener.class;
			arrayOfObject9[1] = new XC_MethodHook() {
				protected void beforeHookedMethod(XC_MethodHook.MethodHookParam paramAnonymousMethodHookParam) throws Throwable {
					FakeLocation.this.unproxyLocationListener(paramAnonymousMethodHookParam, 0, true);
				}
			};
			XposedHelpers.findAndHookMethod("android.location.LocationManager", null, "removeUpdates", arrayOfObject9);
			Object[] arrayOfObject10 = new Object[2];
			arrayOfObject10[0] = PendingIntent.class;
			arrayOfObject10[1] = new XC_MethodHook() {
				protected void beforeHookedMethod(XC_MethodHook.MethodHookParam paramAnonymousMethodHookParam) throws Throwable {
					FakeLocation.this.unproxyLocationListener(paramAnonymousMethodHookParam, 0, true);
				}
			};
			XposedHelpers.findAndHookMethod("android.location.LocationManager", null, "removeUpdates", arrayOfObject10);
			Object[] arrayOfObject11 = new Object[5];
			arrayOfObject11[0] = String.class;
			arrayOfObject11[1] = Long.TYPE;
			arrayOfObject11[2] = Float.TYPE;
			arrayOfObject11[3] = LocationListener.class;
			arrayOfObject11[4] = new XC_MethodHook() {
				protected void beforeHookedMethod(XC_MethodHook.MethodHookParam paramAnonymousMethodHookParam) throws Throwable {
					if ((paramAnonymousMethodHookParam.args.length > 3) && ((paramAnonymousMethodHookParam.args[0] instanceof String)) && ((paramAnonymousMethodHookParam.args[1] instanceof Long))
							&& ((paramAnonymousMethodHookParam.args[2] instanceof Float)) && (!paramAnonymousMethodHookParam.args[0].equals("mockGps"))) {
						XposedBridge.log("1请求requestLocationUpdates，Provider：" + paramAnonymousMethodHookParam.args[0].toString());
						paramAnonymousMethodHookParam.args[0] = "mockGps";
						paramAnonymousMethodHookParam.args[2] = Float.valueOf(0.0F);
					}
				}
			};
			XposedHelpers.findAndHookMethod("android.location.LocationManager", null, "requestLocationUpdates", arrayOfObject11);
			Object[] arrayOfObject12 = new Object[6];
			arrayOfObject12[0] = String.class;
			arrayOfObject12[1] = Long.TYPE;
			arrayOfObject12[2] = Float.TYPE;
			arrayOfObject12[3] = LocationListener.class;
			arrayOfObject12[4] = Looper.class;
			arrayOfObject12[5] = new XC_MethodHook() {
				protected void beforeHookedMethod(XC_MethodHook.MethodHookParam paramAnonymousMethodHookParam) throws Throwable {
					if ((paramAnonymousMethodHookParam.args.length > 3) && ((paramAnonymousMethodHookParam.args[0] instanceof String)) && ((paramAnonymousMethodHookParam.args[1] instanceof Long))
							&& ((paramAnonymousMethodHookParam.args[2] instanceof Float)) && (!paramAnonymousMethodHookParam.args[0].equals("mockGps"))) {
						paramAnonymousMethodHookParam.args[0] = "mockGps";
						paramAnonymousMethodHookParam.args[2] = Float.valueOf(0.0F);
						XposedBridge.log("2请求requestLocationUpdates，Provider：" + paramAnonymousMethodHookParam.args[0].toString());
					}
				}
			};
			XposedHelpers.findAndHookMethod("android.location.LocationManager", null, "requestLocationUpdates", arrayOfObject12);
			Object[] arrayOfObject13 = new Object[6];
			arrayOfObject13[0] = Long.TYPE;
			arrayOfObject13[1] = Float.TYPE;
			arrayOfObject13[2] = Criteria.class;
			arrayOfObject13[3] = LocationListener.class;
			arrayOfObject13[4] = Looper.class;
			arrayOfObject13[5] = new XC_MethodHook() {
				protected void beforeHookedMethod(XC_MethodHook.MethodHookParam paramAnonymousMethodHookParam) throws Throwable {
					if ((paramAnonymousMethodHookParam.args.length > 3) && ((paramAnonymousMethodHookParam.args[0] instanceof String)) && ((paramAnonymousMethodHookParam.args[1] instanceof Long))
							&& ((paramAnonymousMethodHookParam.args[2] instanceof Float)) && (!paramAnonymousMethodHookParam.args[0].equals("mockGps"))) {
						paramAnonymousMethodHookParam.args[0] = "mockGps";
						paramAnonymousMethodHookParam.args[2] = Float.valueOf(0.0F);
						XposedBridge.log("3请求requestLocationUpdates，Provider：" + paramAnonymousMethodHookParam.args[0].toString());
					}
				}
			};
			XposedHelpers.findAndHookMethod("android.location.LocationManager", null, "requestLocationUpdates", arrayOfObject13);
			Object[] arrayOfObject14 = new Object[5];
			arrayOfObject14[0] = String.class;
			arrayOfObject14[1] = Long.TYPE;
			arrayOfObject14[2] = Float.TYPE;
			arrayOfObject14[3] = PendingIntent.class;
			arrayOfObject14[4] = new XC_MethodHook() {
				protected void beforeHookedMethod(XC_MethodHook.MethodHookParam paramAnonymousMethodHookParam) throws Throwable {
					if ((paramAnonymousMethodHookParam.args.length > 3) && ((paramAnonymousMethodHookParam.args[0] instanceof String)) && ((paramAnonymousMethodHookParam.args[1] instanceof Long))
							&& ((paramAnonymousMethodHookParam.args[2] instanceof Float)) && (!paramAnonymousMethodHookParam.args[0].equals("mockGps"))) {
						paramAnonymousMethodHookParam.args[0] = "mockGps";
						paramAnonymousMethodHookParam.args[2] = Float.valueOf(0.0F);
						XposedBridge.log("4请求requestLocationUpdates，Provider：" + paramAnonymousMethodHookParam.args[0].toString());
					}
				}
			};
			XposedHelpers.findAndHookMethod("android.location.LocationManager", null, "requestLocationUpdates", arrayOfObject14);
			Object[] arrayOfObject15 = new Object[5];
			arrayOfObject15[0] = Long.TYPE;
			arrayOfObject15[1] = Float.TYPE;
			arrayOfObject15[2] = Criteria.class;
			arrayOfObject15[3] = PendingIntent.class;
			arrayOfObject15[4] = new XC_MethodHook() {
				protected void beforeHookedMethod(XC_MethodHook.MethodHookParam paramAnonymousMethodHookParam) throws Throwable {
					if ((paramAnonymousMethodHookParam.args.length > 3) && ((paramAnonymousMethodHookParam.args[0] instanceof String)) && ((paramAnonymousMethodHookParam.args[1] instanceof Long))
							&& ((paramAnonymousMethodHookParam.args[2] instanceof Float)) && (!paramAnonymousMethodHookParam.args[0].equals("mockGps"))) {
						paramAnonymousMethodHookParam.args[0] = "mockGps";
						paramAnonymousMethodHookParam.args[2] = Float.valueOf(0.0F);
						XposedBridge.log("5请求requestLocationUpdates，Provider：" + paramAnonymousMethodHookParam.args[0].toString());
					}
				}
			};
			XposedHelpers.findAndHookMethod("android.location.LocationManager", null, "requestLocationUpdates", arrayOfObject15);
			Object[] arrayOfObject16 = new Object[4];
			arrayOfObject16[0] = String.class;
			arrayOfObject16[1] = LocationListener.class;
			arrayOfObject16[2] = Looper.class;
			arrayOfObject16[3] = new XC_MethodHook() {
				protected void beforeHookedMethod(XC_MethodHook.MethodHookParam paramAnonymousMethodHookParam) throws Throwable {
					if ((paramAnonymousMethodHookParam.args.length > 0) && ((paramAnonymousMethodHookParam.args[0] instanceof String))) {
						paramAnonymousMethodHookParam.args[0] = "mockGps";
					}
				}
			};
			XposedHelpers.findAndHookMethod("android.location.LocationManager", null, "requestSingleUpdate", arrayOfObject16);
			Object[] arrayOfObject17 = new Object[4];
			arrayOfObject17[0] = Criteria.class;
			arrayOfObject17[1] = LocationListener.class;
			arrayOfObject17[2] = Looper.class;
			arrayOfObject17[3] = new XC_MethodHook() {
				protected void beforeHookedMethod(XC_MethodHook.MethodHookParam paramAnonymousMethodHookParam) throws Throwable {
					if ((paramAnonymousMethodHookParam.args.length > 0) && ((paramAnonymousMethodHookParam.args[0] instanceof String))) {
						paramAnonymousMethodHookParam.args[0] = "mockGps";
					}
				}
			};
			XposedHelpers.findAndHookMethod("android.location.LocationManager", null, "requestSingleUpdate", arrayOfObject17);
			Object[] arrayOfObject18 = new Object[3];
			arrayOfObject18[0] = String.class;
			arrayOfObject18[1] = PendingIntent.class;
			arrayOfObject18[2] = new XC_MethodHook() {
				protected void beforeHookedMethod(XC_MethodHook.MethodHookParam paramAnonymousMethodHookParam) throws Throwable {
					if ((paramAnonymousMethodHookParam.args.length > 0) && ((paramAnonymousMethodHookParam.args[0] instanceof String))) {
						paramAnonymousMethodHookParam.args[0] = "mockGps";
					}
				}
			};
			XposedHelpers.findAndHookMethod("android.location.LocationManager", null, "requestSingleUpdate", arrayOfObject18);
			Object[] arrayOfObject19 = new Object[3];
			arrayOfObject19[0] = Criteria.class;
			arrayOfObject19[1] = PendingIntent.class;
			arrayOfObject19[2] = new XC_MethodHook() {
				protected void beforeHookedMethod(XC_MethodHook.MethodHookParam paramAnonymousMethodHookParam) throws Throwable {
					if ((paramAnonymousMethodHookParam.args.length > 0) && ((paramAnonymousMethodHookParam.args[0] instanceof String))) {
						paramAnonymousMethodHookParam.args[0] = "mockGps";
					}
				}
			};
			XposedHelpers.findAndHookMethod("android.location.LocationManager", null, "requestSingleUpdate", arrayOfObject19);
			Object[] arrayOfObject20 = new Object[1];
			arrayOfObject20[0] = new XC_MethodHook() {
				protected void afterHookedMethod(XC_MethodHook.MethodHookParam paramAnonymousMethodHookParam) throws Throwable {
					new ArrayList().add("gps");
				}
			};
			XposedHelpers.findAndHookMethod("android.location.LocationManager", null, "getAllProviders", arrayOfObject20);
			Object[] arrayOfObject21 = new Object[2];
			arrayOfObject21[0] = String.class;
			arrayOfObject21[1] = new XC_MethodHook() {
				protected void afterHookedMethod(XC_MethodHook.MethodHookParam paramAnonymousMethodHookParam) throws Throwable {
					paramAnonymousMethodHookParam.setResult(LocationUtil.GetRandomLocation((Location) paramAnonymousMethodHookParam.getResult()));
				}
			};
			XposedHelpers.findAndHookMethod("android.location.LocationManager", null, "getLastKnownLocation", arrayOfObject21);
			Object[] arrayOfObject22 = new Object[2];
			arrayOfObject22[0] = GpsStatus.class;
			arrayOfObject22[1] = new XC_MethodHook() {
				protected void afterHookedMethod(XC_MethodHook.MethodHookParam paramAnonymousMethodHookParam) throws Throwable {
					GpsStatus localGpsStatus = null;
					if ((paramAnonymousMethodHookParam.getResult() instanceof GpsStatus)) {
						localGpsStatus = (GpsStatus) paramAnonymousMethodHookParam.getResult();
					}
					try {
						Field localField = localGpsStatus.getClass().getDeclaredField("mSatellites");
						localField.setAccessible(true);
						localField.set(localGpsStatus, new GpsSatellite[0]);
						return;
					} catch (Throwable localThrowable) {
					}
				}
			};

			XposedHelpers.findAndHookMethod("android.location.LocationManager", null, "getGpsStatus", arrayOfObject22);
			Object[] arrayOfObject23 = new Object[2];
			arrayOfObject23[0] = String.class;
			arrayOfObject23[1] = new XC_MethodHook() {
				protected void beforeHookedMethod(XC_MethodHook.MethodHookParam paramAnonymousMethodHookParam) throws Throwable {
					if (paramAnonymousMethodHookParam.args.length > 0) {
						String str = (String) paramAnonymousMethodHookParam.args[0];
						if ((str.equals("gps")) || (str.equals("mockGps"))) {
							paramAnonymousMethodHookParam.setResult(Boolean.valueOf(true));
						}
					} else {
						return;
					}
					paramAnonymousMethodHookParam.setResult(Boolean.valueOf(false));
				}
			};
			XposedHelpers.findAndHookMethod("android.location.LocationManager", null, "isProviderEnabled", arrayOfObject23);
		} catch (Exception localException1) {
			try {
				for (;;) {
					Object[] arrayOfObject8 = new Object[4];
					arrayOfObject8[0] = "android.location.ILocationListener";
					arrayOfObject8[1] = PendingIntent.class;
					arrayOfObject8[2] = String.class;
					arrayOfObject8[3] = new XC_MethodHook() {
						protected void beforeHookedMethod(XC_MethodHook.MethodHookParam paramAnonymousMethodHookParam) throws Throwable {
							if (paramAnonymousMethodHookParam.args.length > 1) {
								if (paramAnonymousMethodHookParam.args[0] == null) {
									// break label29;
								}
								FakeLocation.this.unproxyLocationListener(paramAnonymousMethodHookParam, 0, false);
							}
							while (paramAnonymousMethodHookParam.args[1] == null) {
								return;
							}
							paramAnonymousMethodHookParam.setResult(null);
						}
					};
					XposedHelpers.findAndHookMethod("com.android.server.LocationManagerService", null, "removeUpdates", arrayOfObject8);
					try {
						Object[] arrayOfObject1 = new Object[5];
						arrayOfObject1[0] = "android.location.LocationRequest";
						arrayOfObject1[1] = "android.location.ILocationListener";
						arrayOfObject1[2] = PendingIntent.class;
						arrayOfObject1[3] = String.class;
						arrayOfObject1[4] = new XC_MethodHook() {
							protected void beforeHookedMethod(XC_MethodHook.MethodHookParam paramAnonymousMethodHookParam) throws Throwable {
								if ((paramAnonymousMethodHookParam.args.length > 2) && (paramAnonymousMethodHookParam.args[0] != null)) {
								}
								try {
									Method localMethod = Class.forName("android.location.LocationRequest").getDeclaredMethod("setProvider", new Class[] { String.class });
									localMethod.setAccessible(true);
									localMethod.invoke(Class.forName("android.location.LocationRequest").cast(paramAnonymousMethodHookParam.args[0]), new Object[] { "mockGps" });
									return;
								} catch (Exception localException) {
								}
							}
						};
						XposedHelpers.findAndHookMethod("com.android.server.LocationManagerService", null, "requestLocationUpdates", arrayOfObject1);
						Object[] arrayOfObject2 = new Object[3];
						arrayOfObject2[0] = "android.location.LocationRequest";
						arrayOfObject2[1] = String.class;
						arrayOfObject2[2] = new XC_MethodHook() {
							protected void afterHookedMethod(XC_MethodHook.MethodHookParam paramAnonymousMethodHookParam) throws Throwable {
								paramAnonymousMethodHookParam.setResult(LocationUtil.GetRandomLocation((Location) paramAnonymousMethodHookParam.getResult()));
							}
						};
						XposedHelpers.findAndHookMethod("com.android.server.LocationManagerService", null, "getLastLocation", arrayOfObject2);
						Object[] arrayOfObject3 = new Object[2];
						arrayOfObject3[0] = String.class;
						arrayOfObject3[1] = new XC_MethodHook() {
							protected void beforeHookedMethod(XC_MethodHook.MethodHookParam paramAnonymousMethodHookParam) throws Throwable {
								if (paramAnonymousMethodHookParam.args.length > 0) {
									String str = (String) paramAnonymousMethodHookParam.args[0];
									if ((str.equals("gps")) || (str.equals("mockGps"))) {
										paramAnonymousMethodHookParam.setResult(Boolean.valueOf(true));
									}
								} else {
									return;
								}
								paramAnonymousMethodHookParam.setResult(Boolean.valueOf(false));
							}
						};
						XposedHelpers.findAndHookMethod("com.android.server.LocationManagerService", null, "isProviderEnabled", arrayOfObject3);
						Object[] arrayOfObject4 = new Object[4];
						arrayOfObject4[0] = String.class;
						arrayOfObject4[1] = String.class;
						arrayOfObject4[2] = Bundle.class;
						arrayOfObject4[3] = new XC_MethodHook() {
							protected void afterHookedMethod(XC_MethodHook.MethodHookParam paramAnonymousMethodHookParam) throws Throwable {
								if (paramAnonymousMethodHookParam.args.length > 0) {
									// ((String)paramAnonymousMethodHookParam.args[0]);
									paramAnonymousMethodHookParam.setResult(Boolean.valueOf(false));
								}
							}
						};
						XposedHelpers.findAndHookMethod("com.android.server.LocationManagerService", null, "sendExtraCommand", arrayOfObject4);
						Object[] arrayOfObject5 = new Object[3];
						arrayOfObject5[0] = Criteria.class;
						arrayOfObject5[1] = Boolean.TYPE;
						arrayOfObject5[2] = new XC_MethodHook() {
							protected void beforeHookedMethod(XC_MethodHook.MethodHookParam paramAnonymousMethodHookParam) throws Throwable {
								ArrayList localArrayList = new ArrayList();
								localArrayList.add("gps");
								paramAnonymousMethodHookParam.setResult(localArrayList);
							}
						};
						XposedHelpers.findAndHookMethod("com.android.server.LocationManagerService", null, "getProviders", arrayOfObject5);
						Object[] arrayOfObject6 = new Object[3];
						arrayOfObject6[0] = Criteria.class;
						arrayOfObject6[1] = Boolean.TYPE;
						arrayOfObject6[2] = new XC_MethodHook() {
							protected void beforeHookedMethod(XC_MethodHook.MethodHookParam paramAnonymousMethodHookParam) throws Throwable {
								paramAnonymousMethodHookParam.setResult("gps");
							}
						};
						XposedHelpers.findAndHookMethod("com.android.server.LocationManagerService", null, "getBestProvider", arrayOfObject6);
						Object[] arrayOfObject7 = new Object[3];
						arrayOfObject7[0] = "android.location.LocationRequest";
						arrayOfObject7[1] = String.class;
						arrayOfObject7[2] = new XC_MethodHook() {
							protected void beforeHookedMethod(XC_MethodHook.MethodHookParam paramAnonymousMethodHookParam) throws Throwable {
								paramAnonymousMethodHookParam.setResult(LocationUtil.GetRandomLocation((Location) paramAnonymousMethodHookParam.getResult()));
							}
						};
						XposedHelpers.findAndHookMethod("com.android.server.LocationManagerService", null, "getLastLocation", arrayOfObject7);
						return;
					} catch (Exception localException3) {
						XposedBridge.log("错误:FakeLocation--LocationManagerService，信息：" + localException3.getMessage());
					}
					localException1 = localException1;
					XposedBridge.log("错误:FakeLocation--LocationManager，信息：" + localException1.getMessage());
				}
			} catch (Exception localException2) {
				for (;;) {
					XposedBridge.log("错误:FakeLocation--LocationManagerService，信息：" + localException2.getMessage());
				}
			}
		}
	}

}