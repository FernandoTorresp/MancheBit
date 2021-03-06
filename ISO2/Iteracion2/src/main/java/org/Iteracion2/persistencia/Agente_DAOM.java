package org.Iteracion2.persistencia;

import org.Iteracion1.dominio.Box;
import org.Iteracion1.persistencia.Agente;
import org.Iteracion1.persistencia.Agente_DAO;

public class Agente_DAOM extends Agente_DAO{
	
	private Agente agente;

	public Agente_DAOM(Agente agente) {
		super(agente);
	}

	public int compronarEstadoBox(Box box) {
		int[] estado;
		estado=agente.leer("SELECT Estado FROM BOXES WHERE Id ='" + box.getId() + "');");
		return estado[0];
	}

	public void cambiarEstadoBox(Box box,String s) {
		agente.modificar("UPDATE BOXES SET Estado='" + s + "' WHERE Id ='" + box.getId() + "');");
	}

	public void leerListaPiezas() {
		throw new UnsupportedOperationException();
	}
}