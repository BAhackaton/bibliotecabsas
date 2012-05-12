package ar.com.grupoesfera.buenosaires.bibliotecas.modelo.entidades;

import java.io.Serializable;

public class LibroDisponibleEnBiblioteca implements Serializable{
	
	private static final long serialVersionUID = 4707988141077975974L;

	private Biblioteca biblioteca;
	
	private boolean disponible;
	
	public LibroDisponibleEnBiblioteca() {}
	
	public LibroDisponibleEnBiblioteca(Biblioteca biblioteca, boolean disponible) {
		super();
		this.biblioteca = biblioteca;
		this.disponible = disponible;
	}


	public Biblioteca getBiblioteca() {
		return biblioteca;
	}

	public void setBiblioteca(Biblioteca biblioteca) {
		this.biblioteca = biblioteca;
	}

	public boolean isDisponible() {
		return disponible;
	}

	public void setDisponible(boolean disponible) {
		this.disponible = disponible;
	}
	
	

}
