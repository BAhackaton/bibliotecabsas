package ar.com.grupoesfera.buenosaires.bibliotecas.controlador;

import java.util.List;

import android.os.AsyncTask;
import ar.com.grupoesfera.buenosaires.bibliotecas.modelo.BibliotecasBsAs;
import ar.com.grupoesfera.buenosaires.bibliotecas.modelo.Libro;
import ar.com.grupoesfera.buenosaires.bibliotecas.vista.ResultadosBusqueda;

public class TareaBuscar extends AsyncTask<String, Libro, List<Libro>>{

	private ResultadosBusqueda vista;
	
	public TareaBuscar(ResultadosBusqueda vista) {
		
		this.vista = vista;
	}
	
	@Override
	protected List<Libro> doInBackground(String... params) {

		String texto = params[0];
		
		List<Libro> resultado = null;
		
		try {
			
			resultado = BibliotecasBsAs.instancia().getCatalogo().buscar(texto);

		} catch (Exception e) {
			
			// TODO informar del detalle del error
		}
		
		return resultado;
	}
	
	@Override
	protected void onPreExecute() {

		this.vista.buscando();
	}
	
	@Override
	protected void onPostExecute(List<Libro> resultado) {

		if (resultado != null) {
			
			this.vista.mostrar(resultado);
			
		} else {
			
			this.vista.finish();
		}
		
	}
}
