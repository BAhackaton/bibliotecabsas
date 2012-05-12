package ar.com.grupoesfera.buenosaires.bibliotecas.vista.adapter;

import java.util.List;

import android.content.Context;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;
import ar.com.grupoesfera.buenosaires.bibliotecas.R;
import ar.com.grupoesfera.buenosaires.bibliotecas.modelo.entidades.Biblioteca;
import ar.com.grupoesfera.buenosaires.bibliotecas.modelo.entidades.LibroDisponibleEnBiblioteca;

public class BibliotecaListAdapter extends ArrayAdapter<LibroDisponibleEnBiblioteca> { 
	
	private List<LibroDisponibleEnBiblioteca> bibliotecasDisponibles;
	private Context context;

	public BibliotecaListAdapter(Context context, int textViewResourceId, List<LibroDisponibleEnBiblioteca> bibliotecas) {
		super(context, textViewResourceId, bibliotecas);
		this.bibliotecasDisponibles = bibliotecas;
		this.context = context;
	}

	@Override
	public View getView(int position, View view, ViewGroup parent) {
		
		if (view == null) {
			LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
			view = inflater.inflate(R.layout.bibliotecas_disponible_item, null);
		}

		LibroDisponibleEnBiblioteca libro = bibliotecasDisponibles.get(position);
		
		if(libro != null) {
			
			Biblioteca biblioteca = libro.getBiblioteca();
			
			TextView nombreBiblioteca = (TextView) view.findViewById(R.id.nombre_biblioteca);
			TextView diponible = (TextView) view.findViewById(R.id.libro_disponible);
			TextView direccionBiblioteca = (TextView) view.findViewById(R.id.direccion_biblioteca);

			nombreBiblioteca.setText(biblioteca != null ? biblioteca.getNombre() : "");
			
			if(diponible != null) {
				diponible.setText(libro.isDisponible() ? "disponible" : "no disponible"); // TODO: Reemplazar por recurso
				
				if (!libro.isDisponible()) {
					diponible.setTextColor(Color.parseColor(context.getString(R.color.rojo)));
					
				} else {
					diponible.setTextColor(Color.parseColor(context.getString(R.color.verde)));
				}
			}
			
			
			direccionBiblioteca.setText(biblioteca != null ? biblioteca.getDireccion() : "");

		}
		
		return view;
	}
}