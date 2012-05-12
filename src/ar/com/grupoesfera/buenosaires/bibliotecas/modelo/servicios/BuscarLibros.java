package ar.com.grupoesfera.buenosaires.bibliotecas.modelo.servicios;

import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.jsoup.Connection;
import org.jsoup.Connection.Method;
import org.jsoup.Connection.Response;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import android.util.Log;
import ar.com.grupoesfera.buenosaires.bibliotecas.modelo.BibliotecaException;
import ar.com.grupoesfera.buenosaires.bibliotecas.modelo.Libro;
import ar.com.grupoesfera.buenosaires.bibliotecas.modelo.entidades.LibroEncontrado;

public class BuscarLibros {

	private static final String LOG_TAG = BuscarLibros.class.getSimpleName();

	private static final Pattern PATRON_ID = Pattern.compile("[^=]*=([0-9|\\.]+).*");
	
	private Map<String, String> datos;
	
	private List<Libro> libros;
	
	public BuscarLibros() {
		
		this.datos = new HashMap<String, String>();

		this.datos.put("cArea1", "BIBLIOTECA");
		this.datos.put("cTermino1", "");
		this.datos.put("cTodas1", "N");
		this.datos.put("cOperacion1", "AND");
		this.datos.put("cArea2", "En todas");
		this.datos.put("cTodas2", "S");
		this.datos.put("cOperacion2", "AND");
		this.datos.put("bBuscar", "Buscar");
	}
	
	public void setTexto(String texto) {
		
		this.datos.put("cTermino2", texto);
	}
	
	public List<Libro> ejecutar() {

		this.libros = Collections.emptyList();
		
		this.cargar();

		return this.libros;
	}

	protected void cargar() {

		Log.d(LOG_TAG, "Comienza la recuperación de libros");

		try {
			
			this.libros = new LinkedList<Libro>();
			
			Connection conexion = Jsoup.connect("http://catalogo.bibliotecas.gov.ar/pergamo/opac/cgi-bin/pgopac.cgi?ISRCH")
										.method(Method.POST)
										.data(this.datos)
										.followRedirects(true)
										.timeout(10000);
			
			Response resultado = conexion.execute();

			Document documento = resultado.parse();

			Elements trs = documento.select("#tb-resultados tbody tr");
			
			for (Element tr : trs) {
				
				String sintesis = tr.text();
				String id = null;
				
				Element link = tr.select("a").first();
				
				if (link != null) {
					
					String url = link.attr("href");
					
					Matcher busquedaId = PATRON_ID.matcher(url);
					
					if (busquedaId.matches()) {
						
						id = busquedaId.group(1);
					}
				}
				
				if ((sintesis != null) && (id != null)) {
					
					this.libros.add(new LibroEncontrado(id, sintesis));
				}
			}
			
		} catch (Exception e) {

			throw new BibliotecaException(e);

		} finally {

		}
	}
}
