package dominio;

public class Cliente {
	
	private Pieza [] _piezas;
	
	public Cliente(Pieza [] _piezas) {
		super();
		this._piezas = _piezas;

	}
	
	public Pieza [] get_piezas() {
		return _piezas;
	}
	
	public void set_piezas(Pieza [] _piezas) {
		this._piezas = _piezas;
	}
	
}
