package sapo;
//import sapo.pessoa.Pessoa;


import java.util.HashMap;
import java.util.Map;


/**
 * Repositório de pessoas. O repositório pode ter oprerações simples de busca
 * 
 */

public class PessoaRepository {

	private Map <String, Pessoa> pessoas;

	
	
	/**
	 * Construção padrão do repositório de pessoas.
	 */
	public PessoaRepository() {
		this.pessoas = new HashMap<String, Pessoa>();
	}
	

	/**
	 * O método adicionarPessoa "chama" o método de caddastraPessoa no controller.
	 */
    public void adicionarPessoa(Pessoa pessoa) {
        pessoas.put(pessoa.getCpf(), pessoa);
    }

    public Pessoa retornaPessoa(String cpf) {
        return this.pessoas.get(cpf);
    }

	
	
	
	
	
	
	
	
	
	
}
