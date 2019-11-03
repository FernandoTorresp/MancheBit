package persistencia;

import dominio.*;

public class Agente_DAO {
	
	private Agente agente;
	
	public Agente_DAO(Agente agente) { //Constructor
		this.agente=agente;
	}
	
	public void reservarBox(Box box){ //Incluímos el box en la tabla de reservados
		agente.modificar("INSERT INTO RESERVADOS VALUES ('" + box.getId() + "');"); 
	}
	
	public void taller_mecanico(Box box, Mecanico mecanico) { //Incluímos mecánico + box asignado automáticamente
		agente.modificar("INSERT INTO TALLER_MECANICO VALUES ('" + box.getId() + "','" + mecanico.getDNI() + "');");
	}
	
	public int checkBoxLibre() {
		int id=0; int[] libres;
		libres=agente.leer("SELECT Id FROM BOXES WHERE Estado = Libre");
		id=libres[0]; //Haría falta controlar si no hay boxes libres. En este caso se escoge el primero leído de la BD
		return id;
		
	}
	
	public void cambioReservado(Box box,String s) { //También modificamos el estado en la tabla BOXES
		agente.modificar("UPDATE BOXES SET Estado='" + s + "' WHERE Id ='" + box.getId() + "');");
	}

}
