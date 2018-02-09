/**
 * 
 */
package com.x;

import android.app.AndroidAppHelper;
import android.content.Context;
import android.location.Location;
import android.location.LocationListener;
import de.robv.android.xposed.*;
import de.robv.android.xposed.callbacks.XC_LoadPackage.LoadPackageParam;

import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Random;
import java.util.Set;

import static de.robv.android.xposed.XposedHelpers.findClass;

/**
 * @author MyPC
 * 
 */
public class LocationHook implements IXposedHookLoadPackage,
		IXposedHookZygoteInit {

	private boolean mLocationManagerHooked = false;
	// private GPSFake mInstance = this;
	private String mApp = "";
	private HashMap<Method, XC_MethodHook> mHook = new HashMap<Method, XC_MethodHook>();
	private double pi = 3.14159265359;
	private double newlat = 22.318344;
	private double newlng = 114.168655;
	private Random rand = new Random();
	private final double earth = (double) 6378137.0;
	// private static Settings settings = new Settings();

	private static com.x.utils.LocationUtil loc = com.x.utils.LocationUtil.getNew();

	@Override
	public void handleLoadPackage(LoadPackageParam lpparam) throws Throwable {
		
	}
	@Override
	public void initZygote(StartupParam startupParam) throws Throwable {
		hookSystemService("android.app.ContextImpl");
		hookSystemService("android.app.Activity");
	}

	private void updateLocation() {
		double x = (double) (rand.nextInt(50) - 25);
		double y = (double) (rand.nextInt(50) - 25);
		double dlat = x / earth;
//		double dlng = y / (earth * Math.cos(pi * loc.Latitude / 180.0));
//		newlat = loc.Latitude + (dlat * 180.0 / pi);
//		newlng = loc.Longitude + (dlng * 180.0 / pi);
	}

	private void handleGetSystemService(String name, Object instance) {
		if (name.equals(Context.LOCATION_SERVICE)) {
			if (!mLocationManagerHooked) {
				String packageName = AndroidAppHelper.currentPackageName();
				// XposedBridge.log("Hook Location Manager " + packageName +
				// " " + instance.getClass().getName());
				try {
					Class<?> hookClass = null;
					hookClass = findClass(instance.getClass().getName(), null);
					if (hookClass == null)
						throw new ClassNotFoundException(instance.getClass()
								.getName());

					XC_MethodHook methodHook = new XC_MethodHook() {
						@Override
						protected void beforeHookedMethod(MethodHookParam param)
								throws Throwable {
							// settings.reload();
							if (param.method.getName().equals(
									"onProviderDisabled")) {
								// if (settings.isStarted())
								// param.setResult(null);
								param.setResult(null);
							}
						}

						@Override
						protected void afterHookedMethod(MethodHookParam param)
								throws Throwable {
							// settings.reload();
							if (!param.hasThrowable())
								try {
									// if (settings.isStarted()) {
									// XposedBridge.log("sLocation Manager Hook Method : "
									// + param.method.getName());
									if (true) {

										if (param.method.getName().equals(
												"getTime")) {
											// XposedBridge.log("Location Manager getTime "
											// + param.getResult());
											param.setResult(new Long(System
													.currentTimeMillis()));
										}
										if (param.method.getName().equals(
												"getLatitude")) {
											XposedBridge
													.log("Location Manager getLatitude "
															+ newlat
															+ " "
															+ newlng);
											// param.setResult(new
											// Double(22.318344));
											param.setResult(new Double(newlat));
										}
										if (param.method.getName().equals(
												"getLongitude")) {
											// param.setResult(new
											// Double(114.168655));
											param.setResult(new Double(newlng));
										}
										if (param.method.getName().equals(
												"getAccuracy")) {
											// XposedBridge.log("Location Manager getAccuracy "
											// + param.getResult());
										}
										if (param.args != null
												&& param.args.length == 1
												&& param.method.getName()
														.equals("set")) {
											// XposedBridge.log("Location Manager set "
											// + param.args[0]);
										}
									}
									if (param.args.length > 0
											&& param.args[0] != null) {
										if (param.args != null
												&& param.args.length == 1
												&& param.method
														.getName()
														.equals("isProviderEnabled")) {
											// XposedBridge.log("Location Manager isProviderEnabled : "
											// + param.args[0] + " " +
											// param.getResult());
											// if (settings.isStarted())
											param.setResult(new Boolean(true));
										}
										if (param.args != null
												&& param.args.length >= 1
												&& param.method
														.getName()
														.equals("requestLocationUpdates")) {
											for (int count = 0; count < param.args.length; count++) {
												// XposedBridge.log("Location Manager requestLocationUpdates : "
												// + param.args[count]);
												if (param.args[count] instanceof LocationListener) {
													LocationListener ll = (LocationListener) param.args[count];

													try {
														Class<?> clazz = ll
																.getClass();
														for (Method method : clazz
																.getDeclaredMethods()) {
															int m = method
																	.getModifiers();
															if (method != null
																	&& Modifier
																			.isPublic(m)
																	&& !Modifier
																			.isStatic(m)) {
																if (!mHook
																		.containsKey(method)) {
																	mHook.put(
																			method,
																			this);
																	// XposedBridge.log("Location Manager Listener "
																	// +
																	// method.getName());
																	XposedBridge
																			.hookMethod(
																					method,
																					this);
																	// if
																	// (settings.isStarted())
																	// {
																	if (true) {
																		Location l = new Location(
																				"network");
																		updateLocation();
																		XposedBridge
																				.log("Location Manager New Loc : "
																						+ newlat
																						+ " "
																						+ newlng);
																		l.setTime(new Long(
																				System.currentTimeMillis()));
																		l.setLatitude(newlat);
																		l.setLongitude(newlng);
																		l.setAccuracy((float) 20.0);
																		XposedHelpers
																				.callMethod(
																						ll,
																						"onLocationChanged",
																						l);
																	}
																}
															}
														}
													} catch (Exception ex) {
													}
												}
											}
										}
										if (param.args != null
												&& param.args.length == 1
												&& param.method
														.getName()
														.equals("onLocationChanged")) {
											if (param.args[0] instanceof Location) {
												Location ll = (Location) param.args[0];
												try {
													Class<?> clazz = ll
															.getClass();
													for (Method method : clazz
															.getDeclaredMethods()) {
														int m = method
																.getModifiers();
														if (method != null
																&& Modifier
																		.isPublic(m)
																&& !Modifier
																		.isStatic(m)) {
															if (!mHook
																	.containsKey(method)) {
																mHook.put(
																		method,
																		this);
																// XposedBridge.log("Location Manager Listener "
																// +
																// method.getName());
																XposedBridge
																		.hookMethod(
																				method,
																				this);
															}
														}
													}
												} catch (Exception ex) {
												}
											}
										}
										if (param.method.getName().equals(
												"removeUpdates")) {
											Set<Method> mMethod = mHook
													.keySet();
											for (Method m : mMethod) {
												XposedBridge.unhookMethod(m,
														mHook.get(m));
											}
											mHook.clear();
										}
									}
								} catch (Throwable ex) {
									throw ex;
								}
						}
					};

					Class<?> clazz = hookClass;
					for (Method method : clazz.getDeclaredMethods()) {
						int m = method.getModifiers();
						if (method != null && Modifier.isPublic(m)
								&& !Modifier.isStatic(m)) {
							// XposedBridge.log("Location Manager Method Name "
							// + method.getName());
							XposedBridge.hookMethod(method, methodHook);
						}
					}

				} catch (Exception ex) {
				}
			}
			mLocationManagerHooked = true;
		}

	}

	private void hookSystemService(String context) {
		try {
			XC_MethodHook methodHook = new XC_MethodHook() {
				@Override
				protected void beforeHookedMethod(MethodHookParam param)
						throws Throwable {
				}

				@Override
				protected void afterHookedMethod(MethodHookParam param)
						throws Throwable {
					if (!param.hasThrowable())
						try {
							if (param.args.length > 0 && param.args[0] != null) {
								// XposedBridge.log("Hook Method : " + mInstance
								// + " " + mApp + " " + packageName);
								String name = (String) param.args[0];
								Object instance = param.getResult();
								if (name != null && instance != null) {
									handleGetSystemService(name, instance);
								}
							}
						} catch (Throwable ex) {
							throw ex;
						}
				}
			};

			Set<XC_MethodHook.Unhook> hookSet = new HashSet<XC_MethodHook.Unhook>();

			Class<?> hookClass = null;
			try {
				hookClass = findClass(context, null);
				if (hookClass == null)
					throw new ClassNotFoundException(context);
				// XposedBridge.log("Zygote Context Find Class Done");
			} catch (Exception ex) {
				// XposedBridge.log("Zygote Context Impl Exception " + ex);
			}

			// XposedBridge.log("Zygote Context Find Class " + hookClass);
			Class<?> clazz = hookClass;
			while (clazz != null) {
				for (Method method : clazz.getDeclaredMethods()) {
					if (method != null
							&& method.getName().equals("getSystemService")) {
						hookSet.add(XposedBridge.hookMethod(method, methodHook));
					}
				}
				clazz = (hookSet.isEmpty() ? clazz.getSuperclass() : null);
			}
		} catch (Exception ex) {
			// XposedBridge.log("Zygote Context Hook Exception " + ex);
		}
	}



}
