package com.x.utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.OutputStream;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserFactory;
import org.xmlpull.v1.XmlSerializer;

import android.os.Environment;
import android.util.Log;
import android.util.Xml;


public class Setting {
	public Boolean KeepMode; 
	public Boolean SaveData; 
	public Boolean dateSelected; 
	public Boolean Uninstall; 
	public String Pkg;
	public Boolean AppInstallMonitor;
	public String UserId;
	public String UserName;
	public String DeviceId; 
	public String DeviceName;
	public String TaskId; 
	public String TaskName;
	public int Keep2;
	public int Keep3; 
	public int Keep4; 
	public int Keep5; 
	public int Keep6;
	public int Keep7; 
	public int Keep8;
	public int Keep9; 
	public int Keep10; 
	public int Keep11; 
	public int Keep12; 
	public int Keep13;
	public int Keep14;
	public int Keep15;
	public int taskIdValue;
	public String pointIdValue;
	public Boolean padSelected;
	public int registIdValue;

	public Setting() {
		KeepMode = false;
		padSelected = false;
		SaveData = false; 
		dateSelected = false; 
		Uninstall = false; 
		AppInstallMonitor = false; 
		
		taskIdValue=0;
		registIdValue=0;

		pointIdValue="206,603|452,206|258,204";
		
		UserId = "0";
		UserName = "未设定";

		DeviceId = "0";
		DeviceName = "未设定";

		TaskId = "0";
		TaskName = "未设定";

		Keep2 = 31; 
		Keep3 = 27; 
		Keep4 = 24; 
		Keep5 = 22;
		Keep6 = 19;
		Keep7 = 16; 
		Keep8 = 16; 
		Keep9 = 15;
		Keep10 = 15;
		Keep11 = 14;
		Keep12 = 13;
		Keep13 = 12;
		Keep14 = 11;
		Keep15 = 10;
		String appListFile = Environment.getExternalStorageDirectory().getPath() + "/.shenqi/Setting.xml";
		File file = new File(appListFile);
		if (!file.exists()) {
			save();
		} else {
			try {
				XmlPullParser parser = XmlPullParserFactory.newInstance().newPullParser();
				parser.setInput(new FileInputStream(file), "UTF-8");
				int type = parser.getEventType();
				while (type != XmlPullParser.END_DOCUMENT) {
					switch (type) {
					case XmlPullParser.START_TAG:
						if (parser.getName().equals("KeepMode")) {
							KeepMode = Boolean.parseBoolean(parser.nextText());
						} else if (parser.getName().equals("padSelected")) {
							padSelected = Boolean.parseBoolean(parser.nextText());
						} else if (parser.getName().equals("SaveData")) {
							SaveData = Boolean.parseBoolean(parser.nextText());
						}  else if (parser.getName().equals("dateSelected")) {
							dateSelected = Boolean.parseBoolean(parser.nextText());
						} else if (parser.getName().equals("Uninstall")) {
							Uninstall = Boolean.parseBoolean(parser.nextText());
						} else if (parser.getName().equals("AppInstallMonitor")) {
							AppInstallMonitor = Boolean.parseBoolean(parser.nextText());
						} else if (parser.getName().equals("UserId")) {
							UserId = parser.nextText();
						} else if (parser.getName().equals("UserName")) {
							UserName = parser.nextText();
						} else if (parser.getName().equals("DeviceId")) {
							DeviceId = parser.nextText();
						} else if (parser.getName().equals("DeviceName")) {
							DeviceName = parser.nextText();
						} else if (parser.getName().equals("TaskId")) {
							TaskId = parser.nextText();
						} else if (parser.getName().equals("TaskName")) {
							TaskName = parser.nextText();
						} else if (parser.getName().equals("Keep2")) {
							Keep2 = Integer.parseInt(parser.nextText());
						} else if (parser.getName().equals("Keep3")) {
							Keep3 = Integer.parseInt(parser.nextText());
						} else if (parser.getName().equals("Keep4")) {
							Keep4 = Integer.parseInt(parser.nextText());
						} else if (parser.getName().equals("Keep5")) {
							Keep5 = Integer.parseInt(parser.nextText());
						} else if (parser.getName().equals("Keep6")) {
							Keep6 = Integer.parseInt(parser.nextText());
						} else if (parser.getName().equals("Keep7")) {
							Keep7 = Integer.parseInt(parser.nextText());
						} else if (parser.getName().equals("Keep8")) {
							Keep8 = Integer.parseInt(parser.nextText());
						} else if (parser.getName().equals("Keep9")) {
							Keep9 = Integer.parseInt(parser.nextText());
						} else if (parser.getName().equals("Keep10")) {
							Keep10 = Integer.parseInt(parser.nextText());
						} else if (parser.getName().equals("Keep11")) {
							Keep11 = Integer.parseInt(parser.nextText());
						} else if (parser.getName().equals("Keep12")) {
							Keep12 = Integer.parseInt(parser.nextText());
						} else if (parser.getName().equals("Keep13")) {
							Keep13 = Integer.parseInt(parser.nextText());
						} else if (parser.getName().equals("Keep14")) {
							Keep14 = Integer.parseInt(parser.nextText());
						} else if (parser.getName().equals("Keep15")) {
							Keep15 = Integer.parseInt(parser.nextText());
						}else if (parser.getName().equals("taskIdValue")) {
							taskIdValue = Integer.parseInt(parser.nextText());
						}else if (parser.getName().equals("registIdValue")){
							registIdValue = Integer.parseInt(parser.nextText());
						}
						else if (parser.getName().equals("pointIdValue")) {
							pointIdValue = parser.nextText();
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
			}
		}
	}

	
	public void save() {
		String sddir = Environment.getExternalStorageDirectory().getPath();
		XmlSerializer xml = Xml.newSerializer();
		try {
			File settingFile = new File(sddir + "/.shenqi/Setting.xml");
			OutputStream os = new FileOutputStream(settingFile);
			// 指定输出流
			xml.setOutput(os, "utf-8");
			// 开始文档
			xml.startDocument("utf-8", true);
			xml.startTag("", "Settings");
			xml.startTag("", "Setting");

			xml.startTag("", "KeepMode");
			xml.text(KeepMode.toString());
			xml.endTag("", "KeepMode");
			
			xml.startTag("", "padSelected");
			xml.text(padSelected.toString());
			xml.endTag("", "padSelected");
			
			xml.startTag("", "SaveData");
			xml.text(SaveData.toString());
			xml.endTag("", "SaveData");

			xml.startTag("", "dateSelected");
			xml.text(dateSelected.toString());
			xml.endTag("", "dateSelected");

			xml.startTag("", "Uninstall");
			xml.text(Uninstall.toString());
			xml.endTag("", "Uninstall");

			xml.startTag("", "AppInstallMonitor");
			xml.text(AppInstallMonitor.toString());
			xml.endTag("", "AppInstallMonitor");

			xml.startTag("", "UserId");
			xml.text(UserId);
			xml.endTag("", "UserId");

			xml.startTag("", "UserName");
			xml.text(UserName);
			xml.endTag("", "UserName");

			xml.startTag("", "DeviceId");
			xml.text(DeviceId);
			xml.endTag("", "DeviceId");

			xml.startTag("", "DeviceName");
			xml.text(DeviceName);
			xml.endTag("", "DeviceName");

			xml.startTag("", "TaskId");
			xml.text(TaskId);
			xml.endTag("", "TaskId");

			xml.startTag("", "TaskName");
			xml.text(TaskName);
			xml.endTag("", "TaskName");

			xml.startTag("", "Keep2");
			xml.text(Keep2 + "");
			xml.endTag("", "Keep2");

			xml.startTag("", "Keep3");
			xml.text(Keep3 + "");
			xml.endTag("", "Keep3");

			xml.startTag("", "Keep4");
			xml.text(Keep4 + "");
			xml.endTag("", "Keep4");

			xml.startTag("", "Keep5");
			xml.text(Keep5 + "");
			xml.endTag("", "Keep5");

			xml.startTag("", "Keep6");
			xml.text(Keep6 + "");
			xml.endTag("", "Keep6");

			xml.startTag("", "Keep7");
			xml.text(Keep7 + "");
			xml.endTag("", "Keep7");

			xml.startTag("", "Keep8");
			xml.text(Keep8 + "");
			xml.endTag("", "Keep8");

			xml.startTag("", "Keep9");
			xml.text(Keep9 + "");
			xml.endTag("", "Keep9");

			xml.startTag("", "Keep10");
			xml.text(Keep10 + "");
			xml.endTag("", "Keep10");

			xml.startTag("", "Keep11");
			xml.text(Keep11 + "");
			xml.endTag("", "Keep11");

			xml.startTag("", "Keep12");
			xml.text(Keep12 + "");
			xml.endTag("", "Keep12");

			xml.startTag("", "Keep13");
			xml.text(Keep13 + "");
			xml.endTag("", "Keep13");

			xml.startTag("", "Keep14");
			xml.text(Keep14 + "");
			xml.endTag("", "Keep14");
			
			xml.startTag("", "taskIdValue");
			xml.text(taskIdValue + "");
			xml.endTag("", "taskIdValue");
			
			xml.startTag("", "registIdValue");
			xml.text(registIdValue + "");
			xml.endTag("", "registIdValue");
			
			xml.startTag("", "pointIdValue");
			xml.text(pointIdValue + "");
			xml.endTag("", "pointIdValue");
			
			xml.startTag("", "Keep15");
			xml.text(Keep15 + "");
			xml.endTag("", "Keep15");

			xml.endTag("", "Setting");
			xml.endTag("", "Settings");
			xml.endDocument();
		} catch (Exception e) {
			Log.i("错误", "未能保存" + e.getMessage());
		}
	}

}
