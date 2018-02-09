package com.x.generator;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public class Model {

	public String id;

	//手机型号相关
		public String BOARD;  //机型相关
		public String BOOTLOADER;
		public String BRAND;
		public String CPU_ABI;
		public String CPU_ABI2;
		public String DEVICE;
		public String DISPLAY;
		public String FINGERPRINT;   //机型下ROM相关
		public String HARDWARE;
		public String HOST;     //机型下ROM相关
		public String ID;     //机型下ROM相关
		public String MANUFACTURER;
		public String MODEL;
		public String PRODUCT;
		public String RADIO;   //机型ROM相关
		//public String SERIAL;  //格式为：8位16进制随机代码
		public String TAGS;  //随机生成：unsigned,debug，user,userdebug
		public String TYPE;  //user,eng,userdebug,end
		public String USER; 
		public String CODENAME;// 一般为REL
		public String INCREMENTAL;
		public String RELEASE;//  机型ROM相关
		public int SDK_INT;// 机型ROM相关
		public String SDK;//  根据SDK_INT 生成
		//屏幕相关
		public int Height; //机型相关
		public int Width; //机型先关
		public float Density;//机型相关
		public float ScaleDensity;// 机型相关
		public float DensityDPI;// 机型相关
		public float Xdpi; //机型相关
		public float Ydpi; //机型相关
		//机型数据配置有关,暂时不适用
		public String UA; //三种修改方法
		public String BaseBand;//两种修改方法
		public String OSVersion;//两种修改方法
		public String PROCVersion;//两种修改方法
		public String CPUINFO;//两种修改方法
		public String TIME; //尚不清楚生成原理。

		
		public static String getTAGS(){
			String [] Strs = new String[]{"unsigned","debug","user","userdebug",""};
			Random random = new Random();
			int index = random.nextInt(4);
			return Strs[index];
		}
		public static String getTYPE(){
			String [] Strs = new String[]{"user","eng","userdebug","end",""};
			Random random = new Random();
			int index = random.nextInt(4);
			return Strs[index];
		}
		public static String getCODENAME(){
			String [] Strs = new String[]{"REL",""};
			Random random = new Random();
			int index = random.nextInt(1);
			return Strs[index];
		}
		
		
	
	public static Map<String, Model> GetLib() {
		Map<String, Model> maps = new HashMap<String, Model>();
            insertLib(maps,new String[] {
                "C8816", "Huawei", "hwC8816", "C8816V100R001C92B802", "HUAWEI", "HUAWEI C8816", "C8816", "", "HuaweiC8816", "user", 
                "release-keys", "huawei", "huawei-desktop", "qcom", "armeabi-v7a", "armeabi", "Huawei/C8816/hwC8816:4.3/HuaweiC8816/C92B802:user/ota-rel-keys,release-keys", "REL", "C92B802", "4.3", 
                "18", "18", "A0000049", "960", "540", "1.9499999", "1.5", "240", "159.488", "160.421", 
                "01760", "3.4.0+", "Linux version 3.4.0+ (jenkins@wuhcitculx00170) (gcc version 4.7 (GCC) ) #1 SMP P" +
    "REEMPT Sat Jul 5 22:29:33 CST 2014\n"
    , "Processor\t: ARMv7 Processor rev 3 (v7l)\nprocessor\t: 0\nBogoMIPS\t: 38.40\n\np" +
    "rocessor\t: 1\nBogoMIPS\t: 38.40\n\nprocessor\t: 2\nBogoMIPS\t: 38.40\n\nprocess" +
    "or\t: 3\nBogoMIPS\t: 38.40\n\nFeatures\t: swp half thumb fastmult vfp edsp neon " +
    "vfpv3 tls vfpv4 idiva idivt \nCPU implementer\t: 0x41\nCPU architecture: 7\nCPU " +
    "variant\t: 0x0\nCPU part\t: 0xc07\nCPU revision\t: 3\n\nHardware\t: Qualcomm MSM" +
    " 8x1x (Flattened Device Tree)\nRevision\t: 0000\nSerial\t\t: 0000000000000000\n"
    , "dianxin"
            });
            insertLib(maps,new String[] {
                "G730-C00", "Huawei", "hwG730-C00", "G730-C00V100R001C92B158", "HUAWEI", "HUAWEI G730-C00", "G730-C00", "", "HuaweiG730-C00", "user", 
                "ota-rel-keys,release-keys", "huawei", "huawei-desktop", "huawei", "armeabi-v7a", "armeabi", "Huawei/G730-C00/hwG730-C00:4.1.2/HuaweiG730-C00/C92B158:user/ota-rel-keys,releas" +
    "e-keys"
    , "REL", "C92B158", "4.1.2", 
                "16", "16", "A0000049", "960", "540", "1.5", "1.5", "240", "159.48837", "160.42105", 
                "31,103,110", "3.4.0-perf-gda5d807", "Linux version 3.4.0-perf-gda5d807 (android@localhost) (gcc version 4.6.x-google " +
    "20120106 (prerelease) (GCC) ) #1 SMP PREEMPT Fri May 9 13:13:39 CST 2014\n"
    , "Processor\t: ARMv7 Processor rev 1 (v7l)\nprocessor\t: 0\nBogoMIPS\t: 802.63\n\n" +
    "processor\t: 1\nBogoMIPS\t: 802.63\n\nprocessor\t: 2\nBogoMIPS\t: 398.13\n\nproc" +
    "essor\t: 3\nBogoMIPS\t: 398.13\n\nFeatures\t: swp half thumb fastmult vfp edsp t" +
    "humbee neon vfpv3 tls vfpv4 \nCPU implementer\t: 0x41\nCPU architecture: 7\nCPU " +
    "variant\t: 0x0\nCPU part\t: 0xc05\nCPU revision\t: 1\n\nHardware\t: MSM8x25 G730" +
    " BOARD\nRevision\t: 0000\nSerial\t\t: 0000000000000000\n"
    , "dianxin"
            });
            insertLib(maps,new String[] {
                "MT2-C00", "Huawei", "hwmt2-c00", "MT2-C00V100R001C92B119", "HUAWEI", "HUAWEI MT2-C00", "MT2-C00", "", "HuaweiMT2-C00", "user", 
                "ota-rel-keys,release-keys", "android", "localhost#1", "hi6620oem", "armeabi-v7a", "armeabi", "Huawei/MT2-C00/hwmt2-c00:4.2.2/HuaweiMT2-C00/C92B119:user/ota-rel-keys,release-k" +
    "eys"
    , "REL", "C92B119", "4.2.2", 
                "17", "17", "A0000049", "1280", "720", "2.0", "2.0", "320", "240.631", "240.829", 
                "SNAVARZ5334_(Jun 25 2014),21.270.11.00.000", "3.0.8-00595-g6be320d", "Linux version 3.0.8-00595-g6be320d (android@localhost) (gcc version 4.6.x-google" +
    " 20120106 (prerelease) (GCC) ) #1 SMP PREEMPT Wed Jun 25 18:46:25 CST 2014\n"
    , "Processor\t: ARMv7 Processor rev 1 (v7l)\nprocessor\t: 0\nBogoMIPS\t: 3180.00\n\n" +
    "processor\t: 1\nBogoMIPS\t: 3180.00\n\nprocessor\t: 2\nBogoMIPS\t: 3180.00\n\npr" +
    "ocessor\t: 3\nBogoMIPS\t: 3180.00\n\nFeatures\t: swp half thumb fastmult vfp eds" +
    "p thumbee neon vfpv3 \nCPU implementer\t: 0x41\nCPU architecture: 7\nCPU variant" +
    "\t: 0x4\nCPU part\t: 0xc09\nCPU revision\t: 1\n\nHardware\t: hi6620oem\nRevision" +
    "\t: 0000\nSerial\t\t: 0000000000000000\n"
    , "dianxin"
            });
            insertLib(maps,new String[] {
                "Y321-C00", "Huawei", "hwy321-c00", "Y321-C00V100R001C92B612", "HUAWEI", "HUAWEI Y321-C00", "Y321-C00", "", "HuaweiY321-C00", "user", 
                "release-keys", "build", "build", "qcom", "armeabi-v7a", "armeabi", "Huawei/Y321-C00/hwy321-c00:4.1.2/HuaweiY321-C00/C92B612SP02:user/release-keys", "REL", "C92B612SP02", "4.1.2", 
                "16", "16", "A0000049", "800", "480", "1.7249999", "1.5", "240", "160.42105", "160", 
                "QC8X25_Y321C_V043_1204", "3.4.0-perf-gcc32e059", "Linux version 3.4.0-perf-gcc32e059 (build@build) (gcc version 4.6.x-google 20120" +
    "106 (prerelease) (GCC) ) #1 SMP PREEMPT Wed Dec 4 18:10:30 CST 2013\n"
    , "Processor\t: ARMv7 Processor rev 1 (v7l)\nprocessor\t: 0\nBogoMIPS\t: 501.64\n\n" +
    "processor\t: 1\nBogoMIPS\t: 501.64\n\nFeatures\t: swp half thumb fastmult vfp ed" +
    "sp thumbee neon vfpv3 tls vfpv4 \nCPU implementer\t: 0x41\nCPU architecture: 7\n" +
    "CPU variant\t: 0x0\nCPU part\t: 0xc05\nCPU revision\t: 1\n\nHardware\t: QRD MSM8" +
    "625 Y320C\nRevision\t: 0000\nSerial\t\t: 0000000000000000\n"
    , "dianxin"
            });
            insertLib(maps,new String[] {
                "C8815", "Huawei", "hwC8815", "C8815V100R001C92B133", "HUAWEI", "HUAWEI C8815", "C8815", "", "HuaweiC8815", "user", 
                "ota-rel-keys,release-keys", "huawei", "huawei-desktop", "huawei", "armeabi-v7a", "armeabi", "Huawei/C8815/hwC8815:4.1.2/HuaweiC8815/C92B133:user/ota-rel-keys,release-keys", "REL", "C92B133", "4.1.2", 
                "16", "16", "A0000049", "960", "540", "1.5", "1.5", "240", "159.48837", "160.42105", 
                "3110", "3.4.0-perf-g659f716-00647-g492ebe1", "Linux version 3.4.0-perf-g659f716-00647-g492ebe1 (android@localhost) (gcc versio" +
    "n 4.6.x-google 20120106 (prerelease) (GCC) ) #1 SMP PREEMPT Fri Nov 1 15:34:19 C" +
    "ST 2013\n"
    , "Processor\t: ARMv7 Processor rev 1 (v7l)\nprocessor\t: 0\nBogoMIPS\t: 802.63\n\n" +
    "processor\t: 1\nBogoMIPS\t: 802.63\n\nprocessor\t: 2\nBogoMIPS\t: 802.63\n\nproc" +
    "essor\t: 3\nBogoMIPS\t: 802.63\n\nFeatures\t: swp half thumb fastmult vfp edsp t" +
    "humbee neon vfpv3 tls vfpv4 \nCPU implementer\t: 0x41\nCPU architecture: 7\nCPU " +
    "variant\t: 0x0\nCPU part\t: 0xc05\nCPU revision\t: 1\n\nHardware\t: MSM8x25 G610" +
    "C BOARD\nRevision\t: 0000\nSerial\t\t: 0000000000000000\n"
    , "dianxin"
            });
            insertLib(maps,new String[] {
                "MSM8674", "samsung", "hlte", "KOT49H.N9009KEU2ENH5", "samsung", "SM-N9009", "h3gduosctc", "N9009KEU2ENH5", "KOT49H", "user", 
                "release-keys", "dpi", "SWDD5620", "qcom", "armeabi-v7a", "armeabi", "samsung/h3gduosctc/hlte:4.4.2/KOT49H\n9009KEU2ENH5:user/release-keys", "REL", "N9009KEU2ENH5", "4.4.2", 
                "19", "19", "A0000048", "1920", "1080", "3.0", "3.0", "480", "386.366", "387.047", 
                "N9009KEU2ENH5", "3.4.0-2420422", "Linux version 3.4.0-2420422 (dpi@SWDD5007) (gcc version 4.7 (GCC) ) #1 SMP PREEM" +
    "PT Mon Aug 25 21:21:27 KST 2014\n"
    , "Processor\t: ARMv7 Processor rev 0 (v7l)\nprocessor\t: 0\nBogoMIPS\t: 38.40\n\np" +
    "rocessor\t: 1\nBogoMIPS\t: 38.40\n\nprocessor\t: 2\nBogoMIPS\t: 38.40\n\nprocess" +
    "or\t: 3\nBogoMIPS\t: 38.40\n\nFeatures\t: swp half thumb fastmult vfp edsp neon " +
    "vfpv3 tls vfpv4 idiva idivt \nCPU implementer\t: 0x51\nCPU architecture: 7\nCPU " +
    "variant\t: 0x2\nCPU part\t: 0x06f\nCPU revision\t: 0\n\nHardware\t: Qualcomm MSM" +
    " 8974 (Flattened Device Tree)\nRevision\t: 0008\nSerial\t\t: 0000a4b200004b53\n"
    , "dianxin"
            });
            insertLib(maps,new String[] {
                "MSM8674", "samsung", "hlte", "KOT49H.N9009KEU2ENH5", "samsung", "SM-N9009", "h3gduosctc", "N9009KEU2ENH5", "KOT49H", "user", 
                "release-keys", "dpi", "SWDD5007", "qcom", "armeabi-v7a", "armeabi", "samsung/h3gduosctc/hlte:4.4.2/KOT49H\n9009KEU2ENH5:user/release-keys", "REL", "N9009KEU2ENH5", "4.4.2", 
                "19", "19", "A0000048", "1920", "1080", "3.0", "3.0", "480", "386.366", "387.047", 
                "N9009KEU2ENH5", "3.4.0-2420422", "Linux version 3.4.0-2420422 (dpi@SWDD5007) (gcc version 4.7 (GCC) ) #1 SMP PREEM" +
    "PT Mon Aug 25 21:21:27 KST 2014\n"
    , "Processor\t: ARMv7 Processor rev 0 (v7l)\nprocessor\t: 0\nBogoMIPS\t: 38.40\n\np" +
    "rocessor\t: 1\nBogoMIPS\t: 38.40\n\nprocessor\t: 2\nBogoMIPS\t: 38.40\n\nprocess" +
    "or\t: 3\nBogoMIPS\t: 38.40\n\nFeatures\t: swp half thumb fastmult vfp edsp neon " +
    "vfpv3 tls vfpv4 idiva idivt \nCPU implementer\t: 0x51\nCPU architecture: 7\nCPU " +
    "variant\t: 0x2\nCPU part\t: 0x06f\nCPU revision\t: 0\n\nHardware\t: Qualcomm MSM" +
    " 8974 (Flattened Device Tree)\nRevision\t: 0008\nSerial\t\t: 0000fda60000b60f\n"
    , "dianxin"
            });
            insertLib(maps,new String[] {
                "MSM8610", "samsung", "logan", "JLS36C.I679KEUANC4", "samsung", "SCH-I679", "loganctc", "I679KEUANF2", "JLS36C", "user", 
                "release-keys", "se.infra", "R0301-09", "qcom", "armeabi-v7a", "armeabi", "samsung/loganctc/logan:4.3/JLS36C/I679KEUANC4:user/release-keys", "REL", "I679KEUANC4", "4.3", 
                "18", "18", "A0000048", "800", "480", "1.5", "1.5", "240", "160.421", "160", 
                "I679KEUANF2", "3.4.0-2699439", "Linux version 3.4.0-2699439 (se.infra@R0210-08) (gcc version 4.7 (GCC) ) #1 SMP " +
    "PREEMPT Mon Jun 23 15:41:05 KST 2014\n"
    , "Processor\t: ARMv7 Processor rev 3 (v7l)\nprocessor\t: 0\nBogoMIPS\t: 38.40\n\np" +
    "rocessor\t: 1\nBogoMIPS\t: 38.40\n\nFeatures\t: swp half thumb fastmult vfp edsp" +
    " neon vfpv3 tls vfpv4 idiva idivt \nCPU implementer\t: 0x41\nCPU architecture: 7" +
    "\nCPU variant\t: 0x0\nCPU part\t: 0xc07\nCPU revision\t: 3\n\nHardware\t: Qualco" +
    "mm MSM 8610 (Flattened Device Tree)\nRevision\t: 0003\nSerial\t\t: 0000000000000" +
    "000\n"
    , "dianxin"
            });
            insertLib(maps,new String[] {
                "MSM8674", "samsung", "hlte", "KOT49H.N9009KEU2ENH5", "samsung", "SM-N9009", "h3gduosctc", "N9009KEU2ENH5", "KOT49H", "user", 
                "release-keys", "dpi", "SWDD5007", "qcom", "armeabi-v7a", "armeabi", "samsung/h3gduosctc/hlte:4.4.2/KOT49H\n9009KEU2ENH5:user/release-keys", "REL", "N9009KEU2ENH5", "4.4.2", 
                "19", "19", "A0000048", "1920", "1080", "3.0", "3.0", "480", "386.366", "387.047", 
                "N9009KEU2ENH5", "3.4.0-2420422", "Linux version 3.4.0-2420422 (dpi@SWDD5007) (gcc version 4.7 (GCC) ) #1 SMP PREEM" +
    "PT Mon Aug 25 21:21:27 KST 2014\n"
    , "Processor\t: ARMv7 Processor rev 0 (v7l)\nprocessor\t: 0\nBogoMIPS\t: 38.40\n\np" +
    "rocessor\t: 1\nBogoMIPS\t: 38.40\n\nprocessor\t: 2\nBogoMIPS\t: 38.40\n\nprocess" +
    "or\t: 3\nBogoMIPS\t: 38.40\n\nFeatures\t: swp half thumb fastmult vfp edsp neon " +
    "vfpv3 tls vfpv4 idiva idivt \nCPU implementer\t: 0x51\nCPU architecture: 7\nCPU " +
    "variant\t: 0x2\nCPU part\t: 0x06f\nCPU revision\t: 0\n\nHardware\t: Qualcomm MSM" +
    " 8974 (Flattened Device Tree)\nRevision\t: 0008\nSerial\t\t: 00005ef60000b628\n"
    , "dianxin"
            });
            insertLib(maps,new String[] {
                "MSM8610", "samsung", "kanas3gctc", "KOT49H.G3559KEU1ANH1", "samsung", "SM-G3559", "kanas3gctc", "G3559KEU1ANH1", "KOT49H", "user", 
                "release-keys", "dpi", "SWDD5906", "qcom", "armeabi-v7a", "armeabi", "samsung/kanas3gctc/kanas3gctc:4.4.2/KOT49H/G3559KEU1ANH1:user/release-keys", "REL", "G3559KEU1ANH1", "4.4.2", 
                "19", "19", "A0000048", "800", "480", "1.6500001", "1.5", "240", "160.421", "160", 
                "G3559KEU1ANH1", "3.4.0-2432814", "Linux version 3.4.0-2432814 (dpi@SWDD5906) (gcc version 4.7 (GCC) ) #1 SMP PREEM" +
    "PT Thu Aug 7 15:29:55 KST 2014\n"
    , "Processor\t: ARMv7 Processor rev 3 (v7l)\nprocessor\t: 0\nBogoMIPS\t: 38.40\n\np" +
    "rocessor\t: 1\nBogoMIPS\t: 38.40\n\nFeatures\t: swp half thumb fastmult vfp edsp" +
    " neon vfpv3 tls vfpv4 idiva idivt \nCPU implementer\t: 0x41\nCPU architecture: 7" +
    "\nCPU variant\t: 0x0\nCPU part\t: 0xc07\nCPU revision\t: 3\n\nHardware\t: Qualco" +
    "mm MSM 8610 (Flattened Device Tree)\nRevision\t: 0004\nSerial\t\t: 000061070000d" +
    "42d\n"
    , "dianxin"
            });
            insertLib(maps,new String[] {
                "MSM8610", "samsung", "logan", "JLS36C.I679KEUANG1", "samsung", "SCH-I679", "loganctc", "I679KEUANG1", "JLS36C", "user", 
                "release-keys", "se.infra", "R0301-05", "qcom", "armeabi-v7a", "armeabi", "samsung/loganctc/logan:4.3/JLS36C/I679KEUANG1:user/release-keys", "REL", "I679KEUANG1", "4.3", 
                "18", "18", "A0000048", "800", "480", "1.5", "1.5", "240", "160.421", "160", 
                "I679KEUANG1", "3.4.0-2710173", "Linux version 3.4.0-2710173 (se.infra@R0301-05) (gcc version 4.7 (GCC) ) #1 SMP " +
    "PREEMPT Mon Jul 7 21:07:15 KST 2014\n"
    , "Processor\t: ARMv7 Processor rev 3 (v7l)\nprocessor\t: 0\nBogoMIPS\t: 38.40\n\np" +
    "rocessor\t: 1\nBogoMIPS\t: 38.40\n\nFeatures\t: swp half thumb fastmult vfp edsp" +
    " neon vfpv3 tls vfpv4 idiva idivt \nCPU implementer\t: 0x41\nCPU architecture: 7" +
    "\nCPU variant\t: 0x0\nCPU part\t: 0xc07\nCPU revision\t: 3\n\nHardware\t: Qualco" +
    "mm MSM 8610 (Flattened Device Tree)\nRevision\t: 0003\nSerial\t\t: 0000000000000" +
    "000\n"
    , "dianxin"
            });
            insertLib(maps,new String[] {
                "MSM8610", "samsung", "logan", "JLS36C.I679KEUANF2", "samsung", "SCH-I679", "loganctc", "I679KEUANF2", "JLS36C", "user", 
                "release-keys", "se.infra", "R0210-08", "qcom", "armeabi-v7a", "armeabi", "samsung/loganctc/logan:4.3/JLS36C/I679KEUANF2:user/release-keys", "REL", "I679KEUANF2", "4.3", 
                "18", "18", "A0000048", "800", "480", "1.5", "1.5", "240", "160.421", "160", 
                "I679KEUANF2", "3.4.0-2699439", "Linux version 3.4.0-2699439 (se.infra@R0210-08) (gcc version 4.7 (GCC) ) #1 SMP " +
    "PREEMPT Mon Jun 23 15:41:05 KST 2014\n"
    , "Processor\t: ARMv7 Processor rev 3 (v7l)\nprocessor\t: 0\nBogoMIPS\t: 38.40\n\np" +
    "rocessor\t: 1\nBogoMIPS\t: 38.40\n\nFeatures\t: swp half thumb fastmult vfp edsp" +
    " neon vfpv3 tls vfpv4 idiva idivt \nCPU implementer\t: 0x41\nCPU architecture: 7" +
    "\nCPU variant\t: 0x0\nCPU part\t: 0xc07\nCPU revision\t: 3\n\nHardware\t: Qualco" +
    "mm MSM 8610 (Flattened Device Tree)\nRevision\t: 0003\nSerial\t\t: 0000000000000" +
    "000\n"
    , "dianxin"
            });
            insertLib(maps,new String[] {
                "MSM8974", "samsung", "klte", "KOT49H.G9009DKEU1ANI3", "samsung", "SM-G9009D", "k3gduosctc", "G9009DKEU1ANI3", "KOT49H", "user", 
                "release-keys", "dpi", "SWDD5821", "qcom", "armeabi-v7a", "armeabi", "samsung/k3gduosctc/klte:4.4.2/KOT49H/G9009DKEU1ANI3:user/release-keys", "REL", "G9009DKEU1ANI3", "4.4.2", 
                "19", "19", "A0000048", "1920", "1080", "3.27", "3.0", "480", "422.03", "424.069", 
                "G9009DKEU1ANI3", "3.4.0-2833955", "Linux version 3.4.0-2833955 (dpi@SWDD5821) (gcc version 4.7 (GCC) ) #1 SMP PREEM" +
    "PT Mon Sep 22 15:02:58 KST 2014\n"
    , "Processor\t: ARMv7 Processor rev 1 (v7l)\nprocessor\t: 0\nBogoMIPS\t: 38.40\n\np" +
    "rocessor\t: 1\nBogoMIPS\t: 38.40\n\nprocessor\t: 2\nBogoMIPS\t: 38.40\n\nprocess" +
    "or\t: 3\nBogoMIPS\t: 38.40\n\nFeatures\t: swp half thumb fastmult vfp edsp neon " +
    "vfpv3 tls vfpv4 idiva idivt \nCPU implementer\t: 0x51\nCPU architecture: 7\nCPU " +
    "variant\t: 0x2\nCPU part\t: 0x06f\nCPU revision\t: 1\n\nHardware\t: Qualcomm MSM" +
    " 8974 (Flattened Device Tree)\nRevision\t: 000e\nSerial\t\t: 000054330000ccf1\n"
    , "dianxin"
            });
            insertLib(maps,new String[] {
                "MSM8626", "samsung", "ms013g", "JLS36C.G7109KEUBNG1", "samsung", "SM-G7109", "ms013gctc", "G7109KEUBNG1", "JLS36C", "user", 
                "release-keys", "se.infra", "SEP-113", "qcom", "armeabi-v7a", "armeabi", "samsung/ms013gctc/ms013g:4.3/JLS36C/G7109KEUBNG1:user/release-keys", "REL", "G7109KEUBNG1", "4.3", 
                "18", "18", "A0000048", "1280", "720", "2.2", "2.0", "320", "265.043", "262.193", 
                "G7109KEUBNG1", "3.4.0-2717296", "Linux version 3.4.0-2717296 (se.infra@SEP-113) (gcc version 4.7 (GCC) ) #1 SMP P" +
    "REEMPT Thu Jul 17 16:52:37 KST 2014\n"
    , "Processor\t: ARMv7 Processor rev 3 (v7l)\nprocessor\t: 0\nBogoMIPS\t: 38.40\n\np" +
    "rocessor\t: 1\nBogoMIPS\t: 38.40\n\nprocessor\t: 2\nBogoMIPS\t: 38.40\n\nprocess" +
    "or\t: 3\nBogoMIPS\t: 38.40\n\nFeatures\t: swp half thumb fastmult vfp edsp neon " +
    "vfpv3 tls vfpv4 idiva idivt \nCPU implementer\t: 0x41\nCPU architecture: 7\nCPU " +
    "variant\t: 0x0\nCPU part\t: 0xc07\nCPU revision\t: 3\n\nHardware\t: Qualcomm MSM" +
    " 8226 (Flattened Device Tree)\nRevision\t: 0007\nSerial\t\t: 0000000000000000\n"
    , "dianxin"
            });
            insertLib(maps,new String[] {
                "MSM8626", "samsung", "ms013g", "JLS36C.G7109KEUBNG1", "samsung", "SM-G7109", "ms013gctc", "G7109KEUBNG1", "JLS36C", "user", 
                "release-keys", "se.infra", "SEP-113", "qcom", "armeabi-v7a", "armeabi", "samsung/ms013gctc/ms013g:4.3/JLS36C/G7109KEUBNG1:user/release-keys", "REL", "G7109KEUBNG1", "4.3", 
                "18", "18", "A0000048", "1280", "720", "2.2", "2.0", "320", "265.043", "262.193", 
                "G7109KEUBNG1", "3.4.0-2717296", "Linux version 3.4.0-2717296 (se.infra@SEP-113) (gcc version 4.7 (GCC) ) #1 SMP P" +
    "REEMPT Thu Jul 17 16:52:37 KST 2014\n"
    , "Processor\t: ARMv7 Processor rev 3 (v7l)\nprocessor\t: 0\nBogoMIPS\t: 38.40\n\np" +
    "rocessor\t: 1\nBogoMIPS\t: 38.40\n\nprocessor\t: 2\nBogoMIPS\t: 38.40\n\nprocess" +
    "or\t: 3\nBogoMIPS\t: 38.40\n\nFeatures\t: swp half thumb fastmult vfp edsp neon " +
    "vfpv3 tls vfpv4 idiva idivt \nCPU implementer\t: 0x41\nCPU architecture: 7\nCPU " +
    "variant\t: 0x0\nCPU part\t: 0xc07\nCPU revision\t: 3\n\nHardware\t: Qualcomm MSM" +
    " 8226 (Flattened Device Tree)\nRevision\t: 0007\nSerial\t\t: 0000000000000000\n"
    , "dianxin"
            });
            insertLib(maps,new String[] {
                "MSM8974", "samsung", "klte", "KOT49H.G9009DKEU1AND6", "samsung", "SM-G9009D", "k3gduosctc", "G9009DKEU1AND6", "KOT49H", "user", 
                "release-keys", "dpi", "SWDD5616", "qcom", "armeabi-v7a", "armeabi", "samsung/k3gduosctc/klte:4.4.2/KOT49H/G9009DKEU1AND6:user/release-keys", "REL", "G9009DKEU1AND6", "4.4.2", 
                "19", "19", "A0000048", "1920", "1080", "3.5700002", "3.0", "480", "422.03", "424.069", 
                "G9009DKEU1AND6", "3.4.0-965559", "Linux version 3.4.0-965559 (dpi@SWDD5616) (gcc version 4.7 (GCC) ) #1 SMP PREEMP" +
    "T Thu Apr 24 22:29:07 KST 2014\n"
    , "Processor\t: ARMv7 Processor rev 1 (v7l)\nprocessor\t: 0\nBogoMIPS\t: 38.40\n\np" +
    "rocessor\t: 1\nBogoMIPS\t: 38.40\n\nprocessor\t: 2\nBogoMIPS\t: 38.40\n\nprocess" +
    "or\t: 3\nBogoMIPS\t: 38.40\n\nFeatures\t: swp half thumb fastmult vfp edsp neon " +
    "vfpv3 tls vfpv4 idiva idivt \nCPU implementer\t: 0x51\nCPU architecture: 7\nCPU " +
    "variant\t: 0x2\nCPU part\t: 0x06f\nCPU revision\t: 1\n\nHardware\t: Qualcomm MSM" +
    " 8974 (Flattened Device Tree)\nRevision\t: 000e\nSerial\t\t: 0000f7c100009b2b\n"
    , "dianxin"
            });
            insertLib(maps,new String[] {
                "MSM8974", "samsung", "klte", "KOT49H.G9009DKEU1ANI3", "samsung", "SM-G9009D", "k3gduosctc", "G9009DKEU1ANI3", "KOT49H", "user", 
                "release-keys", "dpi", "SWDD5821", "qcom", "armeabi-v7a", "armeabi", "samsung/k3gduosctc/klte:4.4.2/KOT49H/G9009DKEU1ANI3:user/release-keys", "REL", "G9009DKEU1ANI3", "4.4.2", 
                "19", "19", "A0000048", "1920", "1080", "2.1299999", "3.0", "480", "422.03", "424.069", 
                "G9009DKEU1ANI3", "3.4.0-2833955", "Linux version 3.4.0-2833955 (dpi@SWDD5821) (gcc version 4.7 (GCC) ) #1 SMP PREEM" +
    "PT Mon Sep 22 15:02:58 KST 2014\n"
    , "Processor\t: ARMv7 Processor rev 1 (v7l)\nprocessor\t: 0\nBogoMIPS\t: 38.40\n\np" +
    "rocessor\t: 1\nBogoMIPS\t: 38.40\n\nprocessor\t: 2\nBogoMIPS\t: 38.40\n\nprocess" +
    "or\t: 3\nBogoMIPS\t: 38.40\n\nFeatures\t: swp half thumb fastmult vfp edsp neon " +
    "vfpv3 tls vfpv4 idiva idivt \nCPU implementer\t: 0x51\nCPU architecture: 7\nCPU " +
    "variant\t: 0x2\nCPU part\t: 0x06f\nCPU revision\t: 1\n\nHardware\t: Qualcomm MSM" +
    " 8974 (Flattened Device Tree)\nRevision\t: 000e\nSerial\t\t: 00002b0d00009a59\n"
    , "dianxin"
            });
            insertLib(maps,new String[] {
                "MSM8626", "samsung", "ms013g", "JLS36C.G7109KEUBNG1", "samsung", "SM-G7109", "ms013gctc", "G7109KEUBNG1", "JLS36C", "user", 
                "release-keys", "se.infra", "SEP-113", "qcom", "armeabi-v7a", "armeabi", "samsung/ms013gctc/ms013g:4.3/JLS36C/G7109KEUBNG1:user/release-keys", "REL", "G7109KEUBNG1", "4.3", 
                "18", "18", "A0000048", "1280", "720", "2.0", "2.0", "320", "265.043", "262.193", 
                "G7109KEUBNG1", "3.4.0-2717296", "Linux version 3.4.0-2717296 (se.infra@SEP-113) (gcc version 4.7 (GCC) ) #1 SMP P" +
    "REEMPT Thu Jul 17 16:52:37 KST 2014\n"
    , "Processor\t: ARMv7 Processor rev 3 (v7l)\nprocessor\t: 0\nBogoMIPS\t: 38.40\n\np" +
    "rocessor\t: 1\nBogoMIPS\t: 38.40\n\nprocessor\t: 2\nBogoMIPS\t: 38.40\n\nprocess" +
    "or\t: 3\nBogoMIPS\t: 38.40\n\nFeatures\t: swp half thumb fastmult vfp edsp neon " +
    "vfpv3 tls vfpv4 idiva idivt \nCPU implementer\t: 0x41\nCPU architecture: 7\nCPU " +
    "variant\t: 0x0\nCPU part\t: 0xc07\nCPU revision\t: 3\n\nHardware\t: Qualcomm MSM" +
    " 8226 (Flattened Device Tree)\nRevision\t: 0007\nSerial\t\t: 0000000000000000\n"
    , "dianxin"
            });
            insertLib(maps,new String[] {
                "MSM8626", "samsung", "s3lite", "JLS36C.I939IKEUANG3", "samsung", "SCH-I939I", "s3litectc", "I939IKEUANG3", "JLS36C", "user", 
                "release-keys", "se.infra", "SWDB2809", "qcom", "armeabi-v7a", "armeabi", "samsung/s3litectc/s3lite:4.3/JLS36C/I939IKEUANG3:user/release-keys", "REL", "I939IKEUANG3", "4.3", 
                "18", "18", "A0000048", "1280", "720", "2.74", "2.0", "320", "304.799", "306.716", 
                "I939IKEUANG3", "3.4.0-2720064", "Linux version 3.4.0-2720064 (se.infra@SWDB2809) (gcc version 4.7 (GCC) ) #1 SMP " +
    "PREEMPT Thu Jul 31 10:50:35 KST 2014\n"
    , "Processor\t: ARMv7 Processor rev 3 (v7l)\nprocessor\t: 0\nBogoMIPS\t: 38.40\n\np" +
    "rocessor\t: 1\nBogoMIPS\t: 38.40\n\nprocessor\t: 2\nBogoMIPS\t: 38.40\n\nprocess" +
    "or\t: 3\nBogoMIPS\t: 38.40\n\nFeatures\t: swp half thumb fastmult vfp edsp neon " +
    "vfpv3 tls vfpv4 idiva idivt \nCPU implementer\t: 0x41\nCPU architecture: 7\nCPU " +
    "variant\t: 0x0\nCPU part\t: 0xc07\nCPU revision\t: 3\n\nHardware\t: Qualcomm MSM" +
    " 8226 (Flattened Device Tree)\nRevision\t: 0005\nSerial\t\t: 0000000000000000\n"
    , "dianxin"
            });
            insertLib(maps,new String[] {
                "MSM8625", "samsung", "wilcoxctc", "JZO54K.G3819DKEUANF1", "samsung", "SM-G3819D", "wilcoxctc", "G3819DKEUANA3", "JZO54K", "user", 
                "release-keys", "se.infra", "SWDA2308", "qcom", "armeabi-v7a", "armeabi", "samsung/wilcoxctc/wilcoxctc:4.1.2/JZO54K/G3819DKEUANF1:user/release-keys", "REL", "G3819DKEUANF1", "4.1.2", 
                "16", "16", "A0000048", "960", "540", "1.5", "1.5", "240", "159.48837", "160.42105", 
                "G3819DKEUANA3", "3.4.0-1512851-user", "Linux version 3.4.0-1512851-user (se.infra@SEP-64) (gcc version 4.6.x-google 201" +
    "20106 (prerelease) (GCC) ) #1 SMP PREEMPT Fri Jan 24 17:14:07 KST 2014\n"
    , "Processor\t: ARMv7 Processor rev 1 (v7l)\nprocessor\t: 0\nBogoMIPS\t: 501.64\n\n" +
    "processor\t: 1\nBogoMIPS\t: 501.64\n\nprocessor\t: 2\nBogoMIPS\t: 501.64\n\nproc" +
    "essor\t: 3\nBogoMIPS\t: 501.64\n\nFeatures\t: swp half thumb fastmult vfp edsp t" +
    "humbee neon vfpv3 tls vfpv4 \nCPU implementer\t: 0x41\nCPU architecture: 7\nCPU " +
    "variant\t: 0x0\nCPU part\t: 0xc05\nCPU revision\t: 1\n\nHardware\t: QRD MSM8625Q" +
    " SKUD\nRevision\t: 0000\nSerial\t\t: 4203ef1355c5c054\n"
    , "dianxin"
            });
            insertLib(maps,new String[] {
                "MSM8626", "samsung", "ms013g", "JLS36C.G7109KEUBNG1", "samsung", "SM-G7109", "ms013gctc", "G7109KEUBNG1", "JLS36C", "user", 
                "release-keys", "se.infra", "SEP-113", "qcom", "armeabi-v7a", "armeabi", "samsung/ms013gctc/ms013g:4.3/JLS36C/G7109KEUBNG1:user/release-keys", "REL", "G7109KEUBNG1", "4.3", 
                "18", "18", "A0000048", "1280", "720", "2.0", "2.0", "320", "265.043", "262.193", 
                "G7109KEUBNG1", "3.4.0-2717296", "Linux version 3.4.0-2717296 (se.infra@SEP-113) (gcc version 4.7 (GCC) ) #1 SMP P" +
    "REEMPT Thu Jul 17 16:52:37 KST 2014\n"
    , "Processor\t: ARMv7 Processor rev 3 (v7l)\nprocessor\t: 0\nBogoMIPS\t: 38.40\n\np" +
    "rocessor\t: 1\nBogoMIPS\t: 38.40\n\nprocessor\t: 2\nBogoMIPS\t: 38.40\n\nprocess" +
    "or\t: 3\nBogoMIPS\t: 38.40\n\nFeatures\t: swp half thumb fastmult vfp edsp neon " +
    "vfpv3 tls vfpv4 idiva idivt \nCPU implementer\t: 0x41\nCPU architecture: 7\nCPU " +
    "variant\t: 0x0\nCPU part\t: 0xc07\nCPU revision\t: 3\n\nHardware\t: Qualcomm MSM" +
    " 8226 (Flattened Device Tree)\nRevision\t: 0007\nSerial\t\t: 0000000000000000\n"
    , "dianxin"
            });
            insertLib(maps,new String[] {
                "MSM8625", "samsung", "wilcoxctc", "JZO54K.G3819DKEUAML1", "samsung", "SM-G3819D", "wilcoxctc", "G3819DKEUANE3", "JZO54K", "user", 
                "release-keys", "se.infra", "SEI-43", "qcom", "armeabi-v7a", "armeabi", "samsung/wilcoxctc/wilcoxctc:4.1.2/JZO54K/G3819DKEUAML1:user/release-keys", "REL", "G3819DKEUAML1", "4.1.2", 
                "16", "16", "A0000048", "960", "540", "1.5", "1.5", "240", "159.48837", "160.42105", 
                "G3819DKEUAML1", "3.4.0-1485733-user", "Linux version 3.4.0-1485733-user (se.infra@SEI-43) (gcc version 4.6.x-google 201" +
    "20106 (prerelease) (GCC) ) #1 SMP PREEMPT Fri Dec 13 17:00:33 KST 2013\n"
    , "Processor\t: ARMv7 Processor rev 1 (v7l)\nprocessor\t: 0\nBogoMIPS\t: 601.97\n\n" +
    "processor\t: 1\nBogoMIPS\t: 601.97\n\nprocessor\t: 2\nBogoMIPS\t: 601.97\n\nproc" +
    "essor\t: 3\nBogoMIPS\t: 601.97\n\nFeatures\t: swp half thumb fastmult vfp edsp t" +
    "humbee neon vfpv3 tls vfpv4 \nCPU implementer\t: 0x41\nCPU architecture: 7\nCPU " +
    "variant\t: 0x0\nCPU part\t: 0xc05\nCPU revision\t: 1\n\nHardware\t: QRD MSM8625Q" +
    " SKUD\nRevision\t: 0000\nSerial\t\t: 420322994226c0f8\n"
    , "dianxin"
            });
            insertLib(maps,new String[] {
                "MSM8674", "samsung", "hlte", "KOT49H.N9009KEU2ENH5", "samsung", "SM-N9009", "h3gduosctc", "N9009KEU2ENH5", "KOT49H", "user", 
                "release-keys", "dpi", "SWDD5007", "qcom", "armeabi-v7a", "armeabi", "samsung/h3gduosctc/hlte:4.4.2/KOT49H\n9009KEU2ENH5:user/release-keys", "REL", "N9009KEU2ENH5", "4.4.2", 
                "19", "19", "A0000047", "1920", "1080", "3.27", "3.0", "480", "386.366", "387.047", 
                "N9009KEU2ENH5", "3.4.0-2420422", "Linux version 3.4.0-2420422 (dpi@SWDD5007) (gcc version 4.7 (GCC) ) #1 SMP PREEM" +
    "PT Mon Aug 25 21:21:27 KST 2014\n"
    , "Processor\t: ARMv7 Processor rev 0 (v7l)\nprocessor\t: 0\nBogoMIPS\t: 38.40\n\np" +
    "rocessor\t: 1\nBogoMIPS\t: 38.40\n\nprocessor\t: 2\nBogoMIPS\t: 38.40\n\nprocess" +
    "or\t: 3\nBogoMIPS\t: 38.40\n\nFeatures\t: swp half thumb fastmult vfp edsp neon " +
    "vfpv3 tls vfpv4 idiva idivt \nCPU implementer\t: 0x51\nCPU architecture: 7\nCPU " +
    "variant\t: 0x2\nCPU part\t: 0x06f\nCPU revision\t: 0\n\nHardware\t: Qualcomm MSM" +
    " 8974 (Flattened Device Tree)\nRevision\t: 0008\nSerial\t\t: 0000cb42000063c2\n"
    , "dianxin"
            });
            insertLib(maps,new String[] {
                "MSM8674", "samsung", "hlte", "KOT49H.N9009KEU2ENH5", "samsung", "SM-N9009", "h3gduosctc", "N9009KEU2ENH5", "KOT49H", "user", 
                "release-keys", "dpi", "SWDD5007", "qcom", "armeabi-v7a", "armeabi", "samsung/h3gduosctc/hlte:4.4.2/KOT49H\n9009KEU2ENH5:user/release-keys", "REL", "N9009KEU2ENH5", "4.4.2", 
                "19", "19", "A0000047", "1920", "1080", "3.5700002", "3.0", "480", "386.366", "387.047", 
                "N9009KEU2ENH5", "3.4.0-2420422", "Linux version 3.4.0-2420422 (dpi@SWDD5007) (gcc version 4.7 (GCC) ) #1 SMP PREEM" +
    "PT Mon Aug 25 21:21:27 KST 2014\n"
    , "Processor\t: ARMv7 Processor rev 0 (v7l)\nprocessor\t: 0\nBogoMIPS\t: 38.40\n\np" +
    "rocessor\t: 1\nBogoMIPS\t: 38.40\n\nprocessor\t: 2\nBogoMIPS\t: 38.40\n\nprocess" +
    "or\t: 3\nBogoMIPS\t: 38.40\n\nFeatures\t: swp half thumb fastmult vfp edsp neon " +
    "vfpv3 tls vfpv4 idiva idivt \nCPU implementer\t: 0x51\nCPU architecture: 7\nCPU " +
    "variant\t: 0x2\nCPU part\t: 0x06f\nCPU revision\t: 0\n\nHardware\t: Qualcomm MSM" +
    " 8974 (Flattened Device Tree)\nRevision\t: 0008\nSerial\t\t: 0000cc920000633f\n"
    , "dianxin"
            });
            insertLib(maps,new String[] {
                "MSM8626", "samsung", "s3lite", "JLS36C.I939IKEUANG3", "samsung", "SCH-I939I", "s3litectc", "I939IKEUANG3", "JLS36C", "user", 
                "release-keys", "se.infra", "R0210-03", "qcom", "armeabi-v7a", "armeabi", "samsung/s3litectc/s3lite:4.3/JLS36C/I939IKEUANG3:user/release-keys", "REL", "I939IKEUANG3", "4.3", 
                "18", "18", "A0000047", "1280", "720", "2.74", "2.0", "320", "304.799", "306.716", 
                "I939IKEUANG3", "3.4.0-2720064", "Linux version 3.4.0-2720064 (se.infra@SWDB2809) (gcc version 4.7 (GCC) ) #1 SMP " +
    "PREEMPT Thu Jul 31 10:50:35 KST 2014\n"
    , "Processor\t: ARMv7 Processor rev 3 (v7l)\nprocessor\t: 0\nBogoMIPS\t: 38.40\n\np" +
    "rocessor\t: 1\nBogoMIPS\t: 38.40\n\nprocessor\t: 2\nBogoMIPS\t: 38.40\n\nprocess" +
    "or\t: 3\nBogoMIPS\t: 38.40\n\nFeatures\t: swp half thumb fastmult vfp edsp neon " +
    "vfpv3 tls vfpv4 idiva idivt \nCPU implementer\t: 0x41\nCPU architecture: 7\nCPU " +
    "variant\t: 0x0\nCPU part\t: 0xc07\nCPU revision\t: 3\n\nHardware\t: Qualcomm MSM" +
    " 8226 (Flattened Device Tree)\nRevision\t: 0005\nSerial\t\t: 0000000000000000\n"
    , "dianxin"
            });
            insertLib(maps,new String[] {
                "smdk4x12", "samsung", "m0ctc", "JSS15J.I939KEUFNK1", "samsung", "SCH-I939", "m0ctc", "I939KEUFNK1", "JSS15J", "user", 
                "release-keys", "se.infra", "SWDA2603", "smdk4x12", "armeabi-v7a", "armeabi", "samsung/m0ctc/m0ctc:4.3/JSS15J/I939KEUFNK1:user/release-keys", "REL", "I939KEUFNK1", "4.3", 
                "18", "18", "A0000047", "1280", "720", "2.6", "2.0", "320", "304.8", "306.716", 
                "I939KEUFNK1", "3.0.31-2798076", "", "Processor\t: ARMv7 Processor rev 0 (v7l)\nprocessor\t: 0\nBogoMIPS\t: 1592.52\n\n" +
    "processor\t: 1\nBogoMIPS\t: 2786.91\n\nprocessor\t: 2\nBogoMIPS\t: 2786.91\n\npr" +
    "ocessor\t: 3\nBogoMIPS\t: 1592.52\n\nFeatures\t: swp half thumb fastmult vfp eds" +
    "p neon vfpv3 tls \nCPU implementer\t: 0x41\nCPU architecture: 7\nCPU variant\t: " +
    "0x3\nCPU part\t: 0xc09\nCPU revision\t: 0\n\nChip name\t: EXYNOS4412\nChip revis" +
    "ion\t: 0011\nHardware\t: SMDK4x12\nRevision\t: 000c\nSerial\t\t: 4ab151474d008b1" +
    "1\n"
    , "dianxin"
            });
            insertLib(maps,new String[] {
                "MSM8960", "samsung", "crater3gctc", "JDQ39.P709KEUCNK1", "samsung", "SCH-P709", "crater3gctc", "P709KEUCNK1", "JDQ39", "user", 
                "release-keys", "se.infra", "SWDA2604", "qcom", "armeabi-v7a", "armeabi", "samsung/crater3gctc/crater3gctc:4.2.2/JDQ39/P709KEUCNK1:user/release-keys", "REL", "P709KEUCNK1", "4.2.2", 
                "17", "17", "A0000047", "960", "540", "1.5", "1.5", "240", "159.488", "160.421", 
                "P709KEUCNK1", "3.4.0-2804693", "Linux version 3.4.0-2804693 (se.infra@SWDA2602) (gcc version 4.6.x-google 201201" +
    "06 (prerelease) (GCC) ) #1 SMP PREEMPT Thu Nov 20 18:48:54 KST 2014\n"
    , "Processor\t: ARMv7 Processor rev 0 (v7l)\nprocessor\t: 0\nBogoMIPS\t: 13.53\n\np" +
    "rocessor\t: 1\nBogoMIPS\t: 13.53\n\nFeatures\t: swp half thumb fastmult vfp edsp" +
    " neon vfpv3 tls vfpv4 \nCPU implementer\t: 0x51\nCPU architecture: 7\nCPU varian" +
    "t\t: 0x2\nCPU part\t: 0x04d\nCPU revision\t: 0\n\nHardware\t: SAMSUNG MELIUS\nRe" +
    "vision\t: 0008\nSerial\t\t: 0000011d000011ed\n"
    , "dianxin"
            });
            insertLib(maps,new String[] {
                "MSM8960", "samsung", "crater3gctc", "JDQ39.P709KEUCNI1", "samsung", "SCH-P709", "crater3gctc", "P709KEUCNI1", "JDQ39", "user", 
                "release-keys", "se.infra", "SWDA2604", "qcom", "armeabi-v7a", "armeabi", "samsung/crater3gctc/crater3gctc:4.2.2/JDQ39/P709KEUCNI1:user/release-keys", "REL", "P709KEUCNI1", "4.2.2", 
                "17", "17", "A0000047", "960", "540", "1.5", "1.5", "240", "159.488", "160.421", 
                "P709KEUCNI1", "3.4.0-2779771", "Linux version 3.4.0-2779771 (se.infra@SWDA2604) (gcc version 4.6.x-google 201201" +
    "06 (prerelease) (GCC) ) #1 SMP PREEMPT Thu Sep 18 18:10:46 KST 2014\n"
    , "Processor\t: ARMv7 Processor rev 0 (v7l)\nprocessor\t: 0\nBogoMIPS\t: 13.53\n\np" +
    "rocessor\t: 1\nBogoMIPS\t: 13.53\n\nFeatures\t: swp half thumb fastmult vfp edsp" +
    " neon vfpv3 tls vfpv4 \nCPU implementer\t: 0x51\nCPU architecture: 7\nCPU varian" +
    "t\t: 0x2\nCPU part\t: 0x04d\nCPU revision\t: 0\n\nHardware\t: SAMSUNG MELIUS\nRe" +
    "vision\t: 0008\nSerial\t\t: 000023370000eae5\n"
    , "dianxin"
            });
            insertLib(maps,new String[] {
                "MSM8674", "samsung", "hlte", "KOT49H.N9009KEU2ENH5", "samsung", "SM-N9009", "h3gduosctc", "N9009KEU2ENH5", "KOT49H", "user", 
                "release-keys", "dpi", "SWDD5007", "qcom", "armeabi-v7a", "armeabi", "samsung/h3gduosctc/hlte:4.4.2/KOT49H\n9009KEU2ENH5:user/release-keys", "REL", "N9009KEU2ENH5", "4.4.2", 
                "19", "19", "A0000045", "1920", "1080", "3.0", "3.0", "480", "386.366", "387.047", 
                "N9009KEU2ENH5", "3.4.0-2420422", "Linux version 3.4.0-2420422 (dpi@SWDD5007) (gcc version 4.7 (GCC) ) #1 SMP PREEM" +
    "PT Mon Aug 25 21:21:27 KST 2014\n"
    , "Processor\t: ARMv7 Processor rev 0 (v7l)\nprocessor\t: 0\nBogoMIPS\t: 38.40\n\np" +
    "rocessor\t: 1\nBogoMIPS\t: 38.40\n\nprocessor\t: 2\nBogoMIPS\t: 38.40\n\nprocess" +
    "or\t: 3\nBogoMIPS\t: 38.40\n\nFeatures\t: swp half thumb fastmult vfp edsp neon " +
    "vfpv3 tls vfpv4 idiva idivt \nCPU implementer\t: 0x51\nCPU architecture: 7\nCPU " +
    "variant\t: 0x2\nCPU part\t: 0x06f\nCPU revision\t: 0\n\nHardware\t: Qualcomm MSM" +
    " 8974 (Flattened Device Tree)\nRevision\t: 0008\nSerial\t\t: 0000ba700000610c\n"
    , "dianxin"
            });
            insertLib(maps,new String[] {
                "MSM8625", "samsung", "delos3gduosctc", "JZO54K.I869KESANH2", "samsung", "SCH-I869", "delos3gduosctc", "I869KESAMI1", "JZO54K", "user", 
                "release-keys", "se.infra", "SWDA2612", "qcom", "armeabi-v7a", "armeabi", "samsung/delos3gduosctc/delos3gduosctc:4.1.2/JZO54K/I869KESANH2:user/release-keys", "REL", "I869KESANH2", "4.1.2", 
                "16", "16", "A0000045", "800", "480", "1.5", "1.5", "240", "160.42105", "160", 
                "I869KESANH2", "3.4.0-1568012", "Linux version 3.4.0-1568012 (se.infra@SWDA2612) (gcc version 4.6.x-google 201201" +
    "06 (prerelease) (GCC) ) #1 SMP PREEMPT Tue Aug 26 16:14:21 KST 2014\n"
    , "Processor\t: ARMv7 Processor rev 1 (v7l)\nprocessor\t: 0\nBogoMIPS\t: 348.76\n\n" +
    "processor\t: 1\nBogoMIPS\t: 348.76\n\nprocessor\t: 2\nBogoMIPS\t: 298.59\n\nproc" +
    "essor\t: 3\nBogoMIPS\t: 298.59\n\nFeatures\t: swp half thumb fastmult vfp edsp t" +
    "humbee neon vfpv3 tls vfpv4 \nCPU implementer\t: 0x41\nCPU architecture: 7\nCPU " +
    "variant\t: 0x0\nCPU part\t: 0xc05\nCPU revision\t: 1\n\nHardware\t: QRD MSM8625Q" +
    " SKUD\nRevision\t: 0000\nSerial\t\t: 4d0ae1588611c0c6\n"
    , "dianxin"
            });
            insertLib(maps,new String[] {
                "MSM8674", "samsung", "hlte", "KOT49H.N9009KEU2ENH5", "samsung", "SM-N9009", "h3gduosctc", "N9009KEU2ENH5", "KOT49H", "user", 
                "release-keys", "dpi", "SWDD5620", "qcom", "armeabi-v7a", "armeabi", "samsung/h3gduosctc/hlte:4.4.2/KOT49H\n9009KEU2ENH5:user/release-keys", "REL", "N9009KEU2ENH5", "4.4.2", 
                "19", "19", "A0000045", "1920", "1080", "3.0", "3.0", "480", "386.366", "387.047", 
                "N9009KEU2ENH5", "3.4.0-2420422", "Linux version 3.4.0-2420422 (dpi@SWDD5007) (gcc version 4.7 (GCC) ) #1 SMP PREEM" +
    "PT Mon Aug 25 21:21:27 KST 2014\n"
    , "Processor\t: ARMv7 Processor rev 0 (v7l)\nprocessor\t: 0\nBogoMIPS\t: 38.40\n\np" +
    "rocessor\t: 1\nBogoMIPS\t: 38.40\n\nprocessor\t: 2\nBogoMIPS\t: 38.40\n\nprocess" +
    "or\t: 3\nBogoMIPS\t: 38.40\n\nFeatures\t: swp half thumb fastmult vfp edsp neon " +
    "vfpv3 tls vfpv4 idiva idivt \nCPU implementer\t: 0x51\nCPU architecture: 7\nCPU " +
    "variant\t: 0x2\nCPU part\t: 0x06f\nCPU revision\t: 0\n\nHardware\t: Qualcomm MSM" +
    " 8974 (Flattened Device Tree)\nRevision\t: 0008\nSerial\t\t: 0000a0fd00004bf6\n"
    , "dianxin"
            });
            insertLib(maps,new String[] {
                "MSM8960", "samsung", "crater3gctc", "JDQ39.P709KEUAMK1", "samsung", "SCH-P709", "crater3gctc", "P709KEUAMK1", "JDQ39", "user", 
                "release-keys", "se.infra", "R0304-11", "qcom", "armeabi-v7a", "armeabi", "samsung/crater3gctc/crater3gctc:4.2.2/JDQ39/P709KEUAMK1:user/release-keys", "REL", "P709KEUAMK1", "4.2.2", 
                "17", "17", "A0000045", "960", "540", "1.5", "1.5", "240", "159.488", "160.421", 
                "P709KEUAMK1", "3.4.0-1093768", "Linux version 3.4.0-1093768 (se.infra@R0304-11) (gcc version 4.6.x-google 201201" +
    "06 (prerelease) (GCC) ) #1 SMP PREEMPT Mon Nov 11 11:09:06 KST 2013\n"
    , "Processor\t: ARMv7 Processor rev 0 (v7l)\nprocessor\t: 0\nBogoMIPS\t: 13.53\n\np" +
    "rocessor\t: 1\nBogoMIPS\t: 13.53\n\nFeatures\t: swp half thumb fastmult vfp edsp" +
    " neon vfpv3 tls vfpv4 \nCPU implementer\t: 0x51\nCPU architecture: 7\nCPU varian" +
    "t\t: 0x2\nCPU part\t: 0x04d\nCPU revision\t: 0\n\nHardware\t: SAMSUNG MELIUS\nRe" +
    "vision\t: 0008\nSerial\t\t: 0000231a000045ec\n"
    , "dianxin"
            });
            insertLib(maps,new String[] {
                "MSM8960", "samsung", "crater3gctc", "JDQ39.P709KEUCNC1", "samsung", "SCH-P709", "crater3gctc", "P709KEUCNC1", "JDQ39", "user", 
                "release-keys", "se.infra", "R0301-06", "qcom", "armeabi-v7a", "armeabi", "samsung/crater3gctc/crater3gctc:4.2.2/JDQ39/P709KEUCNC1:user/release-keys", "REL", "P709KEUCNC1", "4.2.2", 
                "17", "17", "A0000045", "960", "540", "1.5", "1.5", "240", "159.488", "160.421", 
                "P709KEUCNC1", "3.4.0-2588966", "Linux version 3.4.0-2588966 (se.infra@R0301-06) (gcc version 4.6.x-google 201201" +
    "06 (prerelease) (GCC) ) #1 SMP PREEMPT Mon Mar 10 15:24:20 KST 2014\n"
    , "Processor\t: ARMv7 Processor rev 0 (v7l)\nprocessor\t: 0\nBogoMIPS\t: 13.53\n\np" +
    "rocessor\t: 1\nBogoMIPS\t: 13.53\n\nFeatures\t: swp half thumb fastmult vfp edsp" +
    " neon vfpv3 tls vfpv4 \nCPU implementer\t: 0x51\nCPU architecture: 7\nCPU varian" +
    "t\t: 0x2\nCPU part\t: 0x04d\nCPU revision\t: 0\n\nHardware\t: SAMSUNG MELIUS\nRe" +
    "vision\t: 0008\nSerial\t\t: 000009d20000f696\n"
    , "dianxin"
            });
            insertLib(maps,new String[] {
                "MSM8625", "samsung", "baffin3gduosctc", "JZO54K.I879KEAMH1", "samsung", "SCH-I879", "baffin3gduosctc", "I879KEAMH1", "JZO54K", "user", 
                "release-keys", "se.infra", "SEI-46", "qcom", "armeabi-v7a", "armeabi", "samsung/baffin3gduosctc/baffin3gduosctc:4.1.2/JZO54K/I879KEAMH1:user/release-key" +
    "s"
    , "REL", "I879KEAMH1", "4.1.2", 
                "16", "16", "A0000045", "800", "480", "1.5", "1.5", "240", "160.42105", "160", 
                "I879KEAMH1", "3.4.0-1345404", "Linux version 3.4.0-1345404 (se.infra@SEI-46) (gcc version 4.6.x-google 20120106" +
    " (prerelease) (GCC) ) #1 SMP PREEMPT Wed Aug 7 14:08:55 KST 2013\n"
    , "Processor\t: ARMv7 Processor rev 1 (v7l)\nprocessor\t: 0\nBogoMIPS\t: 348.76\n\n" +
    "processor\t: 1\nBogoMIPS\t: 298.59\n\nFeatures\t: swp half thumb fastmult vfp ed" +
    "sp thumbee neon vfpv3 tls vfpv4 \nCPU implementer\t: 0x41\nCPU architecture: 7\n" +
    "CPU variant\t: 0x0\nCPU part\t: 0xc05\nCPU revision\t: 1\n\nHardware\t: QCT MSM8" +
    "625 FFA\nRevision\t: 0000\nSerial\t\t: 0000000000000000\n"
    , "dianxin"
            });
            insertLib(maps,new String[] {
                "MSM8960", "samsung", "crater3gctc", "JDQ39.P709KEUCNK1", "samsung", "SCH-P709", "crater3gctc", "P709KEUCNK1", "JDQ39", "user", 
                "release-keys", "se.infra", "SWDA2604", "qcom", "armeabi-v7a", "armeabi", "samsung/crater3gctc/crater3gctc:4.2.2/JDQ39/P709KEUCNK1:user/release-keys", "REL", "P709KEUCNK1", "4.2.2", 
                "17", "17", "A0000045", "960", "540", "1.5", "1.5", "240", "159.488", "160.421", 
                "P709KEUCNK1", "3.4.0-2804693", "Linux version 3.4.0-2804693 (se.infra@SWDA2602) (gcc version 4.6.x-google 201201" +
    "06 (prerelease) (GCC) ) #1 SMP PREEMPT Thu Nov 20 18:48:54 KST 2014\n"
    , "Processor\t: ARMv7 Processor rev 0 (v7l)\nprocessor\t: 0\nBogoMIPS\t: 13.53\n\np" +
    "rocessor\t: 1\nBogoMIPS\t: 13.53\n\nFeatures\t: swp half thumb fastmult vfp edsp" +
    " neon vfpv3 tls vfpv4 \nCPU implementer\t: 0x51\nCPU architecture: 7\nCPU varian" +
    "t\t: 0x2\nCPU part\t: 0x04d\nCPU revision\t: 0\n\nHardware\t: SAMSUNG MELIUS\nRe" +
    "vision\t: 0008\nSerial\t\t: 0000098d0000c2ad\n"
    , "dianxin"
            });
            insertLib(maps,new String[] {
                "MSM8674", "samsung", "hlte", "KOT49H.N9009KEU2ENH5", "samsung", "SM-N9009", "h3gduosctc", "N9009KEU2ENH5", "KOT49H", "user", 
                "release-keys", "dpi", "SWDD5007", "qcom", "armeabi-v7a", "armeabi", "samsung/h3gduosctc/hlte:4.4.2/KOT49H\n9009KEU2ENH5:user/release-keys", "REL", "N9009KEU2ENH5", "4.4.2", 
                "19", "19", "A0000045", "1920", "1080", "3.0", "3.0", "480", "386.366", "387.047", 
                "N9009KEU2ENH5", "3.4.0-2420422", "Linux version 3.4.0-2420422 (dpi@SWDD5007) (gcc version 4.7 (GCC) ) #1 SMP PREEM" +
    "PT Mon Aug 25 21:21:27 KST 2014\n"
    , "Processor\t: ARMv7 Processor rev 0 (v7l)\nprocessor\t: 0\nBogoMIPS\t: 38.40\n\np" +
    "rocessor\t: 1\nBogoMIPS\t: 38.40\n\nprocessor\t: 2\nBogoMIPS\t: 38.40\n\nprocess" +
    "or\t: 3\nBogoMIPS\t: 38.40\n\nFeatures\t: swp half thumb fastmult vfp edsp neon " +
    "vfpv3 tls vfpv4 idiva idivt \nCPU implementer\t: 0x51\nCPU architecture: 7\nCPU " +
    "variant\t: 0x2\nCPU part\t: 0x06f\nCPU revision\t: 0\n\nHardware\t: Qualcomm MSM" +
    " 8974 (Flattened Device Tree)\nRevision\t: 0008\nSerial\t\t: 00001d49000059c6\n"
    , "dianxin"
            });
            insertLib(maps,new String[] {
                "MSM8674", "samsung", "hlte", "KOT49H.N9009KEU2ENF1", "samsung", "SM-N9009", "h3gduosctc", "N9009KEU2ENF1", "KOT49H", "user", 
                "release-keys", "dpi", "SWDD5620", "qcom", "armeabi-v7a", "armeabi", "samsung/h3gduosctc/hlte:4.4.2/KOT49H\n9009KEU2ENF1:user/release-keys", "REL", "N9009KEU2ENF1", "4.4.2", 
                "19", "19", "A0000045", "1920", "1080", "3.27", "3.0", "480", "386.366", "387.047", 
                "N9009KEU2ENF1", "3.4.0-1324431", "Linux version 3.4.0-1324431 (dpi@SWDD5620) (gcc version 4.7 (GCC) ) #1 SMP PREEM" +
    "PT Thu Jun 5 17:15:25 KST 2014\n"
    , "Processor\t: ARMv7 Processor rev 0 (v7l)\nprocessor\t: 0\nBogoMIPS\t: 38.40\n\np" +
    "rocessor\t: 1\nBogoMIPS\t: 38.40\n\nprocessor\t: 2\nBogoMIPS\t: 38.40\n\nprocess" +
    "or\t: 3\nBogoMIPS\t: 38.40\n\nFeatures\t: swp half thumb fastmult vfp edsp neon " +
    "vfpv3 tls vfpv4 idiva idivt \nCPU implementer\t: 0x51\nCPU architecture: 7\nCPU " +
    "variant\t: 0x2\nCPU part\t: 0x06f\nCPU revision\t: 0\n\nHardware\t: Qualcomm MSM" +
    " 8974 (Flattened Device Tree)\nRevision\t: 0008\nSerial\t\t: 0000d7d70000476c\n"
    , "dianxin"
            });
            insertLib(maps,new String[] {
                "MSM8674", "samsung", "hlte", "KOT49H.N9009KEU2ENH5", "samsung", "SM-N9009", "h3gduosctc", "N9009KEU2ENH5", "KOT49H", "user", 
                "release-keys", "dpi", "SWDD5007", "qcom", "armeabi-v7a", "armeabi", "samsung/h3gduosctc/hlte:4.4.2/KOT49H\n9009KEU2ENH5:user/release-keys", "REL", "N9009KEU2ENH5", "4.4.2", 
                "19", "19", "A0000045", "1920", "1080", "3.3000002", "3.0", "480", "386.366", "387.047", 
                "N9009KEU2ENH5", "3.4.0-2420422", "Linux version 3.4.0-2420422 (dpi@SWDD5007) (gcc version 4.7 (GCC) ) #1 SMP PREEM" +
    "PT Mon Aug 25 21:21:27 KST 2014\n"
    , "Processor\t: ARMv7 Processor rev 0 (v7l)\nprocessor\t: 0\nBogoMIPS\t: 38.40\n\np" +
    "rocessor\t: 1\nBogoMIPS\t: 38.40\n\nprocessor\t: 2\nBogoMIPS\t: 38.40\n\nprocess" +
    "or\t: 3\nBogoMIPS\t: 38.40\n\nFeatures\t: swp half thumb fastmult vfp edsp neon " +
    "vfpv3 tls vfpv4 idiva idivt \nCPU implementer\t: 0x51\nCPU architecture: 7\nCPU " +
    "variant\t: 0x2\nCPU part\t: 0x06f\nCPU revision\t: 0\n\nHardware\t: Qualcomm MSM" +
    " 8974 (Flattened Device Tree)\nRevision\t: 0008\nSerial\t\t: 0000cafb0000469a\n"
    , "dianxin"
            });
            insertLib(maps,new String[] {
                "MSM8674", "samsung", "hlte", "JSS15J.N9009KEUDNC1", "samsung", "SM-N9009", "h3gduosctc", "N9009KEUDNC1", "JSS15J", "user", 
                "release-keys", "se.infra", "SEP-120", "qcom", "armeabi-v7a", "armeabi", "samsung/h3gduosctc/hlte:4.3/JSS15J\n9009KEUDNC1:user/release-keys", "REL", "N9009KEUDNC1", "4.3", 
                "18", "18", "A0000045", "1920", "1080", "2.67", "3.0", "480", "386.366", "387.047", 
                "N9009KEUDNC1", "3.4.0-2274372", "Linux version 3.4.0-2274372 (se.infra@SEP-120) (gcc version 4.7 (GCC) ) #1 SMP P" +
    "REEMPT Mon Mar 31 18:01:37 KST 2014\n"
    , "Processor\t: ARMv7 Processor rev 0 (v7l)\nprocessor\t: 0\nBogoMIPS\t: 38.40\n\np" +
    "rocessor\t: 1\nBogoMIPS\t: 38.40\n\nprocessor\t: 2\nBogoMIPS\t: 38.40\n\nprocess" +
    "or\t: 3\nBogoMIPS\t: 38.40\n\nFeatures\t: swp half thumb fastmult vfp edsp neon " +
    "vfpv3 tls vfpv4 idiva idivt \nCPU implementer\t: 0x51\nCPU architecture: 7\nCPU " +
    "variant\t: 0x2\nCPU part\t: 0x06f\nCPU revision\t: 0\n\nHardware\t: Qualcomm MSM" +
    " 8974 (Flattened Device Tree)\nRevision\t: 0008\nSerial\t\t: 000037fe000046d2\n"
    , "dianxin"
            });
            insertLib(maps,new String[] {
                "smdk4x12", "samsung", "m0grandectc", "IMM76D.W2013KEANI1", "samsung", "SCH-W2013", "m0grandectc", "W2013KEANI1", "IMM76D", "user", 
                "release-keys", "se.infra", "SWDA2310", "smdk4x12", "armeabi-v7a", "armeabi", "samsung/m0grandectc/m0grandectc:4.0.4/IMM76D/W2013KEANI1:user/release-keys", "REL", "W2013KEANI1", "4.0.4", 
                "15", "15", "A0000045", "800", "480", "1.7249999", "1.5", "240", "203.2", "191.69812", 
                "W2013KENI1", "3.0.15-1303428", "Linux version 3.0.15-1303428 (se.infra@SWDA2310) (gcc version 4.4.3 (GCC) ) #1 S" +
    "MP PREEMPT Fri Sep 5 18:03:46 KST 2014\n"
    , "Processor\t: ARMv7 Processor rev 0 (v7l)\nprocessor\t: 0\nBogoMIPS\t: 1592.52\n\n" +
    "Features\t: swp half thumb fastmult vfp edsp neon vfpv3 tls \nCPU implementer\t:" +
    " 0x41\nCPU architecture: 7\nCPU variant\t: 0x3\nCPU part\t: 0xc09\nCPU revision\t" +
    ": 0\n\nChip revision\t: 0011\nHardware\t: SMDK4x12\nRevision\t: 000f\nSerial\t\t" +
    ": 5ff9a0bd4d00bddd\n"
    , "dianxin"
            });
            insertLib(maps,new String[] {
                "universal5410", "samsung", "ja3gduosctc", "KOT49H.I959KEUHNJ1", "samsung", "SCH-I959", "ja3gduosctc", "I959KEUHNJ1", "KOT49H", "user", 
                "release-keys", "dpi", "SWDD5919", "universal5410", "armeabi-v7a", "armeabi", "samsung/ja3gduosctc/ja3gduosctc:4.4.2/KOT49H/I959KEUHNJ1:user/release-keys", "REL", "I959KEUHNJ1", "4.4.2", 
                "19", "19", "A0000045", "1920", "1080", "3.0", "3.0", "480", "442.451", "443.345", 
                "I959KEUHNJ1", "3.4.5-2965534", "Linux version 3.4.5-2965534 (dpi@SWDD5919) (gcc version 4.6.x-google 20120106 (p" +
    "rerelease) (GCC) ) #1 SMP PREEMPT Thu Oct 9 17:46:09 KST 2014\n"
    , "Processor\t: ARMv7 Processor rev 3 (v7l)\nprocessor\t: 0\nBogoMIPS\t: 1590.88\n\n" +
    "processor\t: 1\nBogoMIPS\t: 1590.88\n\nprocessor\t: 2\nBogoMIPS\t: 1590.88\n\npr" +
    "ocessor\t: 3\nBogoMIPS\t: 1590.88\n\nFeatures\t: swp half thumb fastmult vfp eds" +
    "p neon vfpv3 tls vfpv4 idiva idivt \nCPU implementer\t: 0x41\nCPU architecture: " +
    "7\nCPU variant\t: 0x2\nCPU part\t: 0xc0f\nCPU revision\t: 3\n\nHardware\t: UNIVE" +
    "RSAL5410\nRevision\t: 000a\nSerial\t\t: 619150b74d00d9d6\n"
    , "dianxin"
            });
            insertLib(maps,new String[] {
                "MSM8960", "samsung", "melius3gduosctc", "JDQ39.P729KEUCNI1", "samsung", "SCH-P729", "melius3gduosctc", "P729KEUCNI1", "JDQ39", "user", 
                "release-keys", "se.infra", "R0301-12", "qcom", "armeabi-v7a", "armeabi", "samsung/melius3gduosctc/melius3gduosctc:4.2.2/JDQ39/P729KEUCNI1:user/release-key" +
    "s"
    , "REL", "P729KEUCNI1", "4.2.2", 
                "17", "17", "A0000044", "1280", "720", "1.5", "1.5", "240", "234.461", "233.899", 
                "P729KEUCNI1", "3.4.0-2778953", "Linux version 3.4.0-2778953 (se.infra@SWDA2602) (gcc version 4.6.x-google 201201" +
    "06 (prerelease) (GCC) ) #1 SMP PREEMPT Wed Sep 17 14:14:43 KST 2014\n"
    , "Processor\t: ARMv7 Processor rev 0 (v7l)\nprocessor\t: 0\nBogoMIPS\t: 13.53\n\np" +
    "rocessor\t: 1\nBogoMIPS\t: 13.53\n\nFeatures\t: swp half thumb fastmult vfp edsp" +
    " neon vfpv3 tls vfpv4 \nCPU implementer\t: 0x51\nCPU architecture: 7\nCPU varian" +
    "t\t: 0x2\nCPU part\t: 0x04d\nCPU revision\t: 0\n\nHardware\t: SAMSUNG MELIUS\nRe" +
    "vision\t: 000b\nSerial\t\t: 0000cb150000d4a3\n"
    , "dianxin"
            });
            insertLib(maps,new String[] {
                "MSM8960", "samsung", "melius3gduosctc", "JDQ39.P729KEUCNI1", "samsung", "SCH-P729", "melius3gduosctc", "P729KEUCNI1", "JDQ39", "user", 
                "release-keys", "se.infra", "R0301-12", "qcom", "armeabi-v7a", "armeabi", "samsung/melius3gduosctc/melius3gduosctc:4.2.2/JDQ39/P729KEUCNI1:user/release-key" +
    "s"
    , "REL", "P729KEUCNI1", "4.2.2", 
                "17", "17", "A0000044", "1280", "720", "1.9499999", "1.5", "240", "234.461", "233.899", 
                "P729KEUCNI1", "3.4.0-2778953", "Linux version 3.4.0-2778953 (se.infra@SWDA2602) (gcc version 4.6.x-google 201201" +
    "06 (prerelease) (GCC) ) #1 SMP PREEMPT Wed Sep 17 14:14:43 KST 2014\n"
    , "Processor\t: ARMv7 Processor rev 0 (v7l)\nprocessor\t: 0\nBogoMIPS\t: 13.53\n\np" +
    "rocessor\t: 1\nBogoMIPS\t: 13.53\n\nFeatures\t: swp half thumb fastmult vfp edsp" +
    " neon vfpv3 tls vfpv4 \nCPU implementer\t: 0x51\nCPU architecture: 7\nCPU varian" +
    "t\t: 0x2\nCPU part\t: 0x04d\nCPU revision\t: 0\n\nHardware\t: SAMSUNG MELIUS\nRe" +
    "vision\t: 000b\nSerial\t\t: 00005857000048fb\n"
    , "dianxin"
            });
            insertLib(maps,new String[] {
                "MSM8625", "samsung", "kyleplusctc", "JZO54K.I739KEANJ1", "samsung", "SCH-I739", "kyleplusctc", "I739KEANJ1", "JZO54K", "user", 
                "release-keys", "se.infra", "S0210-08", "qcom", "armeabi-v7a", "armeabi", "samsung/kyleplusctc/kyleplusctc:4.1.2/JZO54K/I739KEANJ1:user/release-keys", "REL", "I739KEANJ1", "4.1.2", 
                "16", "16", "A0000044", "800", "480", "1.5", "1.5", "240", "160.42105", "160", 
                "I739KEANJ1", "3.4.0-1577287", "Linux version 3.4.0-1577287 (se.infra@SWDA2304) (gcc version 4.6.x-google 201201" +
    "06 (prerelease) (GCC) ) #1 SMP PREEMPT Mon Oct 13 17:57:48 KST 2014\n"
    , "Processor\t: ARMv7 Processor rev 1 (v7l)\nprocessor\t: 0\nBogoMIPS\t: 350.19\n\n" +
    "processor\t: 1\nBogoMIPS\t: 299.82\n\nFeatures\t: swp half thumb fastmult vfp ed" +
    "sp thumbee neon vfpv3 tls vfpv4 \nCPU implementer\t: 0x41\nCPU architecture: 7\n" +
    "CPU variant\t: 0x0\nCPU part\t: 0xc05\nCPU revision\t: 1\n\nHardware\t: QCT MSM8" +
    "625 FFA\nRevision\t: 0000\nSerial\t\t: 0000000000000000\n"
    , "dianxin"
            });
            insertLib(maps,new String[] {
                "C8813Q", "Huawei", "hwC8813Q", "C8813QV100R001C92B191", "HUAWEI", "HUAWEI C8813Q", "C8813Q", "", "HuaweiC8813Q", "user", 
                "ota-rel-keys,release-keys", "huawei", "huawei-desktop", "huawei", "armeabi-v7a", "armeabi", "Huawei/C8813Q/hwC8813Q:4.1.2/HuaweiC8813Q/C92B191:user/ota-rel-keys,release-keys", "REL", "C92B191", "4.1.2", 
                "16", "16", "A0000043", "854", "480", "1.5", "1.5", "240", "160.42105", "159.49706", 
                "3110", "3.4.0-perf-g659f716-00543-g6b8ee76", "Linux version 3.4.0-perf-g659f716-00543-g6b8ee76 (android@localhost) (gcc versio" +
    "n 4.6.x-google 20120106 (prerelease) (GCC) ) #1 SMP PREEMPT Fri May 24 06:58:45 " +
    "CST 2013\n"
    , "Processor\t: ARMv7 Processor rev 1 (v7l)\nprocessor\t: 0\nBogoMIPS\t: 802.63\n\n" +
    "processor\t: 1\nBogoMIPS\t: 802.63\n\nprocessor\t: 2\nBogoMIPS\t: 802.63\n\nproc" +
    "essor\t: 3\nBogoMIPS\t: 802.63\n\nFeatures\t: swp half thumb fastmult vfp edsp t" +
    "humbee neon vfpv3 tls vfpv4 \nCPU implementer\t: 0x41\nCPU architecture: 7\nCPU " +
    "variant\t: 0x0\nCPU part\t: 0xc05\nCPU revision\t: 1\n\nHardware\t: MSM8x25 C881" +
    "3Q BOARD\nRevision\t: 0000\nSerial\t\t: 0000000000000000\n"
    , "dianxin"
            });
            insertLib(maps,new String[] {
                "G610-C00", "Huawei", "hwG610-C00", "G610-C00V100R001C92B127", "HUAWEI", "HUAWEI G610-C00", "G610-C00", "", "HuaweiG610-C00", "user", 
                "ota-rel-keys,release-keys", "huawei", "huawei-desktop", "huawei", "armeabi-v7a", "armeabi", "Huawei/G610-C00/hwG610-C00:4.1.2/HuaweiG610-C00/C92B127:user/ota-rel-keys,releas" +
    "e-keys"
    , "REL", "C92B127", "4.1.2", 
                "16", "16", "A0000043", "960", "540", "1.5", "1.5", "240", "159.48837", "160.42105", 
                "31,103,110", "3.4.0-perf-g659f716-00648-gb0e83b7", "Linux version 3.4.0-perf-g659f716-00648-gb0e83b7 (android@localhost) (gcc versio" +
    "n 4.6.x-google 20120106 (prerelease) (GCC) ) #1 SMP PREEMPT Thu Oct 24 13:57:17 " +
    "CST 2013\n"
    , "Processor\t: ARMv7 Processor rev 1 (v7l)\nprocessor\t: 0\nBogoMIPS\t: 802.63\n\n" +
    "processor\t: 1\nBogoMIPS\t: 398.13\n\nprocessor\t: 2\nBogoMIPS\t: 398.13\n\nproc" +
    "essor\t: 3\nBogoMIPS\t: 398.13\n\nFeatures\t: swp half thumb fastmult vfp edsp t" +
    "humbee neon vfpv3 tls vfpv4 \nCPU implementer\t: 0x41\nCPU architecture: 7\nCPU " +
    "variant\t: 0x0\nCPU part\t: 0xc05\nCPU revision\t: 1\n\nHardware\t: MSM8x25 G610" +
    "C BOARD\nRevision\t: 0000\nSerial\t\t: 0000000000000000\n"
    , "dianxin"
            });
            insertLib(maps,new String[] {
                "A199", "Huawei", "hwa199", "A199V100R001C92B130", "HUAWEI", "HUAWEI A199", "A199", "", "HuaweiA199", "user", 
                "ota-rel-keys,release-keys", "android", "localhost#1", "huawei", "armeabi-v7a", "armeabi", "Huawei/A199/hwa199:4.1.2/HuaweiA199/C92B130:user/ota-rel-keys,release-keys", "REL", "C92B130", "4.1.2", 
                "16", "16", "A0000043", "1280", "720", "2.3", "2.0", "320", "315.31033", "315.65048", 
                "SNAVARZ4394_(Aug 30 2013),MAUI.11B.W11.32.MP.V26.F10_2013/08/30 15:04", "3.0.8-gb581cac", "Linux version 3.0.8-gb581cac (android@localhost) (gcc version 4.6.x-google 20120" +
    "106 (prerelease) (GCC) ) #1 SMP PREEMPT Fri Aug 30 16:00:07 CST 2013\n"
    , "Processor\t: ARMv7 Processor rev 0 (v7l)\nprocessor\t: 0\nBogoMIPS\t: 2989.00\n\n" +
    "processor\t: 1\nBogoMIPS\t: 2989.00\n\nprocessor\t: 2\nBogoMIPS\t: 2989.00\n\npr" +
    "ocessor\t: 3\nBogoMIPS\t: 2989.00\n\nFeatures\t: swp half thumb fastmult vfp eds" +
    "p thumbee neon vfpv3 \nCPU implementer\t: 0x41\nCPU architecture: 7\nCPU variant" +
    "\t: 0x3\nCPU part\t: 0xc09\nCPU revision\t: 0\n\nHardware\t: huawei\nRevision\t:" +
    " 0000\nSerial\t\t: 0000000000000000\n"
    , "dianxin"
            });
            insertLib(maps,new String[] {
                "C8813", "Huawei", "hwc8813", "C8813DV100R001C92B175", "HUAWEI", "HUAWEI C8813D", "C8813D", "", "HuaweiC8813D", "user", 
                "release-keys", "huawei", "huawei-desktop", "huawei", "armeabi-v7a", "armeabi", "Huawei/C8813D/hwc8813:4.1.1/HuaweiC8813D/C92B175:user/ota-rel-keys,release-keys", "REL", "C92B175", "4.1.1", 
                "16", "16", "A0000043", "854", "480", "1.5", "1.5", "240", "160.42105", "159.49706", 
                "3110", "3.4.0-perf-g659f716-00062-ged09299", "Linux version 3.4.0-perf-g659f716-00062-ged09299 (android@localhost) (gcc versio" +
    "n 4.6.x-google 20120106 (prerelease) (GCC) ) #1 SMP PREEMPT Tue Nov 5 19:08:48 C" +
    "ST 2013\n"
    , "Processor\t: ARMv7 Processor rev 1 (v7l)\nprocessor\t: 0\nBogoMIPS\t: 802.63\n\n" +
    "processor\t: 1\nBogoMIPS\t: 802.63\n\nFeatures\t: swp half thumb fastmult vfp ed" +
    "sp thumbee neon vfpv3 tls vfpv4 \nCPU implementer\t: 0x41\nCPU architecture: 7\n" +
    "CPU variant\t: 0x0\nCPU part\t: 0xc05\nCPU revision\t: 1\n\nHardware\t: MSM8x25 " +
    "C8813 BOARD\nRevision\t: 0000\nSerial\t\t: 0000000000000000\n"
    , "dianxin"
            });
            insertLib(maps,new String[] {
                "C8813Q", "Huawei", "hwC8813Q", "C8813QV100R001C92B199", "HUAWEI", "HUAWEI C8813Q", "C8813Q", "", "HuaweiC8813Q", "user", 
                "ota-rel-keys,release-keys", "huawei", "huawei-desktop", "huawei", "armeabi-v7a", "armeabi", "Huawei/C8813Q/hwC8813Q:4.1.2/HuaweiC8813Q/C92B199:user/ota-rel-keys,release-keys", "REL", "C92B199", "4.1.2", 
                "16", "16", "A0000043", "854", "480", "1.5", "1.5", "240", "160.42105", "159.49706", 
                "3110", "3.4.0-perf-g659f716-00570-g60615d0", "Linux version 3.4.0-perf-g659f716-00570-g60615d0 (android@localhost) (gcc versio" +
    "n 4.6.x-google 20120106 (prerelease) (GCC) ) #1 SMP PREEMPT Mon Mar 31 17:17:29 " +
    "CST 2014\n"
    , "Processor\t: ARMv7 Processor rev 1 (v7l)\nprocessor\t: 0\nBogoMIPS\t: 668.86\n\n" +
    "processor\t: 1\nBogoMIPS\t: 668.86\n\nprocessor\t: 2\nBogoMIPS\t: 398.13\n\nproc" +
    "essor\t: 3\nBogoMIPS\t: 398.13\n\nFeatures\t: swp half thumb fastmult vfp edsp t" +
    "humbee neon vfpv3 tls vfpv4 \nCPU implementer\t: 0x41\nCPU architecture: 7\nCPU " +
    "variant\t: 0x0\nCPU part\t: 0xc05\nCPU revision\t: 1\n\nHardware\t: MSM8x25 C881" +
    "3Q BOARD\nRevision\t: 0000\nSerial\t\t: 0000000000000000\n"
    , "dianxin"
            });
            insertLib(maps,new String[] {
                "A199", "Huawei", "hwa199", "A199V100R001C92B128", "HUAWEI", "HUAWEI A199", "A199", "", "HuaweiA199", "user", 
                "ota-rel-keys,release-keys", "android", "localhost#1", "huawei", "armeabi-v7a", "armeabi", "Huawei/A199/hwa199:4.1.2/HuaweiA199/C92B128:user/ota-rel-keys,release-keys", "REL", "C92B128", "4.1.2", 
                "16", "16", "A0000043", "1280", "720", "2.0", "2.0", "320", "315.31033", "315.65048", 
                "SNAVARZ4394_(Jul 09 2013),MAUI.11B.W11.32.MP.V26.F10_2013/07/09 17:46", "3.0.8-gc58e832", "Linux version 3.0.8-gc58e832 (android@localhost) (gcc version 4.6.x-google 20120" +
    "106 (prerelease) (GCC) ) #1 SMP PREEMPT Tue Jul 9 18:07:08 CST 2013\n"
    , "Processor\t: ARMv7 Processor rev 0 (v7l)\nprocessor\t: 0\nBogoMIPS\t: 2989.00\n\n" +
    "processor\t: 1\nBogoMIPS\t: 2989.00\n\nprocessor\t: 2\nBogoMIPS\t: 2989.00\n\npr" +
    "ocessor\t: 3\nBogoMIPS\t: 2989.00\n\nFeatures\t: swp half thumb fastmult vfp eds" +
    "p thumbee neon vfpv3 \nCPU implementer\t: 0x41\nCPU architecture: 7\nCPU variant" +
    "\t: 0x3\nCPU part\t: 0xc09\nCPU revision\t: 0\n\nHardware\t: huawei\nRevision\t:" +
    " 0000\nSerial\t\t: 0000000000000000\n"
    , "dianxin"
            });
            insertLib(maps,new String[] {
                "Y300C", "Huawei", "hwy300C", "Y300CV100R001C92B170", "HUAWEI", "HUAWEI Y300C", "Y300C", "", "HuaweiY300C", "user", 
                "release-keys", "huawei", "huawei-desktop", "huawei", "armeabi-v7a", "armeabi", "Huawei/Y300C/hwy300C:4.1.1/HuaweiY300C/C92B170:user/ota-rel-keys,release-keys", "REL", "C92B170", "4.1.1", 
                "16", "16", "A0000042", "800", "480", "1.7249999", "1.5", "240", "160.42105", "160", 
                "QC8X25_Y321C_V043_1204", "3.4.0-perf-g659f716-00062-ged09299", "Linux version 3.4.0-perf-g659f716-00062-ged09299 (android@localhost) (gcc versio" +
    "n 4.6.x-google 20120106 (prerelease) (GCC) ) #1 SMP PREEMPT Fri Jul 26 22:25:05 " +
    "CST 2013\n"
    , "Processor\t: ARMv7 Processor rev 1 (v7l)\nprocessor\t: 0\nBogoMIPS\t: 668.86\n\n" +
    "processor\t: 1\nBogoMIPS\t: 668.86\n\nFeatures\t: swp half thumb fastmult vfp ed" +
    "sp thumbee neon vfpv3 tls vfpv4 \nCPU implementer\t: 0x41\nCPU architecture: 7\n" +
    "CPU variant\t: 0x0\nCPU part\t: 0xc05\nCPU revision\t: 1\n\nHardware\t: MSM8x25 " +
    "C8833D BOARD\nRevision\t: 0000\nSerial\t\t: 0000000000000000\n"
    , "dianxin"
            });
            insertLib(maps,new String[] {
                "smdk4x12", "samsung", "t03gctc", "JZO54K.N719KEBMC1", "samsung", "SCH-N719", "t03gctc", "N719KEBMC1", "JZO54K", "user", 
                "release-keys", "se.infra", "SEP-108", "smdk4x12", "armeabi-v7a", "armeabi", "samsung/t03gctc/t03gctc:4.1.2/JZO54K\n719KEBMC1:user/release-keys", "REL", "N719KEBMC1", "4.1.2", 
                "16", "16", "A0000040", "1280", "720", "2.0", "2.0", "320", "265.0435", "264.3252", 
                "N719KEBMC1", "3.0.31-999893", "Linux version 3.0.31-999893 (se.infra@SEP-108) (gcc version 4.4.3 (GCC) ) #1 SMP" +
    " PREEMPT Fri Mar 1 15:32:01 KST 2013\n"
    , "Processor\t: ARMv7 Processor rev 0 (v7l)\nprocessor\t: 0\nBogoMIPS\t: 1592.52\n\n" +
    "processor\t: 3\nBogoMIPS\t: 2189.72\n\nFeatures\t: swp half thumb fastmult vfp e" +
    "dsp neon vfpv3 tls \nCPU implementer\t: 0x41\nCPU architecture: 7\nCPU variant\t" +
    ": 0x3\nCPU part\t: 0xc09\nCPU revision\t: 0\n\nChip revision\t: 0020\nHardware\t" +
    ": SMDK4x12\nRevision\t: 000a\nSerial\t\t: 3320319b4df7a5a0\n"
    , "dianxin"
            });
            insertLib(maps,new String[] {
                "7x27", "ZTE", "ZTE-N900D", "CT_CN_N900DV1.0.0B10", "ZTE", "ZTE N900D", "ZTE-N900D", "", "JZO54K", "user", 
                "release-keys", "", "SCL_XA242_128", "qcom", "armeabi-v7a", "armeabi", "ZTE/ZTE-N900D/ZTE-N900D:4.1.2/JZO54K/eng..20140312.011154:user/release-keys", "REL", "eng..20140312.011154", "4.1.2", 
                "16", "16", "A0000038", "854", "480", "1.5", "1.5", "240", "160.42105", "159.49706", 
                "8X25Q-QDOSKMLYM-3040,8X25Q-QDOSKMLYM-3040", "3.4.0-perf", "Linux version 3.4.0-perf (root@SCL_XA242_128) (gcc version 4.6.x-google 20120106" +
    " (prerelease) (GCC) ) #1 SMP PREEMPT Wed Mar 12 01:33:19 CST 2014\n"
    , "Processor\t: ARMv7 Processor rev 1 (v7l)\nprocessor\t: 0\nBogoMIPS\t: 501.64\n\n" +
    "processor\t: 1\nBogoMIPS\t: 298.59\n\nFeatures\t: swp half thumb fastmult vfp ed" +
    "sp thumbee neon vfpv3 tls vfpv4 \nCPU implementer\t: 0x41\nCPU architecture: 7\n" +
    "CPU variant\t: 0x0\nCPU part\t: 0xc05\nCPU revision\t: 1\n\nHardware\t: QCT MSM8" +
    "625 SURF\nRevision\t: 0000\nSerial\t\t: 0000000000000000\n"
    , "dianxin"
            });
            insertLib(maps,new String[] {
                "P692N30", "ZTE", "P692N30", "CT_CN_G717CV1.0.0B12", "ZTE", "ZTE G717C", "P692N30", "", "JDQ39", "user", 
                "release-keys", "root", "SCL_XA242_176", "mt6592", "armeabi-v7a", "armeabi", "ZTE/P692N30/P692N30:4.2.2/JDQ39/eng.root.20140428.091431:user/release-keys", "REL", "eng.root.20140428.091431", "4.2.2", 
                "17", "17", "A0000038", "1280", "720", "2.0", "2.0", "320", "320", "320", 
                "8X25Q-QDOSKMLYM-3040,8X25Q-QDOSKMLYM-3040", "3.4.39", "Linux version 3.4.39 (root@SCL_XA242_176) (gcc version 4.6.x-google 20120106 (pr" +
    "erelease) (GCC) ) #2 SMP PREEMPT Mon Apr 28 09:14:23 CST 2014\n"
    , "Processor\t: ARMv7 Processor rev 4 (v7l)\nprocessor\t: 0\nBogoMIPS\t: 1514.68\n\n" +
    "processor\t: 1\nBogoMIPS\t: 1514.68\n\nprocessor\t: 2\nBogoMIPS\t: 1514.68\n\npr" +
    "ocessor\t: 3\nBogoMIPS\t: 1514.68\n\nprocessor\t: 4\nBogoMIPS\t: 1514.68\n\nFeat" +
    "ures\t: swp half thumb fastmult vfp edsp thumbee neon vfpv3 tls vfpv4 idiva idiv" +
    "t \nCPU implementer\t: 0x41\nCPU architecture: 7\nCPU variant\t: 0x0\nCPU part\t" +
    ": 0xc07\nCPU revision\t: 4\n\nHardware\t: MT6592\nRevision\t: 0000\nSerial\t\t: " +
    "0000000000000000\n"
    , "dianxin"
            });
            insertLib(maps,new String[] {
                "8625", "ZTE", "ZTE_N798", "CTWH_CN_N798+V1.0.0B04", "ZTE", "ZTE N798+", "ZTE_N798", "", "IMM76I", "user", 
                "release-keys", "", "SCL_XA240_206", "qcom", "armeabi-v7a", "armeabi", "ZTE/ZTE_N798/ZTE_N798:4.0.4/IMM76I/eng..20130710.035311:user/release-keys", "REL", "eng..20130710.035311", "4.0.4", 
                "15", "15", "A0000038", "800", "480", "1.5", "1.5", "240", "160.42105", "160", 
                "8X25Q-QDOSKMLYM-3040,8X25Q-QDOSKMLYM-3040", "3.0.21-perf", "Linux version 3.0.21-perf (root@SCL_XA240_206) (gcc version 4.4.3 (GCC) ) #1 SMP" +
    " PREEMPT Wed Jul 10 04:26:20 CST 2013\n"
    , "Processor\t: ARMv7 Processor rev 1 (v7l)\nprocessor\t: 0\nBogoMIPS\t: 573.30\n\n" +
    "processor\t: 1\nBogoMIPS\t: 573.30\n\nFeatures\t: swp half thumb fastmult vfp ed" +
    "sp thumbee neon vfpv3 tls vfpv4 \nCPU implementer\t: 0x41\nCPU architecture: 7\n" +
    "CPU variant\t: 0x0\nCPU part\t: 0xc05\nCPU revision\t: 1\n\nHardware\t: QCT MSM8" +
    "625 SURF\nRevision\t: 0000\nSerial\t\t: 0000000000000000\n"
    , "dianxin"
            });
            insertLib(maps,new String[] {
                "8625", "ZTE", "ZTE-N919", "CT_CN_N919V1.0.0B08", "ZTE", "ZTE N919", "ZTE-N919", "", "JZO54K", "user", 
                "release-keys", "", "SCL_XA240_110", "qcom", "armeabi-v7a", "armeabi", "ZTE/ZTE-N919/ZTE-N919:4.1.2/JZO54K/eng..20130816.061543:user/release-keys", "REL", "eng..20130816.061543", "4.1.2", 
                "16", "16", "A0000038", "960", "540", "1.5", "1.5", "240", "159.48837", "160.42105", 
                "8X25Q-QDOSKQLYM-3050", "3.4.0-perf", "Linux version 3.4.0-perf (root@SCL_XA240_110) (gcc version 4.6.x-google 20120106" +
    " (prerelease) (GCC) ) #1 SMP PREEMPT Fri Aug 16 06:38:12 CST 2013\n"
    , "Processor\t: ARMv7 Processor rev 1 (v7l)\nprocessor\t: 0\nBogoMIPS\t: 350.19\n\n" +
    "processor\t: 1\nBogoMIPS\t: 350.19\n\nprocessor\t: 2\nBogoMIPS\t: 350.19\n\nproc" +
    "essor\t: 3\nBogoMIPS\t: 350.19\n\nFeatures\t: swp half thumb fastmult vfp edsp t" +
    "humbee neon vfpv3 tls vfpv4 \nCPU implementer\t: 0x41\nCPU architecture: 7\nCPU " +
    "variant\t: 0x0\nCPU part\t: 0xc05\nCPU revision\t: 1\n\nHardware\t: QRD MSM8625Q" +
    " SKUD\nRevision\t: 0000\nSerial\t\t: 0000000000000000\n"
    , "dianxin"
            });
            insertLib(maps,new String[] {
                "Qualcomm8x25", "motorola", "ironprimect_cg", "IRPMCT_B_02.64.00RPD", "Motorola", "MOT-XT788", "XT788_ct", "", "IRPMCT_B_02.64.00RPD", "user", 
                "release-keys", "User", "Host", "qcom", "armeabi-v7a", "armeabi", "motorola/XT788_ct/ironprimect_cg:4.0.4/IRPMCT_B_02.64.00RPD/02.64.00:user/releas" +
    "e-keys"
    , "REL", "02.64.00", "4.0.4", 
                "15", "15", "A000002C", "894", "540", "1.5749999", "1.5", "240", "159.48837", "160.42105", 
                "2.1-311_6.0", "3.0.21-perf", "Linux version 3.0.21-perf (cuiyuehua@build168) (gcc version 4.4.3 (GCC) ) #1 SMP" +
    " PREEMPT Sat Dec 1 20:02:22 CST 2012\n"
    , "Processor\t: ARMv7 Processor rev 1 (v7l)\nprocessor\t: 0\nBogoMIPS\t: 573.30\n\n" +
    "processor\t: 1\nBogoMIPS\t: 573.30\n\nFeatures\t: swp half thumb fastmult vfp ed" +
    "sp thumbee neon vfpv3 tls vfpv4 \nCPU implementer\t: 0x41\nCPU architecture: 7\n" +
    "CPU variant\t: 0x0\nCPU part\t: 0xc05\nCPU revision\t: 1\n\nHardware\t: QCT MSM8" +
    "625 SURF\nRevision\t: 0000\nSerial\t\t: 0000000000000000\n"
    , "dianxin"
            });


            insertLib(maps,new String[] {
                "MSM8226", "Xiaomi", "armani", "JLS36C", "Xiaomi", "HM 1SC", "armani", "", "JLS36C", "user", 
                "release-keys", "builder", "wcc-miui-ota-bd03.bj", "qcom", "armeabi-v7a", "armeabi", "Xiaomi/armani/armani:4.3/JLS36C/JHCCNBF33.0:user/release-keys", "REL", "JHCCNBF33.0", "4.3", 
                "18", "18", "99000566", "1280", "720", "2.42", "2.0", "320", "160.421", "160.157", 
                "MPSS.TR.2.0-feffbac,MPSS.TR.2.0-feffbac", "3.4.0-g6e12f86-00304-gff5ad06", "Linux version 3.4.0-g6e12f86-00304-gff5ad06 (builder@xiangshan.n.xiaomi.com) (gc" +
    "c version 4.7 (GCC) ) #1 SMP PREEMPT Tue Jul 22 11:51:41 CST 2014\n"
    , "Processor\t: ARMv7 Processor rev 3 (v7l)\nprocessor\t: 0\nBogoMIPS\t: 38.40\n\np" +
    "rocessor\t: 1\nBogoMIPS\t: 38.40\n\nprocessor\t: 2\nBogoMIPS\t: 38.40\n\nprocess" +
    "or\t: 3\nBogoMIPS\t: 38.40\n\nFeatures\t: swp half thumb fastmult vfp edsp neon " +
    "vfpv3 tls vfpv4 idiva idivt \nCPU implementer\t: 0x41\nCPU architecture: 7\nCPU " +
    "variant\t: 0x0\nCPU part\t: 0xc07\nCPU revision\t: 3\n\nHardware\t: Qualcomm MSM" +
    " 8226 (Flattened Device Tree)\nRevision\t: 0000\nSerial\t\t: 0000000000000000\n"
    , "dianxin"
            });
            insertLib(maps,new String[] {
                "7x27", "Coolpad", "Coolpad7295C_C00", "4.1.038.P2.140630.7295C_C00", "YuLong", "Coolpad 7295C_C00", "Coolpad7295C_C00", "", "JZO54K", "user", 
                "release-keys", "mine", "mine", "qcom", "armeabi-v7a", "armeabi", "Coolpad/Coolpad7295C_C00/Coolpad7295C_C00:4.1.2/JZO54K/4.1.038.P2.140630.7295C_C" +
    "00:user/release-keys"
    , "REL", "4.1.038.P2.140630.7295C_C00", "4.1.2", 
                "16", "16", "99000555", "960", "540", "1.7249999", "1.5", "240", "221.2258", "221.67273", 
                "8X25Q-QHOSKMLYM-3010", "3.4.0-perf", "Linux version 3.4.0-perf (mine@mine) (gcc version 4.6.x-google 20120106 (prerele" +
    "ase) (GCC) ) #1 SMP PREEMPT Mon Jun 30 12:02:38 CST 2014\n"
    , "Processor\t: ARMv7 Processor rev 1 (v7l)\nprocessor\t: 0\nBogoMIPS\t: 601.97\n\n" +
    "processor\t: 1\nBogoMIPS\t: 298.59\n\nprocessor\t: 2\nBogoMIPS\t: 298.59\n\nproc" +
    "essor\t: 3\nBogoMIPS\t: 298.59\n\nFeatures\t: swp half thumb fastmult vfp edsp t" +
    "humbee neon vfpv3 tls vfpv4 \nCPU implementer\t: 0x41\nCPU architecture: 7\nCPU " +
    "variant\t: 0x0\nCPU part\t: 0xc05\nCPU revision\t: 1\n\nHardware\t: QRD MSM8625Q" +
    " SKUE\nRevision\t: 0000\nSerial\t\t: 0000000000000000\n"
    , "dianxin"
            });
            insertLib(maps,new String[] {
                "MSM8974", "Xiaomi", "cancro", "KTU84P", "Xiaomi", "MI 3C", "cancro", "", "KTU84P", "user", 
                "release-keys", "builder", "zc-miui-ota-bd27", "qcom", "armeabi-v7a", "armeabi", "Xiaomi/cancro/cancro:4.4.4/KTU84P/V6.2.1.0.KXDCNBK:user/release-keys", "REL", "V6.2.1.0.KXDCNBK", "4.4.4", 
                "19", "19", "99000549", "1920", "1080", "3.0", "3.0", "480", "449.704", "447.412", 
                "MPSS.DI.3.0-a2ac5b4", "3.4.0-gdfdaba7-01182-g9b25266", "", "Processor\t: ARMv7 Processor rev 1 (v7l)\nprocessor\t: 0\nBogoMIPS\t: 38.40\n\np" +
    "rocessor\t: 1\nBogoMIPS\t: 38.40\n\nprocessor\t: 2\nBogoMIPS\t: 38.40\n\nprocess" +
    "or\t: 3\nBogoMIPS\t: 38.40\n\nFeatures\t: swp half thumb fastmult vfp edsp neon " +
    "vfpv3 tls vfpv4 idiva idivt \nCPU implementer\t: 0x51\nCPU architecture: 7\nCPU " +
    "variant\t: 0x2\nCPU part\t: 0x06f\nCPU revision\t: 1\n\nHardware\t: Qualcomm MSM" +
    "8974PRO-AB\nRevision\t: 0000\nSerial\t\t: 0000000000000000\n"
    , "dianxin"
            });
            insertLib(maps,new String[] {
                "aries", "Xiaomi", "aries", "MI2_2.0_A.01_140514", "Xiaomi", "MI 2S", "aries", "", "JDQ39E", "userdebug", 
                "test-keys", "cofface", "Git-Ubuntu-Server-X64", "aries", "armeabi-v7a", "armeabi", "Xiaomi/aries/aries:4.2.2/JDQ39/573038:user/release-keys", "REL", "JDQ39E", "4.2.2", 
                "17", "17", "99000537", "1280", "720", "2.0", "2.0", "320", "160.421", "160.157", 
                "M9615A-CEFWMAZM-2.0.128017", "3.4.0-gc20fec0-00090-gc610f15", "Linux version 3.4.0-gc20fec0-00090-gc610f15 (huangqiwu@xiaomi) (gcc version 4.6." +
    "x-google 20120106 (prerelease) (GCC) ) #1 SMP PREEMPT Tue Aug 27 09:56:57 CST 20" +
    "13\n"
    , "Processor\t: ARMv7 Processor rev 0 (v7l)\nprocessor\t: 0\nBogoMIPS\t: 13.53\n\np" +
    "rocessor\t: 1\nBogoMIPS\t: 13.53\n\nprocessor\t: 2\nBogoMIPS\t: 13.53\n\nprocess" +
    "or\t: 3\nBogoMIPS\t: 13.53\n\nFeatures\t: swp half thumb fastmult vfp edsp neon " +
    "vfpv3 tls vfpv4 \nCPU implementer\t: 0x51\nCPU architecture: 7\nCPU variant\t: 0" +
    "x1\nCPU part\t: 0x06f\nCPU revision\t: 0\n\nHardware\t: MI 2\nRevision\t: 0000\n" +
    "Serial\t\t: 0000000000000000\n"
    , "dianxin"
            });
            insertLib(maps,new String[] {
                "MSM8226", "Xiaomi", "armani", "JLS36C", "Xiaomi", "HM 1SC", "armani", "", "JLS36C", "user", 
                "release-keys", "builder", "wcc-miui-ota-bd03.bj", "qcom", "armeabi-v7a", "armeabi", "Xiaomi/armani/armani:4.3/JLS36C/JHCCNBH45.0:user/release-keys", "REL", "JHCCNBH45.0", "4.3", 
                "18", "18", "99000536", "1280", "720", "2.0", "2.0", "320", "160.421", "160.157", 
                "MPSS.TR.2.0-b56bcd8,MPSS.TR.2.0-b56bcd8", "3.4.0-g6e12f86-00309-g46cb3b3", "Linux version 3.4.0-g6e12f86-00309-g46cb3b3 (builder@xiangshan.n.xiaomi.com) (gc" +
    "c version 4.7 (GCC) ) #1 SMP PREEMPT Mon Sep 22 13:32:30 CST 2014\n"
    , "Processor\t: ARMv7 Processor rev 3 (v7l)\nprocessor\t: 0\nBogoMIPS\t: 38.40\n\np" +
    "rocessor\t: 1\nBogoMIPS\t: 38.40\n\nprocessor\t: 2\nBogoMIPS\t: 38.40\n\nprocess" +
    "or\t: 3\nBogoMIPS\t: 38.40\n\nFeatures\t: swp half thumb fastmult vfp edsp neon " +
    "vfpv3 tls vfpv4 idiva idivt \nCPU implementer\t: 0x41\nCPU architecture: 7\nCPU " +
    "variant\t: 0x0\nCPU part\t: 0xc07\nCPU revision\t: 3\n\nHardware\t: Qualcomm MSM" +
    " 8226 (Flattened Device Tree)\nRevision\t: 0000\nSerial\t\t: 0000000000000000\n"
    , "dianxin"
            });
            insertLib(maps,new String[] {
                "MSM8974", "Xiaomi", "cancro", "KTU84P", "Xiaomi", "MI 3C", "cancro", "", "KTU84P", "user", 
                "release-keys", "builder", "zc-miui-ota-bd27", "qcom", "armeabi-v7a", "armeabi", "Xiaomi/cancro/cancro:4.4.4/KTU84P/V6.1.2.0.KXDCNBJ:user/release-keys", "REL", "V6.1.2.0.KXDCNBJ", "4.4.4", 
                "19", "19", "99000535", "1920", "1080", "3.0", "3.0", "480", "449.704", "447.412", 
                "MPSS.DI.3.0-7bea055", "3.4.0-g64e9dd0-01123-g5ab8247", "Linux version 3.4.0-g64e9dd0-01123-g5ab8247 (builder@taishan) (gcc version 4.7 (" +
    "GCC) ) #1 SMP PREEMPT Wed Oct 29 11:53:15 CST 2014\n"
    , "Processor\t: ARMv7 Processor rev 1 (v7l)\nprocessor\t: 0\nBogoMIPS\t: 38.40\n\np" +
    "rocessor\t: 1\nBogoMIPS\t: 38.40\n\nprocessor\t: 2\nBogoMIPS\t: 38.40\n\nprocess" +
    "or\t: 3\nBogoMIPS\t: 38.40\n\nFeatures\t: swp half thumb fastmult vfp edsp neon " +
    "vfpv3 tls vfpv4 idiva idivt \nCPU implementer\t: 0x51\nCPU architecture: 7\nCPU " +
    "variant\t: 0x2\nCPU part\t: 0x06f\nCPU revision\t: 1\n\nHardware\t: Qualcomm MSM" +
    "8974PRO-AB\nRevision\t: 0000\nSerial\t\t: 0000000000000000\n"
    , "dianxin"
            });
            insertLib(maps,new String[] {
                "MSM8226", "Coolpad", "CoolpadT1", "4.4.062.P0.141119.T1", "YuLong", "Coolpad T1", "CoolpadT1", "", "KVT49L", "user", 
                "release-keys", "system5", "ubuntu", "qcom", "armeabi-v7a", "armeabi", "Coolpad/CoolpadT1/CoolpadT1:4.4.2/KVT49L/4.4.062.P0.141119.T1:user/release-keys", "REL", "4.4.062.P0.141119.T1", "4.4.2", 
                "19", "19", "99000525", "1280", "720", "2.5000038", "2.0", "320", "268.941", "268.694", 
                "MPSS.DI.3.0.c6-00158-M8926DAAAANAZM-1  1  [Aug 11 2014 04:00:00]", "3.4.0", "Linux version 3.4.0 (system5@ubuntu) (gcc version 4.7 (GCC) ) #1 SMP PREEMPT Wed" +
    " Nov 19 17:35:39 CST 2014\n"
    , "Processor\t: ARMv7 Processor rev 3 (v7l)\nprocessor\t: 0\nBogoMIPS\t: 38.40\n\np" +
    "rocessor\t: 1\nBogoMIPS\t: 38.40\n\nprocessor\t: 2\nBogoMIPS\t: 38.40\n\nprocess" +
    "or\t: 3\nBogoMIPS\t: 38.40\n\nFeatures\t: swp half thumb fastmult vfp edsp neon " +
    "vfpv3 tls vfpv4 idiva idivt \nCPU implementer\t: 0x41\nCPU architecture: 7\nCPU " +
    "variant\t: 0x0\nCPU part\t: 0xc07\nCPU revision\t: 3\n\nHardware\t: Qualcomm MSM" +
    "8926\nRevision\t: 0000\nSerial\t\t: 0000000000000000\n"
    , "dianxin"
            });
            insertLib(maps,new String[] {
                "MSM8226", "Coolpad", "Coolpad9190L", "4.3.095.P0.141203.9190L", "YuLong", "Coolpad 9190L", "Coolpad9190L", "", "JLS36C", "user", 
                "release-keys", "system9", "mine", "qcom", "armeabi-v7a", "armeabi", "Coolpad/Coolpad9190L/Coolpad9190L:4.3/JLS36C/4.3.095.P0.141203.9190L:user/releas" +
    "e-keys"
    , "REL", "4.3.095.P0.141203.9190L", "4.3", 
                "18", "18", "99000524", "1280", "720", "2.5", "2.0", "320", "243.839", "246.303", 
                "TD-SCDMA", "3.4.0-g1e451e8-03784-g5bebcd4", "Linux version 3.4.0-g1e451e8-03784-g5bebcd4 (system9@mine) (gcc version 4.7 (GCC" +
    ") ) #1 SMP PREEMPT Wed Dec 3 23:04:39 CST 2014\n"
    , "Processor\t: ARMv7 Processor rev 3 (v7l)\nprocessor\t: 0\nBogoMIPS\t: 38.40\n\np" +
    "rocessor\t: 1\nBogoMIPS\t: 38.40\n\nprocessor\t: 2\nBogoMIPS\t: 38.40\n\nprocess" +
    "or\t: 3\nBogoMIPS\t: 38.40\n\nFeatures\t: swp half thumb fastmult vfp edsp neon " +
    "vfpv3 tls vfpv4 idiva idivt \nCPU implementer\t: 0x41\nCPU architecture: 7\nCPU " +
    "variant\t: 0x0\nCPU part\t: 0xc07\nCPU revision\t: 3\n\nHardware\t: Qualcomm MSM" +
    " 8226 (Flattened Device Tree)\nRevision\t: 0000\nSerial\t\t: 0000000000000000\n"
    , "dianxin"
            });
            insertLib(maps,new String[] {
                "MSM8226", "Coolpad", "Coolpad5892", "4.3.083.P2.140910.5892", "YuLong", "Coolpad 5892", "Coolpad5892", "", "JLS36C", "user", 
                "release-keys", "system9", "ubuntu", "qcom", "armeabi-v7a", "armeabi", "Coolpad/Coolpad5892/Coolpad5892:4.3/JLS36C/4.3.083.P2.140910.5892:user/release-k" +
    "eys"
    , "REL", "4.3.083.P2.140910.5892", "4.3", 
                "18", "18", "99000523", "854", "480", "2.7000027", "1.5", "240", "196.645", "197.196", 
                "8X25Q-QHOSKMLYM-3010", "3.4.0-g1e451e8-03880-gda98128-dirty", "", "Processor\t: ARMv7 Processor rev 3 (v7l)\nprocessor\t: 0\nBogoMIPS\t: 38.40\n\np" +
    "rocessor\t: 1\nBogoMIPS\t: 38.40\n\nprocessor\t: 2\nBogoMIPS\t: 38.40\n\nprocess" +
    "or\t: 3\nBogoMIPS\t: 38.40\n\nFeatures\t: swp half thumb fastmult vfp edsp neon " +
    "vfpv3 tls vfpv4 idiva idivt \nCPU implementer\t: 0x41\nCPU architecture: 7\nCPU " +
    "variant\t: 0x0\nCPU part\t: 0xc07\nCPU revision\t: 3\n\nHardware\t: Qualcomm MSM" +
    " 8226 (Flattened Device Tree)\nRevision\t: 0000\nSerial\t\t: 0000000000000000\n"
    , "dianxin"
            });
            insertLib(maps,new String[] {
                "MSM8226", "Coolpad", "Coolpad5892", "4.3.083.P2.140910.5892", "YuLong", "Coolpad 5892", "Coolpad5892", "", "JLS36C", "user", 
                "release-keys", "system9", "ubuntu", "qcom", "armeabi-v7a", "armeabi", "Coolpad/Coolpad5892/Coolpad5892:4.3/JLS36C/4.3.083.P2.140910.5892:user/release-k" +
    "eys"
    , "REL", "4.3.083.P2.140910.5892", "4.3", 
                "18", "18", "99000522", "854", "480", "1.5", "1.5", "240", "196.645", "197.196", 
                "8X25Q-QHOSKMLYM-3010", "3.4.0-g1e451e8-03880-gda98128-dirty", "Linux version 3.4.0-g1e451e8-03880-gda98128-dirty (system9@ubuntu) (gcc version " +
    "4.7 (GCC) ) #1 SMP PREEMPT Wed Sep 10 19:04:42 CST 2014\n"
    , "Processor\t: ARMv7 Processor rev 3 (v7l)\nprocessor\t: 0\nBogoMIPS\t: 38.40\n\np" +
    "rocessor\t: 1\nBogoMIPS\t: 38.40\n\nprocessor\t: 2\nBogoMIPS\t: 38.40\n\nprocess" +
    "or\t: 3\nBogoMIPS\t: 38.40\n\nFeatures\t: swp half thumb fastmult vfp edsp neon " +
    "vfpv3 tls vfpv4 idiva idivt \nCPU implementer\t: 0x41\nCPU architecture: 7\nCPU " +
    "variant\t: 0x0\nCPU part\t: 0xc07\nCPU revision\t: 3\n\nHardware\t: Qualcomm MSM" +
    " 8226 (Flattened Device Tree)\nRevision\t: 0000\nSerial\t\t: 0000000000000000\n"
    , "dianxin"
            });
            insertLib(maps,new String[] {
                "MSM8974", "samsung", "klte", "KOT49H.G9009WKEU1ANH8", "samsung", "SM-G9009W", "klteduosctc", "G9009WKEU1ANH8", "KOT49H", "user", 
                "release-keys", "dpi", "SWDD5508", "qcom", "armeabi-v7a", "armeabi", "samsung/klteduosctc/klte:4.4.2/KOT49H/G9009WKEU1ANH8:user/release-keys", "REL", "G9009WKEU1ANH8", "4.4.2", 
                "19", "19", "99000468", "1920", "1080", "3.0", "3.0", "480", "422.03", "424.069", 
                "G9009WKEU1ANH8", "3.4.0-1862277", "Linux version 3.4.0-1862277 (dpi@SWDD5812) (gcc version 4.7 (GCC) ) #1 SMP PREEM" +
    "PT Mon Aug 18 08:31:24 KST 2014\n"
    , "Processor\t: ARMv7 Processor rev 1 (v7l)\nprocessor\t: 0\nBogoMIPS\t: 38.40\n\np" +
    "rocessor\t: 1\nBogoMIPS\t: 38.40\n\nprocessor\t: 2\nBogoMIPS\t: 38.40\n\nprocess" +
    "or\t: 3\nBogoMIPS\t: 38.40\n\nFeatures\t: swp half thumb fastmult vfp edsp neon " +
    "vfpv3 tls vfpv4 idiva idivt \nCPU implementer\t: 0x51\nCPU architecture: 7\nCPU " +
    "variant\t: 0x2\nCPU part\t: 0x06f\nCPU revision\t: 1\n\nHardware\t: Qualcomm MSM" +
    " 8974 (Flattened Device Tree)\nRevision\t: 000a\nSerial\t\t: 0000f82f0000dc50\n"
    , "dianxin"
            });
            insertLib(maps,new String[] {
                "MSM8974", "samsung", "klte", "KOT49H.G9009WKEU1ANJ5", "samsung", "SM-G9009W", "klteduosctc", "G9009WKEU1ANJ5", "KOT49H", "user", 
                "release-keys", "dpi", "SWDD5812", "qcom", "armeabi-v7a", "armeabi", "samsung/klteduosctc/klte:4.4.2/KOT49H/G9009WKEU1ANJ5:user/release-keys", "REL", "G9009WKEU1ANJ5", "4.4.2", 
                "19", "19", "99000467", "1920", "1080", "3.0", "3.0", "480", "422.03", "424.069", 
                "G9009WKEU1ANJ5", "3.4.0-3010444", "Linux version 3.4.0-3010444 (dpi@SWDD5008) (gcc version 4.7 (GCC) ) #1 SMP PREEM" +
    "PT Wed Oct 29 12:21:38 KST 2014\n"
    , "Processor\t: ARMv7 Processor rev 1 (v7l)\nprocessor\t: 0\nBogoMIPS\t: 38.40\n\np" +
    "rocessor\t: 1\nBogoMIPS\t: 38.40\n\nprocessor\t: 2\nBogoMIPS\t: 38.40\n\nprocess" +
    "or\t: 3\nBogoMIPS\t: 38.40\n\nFeatures\t: swp half thumb fastmult vfp edsp neon " +
    "vfpv3 tls vfpv4 idiva idivt \nCPU implementer\t: 0x51\nCPU architecture: 7\nCPU " +
    "variant\t: 0x2\nCPU part\t: 0x06f\nCPU revision\t: 1\n\nHardware\t: Qualcomm MSM" +
    " 8974 (Flattened Device Tree)\nRevision\t: 000a\nSerial\t\t: 0000f4510000977c\n"
    , "dianxin"
            });
            insertLib(maps,new String[] {
                "MSM8974", "samsung", "klte", "KOT49H.G9009WKEU1ANH7", "samsung", "SM-G9009W", "klteduosctc", "G9009WKEU1ANH7", "KOT49H", "user", 
                "release-keys", "dpi", "SWDD5919", "qcom", "armeabi-v7a", "armeabi", "samsung/klteduosctc/klte:4.4.2/KOT49H/G9009WKEU1ANH7:user/release-keys", "REL", "G9009WKEU1ANH7", "4.4.2", 
                "19", "19", "99000467", "1920", "1080", "3.0", "3.0", "480", "422.03", "424.069", 
                "G9009WKEU1ANH7", "3.4.0-1862277", "Linux version 3.4.0-1862277 (dpi@SWDD5508) (gcc version 4.7 (GCC) ) #1 SMP PREEM" +
    "PT Fri Aug 15 13:25:36 KST 2014\n"
    , "Processor\t: ARMv7 Processor rev 1 (v7l)\nprocessor\t: 0\nBogoMIPS\t: 38.40\n\np" +
    "rocessor\t: 1\nBogoMIPS\t: 38.40\n\nprocessor\t: 2\nBogoMIPS\t: 38.40\n\nprocess" +
    "or\t: 3\nBogoMIPS\t: 38.40\n\nFeatures\t: swp half thumb fastmult vfp edsp neon " +
    "vfpv3 tls vfpv4 idiva idivt \nCPU implementer\t: 0x51\nCPU architecture: 7\nCPU " +
    "variant\t: 0x2\nCPU part\t: 0x06f\nCPU revision\t: 1\n\nHardware\t: Qualcomm MSM" +
    " 8974 (Flattened Device Tree)\nRevision\t: 000a\nSerial\t\t: 00001e1600009801\n"
    , "dianxin"
            });
            insertLib(maps,new String[] {
                "7x27", "Coolpad", "Coolpad5951", "4.1.057.P2.140702.5951", "YuLong", "Coolpad 5951", "Coolpad5951", "", "JZO54K", "user", 
                "release-keys", "mine", "mine", "qcom", "armeabi-v7a", "armeabi", "Coolpad/Coolpad5951/Coolpad5951:4.1.2/JZO54K/4.1.057.P2.140702.5951:user/release" +
    "-keys"
    , "REL", "4.1.057.P2.140702.5951", "4.1.2", 
                "16", "16", "99000459", "720", "1280", "3.0", "2.0", "320", "268.94116", "270.93332", 
                "8X25Q-QHOSKMLYM-3010", "3.4.0-perf", "Linux version 3.4.0-perf (mine@mine) (gcc version 4.6.x-google 20120106 (prerele" +
    "ase) (GCC) ) #1 SMP PREEMPT Wed Jul 2 10:38:11 CST 2014\n"
    , "Processor\t: ARMv7 Processor rev 1 (v7l)\nprocessor\t: 0\nBogoMIPS\t: 501.64\n\n" +
    "processor\t: 1\nBogoMIPS\t: 501.64\n\nprocessor\t: 2\nBogoMIPS\t: 298.59\n\nproc" +
    "essor\t: 3\nBogoMIPS\t: 298.59\n\nFeatures\t: swp half thumb fastmult vfp edsp t" +
    "humbee neon vfpv3 tls vfpv4 \nCPU implementer\t: 0x41\nCPU architecture: 7\nCPU " +
    "variant\t: 0x0\nCPU part\t: 0xc05\nCPU revision\t: 1\n\nHardware\t: QRD MSM8625Q" +
    " SKUE\nRevision\t: 0000\nSerial\t\t: 0000000000000000\n"
    , "dianxin"
            });
            insertLib(maps,new String[] {
                "7x27", "Coolpad", "Coolpad5951", "4.1.057.P2.140702.5951", "YuLong", "Coolpad 5951", "Coolpad5951", "", "JZO54K", "user", 
                "release-keys", "mine", "mine", "qcom", "armeabi-v7a", "armeabi", "Coolpad/Coolpad5951/Coolpad5951:4.1.2/JZO54K/4.1.057.P2.140702.5951:user/release" +
    "-keys"
    , "REL", "4.1.057.P2.140702.5951", "4.1.2", 
                "16", "16", "99000458", "1280", "720", "2.3", "2.0", "320", "268.94116", "270.93332", 
                "8X25Q-QHOSKMLYM-3010", "3.4.0-perf", "Linux version 3.4.0-perf (mine@mine) (gcc version 4.6.x-google 20120106 (prerele" +
    "ase) (GCC) ) #1 SMP PREEMPT Wed Jul 2 10:38:11 CST 2014\n"
    , "Processor\t: ARMv7 Processor rev 1 (v7l)\nprocessor\t: 0\nBogoMIPS\t: 601.97\n\n" +
    "processor\t: 1\nBogoMIPS\t: 298.59\n\nprocessor\t: 2\nBogoMIPS\t: 298.59\n\nproc" +
    "essor\t: 3\nBogoMIPS\t: 298.59\n\nFeatures\t: swp half thumb fastmult vfp edsp t" +
    "humbee neon vfpv3 tls vfpv4 \nCPU implementer\t: 0x41\nCPU architecture: 7\nCPU " +
    "variant\t: 0x0\nCPU part\t: 0xc05\nCPU revision\t: 1\n\nHardware\t: QRD MSM8625Q" +
    " SKUE\nRevision\t: 0000\nSerial\t\t: 0000000000000000\n"
    , "dianxin"
            });
            insertLib(maps,new String[] {
                "7x27", "Coolpad", "Coolpad5950", "4.1.042.P0.131127.5950", "YuLong", "Coolpad 5950", "Coolpad5950", "", "JZO54K", "user", 
                "release-keys", "mine", "mine", "qcom", "armeabi-v7a", "armeabi", "Coolpad/Coolpad5950/Coolpad5950:4.1.2/JZO54K/4.1.042.P0.131127.5950:user/release" +
    "-keys"
    , "REL", "4.1.042.P0.131127.5950", "4.1.2", 
                "16", "16", "99000457", "960", "540", "1.7249999", "1.5", "240", "201.70589", "201.52066", 
                "8X25Q-QHOSKMLYM-3010", "3.4.0-perf", "Linux version 3.4.0-perf (mine@mine) (gcc version 4.6.x-google 20120106 (prerele" +
    "ase) (GCC) ) #1 SMP PREEMPT Wed Nov 27 19:19:29 CST 2013\n"
    , "Processor\t: ARMv7 Processor rev 1 (v7l)\nprocessor\t: 0\nBogoMIPS\t: 601.97\n\n" +
    "processor\t: 1\nBogoMIPS\t: 601.97\n\nprocessor\t: 2\nBogoMIPS\t: 601.97\n\nproc" +
    "essor\t: 3\nBogoMIPS\t: 601.97\n\nFeatures\t: swp half thumb fastmult vfp edsp t" +
    "humbee neon vfpv3 tls vfpv4 \nCPU implementer\t: 0x41\nCPU architecture: 7\nCPU " +
    "variant\t: 0x0\nCPU part\t: 0xc05\nCPU revision\t: 1\n\nHardware\t: QRD MSM8625Q" +
    " SKUE\nRevision\t: 0000\nSerial\t\t: 0000000000000000\n"
    , "dianxin"
            });
            insertLib(maps,new String[] {
                "7x27", "Coolpad", "Coolpad5891", "4.1.044.P1.131021.5891", "YuLong", "Coolpad 5891", "Coolpad5891", "", "JZO54K", "user", 
                "release-keys", "mine", "mine", "qcom", "armeabi-v7a", "armeabi", "Coolpad/Coolpad5891/Coolpad5891:4.1.2/JZO54K/4.1.044.P1.131021.5891:user/release" +
    "-keys"
    , "REL", "4.1.044.P1.131021.5891", "4.1.2", 
                "16", "16", "99000456", "960", "540", "1.5", "1.5", "240", "221.2258", "221.67273", 
                "8X25Q-QHOSKMLYM-3010", "3.4.0-perf", "Linux version 3.4.0-perf (mine@mine) (gcc version 4.6.x-google 20120106 (prerele" +
    "ase) (GCC) ) #1 SMP PREEMPT Mon Oct 21 13:41:00 CST 2013\n"
    , "Processor\t: ARMv7 Processor rev 1 (v7l)\nprocessor\t: 0\nBogoMIPS\t: 503.70\n\n" +
    "processor\t: 1\nBogoMIPS\t: 503.70\n\nprocessor\t: 2\nBogoMIPS\t: 503.70\n\nproc" +
    "essor\t: 3\nBogoMIPS\t: 503.70\n\nFeatures\t: swp half thumb fastmult vfp edsp t" +
    "humbee neon vfpv3 tls vfpv4 \nCPU implementer\t: 0x41\nCPU architecture: 7\nCPU " +
    "variant\t: 0x0\nCPU part\t: 0xc05\nCPU revision\t: 1\n\nHardware\t: QRD MSM8625Q" +
    " SKUE\nRevision\t: 0000\nSerial\t\t: 0000000000000000\n"
    , "dianxin"
            });
            insertLib(maps,new String[] {
                "7x27", "Coolpad", "Coolpad5891", "4.1.044.P1.131021.5891", "YuLong", "Coolpad 5891", "Coolpad5891", "", "JZO54K", "user", 
                "release-keys", "mine", "mine", "qcom", "armeabi-v7a", "armeabi", "Coolpad/Coolpad5891/Coolpad5891:4.1.2/JZO54K/4.1.044.P1.131021.5891:user/release" +
    "-keys"
    , "REL", "4.1.044.P1.131021.5891", "4.1.2", 
                "16", "16", "99000456", "960", "540", "1.7249999", "1.5", "240", "221.2258", "221.67273", 
                "8X25Q-QHOSKMLYM-3010", "3.4.0-perf", "", "Processor\t: ARMv7 Processor rev 1 (v7l)\nprocessor\t: 0\nBogoMIPS\t: 601.97\n\n" +
    "processor\t: 1\nBogoMIPS\t: 601.97\n\nprocessor\t: 2\nBogoMIPS\t: 601.97\n\nproc" +
    "essor\t: 3\nBogoMIPS\t: 601.97\n\nFeatures\t: swp half thumb fastmult vfp edsp t" +
    "humbee neon vfpv3 tls vfpv4 \nCPU implementer\t: 0x41\nCPU architecture: 7\nCPU " +
    "variant\t: 0x0\nCPU part\t: 0xc05\nCPU revision\t: 1\n\nHardware\t: QRD MSM8625Q" +
    " SKUE\nRevision\t: 0000\nSerial\t\t: 0000000000000000\n"
    , "dianxin"
            });
            insertLib(maps,new String[] {
                "7x27", "Coolpad", "Coolpad5950", "4.1.041.P0.131107.5950", "YuLong", "Coolpad 5950", "Coolpad5950", "", "JZO54K", "user", 
                "release-keys", "mine", "mine", "qcom", "armeabi-v7a", "armeabi", "Coolpad/Coolpad5950/Coolpad5950:4.1.2/JZO54K/4.1.041.P0.131107.5950:user/release" +
    "-keys"
    , "REL", "4.1.041.P0.131107.5950", "4.1.2", 
                "16", "16", "99000455", "960", "540", "1.5", "1.5", "240", "201.70589", "201.52066", 
                "8X25Q-QHOSKMLYM-3010", "3.4.0-perf", "Linux version 3.4.0-perf (mine@mine) (gcc version 4.6.x-google 20120106 (prerele" +
    "ase) (GCC) ) #1 SMP PREEMPT Thu Nov 7 21:47:57 CST 2013\n"
    , "Processor\t: ARMv7 Processor rev 1 (v7l)\nprocessor\t: 0\nBogoMIPS\t: 501.64\n\n" +
    "processor\t: 1\nBogoMIPS\t: 501.64\n\nprocessor\t: 2\nBogoMIPS\t: 501.64\n\nproc" +
    "essor\t: 3\nBogoMIPS\t: 298.59\n\nFeatures\t: swp half thumb fastmult vfp edsp t" +
    "humbee neon vfpv3 tls vfpv4 \nCPU implementer\t: 0x41\nCPU architecture: 7\nCPU " +
    "variant\t: 0x0\nCPU part\t: 0xc05\nCPU revision\t: 1\n\nHardware\t: QRD MSM8625Q" +
    " SKUE\nRevision\t: 0000\nSerial\t\t: 0000000000000000\n"
    , "dianxin"
            });
            insertLib(maps,new String[] {
                "7x27", "Coolpad", "Coolpad5950", "4.1.042.P0.131127.5950", "YuLong", "Coolpad 5950", "Coolpad5950", "", "JZO54K", "user", 
                "release-keys", "mine", "mine", "qcom", "armeabi-v7a", "armeabi", "Coolpad/Coolpad5950/Coolpad5950:4.1.2/JZO54K/4.1.042.P0.131127.5950:user/release" +
    "-keys"
    , "REL", "4.1.042.P0.131127.5950", "4.1.2", 
                "16", "16", "99000455", "960", "540", "1.5", "1.5", "240", "201.70589", "201.52066", 
                "8X25Q-QHOSKMLYM-3010", "3.4.0-perf", "Linux version 3.4.0-perf (mine@mine) (gcc version 4.6.x-google 20120106 (prerele" +
    "ase) (GCC) ) #1 SMP PREEMPT Wed Nov 27 19:19:29 CST 2013\n"
    , "Processor\t: ARMv7 Processor rev 1 (v7l)\nprocessor\t: 0\nBogoMIPS\t: 601.97\n\n" +
    "processor\t: 1\nBogoMIPS\t: 601.97\n\nprocessor\t: 2\nBogoMIPS\t: 298.59\n\nproc" +
    "essor\t: 3\nBogoMIPS\t: 298.59\n\nFeatures\t: swp half thumb fastmult vfp edsp t" +
    "humbee neon vfpv3 tls vfpv4 \nCPU implementer\t: 0x41\nCPU architecture: 7\nCPU " +
    "variant\t: 0x0\nCPU part\t: 0xc05\nCPU revision\t: 1\n\nHardware\t: QRD MSM8625Q" +
    " SKUE\nRevision\t: 0000\nSerial\t\t: 0000000000000000\n"
    , "dianxin"
            });
            insertLib(maps,new String[] {
                "7x27", "Coolpad", "Coolpad5950", "4.1.042.P0.131127.5950", "YuLong", "Coolpad 5950", "Coolpad5950", "", "JZO54K", "user", 
                "release-keys", "mine", "mine", "qcom", "armeabi-v7a", "armeabi", "Coolpad/Coolpad5950/Coolpad5950:4.1.2/JZO54K/4.1.042.P0.131127.5950:user/release" +
    "-keys"
    , "REL", "4.1.042.P0.131127.5950", "4.1.2", 
                "16", "16", "99000455", "960", "540", "1.9499999", "1.5", "240", "201.70589", "201.52066", 
                "8X25Q-QHOSKMLYM-3010", "3.4.0-perf", "Linux version 3.4.0-perf (mine@mine) (gcc version 4.6.x-google 20120106 (prerele" +
    "ase) (GCC) ) #1 SMP PREEMPT Wed Nov 27 19:19:29 CST 2013\n"
    , "Processor\t: ARMv7 Processor rev 1 (v7l)\nprocessor\t: 0\nBogoMIPS\t: 601.97\n\n" +
    "processor\t: 1\nBogoMIPS\t: 601.97\n\nprocessor\t: 2\nBogoMIPS\t: 601.97\n\nproc" +
    "essor\t: 3\nBogoMIPS\t: 601.97\n\nFeatures\t: swp half thumb fastmult vfp edsp t" +
    "humbee neon vfpv3 tls vfpv4 \nCPU implementer\t: 0x41\nCPU architecture: 7\nCPU " +
    "variant\t: 0x0\nCPU part\t: 0xc05\nCPU revision\t: 1\n\nHardware\t: QRD MSM8625Q" +
    " SKUE\nRevision\t: 0000\nSerial\t\t: 0000000000000000\n"
    , "dianxin"
            });
            insertLib(maps,new String[] {
                "7x27", "Coolpad", "Coolpad5950", "4.1.042.P0.131127.5950", "YuLong", "Coolpad 5950", "Coolpad5950", "", "JZO54K", "user", 
                "release-keys", "mine", "mine", "qcom", "armeabi-v7a", "armeabi", "Coolpad/Coolpad5950/Coolpad5950:4.1.2/JZO54K/4.1.042.P0.131127.5950:user/release" +
    "-keys"
    , "REL", "4.1.042.P0.131127.5950", "4.1.2", 
                "16", "16", "99000455", "960", "540", "1.9499999", "1.5", "240", "201.70589", "201.52066", 
                "8X25Q-QHOSKMLYM-3010", "3.4.0-perf", "Linux version 3.4.0-perf (mine@mine) (gcc version 4.6.x-google 20120106 (prerele" +
    "ase) (GCC) ) #1 SMP PREEMPT Wed Nov 27 19:19:29 CST 2013\n"
    , "Processor\t: ARMv7 Processor rev 1 (v7l)\nprocessor\t: 0\nBogoMIPS\t: 601.97\n\n" +
    "processor\t: 1\nBogoMIPS\t: 298.59\n\nprocessor\t: 2\nBogoMIPS\t: 298.59\n\nproc" +
    "essor\t: 3\nBogoMIPS\t: 298.59\n\nFeatures\t: swp half thumb fastmult vfp edsp t" +
    "humbee neon vfpv3 tls vfpv4 \nCPU implementer\t: 0x41\nCPU architecture: 7\nCPU " +
    "variant\t: 0x0\nCPU part\t: 0xc05\nCPU revision\t: 1\n\nHardware\t: QRD MSM8625Q" +
    " SKUE\nRevision\t: 0000\nSerial\t\t: 0000000000000000\n"
    , "dianxin"
            });
            insertLib(maps,new String[] {
                "7x27", "Coolpad", "Coolpad9150", "4.1.055.P1.130806.9150", "YuLong", "Coolpad 9150", "Coolpad9150", "", "JZO54K", "user", 
                "release-keys", "mine", "mine", "qcom", "armeabi-v7a", "armeabi", "Coolpad/Coolpad9150/Coolpad9150:4.1.2/JZO54K/4.1.055.P1.130806.9150:user/release" +
    "-keys"
    , "REL", "4.1.055.P1.130806.9150", "4.1.2", 
                "16", "16", "99000315", "960", "540", "1.7249999", "1.5", "240", "249.38182", "246.30302", 
                "8X25Q-QHOSKMLYM-3010", "3.4.0-perf", "Linux version 3.4.0-perf (mine@mine) (gcc version 4.6.x-google 20120106 (prerele" +
    "ase) (GCC) ) #1 SMP PREEMPT Tue Aug 6 09:57:37 CST 2013\n"
    , "Processor\t: ARMv7 Processor rev 1 (v7l)\nprocessor\t: 0\nBogoMIPS\t: 601.97\n\n" +
    "processor\t: 1\nBogoMIPS\t: 601.97\n\nprocessor\t: 2\nBogoMIPS\t: 601.97\n\nproc" +
    "essor\t: 3\nBogoMIPS\t: 601.97\n\nFeatures\t: swp half thumb fastmult vfp edsp t" +
    "humbee neon vfpv3 tls vfpv4 \nCPU implementer\t: 0x41\nCPU architecture: 7\nCPU " +
    "variant\t: 0x0\nCPU part\t: 0xc05\nCPU revision\t: 1\n\nHardware\t: QRD MSM8625Q" +
    " SKUE\nRevision\t: 0000\nSerial\t\t: 0000000000000000\n"
    , "dianxin"
            });
            insertLib(maps,new String[] {
                "7x27", "Coolpad", "Coolpad5890", "4.1.056.P0.130619.5890", "YuLong", "Coolpad 5890", "Coolpad5890", "", "JZO54K", "user", 
                "release-keys", "mine", "mine", "qcom", "armeabi-v7a", "armeabi", "Coolpad/Coolpad5890/Coolpad5890:4.1.2/JZO54K/4.1.056.P0.130619.5890:user/release" +
    "-keys"
    , "REL", "4.1.056.P0.130619.5890", "4.1.2", 
                "16", "16", "99000315", "960", "540", "1.7249999", "1.5", "240", "159.48837", "160.42105", 
                "8X25Q-QHOSKMLYM-3010", "3.4.0-perf", "", "Processor\t: ARMv7 Processor rev 1 (v7l)\nprocessor\t: 0\nBogoMIPS\t: 601.97\n\n" +
    "processor\t: 1\nBogoMIPS\t: 601.97\n\nprocessor\t: 2\nBogoMIPS\t: 601.97\n\nproc" +
    "essor\t: 3\nBogoMIPS\t: 298.59\n\nFeatures\t: swp half thumb fastmult vfp edsp t" +
    "humbee neon vfpv3 tls vfpv4 \nCPU implementer\t: 0x41\nCPU architecture: 7\nCPU " +
    "variant\t: 0x0\nCPU part\t: 0xc05\nCPU revision\t: 1\n\nHardware\t: QRD MSM8625Q" +
    " SKUE\nRevision\t: 0000\nSerial\t\t: 0000000000000000\n"
    , "dianxin"
            });
            insertLib(maps,new String[] {
                "7x27", "Coolpad", "Coolpad5891Q", "4.1.026.P0.140708.5891Q", "YuLong", "Coolpad 5891Q", "Coolpad5891Q", "", "JZO54K", "user", 
                "release-keys", "mine", "mine", "qcom", "armeabi-v7a", "armeabi", "Coolpad/Coolpad5891Q/Coolpad5891Q:4.1.2/JZO54K/4.1.026.P0.140708.5891Q:user/rele" +
    "ase-keys"
    , "REL", "4.1.026.P0.140708.5891Q", "4.1.2", 
                "16", "16", "99000314", "960", "540", "1.7249999", "1.5", "240", "201.70589", "201.52066", 
                "8X25Q-QHOSKMLYM-3010", "3.4.0-perf", "Linux version 3.4.0-perf (mine@mine) (gcc version 4.6.x-google 20120106 (prerele" +
    "ase) (GCC) ) #1 SMP PREEMPT Wed Jul 9 00:02:24 CST 2014\n"
    , "Processor\t: ARMv7 Processor rev 1 (v7l)\nprocessor\t: 0\nBogoMIPS\t: 501.64\n\n" +
    "processor\t: 1\nBogoMIPS\t: 501.64\n\nprocessor\t: 2\nBogoMIPS\t: 501.64\n\nproc" +
    "essor\t: 3\nBogoMIPS\t: 501.64\n\nFeatures\t: swp half thumb fastmult vfp edsp t" +
    "humbee neon vfpv3 tls vfpv4 \nCPU implementer\t: 0x41\nCPU architecture: 7\nCPU " +
    "variant\t: 0x0\nCPU part\t: 0xc05\nCPU revision\t: 1\n\nHardware\t: QRD MSM8625Q" +
    " SKUE\nRevision\t: 0000\nSerial\t\t: 0000000000000000\n"
    , "dianxin"
            });
            insertLib(maps,new String[] {
                "", "KDDI", "m7wlj", "JDQ39", "HTC", "HTL22", "m7_jp_kdi", "1.52.0000", "JDQ39", "user", 
                "release-keys", "", "abm014", "m7wlj", "armeabi-v7a", "armeabi", "KDDI/m7_jp_kdi/m7wlj:4.2.2/JDQ39/244097.1:user/release-keys", "REL", "244097.1", "4.2.2", 
                "17", "17", "99000291", "1920", "1080", "2.5500002", "3.0", "480", "472.965", "473.475", 
                "1.23.11.0510", "3.4.10-gd8fb1da", "Linux version 3.4.10-gd8fb1da (root@abm014) (gcc version 4.6.x-google 20120106 (" +
    "prerelease) (GCC) ) #1 SMP PREEMPT Thu Aug 29 17:53:32 CST 2013\n"
    , "Processor\t: ARMv7 Processor rev 0 (v7l)\nprocessor\t: 0\nBogoMIPS\t: 13.52\n\np" +
    "rocessor\t: 1\nBogoMIPS\t: 13.52\n\nprocessor\t: 2\nBogoMIPS\t: 13.52\n\nprocess" +
    "or\t: 3\nBogoMIPS\t: 13.52\n\nFeatures\t: swp half thumb fastmult vfp edsp thumb" +
    "ee neon vfpv3 tls vfpv4 \nCPU implementer\t: 0x51\nCPU architecture: 7\nCPU vari" +
    "ant\t: 0x1\nCPU part\t: 0x06f\nCPU revision\t: 0\n\nHardware\t: \nRevision\t: 00" +
    "03\nSerial\t\t: 0000000000000000\n"
    , "dianxin"
            });
            insertLib(maps,new String[] {
                "7x27", "Coolpad", "msm7627a_5860S", "4.0.057.P1.131012.5860S", "YuLong", "5860S", "5860S", "", "IMM76I", "user", 
                "release-keys", "mine", "mine", "qcom", "armeabi-v7a", "armeabi", "Coolpad/5860S/msm7627a_5860S:4.0.4/IMM76I/4.0.058.T0.131014.5860S:user/release-k" +
    "eys"
    , "REL", "4.0.058.T0.131014.5860S", "4.0.4", 
                "15", "15", "99000217", "800", "480", "1.5", "1.5", "240", "160.42105", "160", 
                "MOLY.WR8.W1301.MD.TG.MP.V4.P8, 2013/11/26 11:47", "3.0.21-perf", "Linux version 3.0.21-perf (mine@mine) (gcc version 4.4.3 (GCC) ) #1 SMP PREEMPT " +
    "Mon Oct 14 21:04:12 CST 2013\n"
    , "Processor\t: ARMv7 Processor rev 1 (v7l)\nprocessor\t: 0\nBogoMIPS\t: 501.64\n\n" +
    "processor\t: 1\nBogoMIPS\t: 501.64\n\nFeatures\t: swp half thumb fastmult vfp ed" +
    "sp thumbee neon vfpv3 tls vfpv4 \nCPU implementer\t: 0x41\nCPU architecture: 7\n" +
    "CPU variant\t: 0x0\nCPU part\t: 0xc05\nCPU revision\t: 1\n\nHardware\t: QRD MSM8" +
    "625 SKU5\nRevision\t: 0000\nSerial\t\t: 0000000000000000\n"
    , "dianxin"
            });


            insertLib(maps,new String[] {
                "lc1810", "K-Touch", "lc1810", "920610_8670_V0219", "K-Touch", "K-Touch T789", "full_lc1810", "", "IML74K", "user", 
                "dev-keys", "ccadmin", "BUILD12", "leadcoreinnopower", "armeabi-v7a", "armeabi", "K-Touch/full_lc1810/lc1810:4.0.3/IML74K/920610_8670_V0219:user/dev-keys", "REL", "920610_8670_V0219", "4.0.3", 
                "15", "15", "86968301", "800", "480", "1.5", "1.5", "240", "160.42105", "160", 
                "LM_1.40.00.P05.R07", "3.0.8", "Linux version 3.0.8 (ccadmin@BUILD12) (gcc version 4.4.3 (GCC) ) #1 SMP PREEMPT " +
    "Mon Jun 24 12:32:50 CST 2013\n"
    , "Processor\t: ARMv7 Processor rev 0 (v7l)\nprocessor\t: 0\nBogoMIPS\t: 1967.71\n\n" +
    "processor\t: 1\nBogoMIPS\t: 246.98\n\nFeatures\t: swp half thumb fastmult vfp ed" +
    "sp neon vfpv3 \nCPU implementer\t: 0x41\nCPU architecture: 7\nCPU variant\t: 0x3" +
    "\nCPU part\t: 0xc09\nCPU revision\t: 0\n\nHardware\t: Leadcore Innopower\nRevisi" +
    "on\t: 0000\nSerial\t\t: 0000000000000000\n"
    , "yidong"
            });
            insertLib(maps,new String[] {
                "P117A20", "ZTE", "P117A20", "U817", "ZTE", "ZTE U817", "P117A20", "", "IMM76D", "user", 
                "release-keys", "root", "SWT230", "mt6577", "armeabi-v7a", "armeabi", "ZTE/P117A20/P117A20:4.0.4/IMM76D/eng.root.20130517.140951:user/release-keys", "REL", "eng.root.20130517.140951", "4.0.4", 
                "15", "15", "86958501", "804", "480", "1.5", "1.5", "240", "240", "240", 
                "MAUI.11AMD.W12.36.SP.V3.F4, 2013/03/12 11:41", "3.0.13", "Linux version 3.0.13 (root@SWT211) (gcc version 4.4.3 (GCC) ) #1 SMP PREEMPT Thu" +
    " May 16 10:13:43 CST 2013\n"
    , "Processor\t: ARMv7 Processor rev 0 (v7l)\nprocessor\t: 0\nBogoMIPS\t: 1993.93\n\n" +
    "processor\t: 1\nBogoMIPS\t: 2000.48\n\nFeatures\t: swp half thumb fastmult vfp e" +
    "dsp thumbee neon vfpv3 \nCPU implementer\t: 0x41\nCPU architecture: 7\nCPU varia" +
    "nt\t: 0x3\nCPU part\t: 0xc09\nCPU revision\t: 0\n\nHardware\t: MT6577\nRevision\t" +
    ": 65fb8a00\nSerial\t\t: 0000000000000000\n"
    , "yidong"
            });
            insertLib(maps,new String[] {
                "P117A11", "ZTE", "P117A11", "U807V1.0.0B03", "ZTE", "ZTE U807", "P117A11", "", "IMM76D", "user", 
                "release-keys", "root", "SWT222", "mt6577", "armeabi-v7a", "armeabi", "ZTE/P117A11/P117A11:4.0.4/IMM76D/eng.root.20130122.185304:user/release-keys", "REL", "eng.root.20130122.185304", "4.0.4", 
                "15", "15", "86939401", "800", "480", "1.5", "1.5", "240", "240", "240", 
                "MAUI.11AMD.W12.36.SP.V3.F1.P22, 2013/01/14 13:43", "3.0.13", "", "Processor\t: ARMv7 Processor rev 0 (v7l)\nprocessor\t: 0\nBogoMIPS\t: 1993.93\n\n" +
    "processor\t: 1\nBogoMIPS\t: 2000.48\n\nFeatures\t: swp half thumb fastmult vfp e" +
    "dsp thumbee neon vfpv3 \nCPU implementer\t: 0x41\nCPU architecture: 7\nCPU varia" +
    "nt\t: 0x3\nCPU part\t: 0xc09\nCPU revision\t: 0\n\nHardware\t: MT6577\nRevision\t" +
    ": 65fb8a00\nSerial\t\t: 0000000000000000\n"
    , "yidong"
            });
            insertLib(maps,new String[] {
                "lc1810", "Coolpad", "lc1810_8720", "4.0.026.T2.8720", "YuLong", "8720", "full_lc1810", "", "IML74K", "user", 
                "release-keys", "mine", "mine", "leadcore1811", "armeabi-v7a", "armeabi", "Coolpad/full_lc1810/lc1810_8720:4.0.3/IML74K/4.0.062.T2.131024.8720:user/release" +
    "-keys"
    , "REL", "4.0.062.T2.131024.8720", "4.0.3", 
                "15", "15", "86881401", "1280", "720", "2.3", "2.0", "320", "160.42105", "160.15764", 
                "MOLY.WR8.W1301.MD.TG.MP.V4.P8, 2013/11/26 11:47", "3.0.8", "Linux version 3.0.8 (mine@mine) (gcc version 4.4.3 (GCC) ) #3 SMP PREEMPT Thu Oc" +
    "t 24 01:20:42 CST 2013\n"
    , "Processor\t: ARMv7 Processor rev 0 (v7l)\nprocessor\t: 0\nBogoMIPS\t: 2380.59\n\n" +
    "processor\t: 1\nBogoMIPS\t: 298.59\n\nFeatures\t: swp half thumb fastmult vfp ed" +
    "sp neon vfpv3 \nCPU implementer\t: 0x41\nCPU architecture: 7\nCPU variant\t: 0x3" +
    "\nCPU part\t: 0xc09\nCPU revision\t: 0\n\nHardware\t: Leadcore 1811\nRevision\t:" +
    " 0000\nSerial\t\t: 0000000000000000\n"
    , "yidong"
            });
            insertLib(maps,new String[] {
                "yulong89_cu_jb", "Coolpad", "yulong89_cu_jb", "4.1.049.P3.131102.7295", "Coolpad", "Coolpad7295", "yulong89_cu_jb", "", "JZO54K", "user", 
                "release-keys", "mine", "mine", "mt6589", "armeabi-v7a", "armeabi", "Coolpad/yulong89_cu_jb/yulong89_cu_jb:4.1.2/JZO54K/4.1.049.P3.131102.7295:user/r" +
    "elease-keys"
    , "REL", "4.1.049.P3.131102.7295", "4.1.2", 
                "16", "16", "86877201", "960", "540", "1.7249999", "1.5", "240", "240", "240", 
                "MOLY.WR8.W1248.MD.WG.MP.V1, 2013/11/02 10:05", "3.4.5", "Linux version 3.4.5 (mine@mine) (gcc version 4.6.x-google 20120106 (prerelease) " +
    "(GCC) ) #1 SMP PREEMPT Sat Nov 2 10:07:42 CST 2013\n"
    , "Processor\t: ARMv7 Processor rev 2 (v7l)\nprocessor\t: 0\nBogoMIPS\t: 2439.94\n\n" +
    "processor\t: 1\nBogoMIPS\t: 2447.96\n\nFeatures\t: swp half thumb fastmult vfp e" +
    "dsp thumbee neon vfpv3 tls vfpv4 idiva idivt \nCPU implementer\t: 0x41\nCPU arch" +
    "itecture: 7\nCPU variant\t: 0x0\nCPU part\t: 0xc07\nCPU revision\t: 2\n\nHardwar" +
    "e\t: MT6589\nRevision\t: 0000\nSerial\t\t: 0000000000000000\n"
    , "yidong"
            });
            insertLib(maps,new String[] {
                "yulong89_cu_jb", "Coolpad", "yulong89_cu_jb", "4.1.049.P3.131102.7295", "Coolpad", "Coolpad7295", "yulong89_cu_jb", "", "JZO54K", "user", 
                "release-keys", "mine", "mine", "mt6589", "armeabi-v7a", "armeabi", "Coolpad/yulong89_cu_jb/yulong89_cu_jb:4.1.2/JZO54K/4.1.049.P3.131102.7295:user/r" +
    "elease-keys"
    , "REL", "4.1.049.P3.131102.7295", "4.1.2", 
                "16", "16", "86877201", "960", "540", "1.5", "1.5", "240", "240", "240", 
                "MOLY.WR8.W1248.MD.WG.MP.V1, 2013/11/02 10:05", "3.4.5", "Linux version 3.4.5 (mine@mine) (gcc version 4.6.x-google 20120106 (prerelease) " +
    "(GCC) ) #1 SMP PREEMPT Sat Nov 2 10:07:42 CST 2013\n"
    , "Processor\t: ARMv7 Processor rev 2 (v7l)\nprocessor\t: 0\nBogoMIPS\t: 2439.94\n\n" +
    "processor\t: 1\nBogoMIPS\t: 2000.48\n\nFeatures\t: swp half thumb fastmult vfp e" +
    "dsp thumbee neon vfpv3 tls vfpv4 idiva idivt \nCPU implementer\t: 0x41\nCPU arch" +
    "itecture: 7\nCPU variant\t: 0x0\nCPU part\t: 0xc07\nCPU revision\t: 2\n\nHardwar" +
    "e\t: MT6589\nRevision\t: 0000\nSerial\t\t: 0000000000000000\n"
    , "liantong"
            });
            insertLib(maps,new String[] {
                "P172T24", "ZTE", "P172T24", "Q201TV1.0.0B03", "ZTE", "ZTE Q201T", "P172T24", "", "JDQ39", "user", 
                "release-keys", "fengsong", "softser306", "mt6572", "armeabi-v7a", "armeabi", "ZTE/P172T24/P172T24:4.2.2/JDQ39/20140308.132028:user/release-keys", "REL", "P172T24V1.0.0B10", "4.2.2", 
                "17", "17", "86870200", "854", "480", "1.5", "1.5", "240", "160.42105", "159.49706", 
                "MOLY.WR8.W1319.MD.TG.MP.V4.P19, 2013/12/27 17:26", "3.4.5", "Linux version 3.4.5 (wind-kernel@droid) (gcc version 4.6.x-google 20120106 (prer" +
    "elease) (GCC) ) #1 SMP PREEMPT Sat Mar 8 13:19:58 CST 2014\n"
    , "Processor\t: ARMv7 Processor rev 3 (v7l)\nprocessor\t: 0\nBogoMIPS\t: 2589.52\n\n" +
    "processor\t: 1\nBogoMIPS\t: 2589.52\n\nFeatures\t: swp half thumb fastmult vfp e" +
    "dsp thumbee neon vfpv3 tls vfpv4 idiva idivt \nCPU implementer\t: 0x41\nCPU arch" +
    "itecture: 7\nCPU variant\t: 0x0\nCPU part\t: 0xc07\nCPU revision\t: 3\n\nHardwar" +
    "e\t: MT6572\nRevision\t: 0000\nSerial\t\t: 0000000000000000\n"
    , "yidong"
            });
            insertLib(maps,new String[] {
                "techain72_t_lca", "DESAY", "DESAY TS1018", "DESAY_TS1018_yidong_V2.0", "DESAY", "DESAY TS1018", "DESAY TS1018", "", "JDQ39", "user", 
                "test-keys", "lw", "sw166-desktop", "mt6572", "armeabi-v7a", "armeabi", "alps/techain72_t_lca/techain72_t_lca:4.2.2/JDQ39/1382351062:user/test-keys", "REL", "eng.lw.1382351062", "4.2.2", 
                "17", "17", "86866201", "800", "480", "1.5", "1.5", "240", "160.42105", "160", 
                "MOLY.WR8.W1319.MD.TG.MP.V4.P33, 2013/10/09 13:59", "3.4.5", "Linux version 3.4.5 (lw@sw166-desktop) (gcc version 4.6.x-google 20120106 (prere" +
    "lease) (GCC) ) #1 SMP PREEMPT Mon Oct 21 18:24:04 CST 2013\n"
    , "Processor\t: ARMv7 Processor rev 3 (v7l)\nprocessor\t: 0\nBogoMIPS\t: 2589.52\n\n" +
    "processor\t: 1\nBogoMIPS\t: 2589.52\n\nFeatures\t: swp half thumb fastmult vfp e" +
    "dsp thumbee neon vfpv3 tls vfpv4 idiva idivt \nCPU implementer\t: 0x41\nCPU arch" +
    "itecture: 7\nCPU variant\t: 0x0\nCPU part\t: 0xc07\nCPU revision\t: 3\n\nHardwar" +
    "e\t: MT6572\nRevision\t: 0000\nSerial\t\t: 0000000000000000\n"
    , "yidong"
            });
            insertLib(maps,new String[] {
                "P188T10", "ZTE", "P188T10", "U956V1.0.0B04", "alps", "ZTE U956", "P188T10", "", "JZO54K", "user", 
                "release-keys", "root", "SWT192", "mt6589", "armeabi-v7a", "armeabi", "ZTE/P188T10/P188T10:4.1.2/JZO54K/eng.root.20130613.175210:user/release-keys", "REL", "eng.root.20130613.175210", "4.1.2", 
                "16", "16", "86784000", "1280", "720", "2.0", "2.0", "320", "320", "320", 
                "MOLY.WR8.W1301.MD.TG.MP.V1.P14, 2013/06/06 00:43", "3.4.5", "Linux version 3.4.5 (root@SWT192) (gcc version 4.6.x-google 20120106 (prerelease" +
    ") (GCC) ) #1 SMP PREEMPT Thu Jun 6 00:21:56 CST 2013\n"
    , "Processor\t: ARMv7 Processor rev 2 (v7l)\nprocessor\t: 0\nBogoMIPS\t: 2439.94\n\n" +
    "processor\t: 1\nBogoMIPS\t: 2447.96\n\nprocessor\t: 2\nBogoMIPS\t: 2000.48\n\nFe" +
    "atures\t: swp half thumb fastmult vfp edsp thumbee neon vfpv3 tls vfpv4 idiva id" +
    "ivt \nCPU implementer\t: 0x41\nCPU architecture: 7\nCPU variant\t: 0x0\nCPU part" +
    "\t: 0xc07\nCPU revision\t: 2\n\nHardware\t: MT6589\nRevision\t: 0000\nSerial\t\t" +
    ": 0000000000000000\n"
    , "yidong"
            });
            insertLib(maps,new String[] {
                "Q103", "T805s", "T805s", "MT6592T\u516B\u6838_\u4E09\u661FT805s  4G\u901A\u8BDD\u7248", "Wiselinksz", "T805s", "MID", "", "KOT49H", "user", 
                "release-keys", "jenkins", "buildserver#2", "mt6592t", "armeabi-v7a", "armeabi", "T805s/MID/T805s:4.4.2/KOT49H/1416200664:user/release-keys", "REL", "vJ10L4", "4.4.2", 
                "19", "19", "86773102", "1280", "752", "1.25", "1.0", "160", "160", "160", 
                "MOLY.WR8.W1315.MD.WG.MP.V54.P2, 2014/08/25 14:37", "3.4.67", "Linux version 3.4.67 (jenkins@jenkins213) (gcc version 4.7 (GCC) ) #1 SMP PREEMP" +
    "T Tue Oct 28 11:07:55 CST 2014\n"
    , "Processor\t: ARMv7 Processor rev 3 (v7l)\nprocessor\t: 0\nBogoMIPS\t: 2590.72\n\n" +
    "processor\t: 1\nBogoMIPS\t: 2590.72\n\nprocessor\t: 2\nBogoMIPS\t: 2590.72\n\npr" +
    "ocessor\t: 3\nBogoMIPS\t: 2590.72\n\nprocessor\t: 4\nBogoMIPS\t: 2590.72\n\nproc" +
    "essor\t: 5\nBogoMIPS\t: 2590.72\n\nFeatures\t: swp half thumb fastmult vfp edsp " +
    "thumbee neon vfpv3 tls vfpv4 idiva idivt \nCPU implementer\t: 0x41\nCPU architec" +
    "ture: 7\nCPU variant\t: 0x0\nCPU part\t: 0xc07\nCPU revision\t: 3\n\nHardware\t:" +
    " MT6592T\nRevision\t: 0000\nSerial\t\t: 0000000000000000\n"
    , "yidong"
            });
            insertLib(maps,new String[] {
                "hct17_ics2", "FDT_E939", "hct17_ics2", "R08", "alps", "FDT E939", "hct17_ics2", "", "IMM76D", "user", 
                "test-keys", "release", "HCT-SW-Server-04", "mt6577", "armeabi-v7a", "armeabi", "FDT_E939/hct17_ics2/hct17_ics2:4.2/IMM76D/1372056825:user/test-keys", "REL", "eng.release.1372056825", "4.2", 
                "15", "15", "86739500", "854", "480", "1.5", "1.5", "240", "240", "240", 
                "MAUI.11AMD.W12.22.SP.V11.P2, 2013/04/10 10:10", "3.0.13", "Linux version 3.0.13 (release@HCT-SW-Server-04) (gcc version 4.4.3 (GCC) ) #1 SM" +
    "P PREEMPT Mon Jun 24 14:53:34 CST 2013\n"
    , "Processor\t: ARMv7 Processor rev 0 (v7l)\nprocessor\t: 0\nBogoMIPS\t: 1993.93\n\n" +
    "processor\t: 1\nBogoMIPS\t: 2000.48\n\nFeatures\t: swp half thumb fastmult vfp e" +
    "dsp thumbee neon vfpv3 \nCPU implementer\t: 0x41\nCPU architecture: 7\nCPU varia" +
    "nt\t: 0x3\nCPU part\t: 0xc09\nCPU revision\t: 0\n\nHardware\t: Quad-Core MT6589\n" +
    "Revision\t: 65fb8a00\nSerial\t\t: 0000000000000000\n"
    , "yidong"
            });
            insertLib(maps,new String[] {
                "K22", "OUKI", "K22", "OUKI_A33_TD_V1.0 20130829-123549", "OUKI", "A33", "K22", "", "JDQ39", "user", 
                "test-keys", "scm", "vanzo71", "mt6572", "armeabi-v7a", "armeabi", "OUKI/K22/K22:4.2.2/JDQ39/1377750870:user/test-keys", "REL", "eng.scm.1377750870", "4.2.2", 
                "17", "17", "86698301", "960", "540", "1.6500001", "1.5", "240", "159.48837", "160.42105", 
                "MOLY.WR8.W1319.MD.TG.MP.V1.P10, 2013/08/15 21:03", "3.4.5", "Linux version 3.4.5 (songlixin@vanzo71) (gcc version 4.6.x-google 20120106 (prer" +
    "elease) (GCC) ) #1 SMP PREEMPT Thu Aug 29 12:34:07 CST 2013\n"
    , "Processor\t: ARMv7 Processor rev 3 (v7l)\nprocessor\t: 0\nBogoMIPS\t: 2589.52\n\n" +
    "processor\t: 1\nBogoMIPS\t: 2589.52\n\nFeatures\t: swp half thumb fastmult vfp e" +
    "dsp thumbee neon vfpv3 tls vfpv4 idiva idivt \nCPU implementer\t: 0x41\nCPU arch" +
    "itecture: 7\nCPU variant\t: 0x0\nCPU part\t: 0xc07\nCPU revision\t: 3\n\nHardwar" +
    "e\t: MT6589\nRevision\t: 0000\nSerial\t\t: 0000000000000000\n"
    , "yidong"
            });
            insertLib(maps,new String[] {
                "P770", "Lenovo", "P770", "Lenovo P770_S124_130201", "LENOVO", "Lenovo P770", "P770", "", "JRO03C", "user", 
                "release-keys", "buildslave", "lenovo-s16", "mt6577", "armeabi-v7a", "armeabi", "Lenovo/P770/P770:4.1.1/JRO03C/P770_S124_130201:user/release-keys", "REL", "P770_S124_130201", "4.1.1", 
                "16", "16", "86695901", "960", "540", "1.5", "1.5", "240", "240", "240", 
                "P770.W12.22.SP.V15.P11, 2012/12/12 18:17", "3.4.0", "", "Processor\t: ARMv7 Processor rev 0 (v7l)\nprocessor\t: 0\nBogoMIPS\t: 1608.90\n\n" +
    "processor\t: 1\nBogoMIPS\t: 1608.90\n\nFeatures\t: swp half thumb fastmult vfp e" +
    "dsp thumbee neon vfpv3 tls \nCPU implementer\t: 0x41\nCPU architecture: 7\nCPU v" +
    "ariant\t: 0x3\nCPU part\t: 0xc09\nCPU revision\t: 0\n\nHardware\t: MT6577\nRevis" +
    "ion\t: 0000\nSerial\t\t: 0000000000000000\n"
    , "liantong"
            });
            insertLib(maps,new String[] {
                "hct17_ics2", "alps", "hct17_ics2", "R03", "alps", "intkiE93", "hct17_ics2", "", "IMM76D", "user", 
                "test-keys", "release", "release09", "mt6577", "armeabi-v7a", "armeabi", "alps/hct17_ics2/hct17_ics2:4.0.4/IMM76D/1357376324:user/test-keys", "REL", "eng.release.1357376324", "4.0.4", 
                "15", "15", "86692101", "854", "480", "1.5", "1.5", "240", "240", "240", 
                "MAUI.11AMD.W12.22.SP.V11, 2012/12/12 13:59", "3.0.13", "Linux version 3.0.13 (release@release09) (gcc version 4.4.3 (GCC) ) #1 SMP PREEM" +
    "PT Sat Jan 5 16:58:25 CST 2013\n"
    , "Processor\t: ARMv7 Processor rev 0 (v7l)\nprocessor\t: 0\nBogoMIPS\t: 1993.93\n\n" +
    "processor\t: 1\nBogoMIPS\t: 2000.48\n\nFeatures\t: swp half thumb fastmult vfp e" +
    "dsp thumbee neon vfpv3 \nCPU implementer\t: 0x41\nCPU architecture: 7\nCPU varia" +
    "nt\t: 0x3\nCPU part\t: 0xc09\nCPU revision\t: 0\n\nHardware\t: MT6577\nRevision\t" +
    ": 65fb8a00\nSerial\t\t: 0000000000000000\n"
    , "yidong"
            });
            insertLib(maps,new String[] {
                "U8951D", "Huawei", "hwG510-0010", "G510-0010V100R001C17B168", "HUAWEI", "HUAWEI G510-0010", "G510-0010", "", "HuaweiG510-0010", "user", 
                "ota-rel-keys,release-keys", "huawei", "huawei-desktop", "huawei", "armeabi-v7a", "armeabi", "Huawei/G510-0010/hwG510-0010:4.1.1/HuaweiG510-0010/C17B168:user/ota-rel-keys,rel" +
    "ease-keys"
    , "REL", "C17B168", "4.1.1", 
                "16", "16", "86687201", "854", "480", "1.5", "1.5", "240", "160.42105", "159.49706", 
                "no message", "3.4.0-perf-g0d04852-00764-gb88fdd4", "Linux version 3.4.0-perf-g0d04852-00764-gb88fdd4 (android@localhost) (gcc versio" +
    "n 4.6.x-google 20120106 (prerelease) (GCC) ) #1 SMP PREEMPT Fri Dec 21 23:14:24 " +
    "CST 2012\n"
    , "Processor\t: ARMv7 Processor rev 1 (v7l)\nprocessor\t: 0\nBogoMIPS\t: 802.63\n\n" +
    "processor\t: 1\nBogoMIPS\t: 802.63\n\nFeatures\t: swp half thumb fastmult vfp ed" +
    "sp thumbee neon vfpv3 tls vfpv4 \nCPU implementer\t: 0x41\nCPU architecture: 7\n" +
    "CPU variant\t: 0x0\nCPU part\t: 0xc05\nCPU revision\t: 1\n\nHardware\t: MSM8x25 " +
    "U8951D BOARD\nRevision\t: 0000\nSerial\t\t: 0000000000000000\n"
    , "liantong"
            });
            insertLib(maps,new String[] {
                "leatek71_et_jb7", "G4", "leatek71_et_jb7", "V1.0.0.20140927.092835", "G4", "G4", "leatek71_et_jb7", "", "JDQ39", "user", 
                "test-keys", "zengk", "ubuntu-server5", "mt6571", "armeabi-v7a", "armeabi", "alps/leatek71_et_jb7/leatek71_et_jb7:4.2.2/JDQ39/1411781315:user/test-keys", "REL", "eng.zengk.1411781315", "4.4.2", 
                "17", "17", "86651400", "960", "540", "1.5", "1.5", "240", "240.63158", "239.05882", 
                "MOLY.WR8.W1328.MD.TG.MP.V17, 2014/03/27 13:46", "3.4.39", "Linux version 3.4.39 (zengk@ubuntu-server5) (gcc version 4.6.x-google 20120106 (" +
    "prerelease) (GCC) ) #1 SMP PREEMPT Sat Sep 27 09:28:06 CST 2014\n"
    , "Processor\t: ARMv7 Processor rev 4 (v7l)\nprocessor\t: 0\nBogoMIPS\t: 2589.52\n\n" +
    "processor\t: 1\nBogoMIPS\t: 2589.52\n\nFeatures\t: swp half thumb fastmult vfp e" +
    "dsp thumbee neon vfpv3 tls vfpv4 idiva idivt \nCPU implementer\t: 0x41\nCPU arch" +
    "itecture: 7\nCPU variant\t: 0x0\nCPU part\t: 0xc07\nCPU revision\t: 4\n\nHardwar" +
    "e\t: MT6571\nRevision\t: 0000\nSerial\t\t: 0000000000000000\n"
    , "yidong"
            });
            insertLib(maps,new String[] {
                "sp6825c2", "Android", "Android", "Android4.4.4", "Spreadtrum", "Android", "Android", "", "Android4.4.4", "user", 
                "test-keys", "jenkins", "android107", "mtk6589", "armeabi-v7a", "armeabi", "Android4.4.4", "REL", "S9E_JH_A1_P4.WVGA.USR.R0416.48.B2G", "4.4.4", 
                "15", "15", "86625601", "800", "480", "1.9499999", "1.5", "240", "225.77777", "211.66667", 
                "DM_BASE_13B_W13.34\nsc6825_modem\n08-24-2013 21:44:14", "3.0.8", "Linux version 3.0.8 (jenkins@android107) (gcc version 4.4.3 (GCC) ) #1 SMP PREEM" +
    "PT Tue Apr 29 12:14:24 CST 2014\n"
    , "Processor\t: ARMv7 Processor rev 1 (v7l)\nprocessor\t: 0\nBogoMIPS\t: 1024.00\n\n" +
    "processor\t: 1\nBogoMIPS\t: 1024.00\n\nFeatures\t: swp half thumb fastmult vfp e" +
    "dsp thumbee neon vfpv3 \nCPU implementer\t: 0x41\nCPU architecture: 7\nCPU varia" +
    "nt\t: 0x0\nCPU part\t: 0xc05\nCPU revision\t: 1\n\nHardware\t: mtk6589\nRevision" +
    "\t: 0000\nSerial\t\t: 0000000000000000\n"
    , "yidong"
            });
            insertLib(maps,new String[] {
                "", "Xiaomi", "pisces", "KTU84P", "Xiaomi", "MI 3", "pisces", "", "KTU84P", "user", 
                "release-keys", "builder", "wcc-miui-ota-bd19", "pisces", "armeabi-v7a", "armeabi", "Xiaomi/pisces/pisces:4.4.4/KTU84P/V6.1.2.0.KXCCNBJ:user/release-keys", "REL", "V6.1.2.0.KXCCNBJ", "4.4.4", 
                "19", "19", "86600102", "1920", "1080", "3.0", "3.0", "480", "442.452", "443.345", 
                "DM_BASE_13A_8803G_W13.44 \n 20140120092332", "3.4.35-g48253b7", "", "Processor\t: ARMv7 Processor rev 2 (v7l)\nprocessor\t: 0\nBogoMIPS\t: 1176.57\n\n" +
    "processor\t: 1\nBogoMIPS\t: 1176.57\n\nprocessor\t: 2\nBogoMIPS\t: 1176.57\n\npr" +
    "ocessor\t: 3\nBogoMIPS\t: 1176.57\n\nFeatures\t: swp half thumb fastmult vfp eds" +
    "p neon vfpv3 tls vfpv4 idiva idivt \nCPU implementer\t: 0x41\nCPU architecture: " +
    "7\nCPU variant\t: 0x2\nCPU part\t: 0xc0f\nCPU revision\t: 2\n\nHardware\t: pisce" +
    "s\nRevision\t: 0000\nSerial\t\t: 062c006403430200\n"
    , "yidong"
            });
            insertLib(maps,new String[] {
                "lcsh82_slt_cb_kk", "Lenovo", "A360t", "A360t_S001_140518", "LENOVO", "Lenovo A360t", "A360t", "", "KOT49H", "user", 
                "release-keys", "jenkins", "glsrv4", "mt6582", "armeabi-v7a", "armeabi", "Lenovo/A360t/A360t:4.4.2/KOT49H/A360t_USR_S224_140925:user/release-keys", "REL", "A360t_S224_140925", "4.4.2", 
                "19", "19", "86593402", "854", "480", "1.5", "1.5", "240", "240", "240", 
                "MOLY.LR9.W1414A.MD.LWTG.MP.V2.P27, 2014/09/17 14:58", "3.4.67", "Linux version 3.4.67 (jenkins@glsrv4) (gcc version 4.7 (GCC) ) #1 SMP PREEMPT Fr" +
    "i Sep 26 09:06:59 CST 2014\n"
    , "Processor\t: ARMv7 Processor rev 3 (v7l)\nprocessor\t: 0\nBogoMIPS\t: 2590.72\n\n" +
    "processor\t: 1\nBogoMIPS\t: 2590.72\n\nprocessor\t: 2\nBogoMIPS\t: 2590.72\n\npr" +
    "ocessor\t: 3\nBogoMIPS\t: 2590.72\n\nFeatures\t: swp half thumb fastmult vfp eds" +
    "p thumbee neon vfpv3 tls vfpv4 idiva idivt \nCPU implementer\t: 0x41\nCPU archit" +
    "ecture: 7\nCPU variant\t: 0x0\nCPU part\t: 0xc07\nCPU revision\t: 3\n\nHardware\t" +
    ": MT6582\nRevision\t: 0000\nSerial\t\t: 0000000000000000\n"
    , "yidong"
            });
            insertLib(maps,new String[] {
                "2014501", "Xiaomi", "HM2014501", "KOT49H", "Xiaomi", "2014501", "2014501", "", "KOT49H", "user", 
                "release-keys", "builder", "wcc-miui-ota-bd25", "mt6582", "armeabi-v7a", "armeabi", "Xiaomi/2014501/HM2014501:4.4.2/KOT49H/KHHCNBF2.0:user/release-keys", "REL", "KHHCNBF2.0", "4.4.2", 
                "19", "19", "86589902", "1280", "720", "2.0", "2.0", "320", "294.967", "285.193", 
                "MOLY.LR9.W1414A.MD.LWTG.MP.V3.P36, 2014/08/06 03:47", "3.4.67", "", "Processor\t: ARMv7 Processor rev 3 (v7l)\nprocessor\t: 0\nBogoMIPS\t: 2590.72\n\n" +
    "processor\t: 1\nBogoMIPS\t: 2590.72\n\nprocessor\t: 2\nBogoMIPS\t: 2590.72\n\npr" +
    "ocessor\t: 3\nBogoMIPS\t: 2590.72\n\nFeatures\t: swp half thumb fastmult vfp eds" +
    "p thumbee neon vfpv3 tls vfpv4 idiva idivt \nCPU implementer\t: 0x41\nCPU archit" +
    "ecture: 7\nCPU variant\t: 0x0\nCPU part\t: 0xc07\nCPU revision\t: 3\n\nHardware\t" +
    ": MT6582\nRevision\t: aaff\nSerial\t\t: 0000000000000000\n"
    , "yidong"
            });
            insertLib(maps,new String[] {
                "MSM8226", "OPPO", "R831S", "R831S_11_141023", "OPPO", "R831S", "R831S", "", "JLS36C", "user", 
                "release-keys", "root", "ubuntu", "qcom", "armeabi-v7a", "armeabi", "OPPO/R831S/R831S:4.3/JLS36C/1390465867:user/release-keys", "REL", "eng.root.20141023.145103", "4.3", 
                "18", "18", "86588102", "854", "480", "1.5", "1.5", "240", "206.644", "208.573", 
                "Q_V1_P14", "3.4.0", "Linux version 3.4.0 (root@ubuntu) (gcc version 4.7 (GCC) ) #1 SMP PREEMPT Thu Oc" +
    "t 23 15:02:36 CST 2014\n"
    , "Processor\t: ARMv7 Processor rev 3 (v7l)\nprocessor\t: 0\nBogoMIPS\t: 38.40\n\np" +
    "rocessor\t: 1\nBogoMIPS\t: 38.40\n\nprocessor\t: 2\nBogoMIPS\t: 38.40\n\nprocess" +
    "or\t: 3\nBogoMIPS\t: 38.40\n\nFeatures\t: swp half thumb fastmult vfp edsp neon " +
    "vfpv3 tls vfpv4 idiva idivt \nCPU implementer\t: 0x41\nCPU architecture: 7\nCPU " +
    "variant\t: 0x0\nCPU part\t: 0xc07\nCPU revision\t: 3\n\nHardware\t: Qualcomm MSM" +
    " 8226 (Flattened Device Tree)\nRevision\t: 0000\nSerial\t\t: 0000000000000000\n"
    , "yidong"
            });
            insertLib(maps,new String[] {
                "", "Xiaomi", "pisces", "KOT49H", "Xiaomi", "MI 3", "pisces", "", "KOT49H", "user", 
                "release-keys", "builder", "wcc-miui-ota-bd19", "pisces", "armeabi-v7a", "armeabi", "Xiaomi/pisces/pisces:4.4.2/KOT49H/KXCCNBH31.0:user/release-keys", "REL", "KXCCNBH31.0", "4.4.2", 
                "19", "19", "86585402", "1920", "1080", "3.0", "3.0", "480", "442.452", "443.345", 
                "DM_BASE_13A_8803G_W13.44 \n 20140120092332", "3.4.35-g705ece4", "Linux version 3.4.35-g705ece4 (builder@taishan) (gcc version 4.6.x-google 201201" +
    "06 (prerelease) (GCC) ) #1 SMP PREEMPT Wed Jul 30 21:06:54 CST 2014\n"
    , "Processor\t: ARMv7 Processor rev 2 (v7l)\nprocessor\t: 0\nBogoMIPS\t: 1176.57\n\n" +
    "processor\t: 1\nBogoMIPS\t: 1176.57\n\nprocessor\t: 2\nBogoMIPS\t: 1176.57\n\npr" +
    "ocessor\t: 3\nBogoMIPS\t: 1176.57\n\nFeatures\t: swp half thumb fastmult vfp eds" +
    "p neon vfpv3 tls vfpv4 idiva idivt \nCPU implementer\t: 0x41\nCPU architecture: " +
    "7\nCPU variant\t: 0x2\nCPU part\t: 0xc0f\nCPU revision\t: 2\n\nHardware\t: pisce" +
    "s\nRevision\t: 0000\nSerial\t\t: 062c006403430200\n"
    , "yidong"
            });
            insertLib(maps,new String[] {
                "lcsh82_slt_cb_kk", "Lenovo", "A360t", "A360t_S001_140518", "LENOVO", "Lenovo A360t", "A360t", "", "KOT49H", "user", 
                "release-keys", "jenkins", "glsrv4", "mt6582", "armeabi-v7a", "armeabi", "Lenovo/A360t/A360t:4.4.2/KOT49H/A360t_USR_S221_140806:user/release-keys", "REL", "A360t_S221_140806", "4.4.2", 
                "19", "19", "86578602", "854", "480", "1.5", "1.5", "240", "240", "240", 
                "MOLY.LR9.W1414A.MD.LWTG.MP.V2.P20, 2014/08/06 09:53", "3.4.67", "Linux version 3.4.67 (jenkins@glsrv4) (gcc version 4.7 (GCC) ) #1 SMP PREEMPT We" +
    "d Aug 6 12:54:55 CST 2014\n"
    , "Processor\t: ARMv7 Processor rev 3 (v7l)\nprocessor\t: 0\nBogoMIPS\t: 2590.72\n\n" +
    "processor\t: 1\nBogoMIPS\t: 2590.72\n\nprocessor\t: 2\nBogoMIPS\t: 2590.72\n\npr" +
    "ocessor\t: 3\nBogoMIPS\t: 2590.72\n\nFeatures\t: swp half thumb fastmult vfp eds" +
    "p thumbee neon vfpv3 tls vfpv4 idiva idivt \nCPU implementer\t: 0x41\nCPU archit" +
    "ecture: 7\nCPU variant\t: 0x0\nCPU part\t: 0xc07\nCPU revision\t: 3\n\nHardware\t" +
    ": MT6582\nRevision\t: 0000\nSerial\t\t: 0000000000000000\n"
    , "yidong"
            });
            insertLib(maps,new String[] {
                "MSM8226", "OPPO", "R831S", "R831S_11_140912", "OPPO", "R831S", "R831S", "", "JLS36C", "user", 
                "release-keys", "root", "ubuntu", "qcom", "armeabi-v7a", "armeabi", "OPPO/R831S/R831S:4.3/JLS36C/1390465867:user/release-keys", "REL", "eng.root.20140912.190627", "4.3", 
                "18", "18", "86567502", "854", "480", "1.5", "1.5", "240", "206.644", "208.573", 
                "Q_V1_P14", "3.4.0", "Linux version 3.4.0 (root@ubuntu) (gcc version 4.7 (GCC) ) #1 SMP PREEMPT Fri Se" +
    "p 12 19:41:25 CST 2014\n"
    , "Processor\t: ARMv7 Processor rev 3 (v7l)\nprocessor\t: 0\nBogoMIPS\t: 38.40\n\np" +
    "rocessor\t: 1\nBogoMIPS\t: 38.40\n\nprocessor\t: 2\nBogoMIPS\t: 38.40\n\nprocess" +
    "or\t: 3\nBogoMIPS\t: 38.40\n\nFeatures\t: swp half thumb fastmult vfp edsp neon " +
    "vfpv3 tls vfpv4 idiva idivt \nCPU implementer\t: 0x41\nCPU architecture: 7\nCPU " +
    "variant\t: 0x0\nCPU part\t: 0xc07\nCPU revision\t: 3\n\nHardware\t: Qualcomm MSM" +
    " 8226 (Flattened Device Tree)\nRevision\t: 0000\nSerial\t\t: 0000000000000000\n"
    , "yidong"
            });
            insertLib(maps,new String[] {
                "MSM8226", "OPPO", "R2017", "R2017_11_140616", "OPPO", "R2017", "R2017", "", "JLS36C", "user", 
                "release-keys", "root", "ubuntu", "qcom", "armeabi-v7a", "armeabi", "OPPO/R2017/R2017:4.3/JLS36C/1390465867:user/release-keys", "REL", "eng.root.20140616.190601", "4.3", 
                "18", "18", "86567402", "960", "540", "1.86", "1.5", "240", "232.474", "234.461", 
                "Q_V1_P14", "3.4.0", "Linux version 3.4.0 (root@ubuntu) (gcc version 4.7 (GCC) ) #1 SMP PREEMPT Mon Ju" +
    "n 16 19:20:35 CST 2014\n"
    , "Processor\t: ARMv7 Processor rev 3 (v7l)\nprocessor\t: 0\nBogoMIPS\t: 38.40\n\np" +
    "rocessor\t: 1\nBogoMIPS\t: 38.40\n\nprocessor\t: 2\nBogoMIPS\t: 38.40\n\nprocess" +
    "or\t: 3\nBogoMIPS\t: 38.40\n\nFeatures\t: swp half thumb fastmult vfp edsp neon " +
    "vfpv3 tls vfpv4 idiva idivt \nCPU implementer\t: 0x41\nCPU architecture: 7\nCPU " +
    "variant\t: 0x0\nCPU part\t: 0xc07\nCPU revision\t: 3\n\nHardware\t: Qualcomm MSM" +
    " 8226 (Flattened Device Tree)\nRevision\t: 0000\nSerial\t\t: 0000000000000000\n"
    , "yidong"
            });
            insertLib(maps,new String[] {
                "BalongV9R1", "Honor", "hwH30", "H30-L01MV100R001CHNC01B132", "HUAWEI", "HONOR H30-L01M", "H30-L01M", "", "HonorH30-L01M", "user", 
                "ota-rel-keys,release-keys", "android", "localhost#1", "hi6620oem", "armeabi-v7a", "armeabi", "Honor/H30-L01M/hwH30:4.4.2/HonorH30-L01M/C01B132:user/ota-rel-keys,release-keys", "REL", "C01B132", "4.4.2", 
                "19", "19", "86566602", "1280", "720", "2.0", "2.0", "320", "268.941", "239.058", 
                "23.256.00.00.000", "3.0.8-g69b9442", "Linux version 3.0.8-g69b9442 (android@localhost) (gcc version 4.7 (GCC) ) #1 SMP" +
    " PREEMPT Wed Jul 30 18:39:01 CST 2014\n"
    , "Processor\t: ARMv7 Processor rev 1 (v7l)\nprocessor\t: 0\nBogoMIPS\t: 3180.00\n\n" +
    "processor\t: 1\nBogoMIPS\t: 3180.00\n\nprocessor\t: 2\nBogoMIPS\t: 3180.00\n\npr" +
    "ocessor\t: 3\nBogoMIPS\t: 3180.00\n\nFeatures\t: swp half thumb fastmult vfp eds" +
    "p thumbee neon vfpv3 \nCPU implementer\t: 0x41\nCPU architecture: 7\nCPU variant" +
    "\t: 0x4\nCPU part\t: 0xc09\nCPU revision\t: 1\n\nHardware\t: hi6620oem\nRevision" +
    "\t: 0000\nSerial\t\t: 0000000000000000\n"
    , "yidong"
            });
            insertLib(maps,new String[] {
                "BalongV9R1", "Honor", "hwH30", "H30-L01MV100R001CHNC01B132", "HUAWEI", "HONOR H30-L01M", "H30-L01M", "", "HonorH30-L01M", "user", 
                "ota-rel-keys,release-keys", "android", "localhost#1", "hi6620oem", "armeabi-v7a", "armeabi", "Honor/H30-L01M/hwH30:4.4.2/HonorH30-L01M/C01B132:user/ota-rel-keys,release-keys", "REL", "C01B132", "4.4.2", 
                "19", "19", "86566602", "1280", "720", "2.0", "2.0", "320", "268.941", "239.058", 
                "23.255.00.00.000", "3.0.8-g69b9442", "Linux version 3.0.8-g69b9442 (android@localhost) (gcc version 4.7 (GCC) ) #1 SMP" +
    " PREEMPT Wed Jul 30 18:39:01 CST 2014\n"
    , "Processor\t: ARMv7 Processor rev 1 (v7l)\nprocessor\t: 0\nBogoMIPS\t: 3180.00\n\n" +
    "processor\t: 1\nBogoMIPS\t: 3180.00\n\nprocessor\t: 2\nBogoMIPS\t: 3180.00\n\npr" +
    "ocessor\t: 3\nBogoMIPS\t: 3180.00\n\nFeatures\t: swp half thumb fastmult vfp eds" +
    "p thumbee neon vfpv3 \nCPU implementer\t: 0x41\nCPU architecture: 7\nCPU variant" +
    "\t: 0x4\nCPU part\t: 0xc09\nCPU revision\t: 1\n\nHardware\t: hi6620oem\nRevision" +
    "\t: 0000\nSerial\t\t: 0000000000000000\n"
    , "yidong"
            });
            insertLib(maps,new String[] {
                "MSM8226", "Xiaomi", "armani", "JLS36C", "Xiaomi", "HM 1SW", "armani", "", "JLS36C", "user", 
                "release-keys", "builder", "wcc-miui-ota-bd08.bj", "qcom", "armeabi-v7a", "armeabi", "Xiaomi/armani/armani:4.3/JLS36C/JHCCNBD22.0:user/release-keys", "REL", "JHCCNBD22.0", "4.3", 
                "18", "18", "86562402", "1280", "720", "2.0", "2.0", "320", "160.421", "160.157", 
                "MPSS.TR.2.0-b1e0d0c,MPSS.TR.2.0-b1e0d0c", "3.4.0-g6e12f86-00266-g8cd00c9", "Linux version 3.4.0-g6e12f86-00266-g8cd00c9 (builder@xiangshan) (gcc version 4.7" +
    " (GCC) ) #1 SMP PREEMPT Wed Apr 23 21:27:00 CST 2014\n"
    , "Processor\t: ARMv7 Processor rev 3 (v7l)\nprocessor\t: 0\nBogoMIPS\t: 38.40\n\np" +
    "rocessor\t: 1\nBogoMIPS\t: 38.40\n\nprocessor\t: 2\nBogoMIPS\t: 38.40\n\nprocess" +
    "or\t: 3\nBogoMIPS\t: 38.40\n\nFeatures\t: swp half thumb fastmult vfp edsp neon " +
    "vfpv3 tls vfpv4 idiva idivt \nCPU implementer\t: 0x41\nCPU architecture: 7\nCPU " +
    "variant\t: 0x0\nCPU part\t: 0xc07\nCPU revision\t: 3\n\nHardware\t: Qualcomm MSM" +
    " 8226 (Flattened Device Tree)\nRevision\t: 0000\nSerial\t\t: 0000000000000000\n"
    , "yidong"
            });
            insertLib(maps,new String[] {
                "MSM8226", "OPPO", "msm8226", "R8007_11_140429", "OPPO", "R8007", "msm8226", "", "JLS36C", "user", 
                "release-keys", "root", "ubuntu", "qcom", "armeabi-v7a", "armeabi", "OPPO/R8007/R8007:4.3/JLS36C/1390465867:user/release-keys", "REL", "eng.root.20140721.195558", "4.3", 
                "18", "18", "86556702", "1280", "720", "2.0", "2.0", "320", "309.966", "312.615", 
                "Q_V1_P14", "3.4.0", "Linux version 3.4.0 (root@ubuntu) (gcc version 4.7 (GCC) ) #1 SMP PREEMPT Mon Ju" +
    "l 21 20:37:20 CST 2014\n"
    , "Processor\t: ARMv7 Processor rev 3 (v7l)\nprocessor\t: 0\nBogoMIPS\t: 38.40\n\np" +
    "rocessor\t: 1\nBogoMIPS\t: 38.40\n\nprocessor\t: 2\nBogoMIPS\t: 38.40\n\nprocess" +
    "or\t: 3\nBogoMIPS\t: 38.40\n\nFeatures\t: swp half thumb fastmult vfp edsp neon " +
    "vfpv3 tls vfpv4 idiva idivt \nCPU implementer\t: 0x41\nCPU architecture: 7\nCPU " +
    "variant\t: 0x0\nCPU part\t: 0xc07\nCPU revision\t: 3\n\nHardware\t: Qualcomm MSM" +
    " 8226 (Flattened Device Tree)\nRevision\t: 0000\nSerial\t\t: 0000000000000000\n"
    , "yidong"
            });
            insertLib(maps,new String[] {
                "lcsh92_wet_tdd", "Xiaomi", "lcsh92_wet_tdd", "MIUI-yidong03", "Xiaomi", "HM NOTE 1TD", "lcsh92_wet_tdd", "", "JDQ39", "user", 
                "release-keys", "builder", "wcc-miui-ota-bd05.bj", "mt6592", "armeabi-v7a", "armeabi", "Xiaomi/lcsh92_wet_tdd/lcsh92_wet_tdd:4.2.2/JDQ39/JHECNBH37.0:user/release-keys", "REL", "JHECNBH37.0", "4.2.2", 
                "17", "17", "86545402", "1280", "720", "2.0", "2.0", "320", "320", "320", 
                "MOLY.WR8.W1328.MD.TG.MP.V3.P25, 2014/03/24 15:01", "3.4.39", "Linux version 3.4.39 (builder@wcc-miui-ota-bd05.bj) (gcc version 4.6.x-google 20" +
    "120106 (prerelease) (GCC) ) #1 SMP PREEMPT Sat Oct 4 09:03:32 CST 2014\n"
    , "Processor\t: ARMv7 Processor rev 4 (v7l)\nprocessor\t: 0\nBogoMIPS\t: 1685.91\n\n" +
    "processor\t: 1\nBogoMIPS\t: 1685.91\n\nprocessor\t: 2\nBogoMIPS\t: 1685.91\n\npr" +
    "ocessor\t: 3\nBogoMIPS\t: 1685.91\n\nprocessor\t: 4\nBogoMIPS\t: 1685.91\n\nproc" +
    "essor\t: 5\nBogoMIPS\t: 1685.91\n\nprocessor\t: 6\nBogoMIPS\t: 1685.91\n\nproces" +
    "sor\t: 7\nBogoMIPS\t: 1685.91\n\nFeatures\t: swp half thumb fastmult vfp edsp th" +
    "umbee neon vfpv3 tls vfpv4 idiva idivt \nCPU implementer\t: 0x41\nCPU architectu" +
    "re: 7\nCPU variant\t: 0x0\nCPU part\t: 0xc07\nCPU revision\t: 4\n\nHardware\t: M" +
    "T6592\nRevision\t: aaff\nSerial\t\t: 0000000000000000\n"
    , "yidong"
            });
            insertLib(maps,new String[] {
                "2013022", "Xiaomi", "HM2013022", "JH3CN0.0-41952c44d36acc0d837d5422022b4894f3b6d48b", "Xiaomi", "HM NOTE 1TD", "2013022", "", "JDQ39", "user", 
                "release-keys", "builder", "huangshan", "mt6582", "armeabi-v7a", "armeabi", "Xiaomi/2013022/HM2013022:4.2.1/HM2013022/JHACNAH2.0:user/release-keys", "REL", "JHECNBA23.0", "4.4.2", 
                "17", "17", "86545402", "960", "540", "1.8000001", "1.5", "240", "240", "240", 
                "MOLY.WR8.W1328.MD.TG.MP.V3.P25, 2014/06/13 14:26", "3.4.5", "Linux version 3.4.5 (wangqin@userver-desktop) (gcc version 4.6.x-google 20120106" +
    " (prerelease) (GCC) ) #1 SMP PREEMPT Tue Jul 15 18:29:43 CST 2014\n"
    , "Processor\t: ARMv7 Processor rev 3 (v7l)\nprocessor\t: 0\nBogoMIPS\t: 2590.72\n\n" +
    "processor\t: 1\nBogoMIPS\t: 2590.72\n\nprocessor\t: 2\nBogoMIPS\t: 2590.72\n\npr" +
    "ocessor\t: 3\nBogoMIPS\t: 2590.72\n\nFeatures\t: swp half thumb fastmult vfp eds" +
    "p thumbee neon vfpv3 tls vfpv4 idiva idivt \nCPU implementer\t: 0x41\nCPU archit" +
    "ecture: 7\nCPU variant\t: 0x0\nCPU part\t: 0xc07\nCPU revision\t: 3\n\nHardware\t" +
    ": MT6592\nRevision\t: 0000\nSerial\t\t: 0000000000000000\n"
    , "yidong"
            });
            insertLib(maps,new String[] {
                "MSM8960", "vivo", "msm8960", "JDQ39", "BBK", "vivo Xplay", "msm8960", "", "JDQ39", "user", 
                "test-keys", "compiler", "compiler009", "qcom", "armeabi-v7a", "armeabi", "vivo/msm8960/msm8960:4.2.2/JDQ39/eng.compiler.20140625.105741:user/test-keys", "REL", "eng.compiler.20140625.105741", "4.2.2", 
                "17", "17", "86541001", "1920", "1080", "3.00003", "3.0", "480", "160.421", "159.895", 
                "MDM9x15.161032", "3.4.0", "Linux version 3.4.0 (compiler@compiler009) (gcc version 4.6.x-google 20120106 (p" +
    "rerelease) (GCC) ) #1 SMP PREEMPT Wed Jun 25 11:09:49 CST 2014\n"
    , "Processor\t: ARMv7 Processor rev 0 (v7l)\nprocessor\t: 0\nBogoMIPS\t: 13.53\n\np" +
    "rocessor\t: 1\nBogoMIPS\t: 13.53\n\nprocessor\t: 2\nBogoMIPS\t: 13.53\n\nprocess" +
    "or\t: 3\nBogoMIPS\t: 13.53\n\nFeatures\t: swp half thumb fastmult vfp edsp neon " +
    "vfpv3 tls vfpv4 \nCPU implementer\t: 0x51\nCPU architecture: 7\nCPU variant\t: 0" +
    "x1\nCPU part\t: 0x06f\nCPU revision\t: 0\n\nHardware\t: QCT APQ8064 MTP\nRevisio" +
    "n\t: 0000\nSerial\t\t: 0000000000000000\n"
    , "yidong"
            });
            insertLib(maps,new String[] {
                "MSM8226", "TCL", "Rio5C", "JLS36C", "TCL", "TCL-P688L", "TCL-P688L", "L7KB7070AT00", "JLS36C", "user", 
                "release-keys", "android-bld", "cdrnb", "qcom", "armeabi-v7a", "armeabi", "TCL/TCL-P688L/Rio5C:4.3/JLS36C/v7KB7-0:user/release-keys", "REL", "v7KB7-0", "4.3", 
                "18", "18", "86538602", "960", "540", "1.3312501", "1.3312501", "213", "159.488", "160.421", 
                "M8926AAAAANLYD1038", "3.4.0-g5f0dddc-00006-ge8144a5", "Linux version 3.4.0-g5f0dddc-00006-ge8144a5 (android-bld@cdrnb) (gcc version 4.7" +
    " (GCC) ) #1 SMP PREEMPT Wed Sep 17 13:26:34 CST 2014\n"
    , "Processor\t: ARMv7 Processor rev 3 (v7l)\nprocessor\t: 0\nBogoMIPS\t: 38.40\n\np" +
    "rocessor\t: 1\nBogoMIPS\t: 38.40\n\nprocessor\t: 2\nBogoMIPS\t: 38.40\n\nprocess" +
    "or\t: 3\nBogoMIPS\t: 38.40\n\nFeatures\t: swp half thumb fastmult vfp edsp neon " +
    "vfpv3 tls vfpv4 idiva idivt \nCPU implementer\t: 0x41\nCPU architecture: 7\nCPU " +
    "variant\t: 0x0\nCPU part\t: 0xc07\nCPU revision\t: 3\n\nHardware\t: Qualcomm MSM" +
    " 8226 (Flattened Device Tree)\nRevision\t: 0000\nSerial\t\t: 0000000000000000\n"
    , "yidong"
            });
            insertLib(maps,new String[] {
                "MSM8974", "Xiaomi", "cancro", "KTU84P", "Xiaomi", "MI 4LTE", "cancro_wc_lte", "", "KTU84P", "user", 
                "release-keys", "builder", "zc-miui-ota-bd27", "qcom", "armeabi-v7a", "armeabi", "Xiaomi/cancro_wc_lte/cancro:4.4.4/KTU84P/V6.1.2.0.KXDCNBJ:user/release-keys", "REL", "V6.1.2.0.KXDCNBJ", "4.4.4", 
                "19", "19", "86537202", "1920", "1080", "2.5500002", "3.0", "480", "449.704", "447.412", 
                "MPSS.DI.3.0-7bea055", "3.4.0-g64e9dd0-01123-g5ab8247", "Linux version 3.4.0-g64e9dd0-01123-g5ab8247 (builder@taishan) (gcc version 4.7 (" +
    "GCC) ) #1 SMP PREEMPT Wed Oct 29 11:53:15 CST 2014\n"
    , "Processor\t: ARMv7 Processor rev 1 (v7l)\nprocessor\t: 0\nBogoMIPS\t: 38.40\n\np" +
    "rocessor\t: 1\nBogoMIPS\t: 38.40\n\nprocessor\t: 2\nBogoMIPS\t: 38.40\n\nprocess" +
    "or\t: 3\nBogoMIPS\t: 38.40\n\nFeatures\t: swp half thumb fastmult vfp edsp neon " +
    "vfpv3 tls vfpv4 idiva idivt \nCPU implementer\t: 0x51\nCPU architecture: 7\nCPU " +
    "variant\t: 0x2\nCPU part\t: 0x06f\nCPU revision\t: 1\n\nHardware\t: Qualcomm MSM" +
    "8974PRO-AC\nRevision\t: 0000\nSerial\t\t: 0000000000000000\n"
    , "yidong"
            });
            insertLib(maps,new String[] {
                "MSM8974", "Xiaomi", "cancro", "KTU84P", "Xiaomi", "MI 4LTE", "cancro_wc_lte", "", "KTU84P", "user", 
                "release-keys", "builder", "zc-miui-ota-bd27", "qcom", "armeabi-v7a", "armeabi", "Xiaomi/cancro_wc_lte/cancro:4.4.4/KTU84P/V6.2.1.0.KXDCNBK:user/release-keys", "REL", "V6.2.1.0.KXDCNBK", "4.4.4", 
                "19", "19", "86537202", "1920", "1080", "3.0", "3.0", "480", "449.704", "447.412", 
                "MPSS.DI.3.0-a2ac5b4", "3.4.0-gdfdaba7-01182-g9b25266", "Linux version 3.4.0-gdfdaba7-01182-g9b25266 (builder@taishan) (gcc version 4.7 (" +
    "GCC) ) #1 SMP PREEMPT Wed Nov 12 20:29:39 CST 2014\n"
    , "Processor\t: ARMv7 Processor rev 1 (v7l)\nprocessor\t: 0\nBogoMIPS\t: 38.40\n\np" +
    "rocessor\t: 1\nBogoMIPS\t: 38.40\n\nprocessor\t: 2\nBogoMIPS\t: 38.40\n\nprocess" +
    "or\t: 3\nBogoMIPS\t: 38.40\n\nFeatures\t: swp half thumb fastmult vfp edsp neon " +
    "vfpv3 tls vfpv4 idiva idivt \nCPU implementer\t: 0x51\nCPU architecture: 7\nCPU " +
    "variant\t: 0x2\nCPU part\t: 0x06f\nCPU revision\t: 1\n\nHardware\t: Qualcomm MSM" +
    "8974PRO-AC\nRevision\t: 0000\nSerial\t\t: 0000000000000000\n"
    , "yidong"
            });
            insertLib(maps,new String[] {
                "2014501", "Xiaomi", "HM2014501", "KOT49H", "Xiaomi", "2014501", "2014501", "", "KOT49H", "user", 
                "release-keys", "builder", "wcc-miui-ota-bd25", "mt6582", "armeabi-v7a", "armeabi", "Xiaomi/2014501/HM2014501:4.4.2/KOT49H/KHHCNBH12.0:user/release-keys", "REL", "KHHCNBH12.0", "4.4.2", 
                "19", "19", "86533502", "1280", "720", "2.4", "2.0", "320", "294.967", "285.193", 
                "MOLY.LR9.W1414A.MD.LWTG.MP.V3.P36, 2014/08/06 03:47", "3.4.67", "Linux version 3.4.67 (builder@wcc-miui-ota-bd25) (gcc version 4.7 (GCC) ) #1 SMP" +
    " PREEMPT Fri Oct 3 22:07:08 CST 2014\n"
    , "Processor\t: ARMv7 Processor rev 3 (v7l)\nprocessor\t: 0\nBogoMIPS\t: 2590.72\n\n" +
    "processor\t: 1\nBogoMIPS\t: 2590.72\n\nprocessor\t: 2\nBogoMIPS\t: 2590.72\n\npr" +
    "ocessor\t: 3\nBogoMIPS\t: 2590.72\n\nFeatures\t: swp half thumb fastmult vfp eds" +
    "p thumbee neon vfpv3 tls vfpv4 idiva idivt \nCPU implementer\t: 0x41\nCPU archit" +
    "ecture: 7\nCPU variant\t: 0x0\nCPU part\t: 0xc07\nCPU revision\t: 3\n\nHardware\t" +
    ": MT6582\nRevision\t: aaff\nSerial\t\t: 0000000000000000\n"
    , "yidong"
            });
            insertLib(maps,new String[] {
                "", "Coolpad", "Coolpad8021", "4.3.016.P0.140618.8021", "Coolpad", "Coolpad 8021", "Coolpad8021", "", "JSS15Q", "user", 
                "release-keys", "system1", "ubuntu", "pxa1l88", "armeabi-v7a", "armeabi", "Coolpad/Coolpad8021/Coolpad8021:4.3/JSS15Q/4.3.036.P0.141209.8021:user/release-k" +
    "eys"
    , "REL", "", "4.3", 
                "18", "18", "86532302", "800", "480", "1.5", "1.5", "240", "160", "160", 
                "HL_CP_3.59.041::3.59.038::sky_ttc_rC0_v3_001_X49_dual_link_1.1_TQP_a_RA_Fix_leno" +
    "vo_3mode_rj"
    , "3.4.39+", "Linux version 3.4.39+ (system1@ubuntu) (gcc version 4.7 (GCC) ) #6 SMP PREEMPT T" +
    "ue Dec 9 17:21:22 CST 2014\n"
    , "processor\t: 0\nmodel name\t: ARMv7 Processor rev 3 (v7l)\nProcessor\t: ARMv7 Pr" +
    "ocessor rev 3 (v7l)\nBogoMIPS\t: 1605.94\nprocessor\t: 1\nmodel name\t: ARMv7 Pr" +
    "ocessor rev 3 (v7l)\nProcessor\t: ARMv7 Processor rev 3 (v7l)\nBogoMIPS\t: 1605." +
    "94\nprocessor\t: 2\nmodel name\t: ARMv7 Processor rev 3 (v7l)\nProcessor\t: ARMv" +
    "7 Processor rev 3 (v7l)\nBogoMIPS\t: 1605.94\nprocessor\t: 3\nmodel name\t: ARMv" +
    "7 Processor rev 3 (v7l)\nProcessor\t: ARMv7 Processor rev 3 (v7l)\nBogoMIPS\t: 1" +
    "605.94\nFeatures\t: swp half thumb fastmult vfp edsp thumbee neon vfpv3 tls vfpv" +
    "4 idiva idivt \nCPU implementer\t: 0x41\nCPU architecture: 7\nCPU variant\t: 0x0" +
    "\nCPU part\t: 0xc07\nCPU revision\t: 3\n\nHardware\t: PXA1L88\nRevision\t: 0000\n" +
    "Serial\t\t: 0000000000000000\n"
    , "yidong"
            });
            insertLib(maps,new String[] {
                "", "Coolpad", "Coolpad8021", "4.3.016.P0.140618.8021", "Coolpad", "Coolpad 8021", "Coolpad8021", "", "JSS15Q", "user", 
                "release-keys", "system1", "ubuntu", "pxa1l88", "armeabi-v7a", "armeabi", "Coolpad/Coolpad8021/Coolpad8021:4.3/JSS15Q/4.3.036.P0.141209.8021:user/release-k" +
    "eys"
    , "REL", "", "4.3", 
                "18", "18", "86532302", "800", "480", "1.5000057", "1.5", "240", "160", "160", 
                "HL_CP_3.59.041::3.59.038::sky_ttc_rC0_v3_001_X49_dual_link_1.1_TQP_a_RA_Fix_leno" +
    "vo_3mode_rj"
    , "3.4.39+", "Linux version 3.4.39+ (system1@ubuntu) (gcc version 4.7 (GCC) ) #6 SMP PREEMPT T" +
    "ue Dec 9 17:21:22 CST 2014\n"
    , "processor\t: 0\nmodel name\t: ARMv7 Processor rev 3 (v7l)\nProcessor\t: ARMv7 Pr" +
    "ocessor rev 3 (v7l)\nBogoMIPS\t: 2374.74\nprocessor\t: 1\nmodel name\t: ARMv7 Pr" +
    "ocessor rev 3 (v7l)\nProcessor\t: ARMv7 Processor rev 3 (v7l)\nBogoMIPS\t: 2374." +
    "74\nprocessor\t: 2\nmodel name\t: ARMv7 Processor rev 3 (v7l)\nProcessor\t: ARMv" +
    "7 Processor rev 3 (v7l)\nBogoMIPS\t: 2374.74\nprocessor\t: 3\nmodel name\t: ARMv" +
    "7 Processor rev 3 (v7l)\nProcessor\t: ARMv7 Processor rev 3 (v7l)\nBogoMIPS\t: 2" +
    "374.74\nFeatures\t: swp half thumb fastmult vfp edsp thumbee neon vfpv3 tls vfpv" +
    "4 idiva idivt \nCPU implementer\t: 0x41\nCPU architecture: 7\nCPU variant\t: 0x0" +
    "\nCPU part\t: 0xc07\nCPU revision\t: 3\n\nHardware\t: PXA1L88\nRevision\t: 0000\n" +
    "Serial\t\t: 0000000000000000\n"
    , "yidong"
            });
            insertLib(maps,new String[] {
                "A728", "HOSIN", "HOSIN_V70", "A728F_702A_V1_1_4_TMP", "HOSIN", "HOSIN V70", "A728", "", "HOSINA728", "user", 
                "release-keys", "", "znywb", "mt6589", "armeabi-v7a", "armeabi", "HOSIN/A728/HOSIN_V70:4.2.1/HOSINA728/A728F_702A_V1_1_4_TMP:user/release-keys", "REL", "eng..1379075831", "4.2.1", 
                "17", "17", "86523201", "960", "540", "1.5", "1.5", "240", "240", "240", 
                "MOLY.WR8.W1248.MD.WG.MP.V6.P7, 2013/04/22 13:30", "3.4.5", "Linux version 3.4.5 (queen@znywb) (gcc version 4.6.x-google 20120106 (prerelease" +
    ") (GCC) ) #1 SMP PREEMPT Fri Sep 13 20:36:30 CST 2013\n"
    , "Processor\t: ARMv7 Processor rev 2 (v7l)\nprocessor\t: 0\nBogoMIPS\t: 2439.94\n\n" +
    "processor\t: 1\nBogoMIPS\t: 2447.96\n\nprocessor\t: 2\nBogoMIPS\t: 2447.96\n\nFe" +
    "atures\t: swp half thumb fastmult vfp edsp thumbee neon vfpv3 tls vfpv4 idiva id" +
    "ivt \nCPU implementer\t: 0x41\nCPU architecture: 7\nCPU variant\t: 0x0\nCPU part" +
    "\t: 0xc07\nCPU revision\t: 2\n\nHardware\t: MT6589\nRevision\t: 0000\nSerial\t\t" +
    ": 0000000000000000\n"
    , "yidong"
            });
            insertLib(maps,new String[] {
                "MSM8226", "Xiaomi", "dior", "KVT49L", "Xiaomi", "HM NOTE 1LTEW", "dior", "", "KVT49L", "user", 
                "release-keys", "builder", "zc-miui-ota-bd33", "qcom", "armeabi-v7a", "armeabi", "Xiaomi/dior/dior:4.4.2/KVT49L/KHICNBH21.0:user/release-keys", "REL", "KHICNBH21.0", "4.4.2", 
                "19", "19", "86519902", "1280", "720", "2.0", "2.0", "320", "160.421", "160.157", 
                "MPSS.DI.3.0-bacc40b", "3.4.0-g26e4aff-00556-g25cde7b", "Linux version 3.4.0-g26e4aff-00556-g25cde7b (builder@huangshan) (gcc version 4.7" +
    " (GCC) ) #1 SMP PREEMPT Wed Oct 29 12:09:32 CST 2014\n"
    , "Processor\t: ARMv7 Processor rev 3 (v7l)\nprocessor\t: 0\nBogoMIPS\t: 38.40\n\np" +
    "rocessor\t: 1\nBogoMIPS\t: 38.40\n\nprocessor\t: 2\nBogoMIPS\t: 38.40\n\nprocess" +
    "or\t: 3\nBogoMIPS\t: 38.40\n\nFeatures\t: swp half thumb fastmult vfp edsp neon " +
    "vfpv3 tls vfpv4 idiva idivt \nCPU implementer\t: 0x41\nCPU architecture: 7\nCPU " +
    "variant\t: 0x0\nCPU part\t: 0xc07\nCPU revision\t: 3\n\nHardware\t: Qualcomm MSM" +
    " 8226 (Flattened Device Tree)\nRevision\t: 0000\nSerial\t\t: 0000000000000000\n"
    , "liantong"
            });
            insertLib(maps,new String[] {
                "", "Lenovo", "A788t", "LenovoA788t_S15703_140624", "LENOVO", "Lenovo A788t", "A788t", "", "S104", "user", 
                "release-keys", "Android", "AndroidBuild", "pxa1l88", "armeabi-v7a", "armeabi", "Lenovo/A788t/A788t:4.3/S104/20140624.095613:user/release-keys", "REL", "LenovoA788t_S15703_140624", "4.3", 
                "18", "18", "86517502", "854", "480", "1.5", "1.5", "240", "210", "221", 
                "HL_CP_3.47.027::3.47.027::sky_ttc_rC0_v3_001_049_Lenovo_a", "3.4.39", "Linux version 3.4.39 (Android-bot@Android-server) (gcc version 4.7 (GCC) ) #2 SM" +
    "P PREEMPT Tue Jun 24 10:12:24 CST 2014\n"
    , "Processor\t: ARMv7 Processor rev 3 (v7l)\nprocessor\t: 0\nBogoMIPS\t: 2341.13\n\n" +
    "processor\t: 1\nBogoMIPS\t: 2341.13\n\nprocessor\t: 2\nBogoMIPS\t: 2341.13\n\npr" +
    "ocessor\t: 3\nBogoMIPS\t: 2341.13\n\nFeatures\t: swp half thumb fastmult vfp eds" +
    "p thumbee neon vfpv3 tls vfpv4 idiva idivt \nCPU implementer\t: 0x41\nCPU archit" +
    "ecture: 7\nCPU variant\t: 0x0\nCPU part\t: 0xc07\nCPU revision\t: 3\n\nHardware\t" +
    ": PXA1L88\nRevision\t: 0000\nSerial\t\t: 0000000000000000\n"
    , "yidong"
            });
            insertLib(maps,new String[] {
                "", "Lenovo", "A788t", "LenovoA788t_S15703_140624", "LENOVO", "Lenovo A788t", "A788t", "", "S104", "user", 
                "release-keys", "Android", "AndroidBuild", "pxa1l88", "armeabi-v7a", "armeabi", "Lenovo/A788t/A788t:4.3/S104/20140624.095613:user/release-keys", "REL", "LenovoA788t_S15703_140624", "4.3", 
                "18", "18", "86517502", "854", "480", "1.5", "1.5", "240", "210", "221", 
                "HL_CP_3.47.027::3.47.027::sky_ttc_rC0_v3_001_049_Lenovo_a", "3.4.39", "Linux version 3.4.39 (Android-bot@Android-server) (gcc version 4.7 (GCC) ) #2 SM" +
    "P PREEMPT Tue Jun 24 10:12:24 CST 2014\n"
    , "Processor\t: ARMv7 Processor rev 3 (v7l)\nprocessor\t: 0\nBogoMIPS\t: 2341.13\n\n" +
    "processor\t: 1\nBogoMIPS\t: 2341.13\n\nprocessor\t: 2\nBogoMIPS\t: 2341.13\n\npr" +
    "ocessor\t: 3\nBogoMIPS\t: 2341.13\n\nFeatures\t: swp half thumb fastmult vfp eds" +
    "p thumbee neon vfpv3 tls vfpv4 idiva idivt \nCPU implementer\t: 0x41\nCPU archit" +
    "ecture: 7\nCPU variant\t: 0x0\nCPU part\t: 0xc07\nCPU revision\t: 3\n\nHardware\t" +
    ": PXA1L88\nRevision\t: 0000\nSerial\t\t: 0000000000000000\n"
    , "yidong"
            });
            insertLib(maps,new String[] {
                "techain82_slt_cb_kk", "Lenovo", "A320t", "A320t_S105_140512", "Lenovo", "Lenovo A320t", "A320t", "", "KOT49H", "user", 
                "release-keys", "justin", "sw163-desktop", "mt6582", "armeabi-v7a", "armeabi", "Lenovo/A320t/A320t:4.4.2/KOT49H/A320t_USR_S317_1409091248:user/release-keys", "REL", "A320t_USR_S317_1409091248_MP3V1.11_BMAIN_yidong_CN", "4.4.2", 
                "19", "19", "86516302", "800", "480", "1.5", "1.5", "240", "240", "240", 
                "MOLY.LR9.W1414A.MD.LWTG.MP.V3.P33, 2014/07/26 17:18", "3.4.67", "Linux version 3.4.67 (justin@sw163-desktop) (gcc version 4.7 (GCC) ) #1 SMP PREE" +
    "MPT Tue Sep 9 12:46:28 CST 2014\n"
    , "Processor\t: ARMv7 Processor rev 3 (v7l)\nprocessor\t: 0\nBogoMIPS\t: 2590.72\n\n" +
    "processor\t: 1\nBogoMIPS\t: 2590.72\n\nprocessor\t: 2\nBogoMIPS\t: 2590.72\n\npr" +
    "ocessor\t: 3\nBogoMIPS\t: 2590.72\n\nFeatures\t: swp half thumb fastmult vfp eds" +
    "p thumbee neon vfpv3 tls vfpv4 idiva idivt \nCPU implementer\t: 0x41\nCPU archit" +
    "ecture: 7\nCPU variant\t: 0x0\nCPU part\t: 0xc07\nCPU revision\t: 3\n\nHardware\t" +
    ": MT6582\nRevision\t: 0000\nSerial\t\t: 0000000000000000\n"
    , "yidong"
            });
            insertLib(maps,new String[] {
                "techain82_slt_cb_kk", "ZTE", "P682T20", "Q507TV1.0.0B03", "ZTE", "ZTE Q507T", "P682T20", "", "KOT49H", "user", 
                "release-keys", "xzj", "sw14", "mt6582", "armeabi-v7a", "armeabi", "ZTE/P682T20/P682T20:4.4.2/KOT49H/20140818.150000:user/release-keys", "REL", "eng.xzj.1408352185", "4.4.2", 
                "19", "19", "86515702", "854", "480", "1.5", "1.5", "240", "203.2", "199.005", 
                "MOLY.LR9.W1414A.MD.LWTG.MP.V3.P33, 2014/07/28 13:25", "3.4.67", "", "Processor\t: ARMv7 Processor rev 3 (v7l)\nprocessor\t: 0\nBogoMIPS\t: 2590.72\n\n" +
    "processor\t: 1\nBogoMIPS\t: 2590.72\n\nprocessor\t: 2\nBogoMIPS\t: 2590.72\n\nFe" +
    "atures\t: swp half thumb fastmult vfp edsp thumbee neon vfpv3 tls vfpv4 idiva id" +
    "ivt \nCPU implementer\t: 0x41\nCPU architecture: 7\nCPU variant\t: 0x0\nCPU part" +
    "\t: 0xc07\nCPU revision\t: 3\n\nHardware\t: MT6582\nRevision\t: 0000\nSerial\t\t" +
    ": 0000000000000000\n"
    , "yidong"
            });
            insertLib(maps,new String[] {
                "techain82_slt_cb_kk", "Hisense", "E601M", "E601M_S03", "Hisense", "E601M", "E601M", "", "KOT49H", "user", 
                "test-keys", "wl", "sw163-desktop", "mt6582", "armeabi-v7a", "armeabi", "Hisense/E601M/E601M:4.4.2/KOT49H/L820_M00_S02:user/release-keys", "REL", "eng.wl.1409641591", "4.4.2", 
                "19", "19", "86508902", "800", "480", "1.5", "1.5", "240", "240", "240", 
                "MOLY.LR9.W1414A.MD.LWTG.MP.V3.P36, 2014/08/05 16:33", "3.4.67", "Linux version 3.4.67 (wl@sw163-desktop) (gcc version 4.7 (GCC) ) #1 SMP PREEMPT " +
    "Tue Sep 2 15:06:21 CST 2014\n"
    , "Processor\t: ARMv7 Processor rev 3 (v7l)\nprocessor\t: 0\nBogoMIPS\t: 2072.57\n\n" +
    "processor\t: 1\nBogoMIPS\t: 2072.57\n\nprocessor\t: 2\nBogoMIPS\t: 2072.57\n\npr" +
    "ocessor\t: 3\nBogoMIPS\t: 2072.57\n\nFeatures\t: swp half thumb fastmult vfp eds" +
    "p thumbee neon vfpv3 tls vfpv4 idiva idivt \nCPU implementer\t: 0x41\nCPU archit" +
    "ecture: 7\nCPU variant\t: 0x0\nCPU part\t: 0xc07\nCPU revision\t: 3\n\nHardware\t" +
    ": MT6582\nRevision\t: 0000\nSerial\t\t: 0000000000000000\n"
    , "yidong"
            });
            insertLib(maps,new String[] {
                "bird72_wet_a_jb3", "Bird", "bird72_wet_a_jb3", "i600_V1.01", "Bird", "Bird i600", "bird72_wet_a_jb3", "", "JDQ39", "user", 
                "test-keys", "shen", "builder5", "mt6572", "armeabi-v7a", "armeabi", "Bird/bird72_wet_a_jb3/bird72_wet_a_jb3:4.2.2/JDQ39/1395048064:user/test-keys", "REL", "eng.shen.1395048064", "4.2.2", 
                "17", "17", "86507001", "800", "480", "1.6500001", "1.5", "240", "160.42105", "160", 
                "MOLY.WR8.W1319.MD.TG.MP.V1.P9, 2013/12/18 13:40", "3.4.5", "Linux version 3.4.5 (shen@builder5) (gcc version 4.6.x-google 20120106 (prerelea" +
    "se) (GCC) ) #1 SMP PREEMPT Mon Mar 17 17:20:47 CST 2014\n"
    , "Processor\t: ARMv7 Processor rev 3 (v7l)\nprocessor\t: 0\nBogoMIPS\t: 1993.93\n\n" +
    "processor\t: 1\nBogoMIPS\t: 1993.93\n\nFeatures\t: swp half thumb fastmult vfp e" +
    "dsp thumbee neon vfpv3 tls vfpv4 idiva idivt \nCPU implementer\t: 0x41\nCPU arch" +
    "itecture: 7\nCPU variant\t: 0x0\nCPU part\t: 0xc07\nCPU revision\t: 3\n\nHardwar" +
    "e\t: MT6589\nRevision\t: 0000\nSerial\t\t: 0000000000000000\n"
    , "yidong"
            });
            insertLib(maps,new String[] {
                "gionee77_cu_ics2", "GiONEE", "GiONEE", "GN700W_T15", "GiONEE", "GN700W", "GiONEE", "", "IMM76D", "user", 
                "test-keys", "cdma-server", "cdma-server-desktop", "mt6577", "armeabi-v7a", "armeabi", "alps/gionee77_cu_ics2/gionee77_cu_ics2:4.0.4/IMM76D/1346774963:user/test-keys", "REL", "eng.cdma-server.1346774963", "4.0.4", 
                "15", "15", "86506201", "800", "480", "1.5", "1.5", "240", "240", "240", 
                "MAUI.11AMD.W12.22.SP.V1.P5, 2012/08/15 16:23", "3.0.13", "Linux version 3.0.13 (cdma-server@cdma-server-desktop) (gcc version 4.4.3 (GCC) " +
    ") #1 SMP PREEMPT Wed Sep 5 00:09:09 CST 2012\n"
    , "Processor\t: ARMv7 Processor rev 0 (v7l)\nprocessor\t: 0\nBogoMIPS\t: 1993.93\n\n" +
    "processor\t: 1\nBogoMIPS\t: 2000.48\n\nFeatures\t: swp half thumb fastmult vfp e" +
    "dsp thumbee neon vfpv3 \nCPU implementer\t: 0x41\nCPU architecture: 7\nCPU varia" +
    "nt\t: 0x3\nCPU part\t: 0xc09\nCPU revision\t: 0\n\nHardware\t: MT6577\nRevision\t" +
    ": 65fb8a00\nSerial\t\t: 0000000000000000\n"
    , "yidong"
            });
            insertLib(maps,new String[] {
                "MSM8226", "DOOV", "T35", "T35_11_3.06_140802", "DOOV", "DOOV T35", "T35", "", "JLS36C", "user", 
                "test-keys", "release222", "DOOV", "qcom", "armeabi-v7a", "armeabi", "DOOV/msm8226/msm8226:4.3/JLS36C/eng.release222.20140801.205722:user/test-keys", "REL", "eng.release222.20140801.205722", "4.3", 
                "18", "18", "86504002", "1280", "720", "2.0", "2.0", "320", "160.421", "160.157", 
                "QL1005_888A_V0_1_5,QL1005_888A_V0_1_5", "3.4.0-g9fb0b64-00317-g3eecfd2", "Linux version 3.4.0-g9fb0b64-00317-g3eecfd2 (release222@yep) (gcc version 4.7 (G" +
    "CC) ) #1 SMP PREEMPT Fri Aug 1 21:13:26 CST 2014\n"
    , "Processor\t: ARMv7 Processor rev 3 (v7l)\nprocessor\t: 0\nBogoMIPS\t: 38.40\n\np" +
    "rocessor\t: 1\nBogoMIPS\t: 38.40\n\nprocessor\t: 2\nBogoMIPS\t: 38.40\n\nprocess" +
    "or\t: 3\nBogoMIPS\t: 38.40\n\nFeatures\t: swp half thumb fastmult vfp edsp neon " +
    "vfpv3 tls vfpv4 idiva idivt \nCPU implementer\t: 0x41\nCPU architecture: 7\nCPU " +
    "variant\t: 0x0\nCPU part\t: 0xc07\nCPU revision\t: 3\n\nHardware\t: Qualcomm MSM" +
    " 8926\nRevision\t: 0000\nSerial\t\t: 0000000000000000\n"
    , "liantong"
            });
            insertLib(maps,new String[] {
                "cp8017_m02", "Coolpad", "cp8017_m02", "4.4.001.P1.8017", "Yulong", "Coolpad 8017", "cp8017_m02", "", "KOT49H", "user", 
                "test-keys", "root", "huangzs", "mt6582", "armeabi-v7a", "armeabi", "Coolpad/cp8017_m02/cp8017_m02:4.4.2/KOT49H/1406614256:user/test-keys", "REL", "eng.root.1406614256", "4.4.2", 
                "19", "19", "86503902", "800", "480", "1.5", "1.5", "240", "240", "240", 
                "MOLY.LR9.W1414A.MD.LWTG.MP.V3.P18, 2014/07/28 09:51", "3.4.67", "Linux version 3.4.67 (root@huangzs) (gcc version 4.7 (GCC) ) #1 SMP PREEMPT Tue " +
    "Jul 29 14:10:42 CST 2014\n"
    , "Processor\t: ARMv7 Processor rev 3 (v7l)\nprocessor\t: 0\nBogoMIPS\t: 2590.72\n\n" +
    "processor\t: 1\nBogoMIPS\t: 2590.72\n\nprocessor\t: 2\nBogoMIPS\t: 2590.72\n\npr" +
    "ocessor\t: 3\nBogoMIPS\t: 2590.72\n\nFeatures\t: swp half thumb fastmult vfp eds" +
    "p thumbee neon vfpv3 tls vfpv4 idiva idivt \nCPU implementer\t: 0x41\nCPU archit" +
    "ecture: 7\nCPU variant\t: 0x0\nCPU part\t: 0xc07\nCPU revision\t: 3\n\nHardware\t" +
    ": MT6582\nRevision\t: aaff\nSerial\t\t: 0000000000000000\n"
    , "yidong"
            });
            insertLib(maps,new String[] {
                "MSM8226", "Bird", "msm8226", "Bird_LT02_V1.1", "Bird", "Bird LT02", "msm8226", "", "JLS36C", "user", 
                "test-keys", "release220", "yep", "qcom", "armeabi-v7a", "armeabi", "Bird/msm8226/msm8226:4.3/JLS36C/eng.release220.20140718.181535:user/test-keys", "REL", "eng.release220.20140718.181535", "4.3", 
                "18", "18", "86502802", "854", "480", "1.2750001", "1.5", "240", "160.421", "159.497", 
                "QL1005_888A_V0_1_7", "3.4.0-g9fb0b64-00532-g5f27044", "Linux version 3.4.0-g9fb0b64-00532-g5f27044 (release220@yep) (gcc version 4.7 (G" +
    "CC) ) #1 SMP PREEMPT Fri Jul 18 17:11:24 CST 2014\n"
    , "Processor\t: ARMv7 Processor rev 3 (v7l)\nprocessor\t: 0\nBogoMIPS\t: 38.40\n\np" +
    "rocessor\t: 1\nBogoMIPS\t: 38.40\n\nprocessor\t: 2\nBogoMIPS\t: 38.40\n\nprocess" +
    "or\t: 3\nBogoMIPS\t: 38.40\n\nFeatures\t: swp half thumb fastmult vfp edsp neon " +
    "vfpv3 tls vfpv4 idiva idivt \nCPU implementer\t: 0x41\nCPU architecture: 7\nCPU " +
    "variant\t: 0x0\nCPU part\t: 0xc07\nCPU revision\t: 3\n\nHardware\t: Qualcomm MSM" +
    " 8926\nRevision\t: 0000\nSerial\t\t: 0000000000000000\n"
    , "yidong"
            });
            insertLib(maps,new String[] {
                "", "Lenovo", "A788t", "LenovoA788t_S15703_140624", "LENOVO", "Lenovo A788t", "A788t", "", "S104", "user", 
                "release-keys", "Android", "AndroidBuild", "pxa1l88", "armeabi-v7a", "armeabi", "Lenovo/A788t/A788t:4.3/S104/20140624.095613:user/release-keys", "REL", "LenovoA788t_S15703_140624", "4.3", 
                "18", "18", "86501902", "854", "480", "1.5", "1.5", "240", "160", "159", 
                "HL_CP_3.47.027::3.47.027::sky_ttc_rC0_v3_001_049_Lenovo_a", "3.4.39", "Linux version 3.4.39 (Android-bot@Android-server) (gcc version 4.7 (GCC) ) #2 SM" +
    "P PREEMPT Tue Jun 24 10:12:24 CST 2014\n"
    , "Processor\t: ARMv7 Processor rev 3 (v7l)\nprocessor\t: 0\nBogoMIPS\t: 2341.13\n\n" +
    "processor\t: 1\nBogoMIPS\t: 2341.13\n\nprocessor\t: 2\nBogoMIPS\t: 2341.13\n\npr" +
    "ocessor\t: 3\nBogoMIPS\t: 2341.13\n\nFeatures\t: swp half thumb fastmult vfp eds" +
    "p thumbee neon vfpv3 tls vfpv4 idiva idivt \nCPU implementer\t: 0x41\nCPU archit" +
    "ecture: 7\nCPU variant\t: 0x0\nCPU part\t: 0xc07\nCPU revision\t: 3\n\nHardware\t" +
    ": PXA1L88\nRevision\t: 0000\nSerial\t\t: 0000000000000000\n"
    , "yidong"
            });
            insertLib(maps,new String[] {
                "", "Lenovo", "A788t", "LenovoA788t_S15703_140624", "LENOVO", "Lenovo A788t", "A788t", "", "S104", "user", 
                "release-keys", "Android", "AndroidBuild", "pxa1l88", "armeabi-v7a", "armeabi", "Lenovo/A788t/A788t:4.3/S104/20140624.095613:user/release-keys", "REL", "LenovoA788t_S15703_140624", "4.3", 
                "18", "18", "86501902", "854", "480", "1.5", "1.5", "240", "160", "159", 
                "HL_CP_3.47.027::3.47.027::sky_ttc_rC0_v3_001_049_Lenovo_a", "3.4.39", "Linux version 3.4.39 (Android-bot@Android-server) (gcc version 4.7 (GCC) ) #2 SM" +
    "P PREEMPT Tue Jun 24 10:12:24 CST 2014\n"
    , "Processor\t: ARMv7 Processor rev 3 (v7l)\nprocessor\t: 0\nBogoMIPS\t: 2341.13\n\n" +
    "processor\t: 1\nBogoMIPS\t: 2341.13\n\nprocessor\t: 2\nBogoMIPS\t: 2341.13\n\npr" +
    "ocessor\t: 3\nBogoMIPS\t: 2341.13\n\nFeatures\t: swp half thumb fastmult vfp eds" +
    "p thumbee neon vfpv3 tls vfpv4 idiva idivt \nCPU implementer\t: 0x41\nCPU archit" +
    "ecture: 7\nCPU variant\t: 0x0\nCPU part\t: 0xc07\nCPU revision\t: 3\n\nHardware\t" +
    ": PXA1L88\nRevision\t: 0000\nSerial\t\t: 0000000000000000\n"
    , "yidong"
            });
            insertLib(maps,new String[] {
                "MSM8226", "Xiaomi", "dior", "KVT49L", "Xiaomi", "HM NOTE 1LTETD", "dior", "", "KVT49L", "user", 
                "release-keys", "builder", "zc-miui-ota-bd33", "qcom", "armeabi-v7a", "armeabi", "Xiaomi/dior/dior:4.4.2/KVT49L/KHICNBH11.0:user/release-keys", "REL", "KHICNBH11.0", "4.4.2", 
                "19", "19", "86498102", "1280", "720", "2.0", "2.0", "320", "160.421", "160.157", 
                "MPSS.DI.3.0-b5da158", "3.4.0-g26e4aff-00546-ge3aad6f", "Linux version 3.4.0-g26e4aff-00546-ge3aad6f (builder@huangshan) (gcc version 4.7" +
    " (GCC) ) #1 SMP PREEMPT Mon Sep 15 17:36:48 CST 2014\n"
    , "Processor\t: ARMv7 Processor rev 3 (v7l)\nprocessor\t: 0\nBogoMIPS\t: 38.40\n\np" +
    "rocessor\t: 1\nBogoMIPS\t: 38.40\n\nprocessor\t: 2\nBogoMIPS\t: 38.40\n\nprocess" +
    "or\t: 3\nBogoMIPS\t: 38.40\n\nFeatures\t: swp half thumb fastmult vfp edsp neon " +
    "vfpv3 tls vfpv4 idiva idivt \nCPU implementer\t: 0x41\nCPU architecture: 7\nCPU " +
    "variant\t: 0x0\nCPU part\t: 0xc07\nCPU revision\t: 3\n\nHardware\t: Qualcomm MSM" +
    " 8226 (Flattened Device Tree)\nRevision\t: 0000\nSerial\t\t: 0000000000000000\n"
    , "yidong"
            });
            insertLib(maps,new String[] {
                "MSM8226", "Xiaomi", "dior", "KVT49L", "Xiaomi", "HM NOTE 1LTETD", "dior", "", "KVT49L", "user", 
                "release-keys", "builder", "zc-miui-ota-bd33", "qcom", "armeabi-v7a", "armeabi", "Xiaomi/dior/dior:4.4.2/KVT49L/KHICNBH15.0:user/release-keys", "REL", "KHICNBH15.0", "4.4.2", 
                "19", "19", "86498102", "1280", "720", "2.42", "2.0", "320", "160.421", "160.157", 
                "MPSS.DI.3.0-8fbcbca", "3.4.0-g26e4aff-00547-g924b8ac", "", "Processor\t: ARMv7 Processor rev 3 (v7l)\nprocessor\t: 0\nBogoMIPS\t: 38.40\n\np" +
    "rocessor\t: 1\nBogoMIPS\t: 38.40\n\nprocessor\t: 2\nBogoMIPS\t: 38.40\n\nprocess" +
    "or\t: 3\nBogoMIPS\t: 38.40\n\nFeatures\t: swp half thumb fastmult vfp edsp neon " +
    "vfpv3 tls vfpv4 idiva idivt \nCPU implementer\t: 0x41\nCPU architecture: 7\nCPU " +
    "variant\t: 0x0\nCPU part\t: 0xc07\nCPU revision\t: 3\n\nHardware\t: Qualcomm MSM" +
    " 8226 (Flattened Device Tree)\nRevision\t: 0000\nSerial\t\t: 0000000000000000\n"
    , "yidong"
            });
            insertLib(maps,new String[] {
                "MSM8226", "ZTE", "N9180", "N9180_CNTelecom_V1.05", "ZTE", "N9180", "N9180", "", "KVT49L", "user", 
                "release-keys", "nubia", "swlab-1t042", "qcom", "armeabi-v7a", "armeabi", "ZTE\n9180\n9180:4.4.2/KVT49L/eng.nubia.20140801.191545:user/release-keys", "REL", "eng.nubia.20140801.191545", "4.4.2", 
                "19", "19", "86496502", "1280", "720", "2.0", "2.0", "320", "309.966", "312.615", 
                "N9180_Z85_CN_HSXNIAID11H001", "3.4.0-g1520d93-00060-gf327851", "Linux version 3.4.0-g1520d93-00060-gf327851 (nubia@swlab-1t042) (gcc version 4.7" +
    " (GCC) ) #1 SMP PREEMPT Fri Aug 1 19:43:04 CST 2014\n"
    , "Processor\t: ARMv7 Processor rev 3 (v7l)\nprocessor\t: 0\nBogoMIPS\t: 38.40\n\np" +
    "rocessor\t: 1\nBogoMIPS\t: 38.40\n\nprocessor\t: 2\nBogoMIPS\t: 38.40\n\nprocess" +
    "or\t: 3\nBogoMIPS\t: 38.40\n\nFeatures\t: swp half thumb fastmult vfp edsp neon " +
    "vfpv3 tls vfpv4 idiva idivt \nCPU implementer\t: 0x41\nCPU architecture: 7\nCPU " +
    "variant\t: 0x0\nCPU part\t: 0xc07\nCPU revision\t: 3\n\nHardware\t: Qualcomm MSM" +
    "8926\nRevision\t: 0000\nSerial\t\t: 0000000000000000\n"
    , "yidong"
            });
            insertLib(maps,new String[] {
                "7270_W00", "Coolpad", "Coolpad7270_W00", "4.2.004.P2.140319.7270_W00", "Coolpad", "Coolpad 7270_W00", "7270_W00", "", "JDQ39", "user", 
                "release-keys", "mudingyu", "compiler5-desktop", "mt6589", "armeabi-v7a", "armeabi", "Coolpad/7270_W00/Coolpad7270_W00:4.2.2/JDQ39/1395218917:user/release-keys", "REL", "eng.mudingyu.1395218917", "4.2.2", 
                "17", "17", "86491102", "854", "480", "1.3312501", "1.3312501", "213", "213", "213", 
                "D605A_GSM3_W18_MP_V0.0.3_S0120, 2014/01/20 15:42", "3.4.5", "Linux version 3.4.5 (mudingyu@compiler5-desktop) (gcc version 4.6.x-google 20120" +
    "106 (prerelease) (GCC) ) #1 SMP PREEMPT Wed Mar 19 16:47:43 CST 2014\n"
    , "Processor\t: ARMv7 Processor rev 2 (v7l)\nprocessor\t: 0\nBogoMIPS\t: 2439.94\n\n" +
    "processor\t: 1\nBogoMIPS\t: 2439.94\n\nprocessor\t: 2\nBogoMIPS\t: 2439.94\n\nFe" +
    "atures\t: swp half thumb fastmult vfp edsp thumbee neon vfpv3 tls vfpv4 idiva id" +
    "ivt \nCPU implementer\t: 0x41\nCPU architecture: 7\nCPU variant\t: 0x0\nCPU part" +
    "\t: 0xc07\nCPU revision\t: 2\n\nHardware\t: MT6589\nRevision\t: 0000\nSerial\t\t" +
    ": 0000000000000000\n"
    , "liantong"
            });
            insertLib(maps,new String[] {
                "7270_W00", "Coolpad", "Coolpad7270_W00", "4.2.005.P2.140704.7270_W00", "Coolpad", "Coolpad 7270_W00", "7270_W00", "", "JDQ39", "user", 
                "release-keys", "jenkins", "80-23", "mt6589", "armeabi-v7a", "armeabi", "Coolpad/7270_W00/Coolpad7270_W00:4.2.2/JDQ39/1404458825:user/release-keys", "REL", "eng.jenkins.1404458825", "4.2.2", 
                "17", "17", "86491102", "854", "480", "1.3312501", "1.3312501", "213", "213", "213", 
                "D605A_GSM3_W18_MP_V0.0.3_S0120, 2014/01/20 15:42", "3.4.5", "Linux version 3.4.5 (jenkins@80-23) (gcc version 4.6.x-google 20120106 (prerelea" +
    "se) (GCC) ) #1 SMP PREEMPT Fri Jul 4 15:26:25 CST 2014\n"
    , "Processor\t: ARMv7 Processor rev 2 (v7l)\nprocessor\t: 0\nBogoMIPS\t: 2439.94\n\n" +
    "processor\t: 1\nBogoMIPS\t: 2439.94\n\nprocessor\t: 2\nBogoMIPS\t: 2439.94\n\npr" +
    "ocessor\t: 3\nBogoMIPS\t: 2439.94\n\nFeatures\t: swp half thumb fastmult vfp eds" +
    "p thumbee neon vfpv3 tls vfpv4 idiva idivt \nCPU implementer\t: 0x41\nCPU archit" +
    "ecture: 7\nCPU variant\t: 0x0\nCPU part\t: 0xc07\nCPU revision\t: 2\n\nHardware\t" +
    ": MT6589\nRevision\t: 0000\nSerial\t\t: 0000000000000000\n"
    , "yidong"
            });
            insertLib(maps,new String[] {
                "m01_tcl_mp", "TCL", "TCL_P301M", "TCL_P301M_V1.0", "TCL", "TCL P301M", "TCL_P301M", "", "KOT49H", "user", 
                "release-keys", "root", "hunter", "mt6582", "armeabi-v7a", "armeabi", "TCL/TCL_P301M/TCL_P301M:4.4.2/KOT49H/1404282700:user/release-keys", "REL", "eng.root.1407226702", "4.4.2", 
                "19", "19", "86490902", "800", "480", "1.5", "1.5", "240", "240", "240", 
                "MOLY.LR9.W1414A.MD.LWTG.MP.V3.P18, 2014/07/29 15:03", "3.4.67", "", "Processor\t: ARMv7 Processor rev 3 (v7l)\nprocessor\t: 0\nBogoMIPS\t: 2590.72\n\n" +
    "processor\t: 1\nBogoMIPS\t: 2590.72\n\nprocessor\t: 2\nBogoMIPS\t: 2590.72\n\nFe" +
    "atures\t: swp half thumb fastmult vfp edsp thumbee neon vfpv3 tls vfpv4 idiva id" +
    "ivt \nCPU implementer\t: 0x41\nCPU architecture: 7\nCPU variant\t: 0x0\nCPU part" +
    "\t: 0xc07\nCPU revision\t: 3\n\nHardware\t: MT6582\nRevision\t: aaff\nSerial\t\t" +
    ": 0000000000000000\n"
    , "yidong"
            });
            insertLib(maps,new String[] {
                "tcl_p331m", "TCL", "TCL_P331M", "TCL_P331M_V1.0", "TCL", "TCL P331M", "TCL_P331M", "", "KOT49H", "user", 
                "release-keys", "root", "hunter", "mt6582", "armeabi-v7a", "armeabi", "TCL/TCL_P331M/TCL_P331M:4.4.2/KOT49H/1404294483:user/release-keys", "REL", "eng.root.1407220861", "4.4.2", 
                "19", "19", "86490802", "854", "480", "1.5", "1.5", "240", "240", "240", 
                "MOLY.LR9.W1414A.MD.LWTG.MP.V3.P19, 2014/07/30 13:44", "3.4.67", "Linux version 3.4.67 (root@hunter) (gcc version 4.7 (GCC) ) #1 SMP PREEMPT Tue A" +
    "ug 5 14:40:47 CST 2014\n"
    , "Processor\t: ARMv7 Processor rev 3 (v7l)\nprocessor\t: 0\nBogoMIPS\t: 2072.57\n\n" +
    "processor\t: 1\nBogoMIPS\t: 2072.57\n\nprocessor\t: 2\nBogoMIPS\t: 2072.57\n\nFe" +
    "atures\t: swp half thumb fastmult vfp edsp thumbee neon vfpv3 tls vfpv4 idiva id" +
    "ivt \nCPU implementer\t: 0x41\nCPU architecture: 7\nCPU variant\t: 0x0\nCPU part" +
    "\t: 0xc07\nCPU revision\t: 3\n\nHardware\t: MT6582\nRevision\t: aaff\nSerial\t\t" +
    ": 0000000000000000\n"
    , "yidong"
            });
            insertLib(maps,new String[] {
                "MSM8974", "Xiaomi", "cancro", "KTU84P", "Xiaomi", "MI 4W", "cancro_wc_lte", "", "KTU84P", "user", 
                "release-keys", "builder", "zc-miui-ota-bd27", "qcom", "armeabi-v7a", "armeabi", "Xiaomi/cancro_wc_lte/cancro:4.4.4/KTU84P/V6.2.1.0.KXDCNBK:user/release-keys", "REL", "V6.2.1.0.KXDCNBK", "4.4.4", 
                "19", "19", "86489502", "1920", "1080", "3.0", "3.0", "480", "449.704", "447.412", 
                "MPSS.DI.3.0-a2ac5b4", "3.4.0-gdfdaba7-01182-g9b25266", "Linux version 3.4.0-gdfdaba7-01182-g9b25266 (builder@taishan) (gcc version 4.7 (" +
    "GCC) ) #1 SMP PREEMPT Wed Nov 12 20:29:39 CST 2014\n"
    , "Processor\t: ARMv7 Processor rev 1 (v7l)\nprocessor\t: 0\nBogoMIPS\t: 38.40\n\np" +
    "rocessor\t: 1\nBogoMIPS\t: 38.40\n\nprocessor\t: 2\nBogoMIPS\t: 38.40\n\nprocess" +
    "or\t: 3\nBogoMIPS\t: 38.40\n\nFeatures\t: swp half thumb fastmult vfp edsp neon " +
    "vfpv3 tls vfpv4 idiva idivt \nCPU implementer\t: 0x51\nCPU architecture: 7\nCPU " +
    "variant\t: 0x2\nCPU part\t: 0x06f\nCPU revision\t: 1\n\nHardware\t: Qualcomm MSM" +
    "8974PRO-AC\nRevision\t: 0000\nSerial\t\t: 0000000000000000\n"
    , "yidong"
            });
            insertLib(maps,new String[] {
                "MSM8974", "Xiaomi", "cancro", "KVT49L", "Xiaomi", "MI 4W", "cancro", "", "KVT49L", "user", 
                "release-keys", "builder", "wcc-miui-ota-bd17", "qcom", "armeabi-v7a", "armeabi", "Xiaomi/cancro/cancro:4.4.2/KVT49L/KXDCNBF24.0:user/release-keys", "REL", "KXDCNBF24.0", "4.4.2", 
                "19", "19", "86489502", "1920", "1080", "3.63", "3.0", "480", "449.704", "447.412", 
                "MPSS.DI.3.0-02dcd79", "3.4.0-g26e4aff-00912-g1f7263f", "Linux version 3.4.0-g26e4aff-00912-g1f7263f (builder@taishan) (gcc version 4.7 (" +
    "GCC) ) #1 SMP PREEMPT Fri Aug 8 14:27:21 CST 2014\n"
    , "Processor\t: ARMv7 Processor rev 1 (v7l)\nprocessor\t: 0\nBogoMIPS\t: 38.40\n\np" +
    "rocessor\t: 1\nBogoMIPS\t: 38.40\n\nprocessor\t: 2\nBogoMIPS\t: 38.40\n\nprocess" +
    "or\t: 3\nBogoMIPS\t: 38.40\n\nFeatures\t: swp half thumb fastmult vfp edsp neon " +
    "vfpv3 tls vfpv4 idiva idivt \nCPU implementer\t: 0x51\nCPU architecture: 7\nCPU " +
    "variant\t: 0x2\nCPU part\t: 0x06f\nCPU revision\t: 1\n\nHardware\t: Qualcomm MSM" +
    " 8974 (Flattened Device Tree)\nRevision\t: 0000\nSerial\t\t: 0000000000000000\n"
    , "yidong"
            });
            insertLib(maps,new String[] {
                "MSM8226", "OPPO", "R7007", "R7007_11_140905", "OPPO", "R7007", "R7007", "", "JLS36C", "user", 
                "release-keys", "", "ubuntu", "qcom", "armeabi-v7a", "armeabi", "OPPO/R7007/R7007:4.3/JLS36C/1390465867:user/release-keys", "REL", "eng..20140905.222904", "4.3", 
                "18", "18", "86489202", "1280", "720", "2.0", "2.0", "320", "309.966", "312.615", 
                "Q_V1_P14", "3.4.0", "Linux version 3.4.0 (root@ubuntu) (gcc version 4.7 (GCC) ) #1 SMP PREEMPT Fri Se" +
    "p 5 22:45:27 CST 2014\n"
    , "Processor\t: ARMv7 Processor rev 3 (v7l)\nprocessor\t: 0\nBogoMIPS\t: 38.40\n\np" +
    "rocessor\t: 1\nBogoMIPS\t: 38.40\n\nprocessor\t: 2\nBogoMIPS\t: 38.40\n\nprocess" +
    "or\t: 3\nBogoMIPS\t: 38.40\n\nFeatures\t: swp half thumb fastmult vfp edsp neon " +
    "vfpv3 tls vfpv4 idiva idivt \nCPU implementer\t: 0x41\nCPU architecture: 7\nCPU " +
    "variant\t: 0x0\nCPU part\t: 0xc07\nCPU revision\t: 3\n\nHardware\t: Qualcomm MSM" +
    " 8226 (Flattened Device Tree)\nRevision\t: 0000\nSerial\t\t: 0000000000000000\n"
    , "yidong"
            });
            insertLib(maps,new String[] {
                "MSM8226", "OPPO", "R7007", "R7007_11_141024", "OPPO", "R7007", "R7007", "", "JLS36C", "user", 
                "release-keys", "root", "ubuntu", "qcom", "armeabi-v7a", "armeabi", "OPPO/R7007/R7007:4.3/JLS36C/1390465867:user/release-keys", "REL", "eng.root.20141024.095637", "4.3", 
                "18", "18", "86489202", "1280", "720", "2.0", "2.0", "320", "309.966", "312.615", 
                "Q_V1_P14", "3.4.0", "Linux version 3.4.0 (root@ubuntu) (gcc version 4.7 (GCC) ) #1 SMP PREEMPT Fri Oc" +
    "t 24 10:10:28 CST 2014\n"
    , "Processor\t: ARMv7 Processor rev 3 (v7l)\nprocessor\t: 0\nBogoMIPS\t: 38.40\n\np" +
    "rocessor\t: 1\nBogoMIPS\t: 38.40\n\nprocessor\t: 2\nBogoMIPS\t: 38.40\n\nprocess" +
    "or\t: 3\nBogoMIPS\t: 38.40\n\nFeatures\t: swp half thumb fastmult vfp edsp neon " +
    "vfpv3 tls vfpv4 idiva idivt \nCPU implementer\t: 0x41\nCPU architecture: 7\nCPU " +
    "variant\t: 0x0\nCPU part\t: 0xc07\nCPU revision\t: 3\n\nHardware\t: Qualcomm MSM" +
    " 8226 (Flattened Device Tree)\nRevision\t: 0000\nSerial\t\t: 0000000000000000\n"
    , "yidong"
            });
            insertLib(maps,new String[] {
                "MSM8226", "OPPO", "R6007", "R6007_11_141204", "OPPO", "R6007", "R6007", "", "JLS36C", "user", 
                "release-keys", "", "ubuntu", "qcom", "armeabi-v7a", "armeabi", "OPPO/R6007/R6007:4.3/JLS36C/1390465867:user/release-keys", "REL", "eng..20141204.172433", "4.3", 
                "18", "18", "86489102", "1280", "720", "2.0", "2.0", "320", "309.966", "312.615", 
                "Q_V1_P14", "3.4.0", "Linux version 3.4.0 (root@ubuntu) (gcc version 4.7 (GCC) ) #1 SMP PREEMPT Thu De" +
    "c 4 17:37:33 CST 2014\n"
    , "Processor\t: ARMv7 Processor rev 3 (v7l)\nprocessor\t: 0\nBogoMIPS\t: 38.40\n\np" +
    "rocessor\t: 1\nBogoMIPS\t: 38.40\n\nprocessor\t: 2\nBogoMIPS\t: 38.40\n\nprocess" +
    "or\t: 3\nBogoMIPS\t: 38.40\n\nFeatures\t: swp half thumb fastmult vfp edsp neon " +
    "vfpv3 tls vfpv4 idiva idivt \nCPU implementer\t: 0x41\nCPU architecture: 7\nCPU " +
    "variant\t: 0x0\nCPU part\t: 0xc07\nCPU revision\t: 3\n\nHardware\t: Qualcomm MSM" +
    " 8226 (Flattened Device Tree)\nRevision\t: 0000\nSerial\t\t: 0000000000000000\n"
    , "yidong"
            });
            insertLib(maps,new String[] {
                "MSM8226", "OPPO", "R6007", "R6007_11_140806", "OPPO", "R6007", "R6007", "", "JLS36C", "user", 
                "release-keys", "", "ubuntu", "qcom", "armeabi-v7a", "armeabi", "OPPO/R6007/R6007:4.3/JLS36C/1390465867:user/release-keys", "REL", "eng..20140806.000440", "4.3", 
                "18", "18", "86489102", "1280", "720", "1.76", "2.0", "320", "309.966", "312.615", 
                "Q_V1_P14", "3.4.0", "Linux version 3.4.0 (root@ubuntu) (gcc version 4.7 (GCC) ) #1 SMP PREEMPT Wed Au" +
    "g 6 00:18:22 CST 2014\n"
    , "Processor\t: ARMv7 Processor rev 3 (v7l)\nprocessor\t: 0\nBogoMIPS\t: 38.40\n\np" +
    "rocessor\t: 1\nBogoMIPS\t: 38.40\n\nprocessor\t: 2\nBogoMIPS\t: 38.40\n\nprocess" +
    "or\t: 3\nBogoMIPS\t: 38.40\n\nFeatures\t: swp half thumb fastmult vfp edsp neon " +
    "vfpv3 tls vfpv4 idiva idivt \nCPU implementer\t: 0x41\nCPU architecture: 7\nCPU " +
    "variant\t: 0x0\nCPU part\t: 0xc07\nCPU revision\t: 3\n\nHardware\t: Qualcomm MSM" +
    " 8226 (Flattened Device Tree)\nRevision\t: 0000\nSerial\t\t: 0000000000000000\n"
    , "yidong"
            });
            insertLib(maps,new String[] {
                "yulong82_wet_jb5", "Coolpad", "Coolpad8670", "4.2.041.P1.141119.8670", "Coolpad", "Coolpad 8670", "Coolpad8670", "", "JDQ39", "user", 
                "release-keys", "mine", "ubuntu", "mt6582", "armeabi-v7a", "armeabi", "Coolpad/Coolpad8670/Coolpad8670:4.2.2/JDQ39/4.2.041.P1.141119.8670:user/release-" +
    "keys"
    , "REL", "4.2.041.P1.141119.8670", "4.2.2", 
                "17", "17", "86483702", "960", "540", "1.5", "1.5", "240", "240", "240", 
                "MOLY.WR8.W1319.MD.TG.MP.V45, 2014/11/19 23:03", "3.4.5", "Linux version 3.4.5 (mine@ubuntu) (gcc version 4.6.x-google 20120106 (prerelease" +
    ") (GCC) ) #1 SMP PREEMPT Wed Nov 19 23:15:12 CST 2014\n"
    , "Processor\t: ARMv7 Processor rev 3 (v7l)\nprocessor\t: 0\nBogoMIPS\t: 2590.72\n\n" +
    "processor\t: 1\nBogoMIPS\t: 2590.72\n\nprocessor\t: 2\nBogoMIPS\t: 2590.72\n\npr" +
    "ocessor\t: 3\nBogoMIPS\t: 2590.72\n\nFeatures\t: swp half thumb fastmult vfp eds" +
    "p thumbee neon vfpv3 tls vfpv4 idiva idivt \nCPU implementer\t: 0x41\nCPU archit" +
    "ecture: 7\nCPU variant\t: 0x0\nCPU part\t: 0xc07\nCPU revision\t: 3\n\nHardware\t" +
    ": MT6582\nRevision\t: 0000\nSerial\t\t: 0000000000000000\n"
    , "liantong"
            });
            insertLib(maps,new String[] {
                "yulong82_wet_jb5", "Coolpad", "Coolpad8670", "4.2.041.P1.141119.8670", "Coolpad", "Coolpad 8670", "Coolpad8670", "", "JDQ39", "user", 
                "release-keys", "mine", "ubuntu", "mt6582", "armeabi-v7a", "armeabi", "Coolpad/Coolpad8670/Coolpad8670:4.2.2/JDQ39/4.2.041.P1.141119.8670:user/release-" +
    "keys"
    , "REL", "4.2.041.P1.141119.8670", "4.2.2", 
                "17", "17", "86483702", "540", "960", "1.875", "1.5", "240", "240", "240", 
                "MOLY.WR8.W1319.MD.TG.MP.V45, 2014/11/19 23:03", "3.4.5", "Linux version 3.4.5 (mine@ubuntu) (gcc version 4.6.x-google 20120106 (prerelease" +
    ") (GCC) ) #1 SMP PREEMPT Wed Nov 19 23:15:12 CST 2014\n"
    , "Processor\t: ARMv7 Processor rev 3 (v7l)\nprocessor\t: 0\nBogoMIPS\t: 2590.72\n\n" +
    "processor\t: 1\nBogoMIPS\t: 2590.72\n\nprocessor\t: 2\nBogoMIPS\t: 2590.72\n\npr" +
    "ocessor\t: 3\nBogoMIPS\t: 2590.72\n\nFeatures\t: swp half thumb fastmult vfp eds" +
    "p thumbee neon vfpv3 tls vfpv4 idiva idivt \nCPU implementer\t: 0x41\nCPU archit" +
    "ecture: 7\nCPU variant\t: 0x0\nCPU part\t: 0xc07\nCPU revision\t: 3\n\nHardware\t" +
    ": MT6582\nRevision\t: 0000\nSerial\t\t: 0000000000000000\n"
    , "yidong"
            });
            insertLib(maps,new String[] {
                "sp8825c2", "meetuu", "s9_1602", "T6GUANGXIN1602_3.97L2_CN_140530", "meetuu", "M5C", "s9_1602", "", "IML74K", "user", 
                "test-keys", "jenkins", "relserver1", "sc8825", "armeabi-v7a", "armeabi", "T6_6825C_SC2330B_GUANGXIN_3.97L2_CN_16+2_RC_140530", "REL", "81", "4.0.3", 
                "15", "15", "86483512", "800", "480", "1.2750001", "1.5", "240", "225.77777", "211.66667", 
                "DM_BASE_13B_W13.34\nsc6825_modem\n08-24-2013 21:44:14", "3.0.8", "Linux version 3.0.8 (jenkins@relserver1) (gcc version 4.4.3 (GCC) ) #1 SMP PREEM" +
    "PT Fri May 30 12:30:28 CST 2014\n"
    , "Processor\t: Quad ARMv7 Processor rev 1 (v7l)\nprocessor\t: 0\nBogoMIPS\t: 2048\n" +
    "\nprocessor\t: 1\nBogoMIPS\t: 2048\n\nprocessor\t: 2\nBogoMIPS\t: 2048\n\nproces" +
    "sor\t: 3\nBogoMIPS\t: 2048\n\nFeatures\t: swp half thumb fastmult vfp edsp thumb" +
    "ee neon vfpv3 \nCPU implementer\t: 0x41\nCPU architecture: 7\nCPU variant\t: 0x0" +
    "\nCPU part\t: 0xc05\nCPU revision\t: 1\n\nHardware\t: MTK6589T\nRevision\t: 0000" +
    "\nSerial\t\t: 0000000000000000\n"
    , "yidong"
            });
            insertLib(maps,new String[] {
                "sp8830ec", "Lenovo", "A388t", "MocorDroid4.1.2", "LENOVO", "Lenovo A388t", "A388t", "", "MocorDroid4.1.2", "user", 
                "test-keys", "", "queen-desktop", "sc8830", "armeabi-v7a", "armeabi", "Lenovo/A388t/A388t:4.1.2/MocorDroid4.1.2/A388t_S163_131212.20140605:user/release" +
    "-keys"
    , "REL", "eng..20140605.184304", "4.1.2", 
                "16", "16", "86482802", "854", "480", "1.5", "1.5", "240", "254", "271.145", 
                "TM_BASE_13B_W13.42_P6\nsc8830_modem\n11-20-2013 17:44:36", "3.4.5", "Linux version 3.4.5 (queen@queen-desktop) (gcc version 4.6.x-google 20120106 (pr" +
    "erelease) (GCC) ) #1 SMP PREEMPT Thu Jun 5 17:54:12 CST 2014\n"
    , "Processor\t: ARMv7 Processor rev 4 (v7l)\nprocessor\t: 0\nBogoMIPS\t: 2000.48\n\n" +
    "processor\t: 1\nBogoMIPS\t: 2000.48\n\nprocessor\t: 2\nBogoMIPS\t: 1993.93\n\nFe" +
    "atures\t: swp half thumb fastmult vfp edsp neon vfpv3 tls vfpv4 idiva idivt \nCP" +
    "U implementer\t: 0x41\nCPU architecture: 7\nCPU variant\t: 0x0\nCPU part\t: 0xc0" +
    "7\nCPU revision\t: 4\n\nHardware\t: sc8830\nRevision\t: 0000\nSerial\t\t: 000000" +
    "0000000000\n"
    , "yidong"
            });
            insertLib(maps,new String[] {
                "sp8830ec", "Lenovo", "A388t", "MocorDroid4.1.2", "LENOVO", "Lenovo A388t", "A388t", "", "MocorDroid4.1.2", "user", 
                "test-keys", "", "queen-desktop", "sc8830", "armeabi-v7a", "armeabi", "Lenovo/A388t/A388t:4.1.2/MocorDroid4.1.2/A388t_S163_131212.20140320:user/release" +
    "-keys"
    , "REL", "eng..20140321.073153", "4.1.2", 
                "16", "16", "86482802", "854", "480", "1.5", "1.5", "240", "254", "271.145", 
                "TM_BASE_13B_W13.42_P6\nsc8830_modem\n11-20-2013 17:44:36", "3.4.5", "Linux version 3.4.5 (queen@queen-desktop) (gcc version 4.6.x-google 20120106 (pr" +
    "erelease) (GCC) ) #1 SMP PREEMPT Fri Mar 21 07:01:24 CST 2014\n"
    , "Processor\t: ARMv7 Processor rev 4 (v7l)\nprocessor\t: 0\nBogoMIPS\t: 2000.48\n\n" +
    "processor\t: 1\nBogoMIPS\t: 2000.48\n\nprocessor\t: 2\nBogoMIPS\t: 1993.93\n\npr" +
    "ocessor\t: 3\nBogoMIPS\t: 1987.37\n\nFeatures\t: swp half thumb fastmult vfp eds" +
    "p neon vfpv3 tls vfpv4 idiva idivt \nCPU implementer\t: 0x41\nCPU architecture: " +
    "7\nCPU variant\t: 0x0\nCPU part\t: 0xc07\nCPU revision\t: 4\n\nHardware\t: sc883" +
    "0\nRevision\t: 0000\nSerial\t\t: 0000000000000000\n"
    , "liantong"
            });
            insertLib(maps,new String[] {
                "sp8830ec", "BIRD", "sp8830ec", "MocorDroid4.1.2", "BIRD", "Bird T9609", "st800_bird", "", "MocorDroid4.1.2", "user", 
                "test-keys", "", "queen-desktop", "sc8830", "armeabi-v7a", "armeabi", "BIRD/st800_bird/sp8830ec:4.3/MocorDroid4.1.2/eng..20140617.145607:user/test-keys", "REL", "eng..20140617.145607", "4.3", 
                "16", "16", "86482702", "854", "480", "1.9499999", "1.5", "240", "225.77777", "225.95416", 
                "TM_BASE_13B_W14.04_P1\nsc8830_modem\n02-24-2014 19:17:11", "3.4.5", "Linux version 3.4.5 (queen@queen-desktop) (gcc version 4.6.x-google 20120106 (pr" +
    "erelease) (GCC) ) #1 SMP PREEMPT Tue Jun 17 15:00:53 CST 2014\n"
    , "Processor\t: ARMv7 Processor rev 4 (v7l)\nprocessor\t: 0\nBogoMIPS\t: 2000.48\n\n" +
    "processor\t: 1\nBogoMIPS\t: 2000.48\n\nprocessor\t: 2\nBogoMIPS\t: 1993.93\n\npr" +
    "ocessor\t: 3\nBogoMIPS\t: 1987.37\n\nFeatures\t: swp half thumb fastmult vfp eds" +
    "p neon vfpv3 tls vfpv4 idiva idivt \nCPU implementer\t: 0x41\nCPU architecture: " +
    "7\nCPU variant\t: 0x0\nCPU part\t: 0xc07\nCPU revision\t: 4\n\nHardware\t: sc883" +
    "0\nRevision\t: 0000\nSerial\t\t: 0000000000000000\n"
    , "yidong"
            });
            insertLib(maps,new String[] {
                "yulong82_we_jb5", "Coolpad", "Coolpad7295C", "4.2.036.P1.140325.7295C", "Coolpad", "Coolpad 7295C", "Coolpad7295C", "", "JDQ39", "user", 
                "release-keys", "mine", "mine", "mt6582", "armeabi-v7a", "armeabi", "Coolpad/Coolpad7295C/Coolpad7295C:4.2.2/JDQ39/4.2.036.P1.140325.7295C:user/relea" +
    "se-keys"
    , "REL", "4.2.036.P1.140325.7295C", "4.2.2", 
                "17", "17", "86482102", "960", "540", "1.5", "1.5", "240", "240", "240", 
                "MOLY.WR8.W1315.MD.WG.MP.V15.P1, 2014/03/25 18:13", "3.4.5", "Linux version 3.4.5 (mine@mine) (gcc version 4.6.x-google 20120106 (prerelease) " +
    "(GCC) ) #1 SMP PREEMPT Tue Mar 25 18:16:57 CST 2014\n"
    , "Processor\t: ARMv7 Processor rev 3 (v7l)\nprocessor\t: 0\nBogoMIPS\t: 2590.72\n\n" +
    "processor\t: 1\nBogoMIPS\t: 2590.72\n\nprocessor\t: 2\nBogoMIPS\t: 2590.72\n\npr" +
    "ocessor\t: 3\nBogoMIPS\t: 2590.72\n\nFeatures\t: swp half thumb fastmult vfp eds" +
    "p thumbee neon vfpv3 tls vfpv4 idiva idivt \nCPU implementer\t: 0x41\nCPU archit" +
    "ecture: 7\nCPU variant\t: 0x0\nCPU part\t: 0xc07\nCPU revision\t: 3\n\nHardware\t" +
    ": MT6582\nRevision\t: 0000\nSerial\t\t: 0000000000000000\n"
    , "yidong"
            });
            insertLib(maps,new String[] {
                "mx3", "Meizu", "mx3", "Flyme OS 3.5.2 (A19422)", "Meizu", "M355", "meizu_mx3", "", "JOP40D", "user", 
                "release-keys", "flyme", "mz-builder-4", "mx3", "armeabi-v7a", "armeabi", "Meizu/meizu_mx3/mx3:4.2.1/JOP40D/m35x.Flyme_OS_3.5.2.19422:user/release-keys", "REL", "m35x.Flyme_OS_3.5.2.19422", "4.2.1", 
                "17", "17", "86479302", "1800", "1080", "2.5", "2.5", "400", "415.636", "415.636", 
                "W12.45-30", "3.4.43-user-g3c826da", "Linux version 3.4.43-user-g3c826da (mobileapp@mobileapp) (gcc version 4.6.x-goog" +
    "le 20120106 (prerelease) (GCC) ) #2 SMP PREEMPT Tue Aug 26 17:53:20 CST 2014\n"
    , "Processor\t: ARMv7 Processor rev 3 srev 0x23 (v7l)\nprocessor\t: 0\nCluster\t\t:" +
    " CA15\nBogoMIPS\t: 1590.88\n\nprocessor\t: 1\nCluster\t\t: CA15\nBogoMIPS\t: 159" +
    "0.88\n\nprocessor\t: 2\nCluster\t\t: CA15\nBogoMIPS\t: 1590.88\n\nprocessor\t: 3" +
    "\nCluster\t\t: CA15\nBogoMIPS\t: 1590.88\n\nFeatures\t: swp half thumb fastmult " +
    "vfp edsp neon vfpv3 tls vfpv4 idiva idivt \nCPU implementer\t: 0x41\nCPU archite" +
    "cture: 7\nCPU variant\t: 0x2\nCPU part\t: 0xc0f\nCPU revision\t: 3\nCPU asv grou" +
    "p\t: 3\nCPU asv version\t: 1\nCPU boot cluster: CA15\n\nHardware\t: MX3\nRevisio" +
    "n\t: 5410\nDMEM\t\t: D25\nSerial\t\t: 0000000000000000\n"
    , "yidong"
            });
            insertLib(maps,new String[] {
                "mx3", "Meizu", "mx3", "Flyme OS 3.5.2 (A19220)", "Meizu", "M355", "meizu_mx3", "", "JOP40D", "user", 
                "release-keys", "flyme", "mz-builder-1", "mx3", "armeabi-v7a", "armeabi", "Meizu/meizu_mx3/mx3:4.2.1/JOP40D/m35x.Flyme_OS_3.5.2.19220:user/release-keys", "REL", "m35x.Flyme_OS_3.5.2.19220", "4.2.1", 
                "17", "17", "86479302", "1800", "1080", "2.5", "2.5", "400", "415.636", "415.636", 
                "W12.45-30", "3.4.43-user-gea3150d", "Linux version 3.4.43-user-gea3150d (mobileapp@mobileapp) (gcc version 4.6.x-goog" +
    "le 20120106 (prerelease) (GCC) ) #2 SMP PREEMPT Mon Apr 21 09:41:49 CST 2014\n"
    , "Processor\t: ARMv7 Processor rev 2 srev 0x23 (v7l)\nprocessor\t: 0\nCluster\t\t:" +
    " CA7\nBogoMIPS\t: 1590.88\n\nprocessor\t: 1\nCluster\t\t: CA7\nBogoMIPS\t: 1590." +
    "88\n\nprocessor\t: 2\nCluster\t\t: CA7\nBogoMIPS\t: 1590.88\n\nprocessor\t: 3\nC" +
    "luster\t\t: CA7\nBogoMIPS\t: 1590.88\n\nFeatures\t: swp half thumb fastmult vfp " +
    "edsp neon vfpv3 tls vfpv4 idiva idivt \nCPU implementer\t: 0x41\nCPU architectur" +
    "e: 7\nCPU variant\t: 0x0\nCPU part\t: 0xc07\nCPU revision\t: 2\nCPU asv group\t:" +
    " 5\nCPU asv version\t: 1\nCPU boot cluster: CA15\n\nHardware\t: MX3\nRevision\t:" +
    " 5410\nDMEM\t\t: D25\nSerial\t\t: 0000000000000000\n"
    , "yidong"
            });
            insertLib(maps,new String[] {
                "alston_tddopen", "Lenovo", "A808t", "VIBEUI_V2.0_1430_ST_A808t", "LENOVO", "Lenovo A808t", "alston_tddopen", "", "KOT49H", "user", 
                "release-keys", "buildslave", "xmws53", "mt6592", "armeabi-v7a", "armeabi", "Lenovo/alston_tddopen/A808t:4.4.2/KOT49H/VIBEUI_V2.0_1430_ST_A808t.:user/release" +
    "-keys"
    , "REL", "VIBEUI_V2.0_1430_ST_A808t", "4.4.2", 
                "19", "19", "86478302", "1280", "720", "2.3", "2.0", "320", "320", "320", 
                "A808T.V29, 2014/06/12 17:42", "3.4.67", "Linux version 3.4.67 (buildslave@xmws53) (gcc version 4.7 (GCC) ) #1 SMP PREEMPT" +
    " Thu Jul 24 13:47:07 CST 2014\n"
    , "Processor\t: ARMv7 Processor rev 4 (v7l)\nprocessor\t: 0\nBogoMIPS\t: 2273.59\n\n" +
    "processor\t: 1\nBogoMIPS\t: 2273.59\n\nprocessor\t: 2\nBogoMIPS\t: 2273.59\n\npr" +
    "ocessor\t: 3\nBogoMIPS\t: 2273.59\n\nFeatures\t: swp half thumb fastmult vfp eds" +
    "p thumbee neon vfpv3 tls vfpv4 idiva idivt \nCPU implementer\t: 0x41\nCPU archit" +
    "ecture: 7\nCPU variant\t: 0x0\nCPU part\t: 0xc07\nCPU revision\t: 4\n\nHardware\t" +
    ": MT6592\nRevision\t: 0000\nSerial\t\t: 0000000000000000\n"
    , "yidong"
            });
            insertLib(maps,new String[] {
                "alston_tddopen", "Lenovo", "A808t", "VIBEUI_V2.0_1437_7.2.1_ST_A808t", "LENOVO", "Lenovo A808t", "alston_tddopen", "", "KOT49H", "user", 
                "release-keys", "buildslave", "xmws66", "mt6592", "armeabi-v7a", "armeabi", "Lenovo/alston_tddopen/A808t:4.4.2/KOT49H/V2.0_1437_7.2.1_ST.29:user/release-keys", "REL", "VIBEUI_V2.0_1437_7.2.1_ST_A808t", "4.4.2", 
                "19", "19", "86478302", "1280", "720", "2.0", "2.0", "320", "320", "320", 
                "A808T.V38, 2014/08/12 16:35", "3.4.67", "Linux version 3.4.67 (buildslave@xmws66) (gcc version 4.7 (GCC) ) #1 SMP PREEMPT" +
    " Tue Sep 2 20:00:52 CST 2014\n"
    , "Processor\t: ARMv7 Processor rev 4 (v7l)\nprocessor\t: 0\nBogoMIPS\t: 3307.04\n\n" +
    "processor\t: 1\nBogoMIPS\t: 3307.04\n\nprocessor\t: 2\nBogoMIPS\t: 3307.04\n\npr" +
    "ocessor\t: 3\nBogoMIPS\t: 3307.04\n\nprocessor\t: 4\nBogoMIPS\t: 3307.04\n\nproc" +
    "essor\t: 5\nBogoMIPS\t: 3307.04\n\nprocessor\t: 6\nBogoMIPS\t: 3307.04\n\nproces" +
    "sor\t: 7\nBogoMIPS\t: 3307.04\n\nFeatures\t: swp half thumb fastmult vfp edsp th" +
    "umbee neon vfpv3 tls vfpv4 idiva idivt \nCPU implementer\t: 0x41\nCPU architectu" +
    "re: 7\nCPU variant\t: 0x0\nCPU part\t: 0xc07\nCPU revision\t: 4\n\nHardware\t: M" +
    "T6592\nRevision\t: 0000\nSerial\t\t: 0000000000000000\n"
    , "yidong"
            });
            insertLib(maps,new String[] {
                "magcomm82_wet_jb5", "", "magcomm82_wet_jb5", "UIMI-R1-V11", "alps", "UMI-R1", "UMI-R1", "", "JDQ39", "user", 
                "test-keys", "lenovo", "magcomm", "mt6582", "armeabi-v7a", "armeabi", "alps/magcomm82_wet_jb5/magcomm82_wet_jb5:4.2.2/JDQ39/1408620792:user/test-keys", "REL", "eng.lenovo.1408620792", "4.2.2", 
                "17", "17", "86477102", "1280", "720", "2.3", "2.0", "320", "320", "320", 
                "MOLY.WR8.W1319.MD.TG.MP.V31, 2013/12/26 20:46", "3.4.5", "Linux version 3.4.5 (lenovo@magcomm) (gcc version 4.6.x-google 20120106 (prerele" +
    "ase) (GCC) ) #1 SMP PREEMPT Thu Aug 21 19:32:56 CST 2014\n"
    , "Processor\t: ARMv7 Processor rev 3 (v7l)\nprocessor\t: 0\nBogoMIPS\t: 2590.72\n\n" +
    "processor\t: 1\nBogoMIPS\t: 2590.72\n\nprocessor\t: 2\nBogoMIPS\t: 2590.72\n\npr" +
    "ocessor\t: 3\nBogoMIPS\t: 2590.72\n\nFeatures\t: swp half thumb fastmult vfp eds" +
    "p thumbee neon vfpv3 tls vfpv4 idiva idivt \nCPU implementer\t: 0x41\nCPU archit" +
    "ecture: 7\nCPU variant\t: 0x0\nCPU part\t: 0xc07\nCPU revision\t: 3\n\nHardware\t" +
    ": MT6582\nRevision\t: 0000\nSerial\t\t: 0000000000000000\n"
    , "yidong"
            });
            insertLib(maps,new String[] {
                "hct82_lwt_om_kk", "naM5", "hct82_lwt_om_kk", "R09", "LTTY", "naM5", "hct82_lwt_om_kk", "", "KOT49H", "user", 
                "test-keys", "release", "release05", "mt6582", "armeabi-v7a", "armeabi", "naM5/hct82_lwt_om_kk/hct82_lwt_om_kk:4.4.2/KOT49H/1407854068:user/test-keys", "REL", "eng.release.1407854068", "4.4.2", 
                "19", "19", "86475002", "960", "540", "1.5", "1.5", "240", "240", "240", 
                "MOLY.LR9.W1414A.MD.LWTG.MP.V3.P7, 2014/08/12 18:11", "3.4.67", "Linux version 3.4.67 (release@release05) (gcc version 4.7 (GCC) ) #5 SMP PREEMPT" +
    " Tue Aug 12 22:34:17 CST 2014\n"
    , "Processor\t: ARMv7 Processor rev 3 (v7l)\nprocessor\t: 0\nBogoMIPS\t: 2590.72\n\n" +
    "processor\t: 1\nBogoMIPS\t: 2590.72\n\nprocessor\t: 2\nBogoMIPS\t: 2590.72\n\npr" +
    "ocessor\t: 3\nBogoMIPS\t: 2590.72\n\nFeatures\t: swp half thumb fastmult vfp eds" +
    "p thumbee neon vfpv3 tls vfpv4 idiva idivt \nCPU implementer\t: 0x41\nCPU archit" +
    "ecture: 7\nCPU variant\t: 0x0\nCPU part\t: 0xc07\nCPU revision\t: 3\n\nHardware\t" +
    ": MT6582\nRevision\t: aaff\nSerial\t\t: 0000000000000000\n"
    , "yidong"
            });
            insertLib(maps,new String[] {
                "hct82_lwt_om_kk", "naM5", "hct82_lwt_om_kk", "R09", "LTTY", "naM5", "hct82_lwt_om_kk", "", "KOT49H", "user", 
                "test-keys", "release", "release05", "mt6582", "armeabi-v7a", "armeabi", "naM5/hct82_lwt_om_kk/hct82_lwt_om_kk:4.4.2/KOT49H/1407854068:user/test-keys", "REL", "eng.release.1407854068", "4.4.2", 
                "19", "19", "86475002", "960", "540", "1.5", "1.5", "240", "240", "240", 
                "MOLY.LR9.W1414A.MD.LWTG.MP.V3.P7, 2014/08/12 18:11", "3.4.67", "Linux version 3.4.67 (release@release05) (gcc version 4.7 (GCC) ) #5 SMP PREEMPT" +
    " Tue Aug 12 22:34:17 CST 2014\n"
    , "Processor\t: ARMv7 Processor rev 3 (v7l)\nprocessor\t: 0\nBogoMIPS\t: 2590.72\n\n" +
    "processor\t: 1\nBogoMIPS\t: 2590.72\n\nprocessor\t: 2\nBogoMIPS\t: 2590.72\n\npr" +
    "ocessor\t: 3\nBogoMIPS\t: 2590.72\n\nFeatures\t: swp half thumb fastmult vfp eds" +
    "p thumbee neon vfpv3 tls vfpv4 idiva idivt \nCPU implementer\t: 0x41\nCPU archit" +
    "ecture: 7\nCPU variant\t: 0x0\nCPU part\t: 0xc07\nCPU revision\t: 3\n\nHardware\t" +
    ": MT6582\nRevision\t: aaff\nSerial\t\t: 0000000000000000\n"
    , "yidong"
            });
            insertLib(maps,new String[] {
                "MSM8226", "uniscope", "msm8226", "msm8226-userdebug 4.3 JLS36C eng.root.20140422.170631 test-keys", "", "US818", "US818", "", "JLS36C", "userdebug", 
                "test-keys", "root", "android-desktop", "qcom", "armeabi-v7a", "armeabi", "qcom/msm8226/msm8226:4.3/JLS36C/eng.root.20140422.170631:userdebug/test-keys", "REL", "eng.root.20140422.170631", "4.3", 
                "18", "18", "86471802", "960", "540", "1.7249999", "1.5", "240", "159.488", "160.421", 
                "M8926DAAAANAZM2013053.1", "3.4.0", "Linux version 3.4.0 (root@android-desktop) (gcc version 4.7 (GCC) ) #1 SMP PREEM" +
    "PT Tue Apr 22 17:37:46 CST 2014\n"
    , "Processor\t: ARMv7 Processor rev 3 (v7l)\nprocessor\t: 0\nBogoMIPS\t: 38.40\n\np" +
    "rocessor\t: 1\nBogoMIPS\t: 38.40\n\nprocessor\t: 2\nBogoMIPS\t: 38.40\n\nprocess" +
    "or\t: 3\nBogoMIPS\t: 38.40\n\nFeatures\t: swp half thumb fastmult vfp edsp neon " +
    "vfpv3 tls vfpv4 idiva idivt \nCPU implementer\t: 0x41\nCPU architecture: 7\nCPU " +
    "variant\t: 0x0\nCPU part\t: 0xc07\nCPU revision\t: 3\n\nHardware\t: Qualcomm MSM" +
    " 8926 (Flattened Device Tree)\nRevision\t: 0000\nSerial\t\t: 0000000000000000\n"
    , "yidong"
            });
            insertLib(maps,new String[] {
                "MT6582", "Lenovo", "A358t", "A358t_S107_140519", "LENOVO", "Lenovo A358t", "A358t", "", "KOT49H", "user", 
                "release-keys", "wangfan", "swdev6", "mt6582", "armeabi-v7a", "armeabi", "Lenovo/A358t/A358t:4.4.2/KOT49H/A358t_S107_140519:user/release-keys", "REL", "A358t_USR_S079_1406052120_MP1V2.10_DEV_CN", "4.4.2", 
                "19", "19", "86470902", "854", "480", "1.5", "1.5", "240", "240", "240", 
                "MOLY.WR8.W1319.MD.TG.MP.V39.P2, 2014/05/27 01:04", "3.4.67", "Linux version 3.4.67 (wangfan@swdev6) (gcc version 4.7 (GCC) ) #1 SMP PREEMPT Th" +
    "u Jun 5 05:37:47 AKDT 2014\n"
    , "Processor\t: ARMv7 Processor rev 3 (v7l)\nprocessor\t: 0\nBogoMIPS\t: 2590.72\n\n" +
    "processor\t: 1\nBogoMIPS\t: 2590.72\n\nprocessor\t: 2\nBogoMIPS\t: 2590.72\n\npr" +
    "ocessor\t: 3\nBogoMIPS\t: 2590.72\n\nFeatures\t: swp half thumb fastmult vfp eds" +
    "p thumbee neon vfpv3 tls vfpv4 idiva idivt \nCPU implementer\t: 0x41\nCPU archit" +
    "ecture: 7\nCPU variant\t: 0x0\nCPU part\t: 0xc07\nCPU revision\t: 3\n\nHardware\t" +
    ": MT6582\nRevision\t: aaff\nSerial\t\t: 0000000000000000\n"
    , "yidong"
            });
            insertLib(maps,new String[] {
                "DOOV C9", "DOOV", "DOOV", "C9_11_3.09_140828", "DOOV", "DOOV C9", "DOOV C9", "", "KOT49H", "user", 
                "test-keys", "builder2001", "server-ubuntu", "mt6582", "armeabi-v7a", "armeabi", "DOOV/DOOV/DOOV:4.4.2/KOT49H/1409207596:user/test-keys", "REL", "eng.builder2001.1409207596", "4.4.2", 
                "19", "19", "86469602", "1280", "720", "2.2", "2.0", "320", "320", "320", 
                "MOLY.LR9.W1414A.MD.LWTG.MP.V3.P13, 2014/08/13 18:03", "3.4.67", "Linux version 3.4.67 (builder2001@server-ubuntu) (gcc version 4.7 (GCC) ) #1 SMP" +
    " PREEMPT Thu Aug 28 14:33:07 CST 2014\n"
    , "Processor\t: ARMv7 Processor rev 3 (v7l)\nprocessor\t: 0\nBogoMIPS\t: 2590.72\n\n" +
    "processor\t: 1\nBogoMIPS\t: 2590.72\n\nprocessor\t: 2\nBogoMIPS\t: 2590.72\n\npr" +
    "ocessor\t: 3\nBogoMIPS\t: 2590.72\n\nFeatures\t: swp half thumb fastmult vfp eds" +
    "p thumbee neon vfpv3 tls vfpv4 idiva idivt \nCPU implementer\t: 0x41\nCPU archit" +
    "ecture: 7\nCPU variant\t: 0x0\nCPU part\t: 0xc07\nCPU revision\t: 3\n\nHardware\t" +
    ": MT6582\nRevision\t: 0000\nSerial\t\t: 0000000000000000\n"
    , "yidong"
            });
            insertLib(maps,new String[] {
                "DOOV C9", "DOOV", "DOOV", "C9_11_3.07_140719", "DOOV", "DOOV C9", "DOOV C9", "", "KOT49H", "user", 
                "test-keys", "builder2001", "server-ubuntu", "mt6582", "armeabi-v7a", "armeabi", "DOOV/DOOV/DOOV:4.4.2/KOT49H/1405742631:user/test-keys", "REL", "eng.builder2001.1405742631", "4.4.2", 
                "19", "19", "86469602", "1280", "720", "2.2", "2.0", "320", "320", "320", 
                "MOLY.LR9.W1414A.MD.LWTG.MP.V3.P7, 2014/07/18 21:09", "3.4.67", "Linux version 3.4.67 (builder2001@server-ubuntu) (gcc version 4.7 (GCC) ) #1 SMP" +
    " PREEMPT Sat Jul 19 12:03:43 CST 2014\n"
    , "Processor\t: ARMv7 Processor rev 3 (v7l)\nprocessor\t: 0\nBogoMIPS\t: 2072.57\n\n" +
    "processor\t: 1\nBogoMIPS\t: 2072.57\n\nprocessor\t: 2\nBogoMIPS\t: 2072.57\n\npr" +
    "ocessor\t: 3\nBogoMIPS\t: 2072.57\n\nFeatures\t: swp half thumb fastmult vfp eds" +
    "p thumbee neon vfpv3 tls vfpv4 idiva idivt \nCPU implementer\t: 0x41\nCPU archit" +
    "ecture: 7\nCPU variant\t: 0x0\nCPU part\t: 0xc07\nCPU revision\t: 3\n\nHardware\t" +
    ": MT6582\nRevision\t: 0000\nSerial\t\t: 0000000000000000\n"
    , "yidong"
            });
            insertLib(maps,new String[] {
                "aux", "Lenovo", "A850", "A850_S203_140208", "LENOVO", "Lenovo A850", "aux", "", "JDQ39", "user", 
                "release-keys", "buildslave", "xmws46", "mt6582", "armeabi-v7a", "armeabi", "Lenovo/aux/A850:4.2.2/JDQ39/A850_S203_140208.:user/release-keys", "REL", "A850_S203_140208", "4.2.2", 
                "17", "17", "86469202", "960", "540", "1.5", "1.5", "240", "240", "240", 
                "A850.V13, 2013/09/06 17:49", "3.4.5", "Linux version 3.4.5 (buildslave@xmws46) (gcc version 4.6.x-google 20120106 (prer" +
    "elease) (GCC) ) #1 SMP PREEMPT Sat Feb 8 18:28:34 CST 2014\n"
    , "Processor\t: ARMv7 Processor rev 3 (v7l)\nprocessor\t: 0\nBogoMIPS\t: 2590.72\n\n" +
    "processor\t: 1\nBogoMIPS\t: 2590.72\n\nprocessor\t: 2\nBogoMIPS\t: 2590.72\n\nFe" +
    "atures\t: swp half thumb fastmult vfp edsp thumbee neon vfpv3 tls vfpv4 idiva id" +
    "ivt \nCPU implementer\t: 0x41\nCPU architecture: 7\nCPU variant\t: 0x0\nCPU part" +
    "\t: 0xc07\nCPU revision\t: 3\n\nHardware\t: MT6582\nRevision\t: 0000\nSerial\t\t" +
    ": 0000000000000000\n"
    , "yidong"
            });
            insertLib(maps,new String[] {
                "mx", "Meizu", "mx", "Flyme 2.5 (A12322)", "Meizu", "M032", "meizu_mx", "", "JRO03H", "user", 
                "release-keys", "flyme", "Flyme-Mz", "mx", "armeabi-v7a", "armeabi", "Meizu/meizu_mx/mx:4.1.1/JRO03H/M03X.Flyme_2.5.1389771700:user/release-keys", "REL", "M03X.Flyme_2.5.1389771700", "4.1.1", 
                "16", "16", "86468701", "960", "640", "2.0", "2.0", "320", "290.2857", "290.2857", 
                "02.1201.01-248", "3.0.39-user-svn7562", "Linux version 3.0.39-user-svn7562 (mobileapp@mobileapp) (gcc version 4.6.3 (cros" +
    "stool-NG linaro-1.13.1-2012.03-20120326 - Linaro GCC 2012.03) ) #1 SMP PREEMPT W" +
    "ed Jan 8 17:19:19 CST 2014\n"
    , "Processor\t: ARMv7 Processor rev 0 (v7l)\nprocessor\t: 0\nBogoMIPS\t: 1195.21\n\n" +
    "processor\t: 1\nBogoMIPS\t: 1593.61\n\nprocessor\t: 2\nBogoMIPS\t: 1992.02\n\npr" +
    "ocessor\t: 3\nBogoMIPS\t: 1992.02\n\nFeatures\t: swp half thumb fastmult vfp eds" +
    "p neon vfpv3 tls \nCPU implementer\t: 0x41\nCPU architecture: 7\nCPU variant\t: " +
    "0x3\nCPU part\t: 0xc09\nCPU revision\t: 1.1\n\nHardware\t: MX\nRevision\t: 4412\n" +
    "Serial\t\t: 00000003000000f0\n"
    , "yidong"
            });
            insertLib(maps,new String[] {
                "MSM8226", "koobee", "msm8226", "msm8226-userdebug 4.3 JLS36C eng.root.20140603.132637 test-keys", "koobee", "koobee M3", "koobee M3", "", "JLS36C", "userdebug", 
                "test-keys", "root", "android-desktop", "qcom", "armeabi-v7a", "armeabi", "qcom/msm8226/msm8226:4.3/JLS36C/eng.root.20140603.132637:userdebug/test-keys", "REL", "eng.root.20140603.132637", "4.3", 
                "18", "18", "86465502", "1280", "720", "2.0", "2.0", "320", "160.421", "160.157", 
                "M8926DAAAANAZM2013053.1", "3.4.0", "Linux version 3.4.0 (root@android-desktop) (gcc version 4.7 (GCC) ) #1 SMP PREEM" +
    "PT Tue Jun 3 13:51:16 CST 2014\n"
    , "Processor\t: ARMv7 Processor rev 3 (v7l)\nprocessor\t: 0\nBogoMIPS\t: 38.40\n\np" +
    "rocessor\t: 1\nBogoMIPS\t: 38.40\n\nprocessor\t: 2\nBogoMIPS\t: 38.40\n\nprocess" +
    "or\t: 3\nBogoMIPS\t: 38.40\n\nFeatures\t: swp half thumb fastmult vfp edsp neon " +
    "vfpv3 tls vfpv4 idiva idivt \nCPU implementer\t: 0x41\nCPU architecture: 7\nCPU " +
    "variant\t: 0x0\nCPU part\t: 0xc07\nCPU revision\t: 3\n\nHardware\t: Qualcomm MSM" +
    " 8926 (Flattened Device Tree)\nRevision\t: 0000\nSerial\t\t: 0000000000000000\n"
    , "yidong"
            });
            insertLib(maps,new String[] {
                "MSM8226", "OPPO", "R831S", "R831S_11_140526", "OPPO", "R831S", "R831S", "", "JLS36C", "user", 
                "release-keys", "root", "ubuntu", "qcom", "armeabi-v7a", "armeabi", "OPPO/R831S/R831S:4.3/JLS36C/1390465867:user/release-keys", "REL", "eng.root.20140526.231928", "4.3", 
                "18", "18", "86462002", "854", "480", "1.5", "1.5", "240", "206.644", "208.573", 
                "Q_V1_P14", "3.4.0", "Linux version 3.4.0 (root@ubuntu) (gcc version 4.7 (GCC) ) #1 SMP PREEMPT Mon Ma" +
    "y 26 23:35:04 CST 2014\n"
    , "Processor\t: ARMv7 Processor rev 3 (v7l)\nprocessor\t: 0\nBogoMIPS\t: 38.40\n\np" +
    "rocessor\t: 1\nBogoMIPS\t: 38.40\n\nprocessor\t: 2\nBogoMIPS\t: 38.40\n\nprocess" +
    "or\t: 3\nBogoMIPS\t: 38.40\n\nFeatures\t: swp half thumb fastmult vfp edsp neon " +
    "vfpv3 tls vfpv4 idiva idivt \nCPU implementer\t: 0x41\nCPU architecture: 7\nCPU " +
    "variant\t: 0x0\nCPU part\t: 0xc07\nCPU revision\t: 3\n\nHardware\t: Qualcomm MSM" +
    " 8226 (Flattened Device Tree)\nRevision\t: 0000\nSerial\t\t: 0000000000000000\n"
    , "yidong"
            });
            insertLib(maps,new String[] {
                "MSM8226", "ZTE", "P826T20", "Q505TV1.0.0B04", "ZTE", "ZTE Q505T", "P826T20", "", "JLS36C", "user", 
                "release-keys", "root", "SWT211", "qcom", "armeabi-v7a", "armeabi", "ZTE/P826T20/P826T20:4.3/JLS36C/eng.root.20140521.141822:user/release-keys", "REL", "eng.root.20140521.141822", "4.3", 
                "18", "18", "86459002", "782", "480", "1.5", "1.5", "240", "160.421", "159.497", 
                "MPSS.DI.2.0.1.c1-00203", "3.4.0", "Linux version 3.4.0 (root@SWT211) (gcc version 4.7 (GCC) ) #1 SMP PREEMPT Wed Ma" +
    "y 21 14:54:52 CST 2014\n"
    , "Processor\t: ARMv7 Processor rev 3 (v7l)\nprocessor\t: 0\nBogoMIPS\t: 38.40\n\np" +
    "rocessor\t: 1\nBogoMIPS\t: 38.40\n\nprocessor\t: 2\nBogoMIPS\t: 38.40\n\nprocess" +
    "or\t: 3\nBogoMIPS\t: 38.40\n\nFeatures\t: swp half thumb fastmult vfp edsp neon " +
    "vfpv3 tls vfpv4 idiva idivt \nCPU implementer\t: 0x41\nCPU architecture: 7\nCPU " +
    "variant\t: 0x0\nCPU part\t: 0xc07\nCPU revision\t: 3\n\nHardware\t: Qualcomm MSM" +
    "8926\nRevision\t: 0000\nSerial\t\t: 0000000000000000\n"
    , "yidong"
            });
            insertLib(maps,new String[] {
                "MSM8226", "ZTE", "P826T20", "Q505TV1.0.0B04", "ZTE", "ZTE Q505T", "P826T20", "", "JLS36C", "user", 
                "release-keys", "root", "SWT211", "qcom", "armeabi-v7a", "armeabi", "ZTE/P826T20/P826T20:4.3/JLS36C/eng.root.20140521.141822:user/release-keys", "REL", "eng.root.20140521.141822", "4.3", 
                "18", "18", "86459002", "782", "480", "1.5", "1.5", "240", "160.421", "159.497", 
                "MPSS.DI.2.0.1.c1-00203", "3.4.0", "Linux version 3.4.0 (root@SWT211) (gcc version 4.7 (GCC) ) #1 SMP PREEMPT Wed Ma" +
    "y 21 14:54:52 CST 2014\n"
    , "Processor\t: ARMv7 Processor rev 3 (v7l)\nprocessor\t: 0\nBogoMIPS\t: 38.40\n\np" +
    "rocessor\t: 1\nBogoMIPS\t: 38.40\n\nprocessor\t: 2\nBogoMIPS\t: 38.40\n\nprocess" +
    "or\t: 3\nBogoMIPS\t: 38.40\n\nFeatures\t: swp half thumb fastmult vfp edsp neon " +
    "vfpv3 tls vfpv4 idiva idivt \nCPU implementer\t: 0x41\nCPU architecture: 7\nCPU " +
    "variant\t: 0x0\nCPU part\t: 0xc07\nCPU revision\t: 3\n\nHardware\t: Qualcomm MSM" +
    "8926\nRevision\t: 0000\nSerial\t\t: 0000000000000000\n"
    , "yidong"
            });
            insertLib(maps,new String[] {
                "lcsh82_slt_cb_kk", "Lenovo", "A360t", "A360t_S001_140518", "LENOVO", "Lenovo A360t", "A360t", "", "KOT49H", "user", 
                "release-keys", "jenkins", "glsrv4", "mt6582", "armeabi-v7a", "armeabi", "Lenovo/A360t/A360t:4.4.2/KOT49H/A360t_USR_S216_140628:user/release-keys", "REL", "A360t_S216_140628", "4.4.2", 
                "19", "19", "86456602", "854", "480", "1.6500001", "1.5", "240", "240", "240", 
                "MOLY.LR9.W1414A.MD.LWTG.MP.V2.P8, 2014/06/06 18:56", "3.4.67", "Linux version 3.4.67 (jenkins@glsrv4) (gcc version 4.7 (GCC) ) #1 SMP PREEMPT Sa" +
    "t Jun 28 12:22:45 CST 2014\n"
    , "Processor\t: ARMv7 Processor rev 3 (v7l)\nprocessor\t: 0\nBogoMIPS\t: 2590.72\n\n" +
    "processor\t: 1\nBogoMIPS\t: 2590.72\n\nprocessor\t: 2\nBogoMIPS\t: 2590.72\n\npr" +
    "ocessor\t: 3\nBogoMIPS\t: 2590.72\n\nFeatures\t: swp half thumb fastmult vfp eds" +
    "p thumbee neon vfpv3 tls vfpv4 idiva idivt \nCPU implementer\t: 0x41\nCPU archit" +
    "ecture: 7\nCPU variant\t: 0x0\nCPU part\t: 0xc07\nCPU revision\t: 3\n\nHardware\t" +
    ": MT6582\nRevision\t: 0000\nSerial\t\t: 0000000000000000\n"
    , "yidong"
            });
            insertLib(maps,new String[] {
                "mr706", "SMMS8H3G", "mz706z", "MT83X2_MR706_MZ706Z1H1C2W1.2014091817", "alps", "SMMS8H3G", "mz706z", "", "JDQ39", "user", 
                "release-keys", "lile", "elinktek3", "mt8382", "armeabi-v7a", "armeabi", "alps/mr706/mr706:4.2.2/JDQ39/1411030920:user/release-keys", "REL", "eng.lile.1411030920", "4.2.2", 
                "17", "17", "86453743", "959", "600", "1.35", "1.35", "216", "216.746", "95.25", 
                "MOLY.WR8.W1315.MD.WG.MP.V35, 2014/09/03 22:30", "3.4.5", "Linux version 3.4.5 (lile@elinktek3) (gcc version 4.6.x-google 20120106 (prerele" +
    "ase) (GCC) ) #1 SMP PREEMPT Thu Sep 18 17:01:31 HKT 2014\n"
    , "Processor\t: ARMv7 Processor rev 3 (v7l)\nprocessor\t: 0\nBogoMIPS\t: 2590.72\n\n" +
    "processor\t: 1\nBogoMIPS\t: 2590.72\n\nFeatures\t: swp half thumb fastmult vfp e" +
    "dsp thumbee neon vfpv3 tls vfpv4 idiva idivt \nCPU implementer\t: 0x41\nCPU arch" +
    "itecture: 7\nCPU variant\t: 0x0\nCPU part\t: 0xc07\nCPU revision\t: 3\n\nHardwar" +
    "e\t: MT8382\nRevision\t: 0000\nSerial\t\t: 0000000000000000\n"
    , "yidong"
            });
            insertLib(maps,new String[] {
                "Lenovo_A338t", "Lenovo", "A338t", "A338t_S211_140623", "LENOVO", "Lenovo A338t", "Lenovo_A338t", "", "KOT49H", "user", 
                "release-keys", "", "queen-desktop", "mt6582", "armeabi-v7a", "armeabi", "Lenovo/Lenovo_A338t/A338t:4.4.2/KOT49H/A338t_S211_140623:user/release-keys", "REL", "A338t_S211_140623", "4.4.2", 
                "19", "19", "86452802", "854", "480", "1.5", "1.5", "240", "240", "240", 
                "MOLY.WR8.W1319.MD.TG.MP.V39.P7, 2014/05/15 21:24", "3.4.67", "Linux version 3.4.67 (queen@queen-desktop) (gcc version 4.7 (GCC) ) #1 SMP PREEM" +
    "PT Mon Jun 23 18:19:28 CST 2014\n"
    , "Processor\t: ARMv7 Processor rev 3 (v7l)\nprocessor\t: 0\nBogoMIPS\t: 2590.72\n\n" +
    "processor\t: 1\nBogoMIPS\t: 2590.72\n\nprocessor\t: 2\nBogoMIPS\t: 2590.72\n\npr" +
    "ocessor\t: 3\nBogoMIPS\t: 2590.72\n\nFeatures\t: swp half thumb fastmult vfp eds" +
    "p thumbee neon vfpv3 tls vfpv4 idiva idivt \nCPU implementer\t: 0x41\nCPU archit" +
    "ecture: 7\nCPU variant\t: 0x0\nCPU part\t: 0xc07\nCPU revision\t: 3\n\nHardware\t" +
    ": MT6582\nRevision\t: 0000\nSerial\t\t: 0000000000000000\n"
    , "yidong"
            });
            insertLib(maps,new String[] {
                "lcsh82_slw_cu_kk", "Lenovo", "A606", "A606_S021_140819", "Lenovo", "Lenovo A606", "A606", "", "KOT49H", "user", 
                "release-keys", "jenkins", "glsrv4", "mt6582", "armeabi-v7a", "armeabi", "Lenovo/A606/A606:4.4.2/KOT49H/A606_S021_140819:user/release-keys", "REL", "A606_S021_140819", "4.4.2", 
                "19", "19", "86452702", "854", "480", "1.5", "1.5", "240", "240", "240", 
                "MOLY.LR9.W1414A.MD.LWTG.MP.V13.P5, 2014/08/19 17:40", "3.4.67", "Linux version 3.4.67 (jenkins@glsrv4) (gcc version 4.7 (GCC) ) #1 SMP PREEMPT Tu" +
    "e Aug 19 22:02:16 CST 2014\n"
    , "Processor\t: ARMv7 Processor rev 3 (v7l)\nprocessor\t: 0\nBogoMIPS\t: 2590.72\n\n" +
    "processor\t: 1\nBogoMIPS\t: 2590.72\n\nprocessor\t: 2\nBogoMIPS\t: 2590.72\n\npr" +
    "ocessor\t: 3\nBogoMIPS\t: 2590.72\n\nFeatures\t: swp half thumb fastmult vfp eds" +
    "p thumbee neon vfpv3 tls vfpv4 idiva idivt \nCPU implementer\t: 0x41\nCPU archit" +
    "ecture: 7\nCPU variant\t: 0x0\nCPU part\t: 0xc07\nCPU revision\t: 3\n\nHardware\t" +
    ": MT6582\nRevision\t: 0000\nSerial\t\t: 0000000000000000\n"
    , "liantong"
            });
            insertLib(maps,new String[] {
                "", "Marvell", "E600M", "JSS15Q", "Hisense", "HS-E600M", "E600M", "", "JSS15Q", "user", 
                "release-keys", "root", "hisense-virtual-machine", "pxa1l88", "armeabi-v7a", "armeabi", "Marvell/E600M/E600M:4.3/JSS15Q/L889.6.01.01:user/release-keys", "REL", "L889.6.01.01", "4.3", 
                "18", "18", "86452002", "854", "480", "1.5", "1.5", "240", "160", "159", 
                "HL_CP_3.59.028::3.59.028::sky_ttc_rC0_v3_001_049_dual_link_1.1_TQP_a_RA_Fix_cost" +
    "down_3mode"
    , "3.4.39+", "Linux version 3.4.39+ (root@hisense-virtual-machine) (gcc version 4.7 (GCC) ) #2" +
    " SMP PREEMPT Tue Jul 15 03:40:17 CST 2014\n"
    , "Processor\t: ARMv7 Processor rev 3 (v7l)\nprocessor\t: 0\nBogoMIPS\t: 2374.74\n\n" +
    "processor\t: 1\nBogoMIPS\t: 2374.74\n\nprocessor\t: 2\nBogoMIPS\t: 2374.74\n\npr" +
    "ocessor\t: 3\nBogoMIPS\t: 2374.74\n\nFeatures\t: swp half thumb fastmult vfp eds" +
    "p thumbee neon vfpv3 tls vfpv4 idiva idivt \nCPU implementer\t: 0x41\nCPU archit" +
    "ecture: 7\nCPU variant\t: 0x0\nCPU part\t: 0xc07\nCPU revision\t: 3\n\nHardware\t" +
    ": PXA1L88\nRevision\t: 0000\nSerial\t\t: 0000000000000000\n"
    , "yidong"
            });


            insertLib(maps,new String[] {
                "bbk89_yidong_jb2", "vivo", "bbk89_yidong_jb2", "ALPS.JB2.TDD.MP.V1", "BBK", "vivo X3t", "bbk89_yidong_jb2", "", "JOP40D", "user", 
                "test-keys", "compiler", "compiler011", "mt6589", "armeabi-v7a", "armeabi", "vivo/bbk89_yidong_jb2/bbk89_yidong_jb2:4.2.1/JOP40D/1397137142:user/test-keys", "REL", "eng.compiler.1397137142", "4.2.1", 
                "17", "17", "86450002", "1280", "720", "2.0", "2.0", "320", "320", "320", 
                "MOLY.WR8.W1301.MD.TG.MP.V6.F8.P7, 2014/03/18 11:55", "3.4.5", "Linux version 3.4.5 (compiler@compiler011) (gcc version 4.6.x-google 20120106 (p" +
    "rerelease) (GCC) ) #1 SMP PREEMPT Thu Apr 10 21:38:42 CST 2014\n"
    , "Processor\t: ARMv7 Processor rev 2 (v7l)\nprocessor\t: 0\nBogoMIPS\t: 3043.37\n\n" +
    "processor\t: 1\nBogoMIPS\t: 2000.48\n\nprocessor\t: 2\nBogoMIPS\t: 2000.48\n\nFe" +
    "atures\t: swp half thumb fastmult vfp edsp thumbee neon vfpv3 tls vfpv4 idiva id" +
    "ivt \nCPU implementer\t: 0x41\nCPU architecture: 7\nCPU variant\t: 0x0\nCPU part" +
    "\t: 0xc07\nCPU revision\t: 2\n\nHardware\t: MT6589\nRevision\t: 0000\nSerial\t\t" +
    ": 0000000000000000\n"
    , "yidong"
            });
            insertLib(maps,new String[] {
                "sp8825ea", "ZTE", "P825T10", "ZTE U808V1.0.0B02", "ZTE", "ZTE U808", "P825T10", "", "IML74K", "user", 
                "release-keys", "xiaocui", "softser306", "sc8825", "armeabi-v7a", "armeabi", "ZTE/P825T10/P825T10:4.0.3/IML74K/20130816.172644:user/release-keys", "REL", "P825T10V1.0.0B18", "4.0.3", 
                "15", "15", "86449300", "800", "480", "1.5", "1.5", "240", "270.93332", "270.93332", 
                "DM_BASE_13B_W13.20\nsc8825_modem\n05-15-2013 17:22:11", "3.0.8-00001-gc5ef80f", "Linux version 3.0.8-00001-gc5ef80f (wind-kernel@droid) (gcc version 4.4.3 (GCC) " +
    ") #1 SMP PREEMPT Fri Aug 16 17:29:48 CST 2013\n"
    , "Processor\t: ARMv7 Processor rev 1 (v7l)\nprocessor\t: 0\nBogoMIPS\t: 1024.00\n\n" +
    "processor\t: 1\nBogoMIPS\t: 1024.00\n\nFeatures\t: swp half thumb fastmult vfp e" +
    "dsp thumbee neon vfpv3 \nCPU implementer\t: 0x41\nCPU architecture: 7\nCPU varia" +
    "nt\t: 0x0\nCPU part\t: 0xc05\nCPU revision\t: 1\n\nHardware\t: sc8825\nRevision\t" +
    ": 0000\nSerial\t\t: 0000000000000000\n"
    , "yidong"
            });
            insertLib(maps,new String[] {
                "MSM8226", "KliTON", "msm8226", "msm8226-userdebug 4.3 JLS36C eng.root.20140408.195251 test-keys", "", "KliTON", "KliTON", "", "JLS36C", "userdebug", 
                "test-keys", "root", "android-desktop", "qcom", "armeabi-v7a", "armeabi", "qcom/msm8226/msm8226:4.3/JLS36C/eng.root.20140408.195251:userdebug/test-keys", "REL", "eng.root.20140408.195251", "4.3", 
                "18", "18", "86448702", "960", "540", "1.9499999", "1.5", "240", "159.488", "160.421", 
                "M8926DAAAANAZM2013053.1", "3.4.0", "Linux version 3.4.0 (root@android-desktop) (gcc version 4.7 (GCC) ) #1 SMP PREEM" +
    "PT Tue Apr 8 20:30:58 CST 2014\n"
    , "Processor\t: ARMv7 Processor rev 3 (v7l)\nprocessor\t: 0\nBogoMIPS\t: 38.40\n\np" +
    "rocessor\t: 1\nBogoMIPS\t: 38.40\n\nprocessor\t: 2\nBogoMIPS\t: 38.40\n\nprocess" +
    "or\t: 3\nBogoMIPS\t: 38.40\n\nFeatures\t: swp half thumb fastmult vfp edsp neon " +
    "vfpv3 tls vfpv4 idiva idivt \nCPU implementer\t: 0x41\nCPU architecture: 7\nCPU " +
    "variant\t: 0x0\nCPU part\t: 0xc07\nCPU revision\t: 3\n\nHardware\t: Qualcomm MSM" +
    " 8926 (Flattened Device Tree)\nRevision\t: 0000\nSerial\t\t: 0000000000000000\n"
    , "yidong"
            });
            insertLib(maps,new String[] {
                "sp8830ec_1Gram", "Qmi", "sp8830ec", "MocorDroid4.1.2", "Qmi", "Qmi", "st800_vollo2", "", "MocorDroid4.1.2", "user", 
                "test-keys", "", "queen-desktop", "sc8830", "armeabi-v7a", "armeabi", "Qmi/st800_vollo2/sp8830ec:4.1.2/MocorDroid4.1.2/eng..20140815.154145:user/test-k" +
    "eys"
    , "REL", "eng..20140815.154145", "4.1.2", 
                "16", "16", "86448502", "960", "540", "1.9499999", "1.5", "240", "254", "254", 
                "TM_BASE_13B_W14.04_P1\nsc8830_modem\n02-24-2014 19:17:11", "3.4.5", "Linux version 3.4.5 (queen@queen-desktop) (gcc version 4.6.x-google 20120106 (pr" +
    "erelease) (GCC) ) #1 SMP PREEMPT Fri Aug 15 14:50:47 CST 2014\n"
    , "Processor\t: ARMv7 Processor rev 4 (v7l)\nprocessor\t: 0\nBogoMIPS\t: 2000.48\n\n" +
    "processor\t: 1\nBogoMIPS\t: 2000.48\n\nprocessor\t: 2\nBogoMIPS\t: 1987.37\n\npr" +
    "ocessor\t: 3\nBogoMIPS\t: 1980.82\n\nFeatures\t: swp half thumb fastmult vfp eds" +
    "p neon vfpv3 tls vfpv4 idiva idivt \nCPU implementer\t: 0x41\nCPU architecture: " +
    "7\nCPU variant\t: 0x0\nCPU part\t: 0xc07\nCPU revision\t: 4\n\nHardware\t: sc883" +
    "0\nRevision\t: 0000\nSerial\t\t: 0000000000000000\n"
    , "yidong"
            });
            insertLib(maps,new String[] {
                "2013022", "Xiaomi", "HM2013022", "JH3CN0.0-41952c44d36acc0d837d5422022b4894f3b6d48b", "Xiaomi", "HM NOTE 1TD", "2013022", "", "JDQ39", "user", 
                "release-keys", "builder", "wcc-miui-ota-bd04.bj", "mt6582", "armeabi-v7a", "armeabi", "Xiaomi/2013022/HM2013022:4.2.1/HM2013022/JHACNAH2.0:user/release-keys", "REL", "JHECNBA30.0", "4.2.2", 
                "17", "17", "86437502", "960", "540", "1.5", "1.5", "240", "240", "240", 
                "MOLY.WR8.W1319.MD.TG.MP.V14.P7, 2014/06/10 18:52", "3.4.5", "Linux version 3.4.5 (sv@sv) (gcc version 4.6.x-google 20120106 (prerelease) (GCC" +
    ") ) #1 SMP PREEMPT Mon Aug 25 14:59:18 CST 2014\n"
    , "Processor\t: ARMv7 Processor rev 3 (v7l)\nprocessor\t: 0\nBogoMIPS\t: 1191.73\n\n" +
    "processor\t: 1\nBogoMIPS\t: 1191.73\n\nFeatures\t: swp half thumb fastmult vfp e" +
    "dsp thumbee neon vfpv3 tls vfpv4 idiva idivt \nCPU implementer\t: 0x41\nCPU arch" +
    "itecture: 7\nCPU variant\t: 0x0\nCPU part\t: 0xc07\nCPU revision\t: 3\n\nHardwar" +
    "e\t: MT6592\nRevision\t: 0000\nSerial\t\t: 0000000000000000\n"
    , "yidong"
            });
            insertLib(maps,new String[] {
                "BalongV9R1", "Huawei", "hw7d501l", "7D-503LV100R001C233B008", "HUAWEI", "MediaPad X1 7.0", "MediaPad", "", "HuaweiMediaPad", "user", 
                "release-keys", "jslave", "screen105", "hw7d501l", "armeabi-v7a", "armeabi", "Huawei/MediaPad/hw7d501l:4.2.2/HuaweiMediaPad/7D503LV1R1C233B008:user/release-ke" +
    "ys"
    , "REL", "C233B008", "4.2.2", 
                "17", "17", "86432302", "1824", "1200", "2.0", "2.0", "320", "324.255", "322.966", 
                "21.580.00.00.000", "3.0.8-01366-g8b18caa", "Linux version 3.0.8-01366-g8b18caa (jslave@screen105) (gcc version 4.6.x-google " +
    "20120106 (prerelease) (GCC) ) #1 SMP PREEMPT Wed Sep 17 18:02:16 CST 2014\n"
    , "Processor\t: ARMv7 Processor rev 1 (v7l)\nprocessor\t: 0\nBogoMIPS\t: 3180.00\n\n" +
    "processor\t: 1\nBogoMIPS\t: 3180.00\n\nprocessor\t: 2\nBogoMIPS\t: 3180.00\n\npr" +
    "ocessor\t: 3\nBogoMIPS\t: 3180.00\n\nFeatures\t: swp half thumb fastmult vfp eds" +
    "p thumbee neon vfpv3 \nCPU implementer\t: 0x41\nCPU architecture: 7\nCPU variant" +
    "\t: 0x4\nCPU part\t: 0xc09\nCPU revision\t: 1\n\nHardware\t: \nRevision\t: 0000\n" +
    "Serial\t\t: 0000000000000000\n"
    , "liantong"
            });
            insertLib(maps,new String[] {
                "OPPO72_13079", "OPPO", "R831T", "R831T_11_140123", "OPPO", "R831T", "OPPO72_13079", "", "JDQ39", "user", 
                "release-keys", "root", "ubuntu", "mt6572", "armeabi-v7a", "armeabi", "OPPO/OPPO72_13079/R831T:4.2.2/JDQ39/1390550946:user/release-keys", "REL", "eng.root.1390550946", "4.2.2", 
                "17", "17", "86430102", "854", "480", "1.5", "1.5", "240", "243.84", "243.72585", 
                "MOLY.WR8.W1319.MD.TG.MP.V21.F3, 2013/11/05 16:50", "3.4.5", "Linux version 3.4.5 (root@ubuntu) (gcc version 4.6.x-google 20120106 (prerelease" +
    ") (GCC) ) #1 SMP PREEMPT Fri Jan 24 16:08:34 CST 2014\n"
    , "Processor\t: ARMv7 Processor rev 3 (v7l)\nprocessor\t: 0\nBogoMIPS\t: 2589.52\n\n" +
    "processor\t: 1\nBogoMIPS\t: 2589.52\n\nFeatures\t: swp half thumb fastmult vfp e" +
    "dsp thumbee neon vfpv3 tls vfpv4 idiva idivt \nCPU implementer\t: 0x41\nCPU arch" +
    "itecture: 7\nCPU variant\t: 0x0\nCPU part\t: 0xc07\nCPU revision\t: 3\n\nHardwar" +
    "e\t: MT6572\nRevision\t: 0000\nSerial\t\t: 0000000000000000\n"
    , "yidong"
            });
            insertLib(maps,new String[] {
                "OPPO82_13065", "OPPO", "R829T", "R829T_11_140218", "OPPO", "R829T", "OPPO82_13065", "", "JDQ39", "user", 
                "release-keys", "root", "ubuntu", "mt6582", "armeabi-v7a", "armeabi", "OPPO/OPPO82_13065/R829T:4.2.2/JDQ39/1383761317:user/release-keys", "REL", "eng.root.1383761317", "4.2.2", 
                "17", "17", "86430002", "1280", "720", "2.0", "2.0", "320", "294.967", "295.563", 
                "MOLY.WR8.W1319.MD.TG.MP.V14.F2.P9, 2013/12/04 09:49", "3.4.5", "Linux version 3.4.5 (root@ubuntu) (gcc version 4.6.x-google 20120106 (prerelease" +
    ") (GCC) ) #1 SMP PREEMPT Tue Feb 18 19:49:23 CST 2014\n"
    , "Processor\t: ARMv7 Processor rev 3 (v7l)\nprocessor\t: 0\nBogoMIPS\t: 2590.72\n\n" +
    "processor\t: 1\nBogoMIPS\t: 2590.72\n\nprocessor\t: 2\nBogoMIPS\t: 2590.72\n\npr" +
    "ocessor\t: 3\nBogoMIPS\t: 2590.72\n\nFeatures\t: swp half thumb fastmult vfp eds" +
    "p thumbee neon vfpv3 tls vfpv4 idiva idivt \nCPU implementer\t: 0x41\nCPU archit" +
    "ecture: 7\nCPU variant\t: 0x0\nCPU part\t: 0xc07\nCPU revision\t: 3\n\nHardware\t" +
    ": MT6582\nRevision\t: 0000\nSerial\t\t: 0000000000000000\n"
    , "yidong"
            });
            insertLib(maps,new String[] {
                "MSM8226", "CMCC", "m811", "JLS36C", "CMDC", "M811", "m811", "", "JLS36C", "user", 
                "release-keys", "root", "redhat6.2", "qcom", "armeabi-v7a", "armeabi", "yidong/m811/m811:4.3/JLS36C/M811_01.50.00RPS:user/release-keys", "REL", "M811_01.50.00RPS", "4.3", 
                "18", "18", "86427902", "1280", "720", "2.0", "2.0", "320", "160.421", "160.157", 
                "MSM8926", "3.4.0-g4efc803", "Linux version 3.4.0-g4efc803 (root@redhat6.2) (gcc version 4.7 (GCC) ) #1 SMP PR" +
    "EEMPT Fri Aug 8 14:57:36 CST 2014\n"
    , "Processor\t: ARMv7 Processor rev 3 (v7l)\nprocessor\t: 0\nBogoMIPS\t: 38.40\n\np" +
    "rocessor\t: 1\nBogoMIPS\t: 38.40\n\nprocessor\t: 2\nBogoMIPS\t: 38.40\n\nprocess" +
    "or\t: 3\nBogoMIPS\t: 38.40\n\nFeatures\t: swp half thumb fastmult vfp edsp neon " +
    "vfpv3 tls vfpv4 idiva idivt \nCPU implementer\t: 0x41\nCPU architecture: 7\nCPU " +
    "variant\t: 0x0\nCPU part\t: 0xc07\nCPU revision\t: 3\n\nHardware\t: Qualcomm MSM" +
    " 8926 (Flattened Device Tree)\nRevision\t: 0000\nSerial\t\t: 0000000000000000\n"
    , "yidong"
            });
            insertLib(maps,new String[] {
                "MSM8226", "CMCC", "m811", "JLS36C", "CMDC", "M811", "m811", "", "JLS36C", "user", 
                "release-keys", "root", "redhat6.2", "qcom", "armeabi-v7a", "armeabi", "yidong/m811/m811:4.3/JLS36C/M811_01.50.00RPS:user/release-keys", "REL", "M811_01.50.00RPS", "4.3", 
                "18", "18", "86427902", "1280", "720", "2.3", "2.0", "320", "160.421", "160.157", 
                "MSM8926", "3.4.0-g4efc803", "Linux version 3.4.0-g4efc803 (root@redhat6.2) (gcc version 4.7 (GCC) ) #1 SMP PR" +
    "EEMPT Fri Aug 15 16:03:13 CST 2014\n"
    , "Processor\t: ARMv7 Processor rev 3 (v7l)\nprocessor\t: 0\nBogoMIPS\t: 38.40\n\np" +
    "rocessor\t: 1\nBogoMIPS\t: 38.40\n\nprocessor\t: 2\nBogoMIPS\t: 38.40\n\nprocess" +
    "or\t: 3\nBogoMIPS\t: 38.40\n\nFeatures\t: swp half thumb fastmult vfp edsp neon " +
    "vfpv3 tls vfpv4 idiva idivt \nCPU implementer\t: 0x41\nCPU architecture: 7\nCPU " +
    "variant\t: 0x0\nCPU part\t: 0xc07\nCPU revision\t: 3\n\nHardware\t: Qualcomm MSM" +
    " 8926 (Flattened Device Tree)\nRevision\t: 0000\nSerial\t\t: 0000000000000000\n"
    , "yidong"
            });
            insertLib(maps,new String[] {
                "MSM8226", "OPPO", "msm8226", "R8007_11_140411", "OPPO", "R8007", "msm8226", "", "JLS36C", "user", 
                "release-keys", "", "ubuntu", "qcom", "armeabi-v7a", "armeabi", "OPPO/R8007/R8007:4.3/JLS36C/1390465867:user/release-keys", "REL", "eng..20140411.205803", "4.3", 
                "18", "18", "86418202", "1280", "720", "2.0", "2.0", "320", "309.966", "312.615", 
                "Q_V1_P14", "3.4.0", "Linux version 3.4.0 (root@ubuntu) (gcc version 4.7 (GCC) ) #1 SMP PREEMPT Fri Ap" +
    "r 11 21:11:10 CST 2014\n"
    , "Processor\t: ARMv7 Processor rev 3 (v7l)\nprocessor\t: 0\nBogoMIPS\t: 38.40\n\np" +
    "rocessor\t: 1\nBogoMIPS\t: 38.40\n\nprocessor\t: 2\nBogoMIPS\t: 38.40\n\nprocess" +
    "or\t: 3\nBogoMIPS\t: 38.40\n\nFeatures\t: swp half thumb fastmult vfp edsp neon " +
    "vfpv3 tls vfpv4 idiva idivt \nCPU implementer\t: 0x41\nCPU architecture: 7\nCPU " +
    "variant\t: 0x0\nCPU part\t: 0xc07\nCPU revision\t: 3\n\nHardware\t: Qualcomm MSM" +
    " 8226 (Flattened Device Tree)\nRevision\t: 0000\nSerial\t\t: 0000000000000000\n"
    , "yidong"
            });
            insertLib(maps,new String[] {
                "MSM8226", "OPPO", "R1S", "R8007_11_140829", "OPPO", "R8007", "R8007", "", "JLS36C", "user", 
                "release-keys", "", "ubuntu", "qcom", "armeabi-v7a", "armeabi", "OPPO/R8007/R1S:4.3/JLS36C/1390465867:user/release-keys", "REL", "eng..20140829.200504", "4.3", 
                "18", "18", "86418202", "1280", "720", "2.0", "2.0", "320", "309.966", "312.615", 
                "Q_V1_P14", "3.4.0", "Linux version 3.4.0 (root@ubuntu) (gcc version 4.7 (GCC) ) #1 SMP PREEMPT Fri Au" +
    "g 29 20:19:20 CST 2014\n"
    , "Processor\t: ARMv7 Processor rev 3 (v7l)\nprocessor\t: 0\nBogoMIPS\t: 38.40\n\np" +
    "rocessor\t: 1\nBogoMIPS\t: 38.40\n\nprocessor\t: 2\nBogoMIPS\t: 38.40\n\nprocess" +
    "or\t: 3\nBogoMIPS\t: 38.40\n\nFeatures\t: swp half thumb fastmult vfp edsp neon " +
    "vfpv3 tls vfpv4 idiva idivt \nCPU implementer\t: 0x41\nCPU architecture: 7\nCPU " +
    "variant\t: 0x0\nCPU part\t: 0xc07\nCPU revision\t: 3\n\nHardware\t: Qualcomm MSM" +
    " 8226 (Flattened Device Tree)\nRevision\t: 0000\nSerial\t\t: 0000000000000000\n"
    , "yidong"
            });
            insertLib(maps,new String[] {
                "MSM8226", "OPPO", "N5117", "N5117_11_140806", "OPPO", "N5117", "N5117", "", "JLS36C", "user", 
                "release-keys", "", "ubuntu", "qcom", "armeabi-v7a", "armeabi", "OPPO\n5117\n5117:4.3/JLS36C/1390465867:user/release-keys", "REL", "eng..20140806.000440", "4.3", 
                "18", "18", "86418102", "1280", "720", "2.0", "2.0", "320", "309.966", "312.615", 
                "Q_V1_P14", "3.4.0", "Linux version 3.4.0 (root@ubuntu) (gcc version 4.7 (GCC) ) #1 SMP PREEMPT Wed Au" +
    "g 6 00:18:22 CST 2014\n"
    , "Processor\t: ARMv7 Processor rev 3 (v7l)\nprocessor\t: 0\nBogoMIPS\t: 38.40\n\np" +
    "rocessor\t: 1\nBogoMIPS\t: 38.40\n\nprocessor\t: 2\nBogoMIPS\t: 38.40\n\nprocess" +
    "or\t: 3\nBogoMIPS\t: 38.40\n\nFeatures\t: swp half thumb fastmult vfp edsp neon " +
    "vfpv3 tls vfpv4 idiva idivt \nCPU implementer\t: 0x41\nCPU architecture: 7\nCPU " +
    "variant\t: 0x0\nCPU part\t: 0xc07\nCPU revision\t: 3\n\nHardware\t: Qualcomm MSM" +
    " 8226 (Flattened Device Tree)\nRevision\t: 0000\nSerial\t\t: 0000000000000000\n"
    , "yidong"
            });
            insertLib(maps,new String[] {
                "MSM8226", "OPPO", "N5117", "N5117_11_140721", "OPPO", "N5117", "N5117", "", "JLS36C", "user", 
                "release-keys", "root", "ubuntu", "qcom", "armeabi-v7a", "armeabi", "OPPO\n5117\n5117:4.3/JLS36C/1390465867:user/release-keys", "REL", "eng.root.20140721.234354", "4.3", 
                "18", "18", "86418102", "1280", "720", "2.0", "2.0", "320", "309.966", "312.615", 
                "Q_V1_P14", "3.4.0", "", "Processor\t: ARMv7 Processor rev 3 (v7l)\nprocessor\t: 0\nBogoMIPS\t: 38.40\n\np" +
    "rocessor\t: 1\nBogoMIPS\t: 38.40\n\nprocessor\t: 2\nBogoMIPS\t: 38.40\n\nprocess" +
    "or\t: 3\nBogoMIPS\t: 38.40\n\nFeatures\t: swp half thumb fastmult vfp edsp neon " +
    "vfpv3 tls vfpv4 idiva idivt \nCPU implementer\t: 0x41\nCPU architecture: 7\nCPU " +
    "variant\t: 0x0\nCPU part\t: 0xc07\nCPU revision\t: 3\n\nHardware\t: Qualcomm MSM" +
    " 8226 (Flattened Device Tree)\nRevision\t: 0000\nSerial\t\t: 0000000000000000\n"
    , "yidong"
            });
            insertLib(maps,new String[] {
                "bird75_a_6628_ics", "C906", "bird75_a_6628_ics", "12K27_N116B_RDA_S3_130420", "C906", "C906", "bird75_a_6628_ics", "", "IMM76D", "user", 
                "test-keys", "root", "yuanhao-desktop", "mt6575", "armeabi-v7a", "armeabi", "L107/bird75_a_6628_ics/bird75_a_6628_ics:4.0.9/IMM76D/1366115108:user/test-keys", "REL", "eng.root.1366115108", "4.0.9", 
                "15", "15", "86414901", "800", "480", "1.7249999", "1.5", "240", "240", "240", 
                "MAUI.11AMD.W11.50.SP.V21, 2012/10/23 15:29", "3.0.13", "Linux version 3.0.13 (root@yuanhao-desktop) (gcc version 4.4.3 (GCC) ) #1 PREEMP" +
    "T Sat Apr 20 12:08:59 CST 2013\n"
    , "Processor\t: ARMv7 Processor rev 10 (v7l)\nBogoMIPS\t: 1993.93\nFeatures\t: swp " +
    "half thumb fastmult vfp edsp thumbee neon vfpv3 \nCPU implementer\t: 0x41\nCPU a" +
    "rchitecture: 7\nCPU variant\t: 0x2\nCPU part\t: 0xc09\nCPU revision\t: 10\n\nHar" +
    "dware\t: MT6589\nRevision\t: 65fb8a00\nSerial\t\t: 0000000000000000\n"
    , "liantong"
            });
            insertLib(maps,new String[] {
                "MSM8226", "ZTE", "P826T30", "Q802TV1.0.0B04", "ZTE", "ZTE Q802T", "P826T30", "", "JLS36C", "user", 
                "release-keys", "root", "SWT218", "qcom", "armeabi-v7a", "armeabi", "ZTE/P826T30/P826T30:4.3/JLS36C/eng.root.20140522.200202:user/release-keys", "REL", "eng.root.20140522.200202", "4.3", 
                "18", "18", "86414702", "1280", "720", "2.0", "2.0", "320", "160.421", "160.157", 
                "MPSS.DI.2.0.1.c1-00203", "3.4.0", "Linux version 3.4.0 (root@SWT218) (gcc version 4.7 (GCC) ) #1 SMP PREEMPT Thu Ma" +
    "y 22 20:48:03 CST 2014\n"
    , "Processor\t: ARMv7 Processor rev 3 (v7l)\nprocessor\t: 0\nBogoMIPS\t: 38.40\n\np" +
    "rocessor\t: 1\nBogoMIPS\t: 38.40\n\nprocessor\t: 2\nBogoMIPS\t: 38.40\n\nprocess" +
    "or\t: 3\nBogoMIPS\t: 38.40\n\nFeatures\t: swp half thumb fastmult vfp edsp neon " +
    "vfpv3 tls vfpv4 idiva idivt \nCPU implementer\t: 0x41\nCPU architecture: 7\nCPU " +
    "variant\t: 0x0\nCPU part\t: 0xc07\nCPU revision\t: 3\n\nHardware\t: Qualcomm MSM" +
    "8926\nRevision\t: 0000\nSerial\t\t: 0000000000000000\n"
    , "yidong"
            });
            insertLib(maps,new String[] {
                "MSM8226", "ZTE", "P826T30", "Q802TV1.0.0B04", "ZTE", "ZTE Q802T", "P826T30", "", "JLS36C", "user", 
                "release-keys", "root", "SWT218", "qcom", "armeabi-v7a", "armeabi", "ZTE/P826T30/P826T30:4.3/JLS36C/eng.root.20140417.234355:user/release-keys", "REL", "eng.root.20140417.234355", "4.3", 
                "18", "18", "86414702", "1280", "720", "2.0", "2.0", "320", "160.421", "160.157", 
                "MPSS.DI.2.0.1.c1-00127", "3.4.0", "Linux version 3.4.0 (root@SWT218) (gcc version 4.7 (GCC) ) #1 SMP PREEMPT Fri Ap" +
    "r 18 00:30:46 CST 2014\n"
    , "Processor\t: ARMv7 Processor rev 3 (v7l)\nprocessor\t: 0\nBogoMIPS\t: 38.40\n\np" +
    "rocessor\t: 1\nBogoMIPS\t: 38.40\n\nprocessor\t: 2\nBogoMIPS\t: 38.40\n\nprocess" +
    "or\t: 3\nBogoMIPS\t: 38.40\n\nFeatures\t: swp half thumb fastmult vfp edsp neon " +
    "vfpv3 tls vfpv4 idiva idivt \nCPU implementer\t: 0x41\nCPU architecture: 7\nCPU " +
    "variant\t: 0x0\nCPU part\t: 0xc07\nCPU revision\t: 3\n\nHardware\t: Qualcomm MSM" +
    " 8226 (Flattened Device Tree)\nRevision\t: 0000\nSerial\t\t: 0000000000000000\n"
    , "yidong"
            });
            insertLib(maps,new String[] {
                "leatek71_et_jb7", "Android TD", "leatek71_et_jb7", "V1.0.0.20140705.093011", "Android TD", "V2", "leatek71_et_jb7", "", "JDQ39", "user", 
                "test-keys", "liup", "ubuntu-server2", "mt6571", "armeabi-v7a", "armeabi", "alps/leatek71_et_jb7/leatek71_et_jb7:4.2.2/JDQ39/1404523810:user/test-keys", "REL", "eng.liup.1404523810", "4.4.2", 
                "17", "17", "86412802", "960", "540", "1.3499999", "1.5", "240", "240.63158", "239.05882", 
                "MOLY.WR8.W1328.MD.TG.MP.V17, 2014/06/26 16:07", "3.4.39", "Linux version 3.4.39 (liup@ubuntu-server2) (gcc version 4.6.x-google 20120106 (p" +
    "rerelease) (GCC) ) #1 SMP PREEMPT Sat Jul 5 09:29:43 CST 2014\n"
    , "Processor\t: ARMv7 Processor rev 4 (v7l)\nprocessor\t: 0\nBogoMIPS\t: 2589.52\n\n" +
    "processor\t: 1\nBogoMIPS\t: 2589.52\n\nFeatures\t: swp half thumb fastmult vfp e" +
    "dsp thumbee neon vfpv3 tls vfpv4 idiva idivt \nCPU implementer\t: 0x41\nCPU arch" +
    "itecture: 7\nCPU variant\t: 0x0\nCPU part\t: 0xc07\nCPU revision\t: 4\n\nHardwar" +
    "e\t: MT6571\nRevision\t: 0000\nSerial\t\t: 0000000000000000\n"
    , "yidong"
            });
            insertLib(maps,new String[] {
                "", "hisense", "X8T", "JSS15Q", "hisense", "HS-X8T", "X8T", "", "JSS15Q", "user", 
                "release-keys", "root", "ubuntu", "pxa1l88", "armeabi-v7a", "armeabi", "hisense/X8T/X8T:4.3/JSS15Q/L889.6.01.03:user/release-keys", "REL", "L889.6.01.03", "4.3", 
                "18", "18", "86409802", "854", "480", "1.7250149", "1.5", "240", "160", "159", 
                "HL_CP_3.55.005::3.55.004::sky_ttc_rC0_v3_001_049_Yulong_a", "3.4.39+", "Linux version 3.4.39+ (root@ubuntu) (gcc version 4.7 (GCC) ) #2 SMP PREEMPT Thu " +
    "Mar 6 04:44:06 PST 2014\n"
    , "Processor\t: ARMv7 Processor rev 3 (v7l)\nprocessor\t: 0\nBogoMIPS\t: 2341.13\n\n" +
    "processor\t: 1\nBogoMIPS\t: 2341.13\n\nprocessor\t: 2\nBogoMIPS\t: 2341.13\n\npr" +
    "ocessor\t: 3\nBogoMIPS\t: 2341.13\n\nFeatures\t: swp half thumb fastmult vfp eds" +
    "p thumbee neon vfpv3 tls vfpv4 idiva idivt \nCPU implementer\t: 0x41\nCPU archit" +
    "ecture: 7\nCPU variant\t: 0x0\nCPU part\t: 0xc07\nCPU revision\t: 3\n\nHardware\t" +
    ": PXA1L88\nRevision\t: 0000\nSerial\t\t: 0000000000000000\n"
    , "yidong"
            });
            insertLib(maps,new String[] {
                "MSM8226", "Disney", "msm8226", "msm8226-userdebug 4.3 JLS36C eng.root.20140422.152132 test-keys", "", "M7009", "M7009", "", "JLS36C", "userdebug", 
                "test-keys", "root", "android-desktop", "qcom", "armeabi-v7a", "armeabi", "qcom/msm8226/msm8226:4.3/JLS36C/eng.root.20140422.152132:userdebug/test-keys", "REL", "eng.root.20140422.152132", "4.3", 
                "18", "18", "86408902", "1280", "720", "1.7", "2.0", "320", "160.421", "160.157", 
                "M8926DAAAANAZM2013053.1", "3.4.0", "Linux version 3.4.0 (root@android-desktop) (gcc version 4.7 (GCC) ) #1 SMP PREEM" +
    "PT Tue Apr 22 16:01:46 CST 2014\n"
    , "Processor\t: ARMv7 Processor rev 3 (v7l)\nprocessor\t: 0\nBogoMIPS\t: 38.40\n\np" +
    "rocessor\t: 1\nBogoMIPS\t: 38.40\n\nprocessor\t: 2\nBogoMIPS\t: 38.40\n\nprocess" +
    "or\t: 3\nBogoMIPS\t: 38.40\n\nFeatures\t: swp half thumb fastmult vfp edsp neon " +
    "vfpv3 tls vfpv4 idiva idivt \nCPU implementer\t: 0x41\nCPU architecture: 7\nCPU " +
    "variant\t: 0x0\nCPU part\t: 0xc07\nCPU revision\t: 3\n\nHardware\t: Qualcomm MSM" +
    " 8926 (Flattened Device Tree)\nRevision\t: 0000\nSerial\t\t: 0000000000000000\n"
    , "yidong"
            });
            insertLib(maps,new String[] {
                "S1", "DOOV", "S1", "T935R_11_4.09_140108", "DOOV", "DOOV S1", "S1", "", "DOOVS1", "user", 
                "test-keys", "", "DOOV", "mt6589", "armeabi-v7a", "armeabi", "DOOV/S1/S1:4.2.1/DOOVS1/T935R_11_4.09_140108:user/test-keys", "REL", "eng..1389195942", "4.2.1", 
                "17", "17", "86406301", "960", "540", "1.6500001", "1.5", "240", "240", "240", 
                "MOLY.WR8.W1301.MD.TG.MP.V7.F1, 2013/11/28 20:58", "3.4.5", "Linux version 3.4.5 (queen@build-desktop) (gcc version 4.6.x-google 20120106 (pr" +
    "erelease) (GCC) ) #1 SMP PREEMPT Wed Jan 8 23:45:16 CST 2014\n"
    , "Processor\t: ARMv7 Processor rev 2 (v7l)\nprocessor\t: 0\nBogoMIPS\t: 2439.94\n\n" +
    "processor\t: 1\nBogoMIPS\t: 2447.96\n\nFeatures\t: swp half thumb fastmult vfp e" +
    "dsp thumbee neon vfpv3 tls vfpv4 idiva idivt \nCPU implementer\t: 0x41\nCPU arch" +
    "itecture: 7\nCPU variant\t: 0x0\nCPU part\t: 0xc07\nCPU revision\t: 2\n\nHardwar" +
    "e\t: MT6589\nRevision\t: 0000\nSerial\t\t: 0000000000000000\n"
    , "yidong"
            });
            insertLib(maps,new String[] {
                "MSM8226", "YUSUN", "msm8226", "LA2-L_V1.0", "YUSUN", "LA2-L", "msm8226", "", "JLS36C", "user", 
                "test-keys", "huguogang", "yep", "qcom", "armeabi-v7a", "armeabi", "YUSUN/msm8226/msm8226:4.3/JLS36C/eng.huguogang.20140516.113755:user/test-keys", "REL", "eng.huguogang.20140516.113755", "4.3", 
                "18", "18", "86406202", "1280", "720", "2.0", "2.0", "320", "160.421", "160.157", 
                "QL1000_888A_V0_1_5", "3.4.0-g4851aea-00034-gbb2a6f7b", "Linux version 3.4.0-g4851aea-00034-gbb2a6f7b (huguogang@yep) (gcc version 4.7 (G" +
    "CC) ) #1 SMP PREEMPT Fri May 16 11:59:06 CST 2014\n"
    , "Processor\t: ARMv7 Processor rev 3 (v7l)\nprocessor\t: 0\nBogoMIPS\t: 38.40\n\np" +
    "rocessor\t: 1\nBogoMIPS\t: 38.40\n\nprocessor\t: 2\nBogoMIPS\t: 38.40\n\nprocess" +
    "or\t: 3\nBogoMIPS\t: 38.40\n\nFeatures\t: swp half thumb fastmult vfp edsp neon " +
    "vfpv3 tls vfpv4 idiva idivt \nCPU implementer\t: 0x41\nCPU architecture: 7\nCPU " +
    "variant\t: 0x0\nCPU part\t: 0xc07\nCPU revision\t: 3\n\nHardware\t: Qualcomm MSM" +
    " 8926\nRevision\t: 0000\nSerial\t\t: 0000000000000000\n"
    , "yidong"
            });
            insertLib(maps,new String[] {
                "MSM8226", "Coolpad", "Coolpad7620L", "4.3.047.P0.140904.7620L", "YuLong", "Coolpad 7620L", "Coolpad7620L", "", "JLS36C", "user", 
                "release-keys", "system5", "ubuntu", "qcom", "armeabi-v7a", "armeabi", "Coolpad/Coolpad7620L/Coolpad7620L:4.3/JLS36C/4.3.047.P0.140904.7620L:user/releas" +
    "e-keys"
    , "REL", "4.3.047.P0.140904.7620L", "4.3", 
                "18", "18", "86393002", "960", "540", "1.3499999", "1.5", "240", "159.488", "160.421", 
                "TD-SCDMA", "3.4.0-g1e451e8-04462-gb503644", "Linux version 3.4.0-g1e451e8-04462-gb503644 (system5@ubuntu) (gcc version 4.7 (G" +
    "CC) ) #1 SMP PREEMPT Fri Sep 5 00:27:50 CST 2014\n"
    , "Processor\t: ARMv7 Processor rev 3 (v7l)\nprocessor\t: 0\nBogoMIPS\t: 38.40\n\np" +
    "rocessor\t: 1\nBogoMIPS\t: 38.40\n\nprocessor\t: 2\nBogoMIPS\t: 38.40\n\nprocess" +
    "or\t: 3\nBogoMIPS\t: 38.40\n\nFeatures\t: swp half thumb fastmult vfp edsp neon " +
    "vfpv3 tls vfpv4 idiva idivt \nCPU implementer\t: 0x41\nCPU architecture: 7\nCPU " +
    "variant\t: 0x0\nCPU part\t: 0xc07\nCPU revision\t: 3\n\nHardware\t: Qualcomm MSM" +
    " 8226 (Flattened Device Tree)\nRevision\t: 0000\nSerial\t\t: 0000000000000000\n"
    , "yidong"
            });
            insertLib(maps,new String[] {
                "sp8825ea", "Coolpad", "Coolpad8079", "4.0.002.P1.130724.8079", "COOLPAD", "Coolpad 8079", "cp8079", "", "IML74K", "user", 
                "release-keys", "dongbin", "server4", "sc8825", "armeabi-v7a", "armeabi", "Coolpad/cp8079/Coolpad8079:4.0.3/IML74K/eng.dongbin.20131021.120645:user/release" +
    "-keys"
    , "REL", "eng.dongbin.20131021.120645", "4.0.3", 
                "15", "15", "86392902", "854", "480", "1.4643751", "1.3312501", "213", "270.93332", "228.33263", 
                "DM_BASE_13B_W.8079.50\nsc8825_modem\n06-17-2013 11:06:01", "3.0.8", "Linux version 3.0.8 (dongbin@server152-PowerEdge-R710) (gcc version 4.4.3 (GCC) " +
    ") #1 SMP PREEMPT Fri Jan 17 15:18:51 CST 2014\n"
    , "Processor\t: ARMv7 Processor rev 1 (v7l)\nprocessor\t: 0\nBogoMIPS\t: 1024.00\n\n" +
    "processor\t: 1\nBogoMIPS\t: 1024.00\n\nFeatures\t: swp half thumb fastmult vfp e" +
    "dsp thumbee neon vfpv3 \nCPU implementer\t: 0x41\nCPU architecture: 7\nCPU varia" +
    "nt\t: 0x0\nCPU part\t: 0xc05\nCPU revision\t: 1\n\nHardware\t: sc8825\nRevision\t" +
    ": 0000\nSerial\t\t: 0000000000000000\n"
    , "yidong"
            });
            insertLib(maps,new String[] {
                "sp8825ea", "Coolpad", "Coolpad8079", "4.0.002.P1.130724.8079", "COOLPAD", "Coolpad 8079", "cp8079", "", "IML74K", "user", 
                "release-keys", "dongbin", "server152-PowerEdge-R710", "sc8825", "armeabi-v7a", "armeabi", "Coolpad/cp8079/Coolpad8079:4.0.3/IML74K/eng.dongbin.20140117.151346:user/release" +
    "-keys"
    , "REL", "eng.dongbin.20140117.151346", "4.0.3", 
                "15", "15", "86392902", "854", "480", "1.3312501", "1.3312501", "213", "270.93332", "228.33263", 
                "DM_BASE_13B_W.8079.50\nsc8825_modem\n06-17-2013 11:06:01", "3.0.8", "Linux version 3.0.8 (dongbin@server152-PowerEdge-R710) (gcc version 4.4.3 (GCC) " +
    ") #1 SMP PREEMPT Fri Jan 17 15:18:51 CST 2014\n"
    , "Processor\t: ARMv7 Processor rev 1 (v7l)\nprocessor\t: 0\nBogoMIPS\t: 1024.00\n\n" +
    "processor\t: 1\nBogoMIPS\t: 1024.00\n\nFeatures\t: swp half thumb fastmult vfp e" +
    "dsp thumbee neon vfpv3 \nCPU implementer\t: 0x41\nCPU architecture: 7\nCPU varia" +
    "nt\t: 0x0\nCPU part\t: 0xc05\nCPU revision\t: 1\n\nHardware\t: sc8825\nRevision\t" +
    ": 0000\nSerial\t\t: 0000000000000000\n"
    , "yidong"
            });
            insertLib(maps,new String[] {
                "sp8825ea", "Coolpad", "Coolpad8079", "4.0.002.P1.130724.8079", "COOLPAD", "Coolpad 8079", "cp8079", "", "IML74K", "user", 
                "release-keys", "dongbin", "server152-PowerEdge-R710", "sc8825", "armeabi-v7a", "armeabi", "Coolpad/cp8079/Coolpad8079:4.0.3/IML74K/eng.dongbin.20140117.151346:user/release" +
    "-keys"
    , "REL", "eng.dongbin.20140117.151346", "4.0.3", 
                "15", "15", "86392902", "854", "480", "1.3312501", "1.3312501", "213", "270.93332", "228.33263", 
                "DM_BASE_13B_W.8079.50\nsc8825_modem\n06-17-2013 11:06:01", "3.0.8", "Linux version 3.0.8 (dongbin@server152-PowerEdge-R710) (gcc version 4.4.3 (GCC) " +
    ") #1 SMP PREEMPT Fri Jan 17 15:18:51 CST 2014\n"
    , "Processor\t: ARMv7 Processor rev 1 (v7l)\nprocessor\t: 0\nBogoMIPS\t: 1024.00\n\n" +
    "processor\t: 1\nBogoMIPS\t: 1024.00\n\nFeatures\t: swp half thumb fastmult vfp e" +
    "dsp thumbee neon vfpv3 \nCPU implementer\t: 0x41\nCPU architecture: 7\nCPU varia" +
    "nt\t: 0x0\nCPU part\t: 0xc05\nCPU revision\t: 1\n\nHardware\t: sc8825\nRevision\t" +
    ": 0000\nSerial\t\t: 0000000000000000\n"
    , "yidong"
            });
            insertLib(maps,new String[] {
                "2013022", "Xiaomi", "HM2013022", "HBJ2.0", "Xiaomi", "2013022", "2013022", "", "HM2013022", "user", 
                "release-keys", "builder", "wcc-miui-ota-bd14", "mt6589", "armeabi-v7a", "armeabi", "Xiaomi/2013022/HM2013022:4.2.1/HM2013022/JHACNAL5.0:user/release-keys", "REL", "JHACNAL5.0", "4.2.1", 
                "17", "17", "86392502", "1280", "720", "2.0", "2.0", "320", "294.96774", "285.193", 
                "MOLY.WR8.W1301.MD.TG.MP.V6.P20, 2013/07/29 14:45", "3.4.5", "Linux version 3.4.5 (builder@wcc-miui-ota-bd14) (gcc version 4.6.x-google 201201" +
    "06 (prerelease) (GCC) ) #1 SMP PREEMPT Mon Dec 30 17:57:16 CST 2013\n"
    , "Processor\t: ARMv7 Processor rev 2 (v7l)\nprocessor\t: 0\nBogoMIPS\t: 3043.37\n\n" +
    "processor\t: 1\nBogoMIPS\t: 3053.37\n\nFeatures\t: swp half thumb fastmult vfp e" +
    "dsp thumbee neon vfpv3 tls vfpv4 idiva idivt \nCPU implementer\t: 0x41\nCPU arch" +
    "itecture: 7\nCPU variant\t: 0x0\nCPU part\t: 0xc07\nCPU revision\t: 2\n\nHardwar" +
    "e\t: MT6589\nRevision\t: 0000\nSerial\t\t: 0000000000000000\n"
    , "yidong"
            });
            insertLib(maps,new String[] {
                "miki82_tb_kk", "alps", "miki82_tb_kk", "ALPS.KK1.MP1.V2.26", "alps", "i9100R1", "miki82_tb_kk", "", "KOT49H", "user", 
                "test-keys", "xlsrd03", "xlsrd01-desktop", "mt8312", "armeabi-v7a", "armeabi", "alps/miki82_tb_kk/miki82_tb_kk:4.4.2/KOT49H/1409882956:user/test-keys", "REL", "eng.xlsrd03.1409882956", "4.4.2", 
                "19", "19", "86388601", "888", "540", "1.5", "1.5", "240", "240", "240", 
                "MOLY.WR8.W1315.MD.WG.MP.V44, 2014/07/18 11:22", "3.4.67", "Linux version 3.4.67 (xlsrd03@xlsrd01-desktop) (gcc version 4.7 (GCC) ) #1 SMP P" +
    "REEMPT Fri Sep 5 10:08:08 CST 2014\n"
    , "Processor\t: ARMv7 Processor rev 3 (v7l)\nprocessor\t: 0\nBogoMIPS\t: 2590.72\n\n" +
    "processor\t: 1\nBogoMIPS\t: 2590.72\n\nFeatures\t: swp half thumb fastmult vfp e" +
    "dsp thumbee neon vfpv3 tls vfpv4 idiva idivt \nCPU implementer\t: 0x41\nCPU arch" +
    "itecture: 7\nCPU variant\t: 0x0\nCPU part\t: 0xc07\nCPU revision\t: 3\n\nHardwar" +
    "e\t: MT8312\nRevision\t: 0000\nSerial\t\t: 0000000000000000\n"
    , "liantong"
            });
            insertLib(maps,new String[] {
                "miki82_tb_kk", "alps", "miki82_tb_kk", "ALPS.KK1.MP1.V2.26", "alps", "i9100R1", "miki82_tb_kk", "", "KOT49H", "user", 
                "test-keys", "xlsrd03", "xlsrd01-desktop", "mt8382", "armeabi-v7a", "armeabi", "alps/miki82_tb_kk/miki82_tb_kk:4.4.2/KOT49H/1409882956:user/test-keys", "REL", "eng.xlsrd03.1409882956", "4.4.2", 
                "19", "19", "86388601", "888", "540", "1.5", "1.5", "240", "240", "240", 
                "MOLY.WR8.W1315.MD.WG.MP.V44, 2014/07/18 11:22", "3.4.67", "Linux version 3.4.67 (xlsrd03@xlsrd01-desktop) (gcc version 4.7 (GCC) ) #1 SMP P" +
    "REEMPT Fri Sep 5 10:08:08 CST 2014\n"
    , "Processor\t: ARMv7 Processor rev 3 (v7l)\nprocessor\t: 0\nBogoMIPS\t: 2590.72\n\n" +
    "processor\t: 1\nBogoMIPS\t: 2590.72\n\nprocessor\t: 2\nBogoMIPS\t: 2590.72\n\npr" +
    "ocessor\t: 3\nBogoMIPS\t: 2590.72\n\nFeatures\t: swp half thumb fastmult vfp eds" +
    "p thumbee neon vfpv3 tls vfpv4 idiva idivt \nCPU implementer\t: 0x41\nCPU archit" +
    "ecture: 7\nCPU variant\t: 0x0\nCPU part\t: 0xc07\nCPU revision\t: 3\n\nHardware\t" +
    ": MT8382\nRevision\t: 0000\nSerial\t\t: 0000000000000000\n"
    , "yidong"
            });
            insertLib(maps,new String[] {
                "7270_W00", "Coolpad", "Coolpad7270_W00", "4.2.005.P2.140704.7270_W00", "Coolpad", "Coolpad 7270_W00", "7270_W00", "", "JDQ39", "user", 
                "release-keys", "jenkins", "80-23", "mt6589", "armeabi-v7a", "armeabi", "Coolpad/7270_W00/Coolpad7270_W00:4.2.2/JDQ39/1404458825:user/release-keys", "REL", "eng.jenkins.1404458825", "4.2.2", 
                "17", "17", "86385802", "854", "480", "1.3312501", "1.3312501", "213", "213", "213", 
                "D605A_GSM3_W18_MP_V0.0.3_S0120, 2014/01/20 15:42", "3.4.5", "Linux version 3.4.5 (jenkins@80-23) (gcc version 4.6.x-google 20120106 (prerelea" +
    "se) (GCC) ) #1 SMP PREEMPT Fri Jul 4 15:26:25 CST 2014\n"
    , "Processor\t: ARMv7 Processor rev 2 (v7l)\nprocessor\t: 0\nBogoMIPS\t: 2439.94\n\n" +
    "processor\t: 1\nBogoMIPS\t: 2439.94\n\nprocessor\t: 2\nBogoMIPS\t: 2439.94\n\npr" +
    "ocessor\t: 3\nBogoMIPS\t: 2439.94\n\nFeatures\t: swp half thumb fastmult vfp eds" +
    "p thumbee neon vfpv3 tls vfpv4 idiva idivt \nCPU implementer\t: 0x41\nCPU archit" +
    "ecture: 7\nCPU variant\t: 0x0\nCPU part\t: 0xc07\nCPU revision\t: 2\n\nHardware\t" +
    ": MT6589\nRevision\t: 0000\nSerial\t\t: 0000000000000000\n"
    , "liantong"
            });
            insertLib(maps,new String[] {
                "m5t_als", "alps", "M5", "M5T.ALS.Q.S3TAKTM1.0919.V3.04", "M5", "X5", "X5", "", "KOT49H", "user", 
                "test-keys", "X5", "sh021tydsw3-desktop", "mt6571", "armeabi-v7a", "armeabi", "alps/m5t_als/m5t_als:4.4.2/KOT49H/1411366006:user/test-keys", "REL", "eng.sh021tydsw3.1411366006", "4.4.2", 
                "19", "19", "86380702", "960", "540", "1.3499999", "1.5", "240", "240", "240", 
                "MOLY.WR8.W1328.MD.TG.MP.V22, 2014/07/01 10:22", "3.4.67", "Linux version 3.4.67 (sh021tydsw3@sh021tydsw3-desktop) (gcc version 4.7 (GCC) ) " +
    "#1 SMP PREEMPT Mon Sep 22 14:06:22 CST 2014\n"
    , "Processor\t: ARMv7 Processor rev 4 (v7l)\nprocessor\t: 0\nBogoMIPS\t: 2589.52\n\n" +
    "processor\t: 1\nBogoMIPS\t: 2589.52\n\nFeatures\t: swp half thumb fastmult vfp e" +
    "dsp thumbee neon vfpv3 tls vfpv4 idiva idivt \nCPU implementer\t: 0x41\nCPU arch" +
    "itecture: 7\nCPU variant\t: 0x0\nCPU part\t: 0xc07\nCPU revision\t: 4\n\nHardwar" +
    "e\t: MT6571\nRevision\t: 0000\nSerial\t\t: 0000000000000000\n"
    , "yidong"
            });
            insertLib(maps,new String[] {
                "MSM8974", "ZTE", "msm8974", "JLS36C", "ZTE", "ZTE Grand S II LTE", "msm8974", "", "JLS36C", "user", 
                "release-keys", "daybuild", "SCL_XA242_103", "qcom", "armeabi-v7a", "armeabi", "ZTE/msm8974/msm8974:4.3/JLS36C/eng.daybuild.20141201.201125:user/release-keys", "REL", "eng.daybuild.20141201.201125", "4.3", 
                "18", "18", "86379802", "1920", "1080", "3.0", "3.0", "480", "403.411", "403.041", 
                "MPSS.DI.2.0.c6.1-00013-M8974", "3.4.0-gae457ba", "Linux version 3.4.0-gae457ba (daybuild@SCL_XA242_105) (gcc version 4.7 (GCC) ) #" +
    "1 SMP PREEMPT Mon Dec 1 17:04:27 CST 2014\n"
    , "Processor\t: ARMv7 Processor rev 1 (v7l)\nprocessor\t: 0\nBogoMIPS\t: 38.40\n\np" +
    "rocessor\t: 1\nBogoMIPS\t: 38.40\n\nprocessor\t: 2\nBogoMIPS\t: 38.40\n\nprocess" +
    "or\t: 3\nBogoMIPS\t: 38.40\n\nFeatures\t: swp half thumb fastmult vfp edsp neon " +
    "vfpv3 tls vfpv4 idiva idivt \nCPU implementer\t: 0x51\nCPU architecture: 7\nCPU " +
    "variant\t: 0x2\nCPU part\t: 0x06f\nCPU revision\t: 1\n\nHardware\t: Qualcomm MSM" +
    " 8974 (Flattened Device Tree)\nRevision\t: 0000\nSerial\t\t: 0000000000000000\n"
    , "yidong"
            });
            insertLib(maps,new String[] {
                "MSM8974", "nubia", "NX505J", "NX505J_CNCommon_V1.29", "nubia", "NX505J", "NX505J", "", "KVT49L", "user", 
                "release-keys", "nubia", "swlab-1t037", "qcom", "armeabi-v7a", "armeabi", "nubia\nX505J\nX505J:4.4.2/KVT49L/eng.nubia.20140709.145108:user/release-keys", "REL", "eng.nubia.20140709.145108", "4.4.2", 
                "19", "19", "86378402", "1920", "1080", "2.5", "2.5", "400", "160.421", "159.895", 
                "NX505J_Z0_CN_DSXPK1JD11H129", "3.4.0-perf-gbd8e2f8", "Linux version 3.4.0-perf-gbd8e2f8 (nubia@swlab-1t037) (gcc version 4.7 (GCC) ) #" +
    "1 SMP PREEMPT Wed Jul 9 15:15:15 CST 2014\n"
    , "Processor\t: ARMv7 Processor rev 1 (v7l)\nprocessor\t: 0\nBogoMIPS\t: 38.40\n\np" +
    "rocessor\t: 1\nBogoMIPS\t: 38.40\n\nprocessor\t: 2\nBogoMIPS\t: 38.40\n\nprocess" +
    "or\t: 3\nBogoMIPS\t: 38.40\n\nFeatures\t: swp half thumb fastmult vfp edsp neon " +
    "vfpv3 tls vfpv4 idiva idivt \nCPU implementer\t: 0x51\nCPU architecture: 7\nCPU " +
    "variant\t: 0x2\nCPU part\t: 0x06f\nCPU revision\t: 1\n\nHardware\t: Qualcomm MSM" +
    "8974PRO-AC\nRevision\t: 0000\nSerial\t\t: 0000000000000000\n"
    , "liantong"
            });
            insertLib(maps,new String[] {
                "yulong92_wet_tdd", "Coolpad", "Coolpad8297", "4.2.094.P1.141027.8297", "Coolpad", "Coolpad 8297", "Coolpad8297", "", "JDQ39", "user", 
                "release-keys", "mine", "ubuntu", "mt6592", "armeabi-v7a", "armeabi", "Coolpad/Coolpad8297/Coolpad8297:4.2.2/JDQ39/4.2.094.P1.141027.8297:user/release-" +
    "keys"
    , "REL", "4.2.094.P1.141027.8297", "4.2.2", 
                "17", "17", "86377702", "1280", "720", "2.2", "2.0", "320", "320", "320", 
                "MOLY.WR8.W1328.MD.TG.MP.V1.P2, 2014/10/27 22:18", "3.4.39", "Linux version 3.4.39 (mine@ubuntu) (gcc version 4.6.x-google 20120106 (prereleas" +
    "e) (GCC) ) #1 SMP PREEMPT Mon Oct 27 22:30:38 CST 2014\n"
    , "Processor\t: ARMv7 Processor rev 4 (v7l)\nprocessor\t: 0\nBogoMIPS\t: 1679.36\n\n" +
    "processor\t: 1\nBogoMIPS\t: 1679.36\n\nprocessor\t: 2\nBogoMIPS\t: 1679.36\n\npr" +
    "ocessor\t: 3\nBogoMIPS\t: 1679.36\n\nprocessor\t: 4\nBogoMIPS\t: 1679.36\n\nproc" +
    "essor\t: 5\nBogoMIPS\t: 1679.36\n\nFeatures\t: swp half thumb fastmult vfp edsp " +
    "thumbee neon vfpv3 tls vfpv4 idiva idivt \nCPU implementer\t: 0x41\nCPU architec" +
    "ture: 7\nCPU variant\t: 0x0\nCPU part\t: 0xc07\nCPU revision\t: 4\n\nHardware\t:" +
    " MT6592\nRevision\t: 0000\nSerial\t\t: 0000000000000000\n"
    , "yidong"
            });
            insertLib(maps,new String[] {
                "bbk82_wet_jb5", "vivo", "bbk82_wet_jb5", "ALPS.JB5.MP.V1.6", "BBK", "vivo Y20T", "bbk82_wet_jb5", "", "JDQ39", "user", 
                "test-keys", "compiler", "compiler018", "mt6582", "armeabi-v7a", "armeabi", "vivo/bbk82_wet_jb5/bbk82_wet_jb5:4.2.2/JDQ39/:user/test-keys", "REL", "5", "4.2.2", 
                "17", "17", "86375602", "1280", "720", "2.0", "2.0", "320", "320", "320", 
                "MOLY.WR8.W1319.MD.TG.MP.V14.F5.P5, 2013/12/19 20:53", "3.4.5", "Linux version 3.4.5 (compiler@compiler018) (gcc version 4.6.x-google 20120106 (p" +
    "rerelease) (GCC) ) #1 SMP PREEMPT Mon Dec 30 18:27:04 CST 2013\n"
    , "Processor\t: ARMv7 Processor rev 3 (v7l)\nprocessor\t: 0\nBogoMIPS\t: 2590.72\n\n" +
    "processor\t: 1\nBogoMIPS\t: 2590.72\n\nprocessor\t: 2\nBogoMIPS\t: 2590.72\n\nFe" +
    "atures\t: swp half thumb fastmult vfp edsp thumbee neon vfpv3 tls vfpv4 idiva id" +
    "ivt \nCPU implementer\t: 0x41\nCPU architecture: 7\nCPU variant\t: 0x0\nCPU part" +
    "\t: 0xc07\nCPU revision\t: 3\n\nHardware\t: MT6582\nRevision\t: 0000\nSerial\t\t" +
    ": 0000000000000000\n"
    , "yidong"
            });
            insertLib(maps,new String[] {
                "OPPO72_13079", "OPPO", "R831T", "R831T_11_140624", "OPPO", "R831T", "OPPO72_13079", "", "JDQ39", "user", 
                "release-keys", "root", "ubuntu", "mt6572", "armeabi-v7a", "armeabi", "OPPO/OPPO72_13079/R831T:4.2.2/JDQ39/1403611216:user/release-keys", "REL", "eng.root.1403611216", "4.2.2", 
                "17", "17", "86373902", "854", "480", "1.86", "1.5", "240", "243.84", "243.72585", 
                "MOLY.WR8.W1319.MD.TG.MP.V21.F3, 2013/11/05 16:50", "3.4.5", "Linux version 3.4.5 (root@ubuntu) (gcc version 4.6.x-google 20120106 (prerelease" +
    ") (GCC) ) #1 SMP PREEMPT Tue Jun 24 19:59:43 CST 2014\n"
    , "Processor\t: ARMv7 Processor rev 3 (v7l)\nprocessor\t: 0\nBogoMIPS\t: 2589.52\n\n" +
    "processor\t: 1\nBogoMIPS\t: 2589.52\n\nFeatures\t: swp half thumb fastmult vfp e" +
    "dsp thumbee neon vfpv3 tls vfpv4 idiva idivt \nCPU implementer\t: 0x41\nCPU arch" +
    "itecture: 7\nCPU variant\t: 0x0\nCPU part\t: 0xc07\nCPU revision\t: 3\n\nHardwar" +
    "e\t: MT6572\nRevision\t: 0000\nSerial\t\t: 0000000000000000\n"
    , "yidong"
            });
            insertLib(maps,new String[] {
                "OPPO72_13079", "OPPO", "R831T", "R831T_11_140904", "OPPO", "R831T", "OPPO72_13079", "", "JDQ39", "user", 
                "release-keys", "root", "ubuntu", "mt6572", "armeabi-v7a", "armeabi", "OPPO/OPPO72_13079/R831T:4.2.2/JDQ39/1409818673:user/release-keys", "REL", "eng.root.1409818673", "4.2.2", 
                "17", "17", "86373902", "854", "480", "1.5", "1.5", "240", "243.84", "243.72585", 
                "MOLY.WR8.W1319.MD.TG.MP.V21.F3, 2013/11/05 16:50", "3.4.5", "Linux version 3.4.5 (root@ubuntu) (gcc version 4.6.x-google 20120106 (prerelease" +
    ") (GCC) ) #1 SMP PREEMPT Thu Sep 4 16:17:14 CST 2014\n"
    , "Processor\t: ARMv7 Processor rev 3 (v7l)\nprocessor\t: 0\nBogoMIPS\t: 2589.52\n\n" +
    "processor\t: 1\nBogoMIPS\t: 2589.52\n\nFeatures\t: swp half thumb fastmult vfp e" +
    "dsp thumbee neon vfpv3 tls vfpv4 idiva idivt \nCPU implementer\t: 0x41\nCPU arch" +
    "itecture: 7\nCPU variant\t: 0x0\nCPU part\t: 0xc07\nCPU revision\t: 3\n\nHardwar" +
    "e\t: MT6572\nRevision\t: 0000\nSerial\t\t: 0000000000000000\n"
    , "yidong"
            });
            insertLib(maps,new String[] {
                "MSM8974", "OPPO", "X9007", "X9007_12_140911", "OPPO", "X9007", "X9007", "", "JLS36C", "user", 
                "release-keys", "oppo", "ubuntu", "qcom", "armeabi-v7a", "armeabi", "OPPO/X9007/X9007:4.3/JLS36C/1390465867:user/release-keys", "REL", "eng.oppo.20140911.114456", "4.3", 
                "18", "18", "86373802", "1920", "1080", "3.0", "3.0", "480", "403.411", "403.041", 
                "Q_V1_P14", "3.4.0-svn9692", "Linux version 3.4.0-svn9692 (oppo@ubuntu) (gcc version 4.7 (GCC) ) #1 SMP PREEMP" +
    "T Thu Sep 11 12:15:06 CST 2014\n"
    , "Processor\t: ARMv7 Processor rev 1 (v7l)\nprocessor\t: 0\nBogoMIPS\t: 38.40\n\np" +
    "rocessor\t: 1\nBogoMIPS\t: 38.40\n\nprocessor\t: 2\nBogoMIPS\t: 38.40\n\nprocess" +
    "or\t: 3\nBogoMIPS\t: 38.40\n\nFeatures\t: swp half thumb fastmult vfp edsp neon " +
    "vfpv3 tls vfpv4 idiva idivt \nCPU implementer\t: 0x51\nCPU architecture: 7\nCPU " +
    "variant\t: 0x2\nCPU part\t: 0x06f\nCPU revision\t: 1\n\nHardware\t: Qualcomm MSM" +
    " 8974 (Flattened Device Tree)\nRevision\t: 0000\nSerial\t\t: 0000000000000000\n"
    , "yidong"
            });
            insertLib(maps,new String[] {
                "MSM8974", "OPPO", "X9007", "X9007_12_140417", "OPPO", "X9007", "X9007", "", "JLS36C", "user", 
                "release-keys", "oppo", "ubuntu", "qcom", "armeabi-v7a", "armeabi", "OPPO/X9007/X9007:4.3/JLS36C/1390465867:user/release-keys", "REL", "eng.oppo.20140417.181741", "4.3", 
                "18", "18", "86373802", "1920", "1080", "3.0", "3.0", "480", "403.411", "403.041", 
                "Q_V1_P14", "3.4.0-svn5918", "Linux version 3.4.0-svn5918 (oppo@ubuntu) (gcc version 4.7 (GCC) ) #1 SMP PREEMP" +
    "T Thu Apr 17 18:48:44 CST 2014\n"
    , "Processor\t: ARMv7 Processor rev 1 (v7l)\nprocessor\t: 0\nBogoMIPS\t: 38.40\n\np" +
    "rocessor\t: 1\nBogoMIPS\t: 38.40\n\nprocessor\t: 2\nBogoMIPS\t: 38.40\n\nprocess" +
    "or\t: 3\nBogoMIPS\t: 38.40\n\nFeatures\t: swp half thumb fastmult vfp edsp neon " +
    "vfpv3 tls vfpv4 idiva idivt \nCPU implementer\t: 0x51\nCPU architecture: 7\nCPU " +
    "variant\t: 0x2\nCPU part\t: 0x06f\nCPU revision\t: 1\n\nHardware\t: Qualcomm MSM" +
    " 8974 (Flattened Device Tree)\nRevision\t: 0000\nSerial\t\t: 0000000000000000\n"
    , "yidong"
            });
            insertLib(maps,new String[] {
                "Z25", "UNISTAR", "Z25", "UNISTAR_U5TD_Z25_V07", "SBYH", "UNISTAR-U5", "Z25", "", "JDQ39", "user", 
                "test-keys", "scm", "v75", "mt6572", "armeabi-v7a", "armeabi", "UNISTAR/Z25/Z25:4.2.2/JDQ39/1396064278:user/test-keys", "REL", "eng.scm.1396064278", "4.2.2", 
                "17", "17", "86372002", "960", "540", "1.7249999", "1.5", "240", "159.48837", "160.42105", 
                "MOLY.WR8.W1319.MD.TG.MP.V1.P31, 2014/03/07 14:20", "3.4.5", "Linux version 3.4.5 (user@linux-user) (gcc version 4.6.x-google 20120106 (prerel" +
    "ease) (GCC) ) #1 SMP PREEMPT Sat Mar 29 11:37:39 CST 2014\n"
    , "Processor\t: ARMv7 Processor rev 3 (v7l)\nprocessor\t: 0\nBogoMIPS\t: 2589.52\n\n" +
    "processor\t: 1\nBogoMIPS\t: 2589.52\n\nFeatures\t: swp half thumb fastmult vfp e" +
    "dsp thumbee neon vfpv3 tls vfpv4 idiva idivt \nCPU implementer\t: 0x41\nCPU arch" +
    "itecture: 7\nCPU variant\t: 0x0\nCPU part\t: 0xc07\nCPU revision\t: 3\n\nHardwar" +
    "e\t: MT6582\nRevision\t: 0000\nSerial\t\t: 0000000000000000\n"
    , "yidong"
            });
            insertLib(maps,new String[] {
                "MSM8226", "TCL", "RIO55_LTE", "TCL_J938M_V2.0_140518_yidong", "TCL", "TCL J938M", "TCL_J938M", "", "JOP43D", "user", 
                "release-keys", "root", "cnbusvr-db03", "qcom", "armeabi-v7a", "armeabi", "TCL/TCL_J938M/RIO55_LTE:4.3/JOP43D/140518_yidong:user/release-keys", "REL", "140518_yidong", "4.3", 
                "18", "18", "86370502", "1280", "720", "2.34", "2.0", "320", "268.941", "268.694", 
                "140428-10300071-SG3M-140428-1032-NOQFE", "3.4.0", "Linux version 3.4.0 (root@cnbusvr-db03) (gcc version 4.7 (GCC) ) #2 SMP PREEMPT " +
    "Sun May 18 04:46:50 CST 2014\n"
    , "Processor\t: ARMv7 Processor rev 3 (v7l)\nprocessor\t: 0\nBogoMIPS\t: 38.40\n\np" +
    "rocessor\t: 1\nBogoMIPS\t: 38.40\n\nprocessor\t: 2\nBogoMIPS\t: 38.40\n\nprocess" +
    "or\t: 3\nBogoMIPS\t: 38.40\n\nFeatures\t: swp half thumb fastmult vfp edsp neon " +
    "vfpv3 tls vfpv4 idiva idivt \nCPU implementer\t: 0x41\nCPU architecture: 7\nCPU " +
    "variant\t: 0x0\nCPU part\t: 0xc07\nCPU revision\t: 3\n\nHardware\t: Qualcomm MSM" +
    " 8226 (Flattened Device Tree)\nRevision\t: 0000\nSerial\t\t: 0000000000000000\n"
    , "yidong"
            });
            insertLib(maps,new String[] {
                "MSM8226", "DOOV", "T90", "T90_11_3.08_140529", "DOOV", "DOOV T90", "T90", "", "JLS36C", "user", 
                "test-keys", "release13", "DOOV", "qcom", "armeabi-v7a", "armeabi", "DOOV/msm8226/msm8226:4.3/JLS36C/eng.release13.20140605.193056:user/test-keys", "REL", "eng.release13.20140605.193056", "4.3", 
                "18", "18", "86367102", "1280", "720", "2.0", "2.0", "320", "160.421", "160.157", 
                "QL1002_888A_V0_1_5", "3.4.0-g9fb0b64-00200-g7271da3", "Linux version 3.4.0-g9fb0b64-00200-g7271da3 (release13@yep) (gcc version 4.7 (GC" +
    "C) ) #1 SMP PREEMPT Thu Jun 5 19:56:48 CST 2014\n"
    , "Processor\t: ARMv7 Processor rev 3 (v7l)\nprocessor\t: 0\nBogoMIPS\t: 38.40\n\np" +
    "rocessor\t: 1\nBogoMIPS\t: 38.40\n\nprocessor\t: 2\nBogoMIPS\t: 38.40\n\nprocess" +
    "or\t: 3\nBogoMIPS\t: 38.40\n\nFeatures\t: swp half thumb fastmult vfp edsp neon " +
    "vfpv3 tls vfpv4 idiva idivt \nCPU implementer\t: 0x41\nCPU architecture: 7\nCPU " +
    "variant\t: 0x0\nCPU part\t: 0xc07\nCPU revision\t: 3\n\nHardware\t: Qualcomm MSM" +
    " 8926\nRevision\t: 0000\nSerial\t\t: 0000000000000000\n"
    , "yidong"
            });
            insertLib(maps,new String[] {
                "techain82_wet_jb5", "ZTE", "P682T51", "U968V1.0.0B02", "ZTE", "ZTE U968", "P682T51", "", "JDQ39", "user", 
                "release-keys", "root", "sw1-andriodserver2-desktop", "mt6582", "armeabi-v7a", "armeabi", "ZTE/P682T51/P682T51:4.2.2/JDQ39/eng.root.1387977579:user/release-keys", "REL", "eng.root.1387977579", "4.2.2", 
                "17", "17", "86365500", "960", "540", "1.7249999", "1.5", "240", "204.716", "203.2", 
                "MOLY.WR8.W1319.MD.TG.MP.V8.P30, 2013/12/23 18:12", "3.4.5", "Linux version 3.4.5 (root@sw1-andriodserver2-desktop) (gcc version 4.6.x-google " +
    "20120106 (prerelease) (GCC) ) #1 SMP PREEMPT Wed Dec 25 21:19:22 CST 2013\n"
    , "Processor\t: ARMv7 Processor rev 3 (v7l)\nprocessor\t: 0\nBogoMIPS\t: 2590.72\n\n" +
    "processor\t: 1\nBogoMIPS\t: 2590.72\n\nprocessor\t: 2\nBogoMIPS\t: 2590.72\n\npr" +
    "ocessor\t: 3\nBogoMIPS\t: 2590.72\n\nFeatures\t: swp half thumb fastmult vfp eds" +
    "p thumbee neon vfpv3 tls vfpv4 idiva idivt \nCPU implementer\t: 0x41\nCPU archit" +
    "ecture: 7\nCPU variant\t: 0x0\nCPU part\t: 0xc07\nCPU revision\t: 3\n\nHardware\t" +
    ": MT6582\nRevision\t: 0000\nSerial\t\t: 0000000000000000\n"
    , "yidong"
            });
            insertLib(maps,new String[] {
                "sp8830ec", "K-Touch", "sp8830ec_nwcn", "K-Touch_T90_yidong_V02", "K-Touch", "K-Touch T90", "sp8830ecyidongspecAplus_nwcn_UUI", "", "JZO54K", "user", 
                "test-keys", "gcj", "sw163-desktop", "sc8830", "armeabi-v7a", "armeabi", "", "REL", "eng.gcj.20140306.224952", "4.1.2", 
                "16", "16", "86364002", "854", "480", "1.2750001", "1.5", "240", "254", "255.19528", 
                "TM_BASE_13B_W14.04_P1\nsc8830_modem\n02-24-2014 19:17:11", "3.4.5", "Linux version 3.4.5 (gcj@sw163-desktop) (gcc version 4.6.x-google 20120106 (prer" +
    "elease) (GCC) ) #1 SMP PREEMPT Thu Mar 6 22:54:43 CST 2014\n"
    , "Processor\t: ARMv7 Processor rev 4 (v7l)\nprocessor\t: 0\nBogoMIPS\t: 2007.04\n\n" +
    "processor\t: 1\nBogoMIPS\t: 2000.48\n\nprocessor\t: 2\nBogoMIPS\t: 1987.37\n\npr" +
    "ocessor\t: 3\nBogoMIPS\t: 1987.37\n\nFeatures\t: swp half thumb fastmult vfp eds" +
    "p neon vfpv3 tls vfpv4 idiva idivt \nCPU implementer\t: 0x41\nCPU architecture: " +
    "7\nCPU variant\t: 0x0\nCPU part\t: 0xc07\nCPU revision\t: 4\n\nHardware\t: sc883" +
    "0\nRevision\t: 0000\nSerial\t\t: 0000000000000000\n"
    , "yidong"
            });
            insertLib(maps,new String[] {
                "7270", "Coolpad", "Coolpad7270", "4.2.008.P2.131114.7270", "Coolpad", "Coolpad 7270", "7270", "", "JDQ39", "user", 
                "release-keys", "mudingyu", "compiler5-desktop", "mt6582", "armeabi-v7a", "armeabi", "Coolpad/7270/Coolpad7270:4.2.2/JDQ39/1384443467:user/release-keys", "REL", "eng.mudingyu.1384443467", "4.2.2", 
                "17", "17", "86357702", "854", "480", "1.3312501", "1.3312501", "213", "213", "213", 
                "RF9810_GSM3_W18_MP_V0.0.7_S1022, 2013/10/22 14:26", "3.4.5", "Linux version 3.4.5 (mudingyu@compiler5-desktop) (gcc version 4.6.x-google 20120" +
    "106 (prerelease) (GCC) ) #1 SMP PREEMPT Thu Nov 14 23:36:53 CST 2013\n"
    , "Processor\t: ARMv7 Processor rev 3 (v7l)\nprocessor\t: 0\nBogoMIPS\t: 2590.72\n\n" +
    "processor\t: 1\nBogoMIPS\t: 2590.72\n\nprocessor\t: 2\nBogoMIPS\t: 2590.72\n\npr" +
    "ocessor\t: 3\nBogoMIPS\t: 2590.72\n\nFeatures\t: swp half thumb fastmult vfp eds" +
    "p thumbee neon vfpv3 tls vfpv4 idiva idivt \nCPU implementer\t: 0x41\nCPU archit" +
    "ecture: 7\nCPU variant\t: 0x0\nCPU part\t: 0xc07\nCPU revision\t: 3\n\nHardware\t" +
    ": MT6582\nRevision\t: 0000\nSerial\t\t: 0000000000000000\n"
    , "liantong"
            });
            insertLib(maps,new String[] {
                "MSM8226", "qcom", "msm8226", "TBT598710_9490_V0003", "K-TOUCH", "K-Touch Tou ch 2", "msm8226", "", "K-Touch Tou ch 2", "user", 
                "release-keys", "ccadmin", "BUILD17", "qcom", "armeabi-v7a", "armeabi", "qcom/msm8226/msm8226:4.3/JLS36C/TBT598710_9490_V0003:user/release-keys", "REL", "TBT598710_9490_V0003", "4.3", 
                "18", "18", "86355102", "854", "480", "1.9499999", "1.5", "240", "160.421", "159.497", 
                "TBT598713_9491_LTE_V2029", "3.4.0-gdf2ce8e-00182-g4c662fa", "Linux version 3.4.0-gdf2ce8e-00182-g4c662fa (ccadmin@BUILD17) (gcc version 4.7 (" +
    "GCC) ) #1 SMP PREEMPT Tue Apr 22 15:24:01 CST 2014\n"
    , "Processor\t: ARMv7 Processor rev 3 (v7l)\nprocessor\t: 0\nBogoMIPS\t: 38.40\n\np" +
    "rocessor\t: 1\nBogoMIPS\t: 38.40\n\nprocessor\t: 2\nBogoMIPS\t: 38.40\n\nprocess" +
    "or\t: 3\nBogoMIPS\t: 38.40\n\nFeatures\t: swp half thumb fastmult vfp edsp neon " +
    "vfpv3 tls vfpv4 idiva idivt \nCPU implementer\t: 0x41\nCPU architecture: 7\nCPU " +
    "variant\t: 0x0\nCPU part\t: 0xc07\nCPU revision\t: 3\n\nHardware\t: Qualcomm MSM" +
    " 8226 (Flattened Device Tree)\nRevision\t: 0000\nSerial\t\t: 0000000000000000\n"
    , "yidong"
            });
            insertLib(maps,new String[] {
                "MSM8226", "qcom", "msm8226", "TBT598710_9490_V0003", "K-TOUCH", "K-Touch Tou ch 2", "msm8226", "", "K-Touch Tou ch 2", "user", 
                "release-keys", "ccadmin", "BUILD17", "qcom", "armeabi-v7a", "armeabi", "qcom/msm8226/msm8226:4.3/JLS36C/TBT598710_9490_V0003:user/release-keys", "REL", "TBT598710_9490_V0003", "4.3", 
                "18", "18", "86355102", "854", "480", "1.5", "1.5", "240", "160.421", "159.497", 
                "TBT598713_9491_LTE_V2029", "3.4.0-gdf2ce8e-00182-g4c662fa", "Linux version 3.4.0-gdf2ce8e-00182-g4c662fa (ccadmin@BUILD17) (gcc version 4.7 (" +
    "GCC) ) #1 SMP PREEMPT Tue Apr 22 15:24:01 CST 2014\n"
    , "Processor\t: ARMv7 Processor rev 3 (v7l)\nprocessor\t: 0\nBogoMIPS\t: 38.40\n\np" +
    "rocessor\t: 1\nBogoMIPS\t: 38.40\n\nprocessor\t: 2\nBogoMIPS\t: 38.40\n\nprocess" +
    "or\t: 3\nBogoMIPS\t: 38.40\n\nFeatures\t: swp half thumb fastmult vfp edsp neon " +
    "vfpv3 tls vfpv4 idiva idivt \nCPU implementer\t: 0x41\nCPU architecture: 7\nCPU " +
    "variant\t: 0x0\nCPU part\t: 0xc07\nCPU revision\t: 3\n\nHardware\t: Qualcomm MSM" +
    " 8226 (Flattened Device Tree)\nRevision\t: 0000\nSerial\t\t: 0000000000000000\n"
    , "yidong"
            });
            insertLib(maps,new String[] {
                "", "Coolpad", "8295C", "4.2.018.P1.131231.8295C", "YuLong", "Coolpad8295C", "8295C", "", "JOP40D", "user", 
                "release-keys", "mine", "mine", "pxa1088", "armeabi-v7a", "armeabi", "Coolpad/8295C/8295C:4.2.1/JOP40D/4.2.024.P1.140129.8295C:user/release-keys", "REL", "4.2.018.P1.131231.8295C", "4.2.1", 
                "17", "17", "86354802", "854", "480", "1.5", "1.5", "240", "160", "159", 
                "HLTD_CP_2.41.P15:TTD_WK_HLTD_MSA_2.41.P12", "3.4.5", "Linux version 3.4.5 (mine@mine) (gcc version 4.6.x-google 20120106 (prerelease) " +
    "(GCC) ) #2 SMP PREEMPT Wed Jan 29 14:57:41 CST 2014\n"
    , "Processor\t: ARMv7 Processor rev 3 (v7l)\nprocessor\t: 0\nBogoMIPS\t: 2374.74\n\n" +
    "processor\t: 3\nBogoMIPS\t: 2374.74\n\nFeatures\t: swp half thumb fastmult vfp e" +
    "dsp thumbee neon vfpv3 tls vfpv4 idiva idivt \nCPU implementer\t: 0x41\nCPU arch" +
    "itecture: 7\nCPU variant\t: 0x0\nCPU part\t: 0xc07\nCPU revision\t: 3\n\nHardwar" +
    "e\t: PXA1088\nRevision\t: 0000\nSerial\t\t: 0000000000000000\n"
    , "yidong"
            });
            insertLib(maps,new String[] {
                "", "Coolpad", "8295C", "4.2.018.P1.131231.8295C", "YuLong", "Coolpad8295C", "8295C", "", "JOP40D", "user", 
                "release-keys", "mine", "mine", "pxa1088", "armeabi-v7a", "armeabi", "Coolpad/8295C/8295C:4.2.1/JOP40D/4.2.024.P1.140129.8295C:user/release-keys", "REL", "4.2.018.P1.131231.8295C", "4.2.1", 
                "17", "17", "86354802", "854", "480", "1.5", "1.5", "240", "160", "159", 
                "HLTD_CP_2.41.P15:TTD_WK_HLTD_MSA_2.41.P12", "3.4.5", "Linux version 3.4.5 (mine@mine) (gcc version 4.6.x-google 20120106 (prerelease) " +
    "(GCC) ) #2 SMP PREEMPT Wed Jan 29 14:57:41 CST 2014\n"
    , "Processor\t: ARMv7 Processor rev 3 (v7l)\nprocessor\t: 0\nBogoMIPS\t: 626.09\n\n" +
    "processor\t: 1\nBogoMIPS\t: 626.09\n\nprocessor\t: 2\nBogoMIPS\t: 626.09\n\nproc" +
    "essor\t: 3\nBogoMIPS\t: 626.09\n\nFeatures\t: swp half thumb fastmult vfp edsp t" +
    "humbee neon vfpv3 tls vfpv4 idiva idivt \nCPU implementer\t: 0x41\nCPU architect" +
    "ure: 7\nCPU variant\t: 0x0\nCPU part\t: 0xc07\nCPU revision\t: 3\n\nHardware\t: " +
    "PXA1088\nRevision\t: 0000\nSerial\t\t: 0000000000000000\n"
    , "yidong"
            });
            insertLib(maps,new String[] {
                "", "Coolpad", "8295C", "4.2.018.P1.131231.8295C", "YuLong", "Coolpad8295C", "8295C", "", "JOP40D", "user", 
                "release-keys", "mine", "mine", "pxa1088", "armeabi-v7a", "armeabi", "Coolpad/8295C/8295C:4.2.1/JOP40D/4.2.021.P1.140115.8295C:user/release-keys", "REL", "4.2.018.P1.131231.8295C", "4.2.1", 
                "17", "17", "86354802", "854", "480", "1.5", "1.5", "240", "160", "159", 
                "HLTD_CP_2.41.P15:TTD_WK_HLTD_MSA_2.41.P12", "3.4.5", "Linux version 3.4.5 (mine@mine) (gcc version 4.6.x-google 20120106 (prerelease) " +
    "(GCC) ) #2 SMP PREEMPT Wed Jan 15 18:30:29 CST 2014\n"
    , "Processor\t: ARMv7 Processor rev 3 (v7l)\nprocessor\t: 0\nBogoMIPS\t: 2374.74\n\n" +
    "processor\t: 1\nBogoMIPS\t: 2374.74\n\nprocessor\t: 2\nBogoMIPS\t: 1605.94\n\npr" +
    "ocessor\t: 3\nBogoMIPS\t: 1605.94\n\nFeatures\t: swp half thumb fastmult vfp eds" +
    "p thumbee neon vfpv3 tls vfpv4 idiva idivt \nCPU implementer\t: 0x41\nCPU archit" +
    "ecture: 7\nCPU variant\t: 0x0\nCPU part\t: 0xc07\nCPU revision\t: 3\n\nHardware\t" +
    ": PXA1088\nRevision\t: 0000\nSerial\t\t: 0000000000000000\n"
    , "yidong"
            });
            insertLib(maps,new String[] {
                "G610-U00", "Huawei", "hwG610-U00", "G610-U00 V100R001CHNC17B144", "HUAWEI", "HUAWEI G610-U00", "G610-U00", "", "HuaweiG610-U00", "user", 
                "ota-rel-keys,release-keys", "jenkins", "sp-linux211-desktop", "mt6589", "armeabi-v7a", "armeabi", "Huawei/G610-U00/hwG610-U00:4.2.1/HuaweiG610-U00/C17B144:user/ota-rel-keys,releas" +
    "e-keys"
    , "REL", "C17B144", "4.2.1", 
                "17", "17", "86349302", "960", "540", "1.5", "1.5", "240", "240", "240", 
                "MOLY.WR8.W1248.MD.WG.MP.V5.F1.P56, 2013/07/27 10:47", "3.4.5", "Linux version 3.4.5 (jenkins@sp-linux211-desktop) (gcc version 4.6.x-google 2012" +
    "0106 (prerelease) (GCC) ) #1 SMP PREEMPT Tue Nov 19 17:06:30 HKT 2013\n"
    , "Processor\t: ARMv7 Processor rev 2 (v7l)\nprocessor\t: 0\nBogoMIPS\t: 2439.94\n\n" +
    "processor\t: 1\nBogoMIPS\t: 2439.94\n\nprocessor\t: 2\nBogoMIPS\t: 2439.94\n\npr" +
    "ocessor\t: 3\nBogoMIPS\t: 2439.94\n\nFeatures\t: swp half thumb fastmult vfp eds" +
    "p thumbee neon vfpv3 tls vfpv4 idiva idivt \nCPU implementer\t: 0x41\nCPU archit" +
    "ecture: 7\nCPU variant\t: 0x0\nCPU part\t: 0xc07\nCPU revision\t: 2\n\nHardware\t" +
    ": MT6589\nRevision\t: 0000\nSerial\t\t: 0000000000000000\n"
    , "yidong"
            });
            insertLib(maps,new String[] {
                "gionee92_wet_jb9", "GiONEE", "GiONEE", "amigo2.0.10", "GiONEE", "GN9000", "GiONEE", "", "JDQ39", "user", 
                "test-keys", "znsj", "znsj-soft02", "mt6592", "armeabi-v7a", "armeabi", "alps/gionee92_wet_jb9/gionee92_wet_jb9:4.2.2/JDQ39/1407903466:user/test-keys", "REL", "eng.znsj.1407903466", "4.2.2", 
                "17", "17", "86348402", "1920", "1080", "2.700001", "3.0", "480", "480", "480", 
                "MOLY.WR8.W1328.MD.TG.MP.V3.P7, 2014/03/27 18:02", "3.4.39", "Linux version 3.4.39 (znsj@znsj-soft02) (gcc version 4.6.x-google 20120106 (prer" +
    "elease) (GCC) ) #1 SMP PREEMPT Wed Aug 13 11:23:50 CST 2014\n"
    , "Processor\t: ARMv7 Processor rev 4 (v7l)\nprocessor\t: 0\nBogoMIPS\t: 1159.06\n\n" +
    "processor\t: 1\nBogoMIPS\t: 1159.06\n\nprocessor\t: 2\nBogoMIPS\t: 1159.06\n\npr" +
    "ocessor\t: 3\nBogoMIPS\t: 1159.06\n\nprocessor\t: 4\nBogoMIPS\t: 1159.06\n\nproc" +
    "essor\t: 5\nBogoMIPS\t: 1159.06\n\nprocessor\t: 6\nBogoMIPS\t: 1159.06\n\nproces" +
    "sor\t: 7\nBogoMIPS\t: 1159.06\n\nFeatures\t: swp half thumb fastmult vfp edsp th" +
    "umbee neon vfpv3 tls vfpv4 idiva idivt \nCPU implementer\t: 0x41\nCPU architectu" +
    "re: 7\nCPU variant\t: 0x0\nCPU part\t: 0xc07\nCPU revision\t: 4\n\nHardware\t: M" +
    "T6592\nRevision\t: 0000\nSerial\t\t: 0000000000000000\n"
    , "yidong"
            });
            insertLib(maps,new String[] {
                "Lenovo_A628t", "Lenovo", "A628t", "A628t_S019_140719", "LENOVO", "Lenovo A628t", "Lenovo_A628t", "", "JDQ39", "user", 
                "release-keys", "", "queen-desktop", "mt6582", "armeabi-v7a", "armeabi", "Lenovo/Lenovo_A628t/A628t:4.2.2/JDQ39/A628t_S019_140719:user/release-keys", "REL", "A628t_S019_140719", "4.2.2", 
                "17", "17", "86337702", "854", "480", "1.5", "1.5", "240", "240", "240", 
                "A628t.V15.P6, 2013/12/30 21:18", "3.4.5", "", "Processor\t: ARMv7 Processor rev 3 (v7l)\nprocessor\t: 0\nBogoMIPS\t: 2590.72\n\n" +
    "processor\t: 1\nBogoMIPS\t: 2590.72\n\nprocessor\t: 2\nBogoMIPS\t: 2590.72\n\npr" +
    "ocessor\t: 3\nBogoMIPS\t: 2590.72\n\nFeatures\t: swp half thumb fastmult vfp eds" +
    "p thumbee neon vfpv3 tls vfpv4 idiva idivt \nCPU implementer\t: 0x41\nCPU archit" +
    "ecture: 7\nCPU variant\t: 0x0\nCPU part\t: 0xc07\nCPU revision\t: 3\n\nHardware\t" +
    ": MT6582\nRevision\t: aaff\nSerial\t\t: 0000000000000000\n"
    , "liantong"
            });
            insertLib(maps,new String[] {
                "LA2-T", "YUSUN", "YUSUN_LA2-T", "LA2-T_V1.0", "YUSUN", "LA2-T", "LA2-T", "", "YUSUNLA2-T", "user", 
                "test-keys", "", "YUSUN", "mt6582", "armeabi-v7a", "armeabi", "YUSUN/LA2-T/YUSUN_LA2-T:4.2.2/YUSUNLA2-T/LA2-T_V1.0:user/test-keys", "REL", "eng..1389788528", "4.2.2", 
                "17", "17", "86330802", "1280", "720", "2.0", "2.0", "320", "320", "320", 
                "MOLY.WR8.W1319.MD.TG.MP.V13, 2013/11/29 11:50", "3.4.5", "Linux version 3.4.5 (queen@build-desktop) (gcc version 4.6.x-google 20120106 (pr" +
    "erelease) (GCC) ) #1 SMP PREEMPT Wed Jan 15 20:21:39 CST 2014\n"
    , "Processor\t: ARMv7 Processor rev 3 (v7l)\nprocessor\t: 0\nBogoMIPS\t: 2590.72\n\n" +
    "processor\t: 1\nBogoMIPS\t: 2590.72\n\nprocessor\t: 2\nBogoMIPS\t: 2590.72\n\npr" +
    "ocessor\t: 3\nBogoMIPS\t: 2590.72\n\nFeatures\t: swp half thumb fastmult vfp eds" +
    "p thumbee neon vfpv3 tls vfpv4 idiva idivt \nCPU implementer\t: 0x41\nCPU archit" +
    "ecture: 7\nCPU variant\t: 0x0\nCPU part\t: 0xc07\nCPU revision\t: 3\n\nHardware\t" +
    ": MT6582\nRevision\t: aaff\nSerial\t\t: 0000000000000000\n"
    , "yidong"
            });
            insertLib(maps,new String[] {
                "yulong89_we_adv_jb2", "Coolpad", "Coolpad7296S", "4.2.022.P0.140308.7296S", "Coolpad", "Coolpad 7296S", "Coolpad7296S", "", "JDQ39", "user", 
                "release-keys", "mine", "mine", "mt6589", "armeabi-v7a", "armeabi", "Coolpad/Coolpad7296S/Coolpad7296S:4.2.2/JDQ39/4.2.022.P0.140308.7296S:user/relea" +
    "se-keys"
    , "REL", "4.2.022.P0.140308.7296S", "4.2.2", 
                "17", "17", "86327802", "960", "540", "1.5", "1.5", "240", "240", "240", 
                "MOLY.WR8.W1248.MD.WG.MP.V10.F1, 2014/03/08 11:59", "3.4.5", "Linux version 3.4.5 (mine@mine) (gcc version 4.6.x-google 20120106 (prerelease) " +
    "(GCC) ) #1 SMP PREEMPT Sat Mar 8 12:09:00 CST 2014\n"
    , "Processor\t: ARMv7 Processor rev 2 (v7l)\nprocessor\t: 0\nBogoMIPS\t: 2439.94\n\n" +
    "processor\t: 1\nBogoMIPS\t: 2000.48\n\nprocessor\t: 2\nBogoMIPS\t: 2000.48\n\npr" +
    "ocessor\t: 3\nBogoMIPS\t: 2000.48\n\nFeatures\t: swp half thumb fastmult vfp eds" +
    "p thumbee neon vfpv3 tls vfpv4 idiva idivt \nCPU implementer\t: 0x41\nCPU archit" +
    "ecture: 7\nCPU variant\t: 0x0\nCPU part\t: 0xc07\nCPU revision\t: 2\n\nHardware\t" +
    ": MT6589\nRevision\t: 0000\nSerial\t\t: 0000000000000000\n"
    , "yidong"
            });
            insertLib(maps,new String[] {
                "yk828_v30_emmc", "Xianmi", "S800", "ALPS.KK1.MP7.V1", "Xianmi", "S800", "yk828_v30_emmc", "", "KOT49H", "user", 
                "test-keys", "root", "tt-desktop", "mt6571", "armeabi-v7a", "armeabi", "waterworld/yk828_v30_emmc/yk828_v30_emmc:4.4.2/KOT49H/1411654849:user/test-keys", "REL", "eng.root.1411654849", "4.4.2", 
                "19", "19", "86326983", "854", "480", "1.5", "1.5", "240", "240", "240", 
                "MOLY.WR8.W1315.MD.WG.MP.V43, 2014/05/12 18:53", "3.4.67", "Linux version 3.4.67 (root@tt-desktop) (gcc version 4.7 (GCC) ) #3 SMP PREEMPT T" +
    "hu Sep 25 22:20:36 HKT 2014\n"
    , "Processor\t: ARMv7 Processor rev 4 (v7l)\nprocessor\t: 0\nBogoMIPS\t: 1993.93\n\n" +
    "processor\t: 1\nBogoMIPS\t: 1993.93\n\nFeatures\t: swp half thumb fastmult vfp e" +
    "dsp thumbee neon vfpv3 tls vfpv4 idiva idivt \nCPU implementer\t: 0x41\nCPU arch" +
    "itecture: 7\nCPU variant\t: 0x0\nCPU part\t: 0xc07\nCPU revision\t: 4\n\nHardwar" +
    "e\t: MT6571\nRevision\t: 0000\nSerial\t\t: 0000000000000000\n"
    , "yidong"
            });
            insertLib(maps,new String[] {
                "q9ts_lg2_iph", "alps", "Q9", "Q9TS.LG2.IPH.Q.S3TAKTM1.0825.V3.04", "Q9", "IPH-3", "Q9", "", "KOT49H", "user", 
                "test-keys", "Q9", "tyduser5-desktop", "mt6571", "armeabi-v7a", "armeabi", "alps/q9ts_lg2_iph/q9ts_lg2_iph:4.4.2/KOT49H/1408948889:user/test-keys", "REL", "eng.program24.1408948889", "4.4.2", 
                "19", "19", "86326202", "960", "540", "1.3499999", "1.5", "240", "240", "240", 
                "MOLY.WR8.W1328.MD.TG.MP.V22, 2014/07/14 22:36", "3.4.67", "Linux version 3.4.67 (program24@tyduser5-desktop) (gcc version 4.7 (GCC) ) #1 SM" +
    "P PREEMPT Mon Aug 25 14:41:08 CST 2014\n"
    , "Processor\t: ARMv7 Processor rev 4 (v7l)\nprocessor\t: 0\nBogoMIPS\t: 2589.52\n\n" +
    "processor\t: 1\nBogoMIPS\t: 2589.52\n\nFeatures\t: swp half thumb fastmult vfp e" +
    "dsp thumbee neon vfpv3 tls vfpv4 idiva idivt \nCPU implementer\t: 0x41\nCPU arch" +
    "itecture: 7\nCPU variant\t: 0x0\nCPU part\t: 0xc07\nCPU revision\t: 4\n\nHardwar" +
    "e\t: MT6571\nRevision\t: 0000\nSerial\t\t: 0000000000000000\n"
    , "yidong"
            });
            insertLib(maps,new String[] {
                "M228A", "mikee", "M228A", "M228A 20140717-191035", "mikee", "M228A", "M228A", "", "JDQ39", "user", 
                "test-keys", "root", "tomlee-desktop", "MT6592", "armeabi-v7a", "armeabi", "alps/yk828_emmc/yk828_emmc:4.2.2/JDQ39/1405595296:user/test-keys", "REL", "eng.root.1405595296", "4.2.2", 
                "17", "17", "86325602", "854", "480", "1.5", "1.5", "240", "160.42105", "159.49706", 
                "MOLY.WR8.W1315.MD.WG.MP.V4.P11, 2013/12/05 21:47", "3.4.5", "Linux version 3.4.5 (root@tomlee-desktop) (gcc version 4.6.x-google 20120106 (pr" +
    "erelease) (GCC) ) #1 SMP PREEMPT Thu Jul 17 19:07:54 CST 2014\n"
    , "Processor\t: ARMv7 Processor rev 3 (v7l)\nprocessor\t: 0\nBogoMIPS\t: 1993.93\n\n" +
    "Features\t: swp half thumb fastmult vfp edsp thumbee neon vfpv3 tls vfpv4 idiva " +
    "idivt \nCPU implementer\t: 0x41\nCPU architecture: 7\nCPU variant\t: 0x0\nCPU pa" +
    "rt\t: 0xc07\nCPU revision\t: 3\n\nHardware\t: MT6592\nRevision\t: 0000\nSerial\t" +
    "\t: 0000000000000000\n"
    , "liantong"
            });
            insertLib(maps,new String[] {
                "OPPO82_13065", "OPPO", "R829T", "R829T_11_140111", "OPPO", "R829T", "OPPO82_13065", "", "JDQ39", "user", 
                "release-keys", "root", "ubuntu", "mt6582", "armeabi-v7a", "armeabi", "OPPO/OPPO82_13065/R829T:4.2.2/JDQ39/1383761317:user/release-keys", "REL", "eng.root.1383761317", "4.2.2", 
                "17", "17", "86321602", "1280", "720", "2.48", "2.0", "320", "294.967", "295.563", 
                "MOLY.WR8.W1319.MD.TG.MP.V14.F2.P9, 2013/12/04 09:49", "3.4.5", "Linux version 3.4.5 (root@ubuntu) (gcc version 4.6.x-google 20120106 (prerelease" +
    ") (GCC) ) #1 SMP PREEMPT Sat Jan 11 16:01:26 CST 2014\n"
    , "Processor\t: ARMv7 Processor rev 3 (v7l)\nprocessor\t: 0\nBogoMIPS\t: 2072.57\n\n" +
    "processor\t: 1\nBogoMIPS\t: 2072.57\n\nprocessor\t: 2\nBogoMIPS\t: 2072.57\n\npr" +
    "ocessor\t: 3\nBogoMIPS\t: 2072.57\n\nFeatures\t: swp half thumb fastmult vfp eds" +
    "p thumbee neon vfpv3 tls vfpv4 idiva idivt \nCPU implementer\t: 0x41\nCPU archit" +
    "ecture: 7\nCPU variant\t: 0x0\nCPU part\t: 0xc07\nCPU revision\t: 3\n\nHardware\t" +
    ": MT6582\nRevision\t: 0000\nSerial\t\t: 0000000000000000\n"
    , "yidong"
            });
            insertLib(maps,new String[] {
                "bbk89_yidong_jb2", "vivo", "bbk89_yidong_jb2", "ALPS.JB2.TDD.MP.V1", "BBK", "vivo X3t", "bbk89_yidong_jb2", "", "JOP40D", "user", 
                "test-keys", "compiler", "compiler011", "mt6589", "armeabi-v7a", "armeabi", "vivo/bbk89_yidong_jb2/bbk89_yidong_jb2:4.2.1/JOP40D/1397137142:user/test-keys", "REL", "eng.compiler.1397137142", "4.2.1", 
                "17", "17", "86321302", "1280", "720", "2.0", "2.0", "320", "320", "320", 
                "MOLY.WR8.W1301.MD.TG.MP.V6.F8.P7, 2014/03/18 11:55", "3.4.5", "Linux version 3.4.5 (compiler@compiler011) (gcc version 4.6.x-google 20120106 (p" +
    "rerelease) (GCC) ) #1 SMP PREEMPT Thu Apr 10 21:38:42 CST 2014\n"
    , "Processor\t: ARMv7 Processor rev 2 (v7l)\nprocessor\t: 0\nBogoMIPS\t: 3043.37\n\n" +
    "processor\t: 1\nBogoMIPS\t: 2000.48\n\nprocessor\t: 2\nBogoMIPS\t: 2000.48\n\nFe" +
    "atures\t: swp half thumb fastmult vfp edsp thumbee neon vfpv3 tls vfpv4 idiva id" +
    "ivt \nCPU implementer\t: 0x41\nCPU architecture: 7\nCPU variant\t: 0x0\nCPU part" +
    "\t: 0xc07\nCPU revision\t: 2\n\nHardware\t: MT6589\nRevision\t: 0000\nSerial\t\t" +
    ": 0000000000000000\n"
    , "liantong"
            });
            insertLib(maps,new String[] {
                "bbk89_yidong_jb2", "vivo", "bbk89_yidong_jb2", "ALPS.JB2.TDD.MP.V1", "BBK", "vivo X3t", "bbk89_yidong_jb2", "", "JOP40D", "user", 
                "test-keys", "compiler", "compiler020", "mt6589", "armeabi-v7a", "armeabi", "vivo/bbk89_yidong_jb2/bbk89_yidong_jb2:4.2.1/JOP40D/1411027394:user/test-keys", "REL", "eng.compiler.1411027394", "4.2.1", 
                "17", "17", "86321302", "1280", "720", "2.0", "2.0", "320", "320", "320", 
                "MOLY.WR8.W1301.MD.TG.MP.V6.F8.P10, 2014/06/26 12:12", "3.4.5", "Linux version 3.4.5 (compiler@compiler020) (gcc version 4.6.x-google 20120106 (p" +
    "rerelease) (GCC) ) #1 SMP PREEMPT Thu Sep 18 16:02:37 CST 2014\n"
    , "Processor\t: ARMv7 Processor rev 2 (v7l)\nprocessor\t: 0\nBogoMIPS\t: 3043.37\n\n" +
    "processor\t: 1\nBogoMIPS\t: 2000.48\n\nprocessor\t: 2\nBogoMIPS\t: 2000.48\n\nFe" +
    "atures\t: swp half thumb fastmult vfp edsp thumbee neon vfpv3 tls vfpv4 idiva id" +
    "ivt \nCPU implementer\t: 0x41\nCPU architecture: 7\nCPU variant\t: 0x0\nCPU part" +
    "\t: 0xc07\nCPU revision\t: 2\n\nHardware\t: MT6589\nRevision\t: 0000\nSerial\t\t" +
    ": 0000000000000000\n"
    , "yidong"
            });
            insertLib(maps,new String[] {
                "bbk89_yidong_jb2", "vivo", "bbk89_yidong_jb2", "ALPS.JB2.TDD.MP.V1.62", "BBK", "vivo X3t", "bbk89_yidong_jb2", "", "JDQ39", "user", 
                "test-keys", "compiler", "compiler015", "mt6589", "armeabi-v7a", "armeabi", "vivo/bbk89_yidong_jb2/bbk89_yidong_jb2:4.2.2/JDQ39/:user/test-keys", "REL", "61", "4.2.2", 
                "17", "17", "86321302", "1280", "720", "2.0", "2.0", "320", "320", "320", 
                "MOLY.WR8.W1301.MD.TG.MP.V50.P1, 2014/02/24 11:01", "3.4.5", "Linux version 3.4.5 (compiler@compiler015) (gcc version 4.6.x-google 20120106 (p" +
    "rerelease) (GCC) ) #1 SMP PREEMPT Wed Aug 13 17:58:24 CST 2014\n"
    , "Processor\t: ARMv7 Processor rev 2 (v7l)\nprocessor\t: 0\nBogoMIPS\t: 3043.37\n\n" +
    "processor\t: 1\nBogoMIPS\t: 3043.37\n\nprocessor\t: 2\nBogoMIPS\t: 3043.37\n\nFe" +
    "atures\t: swp half thumb fastmult vfp edsp thumbee neon vfpv3 tls vfpv4 idiva id" +
    "ivt \nCPU implementer\t: 0x41\nCPU architecture: 7\nCPU variant\t: 0x0\nCPU part" +
    "\t: 0xc07\nCPU revision\t: 2\n\nHardware\t: MT6589\nRevision\t: 0000\nSerial\t\t" +
    ": 0000000000000000\n"
    , "yidong"
            });
            insertLib(maps,new String[] {
                "sofinatd", "Lenovo", "S658t", "VIBEUI_V2.0_1447_7.5.1_ST_S658t", "LENOVO", "Lenovo S658t", "sofinatd", "", "KOT49H", "user", 
                "release-keys", "buildslave", "shws38", "mt6582", "armeabi-v7a", "armeabi", "Lenovo/sofinatd/S658t:4.4.2/KOT49H/VIBEUI_V2.0_1447_7.5.1_ST_S658t.:user/release" +
    "-keys"
    , "REL", "VIBEUI_V2.0_1447_7.5.1_ST_S658t", "4.4.2", 
                "19", "19", "86320602", "960", "540", "1.5", "1.5", "240", "240", "240", 
                "S658T.V100, 2014/03/18 12:32", "3.4.67", "Linux version 3.4.67 (buildslave@shws38) (gcc version 4.7 (GCC) ) #1 SMP PREEMPT" +
    " Tue Nov 11 21:21:12 CST 2014\n"
    , "Processor\t: ARMv7 Processor rev 3 (v7l)\nprocessor\t: 0\nBogoMIPS\t: 2590.72\n\n" +
    "processor\t: 1\nBogoMIPS\t: 2590.72\n\nprocessor\t: 2\nBogoMIPS\t: 2590.72\n\npr" +
    "ocessor\t: 3\nBogoMIPS\t: 2590.72\n\nFeatures\t: swp half thumb fastmult vfp eds" +
    "p thumbee neon vfpv3 tls vfpv4 idiva idivt \nCPU implementer\t: 0x41\nCPU archit" +
    "ecture: 7\nCPU variant\t: 0x0\nCPU part\t: 0xc07\nCPU revision\t: 3\n\nHardware\t" +
    ": MT6582\nRevision\t: 0000\nSerial\t\t: 0000000000000000\n"
    , "yidong"
            });
            insertLib(maps,new String[] {
                "sp8830ec", "Lenovo", "A398tp", "Lenovo A398t+_S112_131214", "LENOVO", "Lenovo A398t+", "A398tp", "", "JZO54K", "user", 
                "release-keys", "justin", "techain-desktop", "sc8830", "armeabi-v7a", "armeabi", "Lenovo/A398tp/A398tp:4.1.2/JZO54K/A398t+_S423_140408:user/release-keys", "REL", "20140408", "4.1.2", 
                "16", "16", "86320502", "854", "480", "1.5", "1.5", "240", "254", "255.19528", 
                "TM_BASE_13B_W13.53\nsc8830_modem\n01-01-2014 20:56:35", "3.4.5", "Linux version 3.4.5 (justin@techain-desktop) (gcc version 4.6.x-google 20120106 " +
    "(prerelease) (GCC) ) #1 SMP PREEMPT Tue Apr 8 19:06:01 HKT 2014\n"
    , "Processor\t: ARMv7 Processor rev 4 (v7l)\nprocessor\t: 0\nBogoMIPS\t: 2000.48\n\n" +
    "processor\t: 1\nBogoMIPS\t: 2000.48\n\nFeatures\t: swp half thumb fastmult vfp e" +
    "dsp neon vfpv3 tls vfpv4 idiva idivt \nCPU implementer\t: 0x41\nCPU architecture" +
    ": 7\nCPU variant\t: 0x0\nCPU part\t: 0xc07\nCPU revision\t: 4\n\nHardware\t: sc8" +
    "830\nRevision\t: 0000\nSerial\t\t: 0000000000000000\n"
    , "yidong"
            });
            insertLib(maps,new String[] {
                "sp8830ec", "Lenovo", "A398tp", "Lenovo A398t+_S112_131214", "LENOVO", "Lenovo A398t+", "A398tp", "", "JZO54K", "user", 
                "release-keys", "justin", "techain-desktop", "sc8830", "armeabi-v7a", "armeabi", "Lenovo/A398tp/A398tp:4.1.2/JZO54K/A398t+_S422_140318:user/release-keys", "REL", "20140318", "4.1.2", 
                "16", "16", "86320502", "854", "480", "1.5", "1.5", "240", "254", "255.19528", 
                "TM_BASE_13B_W13.53\nsc8830_modem\n01-01-2014 20:56:35", "3.4.5", "Linux version 3.4.5 (justin@techain-desktop) (gcc version 4.6.x-google 20120106 " +
    "(prerelease) (GCC) ) #1 SMP PREEMPT Tue Mar 18 18:51:06 HKT 2014\n"
    , "Processor\t: ARMv7 Processor rev 4 (v7l)\nprocessor\t: 0\nBogoMIPS\t: 2000.48\n\n" +
    "Features\t: swp half thumb fastmult vfp edsp neon vfpv3 tls vfpv4 idiva idivt \n" +
    "CPU implementer\t: 0x41\nCPU architecture: 7\nCPU variant\t: 0x0\nCPU part\t: 0x" +
    "c07\nCPU revision\t: 4\n\nHardware\t: sc8830\nRevision\t: 0000\nSerial\t\t: 0000" +
    "000000000000\n"
    , "yidong"
            });
            insertLib(maps,new String[] {
                "sp8830ec", "Lenovo", "A398tp", "Lenovo A398t+_S112_131214", "LENOVO", "Lenovo A398t+", "A398tp", "", "JZO54K", "user", 
                "release-keys", "justin", "techain-desktop", "sc8830", "armeabi-v7a", "armeabi", "Lenovo/A398tp/A398tp:4.1.2/JZO54K/A398t+_S423_140408:user/release-keys", "REL", "20140408", "4.1.2", 
                "16", "16", "86320502", "854", "480", "1.9499999", "1.5", "240", "254", "255.19528", 
                "TM_BASE_13B_W13.53\nsc8830_modem\n01-01-2014 20:56:35", "3.4.5", "Linux version 3.4.5 (justin@techain-desktop) (gcc version 4.6.x-google 20120106 " +
    "(prerelease) (GCC) ) #1 SMP PREEMPT Tue Apr 8 19:06:01 HKT 2014\n"
    , "Processor\t: ARMv7 Processor rev 4 (v7l)\nprocessor\t: 0\nBogoMIPS\t: 2000.48\n\n" +
    "processor\t: 1\nBogoMIPS\t: 2000.48\n\nprocessor\t: 2\nBogoMIPS\t: 1987.37\n\npr" +
    "ocessor\t: 3\nBogoMIPS\t: 1987.37\n\nFeatures\t: swp half thumb fastmult vfp eds" +
    "p neon vfpv3 tls vfpv4 idiva idivt \nCPU implementer\t: 0x41\nCPU architecture: " +
    "7\nCPU variant\t: 0x0\nCPU part\t: 0xc07\nCPU revision\t: 4\n\nHardware\t: sc883" +
    "0\nRevision\t: 0000\nSerial\t\t: 0000000000000000\n"
    , "yidong"
            });
            insertLib(maps,new String[] {
                "", "Lenovo", "A788t", "LenovoA788t_S11373_140421", "LENOVO", "Lenovo A788t", "A788t", "", "S103", "user", 
                "release-keys", "Android", "AndroidBuild", "pxa1l88", "armeabi-v7a", "armeabi", "Lenovo/A788t/A788t:4.3/S103/20140421.135409:user/release-keys", "REL", "LenovoA788t_S11373_140421", "4.3", 
                "18", "18", "86318402", "854", "480", "1.5", "1.5", "240", "160", "159", 
                "HL_CP_3.47.025::3.47.024::sky_ttc_rC0_v3_001_049_Lenovo_a", "3.4.39", "Linux version 3.4.39 (Android-bot@Android-server) (gcc version 4.7 (GCC) ) #2 SM" +
    "P PREEMPT Mon Apr 21 14:06:54 CST 2014\n"
    , "Processor\t: ARMv7 Processor rev 3 (v7l)\nprocessor\t: 0\nBogoMIPS\t: 2341.13\n\n" +
    "processor\t: 1\nBogoMIPS\t: 2341.13\n\nprocessor\t: 2\nBogoMIPS\t: 2341.13\n\npr" +
    "ocessor\t: 3\nBogoMIPS\t: 2341.13\n\nFeatures\t: swp half thumb fastmult vfp eds" +
    "p thumbee neon vfpv3 tls vfpv4 idiva idivt \nCPU implementer\t: 0x41\nCPU archit" +
    "ecture: 7\nCPU variant\t: 0x0\nCPU part\t: 0xc07\nCPU revision\t: 3\n\nHardware\t" +
    ": PXA1L88\nRevision\t: 0000\nSerial\t\t: 0000000000000000\n"
    , "yidong"
            });
            insertLib(maps,new String[] {
                "", "Lenovo", "A788t", "LenovoA788t_S11373_140421", "LENOVO", "Lenovo A788t", "A788t", "", "S103", "user", 
                "release-keys", "Android", "AndroidBuild", "pxa1l88", "armeabi-v7a", "armeabi", "Lenovo/A788t/A788t:4.3/S103/20140421.135409:user/release-keys", "REL", "LenovoA788t_S11373_140421", "4.3", 
                "18", "18", "86318402", "854", "480", "1.5", "1.5", "240", "160", "159", 
                "HL_CP_3.47.025::3.47.024::sky_ttc_rC0_v3_001_049_Lenovo_a", "3.4.39", "Linux version 3.4.39 (Android-bot@Android-server) (gcc version 4.7 (GCC) ) #2 SM" +
    "P PREEMPT Mon Apr 21 14:06:54 CST 2014\n"
    , "Processor\t: ARMv7 Processor rev 3 (v7l)\nprocessor\t: 0\nBogoMIPS\t: 1235.99\n\n" +
    "processor\t: 1\nBogoMIPS\t: 1235.99\n\nprocessor\t: 2\nBogoMIPS\t: 1235.99\n\npr" +
    "ocessor\t: 3\nBogoMIPS\t: 1235.99\n\nFeatures\t: swp half thumb fastmult vfp eds" +
    "p thumbee neon vfpv3 tls vfpv4 idiva idivt \nCPU implementer\t: 0x41\nCPU archit" +
    "ecture: 7\nCPU variant\t: 0x0\nCPU part\t: 0xc07\nCPU revision\t: 3\n\nHardware\t" +
    ": PXA1L88\nRevision\t: 0000\nSerial\t\t: 0000000000000000\n"
    , "yidong"
            });
            insertLib(maps,new String[] {
                "mx3", "Meizu", "mx3", "Flyme OS 3.7.3A", "Meizu", "M355", "meizu_mx3", "", "KTU84P", "user", 
                "release-keys", "flyme", "mz-builder-1", "mx3", "armeabi-v7a", "armeabi", "Meizu/meizu_mx3/mx3:4.4.4/KTU84P/m35x.Flyme_OS_3.7.3.20140909113158:user/release" +
    "-keys"
    , "REL", "m35x.Flyme_OS_3.7.3.20140909113158", "4.4.4", 
                "19", "19", "86315102", "1800", "1080", "2.5", "2.5", "400", "415.636", "415.636", 
                "W12.45-30", "3.4.43-user-g66efe75", "Linux version 3.4.43-user-g66efe75 (mobileapp@mobileapp) (gcc version 4.6.x-goog" +
    "le 20120106 (prerelease) (GCC) ) #2 SMP PREEMPT Tue Sep 9 11:16:30 CST 2014\n"
    , "Processor\t: ARMv7 Processor rev 3 srev 0x23 (v7l)\nprocessor\t: 0\nCluster\t\t:" +
    " CA15\nBogoMIPS\t: 1590.88\n\nprocessor\t: 1\nCluster\t\t: CA15\nBogoMIPS\t: 159" +
    "0.88\n\nprocessor\t: 2\nCluster\t\t: CA15\nBogoMIPS\t: 1590.88\n\nprocessor\t: 3" +
    "\nCluster\t\t: CA15\nBogoMIPS\t: 1590.88\n\nFeatures\t: swp half thumb fastmult " +
    "vfp edsp neon vfpv3 tls vfpv4 idiva idivt \nCPU implementer\t: 0x41\nCPU archite" +
    "cture: 7\nCPU variant\t: 0x2\nCPU part\t: 0xc0f\nCPU revision\t: 3\nCPU asv grou" +
    "p\t: 5\nCPU asv version\t: 1\nCPU boot cluster: CA15\n\nHardware\t: MX3\nRevisio" +
    "n\t: 5410\nDMEM\t\t: D25\nSerial\t\t: 0000000000000000\n"
    , "yidong"
            });
            insertLib(maps,new String[] {
                "mx3", "Meizu", "mx3", "Flyme OS 3.7.3A", "Meizu", "M355", "meizu_mx3", "", "KTU84P", "user", 
                "release-keys", "flyme", "mz-builder-1", "mx3", "armeabi-v7a", "armeabi", "Meizu/meizu_mx3/mx3:4.4.4/KTU84P/m35x.Flyme_OS_3.7.3.20140909113158:user/release" +
    "-keys"
    , "REL", "m35x.Flyme_OS_3.7.3.20140909113158", "4.4.4", 
                "19", "19", "86315102", "1800", "1080", "2.8", "2.5", "400", "415.636", "415.636", 
                "W12.45-30", "3.4.43-user-g66efe75", "Linux version 3.4.43-user-g66efe75 (mobileapp@mobileapp) (gcc version 4.6.x-goog" +
    "le 20120106 (prerelease) (GCC) ) #2 SMP PREEMPT Tue Sep 9 11:16:30 CST 2014\n"
    , "Processor\t: ARMv7 Processor rev 2 srev 0x23 (v7l)\nprocessor\t: 0\nCluster\t\t:" +
    " CA7\nBogoMIPS\t: 1590.88\n\nprocessor\t: 1\nCluster\t\t: CA7\nBogoMIPS\t: 1590." +
    "88\n\nprocessor\t: 2\nCluster\t\t: CA7\nBogoMIPS\t: 1590.88\n\nprocessor\t: 3\nC" +
    "luster\t\t: CA7\nBogoMIPS\t: 1590.88\n\nFeatures\t: swp half thumb fastmult vfp " +
    "edsp neon vfpv3 tls vfpv4 idiva idivt \nCPU implementer\t: 0x41\nCPU architectur" +
    "e: 7\nCPU variant\t: 0x0\nCPU part\t: 0xc07\nCPU revision\t: 2\nCPU asv group\t:" +
    " 6\nCPU asv version\t: 1\nCPU boot cluster: CA15\n\nHardware\t: MX3\nRevision\t:" +
    " 5410\nDMEM\t\t: D25\nSerial\t\t: 0000000000000000\n"
    , "yidong"
            });
            insertLib(maps,new String[] {
                "mx3", "Meizu", "mx3", "Flyme OS 3.5.2 (A19220)", "Meizu", "M356", "meizu_mx3", "", "JOP40D", "user", 
                "release-keys", "flyme", "mz-builder-1", "mx3", "armeabi-v7a", "armeabi", "Meizu/meizu_mx3/mx3:4.2.1/JOP40D/m35x.Flyme_OS_3.5.2.19220:user/release-keys", "REL", "m35x.Flyme_OS_3.5.2.19220", "4.2.1", 
                "17", "17", "86315102", "1800", "1080", "2.5", "2.5", "400", "415.636", "415.636", 
                "W12.45-30", "3.4.43-user-gea3150d", "Linux version 3.4.43-user-gea3150d (mobileapp@mobileapp) (gcc version 4.6.x-goog" +
    "le 20120106 (prerelease) (GCC) ) #2 SMP PREEMPT Mon Apr 21 09:41:49 CST 2014\n"
    , "Processor\t: ARMv7 Processor rev 2 srev 0x23 (v7l)\nprocessor\t: 0\nCluster\t\t:" +
    " CA7\nBogoMIPS\t: 1590.88\n\nprocessor\t: 1\nCluster\t\t: CA7\nBogoMIPS\t: 1590." +
    "88\n\nprocessor\t: 2\nCluster\t\t: CA7\nBogoMIPS\t: 1590.88\n\nprocessor\t: 3\nC" +
    "luster\t\t: CA7\nBogoMIPS\t: 1590.88\n\nFeatures\t: swp half thumb fastmult vfp " +
    "edsp neon vfpv3 tls vfpv4 idiva idivt \nCPU implementer\t: 0x41\nCPU architectur" +
    "e: 7\nCPU variant\t: 0x0\nCPU part\t: 0xc07\nCPU revision\t: 2\nCPU asv group\t:" +
    " 4\nCPU asv version\t: 1\nCPU boot cluster: CA15\n\nHardware\t: MX3\nRevision\t:" +
    " 5410\nDMEM\t\t: D25\nSerial\t\t: 0000000000000000\n"
    , "yidong"
            });
            insertLib(maps,new String[] {
                "mx3", "Meizu", "mx3", "Flyme OS 3.7.3A", "Meizu", "M356", "meizu_mx3", "", "KTU84P", "user", 
                "release-keys", "flyme", "mz-builder-1", "mx3", "armeabi-v7a", "armeabi", "Meizu/meizu_mx3/mx3:4.4.4/KTU84P/m35x.Flyme_OS_3.7.3.20140909113158:user/release" +
    "-keys"
    , "REL", "m35x.Flyme_OS_3.7.3.20140909113158", "4.4.4", 
                "19", "19", "86315102", "1800", "1080", "2.5", "2.5", "400", "415.636", "415.636", 
                "W12.45-30", "3.4.43-user-g66efe75", "Linux version 3.4.43-user-g66efe75 (mobileapp@mobileapp) (gcc version 4.6.x-goog" +
    "le 20120106 (prerelease) (GCC) ) #2 SMP PREEMPT Tue Sep 9 11:16:30 CST 2014\n"
    , "Processor\t: ARMv7 Processor rev 3 srev 0x23 (v7l)\nprocessor\t: 0\nCluster\t\t:" +
    " CA15\nBogoMIPS\t: 1590.88\n\nprocessor\t: 1\nCluster\t\t: CA15\nBogoMIPS\t: 159" +
    "0.88\n\nprocessor\t: 2\nCluster\t\t: CA15\nBogoMIPS\t: 1590.88\n\nprocessor\t: 3" +
    "\nCluster\t\t: CA15\nBogoMIPS\t: 1590.88\n\nFeatures\t: swp half thumb fastmult " +
    "vfp edsp neon vfpv3 tls vfpv4 idiva idivt \nCPU implementer\t: 0x41\nCPU archite" +
    "cture: 7\nCPU variant\t: 0x2\nCPU part\t: 0xc0f\nCPU revision\t: 3\nCPU asv grou" +
    "p\t: 3\nCPU asv version\t: 1\nCPU boot cluster: CA15\n\nHardware\t: MX3\nRevisio" +
    "n\t: 5410\nDMEM\t\t: D25\nSerial\t\t: 0000000000000000\n"
    , "yidong"
            });
            insertLib(maps,new String[] {
                "t978", "Hisense", "t978", "T922.6.02.00.00", "Hisense", "HS-T978", "t978", "", "JDQ39", "user", 
                "release-keys", "root", "ubuntu", "mt6582", "armeabi-v7a", "armeabi", "Hisense/t978/t978:4.2.2/JDQ39/1385031957:user/release-keys", "REL", "1385031957", "4.2.2", 
                "17", "17", "86310002", "960", "540", "1.5", "1.5", "240", "240", "240", 
                "MOLY.WR8.W1319.MD.TG.MP.V14.P9, 2013/11/27 16:34", "3.4.5", "Linux version 3.4.5 (root@ubuntu) (gcc version 4.6.x-google 20120106 (prerelease" +
    ") (GCC) ) #1 SMP PREEMPT Fri Dec 20 22:54:52 PST 2013\n"
    , "Processor\t: ARMv7 Processor rev 3 (v7l)\nprocessor\t: 0\nBogoMIPS\t: 2590.72\n\n" +
    "processor\t: 1\nBogoMIPS\t: 2590.72\n\nprocessor\t: 2\nBogoMIPS\t: 2590.72\n\npr" +
    "ocessor\t: 3\nBogoMIPS\t: 2590.72\n\nFeatures\t: swp half thumb fastmult vfp eds" +
    "p thumbee neon vfpv3 tls vfpv4 idiva idivt \nCPU implementer\t: 0x41\nCPU archit" +
    "ecture: 7\nCPU variant\t: 0x0\nCPU part\t: 0xc07\nCPU revision\t: 3\n\nHardware\t" +
    ": MT6582\nRevision\t: 0000\nSerial\t\t: 0000000000000000\n"
    , "liantong"
            });
            insertLib(maps,new String[] {
                "tl920haier", "Haier", "tl920haier", "HT-I857-H01-S03-yidong", "HAIER", "HT-I857", "full_tl920haier_v104", "", "JOP40D", "user", 
                "test-keys", "root", "wangshuai", "leadcoreinnopower", "armeabi-v7a", "armeabi", "Haier/full_tl920haier_v104/tl920haier:4.2.1/JOP40D/eng.20140318.182654:user/test" +
    "-keys"
    , "REL", "eng.20140318.182654", "4.2.1", 
                "17", "17", "86309702", "854", "480", "1.5", "1.5", "240", "160.42105", "159.49706", 
                "LM_2.30.20.P01.R09.000_20131127", "3.4.5", "Linux version 3.4.5 (root@wangshuai) (gcc version 4.6.x-google 20120106 (prerele" +
    "ase) (GCC) ) #1 SMP PREEMPT Tue Mar 18 18:51:17 CST 2014\n"
    , "Processor\t: ARMv7 Processor rev 3 (v7l)\nprocessor\t: 0\nBogoMIPS\t: 2380.59\n\n" +
    "processor\t: 1\nBogoMIPS\t: 2380.59\n\nprocessor\t: 2\nBogoMIPS\t: 2387.14\n\npr" +
    "ocessor\t: 3\nBogoMIPS\t: 2387.14\n\nFeatures\t: swp half thumb fastmult vfp eds" +
    "p neon vfpv3 tls vfpv4 idiva idivt \nCPU implementer\t: 0x41\nCPU architecture: " +
    "7\nCPU variant\t: 0x0\nCPU part\t: 0xc07\nCPU revision\t: 3\n\nHardware\t: Leadc" +
    "ore Innopower\nRevision\t: 0000\nSerial\t\t: 0000000000000000\n"
    , "yidong"
            });
            insertLib(maps,new String[] {
                "tl920haier", "Haier", "tl920haier", "HT-I857-H01-S03-yidong", "HAIER", "HT-I857", "full_tl920haier_v104", "", "JOP40D", "user", 
                "test-keys", "root", "wangshuai", "leadcoreinnopower", "armeabi-v7a", "armeabi", "Haier/full_tl920haier_v104/tl920haier:4.2.1/JOP40D/eng.20140403.101900:user/test" +
    "-keys"
    , "REL", "eng.20140403.101900", "4.2.1", 
                "17", "17", "86309702", "854", "480", "1.5", "1.5", "240", "160.42105", "159.49706", 
                "LM_2.30.20.P01.R09.000_20131127", "3.4.5", "Linux version 3.4.5 (root@wangshuai) (gcc version 4.6.x-google 20120106 (prerele" +
    "ase) (GCC) ) #1 SMP PREEMPT Thu Apr 3 10:43:26 CST 2014\n"
    , "Processor\t: ARMv7 Processor rev 3 (v7l)\nprocessor\t: 0\nBogoMIPS\t: 2380.59\n\n" +
    "processor\t: 1\nBogoMIPS\t: 2380.59\n\nprocessor\t: 2\nBogoMIPS\t: 2387.14\n\npr" +
    "ocessor\t: 3\nBogoMIPS\t: 2387.14\n\nFeatures\t: swp half thumb fastmult vfp eds" +
    "p neon vfpv3 tls vfpv4 idiva idivt \nCPU implementer\t: 0x41\nCPU architecture: " +
    "7\nCPU variant\t: 0x0\nCPU part\t: 0xc07\nCPU revision\t: 3\n\nHardware\t: Leadc" +
    "ore Innopower\nRevision\t: 0000\nSerial\t\t: 0000000000000000\n"
    , "yidong"
            });
            insertLib(maps,new String[] {
                "Xiaomi", "Xiaomi", "Xiaomi", "HM 1STD 20140802-122108", "Xiaomi", "HM 1STD", "HM 1STD", "", "JDQ39", "user", 
                "test-keys", "tiankun", "tiankun-desktop", "mt6572", "armeabi-v7a", "armeabi", "alps/vanzo72_wet_jb3/vanzo72_wet_jb3:4.2.2/JDQ39/1406952815:user/test-keys", "REL", "eng.tiankun.1406952815", "4.2.2", 
                "17", "17", "86309202", "960", "540", "1.5", "1.5", "240", "159.48837", "160.42105", 
                "MOLY.WR8.W1319.MD.TG.MP.V1.P23, 2013/12/07 10:21", "3.4.5", "Linux version 3.4.5 (user@linux-user) (gcc version 4.6.x-google 20120106 (prerel" +
    "ease) (GCC) ) #5 SMP PREEMPT Sat Aug 2 12:12:26 CST 2014\n"
    , "Processor\t: ARMv7 Processor rev 3 (v7l)\nprocessor\t: 0\nBogoMIPS\t: 1993.93\n\n" +
    "processor\t: 1\nBogoMIPS\t: 1993.93\n\nFeatures\t: swp half thumb fastmult vfp e" +
    "dsp thumbee neon vfpv3 tls vfpv4 idiva idivt \nCPU implementer\t: 0x41\nCPU arch" +
    "itecture: 7\nCPU variant\t: 0x0\nCPU part\t: 0xc07\nCPU revision\t: 3\n\nHardwar" +
    "e\t: MT6572\nRevision\t: aaff\nSerial\t\t: 0000000000000000\n"
    , "yidong"
            });
            insertLib(maps,new String[] {
                "S2y", "DOOV", "S2y", "S2y_11_3.12_140120", "DOOV", "DOOV S2y", "S2y", "", "DOOVS2y", "user", 
                "test-keys", "", "DOOV", "mt6582", "armeabi-v7a", "armeabi", "DOOV/S2y/S2y:4.2.2/DOOVS2y/S2y_11_3.12_140120:user/test-keys", "REL", "eng..1390213516", "4.2.2", 
                "17", "17", "86308202", "960", "540", "1.5", "1.5", "240", "240", "240", 
                "MOLY.WR8.W1319.MD.TG.MP.V13, 2013/11/29 11:50", "3.4.5", "Linux version 3.4.5 (queen@queen-desktop) (gcc version 4.6.x-google 20120106 (pr" +
    "erelease) (GCC) ) #1 SMP PREEMPT Mon Jan 20 18:24:39 CST 2014\n"
    , "Processor\t: ARMv7 Processor rev 3 (v7l)\nprocessor\t: 0\nBogoMIPS\t: 2590.72\n\n" +
    "processor\t: 1\nBogoMIPS\t: 2590.72\n\nprocessor\t: 2\nBogoMIPS\t: 2590.72\n\nFe" +
    "atures\t: swp half thumb fastmult vfp edsp thumbee neon vfpv3 tls vfpv4 idiva id" +
    "ivt \nCPU implementer\t: 0x41\nCPU architecture: 7\nCPU variant\t: 0x0\nCPU part" +
    "\t: 0xc07\nCPU revision\t: 3\n\nHardware\t: MT6582\nRevision\t: 0000\nSerial\t\t" +
    ": 0000000000000000\n"
    , "yidong"
            });
            insertLib(maps,new String[] {
                "t959s1", "Hisense", "t959s1", "T913.6.02.01.00", "Hisense", "HS-T959S1", "t959s1", "", "JDQ39", "user", 
                "release-keys", "root", "ubuntu", "mt6572", "armeabi-v7a", "armeabi", "Hisense/t959s1/t959s1:4.2.2/JDQ39/1384362029:user/release-keys", "REL", "eng.root.1384362029", "4.2.2", 
                "17", "17", "86307502", "854", "480", "1.6500001", "1.5", "240", "160.42105", "159.49706", 
                "MOLY.WR8.W1319.MD.TG.MP.V4.P10, 2013/10/21 16:01", "3.4.5", "Linux version 3.4.5 (root@ubuntu) (gcc version 4.6.x-google 20120106 (prerelease" +
    ") (GCC) ) #1 SMP PREEMPT Wed Nov 13 08:59:41 PST 2013\n"
    , "Processor\t: ARMv7 Processor rev 3 (v7l)\nprocessor\t: 0\nBogoMIPS\t: 1993.93\n\n" +
    "processor\t: 1\nBogoMIPS\t: 1993.93\n\nFeatures\t: swp half thumb fastmult vfp e" +
    "dsp thumbee neon vfpv3 tls vfpv4 idiva idivt \nCPU implementer\t: 0x41\nCPU arch" +
    "itecture: 7\nCPU variant\t: 0x0\nCPU part\t: 0xc07\nCPU revision\t: 3\n\nHardwar" +
    "e\t: MT6572\nRevision\t: 0000\nSerial\t\t: 0000000000000000\n"
    , "yidong"
            });
            insertLib(maps,new String[] {
                "tianyu72_t_yidong_jb3", "alps", "tianyu72_t_yidong_jb3", "TBT972219_8972_V0703", "K-Touch", "K-Touch T85+", "tianyu72_t_yidong_jb3", "", "JDQ39", "user", 
                "release-keys", "ccadmin", "BUILD15", "mt6572", "armeabi-v7a", "armeabi", "alps/tianyu72_t_yidong_jb3/tianyu72_t_yidong_jb3:4.2.2/JDQ39/1392978557:user/rel" +
    "ease-keys"
    , "REL", "eng.ccadmin.1392978557", "4.2.2", 
                "17", "17", "86305802", "854", "480", "1.5", "1.5", "240", "160.42105", "159.49706", 
                "MOLY.WR8.W1319.MD.TG.MP.V4.P26, 2014/02/21 18:15", "3.4.5", "Linux version 3.4.5 (ccadmin@BUILD15) (gcc version 4.6.x-google 20120106 (prerel" +
    "ease) (GCC) ) #1 SMP PREEMPT Fri Feb 21 18:28:49 CST 2014\n"
    , "Processor\t: ARMv7 Processor rev 3 (v7l)\nprocessor\t: 0\nBogoMIPS\t: 1993.93\n\n" +
    "processor\t: 1\nBogoMIPS\t: 1993.93\n\nFeatures\t: swp half thumb fastmult vfp e" +
    "dsp thumbee neon vfpv3 tls vfpv4 idiva idivt \nCPU implementer\t: 0x41\nCPU arch" +
    "itecture: 7\nCPU variant\t: 0x0\nCPU part\t: 0xc07\nCPU revision\t: 3\n\nHardwar" +
    "e\t: MT6572\nRevision\t: 0000\nSerial\t\t: 0000000000000000\n"
    , "yidong"
            });
            insertLib(maps,new String[] {
                "yulong89_we_adv_jb2", "Coolpad", "Coolpad7296", "4.2.030.P2.130930.7296", "Coolpad", "Coolpad 7296", "Coolpad7296", "", "JDQ39", "user", 
                "release-keys", "mine", "mine", "mt6589", "armeabi-v7a", "armeabi", "Coolpad/Coolpad7296/Coolpad7296:4.2.2/JDQ39/4.2.030.P2.130930.7296:user/release-" +
    "keys"
    , "REL", "4.2.030.P2.130930.7296", "4.2.2", 
                "17", "17", "86304202", "960", "540", "1.5", "1.5", "240", "240", "240", 
                "MOLY.WR8.W1248.MD.WG.MP.V10.P12, 2013/09/30 10:10", "3.4.5", "Linux version 3.4.5 (mine@mine) (gcc version 4.6.x-google 20120106 (prerelease) " +
    "(GCC) ) #1 SMP PREEMPT Mon Sep 30 10:32:21 CST 2013\n"
    , "Processor\t: ARMv7 Processor rev 2 (v7l)\nprocessor\t: 0\nBogoMIPS\t: 2439.94\n\n" +
    "Features\t: swp half thumb fastmult vfp edsp thumbee neon vfpv3 tls vfpv4 idiva " +
    "idivt \nCPU implementer\t: 0x41\nCPU architecture: 7\nCPU variant\t: 0x0\nCPU pa" +
    "rt\t: 0xc07\nCPU revision\t: 2\n\nHardware\t: MT6589\nRevision\t: 0000\nSerial\t" +
    "\t: 0000000000000000\n"
    , "yidong"
            });
            insertLib(maps,new String[] {
                "lcsh82_wet_jb5", "Lenovo", "A708t", "Lenovo A708t_S103_131121", "LENOVO", "Lenovo A708t", "A708t", "", "JDQ39", "user", 
                "release-keys", "jenkins", "glsrv4", "mt6582", "armeabi-v7a", "armeabi", "Lenovo/A708t/A708t:4.2.2/JDQ39/A708t_S103_130311:user/release-keys", "REL", "Lenovo_A708t_S012_140311", "4.2.2", 
                "17", "17", "86303402", "960", "540", "1.7249999", "1.5", "240", "240", "240", 
                "MOLY.WR8.W1319.MD.TG.MP.V14.P22, 2013/11/01 15:55", "3.4.5", "Linux version 3.4.5 (jenkins@glsrv4) (gcc version 4.6.x-google 20120106 (prerele" +
    "ase) (GCC) ) #1 SMP PREEMPT Tue Mar 11 15:45:32 CST 2014\n"
    , "Processor\t: ARMv7 Processor rev 3 (v7l)\nprocessor\t: 0\nBogoMIPS\t: 2590.72\n\n" +
    "processor\t: 1\nBogoMIPS\t: 2590.72\n\nprocessor\t: 2\nBogoMIPS\t: 2590.72\n\nFe" +
    "atures\t: swp half thumb fastmult vfp edsp thumbee neon vfpv3 tls vfpv4 idiva id" +
    "ivt \nCPU implementer\t: 0x41\nCPU architecture: 7\nCPU variant\t: 0x0\nCPU part" +
    "\t: 0xc07\nCPU revision\t: 3\n\nHardware\t: MT6582\nRevision\t: aaff\nSerial\t\t" +
    ": 0000000000000000\n"
    , "yidong"
            });
            insertLib(maps,new String[] {
                "lcsh82_wet_jb5", "Lenovo", "A708t", "Lenovo A708t_S103_131121", "Lenovo", "Lenovo A708t", "A708t", "", "JDQ39", "user", 
                "release-keys", "jenkins", "glsrv4", "mt6582", "armeabi-v7a", "armeabi", "Lenovo/A708t/A708t:4.2.2/JDQ39/A708t_S101_131121:user/release-keys", "REL", "Lenovo_A708t_S011_131121", "4.2.2", 
                "17", "17", "86303402", "960", "540", "1.7249999", "1.5", "240", "240", "240", 
                "MOLY.WR8.W1319.MD.TG.MP.V14.P22, 2013/11/01 15:55", "3.4.5", "Linux version 3.4.5 (jenkins@glsrv4) (gcc version 4.6.x-google 20120106 (prerele" +
    "ase) (GCC) ) #1 SMP PREEMPT Thu Nov 21 18:30:37 CST 2013\n"
    , "Processor\t: ARMv7 Processor rev 3 (v7l)\nprocessor\t: 0\nBogoMIPS\t: 2590.72\n\n" +
    "processor\t: 1\nBogoMIPS\t: 2590.72\n\nprocessor\t: 2\nBogoMIPS\t: 2590.72\n\npr" +
    "ocessor\t: 3\nBogoMIPS\t: 2590.72\n\nFeatures\t: swp half thumb fastmult vfp eds" +
    "p thumbee neon vfpv3 tls vfpv4 idiva idivt \nCPU implementer\t: 0x41\nCPU archit" +
    "ecture: 7\nCPU variant\t: 0x0\nCPU part\t: 0xc07\nCPU revision\t: 3\n\nHardware\t" +
    ": MT6582\nRevision\t: aaff\nSerial\t\t: 0000000000000000\n"
    , "yidong"
            });
            insertLib(maps,new String[] {
                "sp8825c1", "Coolpad", "CP8089", "4.0.002.P2.8089", "Coolpad", "Coolpad 8089", "CP8089", "", "IML74K", "user", 
                "test-keys", "fuqiang", "ztStar", "sc8825", "armeabi-v7a", "armeabi", "Coolpad/CP8089/CP8089:4.0.3/IML74K/eng.fuqiang.20140417.164955:user/release-keys", "REL", "eng.fuqiang.20140417.164955", "4.0.3", 
                "15", "15", "86299802", "854", "480", "1.3312501", "1.3312501", "213", "225.77777", "225.95416", 
                "DM_BASE_13B_W13.34\nsc8825_modem\n08-24-2013 21:27:53", "3.0.8", "Linux version 3.0.8 (fuqiang@ztStar) (gcc version 4.4.3 (GCC) ) #1 SMP PREEMPT F" +
    "ri Mar 28 02:42:40 CST 2014\n"
    , "Processor\t: ARMv7 Processor rev 1 (v7l)\nprocessor\t: 0\nBogoMIPS\t: 1024.00\n\n" +
    "processor\t: 1\nBogoMIPS\t: 1024.00\n\nFeatures\t: swp half thumb fastmult vfp e" +
    "dsp thumbee neon vfpv3 \nCPU implementer\t: 0x41\nCPU architecture: 7\nCPU varia" +
    "nt\t: 0x0\nCPU part\t: 0xc05\nCPU revision\t: 1\n\nHardware\t: sc8825\nRevision\t" +
    ": 0000\nSerial\t\t: 0000000000000000\n"
    , "liantong"
            });
            insertLib(maps,new String[] {
                "PXA1088", "Lenovo", "A828t", "LenovoA828t_S103_20131213", "LENOVO", "Lenovo A828t", "A828t", "", "LenovoA828t_S103_20131213", "user", 
                "release-keys", "Android", "AndroidBuild", "pxa1088", "armeabi-v7a", "armeabi", "Lenovo/A828t/A828t:4.2.1/LenovoA828t_S103_20131213/20140226.190839:user/release-" +
    "keys"
    , "REL", "LenovoA828t_S9204_140226", "4.2.1", 
                "17", "17", "86297402", "1280", "720", "2.2", "2.0", "320", "160", "160", 
                "HLTD_CP_2.41.P17:TTD_WK_HLTD_MSA_2.41.P13", "3.4.5", "Linux version 3.4.5 (Android-bot@Android-server) (gcc version 4.6.x-google 20120" +
    "106 (prerelease) (GCC) ) #2 SMP PREEMPT Wed Feb 26 19:08:18 CST 2014\n"
    , "Processor\t: ARMv7 Processor rev 3 (v7l)\nprocessor\t: 0\nBogoMIPS\t: 2374.74\n\n" +
    "processor\t: 1\nBogoMIPS\t: 2374.74\n\nprocessor\t: 2\nBogoMIPS\t: 2374.74\n\npr" +
    "ocessor\t: 3\nBogoMIPS\t: 2374.74\n\nFeatures\t: swp half thumb fastmult vfp eds" +
    "p thumbee neon vfpv3 tls vfpv4 idiva idivt \nCPU implementer\t: 0x41\nCPU archit" +
    "ecture: 7\nCPU variant\t: 0x0\nCPU part\t: 0xc07\nCPU revision\t: 3\n\nHardware\t" +
    ": PXA1088\nRevision\t: 0000\nSerial\t\t: 0000000000000000\n"
    , "yidong"
            });
            insertLib(maps,new String[] {
                "PXA1088", "Lenovo", "A828t", "LenovoA828t_S103_20131213", "LENOVO", "Lenovo A828t", "A828t", "", "LenovoA828t_S103_20131213", "user", 
                "release-keys", "Android", "AndroidBuild", "pxa1088", "armeabi-v7a", "armeabi", "Lenovo/A828t/A828t:4.2.1/LenovoA828t_S103_20131213/20140127.121140:user/release-" +
    "keys"
    , "REL", "LenovoA828t_S8444_140127", "4.2.1", 
                "17", "17", "86297402", "1280", "720", "2.2", "2.0", "320", "160", "160", 
                "HLTD_CP_2.41.P17:TTD_WK_HLTD_MSA_2.41.P13", "3.4.5", "Linux version 3.4.5 (Android-bot@Android-server) (gcc version 4.6.x-google 20120" +
    "106 (prerelease) (GCC) ) #2 SMP PREEMPT Mon Jan 27 12:11:17 CST 2014\n"
    , "Processor\t: ARMv7 Processor rev 3 (v7l)\nprocessor\t: 0\nBogoMIPS\t: 2374.74\n\n" +
    "processor\t: 1\nBogoMIPS\t: 1605.94\n\nprocessor\t: 2\nBogoMIPS\t: 1605.94\n\npr" +
    "ocessor\t: 3\nBogoMIPS\t: 2374.74\n\nFeatures\t: swp half thumb fastmult vfp eds" +
    "p thumbee neon vfpv3 tls vfpv4 idiva idivt \nCPU implementer\t: 0x41\nCPU archit" +
    "ecture: 7\nCPU variant\t: 0x0\nCPU part\t: 0xc07\nCPU revision\t: 3\n\nHardware\t" +
    ": PXA1088\nRevision\t: 0000\nSerial\t\t: 0000000000000000\n"
    , "yidong"
            });
            insertLib(maps,new String[] {
                "mr706", "alps", "mr706z", "MT83X2_MR706_MR706Z1H1C2W1.2014061112", "alps", "SMMS8H3G", "mr706z", "", "JDQ39", "user", 
                "release-keys", "lile", "elinktek3", "mt8382", "armeabi-v7a", "armeabi", "alps/mr706/mr706:4.2.2/JDQ39/1402462104:user/release-keys", "REL", "eng.lile.1402462104", "4.2.2", 
                "17", "17", "86297193", "959", "600", "1.35", "1.35", "216", "216.746", "95.25", 
                "MOLY.WR8.W1315.MD.WG.MP.V18, 2013/11/29 20:10", "3.4.5", "Linux version 3.4.5 (lile@elinktek3) (gcc version 4.6.x-google 20120106 (prerele" +
    "ase) (GCC) ) #1 SMP PREEMPT Wed Jun 11 12:47:58 HKT 2014\n"
    , "Processor\t: ARMv7 Processor rev 3 (v7l)\nprocessor\t: 0\nBogoMIPS\t: 2590.72\n\n" +
    "processor\t: 1\nBogoMIPS\t: 2590.72\n\nFeatures\t: swp half thumb fastmult vfp e" +
    "dsp thumbee neon vfpv3 tls vfpv4 idiva idivt \nCPU implementer\t: 0x41\nCPU arch" +
    "itecture: 7\nCPU variant\t: 0x0\nCPU part\t: 0xc07\nCPU revision\t: 3\n\nHardwar" +
    "e\t: MT8382\nRevision\t: 0000\nSerial\t\t: 0000000000000000\n"
    , "liantong"
            });
            insertLib(maps,new String[] {
                "signal72_wet_jb3", "alps", "signal72_wet_jb3", "Z26_ZK_T2_A_H1.00_V16", "alps", "ZUOKU", "signal72_wet_jb3", "", "JDQ39", "user", 
                "test-keys", "gehuaishu", "signaltech-server", "mt6572", "armeabi-v7a", "armeabi", "alps/signal72_wet_jb3/signal72_wet_jb3:4.2.2/JDQ39/1401271883:user/test-keys", "REL", "1401271883", "4.2.2", 
                "17", "17", "86296801", "854", "480", "1.5", "1.5", "240", "160.42105", "159.49706", 
                "MOLY.WR8.W1319.MD.TG.MP.V1.P6, 2013/07/18 15:25", "3.4.5", "", "Processor\t: ARMv7 Processor rev 3 (v7l)\nprocessor\t: 0\nBogoMIPS\t: 2589.52\n\n" +
    "processor\t: 1\nBogoMIPS\t: 2589.52\n\nFeatures\t: swp half thumb fastmult vfp e" +
    "dsp thumbee neon vfpv3 tls vfpv4 idiva idivt \nCPU implementer\t: 0x41\nCPU arch" +
    "itecture: 7\nCPU variant\t: 0x0\nCPU part\t: 0xc07\nCPU revision\t: 3\n\nHardwar" +
    "e\t: MT6572\nRevision\t: 0000\nSerial\t\t: 0000000000000000\n"
    , "yidong"
            });
            insertLib(maps,new String[] {
                "OPPO89T_13015", "OPPO", "R819T", "R819T_11_140415", "OPPO", "R819T", "OPPO89T_13015", "", "JOP40D", "user", 
                "release-keys", "root", "ubuntu", "mt6589", "armeabi-v7a", "armeabi", "OPPO/OPPO89T_13015/R819T:4.2.1/JOP40D/1397548880:user/release-keys", "REL", "eng.root.1397548880", "4.2.1", 
                "17", "17", "86296702", "1280", "720", "2.0", "2.0", "320", "315.31033", "315.65048", 
                "MOLY.WR8.W1301.MD.TG.MP.V6.F3.P2, 2013/09/24 18:02", "3.4.5", "Linux version 3.4.5 (root@ubuntu) (gcc version 4.6.x-google 20120106 (prerelease" +
    ") (GCC) ) #1 SMP PREEMPT Tue Apr 15 16:00:39 CST 2014\n"
    , "Processor\t: ARMv7 Processor rev 2 (v7l)\nprocessor\t: 0\nBogoMIPS\t: 2439.94\n\n" +
    "processor\t: 1\nBogoMIPS\t: 2447.96\n\nprocessor\t: 2\nBogoMIPS\t: 2000.48\n\npr" +
    "ocessor\t: 3\nBogoMIPS\t: 2000.48\n\nFeatures\t: swp half thumb fastmult vfp eds" +
    "p thumbee neon vfpv3 tls vfpv4 idiva idivt \nCPU implementer\t: 0x41\nCPU archit" +
    "ecture: 7\nCPU variant\t: 0x0\nCPU part\t: 0xc07\nCPU revision\t: 2\n\nHardware\t" +
    ": MT6589\nRevision\t: 0000\nSerial\t\t: 0000000000000000\n"
    , "yidong"
            });
            insertLib(maps,new String[] {
                "2013023", "Xiaomi", "HM2013023", "JHBCNAH1.0", "Xiaomi", "2013023", "2013023", "", "HM2013023", "user", 
                "release-keys", "builder", "xiangshan", "mt6589", "armeabi-v7a", "armeabi", "Xiaomi/2013023/HM2013023:4.2.2/HM2013023/JHBCNAH1.0:user/release-keys", "REL", "JHBCNAH1.0", "4.2.2", 
                "17", "17", "86296602", "1280", "720", "2.0", "2.0", "320", "320", "320", 
                "MOLY.WR8.W1248.MD.WG.MP.V28, 2013/08/21 19:35", "3.4.5", "Linux version 3.4.5 (builder@xiangshan) (gcc version 4.6.x-google 20120106 (prer" +
    "elease) (GCC) ) #1 SMP PREEMPT Wed Oct 23 18:56:36 CST 2013\n"
    , "Processor\t: ARMv7 Processor rev 2 (v7l)\nprocessor\t: 0\nBogoMIPS\t: 3043.37\n\n" +
    "processor\t: 1\nBogoMIPS\t: 3043.37\n\nprocessor\t: 2\nBogoMIPS\t: 3043.37\n\nFe" +
    "atures\t: swp half thumb fastmult vfp edsp thumbee neon vfpv3 tls vfpv4 idiva id" +
    "ivt \nCPU implementer\t: 0x41\nCPU architecture: 7\nCPU variant\t: 0x0\nCPU part" +
    "\t: 0xc07\nCPU revision\t: 2\n\nHardware\t: MT6589\nRevision\t: 0000\nSerial\t\t" +
    ": 0000000000000000\n"
    , "liantong"
            });
            insertLib(maps,new String[] {
                "2013023", "Xiaomi", "HM2013023", "JHBCNAH1.0", "Xiaomi", "2013023", "2013023", "", "HM2013023", "user", 
                "release-keys", "builder", "xiangshan", "mt6589", "armeabi-v7a", "armeabi", "Xiaomi/2013023/HM2013023:4.2.2/HM2013023/JHBCNAH1.0:user/release-keys", "REL", "JHBCNAH1.0", "4.2.2", 
                "17", "17", "86296602", "1280", "720", "2.0", "2.0", "320", "320", "320", 
                "MOLY.WR8.W1248.MD.WG.MP.V28, 2013/08/21 19:35", "3.4.5", "Linux version 3.4.5 (builder@xiangshan) (gcc version 4.6.x-google 20120106 (prer" +
    "elease) (GCC) ) #1 SMP PREEMPT Wed Oct 23 18:56:36 CST 2013\n"
    , "Processor\t: ARMv7 Processor rev 2 (v7l)\nprocessor\t: 0\nBogoMIPS\t: 3043.37\n\n" +
    "processor\t: 1\nBogoMIPS\t: 3043.37\n\nprocessor\t: 2\nBogoMIPS\t: 3043.37\n\npr" +
    "ocessor\t: 3\nBogoMIPS\t: 3043.37\n\nFeatures\t: swp half thumb fastmult vfp eds" +
    "p thumbee neon vfpv3 tls vfpv4 idiva idivt \nCPU implementer\t: 0x41\nCPU archit" +
    "ecture: 7\nCPU variant\t: 0x0\nCPU part\t: 0xc07\nCPU revision\t: 2\n\nHardware\t" +
    ": MT6589\nRevision\t: 0000\nSerial\t\t: 0000000000000000\n"
    , "yidong"
            });
            insertLib(maps,new String[] {
                "bbk82_wet_jb5", "vivo", "bbk82_wet_jb5", "ALPS.JB5.MP.V1.6", "BBK", "vivo Y17T", "bbk82_wet_jb5", "", "JDQ39", "user", 
                "test-keys", "compiler", "compiler017", "mt6582", "armeabi-v7a", "armeabi", "vivo/bbk82_wet_jb5/bbk82_wet_jb5:4.2.2/JDQ39/1386311840:user/test-keys", "REL", "eng.compiler.1386311840", "4.2.2", 
                "17", "17", "86296102", "1280", "720", "2.00002", "2.0", "320", "320", "320", 
                "MOLY.WR8.W1319.MD.TG.MP.V14.F4.P2, 2013/10/21 19:11", "3.4.5", "Linux version 3.4.5 (compiler@compiler017) (gcc version 4.6.x-google 20120106 (p" +
    "rerelease) (GCC) ) #1 SMP PREEMPT Fri Dec 6 14:36:53 CST 2013\n"
    , "Processor\t: ARMv7 Processor rev 3 (v7l)\nprocessor\t: 0\nBogoMIPS\t: 2072.57\n\n" +
    "processor\t: 1\nBogoMIPS\t: 2072.57\n\nprocessor\t: 2\nBogoMIPS\t: 2072.57\n\nFe" +
    "atures\t: swp half thumb fastmult vfp edsp thumbee neon vfpv3 tls vfpv4 idiva id" +
    "ivt \nCPU implementer\t: 0x41\nCPU architecture: 7\nCPU variant\t: 0x0\nCPU part" +
    "\t: 0xc07\nCPU revision\t: 3\n\nHardware\t: MT6582\nRevision\t: 0000\nSerial\t\t" +
    ": 0000000000000000\n"
    , "yidong"
            });
            insertLib(maps,new String[] {
                "mx3", "Meizu", "mx3", "Flyme OS 3.5.2 (U19422)", "Meizu", "M351", "meizu_mx3", "", "JOP40D", "user", 
                "release-keys", "flyme", "mz-builder-4", "mx3", "armeabi-v7a", "armeabi", "Meizu/meizu_mx3/mx3:4.2.1/JOP40D/m35x.Flyme_OS_3.5.2.19422:user/release-keys", "REL", "m35x.Flyme_OS_3.5.2.19422", "4.2.1", 
                "17", "17", "86284502", "1800", "1080", "2.5", "2.5", "400", "415.636", "415.636", 
                "02.1248.00_R09-425", "3.4.43-unicom-g3c826da", "Linux version 3.4.43-unicom-g3c826da (mobileapp@mobileapp) (gcc version 4.6.x-go" +
    "ogle 20120106 (prerelease) (GCC) ) #3 SMP PREEMPT Tue Aug 26 17:53:36 CST 2014\n"
    , "Processor\t: ARMv7 Processor rev 2 srev 0x23 (v7l)\nprocessor\t: 0\nCluster\t\t:" +
    " CA7\nBogoMIPS\t: 1590.88\n\nprocessor\t: 1\nCluster\t\t: CA7\nBogoMIPS\t: 1590." +
    "88\n\nprocessor\t: 2\nCluster\t\t: CA7\nBogoMIPS\t: 1590.88\n\nprocessor\t: 3\nC" +
    "luster\t\t: CA7\nBogoMIPS\t: 1590.88\n\nFeatures\t: swp half thumb fastmult vfp " +
    "edsp neon vfpv3 tls vfpv4 idiva idivt \nCPU implementer\t: 0x41\nCPU architectur" +
    "e: 7\nCPU variant\t: 0x0\nCPU part\t: 0xc07\nCPU revision\t: 2\nCPU asv group\t:" +
    " 3\nCPU asv version\t: 1\nCPU boot cluster: CA15\n\nHardware\t: MX3\nRevision\t:" +
    " 5410\nDMEM\t\t: D25\nSerial\t\t: 0000000000000000\n"
    , "yidong"
            });
            insertLib(maps,new String[] {
                "mx3", "Meizu", "mx3", "Flyme OS 3.1.4 (U16213)", "Meizu", "M351", "meizu_mx3", "", "JOP40D", "user", 
                "release-keys", "flyme", "Flyme-Mz", "mx3", "armeabi-v7a", "armeabi", "Meizu/meizu_mx3/mx3:4.2.1/JOP40D/M35X.Flyme_OS_3.1.4.1387797517:user/release-key" +
    "s"
    , "REL", "M35X.Flyme_OS_3.1.4.1387797517", "4.2.1", 
                "17", "17", "86284502", "1800", "1080", "2.625", "2.5", "400", "415.636", "415.636", 
                "02.1248.00_R09-425", "3.4.43-unicom-svn7549", "Linux version 3.4.43-unicom-svn7549 (mobileapp@mobileapp) (gcc version 4.6.x-goo" +
    "gle 20120106 (prerelease) (GCC) ) #3 SMP PREEMPT Mon Dec 23 16:54:53 CST 2013\n"
    , "Processor\t: ARMv7 Processor rev 2 srev 0x23 (v7l)\nprocessor\t: 0\nCluster\t\t:" +
    " CA7\nBogoMIPS\t: 1590.88\n\nprocessor\t: 1\nCluster\t\t: CA7\nBogoMIPS\t: 1590." +
    "88\n\nprocessor\t: 2\nCluster\t\t: CA7\nBogoMIPS\t: 1590.88\n\nprocessor\t: 3\nC" +
    "luster\t\t: CA7\nBogoMIPS\t: 1590.88\n\nFeatures\t: swp half thumb fastmult vfp " +
    "edsp neon vfpv3 tls vfpv4 idiva idivt \nCPU implementer\t: 0x41\nCPU architectur" +
    "e: 7\nCPU variant\t: 0x0\nCPU part\t: 0xc07\nCPU revision\t: 2\nCPU asv group\t:" +
    " 4\nCPU asv version\t: 1\nCPU boot cluster: CA15\n\nHardware\t: MX3\nRevision\t:" +
    " 5410\nDMEM\t\t: D25\nSerial\t\t: 0000000000000000\n"
    , "yidong"
            });
            insertLib(maps,new String[] {
                "sp8830ec", "Lenovo", "A388t", "MocorDroid4.1.2", "LENOVO", "Lenovo A388t", "A388t", "", "MocorDroid4.1.2", "user", 
                "test-keys", "", "queen-desktop", "sc8830", "armeabi-v7a", "armeabi", "Lenovo/A388t/A388t:4.1.2/MocorDroid4.1.2/A388t_S163_131212.20140312:user/release" +
    "-keys"
    , "REL", "eng..20140313.042354", "4.1.2", 
                "16", "16", "86273602", "854", "480", "1.9499999", "1.5", "240", "254", "271.145", 
                "TM_BASE_13B_W13.42_P6\nsc8830_modem\n11-20-2013 17:44:36", "3.4.5", "Linux version 3.4.5 (queen@queen-desktop) (gcc version 4.6.x-google 20120106 (pr" +
    "erelease) (GCC) ) #1 SMP PREEMPT Thu Mar 13 03:53:29 CST 2014\n"
    , "Processor\t: ARMv7 Processor rev 4 (v7l)\nprocessor\t: 0\nBogoMIPS\t: 2000.48\n\n" +
    "processor\t: 1\nBogoMIPS\t: 2000.48\n\nprocessor\t: 2\nBogoMIPS\t: 1993.93\n\npr" +
    "ocessor\t: 3\nBogoMIPS\t: 1987.37\n\nFeatures\t: swp half thumb fastmult vfp eds" +
    "p neon vfpv3 tls vfpv4 idiva idivt \nCPU implementer\t: 0x41\nCPU architecture: " +
    "7\nCPU variant\t: 0x0\nCPU part\t: 0xc07\nCPU revision\t: 4\n\nHardware\t: sc883" +
    "0\nRevision\t: 0000\nSerial\t\t: 0000000000000000\n"
    , "yidong"
            });
            insertLib(maps,new String[] {
                "sp8830ec", "Lenovo", "A388t", "MocorDroid4.1.2", "LENOVO", "Lenovo A388t", "A388t", "", "MocorDroid4.1.2", "user", 
                "test-keys", "", "queen-desktop", "sc8830", "armeabi-v7a", "armeabi", "Lenovo/A388t/A388t:4.1.2/MocorDroid4.1.2/A388t_S163_131212.20140605:user/release" +
    "-keys"
    , "REL", "eng..20140605.184304", "4.1.2", 
                "16", "16", "86273602", "854", "480", "1.5", "1.5", "240", "254", "271.145", 
                "TM_BASE_13B_W13.42_P6\nsc8830_modem\n11-20-2013 17:44:36", "3.4.5", "Linux version 3.4.5 (queen@queen-desktop) (gcc version 4.6.x-google 20120106 (pr" +
    "erelease) (GCC) ) #1 SMP PREEMPT Thu Jun 5 17:54:12 CST 2014\n"
    , "Processor\t: ARMv7 Processor rev 4 (v7l)\nprocessor\t: 0\nBogoMIPS\t: 2000.48\n\n" +
    "processor\t: 1\nBogoMIPS\t: 2000.48\n\nFeatures\t: swp half thumb fastmult vfp e" +
    "dsp neon vfpv3 tls vfpv4 idiva idivt \nCPU implementer\t: 0x41\nCPU architecture" +
    ": 7\nCPU variant\t: 0x0\nCPU part\t: 0xc07\nCPU revision\t: 4\n\nHardware\t: sc8" +
    "830\nRevision\t: 0000\nSerial\t\t: 0000000000000000\n"
    , "yidong"
            });
            insertLib(maps,new String[] {
                "u966", "Hisense", "u966", "W881.6.01.04.00", "Hisense", "HS-U966", "u966", "", "JDQ39", "user", 
                "release-keys", "root", "ubuntu", "mt6582", "armeabi-v7a", "armeabi", "Hisense/u966/u966:4.2.2/JDQ39/1384484940:user/release-keys", "REL", "eng.root.1384484940", "4.2.2", 
                "17", "17", "86271002", "854", "480", "1.500015", "1.5", "240", "240", "240", 
                "MOLY.WR8.W1315.MD.WG.MP.V11.P5, 2013/11/11 17:17", "3.4.5", "Linux version 3.4.5 (root@ubuntu) (gcc version 4.6.x-google 20120106 (prerelease" +
    ") (GCC) ) #1 SMP PREEMPT Thu Nov 14 19:08:19 PST 2013\n"
    , "Processor\t: ARMv7 Processor rev 3 (v7l)\nprocessor\t: 0\nBogoMIPS\t: 2383.46\n\n" +
    "processor\t: 1\nBogoMIPS\t: 2383.46\n\nprocessor\t: 2\nBogoMIPS\t: 2383.46\n\npr" +
    "ocessor\t: 3\nBogoMIPS\t: 2383.46\n\nFeatures\t: swp half thumb fastmult vfp eds" +
    "p thumbee neon vfpv3 tls vfpv4 idiva idivt \nCPU implementer\t: 0x41\nCPU archit" +
    "ecture: 7\nCPU variant\t: 0x0\nCPU part\t: 0xc07\nCPU revision\t: 3\n\nHardware\t" +
    ": MT6582\nRevision\t: 0000\nSerial\t\t: 0000000000000000\n"
    , "yidong"
            });
            insertLib(maps,new String[] {
                "MSM8960", "Xiaomi", "aries", "JRO03L", "Xiaomi", "MI 2SC", "aries", "", "JRO03L", "user", 
                "release-keys", "builder", "wcc-miui-ota-bd16", "qcom", "armeabi-v7a", "armeabi", "Xiaomi/aries/aries:4.1.1/JRO03L/JLB49.0:user/release-keys", "REL", "JLB49.0", "4.1.1", 
                "16", "16", "86266302", "1280", "720", "2.0", "2.0", "320", "345.0566", "342.23157", 
                "M9615A-CEFWMAZM-2.0.128017", "3.4.0-g52db9c3-01084-g2886fa5", "", "Processor\t: ARMv7 Processor rev 0 (v7l)\nprocessor\t: 0\nBogoMIPS\t: 13.53\n\np" +
    "rocessor\t: 1\nBogoMIPS\t: 13.53\n\nprocessor\t: 2\nBogoMIPS\t: 13.53\n\nprocess" +
    "or\t: 3\nBogoMIPS\t: 13.53\n\nFeatures\t: swp half thumb fastmult vfp edsp neon " +
    "vfpv3 tls vfpv4 \nCPU implementer\t: 0x51\nCPU architecture: 7\nCPU variant\t: 0" +
    "x1\nCPU part\t: 0x06f\nCPU revision\t: 0\n\nHardware\t: MI 2\nRevision\t: 0000\n" +
    "Serial\t\t: 0000000000000000\n"
    , "yidong"
            });
            insertLib(maps,new String[] {
                "G610-T11", "Huawei", "hwG610-T11", "G610-T11 V100R001CHNC01B135", "HUAWEI", "HUAWEI G610-T11", "G610-T11", "", "HuaweiG610-T11", "user", 
                "ota-rel-keys,release-keys", "jenkins", "sp-linux211-desktop", "mt6582", "armeabi-v7a", "armeabi", "Huawei/G610-T11/hwG610-T11:4.2.2/HuaweiG610-T11/C01B135:user/ota-rel-keys,releas" +
    "e-keys"
    , "REL", "C01B135", "4.2.2", 
                "17", "17", "86259402", "960", "540", "1.5", "1.5", "240", "240", "240", 
                "MOLY.WR8.W1319.MD.TG.MP.V8.P60, 2014/01/21 08:09", "3.4.5", "Linux version 3.4.5 (jenkins@sp-linux211-desktop) (gcc version 4.6.x-google 2012" +
    "0106 (prerelease) (GCC) ) #1 SMP PREEMPT Tue Apr 15 01:22:10 HKT 2014\n"
    , "Processor\t: ARMv7 Processor rev 3 (v7l)\nprocessor\t: 0\nBogoMIPS\t: 2072.57\n\n" +
    "processor\t: 1\nBogoMIPS\t: 2072.57\n\nprocessor\t: 2\nBogoMIPS\t: 2072.57\n\npr" +
    "ocessor\t: 3\nBogoMIPS\t: 2072.57\n\nFeatures\t: swp half thumb fastmult vfp eds" +
    "p thumbee neon vfpv3 tls vfpv4 idiva idivt \nCPU implementer\t: 0x41\nCPU archit" +
    "ecture: 7\nCPU variant\t: 0x0\nCPU part\t: 0xc07\nCPU revision\t: 3\n\nHardware\t" +
    ": MT6582\nRevision\t: 0000\nSerial\t\t: 0000000000000000\n"
    , "yidong"
            });
            insertLib(maps,new String[] {
                "sp8825ea", "DESAY", "sp8825ea", "MocorDroid4.0_13A_W13.47\n11-19-2013 18:06:22\nsp8825eaplus-user", "DESAY", "DESAY TS1258", "sp8825eaplus", "", "IML74K", "user", 
                "test-keys", "zhoutao", "driver-ProLiant-DL380p-Gen8", "sc8825", "armeabi-v7a", "armeabi", "DESAY/sp8825eaplus/sp8825ea:4.0.3/IML74K/eng.zhoutao.20131119.180453:user/test-k" +
    "eys"
    , "REL", "eng.zhoutao.20131119.180453", "4.0.3", 
                "15", "15", "86252402", "854", "480", "1.5", "1.5", "240", "225.77777", "225.95416", 
                "DM_BASE_13B_W13.23_P2\nsc8825_modem\n06-17-2013 11:06:01", "3.0.8", "Linux version 3.0.8 (zhoutao@driver-ProLiant-DL380p-Gen8) (gcc version 4.4.3 (GC" +
    "C) ) #1 SMP PREEMPT Tue Nov 19 18:14:01 CST 2013\n"
    , "Processor\t: ARMv7 Processor rev 1 (v7l)\nprocessor\t: 0\nBogoMIPS\t: 1024.00\n\n" +
    "processor\t: 1\nBogoMIPS\t: 1024.00\n\nFeatures\t: swp half thumb fastmult vfp e" +
    "dsp thumbee neon vfpv3 \nCPU implementer\t: 0x41\nCPU architecture: 7\nCPU varia" +
    "nt\t: 0x0\nCPU part\t: 0xc05\nCPU revision\t: 1\n\nHardware\t: sc8825\nRevision\t" +
    ": 0000\nSerial\t\t: 0000000000000000\n"
    , "yidong"
            });
            insertLib(maps,new String[] {
                "hct72_wet_jb3", "Poulo", "hct72_wet_jb3", "R03", "Poulo", "PL888", "hct72_wet_jb3", "", "JDQ39", "user", 
                "test-keys", "release", "release08", "mt6572", "armeabi-v7a", "armeabi", "Poulo/hct72_wet_jb3/hct72_wet_jb3:4.2.2/JDQ39/1378201025:user/test-keys", "REL", "eng.release.1378201025", "4.2.2", 
                "17", "17", "86248702", "960", "540", "1.6500001", "1.5", "240", "159.48837", "160.42105", 
                "MOLY.WR8.W1315.MD.WG.MP.V1.P1, 2013/09/03 17:29", "3.4.5", "Linux version 3.4.5 (release@release08) (gcc version 4.6.x-google 20120106 (prer" +
    "elease) (GCC) ) #1 SMP PREEMPT Tue Sep 3 17:36:45 CST 2013\n"
    , "Processor\t: ARMv7 Processor rev 3 (v7l)\nprocessor\t: 0\nBogoMIPS\t: 2589.52\n\n" +
    "processor\t: 1\nBogoMIPS\t: 2589.52\n\nFeatures\t: swp half thumb fastmult vfp e" +
    "dsp thumbee neon vfpv3 tls vfpv4 idiva idivt \nCPU implementer\t: 0x41\nCPU arch" +
    "itecture: 7\nCPU variant\t: 0x0\nCPU part\t: 0xc07\nCPU revision\t: 3\n\nHardwar" +
    "e\t: MT6572\nRevision\t: 0000\nSerial\t\t: 0000000000000000\n"
    , "liantong"
            });
		return maps;
	}	
	
	
	public static Model GetRondom(){
		Map<String, Model> models = Model.GetLib();
		Random random = new Random();
		int i = random.nextInt(models.size());
		Model ModelInfo = models.get(i + "");
		return ModelInfo;
	}
	
	//将数组改为机型
	public static void insertLib(Map<String, Model> maps,String mod[]){
		Model pm=new Model();
		pm.BOARD=mod[0];
		pm.BOOTLOADER=mod[7];
		pm.BRAND=mod[1];
		pm.CPU_ABI=mod[14];
		pm.CPU_ABI2=mod[15];
		pm.DEVICE=mod[2];
		pm.DISPLAY=mod[3];
		pm.FINGERPRINT=mod[16];
		pm.HARDWARE=mod[13];
		pm.HOST=mod[12];
		pm.ID=mod[8];
		pm.MANUFACTURER=mod[4];
		pm.MODEL=mod[5];
		pm.PRODUCT=mod[6];
		pm.RADIO="";
		pm.TAGS=mod[10];
		pm.TYPE=mod[9];
		pm.USER=mod[11]; 
		pm.CODENAME=mod[17];
		pm.INCREMENTAL=mod[18];
		pm.RELEASE=mod[19];
		pm.SDK_INT=Integer.parseInt(mod[21].trim());		
		pm.SDK=mod[20];		
		pm.Height=Integer.parseInt(mod[23].trim());
		pm.Width=Integer.parseInt(mod[24].trim());
		pm.Density=Float.parseFloat(mod[26].trim());
		pm.ScaleDensity = Float.parseFloat(mod[25].trim());
		pm.DensityDPI = Float.parseFloat(mod[27].trim());
		pm.Xdpi = Float.parseFloat(mod[28].trim());
		pm.Ydpi = Float.parseFloat(mod[28].trim());
		pm.UA = "";// UA数据暂时没有
		pm.BaseBand = mod[30];
		pm.OSVersion = mod[31];
		pm.PROCVersion = mod[32];
		pm.CPUINFO = mod[33];
		pm.TIME = System.currentTimeMillis()
				- Long.parseLong(RanUtil.getRanNub(5))+"";
		String DalvikInt = "14.0.0";
		if (pm.SDK_INT > 15)
			DalvikInt = "16.0.0";
		pm.UA = "Dalvik/" + DalvikInt + "(Linux; U; Android " + pm.RELEASE
				+ "; " + pm.MODEL + " Build/" + pm.ID + ")";
		maps.put(maps.size() + "", pm);
	}
}
