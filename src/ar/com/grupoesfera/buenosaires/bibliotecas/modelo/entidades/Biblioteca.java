package ar.com.grupoesfera.buenosaires.bibliotecas.modelo.entidades;

import java.io.Serializable;

public class Biblioteca implements Serializable {
	
	private static final long serialVersionUID = 8894450936588206726L;

	private String id;
	
	private String idDeBusqueda;
	
	private String nombre;
	
	private String direccion;
	
	private int latitud;
	
	private int longitud;

	public Biblioteca() {
		super();
	}

	public Biblioteca(String id, String idDeBusqueda, String nombre, String direccion, int latitud, int longitud) {

		this.id = id;
		this.idDeBusqueda = idDeBusqueda;
		this.nombre = nombre;
		this.direccion = direccion;
		this.latitud = latitud;
		this.longitud = longitud;
		
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public void setIdDeBusqueda(String idDeBusqueda) {
		this.idDeBusqueda = idDeBusqueda;
	}

	public String getIdDeBusqueda() {
		return idDeBusqueda;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}
	
	public int getLatitud() {
		return latitud;
	}
	
	public void setLatitud(int latitud) {
		this.latitud = latitud;
	}
	
	public int getLongitud() {
		return longitud;
	}
	
	public void setLongitud(int longitud) {
		this.longitud = longitud;
	}

}
