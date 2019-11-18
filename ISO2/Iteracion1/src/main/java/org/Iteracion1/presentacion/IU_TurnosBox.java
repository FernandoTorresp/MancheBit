package org.Iteracion1.presentacion;

import java.util.*;

import org.Iteracion1.dominio.Gestor_reservas;

public class IU_TurnosBox {
	
	private static Scanner teclado = new Scanner(System.in);
	private static Gestor_reservas gestor;
	
	public static void main(String[] args) {
		
		presentacion();		
		pantalla();
	}
	
	public static void pantalla() {
		opciones();
		int opcion=recogerTeclado();
		
		switch(opcion) {
		case 1:
			estadoBoxes();
			break;
		case 2:
			reservarBox();
			break;
		case 0:
			System.exit(1);
		}
	}
	
	public static void presentacion() {
		System.out.println("TALLERES FULANO. RESERVA DE BOXES");
		System.out.println("");
	}
	
	public static void opciones() {
		System.out.println("Seleccione:");
		System.out.println("0. Salir");
		System.out.println("1. Estado de cada box");
		System.out.println("2. Reserva de box");
		System.out.println("");
	}
	
	public static int recogerTeclado() {
		int op=0;
		try {
			op=teclado.nextInt();
		}catch(InputMismatchException e) {
			System.out.println("Debe introducir un entero entre 0 y 2");
		}
		
		return op;
	}
	
	public static void estadoBoxes() {
		//Implementar métodos para obtener el estado de los boxes mediante SQL
	}
	
	public static void reservarBox() {
		String DNI="";
		System.out.println("Introduzca su DNI para asignarle un box libre");
		DNI=teclado.next();
		gestor.reservarBox(DNI);
	}

}
