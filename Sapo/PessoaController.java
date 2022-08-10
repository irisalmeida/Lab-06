package sapo;

public class PessoaController {
	
	private PessoaRepository pr;

	/**
	 * Construtor padrão de PessoaController. Manter um controller por sistema.
	 * 
	 * @param ds PessoaRepository a ser utilizado pelo controller.
	 */
    public PessoaController() {
        this.pr = new PessoaRepository();
    }

	/**
	 * Método de cadastrar uma pessoa.
	 * 
	 * @param os atributos de pesssoa.
	 */
    public void cadastrarPessoa (String cpf, String nome, String[] habilidades) {
        this.pr.adicionarPessoa(new Pessoa(cpf, nome, habilidades));
    }


	
}
