package com.psp.javi2gar;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class GlobalBalance {

	private static String result = "";

	public static String sumRes(File[] res) throws IOException {

		File[] cacheResFile = res;
		String num = null;
		double sum = 0;

		for (int i = 0; i < cacheResFile.length; i++) {

			BufferedReader br = new BufferedReader(new FileReader(cacheResFile[i]));

			try {

				while (br.ready()) {
					num = br.readLine();
					sum = sum + Double.valueOf(num);
				}

			} catch (IOException ioe) {

				ioe.printStackTrace();

			} finally {
				br.close();
			}
		}
		result = ("Anual global balance of enterprise :  " + sum + " €");
		return result;
	}
}