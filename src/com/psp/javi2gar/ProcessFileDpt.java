package com.psp.javi2gar;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

import com.psp.javi2gar.Department;

public class ProcessFileDpt {

	private long time;

	public void sumReadFile(Department dpt, File file, long timeStamp) throws IOException {

		String[] s;
		double[] balanceDept = null;
		double sum = 0;
		FileReader fr = null;
		BufferedReader br = null;

		try {
			fr = new FileReader(file);
			br = new BufferedReader(fr);

			while (br.ready()) {

				s = br.readLine().split("€");
				balanceDept = new double[s.length];

				for (int i = 0; i < s.length; i++) {
					balanceDept[i] = Double.valueOf(s[i]);
					sum = sum + balanceDept[i];
					esperarXsegundos(s.length);
				}

			}
			time = timeStamp;

		} catch (IOException ioe) {

			ioe.printStackTrace();

		} finally {
			try {
				fr.close();
				br.close();
				System.out.println("Se suma el archivo:  " + dpt.getName()+".txt"+ " en "
						+ ((System.currentTimeMillis() - timeStamp) / 1000) + " seg");
				generateResDptFile(dpt, sum);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

	public void generateResDptFile(Department dpt, double resDpt) {

		FileWriter filew = null;
		PrintWriter pw = null;

		try {
			filew = new FileWriter(dpt.getUrlResFile());
			pw = new PrintWriter(filew);
			pw.println(resDpt);
			esperarXsegundos(2); // Esperamos 2 segundos de anera simbólica
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (null != filew)
					filew.close();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}

		System.out.println("Se genera el archivo:  " + dpt.getName() + ".res" + " en "
				+ ((System.currentTimeMillis() - time) / 1000) + " seg");
	}

	private void esperarXsegundos(int segundos) {
		try {
			Thread.sleep(segundos * 1000);
		} catch (InterruptedException ex) {
			Thread.currentThread().interrupt();
		}
	}
}