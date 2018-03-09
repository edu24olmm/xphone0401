package com.x.hook;

import android.content.ContentResolver;
import android.provider.Settings;
import android.text.TextUtils;
import android.util.Log;
import com.x.app.App;
import com.x.app.SettingDB;
import com.x.phone.PhoneInfo;
import com.x.utils.Util;
import de.robv.android.xposed.IXposedHookLoadPackage;
import de.robv.android.xposed.XC_MethodHook;
import de.robv.android.xposed.XposedBridge;
import de.robv.android.xposed.XposedHelpers;
import de.robv.android.xposed.callbacks.XC_LoadPackage.LoadPackageParam;

import static de.robv.android.xposed.XposedHelpers.findAndHookMethod;

public class FAkeSetting implements IXposedHookLoadPackage {

    static PhoneInfo info;

    @Override
    public void handleLoadPackage(final LoadPackageParam paramLoadPackageParam) throws Throwable {
        // TODO 自动生成的方法存根
        info = PhoneInfo.GetNow();
        if (!App.IsInShuaLib(paramLoadPackageParam.packageName)) {
            if ("com.umeng.example".equals(paramLoadPackageParam.packageName)) {
                XposedBridge.log("NOT Shua FAkeSetting：" + paramLoadPackageParam.packageName);
            } else {
                return;
            }
        }

        try {
            HookMethod_System_get("get", info.MODEL, "ro.product.model");
            XposedBridge.log("--FakeSetting---ro.product.model---" + info.MODEL);
        } catch (Exception e) {
            e.printStackTrace();
            XposedBridge.log("info-------------------");
        }

        try {
            HookMethod_System_get("get", info.SERIAL, "ro.serialno");
        } catch (Exception e) {
            e.printStackTrace();
            XposedBridge.log("info-------------------");
        }

        try {
            HookMethod_System_get("get", "cn", "gsm.operator.iso_country");
            HookMethod_System_get("get", "cn", "gsm.sim.operator.iso_country");
        } catch (Exception e) {
            e.printStackTrace();
            XposedBridge.log("info-------------------");
        }
        String simoperator = info.Operator;
        try {
            if (!TextUtils.isEmpty(simoperator)) {
                HookMethod_System_get("get", simoperator, "gsm.operator.numeric");
                HookMethod_System_get("get", simoperator, "gsm.sim.operator.numeric");
            }
        } catch (Exception e) {
            e.printStackTrace();
            XposedBridge.log("info-------------------");
        }
        try {
            if (!TextUtils.isEmpty(simoperator)) {
                HookMethod_System_getInt("getInt", simoperator, "gsm.operator.numeric");
                HookMethod_System_getInt("getInt", simoperator, "gsm.sim.operator.numeric");
            }
        } catch (Exception e) {
            e.printStackTrace();
            XposedBridge.log("info-------------------");
        }
        try {
            HookMethod_System_get("get", "1", "gsm.current.phone-type");
            HookMethod_System_get("get", "false", "gsm.operator.isroaming");

            HookMethod_System_get("get", info.OperatorName, "gsm.sim.operator.alpha");
            HookMethod_System_get("get", info.OperatorName, "gsm.operator.alpha");
        } catch (Exception e) {
            e.printStackTrace();
            XposedBridge.log("info-------------------");
        }

        try {
            findAndHookMethod("android.provider.Settings.Secure", paramLoadPackageParam.classLoader, "getString", ContentResolver.class, String.class, new XC_MethodHook() {
                // getString.getInt.getLong最后都是调用的此函数
                @Override
                protected void afterHookedMethod(MethodHookParam param) throws Throwable {
                    String name = (param.args.length > 1 ? (String) param.args[1] : null);
                    if (Settings.Secure.ANDROID_ID.equals(name)) {
                        if (info != null) {
                            param.setResult(info.AndroidID);
                            return;
                        }
                    } else if (Settings.Secure.DEFAULT_INPUT_METHOD.equals(name)) {
                        param.setResult("com.google.android.inputmethod.pinyin/.PinyinIME");
                    } else if (Settings.Secure.ALLOW_MOCK_LOCATION.equals(name)) {
                        param.setResult("0");
                    } else if (!SettingDB.isSystemKey(name)) {
                        XposedBridge.log(paramLoadPackageParam.packageName + "请求Secure:" + name);
                        String value = SettingDB.gettString(name);
                        if (value != null) {
                            param.setResult(value);
                        } else {
                            param.setResult("");
                        }
                        return;
                    }
                }
            });
        } catch (Exception e) {
            XposedBridge.log("错误:android.provider.Settings.Secure，getString.信息：" + e.getMessage());
        }
        try {
            findAndHookMethod("android.provider.Settings.Secure", paramLoadPackageParam.classLoader, "putString", ContentResolver.class, String.class, String.class, new XC_MethodHook() {
                @Override
                protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
                    String name = (param.args.length > 1 ? (String) param.args[1] : null);
                    String value = (param.args.length > 2 ? (String) param.args[2] : null);
                    if (!SettingDB.isSystemKey(name)) {
                        SettingDB.putString(name, value);
                        param.setResult(true);
                    }
                    return;
                }
            });
        } catch (Exception e) {
            XposedBridge.log("错误:android.provider.Settings.Secure，putString.信息：" + e.getMessage());
        }
        // Settings.System
        try {
            findAndHookMethod("android.provider.Settings.System", paramLoadPackageParam.classLoader, "getString", ContentResolver.class, String.class, new XC_MethodHook() {
                @Override
                protected void afterHookedMethod(MethodHookParam param) throws Throwable {
                    String name = (param.args.length > 1 ? (String) param.args[1] : null);

                    if (Settings.Secure.ANDROID_ID.equals(name)) {
                        if (info != null) {
                            param.setResult(info.AndroidID); // 修改android_id
                            Util.XLog(param, info.AndroidID);
                            return;
                        }
                    } else if (!SettingDB.isSystemKey(name)) { // 检测是不是系统里面里面的选项，如果不是系统里面的选项，去我们当下的存储里面找
                        String value = SettingDB.gettString(name);
                        param.setResult(value);
                        Util.XLog(param, name + "--" + value);
                        return;
                    }
                }
            });

        } catch (Exception e) {
            XposedBridge.log("错误:android.provider.Settings.Syste，getString.信息：" + e.getMessage());
        }
        try {
            findAndHookMethod("android.provider.Settings.System", paramLoadPackageParam.classLoader, "putString", ContentResolver.class, String.class, String.class, new XC_MethodHook() {
                @Override
                protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
                    String name = (param.args.length > 1 ? (String) param.args[1] : null);
                    String value = (param.args.length > 2 ? (String) param.args[2] : null);
                    if (!SettingDB.isSystemKey(name)) {
                        SettingDB.putString(name, value);
                        param.setResult(true);
                    }
                    return;
                }
            });
        } catch (NoSuchMethodError n) {
            XposedBridge.log("错误:NoSuchMethodError -FakeSetting-Settings-System，信息：" + n.getMessage());
        } catch (Exception e) {
            XposedBridge.log("错误:FakeSetting--Settings.System，信息：" + e.getMessage());
        }

        // Settings.Secure
        try {
            findAndHookMethod("android.provider.Settings.Secure", paramLoadPackageParam.classLoader, "getStringForUser", ContentResolver.class, String.class, int.class, new XC_MethodHook() {
                // getString.getInt.getLong最后都是调用的此函数
                @Override
                protected void afterHookedMethod(MethodHookParam param) throws Throwable {
                    String name = (param.args.length > 1 ? (String) param.args[1] : null);
                    if (Settings.Secure.ANDROID_ID.equals(name)) {
                        if (info != null) {
                            param.setResult(info.AndroidID);
                            return;
                        }
                    } else if (Settings.Secure.DEFAULT_INPUT_METHOD.equals(name)) {
                        param.setResult("com.google.android.inputmethod.pinyin/.PinyinIME");
                    } else if (Settings.Secure.ALLOW_MOCK_LOCATION.equals(name)) {
                        param.setResult("0");
                    } else if (!SettingDB.isSystemKey(name)) {
                        XposedBridge.log(paramLoadPackageParam.packageName + "请求Secure:" + name);
                        String value = SettingDB.gettString(name);
                        if (value != null) {
                            param.setResult(value);
                        } else {
                            param.setResult("");
                        }
                        return;
                    }
                }
            });
        } catch (NoSuchMethodError n) {
            XposedBridge.log("错误NoSuchMethodError------:FakeSetting--Settings.Secure，信息：" + n.getMessage());
        } catch (Exception e) {
            XposedBridge.log("错误:FakeSetting--Settings.Secure，信息：" + e.getMessage());
        }
        try {
            findAndHookMethod("android.provider.Settings.Secure", paramLoadPackageParam.classLoader, "putStringForUser", ContentResolver.class, String.class, String.class, int.class,
                    new XC_MethodHook() {
                        @Override
                        protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
                            String name = (param.args.length > 1 ? (String) param.args[1] : null);
                            String value = (param.args.length > 2 ? (String) param.args[2] : null);
                            if (!SettingDB.isSystemKey(name)) {
                                SettingDB.putString(name, value);
                                param.setResult(true);
                            }
                            return;
                        }
                    });
        } catch (Exception e) {
            XposedBridge.log("错误:FakeSetting--Settings.Secure，信息：" + e.getMessage());
        }
        // Settings.System
        try {
            findAndHookMethod("android.provider.Settings.System", paramLoadPackageParam.classLoader, "getStringForUser", ContentResolver.class, String.class, int.class, new XC_MethodHook() {
                @Override
                protected void afterHookedMethod(MethodHookParam param) throws Throwable {
                    String name = (param.args.length > 1 ? (String) param.args[1] : null);

                    if (Settings.Secure.ANDROID_ID.equals(name)) {
                        if (info != null) {
                            param.setResult(info.AndroidID); // 修改android_id
                            Util.XLog(param, info.AndroidID);
                            return;
                        }
                    } else if (!SettingDB.isSystemKey(name)) { // 检测是不是系统里面里面的选项，如果不是系统里面的选项，去我们当下的存储里面找
                        String value = SettingDB.gettString(name);

                        param.setResult(value);
                        Util.XLog(param, name + "--" + value);
                        return;
                    }
                }
            });

        } catch (Exception e) {
            XposedBridge.log("错误:FakeSetting--Settings，System.信息：" + e.getMessage());
        }
        try {
            findAndHookMethod("android.provider.Settings.System", paramLoadPackageParam.classLoader, "putStringForUser", ContentResolver.class, String.class, String.class, int.class,
                    new XC_MethodHook() {
                        @Override
                        protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
                            String name = (param.args.length > 1 ? (String) param.args[1] : null);
                            String value = (param.args.length > 2 ? (String) param.args[2] : null);
                            if (!SettingDB.isSystemKey(name)) {
                                SettingDB.putString(name, value);
                                param.setResult(true);
                            }
                            return;
                        }
                    });

        } catch (Exception e) {
            XposedBridge.log("错误:FakeSetting--Settings，信息：" + e.getMessage());
        }
    }

    private void HookMethod_System_getInt(final String type, final Object result, final String reqParam) {
        try {
            Object[] arrayOfObject4 = new Object[3];
            arrayOfObject4[0] = String.class;
            arrayOfObject4[1] = Integer.TYPE;
            arrayOfObject4[2] = new XC_MethodHook() {
                protected void afterHookedMethod(XC_MethodHook.MethodHookParam paramAnonymousMethodHookParam) throws Throwable {
                    String str1 = "";
                    String str2 = "";
                    if (paramAnonymousMethodHookParam.args.length > 0) {
                        str1 = (String) paramAnonymousMethodHookParam.args[0];
                        str2 = "";
                        if (!str1.equals(reqParam)) {
                        } else {
                            str2 = result.toString();
                        }
                    }
                    if (!str2.equals("")) {
                        paramAnonymousMethodHookParam.setResult(Integer.valueOf(str2));
                    } else {

                    }
                }
            };
            XposedHelpers.findAndHookMethod("android.os.SystemProperties", null, "getInt", arrayOfObject4);
        } catch (Throwable e) {
            Log.i("MainHook", "HookMethod", e);
        }
    }

    private void HookMethod_System_get(final String type, final Object result, final String reqParam) {
        try {
            Object[] arrayOfObject4 = new Object[2];
            arrayOfObject4[0] = String.class;
            arrayOfObject4[1] = new XC_MethodHook() {
                protected void afterHookedMethod(XC_MethodHook.MethodHookParam paramAnonymousMethodHookParam) throws Throwable {

                    XposedBridge.log("paramAnonymousMethodHookParam=" +paramAnonymousMethodHookParam.thisObject.toString());

                    String str2 = "";
                    if (paramAnonymousMethodHookParam.args.length > 0) {
                        String str1 = (String) paramAnonymousMethodHookParam.args[0];

                        if (str1.equals(reqParam)) {
                            str2 = result.toString();
                        }
                    }

                    if (!str2.equals("")) {
                        paramAnonymousMethodHookParam.setResult(str2);
                    } else {

                    }

                }
            };


            XposedHelpers.findAndHookMethod("android.os.SystemProperties", null, "get", arrayOfObject4);
        } catch (Throwable e) {
            Log.i("MainHook", "HookMethod", e);
        }
    }
}
