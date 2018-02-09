package com.x.hook;

import static de.robv.android.xposed.XposedHelpers.findAndHookMethod;
import static de.robv.android.xposed.XposedHelpers.findConstructorExact;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.Constructor;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import android.app.ActivityManager;
import android.app.ActivityManager.RunningAppProcessInfo;
import android.app.ActivityManager.RunningServiceInfo;
import android.app.ActivityManager.RunningTaskInfo;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;

import com.x.app.App;
import com.x.phone.PhoneInfo;

import de.robv.android.xposed.IXposedHookLoadPackage;
import de.robv.android.xposed.XC_MethodHook;
import de.robv.android.xposed.XposedBridge;
import de.robv.android.xposed.callbacks.XCallback;
import de.robv.android.xposed.callbacks.XC_LoadPackage.LoadPackageParam;

/**
 * 隐藏ROOT和一些安装的app通过
 * 
 */
public class FakeApp implements IXposedHookLoadPackage {

	static PhoneInfo info; // 当前的手机型号
	// [start] 有关root和命令的几个常量
	private Set<String> keywordSet; // 关键字
	private Set<String> commandSet; // 命令列表
	private static final String FAKE_COMMAND = "FAKEJUNKCOMMAND";
	private static final String FAKE_FILE = "FAKEJUNKFILE";
	private static final String FAKE_PACKAGE = "FAKE.JUNK.PACKAGE";
	private static final String FAKE_APPLICATION = "FAKE.JUNK.APPLICATION";

	// [end]
	@Override
	public void handleLoadPackage(final LoadPackageParam paramLoadPackageParam)
			throws Throwable {
		if (paramLoadPackageParam.packageName.equals("com.x.xphone")) {
			findAndHookMethod("com.x.utils.Util",
					paramLoadPackageParam.classLoader, "isXposedEnabled",
					new XC_MethodHook() {
						protected void afterHookedMethod(MethodHookParam param)
								throws Throwable {
							param.setResult(true);
						}
					});
		}
		info = PhoneInfo.GetNow();
		if (!App.IsInShuaLib(paramLoadPackageParam.packageName))
			return;
		// [start] 修改已装app和进程的相关代码
		commandSet = new HashSet<String>();
		commandSet.add("su");
		commandSet.add("which");
		commandSet.add("busybox");
		commandSet.add("pm");
		commandSet.add("am");
		// commandSet.add("sh");
		commandSet.add("ps");
		keywordSet = new HashSet<String>();
		keywordSet.add("MIUI");
		keywordSet.add("miui");
		keywordSet.add("xiaomi");
		keywordSet.add("supersu");
		keywordSet.add("superuser");
		keywordSet.add("Superuser");
		keywordSet.add("noshufou");
		keywordSet.add("xposed");
		keywordSet.add("rootcloak");
		keywordSet.add("chainfire");
		keywordSet.add("titanium");
		keywordSet.add("Titanium");
		keywordSet.add("substrate");
		keywordSet.add("greenify");
		keywordSet.add("daemonsu");
		keywordSet.add("root");
		keywordSet.add("busybox");
		keywordSet.add("tmpsu");
		keywordSet.add("su");
		keywordSet.add("xphone");
		keywordSet.add("xprivacy");
		keywordSet.add("mobileanjian");
		keywordSet.add("cffkb");
		// [end]

		try {
			// initFile(paramLoadPackageParam);
			initPackageManager(paramLoadPackageParam);
			initActivityManager(paramLoadPackageParam);
			initRuntime(paramLoadPackageParam);
			initProcessBuilder(paramLoadPackageParam);
			initProcessBuilderCommand(paramLoadPackageParam);
		} catch (Exception e) {
			XposedBridge.log("错误:FakeApp，信息：" + e.getMessage());
		}

	}

	private void initPackageManager(final LoadPackageParam lpparam) {
		// Hooks getInstalledApplications. For this method we will remove any
		// keywords, such as supersu and superuser, out of the result list.
		try {
			findAndHookMethod("android.app.ApplicationPackageManager",
					lpparam.classLoader, "getInstalledApplications", int.class,
					new XC_MethodHook() {
						@SuppressWarnings("unchecked")
						@Override
						protected void afterHookedMethod(MethodHookParam param)
								throws Throwable {
							if ((App.IsInShuaLib(lpparam.packageName))) {

								List<ApplicationInfo> packages = (List<ApplicationInfo>) param
										.getResult();
								Iterator<ApplicationInfo> iter = packages
										.iterator();
								ApplicationInfo tempAppInfo;
								String tempPackageName;
								while (iter.hasNext()) {
									tempAppInfo = iter.next();
									tempPackageName = tempAppInfo.packageName;
									if (tempPackageName != null
											&& App.IsInBlockLib(tempPackageName)) {
										iter.remove();
										// if (HookLog) {
										// XposedBridge.log("移除隐藏APP: " +
										// tempPackageName+","+lpparam.packageName);
										// }
									} else if (tempPackageName != null
											&& App.IsInBlockLib(tempPackageName)) {
										iter.remove();
									}
								}
								param.setResult(packages);
							}
						}
					});

			// Hooks getInstalledPackages. For this method we will remove any
			// keywords, such as supersu and superuser, out of the result list.
			findAndHookMethod("android.app.ApplicationPackageManager",
					lpparam.classLoader, "getInstalledPackages", int.class,
					new XC_MethodHook() {
						@SuppressWarnings("unchecked")
						@Override
						protected void afterHookedMethod(MethodHookParam param)
								throws Throwable {
							if ((App.IsInShuaLib(lpparam.packageName))) {

								List<PackageInfo> packages = (List<PackageInfo>) param
										.getResult();
								Iterator<PackageInfo> iter = packages
										.iterator();
								PackageInfo tempPackageInfo;
								String tempPackageName;
								while (iter.hasNext()) {
									tempPackageInfo = iter.next();
									tempPackageName = tempPackageInfo.packageName;
									if (tempPackageName != null
											&& App.IsInBlockLib(tempPackageName)) {
										iter.remove();
									}
								}
								param.setResult(packages);
							}
						}
					});
		} catch (Exception e) {
			XposedBridge.log("FakeLocation-----------------");
		}
	}

	@SuppressWarnings("unused")
	private void initFile(final LoadPackageParam lpparam) {
		// Handles a version of the File constructor.
		try {
			Constructor<?> constructLayoutParams = findConstructorExact(
					java.io.File.class, String.class);
			XposedBridge.hookMethod(constructLayoutParams, new XC_MethodHook(
					XCallback.PRIORITY_HIGHEST) {
				@Override
				protected void beforeHookedMethod(MethodHookParam param)
						throws Throwable {
					if (param.args[0] != null) {
					}
					if (((String) param.args[0]).endsWith("su")) {
						param.args[0] = "/system/xbin/" + FAKE_FILE;
					} else if (((String) param.args[0]).endsWith("busybox")) {
						param.args[0] = "/system/xbin/" + FAKE_FILE;
					} else if (App.IsInBlockLib((String) param.args[0])) {
						param.args[0] = "/system/app/" + FAKE_FILE + ".apk";
					}
				}
			});

			// Another version of the File constructor.
			Constructor<?> extendedFileConstructor = findConstructorExact(
					java.io.File.class, String.class, String.class);
			XposedBridge.hookMethod(extendedFileConstructor, new XC_MethodHook(
					XCallback.PRIORITY_HIGHEST) {
				@Override
				protected void beforeHookedMethod(MethodHookParam param)
						throws Throwable {
					if ((App.IsInShuaLib(lpparam.packageName))) {

						// if (param.args[0] != null && param.args[1] != null){
						// XposedBridge.log("File: Found a File constructor: " +
						// ((String)param.args[0]) + ", with: "+
						// ((String)param.args[1]));
						// }

						if (((String) param.args[1]).equalsIgnoreCase("su")) {
							param.args[1] = FAKE_FILE;
						} else if (((String) param.args[1]).contains("busybox")) {
							param.args[1] = FAKE_FILE;
						} else if (App.IsInBlockLib((String) param.args[1])) {
							param.args[1] = FAKE_FILE + ".apk";
						}
					}
				}
			});
		} catch (Exception e) {
			XposedBridge.log("FakeLocation-----------------");
		}
		// Currently just for debugging purposes, not normally used
		// Constructor<?> uriFileConstructor =
		// findConstructorExact(java.io.File.class, URI.class);
		// XposedBridge.hookMethod(uriFileConstructor, new
		// XC_MethodHook(XCallback.PRIORITY_HIGHEST) {
		// @Override
		// protected void beforeHookedMethod(MethodHookParam param) throws
		// Throwable {
		// if (param.args[0] != null){
		// if (HookLog) {
		// XposedBridge.log("发现URI File constructor: " +
		// ((URI)param.args[0]).toString()+" "+lpparam.packageName);
		// }
		// }
		// }
		// });
	}

	private void initActivityManager(final LoadPackageParam lpparam) {
		// Hooks getPackageInfo. For this method we will prevent the package
		// info from being obtained for any app in the list
		try {
			findAndHookMethod("android.app.ApplicationPackageManager",
					lpparam.classLoader, "getPackageInfo", String.class,
					int.class, new XC_MethodHook() {
						@Override
						protected void beforeHookedMethod(MethodHookParam param)
								throws Throwable {
							if ((App.IsInShuaLib(lpparam.packageName))) {

								String name = (String) param.args[0];

								if (name != null && App.IsInBlockLib(name)) {
									param.args[0] = FAKE_PACKAGE;
								}
							}
						}
					});

			// Hooks getApplicationInfo. For this method we will prevent the
			// package
			// info from being obtained for any app in the list
			findAndHookMethod("android.app.ApplicationPackageManager",
					lpparam.classLoader, "getApplicationInfo", String.class,
					int.class, new XC_MethodHook() {
						@Override
						protected void beforeHookedMethod(MethodHookParam param)
								throws Throwable {
							if ((App.IsInShuaLib(lpparam.packageName))) {
								String name = (String) param.args[0];
								if (name != null && App.IsInBlockLib(name)) {
									param.args[0] = FAKE_APPLICATION;
								}
							}
						}
					});
			// Hooks getRunningServices. For this method we will remove any
			// keywords, such as supersu and superuser, out of the result list.
			findAndHookMethod("android.app.ActivityManager",
					lpparam.classLoader, "getRunningServices", int.class,
					new XC_MethodHook() {
						@SuppressWarnings("unchecked")
						@Override
						protected void afterHookedMethod(MethodHookParam param)
								throws Throwable {
							if ((App.IsInShuaLib(lpparam.packageName))) {

								List<ActivityManager.RunningServiceInfo> services = (List<RunningServiceInfo>) param
										.getResult();
								Iterator<RunningServiceInfo> iter = services
										.iterator();
								RunningServiceInfo tempService;
								String tempProcessName;
								while (iter.hasNext()) {
									tempService = iter.next();
									tempProcessName = tempService.process;
									if (tempProcessName != null
											&& App.IsInBlockLib(tempProcessName)) {
										iter.remove();
									}
								}
								param.setResult(services);
							}
						}
					});

			// Hooks getRunningTasks. For this method we will remove any
			// keywords,
			// such as supersu and superuser, out of the result list.
			findAndHookMethod("android.app.ActivityManager",
					lpparam.classLoader, "getRunningTasks", int.class,
					new XC_MethodHook() {
						@SuppressWarnings("unchecked")
						@Override
						protected void afterHookedMethod(MethodHookParam param)
								throws Throwable {
							if ((App.IsInShuaLib(lpparam.packageName))) {

								List<ActivityManager.RunningTaskInfo> services = (List<RunningTaskInfo>) param
										.getResult();
								Iterator<RunningTaskInfo> iter = services
										.iterator();
								RunningTaskInfo tempTask;
								String tempBaseActivity;
								while (iter.hasNext()) {
									tempTask = iter.next();
									tempBaseActivity = tempTask.baseActivity
											.flattenToString();
									if (tempBaseActivity != null
											&& App.IsInBlockLib(tempBaseActivity)) {
										iter.remove();
									}
								}
								param.setResult(services);
							}
						}
					});

			// Hooks getRunningAppProcesses. For this method we will remove any
			// keywords, such as supersu and superuser, out of the result list.
			findAndHookMethod("android.app.ActivityManager",
					lpparam.classLoader, "getRunningAppProcesses",
					new XC_MethodHook() {
						@SuppressWarnings("unchecked")
						@Override
						protected void afterHookedMethod(MethodHookParam param)
								throws Throwable {

							List<ActivityManager.RunningAppProcessInfo> processes = (List<ActivityManager.RunningAppProcessInfo>) param
									.getResult();
							Iterator<RunningAppProcessInfo> iter = processes
									.iterator();
							RunningAppProcessInfo tempProcess;
							String tempProcessName;
							while (iter.hasNext()) {
								tempProcess = iter.next();
								tempProcessName = tempProcess.processName;
								if (tempProcessName != null
										&& App.IsInBlockLib(tempProcessName)) {
									iter.remove();
								}
							}
							param.setResult(processes);
						}
					});
		} catch (Exception e) {
			XposedBridge.log("FakeLocation-----------------");
		}
	}

	private void initRuntime(final LoadPackageParam lpparam) {
		// Hooks the Runtime.exec() method. This is the only one that needs to
		// be hooked because the other two versions of exec() just end up
		// calling this one.
		try {
			findAndHookMethod("java.lang.Runtime", lpparam.classLoader, "exec",
					String[].class, String[].class, File.class,
					new XC_MethodHook() {
						@Override
						protected void beforeHookedMethod(MethodHookParam param)
								throws Throwable {
							if ((App.IsInShuaLib(lpparam.packageName))) {
								String[] execArray = (String[]) param.args[0];
								if ((execArray != null)
										&& (execArray.length >= 1)) {
									String firstParam = execArray[0];
									XposedBridge.log("发现执行命令: " + firstParam
											+ " " + lpparam.packageName);
									if (stringEndsWithFromSet(firstParam,
											commandSet)) {
										if (firstParam.equals("su")
												|| firstParam.endsWith("/su")) {
											param.setThrowable(new IOException());
										} else if (commandSet.contains("pm")
												&& (firstParam.equals("pm") || firstParam
														.endsWith("/pm"))) {
											if (execArray.length >= 3
													&& execArray[1]
															.equalsIgnoreCase("list")
													&& execArray[2]
															.equalsIgnoreCase("packages")) {
												param.args[0] = buildGrepArraySingle(
														execArray, true);
											} else if (execArray.length >= 3
													&& (execArray[1]
															.equalsIgnoreCase("dump") || execArray[1]
															.equalsIgnoreCase("path"))) {
												if (App.IsInBlockLib(execArray[2])) {
													param.args[0] = new String[] {
															execArray[0],
															execArray[1],
															FAKE_PACKAGE };
												}
											}
										} else if (commandSet.contains("ps")
												&& (firstParam.equals("ps") || firstParam
														.endsWith("/ps"))) {
											param.args[0] = buildGrepArraySingle(
													execArray, true);
										} else if (commandSet.contains("which")
												&& (firstParam.equals("which") || firstParam
														.endsWith("/which"))) {
											param.setThrowable(new IOException());
										} else if (commandSet
												.contains("busybox")) {
											for (String tempString : execArray) {
												if (tempString
														.endsWith("busybox")) {
													param.setThrowable(new IOException());
												}
											}
										}
										// else if (commandSet.contains("sh")
										// && (firstParam.equals("sh") ||
										// firstParam
										// .endsWith("/sh"))) {
										// //param.setThrowable(new
										// IOException());
										// } else {
										// //param.setThrowable(new
										// IOException());
										// }
									}
								}
							}
						}
					});
		} catch (Exception e) {
			XposedBridge.log("FakeLocation-----------------");
		}
	}

	private void initProcessBuilderCommand(final LoadPackageParam lpparam) {
		try {
			findAndHookMethod("java.lang.ProcessBuilder", lpparam.classLoader,
					"command", List.class,
					// String[].class, String[].class, File.class,
					new XC_MethodHook() {
						@SuppressWarnings("unchecked")
						@Override
						protected void beforeHookedMethod(MethodHookParam param)
								throws Throwable {
							List<String> cmdList = (param.args.length > 0 ? (List<String>) param.args[0]
									: null);
							if ((cmdList != null) && (cmdList.size() > 0)) {
								if (stringContainsFromSet(cmdList.get(0),
										commandSet)) {
									@SuppressWarnings("unused")
									String str = cmdList.get(0);
									str = FAKE_COMMAND;
									// cmdList[0]=FAKE_COMMAND;
									// cmdArray[0] = FAKE_COMMAND;
									// param.args[0] = cmdArray;
								}
								// String tempStr="";
								// for(String temp:cmdList){
								// tempStr = tempStr + " " + temp;
								// }
								// XposedBridge.log("499监测调用ProcessBuilder.command"+tempStr);
							}
						}
					});

			findAndHookMethod("java.lang.ProcessBuilder", lpparam.classLoader,
					"command", String[].class,
					// String[].class, String[].class, File.class,
					new XC_MethodHook() {
						@Override
						protected void beforeHookedMethod(MethodHookParam param)
								throws Throwable {
							String[] cmdArray = (param.args.length > 0 ? (String[]) param.args[0]
									: null);
							if (cmdArray != null) {
								if (stringEndsWithFromSet(cmdArray[0],
										commandSet)) {
									cmdArray[0] = FAKE_COMMAND;
									param.args[0] = cmdArray;
								}
							}
						}
					});
		} catch (Exception e) {
			XposedBridge.log("FakeLocation-----------------");
		}
	}

	private void initProcessBuilder(final LoadPackageParam lpparam) {
		Constructor<?> processBuilderConstructor2 = findConstructorExact(
				java.lang.ProcessBuilder.class, String[].class);
		try {
			XposedBridge.hookMethod(processBuilderConstructor2,
					new XC_MethodHook(XCallback.PRIORITY_HIGHEST) {
						@Override
						protected void beforeHookedMethod(MethodHookParam param)
								throws Throwable {
							String[] cmdArray = (param.args.length > 0 ? (String[]) param.args[0]
									: null);
							if ((cmdArray != null) && (cmdArray.length > 0)) {
								// if (HookLog) {
								// String tempString =
								// "547ProcessBuilder Command:";
								// for (int i=0;i<cmdArray.length;i++) {
								// String temp = cmdArray[i];
								// tempString = tempString + " " + temp;
								// }
								// XposedBridge.log(tempString);
								// }

								if (stringEndsWithFromSet(cmdArray[0],
										commandSet)) {
									cmdArray[0] = FAKE_COMMAND;
									param.args[0] = cmdArray;
								}

								// if (HookLog) {
								// String tempString =
								// "561New ProcessBuilder Command:";
								// for (String temp : (String[]) param.args[0])
								// {
								// tempString = tempString + " " + temp;
								// }
								// XposedBridge.log(tempString);
								// }
							}
						}
					});
		} catch (Exception e) {
			XposedBridge.log("FakeLocation-----------------");
		}

	}

	// [start] 隐藏app相关
	/**
	 * @param base
	 * @param values
	 * @return
	 */
	public boolean stringContainsFromSet(String base, Set<String> values) {

		if (base != null && values != null) {
			for (String tempString : values) {
				if (base.contains(tempString)) {
					return true;
				}
			}
		}

		return false;
	}

	public boolean stringEndsWithFromSet(String base, Set<String> values) {
		if (base != null && values != null) {
			for (String tempString : values) {
				if (base.endsWith(tempString)) {
					return true;
				}
			}
		}

		return false;
	}

	private String[] buildGrepArraySingle(String[] original, boolean addSH) {
		StringBuilder builder = new StringBuilder();
		ArrayList<String> originalList = new ArrayList<String>();
		if (addSH) {
			originalList.add("sh");
			originalList.add("-c");
		}
		for (String temp : original) {
			builder.append(" ");
			builder.append(temp);
		}
		// originalList.addAll(Arrays.asList(original));
		for (String temp : keywordSet) {
			builder.append(" | grep -v ");
			builder.append(temp);
		}
		// originalList.addAll(Common.DEFAULT_GREP_ENTRIES);
		originalList.add(builder.toString());
		return originalList.toArray(new String[0]);
	}
	// [end]

}
