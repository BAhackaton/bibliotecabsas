package ar.com.grupoesfera.buenosaires.bibliotecas.vista;

import android.graphics.drawable.Drawable;
import android.os.Bundle;
import ar.com.grupoesfera.buenosaires.bibliotecas.R;
import ar.com.grupoesfera.buenosaires.bibliotecas.controlador.ControladorDeBusquedas;
import ar.com.grupoesfera.buenosaires.bibliotecas.modelo.entidades.LibroDisponibleEnBiblioteca;

import com.google.android.maps.GeoPoint;
import com.google.android.maps.MapActivity;
import com.google.android.maps.MapView;

public class MapaConBibliotecas extends MapActivity {
    
	private CapaDeBibliotecas capaDeBibliotecas;
	
    @Override
    public void onCreate(Bundle savedInstanceState) {
    	
        super.onCreate(savedInstanceState);
        setContentView(R.layout.geolocalizacion_bibliotecas);
        
        MapView mapa = (MapView) findViewById(R.id.mapa);
        mapa.setBuiltInZoomControls(true);
        
        Drawable icono = this.getResources().getDrawable(R.drawable.ic_launcher);
        this.capaDeBibliotecas = new CapaDeBibliotecas(icono, this);
        
        GeoPoint miPosicion = new GeoPoint(-34609193,-58445206);
        mapa.getController().animateTo(miPosicion);
        mapa.getController().setZoom(13);

        mapa.getOverlays().add(this.capaDeBibliotecas);
        
        ControladorDeBusquedas.instancia().mostrarBibliotecasEnMapa(this);

    }
    
    public void agregar(LibroDisponibleEnBiblioteca disponibilidad) {
    	
    	this.capaDeBibliotecas.agregar(disponibilidad);
    }

    public void mostrar() {
    	
    	this.capaDeBibliotecas.recargar();
    }
    
    @Override
    protected boolean isRouteDisplayed() {
    
        return false;
    }
}