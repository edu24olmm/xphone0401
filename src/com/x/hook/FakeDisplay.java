package com.x.hook;

import android.content.res.Resources;
import android.util.DisplayMetrics;
import android.view.Display;

import com.x.app.App;
import com.x.phone.PhoneInfo;

import de.robv.android.xposed.IXposedHookLoadPackage;
import de.robv.android.xposed.XC_MethodHook;
import de.robv.android.xposed.XposedBridge;
import de.robv.android.xposed.XposedHelpers;
import de.robv.android.xposed.callbacks.XC_LoadPackage.LoadPackageParam;


public class FakeDisplay implements IXposedHookLoadPackage {

	static PhoneInfo info; 

	@Override
	public void handleLoadPackage(final LoadPackageParam paramLoadPackageParam)
			throws Throwable {
		info = PhoneInfo.GetNow();
		if (!App.IsInShuaLib(paramLoadPackageParam.packageName)) {
			if ("com.umeng.example".equals(paramLoadPackageParam.packageName)) {
				XposedBridge.log("NOT Shua FakeDisp：" + paramLoadPackageParam.packageName);
			}else {
				return;
			}
		}
		if(paramLoadPackageParam.packageName.contains("immomo"))
			return;
		// 更改分辨率
		try {
			XposedHelpers.findAndHookMethod(Resources.class,
					"getDisplayMetrics", new Object[] { new XC_MethodHook() {
						@Override
						protected void afterHookedMethod(MethodHookParam param)
								throws Throwable {
							int dh = 0;
							int dw = 0;
							try {
								dh = info.Height;
								dw = info.Width;
							} catch (Exception e) {
								return;
							}
							try {
								XposedHelpers.setIntField(param.getResult(),
										"heightPixels", dh);
								XposedHelpers.setIntField(param.getResult(),
										"widthPixels", dw);

								// XposedHelpers.setFloatField(param.getResult(),
								// "density", info.Density);
								// XposedHelpers.setIntField(param.getResult(),
								// "densityDpi", (int)info.DensityDPI);
								// XposedHelpers.setFloatField(param.getResult(),
								// "scaledDensity", info.ScaleDensity);
								// XposedHelpers.setFloatField(param.getResult(),
								// "xdpi", info.Xdpi);
								// XposedHelpers.setFloatField(param.getResult(),
								// "ydpi", info.Ydpi);
							} catch (Exception e) {
								XposedBridge.log("分辨率出错误:60   "
										+ e.getMessage());
							}
						}
					} });

			XposedHelpers.findAndHookMethod(Display.class, "getMetrics",
					new Object[] { DisplayMetrics.class, new XC_MethodHook() {
						@Override
						protected void afterHookedMethod(MethodHookParam param)
								throws Throwable {
							int dh = 0;
							int dw = 0;
							try {
								dh = info.Height;
								dw = info.Width;
							} catch (Exception e) {
								return;
							}
							if (param.args.length > 0
									&& param.args[0] instanceof DisplayMetrics) {
								try {
									XposedHelpers.setIntField(param.args[0],
											"heightPixels", dh);
									XposedHelpers.setIntField(param.args[0],
											"widthPixels", dw);

									// XposedHelpers.setFloatField(param.args[0],
									// "density", info.Density);
									// XposedHelpers.setIntField(param.args[0],
									// "densityDpi", (int)info.DensityDPI);
									// XposedHelpers.setFloatField(param.args[0],
									// "scaledDensity", info.ScaleDensity);
									// XposedHelpers.setFloatField(param.args[0],
									// "xdpi", info.Xdpi);
									// XposedHelpers.setFloatField(param.args[0],
									// "ydpi", info.Ydpi);
								} catch (Exception e) {
									XposedBridge.log("分辨率出错误:93   "
											+ e.getMessage());
								}
							}
						}
					} });
			XposedHelpers.findAndHookMethod(Display.class, "getHeight",
					new Object[] { new XC_MethodHook() {
						@Override
						protected void beforeHookedMethod(MethodHookParam param)
								throws Throwable {
							int dh = 0;
							try {
								dh = info.Height;
							} catch (Exception e) {
								return;
							}
							param.setResult(dh);
						}
					} });
			XposedHelpers.findAndHookMethod(Display.class, "getWidth",
					new Object[] { new XC_MethodHook() {
						@Override
						protected void beforeHookedMethod(MethodHookParam param)
								throws Throwable {
							int dw = 0;
							try {
								dw = info.Width;
							} catch (Exception e) {
								return;
							}
							param.setResult(dw);
						}
					} });
		} catch (Throwable t) {
			XposedBridge.log("错误:FakeDisplay--，信息：" + t.getMessage());		
		}
	}

}
