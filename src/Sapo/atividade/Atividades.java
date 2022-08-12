package Sapo.atividade;

import java.util.*;

import Sapo.tarefa.Tarefa;


public class Atividades {
	
	private String nome;
	private String descricao;
	private String cpfResponsavel;
	private int tamanhoTarefas;
	private List<Tarefa> tarefas;
	private List<String> vogais;
	private boolean desativado;
	private boolean concluida;
	private boolean pendente;
	private boolean ativa;

	public int quantidadeTarefas;

	private  static int contadorAtividades;
	
	
	
	public Atividades(String nome, String descricao, String cpf/*, int quantidade*/) {
		this.nome = nome;
		this.descricao = descricao;
		this.cpfResponsavel = cpf;
		this.quantidadeTarefas = 0;
		this.tarefas = new ArrayList<>();
		this.vogais = new ArrayList<>(Arrays.asList("a", "e", "i", "o", "u"));
		this.contadorAtividades = 0;
		this.desativado = false;
		this.concluida = false;
		this.pendente = false;
		this.ativa = false;
		contadorAtividades++;
	}
	
	public String getDescricao() {
		return descricao;
	}
	
	public String getNome() {
		return nome;
	}
	
	public String getCpf() {
		return cpfResponsavel;
	}
	
	
	public String codigo() {
		String codigo = "";
		String[] nomes = nome.split(" ");
		for (String letra : nomes) {
			if (!(vogais.contains(letra))) {
				codigo += letra;
				if (codigo.length() >= 3) {
					break;
			}	
		  }
		} codigo += completaCodigo(3 - codigo.length());
		return codigo.toUpperCase() + "-" + Integer.toString(this.tamanhoTarefas);
	}
	
	private String completaCodigo(int quantidade) {
		String retorno = "";
		for (int i = 0; i < quantidade; i++) {
			retorno += "x";
		}
		return retorno;
	}
	public void salvaTarefas(Tarefa tarefa) {
		tarefas.add(tarefa);
	}
	public boolean desativada() {
		if (quantidadeTareafasRealizadas() == tarefas.size()) {
			this.desativado = true;
		}
		
	}
	public boolean encerrada() {
		if (quantidadeTareafasRealizadas() == tarefas.size()) {
			this.concluida = true;
			this.reaberta = false;
		}
	}
	
	public void reabrir() {
		if () {

		}
		this.ativa= true;
		this.concluida = false;
		this.desativado = false;
	}
	public int quantidadeTarefas() {
		return this.tarefas.size();
	}
	public int quantidadeTareafasRealizadas() {
		int realizadas = 0;
		for (Tarefa tarefa : tarefas) {
			if (tarefa.statusTarefa()) {
				realizadas ++;
			}
		} return realizadas;
	}
	public String tarefasPendentes() {
		String pendente = "";
		int quantTarefas = 0;
		for (int i = tarefas.size() -1; i >= 0; i--) {
			Tarefa tarefa = tarefas.get(i);
			if (!(tarefa.statusTarefa())) {
				pendente += "- " + tarefa.getNomeTarefa() + " - " + codigo() + "-" + (i+1);
				quantTarefas ++;
			} if (quantTarefas == 3) {break;}
		} return pendente;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	
	public void setResponsavel(String cpf) {
		this.cpfResponsavel = cpf;
	}
}
