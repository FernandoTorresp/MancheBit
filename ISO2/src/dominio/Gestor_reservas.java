package dominio;

import persistencia.*;

public class Gestor_reservas {

	private static Agente_DAO dao;
	
	public Gestor_reservas(Agente_DAO dao) { //Constructor
		this.dao=dao;
	}
	
	public static void reservarBox(String DNI) { //Método clave. Una vez obtenemos el id de un box libre, creamos objetos, reservamos y asignamos
		int id=dao.checkBoxLibre();
		Mecanico mecanico=new Mecanico(DNI);
		Box box=new Box(id, mecanico, "Reservado");
		box.reservar(box);
		box.asignarMecanico(box, mecanico);
		box.cambioReservado(box,"Reservado");
	}
	
	public static void estadoBoxes() {
		//No implementado
	}

}
