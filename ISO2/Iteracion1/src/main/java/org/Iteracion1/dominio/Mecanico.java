package org.Iteracion1.dominio;

public class Mecanico {
	
	private String DNI;
	private String 	Nombre;
	private String Apellido;

	public Mecanico(String DNI, String Nombre, String Apellido) { //Constructor 1
		this.DNI=DNI;
		this.Nombre=Nombre;
		this.Apellido=Apellido;
	}
	
	public Mecanico(String DNI) { //Constructor 2
		this.DNI=DNI;
	}
	
	public String getDNI() {
		return DNI;
	}

	public void setDNI(String dNI) {
		DNI = dNI;
	}

	public String getNombre() {
		return Nombre;
	}

	public void setNombre(String nombre) {
		Nombre = nombre;
	}

	public String getApellido() {
		return Apellido;
	}

	public void setApellido(String apellido) {
		Apellido = apellido;
	}
	
	
}
