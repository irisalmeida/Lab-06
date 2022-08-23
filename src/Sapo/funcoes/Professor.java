package Sapo.funcoes;

/**
 * Classe para a funcao de professor
 * 
 * @author Emanuel Lima - Matricula: 120210785
 *
 */
public class Professor implements Funcao {
	
	/**
	 * Array de disciplinas ensinadas pelo professor
	 */
	private String[] disciplinas;
	
	/**
	 * Codigo identificador do professor
	 */
	private String codigoSiape;

	/**
	 * 
	 * @param siape - identificacao do professor
	 * @param disciplinas que sao ensinadas
	 */
	public Professor(String siape, String[] disciplinas) {
		this.codigoSiape = siape;
		this.disciplinas = disciplinas;
	}
	
	/**
	 * 
	 * @return o codigo Siape - identificacao do professor
	 */
	public String getSiape() {
		return codigoSiape;
	}
	
	/**
	 * 
	 * @return as disciplinas ensinadas
	 */
	public String[] getDisciplinas() {
		return disciplinas;
	}
	
	/**
	 * Altera o codigo Siape, caso precise
	 * 
	 * @param novoSiape
	 */
	public void setSiape(String novoSiape) {
		this.codigoSiape = novoSiape;
	}
	
	@Override
	public String toString() {
		return "Professor " + "- " + getSiape() + " - " + disciplinasFormatadas(); 
	}
	
	/**
	 * Metodo auxiliar, que formata as disciplinas para o toString
	 * 
	 * @return a saida segundo a formatacao pedida
	 */
	private String disciplinasFormatadas() {
		String saida = "";
		for (int i = 0; i < disciplinas.length; i++) {
			
			if (i != -1) {saida += disciplinas[i] + ", ";} 
			
			else {saida += disciplinas[i];} 
			
		}return saida;
	
	}
	public void calculaNivel() {
		
	}
}