package com.psp.javi2gar;

import java.io.IOException;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) throws IOException {

		// Guardar la opcion del menú
		Scanner sn = new Scanner(System.in);
		int opcion;

		Ejecucion exec = new Ejecucion();

		try {
			// Menu de la aplicacion
			System.out.println("");
			System.out.println("1. Ejecución sequencial.");
			System.out.println("2. Ejecución heredando de la clase Thread.");
			System.out.println("0. Salir");
			System.out.print("\n\nEscribe una de las opciones: ");
			opcion = sn.nextInt();

			switch (opcion) {
			case 1:
				System.out.println("\n\n\t\tSe inicia modo secuencial");
				System.out.println("\n\t\tEsto puede tardar bastante, sea paciente.\n\n");
				exec.metodoSequencial();
				break;
			case 2:
				System.out.println("\n\n\t\tSe inicia modo Thread");
				System.out.println("\n\t\tEspere unos segundos\n\n");
				exec.metodoThread();
				break;

			case 0:
				System.out.print("\033[H\033[2J");
				System.out.flush();
				System.out.println("\n\n\n\n\n\n\n\n\n\t\t\t\t\tYou're out!!!\n\n\n\n\n\n\n\n\n");
				System.exit(0);

			default:
				System.out.println("\n\n\t\tSolo números 1 y 2\n\n");
			}

		} catch (Exception e) {
			System.err.println("No es un número");
		} finally {
			sn.close();
		}

	}

}
