package Sapo.funcoes;

import Sapo.pessoa.Pessoa;
import Sapo.pessoa.PessoaController;

/**
 * Controller de funcao, responsavel pelas acoes relacionadas as funcoes
 * 
 * @author Emanuel Lima - Matricula: 120210785
 *
 */
public class funcaoController {
	private PessoaController pc;
	
	/**
	 * 
	 * @param pc - Pessoa Controller
	 */
	public funcaoController(PessoaController pc) {
		this.pc = pc;
	}
	
	/**
	 * Cadastrar uma pessoa com a funcao de aluno
	 * 
	 * @param cpf da pessoa
	 * @param nome da pessoa
	 * @param habilidades da pessoa
	 * @param matricula do aluno
	 * @param periodo do aluno
	 */
	public void cadastraAluno(String cpf, String nome, String[] habilidades, String matricula, int periodo) {
		Pessoa pessoa = new Pessoa(cpf,nome,habilidades);
		Funcao funcao = new Aluno(matricula,periodo);
		pessoa.addFuncao(funcao);
	}
	
	/**
	 * Cadastra uma pessoa com a funcao de professor
	 * 
	 * @param cpf da pessoa
	 * @param nome da pessoa
	 * @param siape - identificacao do professor
	 * @param disciplinas ensinadas pelo professor
	 * @param habilidades da pessoa
	 */
	public void cadastraProfessor(String cpf, String nome, String siape, String[] disciplinas, String[] habilidades) {
		Pessoa pessoa = new Pessoa(cpf,nome,habilidades);
		Funcao funcao = new Professor(siape, disciplinas);
		pessoa.addFuncao(funcao);
	}
	
	/**
	 * Troca a funcao de uma pessoa para a funcao de professor 
	 * 
	 * @param cpf da pessoa
	 * @param siape - - identificacao do professor
	 * @param disciplinas ensinadas pelo professor
	 */
	public void definirFuncaoProfessor(String cpf, String siape, String[] disciplinas) {
		Pessoa pessoa = pc.retornarPessoa(cpf);
		Funcao professor = new Professor(siape, disciplinas); 
		pessoa.addFuncao(professor);
	}
	
	/**
	 * Troca a funcao de uma pessoa para a funcao de aluno
	 * 
	 * @param cpf da pessoa
	 * @param matr - identificacao do aluno
	 * @param periodo do aluno
	 */
	public void definirFuncaoAluno(String cpf, String matr, int periodo) { 
		Pessoa pessoa = pc.retornarPessoa(cpf);
		Funcao aluno = new Aluno(matr, periodo); 
		pessoa.addFuncao(aluno);
	}
	
	/**
	 * Remove a funcao de uma pessoa
	 * 
	 * @param cpf da pessoa
	 */
	public void removerFuncao(String cpf) {
		Pessoa pessoa = pc.retornarPessoa(cpf);
		pessoa.removerFuncao();
	}
	/**
	 * Retorna os niveis da pessoa, porém não consegui implementar
	 * 
	 * @param cpf da pessoa
	 * @return deveria retornar o nivel da pessoa
	 */
	public int pegarNivel(String cpf) {
		Pessoa pessoa = pc.retornarPessoa(cpf);
		return 1;
	}
	
	
	/*public String[] listarPessoas() {
		
	}*/
}
