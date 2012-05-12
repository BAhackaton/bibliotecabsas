package ar.com.grupoesfera.buenosaires.bibliotecas.modelo;

import java.util.HashMap;
import java.util.Map;

import ar.com.grupoesfera.buenosaires.bibliotecas.modelo.entidades.Biblioteca;
import ar.com.grupoesfera.buenosaires.bibliotecas.modelo.servicios.CatalogoImpl;

public class BibliotecasBsAs {

	private static final BibliotecasBsAs instancia = new BibliotecasBsAs();
	
	private Catalogo catalogo;
	private Map<String, Biblioteca> bibliotecas;
	
	protected BibliotecasBsAs() {
		
		this.catalogo = new CatalogoImpl();
		this.cargarBibliotecas();
		
	}
	
	public static BibliotecasBsAs instancia() {
		
		return instancia;
	}
	
	public Catalogo getCatalogo() {
		
		return this.catalogo;
	}
	
	public Map<String, Biblioteca> getBibliotecas() {
		return this.bibliotecas;
	}
	
	private void cargarBibliotecas(){
		this.bibliotecas = new HashMap<String, Biblioteca>();
		
		this.agregarBiblioteca("CASA DE LA LECTURA","","CASA DE LA LECTURA","Lavalleja 924",-34597642,-58429717);
		this.agregarBiblioteca("BANCHS, Enrique","","ENRIQUE BANCHS","Caseros y Urquiza - Parque Patricios",-34637427,-58407530);
		this.agregarBiblioteca("GUIDO Y SPANO, Carlos","3","CARLOS GUIDO Y SPANO","Güemes 4601",-34581355,-58423752);
		this.agregarBiblioteca("LYNCH, Benito","7","BENITO LYNCH","Pje. Yrupé 6714",-34667682,-58496429);
		this.agregarBiblioteca("FERNÁNDEZ MORENO, Baldomero","9","BALDOMERO FERNÁNDEZ MORENO","Concepción Arenal 4206",-34591089,-58450252);
		this.agregarBiblioteca("SAAVEDRA, Brig. Gral. Cornelio","13","BRIG. GRAL. CORNELIO SAAVEDRA","Crisólogo Larralde 6293",-34568564,-58507222);
		this.agregarBiblioteca("DEVOTO, Antonio","21","ANTONIO DEVOTO","Bahía Blanca 4025",-34599267,-58510677);
		this.agregarBiblioteca("DEL CAMPO, Estanislao","23","ESTANISLAO DEL CAMPO","Pje. De las Artes 1210",-34634020,-58438386);
		this.agregarBiblioteca("STORNI, Alfonsina (Biblioteca de la Mujer)","25","ALFONSINA STORNI","Venezuela 1538 1º Piso",-34614615,-58387982);
		this.agregarBiblioteca("BANCHS, Enrique (Biblioteca Infantil)","27","ENRIQUE BANCHS","Caseros y Urquiza - Parque Patricios",-34637427,-58407530);
		this.agregarBiblioteca("YUNQUE, Alvaro (Infanto Juvenil)","30","ÁLVARO YUNQUE","S. de la Frontera 5210 Block 28",-34684658,-58463727);
		this.agregarBiblioteca("Infantil DEVOTO, Antonio","36","ANTONIO DEVOTO","Bahía Blanca 4025",-34599267,-58510677);
		this.agregarBiblioteca("Infantil LYNCH, Benito","38","BENITO LYNCH","Pje. Yrupé 6714",-34667682,-58496429);
		this.agregarBiblioteca("CIRCE (Biblioteca TESORO - Con cita telefónica)","40","CIRCE – Libros Tesoro","Talcahuano 1261 – 1º",-34593350,-58386008);
		this.agregarBiblioteca("CARRIEGO, Evaristo","15","EVARISTO CARRIEGO","Honduras 3784",-34594039,-58416091);
		this.agregarBiblioteca("ASCASUBI, Hilario","10","HILARIO ASCASUBI","GraL. Cesar Díaz 4219",-34623320,-58492266);
		this.agregarBiblioteca("VILLAFAÑE, Javier","24","JAVIER VILLAFAÑE","A. M. Janer Manzana 5 Local 279 Barrio Illia",-34646643,-58434523);
		this.agregarBiblioteca("Infantil VILLAFAÑE, Javier","39","JAVIER VILLAFAÑE","A. M. Janer Manzana 5 Local 279 Barrio Illia",-34646643,-58434523);
		this.agregarBiblioteca("GONZÁLEZ, Joaquín V.","14","JOAQUÍN V. GONZÁLEZ","Suárez 408",-34635291,-58358928);
		this.agregarBiblioteca("Infantil GONZÁLEZ, Joaquín V.","37","JOAQUÍN V. GONZÁLEZ","Suárez 408",-34635291,-58358928);
		this.agregarBiblioteca("HERNANDEZ, José","20","JOSÉ HERNÁNDEZ","Boquerón 6753",-34646360,-58520869);
		this.agregarBiblioteca("MÁRMOL, José","11","JOSÉ MÁRMOL","Juramento 2937",-34564906,-58461646);
		this.agregarBiblioteca("SAGUIER, Julio César","19","JULIO CÉSAR SAGUIER","Torre 14 – PB - Dellepiane Norte Barrio Cardenal Copello",-34666058,-58475164);
		this.agregarBiblioteca("Infantil SAGUIER, Julio César","33","JULIO CÉSAR SAGUIER","Torre 14 – PB - Dellepiane Norte Barrio Cardenal Copello",-34666058,-58475164);
		this.agregarBiblioteca("CORTÁZAR","8","JULIO CORTÁZAR","Lavalleja 924",-34597836,-58429803);
		this.agregarBiblioteca("LA PRENSA","18","LA PRENSA","Plaza Nicaragua – J. C. Paz al 3.100",-34644966,-58408924);
		this.agregarBiblioteca("Infantil LUGONES, Leopoldo","34","LEOPOLDO LUGONES","La Pampa 2215",-34563757,-58452441);
		this.agregarBiblioteca("TESORO LUGONES, Leopoldo (Con cita telefónica)","28","LEOPOLDO LUGONES","La Pampa 2215",-34563757,-58452441);
		this.agregarBiblioteca("LUGONES, Leopoldo","6","LEOPOLDO LUGONES","La Pampa 2215",-34563757,-58452441);
		this.agregarBiblioteca("CHORROARÍN, Canónigo Luis José de","12","LUIS JOSÉ DE CHORROARÍN","Soldado de la Frontera 5059 - Block 23",-34683440,-58465165);
		this.agregarBiblioteca("GÁLVEZ, Manuel","4","MANUEL GÁLVEZ","Av. Córdoba 1558",-34599338,-58388969);
		this.agregarBiblioteca("PELLIZA, Mariano","17","MARIANO PELLIZA","Pje. Cranwell 819",-34637604,-58456539);
		this.agregarBiblioteca("CENTENERA, Martín del Barco","16","MARTIN DEL BARCO CENTENERA","Venezuela 1538",-34614579,-58388003);
		this.agregarBiblioteca("Infantil CENTENERA, M. del Barco","35","MARTIN DEL BARCO CENTENERA","Venezuela 1538",-34614579,-58388003);
		this.agregarBiblioteca("PATRIMONIAL","42","MEDIATECA DE PATRIMONIO Y GESTION CULTURAL","Av. de Mayo 575 – PB",-34608539,-58374485);
		this.agregarBiblioteca("TESORO CANÉ, Migue","32","MIGUEL CANÉ","Carlos Calvo 4319",-34624927,-58426219);
		this.agregarBiblioteca("CANÉ, Miguel","4","MIGUEL CANÉ","Carlos Calvo 4319",-34624927,-58426219);
		this.agregarBiblioteca("Infantil CANÉ, Miguel","29","MIGUEL CANÉ","Carlos Calvo 4319",-34624927,-58426219);
		this.agregarBiblioteca("NORA LANGE","","NORA LANGE","Av. Cruz y Escalada (dentro del Parque de la Ciudad)",-34672712,-58459007);
		this.agregarBiblioteca("OBLIGADO, Rafael","22","RAFAEL OBLIGADO","Pje. Crainqueville 2233",-34609564,-58483962);
		this.agregarBiblioteca("LA REINA BATATA","","REINA BATATA","Plaza Barrancas – La Pampa y 11 de Septiembre",-34561513,-58448771);
		this.agregarBiblioteca("GÜIRALDES, Ricardo","2","RICARDO GUIRALDES","Talcahuano 1261",-34593438,-58385965);

	}

	private void agregarBiblioteca(String id, String idBusqueda, String nombre, String direccion, int latitud, int longitud) {
		
		Biblioteca biblioteca = new Biblioteca(id, idBusqueda, nombre, direccion, latitud, longitud);
		bibliotecas.put(id, biblioteca);
		
	}
	
}
