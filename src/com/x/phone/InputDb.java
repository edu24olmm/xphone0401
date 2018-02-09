package com.x.phone;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteDatabase.CursorFactory;
import android.database.sqlite.SQLiteOpenHelper;

public class InputDb extends SQLiteOpenHelper {
	private static final int VERSION = 1;
	public static String DbName="history";

	public InputDb(Context context, CursorFactory factory, int version) {
		// 必须通过super调用父类当中的构造函数
		super(context, DbName, factory, version);
	}

	public InputDb(Context context, int version) {
		this(context, null, version);
	}

	public InputDb(Context context) {
		this(context, VERSION); 
	}

	@Override
	public void onCreate(SQLiteDatabase db) {
		// execSQL用于执行SQL语句
//		db.execSQL("CREATE TABLE IF NOT EXISTS New ( _id INTEGER PRIMARY KEY, KeepDays INT, Days INT, UseDays INT, PackageName TEXT,IMEI TEXT,AndroidID TEXT, GsfId TEXT, AdId TEXT, Mac TEXT, SSID TEXT, BSSID TEXT, Ip TEXT, Line1Number TEXT, CountryIso TEXT, Operator TEXT, OperatorName TEXT, SimSerialNumber TEXT, SubscriberId TEXT,NetWorkType INT, BOARD TEXT, BOOTLOADER TEXT, BRAND TEXT, CPU_ABI TEXT, CPU_ABI2 TEXT, DEVICE TEXT, DISPLAY TEXT, FINGERPRINT TEXT, HARDWARE TEXT, HOST TEXT, ID TEXT, MANUFACTURER TEXT, MODEL TEXT, PRODUCT TEXT, RADIO TEXT, SERIAL TEXT, TAGS TEXT, TIME float,TYPE TEXT, USER TEXT, CODENAME TEXT, INCREMENTAL TEXT, RELEASE TEXT, SDK_INT INT, SDK TEXT,Height INT, Width INT, Density float,ScaleDensity float,DensityDPI float, Xdpi float, Ydpi float, UA TEXT, BaseBand TEXT, OSVersion TEXT, PROCVersion TEXT, CPUINFO TEXT ,Lat double,Lon double,Alt double,Cid INT,Lac INT )");
//		db.execSQL("CREATE TABLE IF NOT EXISTS Keep ( _id INTEGER PRIMARY KEY, KeepDays INT, Days INT, UseDays INT, PackageName TEXT,IMEI TEXT,AndroidID TEXT, GsfId TEXT, AdId TEXT, Mac TEXT, SSID TEXT, BSSID TEXT, Ip TEXT, Line1Number TEXT, CountryIso TEXT, Operator TEXT, OperatorName TEXT, SimSerialNumber TEXT, SubscriberId TEXT,NetWorkType INT, BOARD TEXT, BOOTLOADER TEXT, BRAND TEXT, CPU_ABI TEXT, CPU_ABI2 TEXT, DEVICE TEXT, DISPLAY TEXT, FINGERPRINT TEXT, HARDWARE TEXT, HOST TEXT, ID TEXT, MANUFACTURER TEXT, MODEL TEXT, PRODUCT TEXT, RADIO TEXT, SERIAL TEXT, TAGS TEXT, TIME float,TYPE TEXT, USER TEXT, CODENAME TEXT, INCREMENTAL TEXT, RELEASE TEXT, SDK_INT INT, SDK TEXT,Height INT, Width INT, Density float, ScaleDensity float, DensityDPI float, Xdpi float,Ydpi float, UA TEXT, BaseBand TEXT, OSVersion TEXT, PROCVersion TEXT, CPUINFO TEXT,Lat double,Lon double,Alt double,Cid INT,Lac INT )");
//		db.execSQL("CREATE TABLE IF NOT EXISTS Settings ( _id INTEGER PRIMARY KEY, key TEXT, value TEXT, IMEI TEXT,UseDays INT)");
	}
	@Override
	public void onUpgrade(SQLiteDatabase arg0, int arg1, int arg2) {
		// TODO Auto-generated method stub
		//System.out.println("upgrade a database");
	}
}
