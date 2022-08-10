package SAPO;

public class AtividadesController {
	private AtividadesRepository ar;
	private String nomeAtv;
	private String descricaoAtv;
	private String cpfResponsavel;
	
	public AtividadesController() {
		this.ar = new AtividadesRepository();
		
		
	}
	public void cadastraAtividade(String nome, String descricao, String cpf) {
		this.nomeAtv = nome;
		this.descricaoAtv = descricao;
		this.cpfResponsavel = cpf;
		
	}
	public void desativarAtividade(String atividadeId) {
		
	}
	public void reabrirAtividade(String atividadeId) {
		
	}
	public String exibirAtividade(String atividadeId) {
		
	}
	public void alterarDescricaoAtividade(String atividadeId, String descricao) {
		
	}
	public void alterarResponsavelAtividade(String atividadeId, String cpf) {
		
	}
}
