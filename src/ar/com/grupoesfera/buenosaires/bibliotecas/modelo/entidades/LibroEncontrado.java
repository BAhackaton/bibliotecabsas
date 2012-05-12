package ar.com.grupoesfera.buenosaires.bibliotecas.modelo.entidades;


public class LibroEncontrado extends LibroAbstracto {

	private String sintesis;

	public LibroEncontrado(String id, String sintesis) {
		
		super(id);
		this.sintesis = sintesis;
	}
	
	@Override
	public String getSintesis() {
		
		return this.sintesis;
	}
	
}
