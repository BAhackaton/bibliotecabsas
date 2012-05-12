package ar.com.grupoesfera.buenosaires.bibliotecas.modelo.entidades;

import java.util.List;


public class LibroImpl extends LibroAbstracto {

	private static final long serialVersionUID = -8393935231074331768L;
	
	private String isbn;
	private String titulo;
	private String responsables;
	private String edicion;
	private String editorial;
	private String descripcionFisica;
	private List<LibroDisponibleEnBiblioteca> dondeEsta;
	
	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public void setResponsables(String responsables) {
		this.responsables = responsables;
	}

	public void setEdicion(String edicion) {
		this.edicion = edicion;
	}

	public void setEditorial(String editorial) {
		this.editorial = editorial;
	}

	public void setDescripcionFisica(String descripcionFisica) {
		this.descripcionFisica = descripcionFisica;
	}

	@Override
	public String getIsbn() {
		return this.isbn;
	}

	@Override
	public String getTitulo() {
		return this.titulo;
	}

	@Override
	public String getResponsables() {
		return this.responsables;
	}

	@Override
	public String getEdicion() {
		return this.edicion;
	}

	@Override
	public String getEditorial() {
		return this.editorial;
	}

	@Override
	public String getDescripcionFisica() {
		return this.descripcionFisica;
	}
	
	@Override
	public String getSintesis() {

		StringBuilder sintesis = new StringBuilder();
		
		sintesis.append(this.titulo)
				.append(",")
				.append(this.responsables);
		
		return sintesis.toString();
	}
	
	@Override
	public List<LibroDisponibleEnBiblioteca> dondeEsta() {
		return this.dondeEsta;
	}

	public void setDondeEsta(List<LibroDisponibleEnBiblioteca> dondeEsta) {
		this.dondeEsta = dondeEsta;
	}

}
