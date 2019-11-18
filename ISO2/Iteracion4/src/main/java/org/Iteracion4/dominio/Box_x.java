package org.Iteracion4.dominio;

import org.Iteracion1.dominio.Box;
import org.Iteracion1.dominio.Mecanico;
import org.Iteracion2.dominio.Pieza;

public class Box_x extends Box{
	
	
	public Box_x(int id, Mecanico mecanico, String estado, Pieza[] listaPiezas) {
		super(id, mecanico, estado);
		this._listaPiezas=listaPiezas;
	}

	private Pieza[] _listaPiezas;
}