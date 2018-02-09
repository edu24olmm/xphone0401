package com.x.hook;

import static de.robv.android.xposed.XposedHelpers.findAndHookMethod;
import static de.robv.android.xposed.XposedHelpers.findConstructorExact;

import java.lang.reflect.Constructor;

import com.x.app.App;
import com.x.phone.PhoneInfo;

import android.content.Context;
import android.webkit.WebView;
import de.robv.android.xposed.IXposedHookLoadPackage;
import de.robv.android.xposed.XC_MethodHook;
import de.robv.android.xposed.XposedBridge;
import de.robv.android.xposed.XposedHelpers;
import de.robv.android.xposed.callbacks.XC_LoadPackage.LoadPackageParam;

/**
 * �޸�websetting ��webview
 */

public class FakeWebSetting implements IXposedHookLoadPackage {
	static PhoneInfo info; // ��ǰ���ֻ��ͺ�
	static String UA; // ��ǰ�������UA

	@Override
	public void handleLoadPackage(final LoadPackageParam paramLoadPackageParam)
			throws Throwable {
		// TODO �Զ����ɵķ������
		info = PhoneInfo.GetNow();
		if (!App.IsInShuaLib(paramLoadPackageParam.packageName))
			return;

		try {
			XposedHelpers.findAndHookMethod(android.webkit.WebSettings.class,
					"getDefaultUserAgent", Context.class, new XC_MethodHook() {
						@Override
						protected void afterHookedMethod(MethodHookParam param)
								throws Throwable {
							String ua = "Mozilla/5.0 (Linux; U; Android "
									+ info.RELEASE
									+ "; zh-cn; "
									+ info.MODEL
									+ " Build/"
									+ info.ID
									+ ") AppleWebKit/537.36 (KHTML, like Gecko) Version/4.0 Mobile Safari/537.36";
							param.setResult(ua);
						}
					});
		} catch (NoSuchMethodError n) {
			XposedBridge
					.log("����:NoSuchMethodError -FakeWebSetting-WebSettings-getDefaultUserAgent����Ϣ��"
							+ n.getMessage());
		} catch (Exception e) {
			XposedBridge
					.log("����:FakeWebSetting-WebSettings-getDefaultUserAgent����Ϣ��"
							+ e.getMessage());
		}
		try {
			// XposedHelpers.findAndHookMethod(android.webkit.WebSettings.class,
			// "getUserAgent", new XC_MethodHook() {
			// @Override
			// protected void afterHookedMethod(MethodHookParam param)
			// throws Throwable {
			// String ua = "Mozilla/5.0 (Linux; U; Android "
			// + info.RELEASE
			// + "; zh-cn; "
			// + info.MODEL
			// + " Build/"
			// + info.ID
			// +
			// ") AppleWebKit/537.36 (KHTML, like Gecko) Version/4.0 Mobile Safari/537.36";
			// param.setResult(ua);
			// }
			// });

			findAndHookMethod("android.webkit.WebSettings",
					paramLoadPackageParam.classLoader, "setUserAgentString",
					String.class, new XC_MethodHook() {
						@Override
						protected void beforeHookedMethod(MethodHookParam param)
								throws Throwable {
							if (param.args.length > 0) {
								UA = (String) param.args[0];
							}
						}
					});
		} catch (Exception e) {
			XposedBridge
					.log("����:FakeWebSetting--WebSettings.setUserAgentString����Ϣ��"
							+ e.getMessage());
		}
		try {
			XposedHelpers.findAndHookMethod(android.webkit.WebSettings.class,
					"getUserAgentString", new XC_MethodHook() {
						@Override
						protected void afterHookedMethod(MethodHookParam param)
								throws Throwable {
							if (UA == null || UA.equals("")) {
								UA = "Mozilla/5.0 (Linux; U; Android "
										+ info.RELEASE
										+ "; zh-cn; "
										+ info.MODEL
										+ " Build/"
										+ info.ID
										+ ") AppleWebKit/537.36 (KHTML, like Gecko) Version/4.0 Mobile Safari/537.36";
							}
							param.setResult(UA);
						}
					});
		} catch (Exception e) {
			XposedBridge
					.log("����:FakeWebSetting--WebSettings��getUserAgentString.��Ϣ��"
							+ e.getMessage());
		}
		try {
			Constructor<?> webview = findConstructorExact(
					android.webkit.WebView.class, Context.class);
			XposedBridge.hookMethod(webview, new XC_MethodHook() {
				@Override
				protected void afterHookedMethod(MethodHookParam param)
						throws Throwable {
					if (param.args.length > 0
							&& param.thisObject instanceof WebView) {
						if (UA == null || UA.equals("")) {
							UA = "Mozilla/5.0 (Linux; U; Android "
									+ info.RELEASE
									+ "; zh-cn; "
									+ info.MODEL
									+ " Build/"
									+ info.ID
									+ ") AppleWebKit/537.36 (KHTML, like Gecko) Version/4.0 Mobile Safari/537.36";
						}
						WebView webView = (WebView) param.thisObject;
						if (webView.getSettings() != null)
							webView.getSettings().setUserAgentString(UA);
					}
				}
			});
		} catch (Exception e) {
			XposedBridge.log("����:FakeWebSetting--WebView����Ϣ��" + e.getMessage());
		}
	}
}