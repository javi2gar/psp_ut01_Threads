package com.psp.javi2gar;

import java.io.File;
import java.io.IOException;

public class Ejecucion {

	String inFile = "C:\\Users\\Javier_2\\Procesos\\psp_ut01_Threads\\src\\com\\psp\\javi2gar\\filesInput\\";
	String outFile = "C:\\Users\\Javier_2\\Procesos\\psp_ut01_Threads\\src\\com\\psp\\javi2gar\\filesOutput\\";
	long initialTime = System.currentTimeMillis();

	public Ejecucion() {

	}

	public void metodoSequencial() {

		// Definicion de los departamentos
		Department informatica = new Department("informatica", inFile, outFile);
		Department gerencia = new Department("gerencia", inFile, outFile);
		Department contabilidad = new Department("contabilidad", inFile, outFile);
		Department comercio = new Department("comercio", inFile, outFile);
		Department rrhh = new Department("rrhh", inFile, outFile);

		// Definicion de los procesadores

		ProcessFileDpt p1 = new ProcessFileDpt();
		ProcessFileDpt p2 = new ProcessFileDpt();
		ProcessFileDpt p3 = new ProcessFileDpt();
		ProcessFileDpt p4 = new ProcessFileDpt();
		ProcessFileDpt p5 = new ProcessFileDpt();

		try {

			p1.sumReadFile(informatica, informatica.getUrlFile(), initialTime);
			p2.sumReadFile(comercio, comercio.getUrlFile(), initialTime);
			p3.sumReadFile(gerencia, gerencia.getUrlFile(), initialTime);
			p4.sumReadFile(contabilidad, contabilidad.getUrlFile(), initialTime);
			p5.sumReadFile(rrhh, rrhh.getUrlFile(), initialTime);

			File[] resFiles = new File[5];
			resFiles[0] = comercio.getUrlResFile();
			resFiles[1] = gerencia.getUrlResFile();
			resFiles[2] = contabilidad.getUrlResFile();
			resFiles[3] = comercio.getUrlResFile();
			resFiles[4] = rrhh.getUrlResFile();

			System.out.println("\n\n" + GlobalBalance.sumRes(resFiles));

		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void metodoThread() {

		// Definicion de los departamentos
		Department informatica = new Department("informatica", inFile, outFile);
		Department gerencia = new Department("gerencia", inFile, outFile);
		Department contabilidad = new Department("contabilidad", inFile, outFile);
		Department comercio = new Department("comercio", inFile, outFile);
		Department rrhh = new Department("rrhh", inFile, outFile);

		// Definicion de los procesadores

		ProcessFileDptThread p1 = new ProcessFileDptThread(informatica, informatica.getUrlFile(), initialTime);
		ProcessFileDptThread p2 = new ProcessFileDptThread(gerencia, gerencia.getUrlFile(), initialTime);
		ProcessFileDptThread p3 = new ProcessFileDptThread(contabilidad, contabilidad.getUrlFile(), initialTime);
		ProcessFileDptThread p4 = new ProcessFileDptThread(comercio, comercio.getUrlFile(), initialTime);
		ProcessFileDptThread p5 = new ProcessFileDptThread(rrhh, rrhh.getUrlFile(), initialTime);

		p1.start();
		p2.start();
		p3.start();
		p4.start();
		p5.start();

		try {

			p1.join();
			p2.join();
			p3.join();
			p4.join();
			p5.join();

			File[] resFiles = new File[5];
			resFiles[0] = comercio.getUrlResFile();
			resFiles[1] = gerencia.getUrlResFile();
			resFiles[2] = contabilidad.getUrlResFile();
			resFiles[3] = comercio.getUrlResFile();
			resFiles[4] = rrhh.getUrlResFile();

			System.out.println("\n\n" + GlobalBalance.sumRes(resFiles));

		} catch (IOException e) {
			e.printStackTrace();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}
