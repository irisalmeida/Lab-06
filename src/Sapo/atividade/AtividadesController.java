package Sapo.atividade;

public class AtividadesController {
	private AtividadesRepository ar;
	private String nomeAtv;
	private String descricaoAtv;
	private String cpfResponsavel;
	private Atividades atividade;
	//private Map<>
	
	public AtividadesController(AtividadesRepository ar) {
		this.ar = ar;
	}
	public void cadastraAtividade(String nome, String descricao, String cpf) {
		this.ar.adicionaAtividade(nome, descricao, cpf);
		
	}
	
	public void encerrarAtividade(String atividadeId) {
		this.ar.encerraAtividade(atividadeId);
	}
	
	public void desativarAtividade(String atividadeId) {
		this.ar.encerraAtividade(atividadeId);
	}
	
	public void reabrirAtividade(String atividadeId) {
		this.ar.reabreAtividade(atividadeId);
	}
	
	public String exibirAtividade(String atividadeId) {
		return ar.exibirAtividade(atividadeId);
	}
	public void alterarDescricaoAtividade(String atividadeId, String descricao) {
		this.ar.alteraDescricao(atividadeId, descricao);
	}
	public void alterarResponsavelAtividade(String atividadeId, String cpf) {
		this.ar.alteraResponsavel(atividadeId, cpf);
	}
}
