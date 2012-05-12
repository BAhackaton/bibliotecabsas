package ar.com.grupoesfera.buenosaires.bibliotecas.modelo.entidades;

import java.util.List;

import ar.com.grupoesfera.buenosaires.bibliotecas.modelo.Libro;

public abstract class LibroAbstracto implements Libro {

	private static final long serialVersionUID = -7505467959323562609L;

	private String id;

	public LibroAbstracto() {
		super();
	}

	public LibroAbstracto(String id) {
		
		this.setId(id);
	}

	private void setId(String id) {

		this.id = id;
	}

	@Override
	public String getIsbn() {
		return null;
	}

	@Override
	public String getTitulo() {
		return null;
	}

	@Override
	public String getResponsables() {
		return null;
	}

	@Override
	public String getEdicion() {
		return null;
	}

	@Override
	public String getEditorial() {
		return null;
	}

	@Override
	public String getDescripcionFisica() {
		return null;
	}
	
	@Override
	public String getId() {
		
		return this.id;
	}

	@Override
	public String getSintesis() {
		return null;
	}
	
	@Override
	public List<LibroDisponibleEnBiblioteca> dondeEsta() {
		return null;
	}

}