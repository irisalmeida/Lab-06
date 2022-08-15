package Sapo.atividade;

public class AtividadesController {
	private AtividadesRepository ar;
	/*private String nomeAtv;
	private String descricaoAtv;
	private String cpfResponsavel;
	private Atividades atividade;*/
	
	
	public AtividadesController(AtividadesRepository ar) {
		this.ar = ar;
	}
	/**
	 * Cadastra uma atividade
	 * 
	 * @param nome
	 * @param descricao
	 * @param cpf
	 */
	public void cadastraAtividade(String nome, String descricao, String cpf) {
		this.ar.adicionaAtividade(nome, descricao, cpf);
		
	}
	/**
	 * Encerra uma atividade
	 * 
	 * @param atividadeId
	 */
	public void encerrarAtividade(String atividadeId) {
		this.ar.encerraAtividade(atividadeId);
	}
	/**
	 * Desativa uma atividade
	 * 
	 * @param atividadeId
	 */
	public void desativarAtividade(String atividadeId) {
		this.ar.encerraAtividade(atividadeId);
	}
	/**
	 * Reabre uma atividade
	 * 
	 * @param atividadeId
	 */
	public void reabrirAtividade(String atividadeId) {
		this.ar.reabreAtividade(atividadeId);
	}
	/**
	 * Exibe uma atividade
	 * 
	 * @param atividadeId
	 * @return
	 */
	public String exibirAtividade(String atividadeId) {
		return ar.exibirAtividade(atividadeId);
	}
	/**
	 * Altera a descricao de uma atividade
	 * 
	 * @param atividadeId
	 * @param descricao
	 */
	public void alterarDescricaoAtividade(String atividadeId, String descricao) {
		this.ar.alteraDescricao(atividadeId, descricao);
	}
	/**
	 * Altera o responsavel da Atividade - por seu cpf
	 * 
	 * @param atividadeId
	 * @param cpf
	 */
	public void alterarResponsavelAtividade(String atividadeId, String cpf) {
		this.ar.alteraResponsavel(atividadeId, cpf);
	}
}
