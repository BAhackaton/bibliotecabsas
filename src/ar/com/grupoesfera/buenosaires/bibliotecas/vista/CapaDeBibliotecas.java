package ar.com.grupoesfera.buenosaires.bibliotecas.vista;

import java.util.LinkedList;
import java.util.List;

import android.app.AlertDialog;
import android.content.Context;
import android.graphics.drawable.Drawable;
import ar.com.grupoesfera.buenosaires.bibliotecas.modelo.entidades.Biblioteca;
import ar.com.grupoesfera.buenosaires.bibliotecas.modelo.entidades.LibroDisponibleEnBiblioteca;

import com.google.android.maps.GeoPoint;
import com.google.android.maps.ItemizedOverlay;
import com.google.android.maps.OverlayItem;

public class CapaDeBibliotecas extends ItemizedOverlay<OverlayItem> {

    private List<OverlayItem> items = new LinkedList<OverlayItem>();
    
    private Context context;

    public CapaDeBibliotecas(Drawable defaultMarker, Context context) {
        super(boundCenterBottom(defaultMarker));
        this.context = context;
    }
    
    public void agregar(LibroDisponibleEnBiblioteca disponibilidad) {
    	
    	Biblioteca biblioteca = disponibilidad.getBiblioteca();
        
    	if (biblioteca != null) {
    		
	    	GeoPoint posicion = new GeoPoint(biblioteca.getLatitud(), biblioteca.getLongitud());
	    	
	        OverlayItem item = new OverlayItem(posicion, biblioteca.getNombre(), biblioteca.getDireccion());
	        
	        this.items.add(item);
	        
    	}
    }

    public void recargar() {
    	
    	this.populate();
    }
    
    @Override
    protected OverlayItem createItem(int i) {

        return this.items.get(i);
    }

    @Override
    public int size() {
        
        return this.items.size();
    }
    
    @Override
    protected boolean onTap(int index) {
    	
    	if (index >= 0) {
    		
	    	OverlayItem item = items.get(index);
	    	AlertDialog.Builder dialog = new AlertDialog.Builder(context);
	    	dialog.setTitle(item.getTitle());
	    	dialog.setMessage(item.getSnippet());
	    	dialog.show();
	    	
    	}
    	
    	return true;
    }

}
