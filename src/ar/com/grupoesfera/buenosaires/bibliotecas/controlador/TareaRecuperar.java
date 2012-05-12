package ar.com.grupoesfera.buenosaires.bibliotecas.controlador;

import android.os.AsyncTask;
import ar.com.grupoesfera.buenosaires.bibliotecas.modelo.BibliotecasBsAs;
import ar.com.grupoesfera.buenosaires.bibliotecas.modelo.Libro;
import ar.com.grupoesfera.buenosaires.bibliotecas.vista.DetallesLibro;

public class TareaRecuperar extends AsyncTask<String, Void, Libro>{

	private DetallesLibro vista;
	
	public TareaRecuperar(DetallesLibro vista) {
		
		this.vista = vista;
	}
	
	@Override
	protected Libro doInBackground(String... params) {

		String texto = params[0];
		
		Libro resultado = null;
		
		try {
			
			resultado = BibliotecasBsAs.instancia().getCatalogo().recuperar(texto);

		} catch (Exception e) {
			
			// TODO informar los detalles del error
		}
		
		return resultado;
	}
	
	@Override
	protected void onPreExecute() {

		this.vista.recuperando();
	}
	
	@Override
	protected void onPostExecute(Libro resultado) {

		if (resultado != null) {
			
			this.vista.mostrar(resultado);
			
		} else {
			
			this.vista.finish();
		}
		
	}
}
