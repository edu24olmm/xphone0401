package com.secneo.common;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.sql.Blob;
import java.sql.Clob;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.Set;
import java.util.UUID;

public class CommonUtils {

	public static <T> boolean isBlankSet(Set<T> set) {
		return (set == null) || (set.isEmpty());
	}

	public static <T> boolean isBlankList(List<T> list) {
		return (list == null) || (list.isEmpty());
	}

	public static <T> boolean isBlankMap(Map<String, Object> map) {
		return (map == null) || (map.isEmpty());
	}

	public static boolean isBlankArray(Object[] arr) {
		return (arr == null) || (arr.length < 1);
	}

	public static final synchronized String genID() {
		try {
			Thread.sleep(50L);
		} catch (InterruptedException e) {

		}
		return String.valueOf(System.currentTimeMillis());
	}

	public static final synchronized String getUUID() {
		return UUID.randomUUID().toString().replace("-", "");
	}

	public static synchronized String encryptBySHA(String input)
			throws Exception {
		return encrypt(input, "SHA-256");
	}

	public static synchronized String encryptBySHA(byte[] inputs)
			throws NoSuchAlgorithmException, UnsupportedEncodingException {
		return encrypt(inputs, "SHA-256");
	}

	public static synchronized String encryptByMD5(String input)
			throws NoSuchAlgorithmException {
		return encrypt(input, "MD5");
	}

	public static synchronized String encryptByMD5(byte[] inputs)
			throws NoSuchAlgorithmException {
		return encrypt(inputs, "MD5");
	}

	public static String encrypt(String inputStr, String type) {
		if ((inputStr == null) || ("".equals(inputStr))) {
			return "";
		}
		byte[] bt = inputStr.getBytes();
		return encrypt(bt, type);
	}

	public static String encrypt(byte[] inputs, String type) {
		if (inputs == null) {
			return "";
		}
		MessageDigest md = null;
		String strDes = "";
		try {
			if ((type == null) || (type.equals(""))) {
				type = "SHA-256";
			}
			md = MessageDigest.getInstance(type);
			md.update(inputs);
			strDes = bytes2Hex(md.digest());
		} catch (NoSuchAlgorithmException e) {

		}
		return strDes;
	}

	private static String bytes2Hex(byte[] bts) {
		String des = "";
		String tmp = null;
		for (int i = 0; i < bts.length; i++) {
			tmp = Integer.toHexString(bts[i] & 0xFF);
			if (tmp.length() == 1) {
				des = des + "0";
			}
			des = des + tmp;
		}
		return des;
	}

	public static synchronized String getImageNameByTime() {
		try {
			Thread.sleep(100L);
		} catch (InterruptedException e) {

		}
		return String.valueOf(System.currentTimeMillis());
	}

	public static void copyFile(File src, File target) {
		InputStream in = null;
		OutputStream out = null;
		try {
			in = new BufferedInputStream(new FileInputStream(src), 10240);
			out = new BufferedOutputStream(new FileOutputStream(target), 10240);

			byte[] buffer = new byte[10240];
			Integer len = Integer.valueOf(0);
			while ((len = Integer.valueOf(in.read(buffer))).intValue() > 0)
				out.write(buffer, 0, len.intValue());
		} catch (Exception e) {

			if (in != null) {
				try {
					in.close();
				} catch (IOException e4) {
				}
			}
			if (out != null) {
				try {
					out.flush();
				} catch (IOException e2) {
				}
				try {
					out.close();
				} catch (IOException e3) {
				}
			}
		} finally {
			if (in != null) {
				try {
					in.close();
				} catch (IOException e) {

				}
			}
			if (out != null) {
				try {
					out.flush();
				} catch (IOException e) {

				}
				try {
					out.close();
				} catch (IOException e) {

				}
			}
		}
	}

	public static String toSBC(String strByDBC) {
		if (strByDBC == null) {
			return null;
		}
		char[] charArray = strByDBC.toCharArray();
		for (int i = 0; i < charArray.length; i++) {
			if (charArray[i] == ' ')
				charArray[i] = '¡¡';
			else if (charArray[i] == '.')
				charArray[i] = '¡£';
			else if (charArray[i] == '[')
				charArray[i] = '¡¾';
			else if (charArray[i] == '\'')
				charArray[i] = '¡®';
			else if (charArray[i] == '"')
				charArray[i] = '¡°';
			else if (charArray[i] == '<')
				charArray[i] = '¡¶';
			else if (charArray[i] == '>')
				charArray[i] = '¡·';
			else if (charArray[i] == '$')
				charArray[i] = 65509;
			else if (charArray[i] < '') {
				charArray[i] = (char) (charArray[i] + 65248);
			}
		}
		return new String(charArray);
	}

	public static String mapToString(Map<String, Object> map, String sign) {
		StringBuffer sbf = new StringBuffer();
		for (String k : map.keySet()) {
			sbf.append(k);

			sbf.append(sign);

			sbf.append(map.get(k));

			sbf.append(",");
		}
		return sbf.replace(sbf.lastIndexOf(","), sbf.length(), "").toString();
	}

	public static boolean isStringInArray(String[] array, String str) {
		for (int i = 0; i < array.length; i++) {
			if (str.equals(array[i])) {
				return true;
			}
		}
		return false;
	}

	public static String clobToString(Clob c) {
		String s = null;
		if (c != null) {
			try {
				s = c.getSubString(1L, (int) c.length());
			} catch (SQLException e) {

			}
		}
		return s;
	}

	public static String blobToString(Blob blob) {
		String s = null;
		try {
			byte[] brr = blob.getBytes(0L, (int) blob.length());
			s = new String(brr);
		} catch (SQLException e) {

		}
		return s;
	}

	public static String getPathByOs(String sPath) {
		if (sPath == null) {
			return sPath;
		}
		if (System.getProperty("os.name").toUpperCase().contains("LINUX")) {
			sPath = "/" + sPath;
		}
		return sPath;
	}

	public static boolean isWindowsOs() {
		return !System.getProperty("os.name").toUpperCase().contains("LINUX");
	}

	public static String readFile(File file) {
		InputStream is = null;
		String res = new String();
		try {
			is = new FileInputStream(file);
			byte[] b = new byte[1024];
			int byteRead = 0;
			while ((byteRead = is.read(b)) > 0)
				res = res + new String(b, 0, byteRead);
		} catch (Exception e) {

			if (is != null)
				try {
					is.close();
				} catch (IOException e6) {
				}
		} finally {
			if (is != null) {
				try {
					is.close();
				} catch (IOException e) {

				}
			}
		}
		return res;
	}

	public static String readFile(String filePath) throws IOException {
		return readFile(new File(filePath));
	}

	public static List<String> readLine(File file) {
		BufferedReader is = null;
		List results = new ArrayList();
		try {
			String line = "";
			is = new BufferedReader(new FileReader(file));
			while ((line = is.readLine()) != null)
				results.add(line);
		} catch (Exception e) {
			if (is != null)
				try {
					is.close();
				} catch (IOException e0) {
				}
		} finally {
			if (is != null) {
				try {
					is.close();
				} catch (IOException e) {

				}
			}
		}
		return results;
	}

	public static int random(int min, int max) {
		Random rand = new Random();
		return (int) Math.floor(rand.nextDouble() * (max - min) + min);
	}

	public static long random(long min, long max) {
		Random rand = new Random();
		return (long) Math.floor(rand.nextDouble() * (max - min) + min);
	}

	public static synchronized boolean deleteFile(String delpath) {
		try {
			File file = new File(delpath);
			if (!file.isDirectory()) {
				file.delete();
			} else if (file.isDirectory()) {
				String[] filelist = file.list();
				for (int i = 0; i < filelist.length; i++) {
					File delfile = new File(delpath + "/" + filelist[i]);
					if (!delfile.isDirectory())
						delfile.delete();
					else if (delfile.isDirectory())
						deleteFile(delpath + "/" + filelist[i]);
				}
				file.delete();
			}
		} catch (Exception e) {
			return false;
		}
		return true;
	}

	public static int hasSuffix(File file, String suffix) {
		int res = 0;
		if (file.isFile()) {
			if (file.getName().endsWith(suffix)) {
				res = 1;
			}
		} else if (!isBlankArray(file.listFiles())) {
			for (File f : file.listFiles()) {
				if (f.isFile()) {
					if (f.getName().toLowerCase().endsWith(suffix))
						res++;
				} else {
					res += hasSuffix(f, suffix);
				}
			}
		}

		return res;
	}

	public static synchronized String createToken() {
		return String.valueOf(System.currentTimeMillis());
	}

	public static String projectRealPath() {
		String projectPath = new CommonUtils().getClass().getResource("/")
				.getPath().replace("WEB-INF/classes/", "");
		if ((isWindowsOs()) && (projectPath.indexOf("/") == 0)) {
			projectPath = projectPath.replaceFirst("/", "");
		}
		return projectPath;
	}

	public static String getClassPath() {
		String classPath = new CommonUtils().getClass().getResource("/")
				.getPath();
		if ((isWindowsOs()) && (classPath.indexOf("/") == 0)) {
			classPath = classPath.replaceFirst("/", "");
		}
		return classPath;
	}

	public static synchronized String encryptString(String str) {
		return str;
	}

	public static synchronized String crackString(String str) {
		return str;
	}

	public static void deleteDir(File tDirFile) {
		if (tDirFile.exists()) {
			if (tDirFile.exists()) {
				if (tDirFile.isDirectory()) {
					File[] arrFiles = tDirFile.listFiles();
					for (int i = 0; i < arrFiles.length; i++) {
						deleteDir(arrFiles[i]);
					}
					arrFiles = (File[]) null;
					tDirFile.delete();
				} else {
					tDirFile.delete();
				}
			}
			tDirFile = null;
		}
	}
}