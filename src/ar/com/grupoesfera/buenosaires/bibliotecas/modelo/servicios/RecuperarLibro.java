package ar.com.grupoesfera.buenosaires.bibliotecas.modelo.servicios;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import org.jsoup.Connection;
import org.jsoup.Connection.Response;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import android.util.Log;
import ar.com.grupoesfera.buenosaires.bibliotecas.modelo.BibliotecaException;
import ar.com.grupoesfera.buenosaires.bibliotecas.modelo.BibliotecasBsAs;
import ar.com.grupoesfera.buenosaires.bibliotecas.modelo.Libro;
import ar.com.grupoesfera.buenosaires.bibliotecas.modelo.entidades.Biblioteca;
import ar.com.grupoesfera.buenosaires.bibliotecas.modelo.entidades.LibroAbstracto;
import ar.com.grupoesfera.buenosaires.bibliotecas.modelo.entidades.LibroDisponibleEnBiblioteca;
import ar.com.grupoesfera.buenosaires.bibliotecas.modelo.entidades.LibroImpl;

public class RecuperarLibro {

	private static final String LOG_TAG = RecuperarLibro.class.getSimpleName();

	private String id;
	
	private Libro libro;
	
	public RecuperarLibro() {
		
	}
	
	public void setId(String id) {
		
		this.id = id;
	}
	
	public Libro ejecutar() {

		this.libro = RecuperarLibro.NO_ENCONTRADO;
		
		this.cargar();

		return this.libro;
	}

	protected void cargar() {

		Log.d(LOG_TAG, "Comienza la recuperación de libros");

		try {
			
			Connection conexion = Jsoup.connect("http://catalogo.bibliotecas.gov.ar/pergamo/opac/cgi-bin/pgopac.cgi?VDOC=" + this.id)
										.timeout(10000);
			
			Response resultado = conexion.execute();

			Document documento = resultado.parse();

			Elements trs = documento.select("#tbGeneral tr");
			
			LibroImpl libro = new LibroImpl();
			
			libro.setIsbn(this.leer(trs, "ISBN"));
			libro.setTitulo(this.leer(trs, "Título"));
			libro.setResponsables(this.leer(trs, "Responsables"));
			libro.setEditorial(this.leer(trs, "Editorial"));
			libro.setEdicion(this.leer(trs, "Edición"));
			libro.setDescripcionFisica(this.leer(trs, "Descripción Física"));
			
			Elements disponibilidad = documento.select("#lyEjemplares table tbody tr");
			libro.setDondeEsta(this.leerBibliotecas(disponibilidad));
			
			Log.d(LOG_TAG, "Esta disponible en " + libro.dondeEsta().size() + " bibliotecas");
			
			this.libro = libro;
			
		} catch (Exception e) {

			throw new BibliotecaException(e);

		} finally {

		}
	}

	private String leer(Elements trs, String campo) {

		String valor = null;
		
		Element elementoNombre = trs.select("td:matches(^" + campo +  "$)").first();
		
		if (elementoNombre != null) {
			
			Element elementoValor = elementoNombre.nextElementSibling();
			
			if (elementoValor != null) {
				
				valor = elementoValor.text();
			}
		}
				
		return valor;
	}
	
	private List<LibroDisponibleEnBiblioteca> leerBibliotecas(Elements bibliotecas){
		
		Map<String,LibroDisponibleEnBiblioteca> dondeEsta = new HashMap<String,LibroDisponibleEnBiblioteca>();
		
		if(bibliotecas.size() >= 1) {
			
			for (int i = 1; i < bibliotecas.size(); i++) {
				Element registroBiblioteca = bibliotecas.get(i); 
				Elements biblioteca = registroBiblioteca.children();
				String idBiblioteca = biblioteca.get(1).text();
				Boolean disponibilidad = estaDisponible(biblioteca.get(6).text());
				
				if(dondeEsta.containsKey(idBiblioteca)) {
					LibroDisponibleEnBiblioteca bibliotecaGuardada = dondeEsta.get(idBiblioteca);
					bibliotecaGuardada.setDisponible(bibliotecaGuardada.isDisponible() || disponibilidad);
				} else {
					dondeEsta.put(idBiblioteca, this.construirBiblioteca(idBiblioteca, disponibilidad));
				}
				
			}

		}
		
		return new LinkedList<LibroDisponibleEnBiblioteca>(dondeEsta.values());
		
	}
	
	private boolean estaDisponible(String disponibilidad){
		return disponibilidad.equalsIgnoreCase("disponible");
	}
	
	private LibroDisponibleEnBiblioteca construirBiblioteca(String id, Boolean disponibilidad) {
		
		Biblioteca biblioteca = BibliotecasBsAs.instancia().getBibliotecas().get(id);
		return new LibroDisponibleEnBiblioteca(biblioteca, disponibilidad);
	}
	
	private static final Libro NO_ENCONTRADO = new LibroAbstracto() {};
	
}
