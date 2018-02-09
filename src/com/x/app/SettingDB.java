package com.x.app;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

import android.os.Environment;
import android.provider.Settings;

import com.x.phone.PhoneInfo;
import com.x.utils.Setting;
import com.x.utils.ShellUtil;

public class SettingDB {

	public static boolean isSystemKey(String key) {
		final Set<String> set = new HashSet<String>();
		set.add(Settings.Secure.ACCESSIBILITY_ENABLED);
		set.add(Settings.Secure.ACCESSIBILITY_SPEAK_PASSWORD);
		set.add(Settings.Secure.ADB_ENABLED);
		set.add(Settings.Secure.ALLOW_MOCK_LOCATION);
		set.add(Settings.Secure.ALLOWED_GEOLOCATION_ORIGINS);
		set.add(Settings.Secure.BACKGROUND_DATA);
		set.add(Settings.Secure.BLUETOOTH_ON);
		set.add(Settings.Secure.DATA_ROAMING);
		set.add(Settings.Secure.DEFAULT_INPUT_METHOD);
		set.add(Settings.Secure.DEVELOPMENT_SETTINGS_ENABLED);
		set.add(Settings.Secure.DEVICE_PROVISIONED);
		set.add(Settings.Secure.ENABLED_ACCESSIBILITY_SERVICES);
		set.add(Settings.Secure.ENABLED_INPUT_METHODS);
		set.add(Settings.Secure.HTTP_PROXY);
		set.add(Settings.Secure.INPUT_METHOD_SELECTOR_VISIBILITY);
		set.add(Settings.Secure.INSTALL_NON_MARKET_APPS);
		set.add(Settings.Secure.LOCATION_PROVIDERS_ALLOWED);
		set.add(Settings.Secure.LOCK_PATTERN_ENABLED);
		set.add(Settings.Secure.LOCK_PATTERN_TACTILE_FEEDBACK_ENABLED);
		set.add(Settings.Secure.LOCK_PATTERN_VISIBLE);
		set.add(Settings.Secure.LOGGING_ID);
		set.add(Settings.Secure.NETWORK_PREFERENCE);
		set.add(Settings.Secure.PARENTAL_CONTROL_ENABLED);
		set.add(Settings.Secure.PARENTAL_CONTROL_LAST_UPDATE);
		set.add(Settings.Secure.PARENTAL_CONTROL_REDIRECT_URL);
		set.add(Settings.Secure.SELECTED_INPUT_METHOD_SUBTYPE);
		set.add(Settings.Secure.SETTINGS_CLASSNAME);
		set.add(Settings.Secure.SYS_PROP_SETTING_VERSION);
		set.add(Settings.Secure.TOUCH_EXPLORATION_ENABLED);
		set.add(Settings.Secure.TTS_DEFAULT_COUNTRY);
		set.add(Settings.Secure.TTS_DEFAULT_LANG);
		set.add(Settings.Secure.TTS_DEFAULT_PITCH);
		set.add(Settings.Secure.TTS_DEFAULT_RATE);
		set.add(Settings.Secure.TTS_DEFAULT_SYNTH);
		set.add(Settings.Secure.TTS_DEFAULT_VARIANT);
		set.add(Settings.Secure.TTS_ENABLED_PLUGINS);
		set.add(Settings.Secure.TTS_USE_DEFAULTS);
		set.add(Settings.Secure.USB_MASS_STORAGE_ENABLED);
		set.add(Settings.Secure.USE_GOOGLE_MAIL);
		set.add(Settings.Secure.WIFI_MAX_DHCP_RETRY_COUNT);
		set.add(Settings.Secure.WIFI_MOBILE_DATA_TRANSITION_WAKELOCK_TIMEOUT_MS);
		set.add(Settings.Secure.WIFI_NETWORKS_AVAILABLE_NOTIFICATION_ON);
		set.add(Settings.Secure.WIFI_NETWORKS_AVAILABLE_REPEAT_DELAY);
		set.add(Settings.Secure.WIFI_NUM_OPEN_NETWORKS_KEPT);
		set.add(Settings.Secure.WIFI_ON);
		set.add(Settings.Secure.WIFI_WATCHDOG_ACCEPTABLE_PACKET_LOSS_PERCENTAGE);
		set.add(Settings.Secure.WIFI_WATCHDOG_AP_COUNT);
		set.add(Settings.Secure.WIFI_WATCHDOG_BACKGROUND_CHECK_DELAY_MS);
		set.add(Settings.Secure.WIFI_WATCHDOG_BACKGROUND_CHECK_ENABLED);
		set.add(Settings.Secure.WIFI_WATCHDOG_BACKGROUND_CHECK_TIMEOUT_MS);
		set.add(Settings.Secure.WIFI_WATCHDOG_INITIAL_IGNORED_PING_COUNT);
		set.add(Settings.Secure.WIFI_WATCHDOG_MAX_AP_CHECKS);
		set.add(Settings.Secure.WIFI_WATCHDOG_ON);
		set.add(Settings.Secure.WIFI_WATCHDOG_PING_COUNT);
		set.add(Settings.Secure.WIFI_WATCHDOG_PING_DELAY_MS);
		set.add(Settings.Secure.WIFI_WATCHDOG_PING_TIMEOUT_MS);
		set.add(Settings.Secure.WIFI_WATCHDOG_WATCH_LIST);

		set.add(Settings.System.ACCELEROMETER_ROTATION);
		set.add(Settings.System.ADB_ENABLED);
		set.add(Settings.System.AIRPLANE_MODE_ON);
		set.add(Settings.System.AIRPLANE_MODE_RADIOS);
		set.add(Settings.System.ALARM_ALERT);
		set.add(Settings.System.ALWAYS_FINISH_ACTIVITIES);
		set.add(Settings.System.FONT_SCALE);
		set.add(Settings.System.HAPTIC_FEEDBACK_ENABLED);
		set.add(Settings.System.HTTP_PROXY);
		set.add(Settings.System.INSTALL_NON_MARKET_APPS);
		set.add(Settings.System.LOCATION_PROVIDERS_ALLOWED);
		set.add(Settings.System.LOCK_PATTERN_ENABLED);
		set.add(Settings.System.LOCK_PATTERN_TACTILE_FEEDBACK_ENABLED);
		set.add(Settings.System.LOCK_PATTERN_VISIBLE);
		set.add(Settings.System.LOGGING_ID);
		set.add(Settings.System.MODE_RINGER);
		set.add(Settings.System.MODE_RINGER_STREAMS_AFFECTED);
		set.add(Settings.System.MUTE_STREAMS_AFFECTED);
		set.add(Settings.System.NETWORK_PREFERENCE);
		set.add(Settings.System.NEXT_ALARM_FORMATTED);
		set.add(Settings.System.NOTIFICATION_SOUND);
		set.add(Settings.System.NAME);
		set.add(Settings.System.PARENTAL_CONTROL_ENABLED);
		set.add(Settings.System.PARENTAL_CONTROL_LAST_UPDATE);
		set.add(Settings.System.PARENTAL_CONTROL_REDIRECT_URL);
		set.add(Settings.System.RADIO_BLUETOOTH);
		set.add(Settings.System.RADIO_CELL);
		set.add(Settings.System.RADIO_NFC);
		set.add(Settings.System.RADIO_WIFI);
		set.add(Settings.System.RINGTONE);
		set.add(Settings.System.SCREEN_BRIGHTNESS);
		set.add(Settings.System.SCREEN_BRIGHTNESS_MODE);
		set.add(Settings.System.SCREEN_OFF_TIMEOUT);
		set.add(Settings.System.SETTINGS_CLASSNAME);
		set.add(Settings.System.SETUP_WIZARD_HAS_RUN);
		set.add(Settings.System.SHOW_GTALK_SERVICE_STATUS);
		set.add(Settings.System.SHOW_PROCESSES);
		set.add(Settings.System.SHOW_WEB_SUGGESTIONS);
		set.add(Settings.System.SOUND_EFFECTS_ENABLED);
		set.add(Settings.System.STAY_ON_WHILE_PLUGGED_IN);
		set.add(Settings.System.SYS_PROP_SETTING_VERSION);
		set.add(Settings.System.TEXT_AUTO_CAPS);
		set.add(Settings.System.TEXT_AUTO_PUNCTUATE);
		set.add(Settings.System.TEXT_AUTO_REPLACE);
		set.add(Settings.System.TIME_12_24);
		set.add(Settings.System.TEXT_SHOW_PASSWORD);
		set.add(Settings.System.TRANSITION_ANIMATION_SCALE);
		set.add(Settings.System.USB_MASS_STORAGE_ENABLED);
		set.add(Settings.System.USE_GOOGLE_MAIL);
		set.add(Settings.System.USER_ROTATION);
		set.add(Settings.System.VOLUME_ALARM);
		set.add(Settings.System.VIBRATE_ON);
		set.add(Settings.System.VOLUME_BLUETOOTH_SCO);
		set.add(Settings.System.VOLUME_MUSIC);
		set.add(Settings.System.VOLUME_NOTIFICATION);
		set.add(Settings.System.VOLUME_RING);
		set.add(Settings.System.VOLUME_SYSTEM);
		set.add(Settings.System.VOLUME_VOICE);
		set.add(Settings.System.WAIT_FOR_DEBUGGER);
		set.add(Settings.System.WALLPAPER_ACTIVITY);
		set.add(Settings.System.WIFI_MAX_DHCP_RETRY_COUNT);
		set.add(Settings.System.WIFI_MOBILE_DATA_TRANSITION_WAKELOCK_TIMEOUT_MS);
		set.add(Settings.System.WIFI_NETWORKS_AVAILABLE_NOTIFICATION_ON);
		set.add(Settings.System.WIFI_NETWORKS_AVAILABLE_REPEAT_DELAY);
		set.add(Settings.System.WIFI_NUM_OPEN_NETWORKS_KEPT);
		set.add(Settings.System.WIFI_ON);
		set.add(Settings.System.WIFI_SLEEP_POLICY);
		set.add(Settings.System.WIFI_STATIC_DNS1);
		set.add(Settings.System.WIFI_STATIC_DNS2);
		set.add(Settings.System.WIFI_STATIC_GATEWAY);
		set.add(Settings.System.WIFI_STATIC_IP);
		set.add(Settings.System.WIFI_STATIC_NETMASK);
		set.add(Settings.System.WIFI_USE_STATIC_IP);
		set.add(Settings.System.WIFI_WATCHDOG_ACCEPTABLE_PACKET_LOSS_PERCENTAGE);
		set.add(Settings.System.WIFI_WATCHDOG_AP_COUNT);
		set.add(Settings.System.WIFI_WATCHDOG_BACKGROUND_CHECK_DELAY_MS);

		set.add(Settings.System.WIFI_WATCHDOG_BACKGROUND_CHECK_ENABLED);
		set.add(Settings.System.WIFI_WATCHDOG_BACKGROUND_CHECK_TIMEOUT_MS);
		set.add(Settings.System.WIFI_WATCHDOG_INITIAL_IGNORED_PING_COUNT);
		set.add(Settings.System.WIFI_WATCHDOG_MAX_AP_CHECKS);
		set.add(Settings.System.WIFI_WATCHDOG_ON);
		set.add(Settings.System.WIFI_WATCHDOG_PING_COUNT);
		set.add(Settings.System.WIFI_WATCHDOG_PING_DELAY_MS);
		set.add(Settings.System.WIFI_WATCHDOG_PING_TIMEOUT_MS);
		set.add(Settings.System.WINDOW_ANIMATION_SCALE);
		set.add("access_control_lock_enabled");
		return set.contains(key);

	}

	public static void putString(String Key, String Value) {
		try {
			PhoneInfo info = PhoneInfo.GetNow();
			String IMEI = info.IMEI;
			if (Value == null)
				Value = "";

			Map<String, App> ShuaList = App.GetAppList("Shua");
			Collection<App> ShuaAppListColl = ShuaList.values();
			Iterator<App> ShuaAppListIter = ShuaAppListColl.iterator();
			for (; ShuaAppListIter.hasNext();) {
				App a = ShuaAppListIter.next();
				Setting set =new Setting();
				String file = "";
				if (set.padSelected) {
					String sddir = Environment.getExternalStorageDirectory().getPath();
					file = sddir + "/.shenqi/sys/" + IMEI + "/";
				} else {
					file = "/mnt/shared/beifen/" + a.pkg + "/" + info.taskIdValue + "-" + info.Days + "/sys/" + IMEI + "/";
				}

				File dataDir = new File(file); // +
				// IMEI+"/"
				if (!dataDir.exists())
					dataDir.mkdirs();
				File dataFile = new File(file + Key + ".txt"); // 每个key一个文件
				dataFile.delete();

				OutputStream outstream = new FileOutputStream(dataFile);
				OutputStreamWriter out = new OutputStreamWriter(outstream);
				out.write(Value);
				out.close();
				return;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public static String gettString(String Key) {
		PhoneInfo info = PhoneInfo.GetNow();
		String IMEI = info.IMEI;
		String Value = ""; // 文件内容字符串

		Map<String, App> ShuaList = App.GetAppList("Shua");
		Collection<App> ShuaAppListColl = ShuaList.values();
		Iterator<App> ShuaAppListIter = ShuaAppListColl.iterator();
		for (; ShuaAppListIter.hasNext();) {
			App a = ShuaAppListIter.next();
			Setting set =new Setting();
			String file = "";
			if (set.padSelected) {
				String sddir = Environment.getExternalStorageDirectory().getPath();
				file = sddir + "/.shenqi/sys/" + IMEI + "/";
			} else {
				file = "/mnt/shared/beifen/" + a.pkg + "/" + info.taskIdValue + "-" + info.Days + "/sys/" + IMEI + "/";
			}

			File dataFile = new File(file + Key + ".txt"); // 每一个key

			if (!dataFile.exists())
				return Value;
			try {
				InputStream instream = new FileInputStream(dataFile);
				if (instream != null) {
					InputStreamReader inputreader = new InputStreamReader(instream);
					BufferedReader buffreader = new BufferedReader(inputreader);
					Value = buffreader.readLine();
					instream.close();
				}
			} catch (java.io.FileNotFoundException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		return Value;
	}

	public static void Clear(boolean padSelected) {

		if (padSelected) {
			PhoneInfo info = PhoneInfo.GetNow();
			String IMEI = info.IMEI;
			// 打开文件
			String sddir = Environment.getExternalStorageDirectory().getPath();
			String dataDir = sddir + "/.shenqi/sys/"; // + IMEI+"/"
			ShellUtil.Exec("rm -r " + dataDir + "* ");
		} else {
			// 打开文件
			Map<String, App> ShuaList = App.GetAppList("Shua");
			Collection<App> ShuaAppListColl = ShuaList.values();
			Iterator<App> ShuaAppListIter = ShuaAppListColl.iterator();
			for (; ShuaAppListIter.hasNext();) {
				App a = ShuaAppListIter.next();

				String file = "/mnt/shared/beifen/" + a.pkg + "/";

				ShellUtil.Exec("rm -r " + file + "* ");
			}
		}
	}
}
