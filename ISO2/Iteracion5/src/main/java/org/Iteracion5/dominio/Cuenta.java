package org.Iteracion5.dominio;

public class Cuenta {
	
	private String id;	

	private double cantidad_disponible;
	
	public Cuenta() {
		this.id=id;
		this.cantidad_disponible=cantidad_disponible;
	}
	
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public double getCantidad_disponible() {
		return cantidad_disponible;
	}

	public void setCantidad_disponible(double cantidad_disponible) {
		this.cantidad_disponible = cantidad_disponible;
	}
	
	public double calcular_cantidad(double cantidad_pagar) {
		
		//No implementado
		return cantidad_pagar;
		
	}
	
	

}
