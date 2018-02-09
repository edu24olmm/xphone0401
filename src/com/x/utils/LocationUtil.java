package com.x.utils;

import android.annotation.SuppressLint;
import android.location.Location;
import android.os.Build;
import android.os.SystemClock;
import com.x.phone.PhoneInfo;

import java.util.Random;


public class LocationUtil {
	public double Lat;
	public double Lon;
	public double Alt;
	public int Cid;
	public int Lac;
	
	public LocationUtil() {
	}
	
	public static LocationUtil getNew(){
		LocationUtil loc = new LocationUtil();
		Random r = new Random();
		int sitychance=r.nextInt(100);
		double[] beijing={116.233124,40.010451,116.525181,39.801456}; //地界标识，左上角经纬度，右下角经纬度
		double[] tianjing={117.022816,39.239227,117.503445,38.890516};
		double[] shanghai={121.340146,31.302,121.636227,31.193823};
		double[] chongqing={106.433474,29.639579,106.557656,29.490295};
		double[] guangzhou={113.205315,23.185443,113.428957,23.027486};
		double[] shenzhen={113.887994,22.585035,114.063344,22.532168};
		double[] nanjing={118.70621,32.167826,118.83959,31.940137};
		double[] hangzhou={120.122789,30.344056,120.342982,30.14588};
		double[] wuhan={114.185694,30.65617,114.430033,30.483534};
		double[] suzhou={120.553792,31.402846,120.740639,31.27059};
		double[] qita={112.281574,39.581546,117.21205,24.691997};
		if(sitychance<16){
			setloc(loc,beijing);
		}else if(sitychance<21){
			setloc(loc,tianjing);
		}else if(sitychance<36){
			setloc(loc,shanghai);
		}else if(sitychance<50){
			setloc(loc,guangzhou);
		}else if(sitychance<62){
			setloc(loc,shenzhen);
		}else if(sitychance<67){
			setloc(loc,nanjing);
		}else if(sitychance<72){
			setloc(loc,wuhan);
		}else if(sitychance<80){
			setloc(loc,chongqing);
		}else if(sitychance<87){
			setloc(loc,hangzhou);
		}else if(sitychance<91){
			setloc(loc,suzhou);
		}else{
			setloc(loc,qita);
		}		

		loc.Alt = r.nextDouble() * 2 * 68;
		loc.Cid = 0;
		loc.Lac = 0;

		return loc;
	}
	
	private static void setloc(LocationUtil loc,double[] range){
		loc.Lon=getRan(range[0],range[2]); //经度
		loc.Lat=getRan(range[3],range[1]); //纬度
	}
	
	
	
	public static double getRan(double a,double b){
		Random r = new Random();
		double c = r.nextDouble()*(a-b)+b;
		return Math.rint(c * 1e7) / 1e7;
	}

	
	@SuppressLint("NewApi")
	public static Location GetRandomLocation(Location location) {

		double sLat;// = "40.388";
		double sLon;// = "118.667";
		double sAlt;// = "686";

		if (location == null) {
			location = new Location("mockGps");
			PhoneInfo info = PhoneInfo.GetNow();
			sLat = info.Lat;
			sLon = info.Lon;
			sAlt = info.Alt;
		}else if(location.getLatitude()==0){
			location = new Location("mockGps");
			PhoneInfo info = PhoneInfo.GetNow();
			sLat = info.Lat;
			sLon = info.Lon;
			sAlt = info.Alt;
		} else {
			sLat = location.getLatitude();
			sLon = location.getLongitude();
			sAlt = location.getAltitude();
		}
		location.setAccuracy(3.0f);
		location.setSpeed(0.0f);
		location.setBearing(0.0f);
		if (Build.VERSION.SDK_INT > Build.VERSION_CODES.JELLY_BEAN)
			location.setElapsedRealtimeNanos(SystemClock.elapsedRealtimeNanos());

		
		location.setLatitude(sLat + (Math.random() - 0.5)
				* location.getAccuracy() * 0.00001);
		location.setLongitude(sLon + (Math.random() - 0.5)
				* location.getAccuracy() * 0.000001);
		location.setAltitude(sAlt);
		location.setAltitude(sAlt + (Math.random() - 0.5)
				* location.getAccuracy() * 0.0000001);
		location.setTime(System.currentTimeMillis());
		return location;

	}
}
