package Sapo.atividade;

import Sapo.pessoa.PessoaRepository;
import Sapo.tarefa.Tarefa;
import Sapo.pessoa.Pessoa;

import java.util.*;

public class AtividadesRepository {
	private final List<Tarefa> tarefas;
	private Map<String, Atividades> atividade;
	private PessoaRepository pr;
	
	public AtividadesRepository(PessoaRepository pr) {
		this.atividade = new HashMap<>();
		this.tarefas = new ArrayList<>();
		this.pr = pr;
	}
	public void salvaTarefas(Tarefa tarefa, String atividadeId) {
		if (!(atividade.get(atividadeId).getStatusDesativada()) || !(atividade.get(atividadeId).getStatusEncerrada())) {
			atividade.get(atividadeId).adicionaTarefa(tarefa);
		}
	}
	
	public String adicionaAtividade(String nome, String descricao, String cpf) {
			Atividades atv = new Atividades(nome, descricao, cpf /*, this.atividade.size()*/);
			String codigo = atv.codigo();
			this.atividade.put(codigo, atv);
			return codigo;
	}
	
	public void desativaAtividade(String atividadeId) {
			atividade.get(atividadeId).desativar();
	}
	public void encerraAtividade(String atividadeId) {
			atividade.get(atividadeId).encerrar();
		
	}
	
	public void reabreAtividade(String atividadeId) {
		Atividades atv = this.atividade.get(atividadeId);
		if (atv.getStatusDesativada()) {
			atv.reabrir();
		}
	}
	
	public String exibirAtividade(String atividadeId) {
		Atividades atv = this.atividade.get(atividadeId);
		String saida = "";
		Pessoa responsavel = this.pr.retornaPessoa(atv.getCpf());
		saida += atividadeId +": " + atv.getNome() + "\n"; 
		if (responsavel != null) {
			saida += "Resposável" + ": " + responsavel.getNome()
		+ " - " + responsavel.getCpf() + "\n";
		}	
		 saida += "===\n" + atv.getDescricao() + "\n===\n" + "Tarefas: " + atv.quantidadeTareafasRealizadas() + "/" +
				atv.quantidadeTarefas() + "\n" + atv.tarefasPendentes();
		return saida;
	}

	public void alteraDescricao(String atividadeId, String descricao) {
		Atividades atv = this.atividade.get(atividadeId);
		atv.setDescricao(descricao);
	}
	
	public void alteraResponsavel(String atividadeId, String cpf) {
		Atividades atv = this.atividade.get(atividadeId);
		atv.setResponsavel(cpf);
	}
	
}
