package ar.com.grupoesfera.buenosaires.bibliotecas.modelo;

public class BibliotecaException extends RuntimeException {

	private static final long serialVersionUID = -2586760169804136157L;

	public BibliotecaException() {
		super();
	}

	public BibliotecaException(String detailMessage, Throwable throwable) {
		super(detailMessage, throwable);
	}

	public BibliotecaException(String detailMessage) {
		super(detailMessage);
	}

	public BibliotecaException(Throwable throwable) {
		super(throwable);
	}

}
