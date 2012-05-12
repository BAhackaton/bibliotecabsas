package ar.com.grupoesfera.buenosaires.bibliotecas.vista;

import java.util.Date;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;
import ar.com.grupoesfera.buenosaires.bibliotecas.R;
import ar.com.grupoesfera.buenosaires.bibliotecas.controlador.ControladorDeBusquedas;
import ar.com.grupoesfera.buenosaires.bibliotecas.modelo.Libro;
import ar.com.grupoesfera.buenosaires.bibliotecas.modelo.entidades.LibroTweet;
import ar.com.grupoesfera.buenosaires.bibliotecas.vista.adapter.TweetsListAdapter;

public class DetallesLibro extends Activity {

	private ControladorDeBusquedas controlador;

	private Libro libro;

	private final View.OnClickListener mostrarBibliotecasEnMapa = new View.OnClickListener() {
		
		@Override
		public void onClick(View v) {

			controlador.mostrarEnMapa(DetallesLibro.this);
		}
	};
	
	private final View.OnClickListener mostrarBibliotecas = new View.OnClickListener() {
		
		@Override
		public void onClick(View v) {

			controlador.recuperarBibliotecas(DetallesLibro.this);
		}
	};
	
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.libro_container);
		
		this.controlador = ControladorDeBusquedas.instancia();
		
		Button boton = (Button) findViewById(R.id.botonDondeLoEncuentro);
		boton.setOnClickListener(this.mostrarBibliotecas);
		
		Button botonMapa = (Button) findViewById(R.id.botonMapa);
		botonMapa.setOnClickListener(this.mostrarBibliotecasEnMapa);
		
		this.controlador.mostrar(this);
	}

	public void recuperando() {

		this.findViewById(R.id.detalles).setVisibility(View.GONE);
		this.findViewById(R.id.recuperando).setVisibility(View.VISIBLE);

	}

	public void mostrar(Libro resultado) {

		this.cargar(resultado);

		this.findViewById(R.id.recuperando).setVisibility(View.GONE);
		this.findViewById(R.id.detalles).setVisibility(View.VISIBLE);
	}

	private void cargar(Libro libro) {

		this.libro = libro;

		if (this.libro != null) {

			TextView.class.cast(this.findViewById(R.id.valorTitulo)).setText(libro.getTitulo());
			TextView.class.cast(this.findViewById(R.id.valorResponsables)).setText(libro.getResponsables());
			TextView.class.cast(this.findViewById(R.id.valorEdicion)).setText(libro.getEdicion());
			TextView.class.cast(this.findViewById(R.id.valorEditorial)).setText(libro.getEditorial());
			TextView.class.cast(this.findViewById(R.id.valorDescripcionFisica)).setText(libro.getDescripcionFisica());
			TextView.class.cast(this.findViewById(R.id.valorIsbn)).setText(libro.getIsbn());
			
			cargarTweets(libro);
		}
	}

	private void cargarTweets(Libro libro) {


		TweetsListAdapter tweetsListAdapter = new TweetsListAdapter(this, R.layout.tweets_item);

		ListView viewTweets = (ListView) findViewById(R.id.viewListaTweets);
		viewTweets.setAdapter(tweetsListAdapter);

		
		LibroTweet tweetActual = new LibroTweet();
		
		tweetActual.setUser( "facundomr" );
		tweetActual.setProfileImageUrl( getApplicationContext().getResources().getDrawable(R.drawable.grupoesfera) );
		tweetActual.setText( "Muy bueno el libro " + libro.getTitulo() + " de " + libro.getResponsables() +" !!!" );
		tweetActual.setDateCreated( new Date() );
		
		((TextView)findViewById(R.id.tituloTwitter)).setVisibility(View.VISIBLE);
		
		tweetsListAdapter.add(tweetActual);
		tweetsListAdapter.notifyDataSetChanged();
		
		LibroTweet otroTweet = new LibroTweet();
		
		otroTweet.setUser( "mtugna" );
		otroTweet.setProfileImageUrl( getApplicationContext().getResources().getDrawable(R.drawable.grupoesfera) );
		otroTweet.setText( "Recién termino de leer el libro " + libro.getTitulo() + ", de " + libro.getResponsables() );
		otroTweet.setDateCreated( new Date() );
		
		tweetsListAdapter.add(otroTweet);
		tweetsListAdapter.notifyDataSetChanged();
		

	}


	public Libro getLibro() {
		
		return this.libro;
	}
}
