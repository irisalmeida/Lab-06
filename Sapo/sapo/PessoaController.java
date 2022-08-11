
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
	public void cadastrarPessoa(String cpf, String nome, String[] habilidades) {
		this.pr.adicionarPessoa(new Pessoa(cpf, nome, habilidades));
	}

	public void alterarNomePessoa(String cpf, String novoNome) {
		this.pr.retornaPessoa(cpf).setNome(novoNome);
	}

	public void alterarHabilidadesPessoa(String cpf, String[] novasHabilidades) {
		this.pr.retornaPessoa(cpf).setHabilidades(novasHabilidades);

	}

	// Adicionar itens no arraylist, lembre do método adicionarComentario que está
	// lá na Classe Pessoa
	public void adicionarComentarioPessoa(String cpf, String comentario, String autorCpf) {
		this.pr.retornaPessoa(cpf).adicionarComentario(comentario, autorCpf);
	}

	/**
	 * Método de listar comentarios, tem relação com o método de listarComentarios()
	 * lá em pessoa.
	 * 
	 * @param os atributos de pesssoa.
	 */
	public void listarComentariosPessoa(String cpf) {
		this.pr.retornaPessoa(cpf).listarComentarios();
	}

	public void removerPessoa(String cpf) {
		this.pr.removePessoa(cpf);
	}

	/**
	 * Método que retorna a representação textual de pessoa, tendo como parâmetro
	 * seu CPF
	 */
	public String exibirPessoa(String cpf) {
		return this.pr.retornaPessoa(cpf).toString();

	}

}