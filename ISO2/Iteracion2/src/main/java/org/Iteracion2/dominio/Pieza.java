package org.Iteracion2.dominio;

public class Pieza {
	
	private String _codigo;
	private int _disponibilidad;
	private String _nombre;
	private int _coste;
	
	public Pieza(String _codigo, int _disponibilidad, String _nombre, int _coste) {
		super();
		this._codigo = _codigo;
		this._disponibilidad = _disponibilidad;
		this._nombre = _nombre;
		this._coste = _coste;
	}
	
	public String get_codigo() {
		return _codigo;
	}
	
	public void set_codigo(String _codigo) {
		this._codigo = _codigo;
	}
	
	public int get_disponibilidad() {
		return _disponibilidad;
	}
	
	public void set_disponibilidad(int _disponibilidad) {
		this._disponibilidad = _disponibilidad;
	}
	
	public String get_nombre() {
		return _nombre;
	}
	
	public void set_nombre(String _nombre) {
		this._nombre = _nombre;
	}

	public int get_coste() {
		return _coste;
	}
	
	public void set_coste(int _coste) {
		this._coste = _coste;
	}
	
}