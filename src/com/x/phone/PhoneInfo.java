package com.x.phone;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Build;
import android.os.Environment;
import android.os.Message;
import android.text.TextUtils;
import android.util.Log;
import android.util.Xml;
import com.secneo.common.CommonUtils;
import com.secneo.common.GetStartApkHttpService;
import com.secneo.common.HttpsHandler;
import com.x.app.App;
import com.x.generator.*;
import com.x.utils.DateUtil;
import com.x.utils.LocationUtil;
import com.x.xphone.MyApplication;
import org.json.JSONException;
import org.json.JSONObject;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserFactory;
import org.xmlpull.v1.XmlSerializer;

import java.io.*;
import java.net.URLEncoder;
import java.util.*;

public class PhoneInfo {
	public int _id = 0;
	public String isReachTopOfEveryDay = "";
	public int taskIdValue = 0;
	public int KeepDays = 0;
	public int Days = 0;
	// public String IMSI;
	public int UseDays = 0;
	public String PackageName = "";
	public String IMEI = "";
	public String AndroidID = "";
	public String GsfId = "";
	public String AdId = "";
	public String Mac = "";
	public String SSID = "";
	public String BSSID = "";
	public String Ip = "";
	public String Line1Number = "";
	public String CountryIso = "";
	public String Operator = "";
	public String OperatorName = "";
	public String SimSerialNumber = "";
	public String SubscriberId = "";
	public int NetWorkType = 0;
	public String BOARD = "";
	public String BOOTLOADER = "";
	public String BRAND = "";
	public String CPU_ABI = "";
	public String CPU_ABI2 = "";
	public String DEVICE = "";
	public String DISPLAY = "";
	public String FINGERPRINT = "";
	public String HARDWARE = "";
	public String HOST = "";
	public String ID = "";
	public String MANUFACTURER = "";
	public String MODEL = "";
	public String PRODUCT = "";
	public String RADIO = "";
	public String SERIAL = "";
	public String TAGS = "";
	public String TIME = "";
	public String TYPE = "";
	public String USER = "";
	public String CODENAME = "";
	public String INCREMENTAL = "";
	public String RELEASE = "";
	public int SDK_INT = 0;
	public String SDK = "";
	public int Height;
	public int Width;
	public float Density = 0;
	public float ScaleDensity = 0;
	public float DensityDPI = 0;
	public float Xdpi = 0;
	public float Ydpi = 0;
	public String UA = "";
	public String BaseBand = "";
	public String OSVersion = "";
	public String PROCVersion = "";
	public String CPUINFO = "";
	public double Lat = 0;
	public double Lon = 0;
	public double Alt = 0;
	public int Cid = 0;
	public int Lac = 0;
	public String registerPhone = "";
	public String flagShua = "1";
	static PhoneInfo info = new PhoneInfo();

	/**
	 * 生成手机信息，写入xml文件
	 * 
	 * @param c
	 * @param taskIdValue
	 * @param regisionPhoneNum
	 * @param flagShua
	 * @return
	 */
	public static PhoneInfo CreatNew(Context c, int taskIdValue, String regisionPhoneNum, String flagShua, JSONObject jsonMsg) {

		try {

			Map ShuaList = App.GetAppList("Shua");
			// 将要刷的APP从列表中显示出来
			Collection<App> ShuaAppListColl = ShuaList.values();
			Iterator<App> ShuaAppListIter = ShuaAppListColl.iterator();

			String packageName = "";
			for (int i = 1; ShuaAppListIter.hasNext(); i++) {
				App a = ShuaAppListIter.next();
				packageName = a.pkg;
			}

			info.taskIdValue = taskIdValue;
			// info.KeepDays = KeepDaysUtil.getKeepDays(); // 获取留存天数
			info.KeepDays = 0; // 获取留存天数
			info.Days = DateUtil.Days();// 创建日期
			info.UseDays = DateUtil.Days();// 使用日期

			info.PackageName = packageName == null ? "" : packageName;// 刷哪个包时使用这个数据，暂时不区分
			// info.IMSI = createImsi(lineNumber);

			if (jsonMsg != null) {
				info.IMEI = jsonMsg.get("IMEI") + "";
			} else {
				info.IMEI = ImeiUtil.CreateIMEI();
			}

			info.AndroidID = RanUtil.getRanStr(16);
			info.GsfId = RanUtil.getRanStr(16);// GSF ID和Android ID格式一样
			info.AdId = RanUtil.getRanStr(8) + "-" + RanUtil.getRanStr(4) + "-" + RanUtil.getRanStr(4) + "-" + RanUtil.getRanStr(12);// 8-4-4-12

			if (jsonMsg != null) {
				info.Mac = jsonMsg.get("mac") + "";
				info.BSSID = jsonMsg.get("mac") + "";
			} else {
				info.Mac = WifiUtil.getMac();
				info.BSSID = WifiUtil.getMac();
			}

			info.SSID = WifiUtil.getSSID();
			info.Ip = WifiUtil.getIp();
			info.CountryIso = "86";

			if (jsonMsg != null) {
				String SimSerialNumber = jsonMsg.getString("simSerialNumber");
				if (!TextUtils.isEmpty(SimSerialNumber) && SimSerialNumber.length() >= 5) {
					info.Operator = SimSerialNumber.substring(0, 4);
					info.OperatorName = SimSerialNumber.substring(0, 4);
					info.SimSerialNumber = SimSerialNumber;
					info.NetWorkType = OperatorUtil.getNetWorkType(info.Operator);
				} else {
					info.Operator = "";
					info.OperatorName = "";
					info.SimSerialNumber = "";
					info.NetWorkType = 1;
				}

			} else {
				OperatorUtil aa = OperatorUtil.getNew();
				info.Operator = aa.Operator;
				info.OperatorName = aa.OperatorName;
				info.SimSerialNumber = aa.SimSerialNumber;
				info.NetWorkType = aa.NetWorkType;
				// info.SubscriberId = aa.SubID;
			}

			if (jsonMsg != null) {
				info.SubscriberId = jsonMsg.getString("subscriberId");
				info.Line1Number = getLineNumberBySubscriberId(info.SubscriberId);
			} else {
				String lineNumber = WifiUtil.getPhoneNum();
				info.Line1Number = lineNumber;
				info.SubscriberId = createImsi(lineNumber);
			}

			// 手机序列号
			// Random r = new Random();
			// long v = r.nextLong();
			info.SERIAL = RanUtil.getRanStr(7);
			// 手机型号相关
			Model mod = Model.GetRondom();
			info.BOARD = mod.BOARD; // 机型相关
			info.BOOTLOADER = mod.BOOTLOADER;
			info.BRAND = mod.BRAND;
			info.CPU_ABI = mod.CPU_ABI;
			info.CPU_ABI2 = mod.CPU_ABI2;
			info.DEVICE = mod.DEVICE;
			info.DISPLAY = mod.DISPLAY;
			info.FINGERPRINT = mod.FINGERPRINT;
			info.HARDWARE = mod.FINGERPRINT;
			info.HOST = mod.HOST;
			info.ID = mod.ID;
			info.MANUFACTURER = mod.MANUFACTURER;
			if (jsonMsg != null) {
				info.MODEL = jsonMsg.get("MODEL") + "";
			} else {
				info.MODEL = mod.MODEL;
			}
			info.PRODUCT = mod.PRODUCT;
			info.RADIO = mod.RADIO;
			info.TAGS = mod.TAGS;
			info.TIME = mod.TIME;
			info.TYPE = mod.TYPE;
			info.USER = mod.USER;
			info.CODENAME = mod.CODENAME;
			info.INCREMENTAL = mod.INCREMENTAL;
			info.RELEASE = mod.RELEASE;
			if (jsonMsg != null) {
				info.SDK_INT = jsonMsg.getInt("SDK_INT");
			} else {
				info.SDK_INT = Build.VERSION.SDK_INT;// mod.SDK_INT;
			}
			info.SDK = Build.VERSION.SDK;// mod.SDK;
			// 屏幕相关
			info.Height = mod.Height;
			info.Width = mod.Width;
			// info.Density = mod.Density;
			// info.ScaleDensity = mod.ScaleDensity;
			// info.DensityDPI = mod.DensityDPI;
			info.Xdpi = mod.Xdpi;
			info.Ydpi = mod.Ydpi;
			info.UA = mod.UA;
			info.BaseBand = mod.BaseBand;
			info.OSVersion = mod.OSVersion;
			info.PROCVersion = mod.PROCVersion;
			info.CPUINFO = mod.CPUINFO;
			LocationUtil loc = LocationUtil.getNew();
			info.Lat = loc.Lat; // 经度
			info.Lon = loc.Lon; // 纬度
			info.Alt = loc.Alt; // 海拔
			info.Cid = loc.Cid; // 小区编号
			info.Lac = loc.Lac; // 位置区码
			info.registerPhone = regisionPhoneNum;
			if (TextUtils.isEmpty(flagShua)) {
				flagShua = "1";
			}
			info.flagShua = flagShua;

		} catch (Exception e) {
			Log.i("xphone", "新手机生成错误，错误信息：" + e.getMessage());
		}
		// info.Save(MyApplication.getAppContext());
		try {
			String flag = info.SaveToServer(c, taskIdValue, regisionPhoneNum, flagShua);
			if (TextUtils.isEmpty(flag)) {
				return null;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		info.PushIn();
		return info;
	}

	private String SaveToServer(Context c, int taskIdValue, String registerPhone, String flagShua) throws Exception {
		JSONObject member1 = new JSONObject();
		try {
			member1.put("taskId", taskIdValue);
			member1.put("KeepDays", KeepDays);
			member1.put("Days", Days);
			member1.put("UseDays", UseDays);
			member1.put("PackageName", PackageName);
			member1.put("IMEI", IMEI);
			member1.put("AndroidID", AndroidID);
			member1.put("GsfId", GsfId);
			member1.put("AdId", AdId);
			member1.put("Mac", Mac);
			member1.put("SSID", SSID);
			member1.put("BSSID", BSSID);
			member1.put("Ip", Ip);
			member1.put("Line1Number", Line1Number);
			member1.put("CountryIso", CountryIso);
			member1.put("Operator", Operator);
			member1.put("OperatorName", OperatorName);
			member1.put("SimSerialNumber", SimSerialNumber);
			member1.put("SubscriberId", SubscriberId);
			member1.put("NetWorkType", NetWorkType);
			member1.put("BOARD", BOARD);
			member1.put("BOOTLOADER", BOOTLOADER);
			member1.put("BRAND", BRAND);
			member1.put("CPU_ABI", CPU_ABI);
			member1.put("CPU_ABI2", CPU_ABI2);
			member1.put("DEVICE", DEVICE);
			member1.put("DISPLAY", DISPLAY);
			member1.put("FINGERPRINT", FINGERPRINT);
			member1.put("HARDWARE", HARDWARE);
			member1.put("HOST", HOST);
			member1.put("ID", ID);
			member1.put("MANUFACTURER", MANUFACTURER);
			member1.put("MODEL", MODEL);
			member1.put("PRODUCT", PRODUCT);
			member1.put("RADIO", RADIO);
			member1.put("SERIAL", SERIAL);
			member1.put("TAGS", TAGS);
			member1.put("TIME", TIME);
			member1.put("TYPE", TYPE);
			member1.put("USER", USER);
			member1.put("CODENAME", CODENAME);
			member1.put("INCREMENTAL", INCREMENTAL);
			member1.put("RELEASE", RELEASE);
			member1.put("SDK_INT", SDK_INT);
			member1.put("SDK", SDK);
			member1.put("Height", Height);
			member1.put("Width", Width);
			member1.put("Density", Density);
			member1.put("ScaleDensity", ScaleDensity);
			member1.put("DensityDPI", DensityDPI);
			member1.put("Xdpi", Xdpi);
			member1.put("Ydpi", Ydpi);
			member1.put("UA", UA);
			member1.put("BaseBand", BaseBand);
			member1.put("OSVersion", OSVersion);
			member1.put("PROCVersion", PROCVersion);
			member1.put("CPUINFO", CPUINFO);
			member1.put("Lat", Lat);
			member1.put("Lon", Lon);
			member1.put("Alt", Alt);
			member1.put("Cid", Cid);
			member1.put("Lac", Lac);
			member1.put("registerPhone", registerPhone);
			member1.put("flagShua", flagShua);

		} catch (Exception e) {
			e.printStackTrace();
		}

		String strRequest = member1.toString();
		strRequest = URLEncoder.encode(strRequest, "UTF-8");
		String url = GetStartApkHttpService.SaveToServer + "phoneInfo=" + strRequest;
		if (c != null) {
			invokeSaveKeepHttp(c, url);
		} else {
			Map<String, String> map = new HashMap<String, String>();
			GetStartApkHttpService.sendGetRequest(url, map, "UTF-8");
		}

		return "success";
	}

	public void invokeSaveKeepHttp(Context context, String url) {
		keyhandler.getHttpsResponse(context, url, "");
	}

	private HttpsHandler keyhandler = new HttpsHandler() {
		public void onHttpFailure(Message msg) {
			super.onHttpFailure(msg);
			System.out.println("faile..." + msg.obj.toString());
		};

		@Override
		public void onHttpSuccess(Message msg) {
			super.onHttpSuccess(msg);
			System.out.println("key..." + msg.obj.toString());
		}
	};

	public static int getCountByDay(int Days) {
		return getCountByDaysAndForm(Days, "New");
	}

	public static int getKeepCountByDay(int Days) {
		return getCountByDaysAndForm(Days, "Keep");
	}

	private static int getCountByDaysAndForm(int Days, String FormName) {
		DbM dbm = new DbM(MyApplication.getAppContext());
		SQLiteDatabase db = dbm.getReadableDatabase();
		int count = 0;
		if (FormName.intern() == "New".intern()) {
			Cursor cursor = db.rawQuery("select * from New where Days=?", new String[] { Days + "" });
			count = cursor.getCount();
			cursor.close();
			db.close();
			dbm.close();
		} else if (FormName.intern() == "Keep".intern()) {
			Cursor cursor = db.rawQuery("select * from Keep where UseDays=?", new String[] { Days + "" });
			count = cursor.getCount();
			cursor.close();
			db.close();
			dbm.close();
		}
		return count;
	}

	public static PhoneInfo GetNow() {
		// 当前的手机配置只能从xml文件中读取
		// PhoneInfo info = new PhoneInfo();
		try {
			XmlPullParser parser = XmlPullParserFactory.newInstance().newPullParser();
			String sddir = Environment.getExternalStorageDirectory().getPath();
			File file = new File(sddir + "/.shenqi/now.xml");
			if (!file.exists())
				return info;
			parser.setInput(new FileInputStream(file), "UTF-8");
			int type = parser.getEventType();
			while (type != XmlPullParser.END_DOCUMENT) {
				switch (type) {
				case XmlPullParser.START_TAG:
					if (parser.getName().equals("taskId")) {
						info.taskIdValue = Integer.parseInt(parser.nextText());
					} else if (parser.getName().equals("registerPhone")) {
						info.registerPhone = parser.nextText();
					} else if (parser.getName().equals("KeepDays")) {
						info.KeepDays = Integer.parseInt(parser.nextText());
					} else if (parser.getName().equals("Days")) {
						info.Days = Integer.parseInt(parser.nextText());
					} else if (parser.getName().equals("UseDays")) {
						info.UseDays = Integer.parseInt(parser.nextText());
					} else if (parser.getName().equals("PackageName")) {
						info.PackageName = parser.nextText();
					} else if (parser.getName().equals("IMEI")) {
						info.IMEI = parser.nextText();
					} else if (parser.getName().equals("AndroidID")) {
						info.AndroidID = parser.nextText();
					} else if (parser.getName().equals("GsfId")) {
						info.GsfId = parser.nextText();
					} else if (parser.getName().equals("AdId")) {
						info.AdId = parser.nextText();
					} else if (parser.getName().equals("Mac")) {
						info.Mac = parser.nextText();
					} else if (parser.getName().equals("SSID")) {
						info.SSID = parser.nextText();
					} else if (parser.getName().equals("BSSID")) {
						info.BSSID = parser.nextText();
					} else if (parser.getName().equals("Ip")) {
						info.Ip = parser.nextText();
					} else if (parser.getName().equals("Line1Number")) {
						info.Line1Number = parser.nextText();
					} else if (parser.getName().equals("CountryIso")) {
						info.CountryIso = parser.nextText();
					} else if (parser.getName().equals("Operator")) {
						info.Operator = parser.nextText();
					} else if (parser.getName().equals("OperatorName")) {
						info.OperatorName = parser.nextText();
					} else if (parser.getName().equals("SimSerialNumber")) {
						info.SimSerialNumber = parser.nextText();
					} else if (parser.getName().equals("SubscriberId")) {
						info.SubscriberId = parser.nextText();
					} else if (parser.getName().equals("NetWorkType")) {
						info.NetWorkType = Integer.parseInt(parser.nextText());
					} else if (parser.getName().equals("BOARD")) {
						info.BOARD = parser.nextText();
					} else if (parser.getName().equals("BOOTLOADER")) {
						info.BOOTLOADER = parser.nextText();
					} else if (parser.getName().equals("BRAND")) {
						info.BRAND = parser.nextText();
					} else if (parser.getName().equals("CPU_ABI")) {
						info.CPU_ABI = parser.nextText();
					} else if (parser.getName().equals("CPU_ABI2")) {
						info.CPU_ABI2 = parser.nextText();
					} else if (parser.getName().equals("DEVICE")) {
						info.DEVICE = parser.nextText();
					} else if (parser.getName().equals("DISPLAY")) {
						info.DISPLAY = parser.nextText();
					} else if (parser.getName().equals("FINGERPRINT")) {
						info.FINGERPRINT = parser.nextText();
					} else if (parser.getName().equals("HARDWARE")) {
						info.HARDWARE = parser.nextText();
					} else if (parser.getName().equals("HOST")) {
						info.HOST = parser.nextText();
					} else if (parser.getName().equals("ID")) {
						info.ID = parser.nextText();
					} else if (parser.getName().equals("MANUFACTURER")) {
						info.MANUFACTURER = parser.nextText();
					} else if (parser.getName().equals("MODEL")) {
						info.MODEL = parser.nextText();
					} else if (parser.getName().equals("PRODUCT")) {
						info.PRODUCT = parser.nextText();
					} else if (parser.getName().equals("RADIO")) {
						info.RADIO = parser.nextText();
					} else if (parser.getName().equals("SERIAL")) {
						info.SERIAL = parser.nextText();
					} else if (parser.getName().equals("TAGS")) {
						info.TAGS = parser.nextText();
					} else if (parser.getName().equals("TIME")) {
						info.TIME = parser.nextText();
					} else if (parser.getName().equals("TYPE")) {
						info.TYPE = parser.nextText();
					} else if (parser.getName().equals("USER")) {
						info.USER = parser.nextText();
					} else if (parser.getName().equals("CODENAME")) {
						info.CODENAME = parser.nextText();
					} else if (parser.getName().equals("INCREMENTAL")) {
						info.INCREMENTAL = parser.nextText();
					} else if (parser.getName().equals("RELEASE")) {
						info.RELEASE = parser.nextText();
					} else if (parser.getName().equals("SDK_INT")) {
						info.SDK_INT = Integer.parseInt(parser.nextText());
					} else if (parser.getName().equals("SDK")) {
						info.SDK = parser.nextText();
					} else if (parser.getName().equals("Height")) {
						info.Height = Integer.parseInt(parser.nextText());
					} else if (parser.getName().equals("Width")) {
						info.Width = Integer.parseInt(parser.nextText());
					} else if (parser.getName().equals("Density")) {
						info.Density = Float.parseFloat(parser.nextText());
					} else if (parser.getName().equals("ScaleDensity")) {
						info.ScaleDensity = Float.parseFloat(parser.nextText());
					} else if (parser.getName().equals("DensityDPI")) {
						info.DensityDPI = Float.parseFloat(parser.nextText());
					} else if (parser.getName().equals("Xdpi")) {
						info.Xdpi = Float.parseFloat(parser.nextText());
					} else if (parser.getName().equals("Ydpi")) {
						info.Ydpi = Float.parseFloat(parser.nextText());
					} else if (parser.getName().equals("UA")) {
						info.UA = parser.nextText();
					} else if (parser.getName().equals("BaseBand")) {
						info.BaseBand = parser.nextText();
					} else if (parser.getName().equals("OSVersion")) {
						info.OSVersion = parser.nextText();
					} else if (parser.getName().equals("PROCVersion")) {
						info.PROCVersion = parser.nextText();
					} else if (parser.getName().equals("CPUINFO")) {
						info.CPUINFO = parser.nextText();
					} else if (parser.getName().equals("Lat")) {
						info.Lat = Double.parseDouble(parser.nextText());
					} else if (parser.getName().equals("Lon")) {
						info.Lon = Double.parseDouble(parser.nextText());
					} else if (parser.getName().equals("Alt")) {
						info.Alt = Double.parseDouble(parser.nextText());
					} else if (parser.getName().equals("Ydpi")) {
						info.Cid = Integer.parseInt(parser.nextText());
					} else if (parser.getName().equals("Ydpi")) {
						info.Lac = Integer.parseInt(parser.nextText());
					} else if (parser.getName().equals("flagShua")) {
						info.flagShua = parser.nextText();
					}

					break;
				case XmlPullParser.END_TAG:
					break;
				default:
					break;
				}
				type = parser.next();
			}
		} catch (Exception e) {
			Log.i("出错了", e.getMessage());
		}

		return info;
	}

	private void PushIn() {
		try {

			// 刷入手机
			String sddir = Environment.getExternalStorageDirectory().getPath();
			XmlSerializer xml = Xml.newSerializer();
			File dir = new File(sddir + "/.shenqi/");
			if (!dir.exists())
				dir.mkdirs();
			File nowFile = new File(sddir + "/.shenqi/now.xml");
			OutputStream os = new FileOutputStream(nowFile);
			// 指定输出流
			xml.setOutput(os, "utf-8");
			// 开始文档
			xml.startDocument("utf-8", true);
			xml.startTag("", "Phones");
			xml.startTag("", "Phone");

			xmlTag(xml, "registerPhone", registerPhone + "");
			xmlTag(xml, "taskId", taskIdValue + "");
			xmlTag(xml, "KeepDays", KeepDays + "");
			xmlTag(xml, "Days", Days + "");
			xmlTag(xml, "UseDays", UseDays + "");
			xmlTag(xml, "PackageName", PackageName);
			xmlTag(xml, "IMEI", IMEI);
			xmlTag(xml, "AndroidID", AndroidID);
			xmlTag(xml, "GsfId", GsfId);
			xmlTag(xml, "AdId", AdId);
			xmlTag(xml, "Mac", Mac);
			xmlTag(xml, "SSID", SSID);
			xmlTag(xml, "BSSID", BSSID);
			xmlTag(xml, "Ip", Ip);
			xmlTag(xml, "Line1Number", Line1Number);
			xmlTag(xml, "CountryIso", CountryIso);
			xmlTag(xml, "Operator", Operator);
			xmlTag(xml, "OperatorName", OperatorName);
			xmlTag(xml, "SimSerialNumber", SimSerialNumber);
			xmlTag(xml, "SubscriberId", SubscriberId);
			xmlTag(xml, "NetWorkType", NetWorkType + "");
			xmlTag(xml, "BOARD", BOARD);
			xmlTag(xml, "BOOTLOADER", BOOTLOADER);
			xmlTag(xml, "BRAND", BRAND);
			xmlTag(xml, "CPU_ABI", CPU_ABI);
			xmlTag(xml, "CPU_ABI2", CPU_ABI2);
			xmlTag(xml, "DEVICE", DEVICE);
			xmlTag(xml, "DISPLAY", DISPLAY);
			xmlTag(xml, "FINGERPRINT", FINGERPRINT);
			xmlTag(xml, "HARDWARE", HARDWARE);
			xmlTag(xml, "HOST", HOST);
			xmlTag(xml, "ID", ID);
			xmlTag(xml, "MANUFACTURER", MANUFACTURER);
			xmlTag(xml, "MODEL", MODEL);
			xmlTag(xml, "PRODUCT", PRODUCT);
			xmlTag(xml, "RADIO", RADIO);
			xmlTag(xml, "SERIAL", SERIAL);
			xmlTag(xml, "TAGS", TAGS);
			xmlTag(xml, "TIME", TIME + "");
			xmlTag(xml, "TYPE", TYPE);
			xmlTag(xml, "USER", USER);
			xmlTag(xml, "CODENAME", CODENAME);
			xmlTag(xml, "INCREMENTAL", INCREMENTAL);
			xmlTag(xml, "RELEASE", RELEASE);
			xmlTag(xml, "SDK_INT", SDK_INT + "");
			xmlTag(xml, "SDK", SDK + "");
			xmlTag(xml, "Height", Height + "");
			xmlTag(xml, "Width", Width + "");
			xmlTag(xml, "Density", Density + "");

			xmlTag(xml, "ScaleDensity", ScaleDensity + "");
			xmlTag(xml, "DensityDPI", DensityDPI + "");

			xmlTag(xml, "Xdpi", Xdpi + "");
			xmlTag(xml, "Ydpi", Ydpi + "");

			xmlTag(xml, "UA", UA);
			xmlTag(xml, "BaseBand", BaseBand);
			xmlTag(xml, "OSVersion", OSVersion);
			xmlTag(xml, "PROCVersion", PROCVersion);
			xmlTag(xml, "CPUINFO", CPUINFO);
			xmlTag(xml, "Lat", Lat + "");
			xmlTag(xml, "Lon", Lon + "");
			xmlTag(xml, "Alt", Alt + "");
			xmlTag(xml, "Cid", Cid + "");
			xmlTag(xml, "Lac", Lac + "");

			if (!TextUtils.isEmpty(flagShua)) {
				xmlTag(xml, "flagShua", flagShua + "");
			}

			// 结束标签
			xml.endTag("", "Phone");
			xml.endTag("", "Phones");
			// 结束文档
			xml.endDocument();
		} catch (Exception e) {
			Log.i("xphone", "刷入手机出错，错误信息：" + e.getMessage());
		}
	}

	/**
	 * 刷留存0，刷新增1, 刷新增注册2 , 到量 3,刷注册留存 4 刷留存会把留存数据返回来，写入xml文件，新增的话，不写入
	 * 
	 * @param uiatStr
	 * @return
	 * @throws JSONException
	 * @throws Exception
	 */
	public String getKeepByServer(String uiatStr) throws JSONException {

		if (uiatStr == null) {
			return "";
		}

		JSONObject json = new JSONObject(uiatStr);
		flagShua = json.get("flagShua") + "";
		// 刷留存0，刷新增1, 刷新增注册2 , 到量 3,刷注册留存 4
		if ("0".equalsIgnoreCase(flagShua) || "4".equalsIgnoreCase(flagShua)) {

			taskIdValue = Integer.valueOf(json.get("taskId") + "");
			KeepDays = Integer.valueOf(json.get("keepDays") + "");
			Days = Integer.valueOf(json.get("days") + "");
			UseDays = Integer.valueOf(json.get("useDays") + "");

			Object PackageName_ = json.get("packageName");
			PackageName = PackageName_ + "";

			IMEI = (String) json.get("IMEI");
			AndroidID = (String) json.get("androidID");
			GsfId = (String) json.get("gsfId");
			AdId = (String) json.get("adId");
			Mac = (String) json.get("mac");
			SSID = (String) json.get("SSID");
			BSSID = (String) json.get("BSSID");
			Ip = (String) json.get("ip");
			Line1Number = (String) json.get("line1Number");
			CountryIso = (String) json.get("countryIso");
			Operator = (String) json.get("operator");
			OperatorName = (String) json.get("operatorName");
			SimSerialNumber = (String) json.get("simSerialNumber");
			SubscriberId = (String) json.get("subscriberId");
			NetWorkType = Integer.valueOf(json.get("netWorkType") + "");
			BOARD = (String) json.get("BOARD");
			BOOTLOADER = (String) json.get("BOOTLOADER");
			BRAND = (String) json.get("BRAND");
			CPU_ABI = (String) json.get("CPU_ABI");
			CPU_ABI2 = (String) json.get("CPU_ABI2");
			DEVICE = (String) json.get("DEVICE");
			DISPLAY = (String) json.get("DISPLAY");
			FINGERPRINT = (String) json.get("FINGERPRINT");
			HARDWARE = (String) json.get("HARDWARE");
			HOST = (String) json.get("HOST");
			ID = (String) json.get("ID");
			MANUFACTURER = (String) json.get("MANUFACTURER");
			MODEL = (String) json.get("MODEL");
			PRODUCT = (String) json.get("PRODUCT");
			RADIO = (String) json.get("RADIO");
			SERIAL = (String) json.get("SERIAL");
			TAGS = (String) json.get("TAGS");
			TIME = (String) json.get("TIME");
			TYPE = (String) json.get("TYPE");
			USER = (String) json.get("USER");
			CODENAME = (String) json.get("CODENAME");
			INCREMENTAL = (String) json.get("INCREMENTAL");
			RELEASE = (String) json.get("RELEASE");
			SDK_INT = Integer.valueOf(json.get("SDK_INT") + "");
			SDK = (String) json.get("SDK");
			Height = Integer.valueOf(json.get("height") + "");
			Width = Integer.valueOf(json.get("width") + "");
			Density = Float.parseFloat(json.get("density").toString());

			ScaleDensity = Float.parseFloat(json.get("scaleDensity").toString());
			DensityDPI = Float.parseFloat(json.get("densityDPI").toString());

			Xdpi = Float.parseFloat(json.get("xdpi").toString());
			Ydpi = Float.parseFloat(json.get("ydpi").toString());
			UA = (String) json.get("UA");
			BaseBand = (String) json.get("baseBand");
			OSVersion = (String) json.get("OSVersion");
			PROCVersion = (String) json.get("PROCVersion");
			CPUINFO = (String) json.get("CPUINFO");
			Lat = Double.parseDouble(json.get("lat").toString());
			Lon = Double.parseDouble(json.get("lon").toString());
			Alt = Double.parseDouble(json.get("alt").toString());
			Cid = Integer.valueOf(json.get("cid") + "");
			Lac = Integer.valueOf(json.get("lac") + "");

			if ("4".equalsIgnoreCase(flagShua)) {
				Log.i("registerUserInfo", json.get("registerPhone") + "");
				registerPhone = json.get("registerPhone") + "";
			}

			PushIn();

		}

		return flagShua;

	}

	// 刷留存0，刷新增1, 刷新增注册2 , 到量 3,刷注册留存 4

	public static String createImsi(String phone) {
		List mobs = new ArrayList();
		mobs.add("138");
		mobs.add("134");
		mobs.add("135");
		mobs.add("139");
		mobs.add("136");
		mobs.add("137");

		mobs.add("150");
		mobs.add("151");
		mobs.add("152");
		mobs.add("158");
		mobs.add("159");
		mobs.add("188");

		List uns = new ArrayList();

		uns.add("131");
		uns.add("132");

		uns.add("155");
		uns.add("156");

		uns.add("186");
		uns.add("185");

		List cts = new ArrayList();
		cts.add("133");
		cts.add("153");
		cts.add("189");

		String imsi = "355710" + CommonUtils.random(100000000, 999999999);

		String subThree = phone.substring(0, 3);
		if (mobs.contains(subThree)) {
			if ("134".equals(subThree))
				imsi = "46001" + CommonUtils.random(0, 9) + CommonUtils.random(100000000, 999999999);
			else if ("159".equals(subThree))
				imsi = "46002" + CommonUtils.random(0, 9) + CommonUtils.random(100000000, 999999999);
			else
				imsi = "46000" + CommonUtils.random(0, 9) + CommonUtils.random(100000000, 999999999);
		} else if (uns.contains(subThree)) {
			imsi = "46001" + CommonUtils.random(0, 9) + CommonUtils.random(100000000, 999999999);
		} else if (cts.contains(subThree)) {
			if ("133".equals(subThree))
				imsi = "46003" + CommonUtils.random(0, 9) + CommonUtils.random(100000000, 999999999);
			else
				imsi = "46002" + CommonUtils.random(0, 9) + CommonUtils.random(100000000, 999999999);
		} else {
			imsi = "46000" + CommonUtils.random(0, 9) + CommonUtils.random(100000000, 999999999);
		}

		return imsi;
	}

	/**
	 * 根据序列号算出手机号
	 * 
	 * @param subscriberId
	 * @return
	 */
	public static String getLineNumberBySubscriberId(String subscriberId) {
		// TODO 自动生成的方法存根

		Random random = new Random();
		List<String> l46000 = new ArrayList<String>();
		l46000.add("135");
		l46000.add("136");
		l46000.add("137");
		l46000.add("138");
		l46000.add("139");

		List<String> l46001 = new ArrayList<String>();
		l46001.add("130");
		l46001.add("131");
		l46001.add("132");
		l46001.add("155");
		l46001.add("156");

		List<String> l46002 = new ArrayList<String>();
		l46002.add("159");
		l46002.add("158");
		l46002.add("150");
		l46002.add("151");

		List<String> l46003 = new ArrayList<String>();
		l46003.add("133");
		l46003.add("180");
		l46003.add("153");
		l46003.add("189");

		List<String> l46007 = new ArrayList<String>();
		l46007.add("157");
		l46007.add("188");
		l46007.add("187");
		l46007.add("147");

		if (TextUtils.isEmpty(subscriberId)) {
			return "";
		} else {
			String begin = subscriberId.substring(0, 4);
			if ("46001".equalsIgnoreCase(begin)) {
				int i = random.nextInt(l46001.size());
				return l46001.get(i) + CommonUtils.random(10000000, 99999999);
			} else if ("46002".equalsIgnoreCase(begin)) {
				int i = random.nextInt(l46002.size());
				return l46002.get(i) + CommonUtils.random(10000000, 99999999);
			} else if ("46003".equalsIgnoreCase(begin)) {
				int i = random.nextInt(l46003.size());
				return l46003.get(i) + CommonUtils.random(10000000, 99999999);
			} else if ("46000".equalsIgnoreCase(begin)) {
				int i = random.nextInt(l46000.size());
				return l46000.get(i) + CommonUtils.random(10000000, 99999999);
			} else if ("46007".equalsIgnoreCase(begin)) {
				int i = random.nextInt(l46007.size());
				return l46007.get(i) + CommonUtils.random(10000000, 99999999);
			} else {
				return "";
			}
		}
	}

	public static void xmlTag(XmlSerializer xml, String Tag, String Value) throws IllegalArgumentException, IllegalStateException, IOException {
		if (Value == null) {
			Value = "";
			Log.i("xphone", "序列化成XML时出错，错误字段：" + Tag);
		}
		xml.startTag("", Tag);
		xml.text(Value);
		xml.endTag("", Tag);
	}

	public String getRetMsg() {
		// TODO 自动生成的方法存根
		return null;
	}

}
