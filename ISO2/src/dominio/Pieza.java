package dominio;

public class Pieza {
	
	private String _codigo;
	private int _disponibilidad;
	private String _nombre;
	
	public Pieza(String _codigo, int _disponibilidad, String _nombre) {
		super();
		this._codigo = _codigo;
		this._disponibilidad = _disponibilidad;
		this._nombre = _nombre;
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
	
}