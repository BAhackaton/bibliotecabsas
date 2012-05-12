package ar.com.grupoesfera.buenosaires.bibliotecas.modelo;

import java.util.List;

public interface Catalogo {

	Libro recuperar(String isbn);
	
	List<Libro> buscar(String texto);
}
