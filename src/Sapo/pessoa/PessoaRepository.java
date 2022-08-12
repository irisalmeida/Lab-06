package Sapo.pessoa;
//import sapo.pessoa.Pessoa;

import java.util.HashMap;
import java.util.Map;

/**
 * Repositório de pessoas. O repositório pode ter oprerações simples de busca
 * 
 */

public class PessoaRepository {

	private Map<String, Pessoa> pessoas;

	/**
	 * Construção padrão do repositório de pessoas.
	 */
	public PessoaRepository() {
		this.pessoas = new HashMap<String, Pessoa>();
	}

	/**
	 * O método adicionarPessoa será usado por o método de cadastraPessoa no
	 * controller.
	 */
	public void adicionarPessoa(Pessoa pessoa) {
		pessoas.put(pessoa.getCpf(), pessoa);
	}

	/**
	 * O método removePessoa "chama" o método de removerPessoa no controller.
	 */
	// ATENCAO
	public void removePessoa(String cpf) {
		pessoas.remove(cpf);
	}

	public Pessoa retornaPessoa(String cpf) {
		return this.pessoas.get(cpf);
	}

}