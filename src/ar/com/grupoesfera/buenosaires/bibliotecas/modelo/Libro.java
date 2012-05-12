package ar.com.grupoesfera.buenosaires.bibliotecas.modelo;

import java.util.List;

import ar.com.grupoesfera.buenosaires.bibliotecas.modelo.entidades.LibroDisponibleEnBiblioteca;

import java.io.Serializable;

public interface Libro extends Serializable {

	String getId();
	
	String getIsbn();
	
	String getTitulo();
	
	String getResponsables();
	
	String getEdicion();
	
	String getEditorial();
	
	String getDescripcionFisica();
	
	String getSintesis();
	
	List<LibroDisponibleEnBiblioteca> dondeEsta();
}
