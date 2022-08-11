package sapo;

public class Comentario {

	private String comentario;
	private String autorCpf;

	public Comentario(String comentario, String autorCpf) {
		this.comentario = comentario;
		this.autorCpf = autorCpf;
	}

	public String getComentario() {
		return comentario;
	}

	public void setComentario(String comentario) {
		this.comentario = comentario;
	}

	public String getAutorCpf() {
		return autorCpf;
	}

	public void setAutorCpf(String autorCpf) {
		this.autorCpf = autorCpf;
	}

	// ToString
	// @Override
	// public String toString() {
	// return getAutorCpf() + getComentario();
	// }

}