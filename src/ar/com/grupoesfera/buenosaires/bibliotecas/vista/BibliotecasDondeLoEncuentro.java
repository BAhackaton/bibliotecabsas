package ar.com.grupoesfera.buenosaires.bibliotecas.vista;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ListView;
import ar.com.grupoesfera.buenosaires.bibliotecas.R;
import ar.com.grupoesfera.buenosaires.bibliotecas.controlador.ControladorDeBusquedas;
import ar.com.grupoesfera.buenosaires.bibliotecas.modelo.Libro;
import ar.com.grupoesfera.buenosaires.bibliotecas.vista.adapter.BibliotecaListAdapter;

public class BibliotecasDondeLoEncuentro extends Activity {

	
//	private List<LibroDisponibleEnBiblioteca> bibliotecasDisponible;
	
	private BibliotecaListAdapter listAdapter;
	
	private ListView listView;
	
	public BibliotecasDondeLoEncuentro() {
		// TODO Reemplazar por busqueda
//		
//		bibliotecasDisponible = new ArrayList<LibroDisponibleEnBiblioteca>();
//		
//		Biblioteca biblioteca = new Biblioteca();
//		biblioteca.setNombre("Güiraldes, Ricardo");
//		biblioteca.setDireccion("Talcahuano 1261 - entre Arenales y Juncal");
//		
//		LibroDisponibleEnBiblioteca libro = new LibroDisponibleEnBiblioteca(biblioteca, true);
//		bibliotecasDisponible.add(libro);
//		
//		biblioteca = new Biblioteca();
//		biblioteca.setNombre("GUIDO Y SPANO, Carlos");
//		biblioteca.setDireccion("Güemes 4601 - esquina Uriarte");
//		
//		libro = new LibroDisponibleEnBiblioteca(biblioteca, true);
//		bibliotecasDisponible.add(libro);
//		
//		biblioteca = new Biblioteca();
//		biblioteca.setNombre("Galvez, Manuel");
//		biblioteca.setDireccion("Cordoba 1558 - entre Paran� y Montevideo");
//		
//		libro = new LibroDisponibleEnBiblioteca(biblioteca, true);
//		bibliotecasDisponible.add(libro);
//		
//		
//		biblioteca = new Biblioteca();
//		biblioteca.setNombre("LUGONES, Leopoldo");
//		biblioteca.setDireccion("La Pampa 2215 - entre Cuba y Vuelta de Obligado");
//		
//		libro = new LibroDisponibleEnBiblioteca(biblioteca, false);
//		bibliotecasDisponible.add(libro);
//		
//		biblioteca = new Biblioteca();
//		biblioteca.setNombre("LYNCH, Benito");
//		biblioteca.setDireccion("Pasaje Yrupé 6714 - Barrio Los Perales");
//		
//		libro = new LibroDisponibleEnBiblioteca(biblioteca, false);
//		bibliotecasDisponible.add(libro);
	}

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.bibliotecas_donde_lo_encuentro);
		
//		listAdapter = new BibliotecaListAdapter(this, R.layout.bibliotecas_disponible_item, bibliotecasDisponible);
		  	
		listView = (ListView) findViewById(R.id.bibliotecas_diponible_list);
//		listView.setAdapter(listAdapter);

		listView.setOnItemClickListener(new OnItemClickListener() {
			public void onItemClick(AdapterView<?> parent, View view,
					int position, long id) {
				
				Log.e("implemntar", "IMPLEMENTAR");
			}
		});
		
		ControladorDeBusquedas.instancia().mostrarBibliotecas(this);
	}

	public void mostrar(Libro libro) {
		
		listAdapter = new BibliotecaListAdapter(this, R.layout.bibliotecas_disponible_item, libro.dondeEsta());
		
		listView.setAdapter(listAdapter);
		
	}
}
