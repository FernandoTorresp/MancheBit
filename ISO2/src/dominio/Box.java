package dominio;

import persistencia.*;

public class Box {
	
	private int id;
	private Mecanico mecanico;
	private String estado;
	private Agente_DAO dao;
	
	public Box(int id, Mecanico mecanico, String estado) { //Constructor
		this.id=id;
		this.mecanico=mecanico;
		this.estado=estado;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Mecanico getMecanico() {
		return mecanico;
	}

	public void setMecanico(Mecanico mecanico) {
		this.mecanico = mecanico;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public void reservar(Box box) {
		dao.reservarBox(box);
	}
	
	public void asignarMecanico(Box box, Mecanico mecanico) {
		dao.taller_mecanico(box,mecanico);
	}
	
	public void cambioReservado(Box box,String s) {
		dao.cambioReservado(box,s);	}

}
