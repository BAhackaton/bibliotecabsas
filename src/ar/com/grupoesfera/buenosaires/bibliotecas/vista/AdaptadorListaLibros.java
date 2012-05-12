package ar.com.grupoesfera.buenosaires.bibliotecas.vista;

import java.util.Collections;
import java.util.List;

import android.content.Context;
import android.graphics.Color;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import ar.com.grupoesfera.buenosaires.bibliotecas.R;
import ar.com.grupoesfera.buenosaires.bibliotecas.modelo.Libro;

public class AdaptadorListaLibros extends BaseAdapter {
    
    private static final String LOG_TAG = AdaptadorListaLibros.class.getSimpleName();
    
    private Context context;
    private List<Libro> libros;
    private LayoutInflater inflater;
	
    public AdaptadorListaLibros(Context context) {
     
        this.context = context;
        this.inflater = (LayoutInflater)this.context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        this.setLibros(null);
    }
    
    public void setLibros(List<Libro> libros) {
    	
    	this.libros = libros != null ? libros : Collections.<Libro>emptyList();
    	
    	this.notifyDataSetChanged();
    }
    
    @Override
	public int getCount() {

		return this.libros.size();
	}

	@Override
	public Libro getItem(int posicion) {

		return this.libros.get(posicion);
	}

	@Override
	public long getItemId(int posicion) {
		
		return this.getItem(posicion).getId().hashCode();
	}

	@Override
	public View getView(int posicion, View convertView, ViewGroup parent) {
		
	    View view = getView(convertView, parent, R.layout.resultado_busqueda_libro_item);

	    try {

	    	Libro libro = this.getItem(posicion);
	    	
	    	view.setTag(libro);
	    	
	    	TextView sintesis = (TextView) view.findViewById(R.id.sintesis);
	    	
	    	sintesis.setText(libro.getSintesis());
	    	
	    	if (posicion % 2 == 0) {
	    		view.setBackgroundColor(Color.parseColor(context.getString(R.color.gris_muy_oscuro)));
	    		
	    	} else {
	    		view.setBackgroundColor(Color.BLACK);
	    	}
	    	
	    } catch (Exception ignorada) {
	        
	        Log.d(LOG_TAG, "Construyendo ítem resultado busqueda de libros", ignorada);
	    }

		return view;
	}
	
    private View getView(View convertView, ViewGroup parent, int layoutId) {
        
        View view;
        
        if (convertView == null) {
            
            view = this.inflater.inflate(layoutId, parent, false);
            
        } else {
            
            view = convertView;
        }
        
        return view;
    }

}
