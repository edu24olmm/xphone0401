package com.x.utils;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

class StreamGobbler extends Thread {
	InputStream is;
	String type;

	StreamGobbler(InputStream is, String type) {
		this.is = is;
		this.type = type;
	}

	public void run() {
		InputStreamReader isr = null;
		BufferedReader br = null;
		try {
			isr = new InputStreamReader(this.is);
			br = new BufferedReader(isr);
			String line = null;
			while ((line = br.readLine()) != null) {
				if (this.type.equals("Error"))
					System.err.print(line);
				else
					System.out.print(line);
			}
		} catch (IOException e) {
			e.printStackTrace();
			try {
				if (br != null)
					br.close();
			} catch (IOException e4) {
				e4.printStackTrace();
			}
			try {
				if (isr != null)
					isr.close();
			} catch (IOException e2) {
				e2.printStackTrace();
			}
		} finally {
			try {
				if (br != null)
					br.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
			try {
				if (isr != null)
					isr.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
}