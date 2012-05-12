package ar.com.grupoesfera.buenosaires.bibliotecas.modelo.servicios;

import java.util.List;

import ar.com.grupoesfera.buenosaires.bibliotecas.modelo.Catalogo;
import ar.com.grupoesfera.buenosaires.bibliotecas.modelo.Libro;

public class CatalogoImpl implements Catalogo {

	private BuscarLibros buscarLibros = new BuscarLibros();
	
	private RecuperarLibro recuperarLibro = new RecuperarLibro();
	
	@Override
	public List<Libro> buscar(String texto) {
		
		this.buscarLibros.setTexto(texto);
		
		return this.buscarLibros.ejecutar();
	}

	@Override
	public Libro recuperar(String isbn) {
		
		this.recuperarLibro.setId(isbn);
		
		return this.recuperarLibro.ejecutar();
	}

}
