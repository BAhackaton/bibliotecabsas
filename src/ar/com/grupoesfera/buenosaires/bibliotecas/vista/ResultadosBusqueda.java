package ar.com.grupoesfera.buenosaires.bibliotecas.vista;

import java.util.List;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ListView;
import ar.com.grupoesfera.buenosaires.bibliotecas.R;
import ar.com.grupoesfera.buenosaires.bibliotecas.controlador.ControladorDeBusquedas;
import ar.com.grupoesfera.buenosaires.bibliotecas.modelo.Libro;

public class ResultadosBusqueda extends Activity {

	private AdaptadorListaLibros adaptador;
	
	private ControladorDeBusquedas controlador;
	
	private Libro seleccionado;
	
    private final OnItemClickListener seleccionarLibro = new OnItemClickListener() {

		@Override
		public void onItemClick(AdapterView<?> adapter, View view, int position, long id) {
			
			seleccionado = (Libro) view.getTag();
			
			controlador.seleccionar(ResultadosBusqueda.this);
		}
	};
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);

		setContentView(R.layout.resultado_busqueda_libros);

		this.controlador = ControladorDeBusquedas.instancia();
		
		ListView viewResultados = (ListView) this.findViewById(R.id.resultado_busqueda);
		viewResultados.setTextFilterEnabled(true);
		
		this.adaptador = new AdaptadorListaLibros(this);
		viewResultados.setAdapter(this.adaptador);
		viewResultados.setOnItemClickListener(this.seleccionarLibro);
		
		this.controlador.mostrarResultados(this);
	}

	public void buscando() {

		this.findViewById(R.id.buscando).setVisibility(View.VISIBLE);
	}

	public void mostrar(List<Libro> resultado) {

		this.findViewById(R.id.buscando).setVisibility(View.GONE);

		this.adaptador.setLibros(resultado);
	}

	public Libro getSeleccionado() {

		return this.seleccionado;
	}

}
