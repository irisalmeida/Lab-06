package Sapo.funcoes;

/**
 * Classe aluno - Uma das funcoes que uma pessoa pode atribuir
 * 
 * @author Emanuel Lima - Matricula: 120210785
 *
 */
public class Aluno implements Funcao {

	
	private int periodoAluno;
	private String matriculaAluno;
	
	/**
	 * Construtor de Aluno
	 * 
	 * @param matricula - identificador do aluno
	 * @param periodo
	 */
	public Aluno(String matricula, int periodo) {
		this.matriculaAluno = matricula;
		this.periodoAluno = periodo;
	}
	
	/**
	 * 
	 * @return periodo do Aluno
	 */
	public int getPeriodoAluno() {
		return periodoAluno;
	}
	
	/**
	 * Caso precise, mudar o periodo do aluno
	 * @param periodoAluno
	 */
	public void setPeriodoAluno(int periodoAluno) {
		this.periodoAluno = periodoAluno;
	}
	
	/**
	 * 
	 * @return a matricula do aluno
	 */
	public String getMatriculaAluno() {
		return matriculaAluno;
	}
	
	/**
	 * Altera a matricula do aluno, caso for preciso
	 * 
	 * @param matriculaAluno - identificador do aluno
	 */
	public void setMatriculaAluno(String matriculaAluno) {
		this.matriculaAluno = matriculaAluno;
	}
	
	@Override
	public String toString() {
		return "Aluno " + "- " + getMatriculaAluno() + " - " + getPeriodoAluno();
	}
	/*public void calculaNivel() {
		
	}*/

}
