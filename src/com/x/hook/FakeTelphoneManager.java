package com.x.hook;

import static de.robv.android.xposed.XposedHelpers.findAndHookMethod;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.WeakHashMap;

import android.annotation.SuppressLint;
import android.content.res.Resources;
import android.os.Build;
import android.os.Bundle;
import android.telephony.CellInfo;
import android.telephony.CellLocation;
import android.telephony.NeighboringCellInfo;
import android.telephony.PhoneStateListener;
import android.telephony.ServiceState;
import android.telephony.SignalStrength;
import android.telephony.TelephonyManager;

import com.x.app.App;
import com.x.phone.PhoneInfo;
import com.x.utils.Util;

import de.robv.android.xposed.IXposedHookLoadPackage;
import de.robv.android.xposed.XC_MethodHook;
import de.robv.android.xposed.XposedBridge;
import de.robv.android.xposed.XposedHelpers;
import de.robv.android.xposed.callbacks.XC_LoadPackage.LoadPackageParam;

public class FakeTelphoneManager implements IXposedHookLoadPackage {

	static PhoneInfo info;
	static boolean fakeConn = true;
	private static final Map<PhoneStateListener, XPhoneStateListener> mListener = new WeakHashMap<PhoneStateListener, XPhoneStateListener>();

	@Override
	public void handleLoadPackage(final LoadPackageParam paramLoadPackageParam) throws Throwable {
		info = PhoneInfo.GetNow();
		if (!App.IsInShuaLib(paramLoadPackageParam.packageName)) {
			if ("com.umeng.example".equals(paramLoadPackageParam.packageName)) {
				XposedBridge.log("NOT Shua FakeTel��" + paramLoadPackageParam.packageName);

			} else {
				return;
			}
		}

		String IMEIEnd = info.IMEI.charAt(12) + ""; // ȡIMEI��12λ���������4��αװ�������4�Ͳ�αװ
		int imeiend = 4; // Ĭ��Ϊ4
		try {
			imeiend = Integer.valueOf(IMEIEnd);
		} catch (Exception e) {
			XposedBridge.log("����:FakeTelphoneManager-----------------------");
		}
		imeiend = 4; // ���Բ�����������������
		if (imeiend > 8) {
			fakeConn = true;
		} else {
			fakeConn = false;
		}
		// android.telephony.ServiceState
		try {
			XposedHelpers.findAndHookMethod(android.telephony.ServiceState.class, "getState", new XC_MethodHook() {
				@Override
				protected void afterHookedMethod(MethodHookParam param) throws Throwable {
					param.setResult(ServiceState.STATE_IN_SERVICE);
					Util.XLog(param);
				}
			});

			XposedHelpers.findAndHookMethod(android.telephony.ServiceState.class, "getOperatorAlphaLong", new XC_MethodHook() {
				@Override
				protected void afterHookedMethod(MethodHookParam param) throws Throwable {
					XposedBridge.log("!!!" + paramLoadPackageParam.packageName + "����getOperatorAlphaLong�����Ϊ" + param.getResult());

				}
			});

			XposedHelpers.findAndHookMethod(android.telephony.ServiceState.class, "getOperatorAlphaShort", new XC_MethodHook() {
				@Override
				protected void afterHookedMethod(MethodHookParam param) throws Throwable {
					XposedBridge.log("!!!" + paramLoadPackageParam.packageName + "����getOperatorAlphaShort�����Ϊ" + param.getResult());
				}
			});

			XposedHelpers.findAndHookMethod(android.telephony.ServiceState.class, "getOperatorNumeric", new XC_MethodHook() {
				@Override
				protected void afterHookedMethod(MethodHookParam param) throws Throwable {
					XposedBridge.log("!!!" + paramLoadPackageParam.packageName + "����getOperatorNumeric�����Ϊ" + param.getResult());
				}
			});

		} catch (Exception e) {
			XposedBridge.log("����:FakeTelphoneManager--ServiceState����Ϣ��" + e.getMessage());
		}
		// android.telephony.TelephonyManager
		try {
			try {
				XposedHelpers.findAndHookMethod(TelephonyManager.class, "disableLocationUpdates", new XC_MethodHook() {
					@Override
					protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
						param.setResult(null);
						Util.XLog(param);
						return;
					}
				});
			} catch (Exception e) {
				XposedBridge.log("����FakeTelphoneManager--disableLocationUpdates,��Ϣ��" + e.getMessage());
			}
			try {
				XposedHelpers.findAndHookMethod(TelephonyManager.class, "getAllCellInfo", new XC_MethodHook() {
					@Override
					protected void afterHookedMethod(MethodHookParam param) throws Throwable {
						// XposedBridge.log("getAllCellInfo����");
						param.setResult(new ArrayList<CellInfo>());
						Util.XLog(param);
						return;
					}
				});
				XposedHelpers.findAndHookMethod(TelephonyManager.class, "getCellLocation", new XC_MethodHook() {
					@Override
					protected void afterHookedMethod(MethodHookParam param) throws Throwable {
						// XposedBridge.log("getCellLocation����");
						param.setResult(null);
						// param.setResult(getDefacedCellBundle(0));
						Util.XLog(param);
						return;
					}
				});
				XposedHelpers.findAndHookMethod(TelephonyManager.class, "getNeighboringCellInfo", new XC_MethodHook() {
					@Override
					protected void afterHookedMethod(MethodHookParam param) throws Throwable {
						// XposedBridge.log("getNeighboringCellInfo����");
						param.setResult(new ArrayList<NeighboringCellInfo>());
						Util.XLog(param);
						return;

					}
				});
			} catch (Exception e) {
				XposedBridge.log("����:FakeTelphoneManager-----------------------");
				e.printStackTrace();
			}
			try {
				XposedHelpers.findAndHookMethod(TelephonyManager.class, "getDataState", new XC_MethodHook() {
					@Override
					protected void afterHookedMethod(MethodHookParam param) throws Throwable {
						// ����ģ��ΪWIFI�򷵻�0�����ģ��Ϊ3G�򷵻�2������4����0��С��4����2
						Util.XLog(param);
						param.setResult(2);
						return;
						// if (fakeConn) {
						// param.setResult(2);
						// }
					}
				});
				XposedHelpers.findAndHookMethod(TelephonyManager.class, "getLine1Number", new XC_MethodHook() {
					@Override
					protected void afterHookedMethod(MethodHookParam param) throws Throwable {
						param.setResult(info.Line1Number);
						Util.XLog(param);
						return;

					}
				});
				XposedHelpers.findAndHookMethod(TelephonyManager.class, "getDeviceId", new XC_MethodHook() {
					@Override
					protected void afterHookedMethod(MethodHookParam param) throws Throwable {
						param.setResult(info.IMEI);
						Util.XLog(param);
						return;

					}
				});
				XposedHelpers.findAndHookMethod(TelephonyManager.class, "getDeviceSoftwareVersion", new XC_MethodHook() {
					@Override
					protected void afterHookedMethod(MethodHookParam param) throws Throwable {
						// getDeviceSoftwareVersion
						// ����IMEI���ֵ���ƶ��ķ���IMEI��������ͨ���ؿ�ֵ
						if (info.Operator.intern() == "46003".intern())
							param.setResult("");
						else
							param.setResult(info.IMEI);
						Util.XLog(param);
					}
				});
				XposedHelpers.findAndHookMethod(TelephonyManager.class, "getLine1Number", new XC_MethodHook() {
					@Override
					protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
						param.setResult(info.Line1Number);
						Util.XLog(param);
						return;
					}
				});
			} catch (Exception e) {
				e.printStackTrace();
			}
			try {
				XposedHelpers.findAndHookMethod(TelephonyManager.class, "getNetworkCountryIso", new XC_MethodHook() {
					@Override
					protected void afterHookedMethod(MethodHookParam param) throws Throwable {
						param.setResult("cn");
						Util.XLog(param);
						return;
					}
				});
				XposedHelpers.findAndHookMethod(TelephonyManager.class, "getNetworkOperator", new XC_MethodHook() {
					@Override
					protected void afterHookedMethod(MethodHookParam param) throws Throwable {
						param.setResult(info.Operator);
						Util.XLog(param);
						return;

					}
				});
				XposedHelpers.findAndHookMethod(TelephonyManager.class, "getNetworkOperatorName", new XC_MethodHook() {
					@Override
					protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
						param.setResult(info.OperatorName);
						Util.XLog(param);
						return;
					}
				});
				XposedHelpers.findAndHookMethod(TelephonyManager.class, "getSimCountryIso", new XC_MethodHook() {
					@Override
					protected void afterHookedMethod(MethodHookParam param) throws Throwable {
						param.setResult("cn");
						Util.XLog(param);
						return;
					}
				});
				XposedHelpers.findAndHookMethod(TelephonyManager.class, "getSimOperator", new XC_MethodHook() {
					@Override
					protected void afterHookedMethod(MethodHookParam param) throws Throwable {
						param.setResult(info.Operator);
						Util.XLog(param);
						return;

					}
				});
				XposedHelpers.findAndHookMethod(TelephonyManager.class, "getSimOperatorName", new XC_MethodHook() {
					@Override
					protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
						param.setResult(info.OperatorName);
						Util.XLog(param);
						return;
					}
				});
				XposedHelpers.findAndHookMethod(TelephonyManager.class, "getSimSerialNumber", new XC_MethodHook() {
					@Override
					protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
						param.setResult(info.SimSerialNumber);
						Util.XLog(param);
						return;

					}
				});
			} catch (Exception e) {
				XposedBridge.log("����:FakeTelphoneManager-----------------------");
				e.printStackTrace();
			}
			try {
				XposedHelpers.findAndHookMethod(TelephonyManager.class, "getNetworkType", new XC_MethodHook() {
					@Override
					protected void afterHookedMethod(MethodHookParam param) throws Throwable {
						Util.XLog(param);
						param.setResult(info.NetWorkType);
						XposedBridge.log("getNetworkType:" + param.getResult());
						return;
					}
				});
				XposedHelpers.findAndHookMethod(TelephonyManager.class, "getNetworkType", new XC_MethodHook() {
					@Override
					protected void afterHookedMethod(MethodHookParam param) throws Throwable {
						// if (fakeConn) {
						param.setResult(info.NetWorkType);
						XposedBridge.log("getDataNetworkType:" + param.getResult());
						Util.XLog(param);
						return;
						// }
					}
				});

				XposedHelpers.findAndHookMethod(TelephonyManager.class, "getPhoneType", new XC_MethodHook() {
					@Override
					protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
						Util.XLog(param);
						if (info.Operator.intern() == "46000".intern()) {
							param.setResult(TelephonyManager.PHONE_TYPE_GSM);
						} else if (info.Operator.intern() == "46001".intern()) {
							param.setResult(TelephonyManager.PHONE_TYPE_GSM);
						} else if (info.Operator.intern() == "46003".intern()) {
							param.setResult(TelephonyManager.PHONE_TYPE_CDMA);
						}
						return;
					}
				});

				XposedHelpers.findAndHookMethod(TelephonyManager.class, "getSimState", new XC_MethodHook() {
					@Override
					protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
						Util.XLog(param);
						param.setResult(5);
						return;
					}
				});

				XposedHelpers.findAndHookMethod(TelephonyManager.class, "getSubscriberId", new XC_MethodHook() {
					@Override
					protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
						Util.XLog(param);
						param.setResult(info.SubscriberId);
						return;
					}
				});

				XposedHelpers.findAndHookMethod(TelephonyManager.class, "hasIccCard", new XC_MethodHook() {
					@Override
					protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
						Util.XLog(param);
						param.setResult(true);
						return;
					}
				});

				XposedHelpers.findAndHookMethod(TelephonyManager.class, "isNetworkRoaming", new XC_MethodHook() {
					@Override
					protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
						Util.XLog(param);
						param.setResult(true);
						return;
					}
				});

				XposedHelpers.findAndHookMethod(TelephonyManager.class, "isSmsCapable", new XC_MethodHook() {
					@Override
					protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
						Util.XLog(param);
						param.setResult(true);
						return;
					}
				});

				XposedHelpers.findAndHookMethod(SignalStrength.class, "getGsmSignalStrength", new XC_MethodHook() {
					@Override
					protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
						Util.XLog(param);
						// ����״���·���0--31��������ʱ����99
						Random rand = new Random();
						int nextInt = 0;
						nextInt = rand.nextInt(31);
						if (nextInt < 20)
							nextInt = 30;
						param.setResult(nextInt);
						return;

					}
				});
			} catch (Exception e) {
				XposedBridge.log("����:FakeTelphoneManager-----------------------");
				e.printStackTrace();
			}
			try {
				XposedHelpers.findAndHookMethod(SignalStrength.class, "isGsm", new XC_MethodHook() {
					@Override
					protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
						Util.XLog(param);
						if (info.Operator.charAt(4) == '3')
							param.setResult(false);
						else
							param.setResult(true);
						return;
					}
				});
			} catch (Exception e) {
				e.printStackTrace();
			}
			try {
				XposedHelpers.findAndHookMethod(TelephonyManager.class, "listen", PhoneStateListener.class, int.class, new XC_MethodHook() {
					@Override
					protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
						if (param.args.length > 1 && param.args[0] instanceof PhoneStateListener && param.args[1] instanceof Integer) {
							Util.XLog(param);
							XposedBridge.log("TelephonyManager.listen�Ѿ�HOOK");
							PhoneStateListener listener = (PhoneStateListener) param.args[0];
							int event = (Integer) param.args[1];
							if (event == PhoneStateListener.LISTEN_NONE) {
								// Remove
								synchronized (mListener) {
									XPhoneStateListener xListener = mListener.get(listener);
									if (xListener != null) {
										param.args[0] = xListener;
									}
								}
							} else
								try {
									// Replace
									XPhoneStateListener xListener;
									synchronized (mListener) {
										xListener = mListener.get(listener);
										if (xListener == null) {
											xListener = new XPhoneStateListener(listener);
											mListener.put(listener, xListener);
										}
									}
									param.args[0] = xListener;
								} catch (Throwable ignored) {
								}
						}
					}

				});
			} catch (Exception e) {
				XposedBridge.log("TelephonyManager.listen�����ˣ�������Ϣ��" + e.getMessage());
			}

			if (Build.VERSION.SDK_INT > 18) {
				try {
					XposedHelpers.findAndHookMethod(TelephonyManager.class, "getGroupIdLevel1", new XC_MethodHook() {
						@Override
						protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
							Util.XLog(param);
							param.setResult(null);
							return;

						}
					});

					XposedHelpers.findAndHookMethod(TelephonyManager.class, "getMmsUAProfUrl", new XC_MethodHook() {
						@Override
						protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
							Util.XLog(param);
							param.setResult("");
							return;
						}
					});

					XposedHelpers.findAndHookMethod(TelephonyManager.class, "getMmsUserAgent", new XC_MethodHook() {
						@Override
						protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
							Util.XLog(param);
							param.setResult("");
							return;

						}
					});
				} catch (Exception e) {
					XposedBridge.log("TelephonyManager SDK>18ʱ���ִ��󣬴�����Ϣ��" + e.getMessage());
				}
			}
		} catch (Exception e) {
			XposedBridge.log("����:FakeTelphoneManager--TelephonyManager����Ϣ��" + e.getMessage());

		}
		// com.android.phone.PhoneInterfaceManager
		// ������androidԴ���ַ com.android.phone.PhoneInterfaceManager
		// http://grepcode.com/file/repository.grepcode.com/java/ext/com.google.android/android-apps/5.0.2_r1/com/android/phone/PhoneInterfaceManager.java#PhoneInterfaceManager
		try {
			try {
				// findAndHookMethod("com.android.phone.PhoneInterfaceManager",
				// null,
				// "disableLocationUpdatesForSubscriber", long.class,
				// new XC_MethodHook() {
				// @Override
				// protected void beforeHookedMethod(
				// MethodHookParam param) throws Throwable {
				// param.setResult(null);
				// XposedBridge
				// .log("��ϣ�disableLocationUpdatesForSubscriber");
				// return;
				// }
				// });
			} catch (Exception e) {
				XposedBridge.log("����FakeTelphoneManager--TelephonyRegistry.disableLocationUpdatesForSubscriber����Ϣ��" + e.getMessage());
			}

			// findAndHookMethod("com.android.phone.PhoneInterfaceManager",
			// null, "getAllCellInfo",
			// new XC_MethodHook() {
			// @Override
			// protected void afterHookedMethod(MethodHookParam param)
			// throws Throwable {
			// XposedBridge.log("����getAllCellInfo");
			// param.setResult(new ArrayList<CellInfo>());
			// XposedBridge.log("��ϣ�");
			// return;
			// }
			// });
			// findAndHookMethod("com.android.phone.PhoneInterfaceManager",
			// paramLoadPackageParam.classLoader, "getCellLocation",
			// new XC_MethodHook() {
			// @Override
			// protected void afterHookedMethod(MethodHookParam param)
			// throws Throwable {
			// param.setResult(getDefacedCellBundle(0));
			// return;
			// }
			// });
			//
			// findAndHookMethod("com.android.phone.PhoneInterfaceManager",
			// paramLoadPackageParam.classLoader,
			// "getNeighboringCellInfo", String.class,
			// new XC_MethodHook() {
			// @Override
			// protected void afterHookedMethod(MethodHookParam param)
			// throws Throwable {
			// param.setResult(new ArrayList<NeighboringCellInfo>());
			// return;
			// }
			// });
			// findAndHookMethod("com.android.phone.PhoneInterfaceManager",
			// paramLoadPackageParam.classLoader, "getCdmaMin",
			// long.class, new XC_MethodHook() {
			// @Override
			// protected void afterHookedMethod(MethodHookParam param)
			// throws Throwable {
			// param.setResult(null);
			// }
			// });

		} catch (Exception e) {
			XposedBridge.log("����:FakeTelphoneManager--PhoneInterfaceManager����Ϣ��" + e.getMessage());
		}

		// com.android.server.TelephonyRegistry
		try {
			XC_MethodHook listenHook = new XC_MethodHook() {
				@Override
				protected void afterHookedMethod(MethodHookParam param) throws Throwable {
					Util.XLog(param);
					param.setResult(null);
				}
			};

			findAndHookMethod("com.android.server.TelephonyRegistry", paramLoadPackageParam.classLoader, "listen", String.class, "com.android.internal.telephony.IPhoneStateListener", int.class,
					boolean.class, listenHook);

		} catch (Exception e) {
			XposedBridge.log("����:FakeTelphoneManager--TelephonyRegistry����Ϣ��" + e.getMessage());
		}

		// com.android.internal.telephony.PhoneSubInfo
		if (Build.VERSION.SDK_INT > 20) {
			try {
				XposedHelpers.findAndHookMethod("com.android.internal.telephony.PhoneSubInfo", paramLoadPackageParam.classLoader, "getImei", new XC_MethodHook() {
					@Override
					protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
						Util.XLog(param);
						param.setResult(info.IMEI);
						return;
					}
				});
			} catch (Exception e) {
				XposedBridge.log("����:FakeTelphoneManager--PhoneSubInfo����Ϣ��" + e.getMessage());
			}
		}
		// �޸�Configuration�е�MCC��MNC
		try {
			XposedHelpers.findAndHookMethod(Resources.class, "getConfiguration", new XC_MethodHook() {
				@Override
				protected void afterHookedMethod(MethodHookParam param) throws Throwable {
					Util.XLog(param);
					XposedHelpers.setIntField(param.getResult(), "mcc", 460);
					XposedHelpers.setIntField(param.getResult(), "mnc", Integer.parseInt(info.Operator.substring(4, 5)));// ("460",
																															// "")));
				}
			});
		} catch (Exception e) {
			XposedBridge.log("����:FakeTelphoneManager--Configuration����Ϣ��" + e.getMessage());
		}
	}

	@SuppressWarnings("unused")
	private static CellLocation getDefacedCellLocation(int uid) {
		// int cid = (Integer) PrivacyManager.getDefacedProp(uid, "CID");
		// int lac = (Integer) PrivacyManager.getDefacedProp(uid, "LAC");
		// if (cid > 0 && lac > 0) {
		// GsmCellLocation cellLocation = new GsmCellLocation();
		// cellLocation.setLacAndCid(lac, cid);
		// return cellLocation;
		// } else
		return CellLocation.getEmpty();
	}

	private static Bundle getDefacedCellBundle(int uid) {
		Bundle result = new Bundle();
		// int cid = (Integer) PrivacyManager.getDefacedProp(uid, "CID");
		// int lac = (Integer) PrivacyManager.getDefacedProp(uid, "LAC");
		// if (cid > 0 && lac > 0) {
		// result.putInt("lac", lac);
		// result.putInt("cid", cid);
		// }
		return result;
	}

	private class XPhoneStateListener extends PhoneStateListener {
		private PhoneStateListener mListener;

		public XPhoneStateListener(PhoneStateListener listener) {
			mListener = listener;
		}

		@Override
		public void onCallForwardingIndicatorChanged(boolean cfi) {
			mListener.onCallForwardingIndicatorChanged(cfi);
		}

		@Override
		public void onCallStateChanged(int state, String incomingNumber) {
			mListener.onCallStateChanged(state, info.Line1Number);
		}

		@SuppressLint("NewApi")
		@Override
		public void onCellInfoChanged(List<CellInfo> cellInfo) {
			mListener.onCellInfoChanged(new ArrayList<CellInfo>());
		}

		@Override
		public void onCellLocationChanged(CellLocation location) {
			// �˴��д���
			// mListener.onCellLocationChanged(LocationUtil.GetRandomLocation(location));
			// //XTelephonyManager.java 623��
			mListener.onCellLocationChanged(CellLocation.getEmpty());
		}

		@Override
		public void onDataActivity(int direction) {
			mListener.onDataActivity(direction);
		}

		@Override
		public void onDataConnectionStateChanged(int state) {
			mListener.onDataConnectionStateChanged(state);
		}

		@Override
		public void onDataConnectionStateChanged(int state, int networkType) {
			mListener.onDataConnectionStateChanged(state, networkType);
		}

		@Override
		public void onMessageWaitingIndicatorChanged(boolean mwi) {
			mListener.onMessageWaitingIndicatorChanged(mwi);
		}

		@Override
		public void onServiceStateChanged(ServiceState serviceState) {
			mListener.onServiceStateChanged(serviceState);
		}

		@Override
		@SuppressWarnings("deprecation")
		public void onSignalStrengthChanged(int asu) {
			mListener.onSignalStrengthChanged(asu);
		}

		@Override
		public void onSignalStrengthsChanged(SignalStrength signalStrength) {
			mListener.onSignalStrengthsChanged(signalStrength);
		}
	}

}
