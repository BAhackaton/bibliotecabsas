package ar.com.grupoesfera.buenosaires.bibliotecas.controlador;

import android.content.Intent;
import ar.com.grupoesfera.buenosaires.bibliotecas.modelo.Libro;
import ar.com.grupoesfera.buenosaires.bibliotecas.modelo.entidades.LibroDisponibleEnBiblioteca;
import ar.com.grupoesfera.buenosaires.bibliotecas.vista.BibliotecasDondeLoEncuentro;
import ar.com.grupoesfera.buenosaires.bibliotecas.vista.BusquedaLibro;
import ar.com.grupoesfera.buenosaires.bibliotecas.vista.DetallesLibro;
import ar.com.grupoesfera.buenosaires.bibliotecas.vista.MapaConBibliotecas;
import ar.com.grupoesfera.buenosaires.bibliotecas.vista.ResultadosBusqueda;

public class ControladorDeBusquedas {

	private static final ControladorDeBusquedas instancia = new ControladorDeBusquedas();
	
	protected ControladorDeBusquedas() {

	}
	
	public void buscar(BusquedaLibro vista) {
		
		String criterio = String.valueOf(vista.getCriterioSimple()).trim();
		
		if ((criterio != null) && (criterio.length() > 0)) {
		
			Intent intent = new Intent(vista, ResultadosBusqueda.class);
			intent.putExtra("criterioSimple", criterio);
			vista.startActivity(intent);		
		}
	}
	
	public void mostrarResultados(ResultadosBusqueda vista) {
		
		Intent intent = vista.getIntent();
		String criterio = intent.getStringExtra("criterioSimple");
		
		new TareaBuscar(vista).execute(criterio);
	}

	public void seleccionar(ResultadosBusqueda vista) {

		
		Libro seleccionado = vista.getSeleccionado();
		
		if (seleccionado != null) {
			
			Intent intent = new Intent(vista, DetallesLibro.class);
			intent.putExtra("libroId", seleccionado.getId());
			vista.startActivity(intent);
		}
	}
	
	public void mostrar(DetallesLibro vista) {
	
		Intent intent = vista.getIntent();
		
		String libroId = intent.getStringExtra("libroId");
		
		if ((libroId != null) && (libroId.length() > 0)) {
			
			new TareaRecuperar(vista).execute(libroId);
		}
	}
	
	public static ControladorDeBusquedas instancia() {
		
		return instancia;
	}

	public void recuperarBibliotecas(DetallesLibro vista) {
		
		Intent intent = new Intent(vista, BibliotecasDondeLoEncuentro.class);

		intent.putExtra("libro", vista.getLibro());
		
		vista.startActivity(intent);
	}
	
	public void mostrarBibliotecas(BibliotecasDondeLoEncuentro vista) {
		
		Intent intent = vista.getIntent();
		
		Libro libro = (Libro) intent.getSerializableExtra("libro");
		
		if (libro != null) {
			
			vista.mostrar(libro);
			
		} else {
			
			vista.finish();
		}
	}
	
	public void mostrarEnMapa(DetallesLibro vista) {
		
		Intent intent = new Intent(vista, MapaConBibliotecas.class);

		intent.putExtra("libro", vista.getLibro());
		
		vista.startActivity(intent);
	}

	public void mostrarBibliotecasEnMapa(MapaConBibliotecas vista) {

		Intent intent = vista.getIntent();
		
		Libro libro = (Libro) intent.getSerializableExtra("libro");
		
		if (libro != null) {
			
			for (LibroDisponibleEnBiblioteca disponibilidad : libro.dondeEsta()) {
				
				vista.agregar(disponibilidad);
			}
			
			vista.mostrar();
			
		} else {
			
			vista.finish();
		}
	}

}
