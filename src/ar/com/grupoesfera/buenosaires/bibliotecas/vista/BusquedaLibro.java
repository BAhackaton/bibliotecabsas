package ar.com.grupoesfera.buenosaires.bibliotecas.vista;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import ar.com.grupoesfera.buenosaires.bibliotecas.R;
import ar.com.grupoesfera.buenosaires.bibliotecas.controlador.ControladorDeBusquedas;

public class BusquedaLibro extends Activity {
	
	private EditText viewSimpleEdit;
	
	private final View.OnClickListener buscar = new OnClickListener() {		
		
		@Override
		public void onClick(View arg0) {
			
			ControladorDeBusquedas.instancia().buscar(BusquedaLibro.this);
		}
	};
	
	@Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.busqueda_libro);
        
        Spinner bibliotecas = (Spinner) findViewById(R.id.bibliotecas);
        ArrayAdapter adapter = ArrayAdapter.createFromResource(
                this, R.array.bibliotecas, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        bibliotecas.setAdapter(adapter);
        
        this.viewSimpleEdit = (EditText) this.findViewById(R.id.busqueda_simple_input);
        
        Button button = (Button) findViewById(R.id.buscar_libro);
        
        button.setOnClickListener(this.buscar);
    }

	public CharSequence getCriterioSimple() {
		
		return this.viewSimpleEdit.getText();
	}

}
