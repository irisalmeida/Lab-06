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
	private boolean desativada;
	private boolean ativa;
	private boolean encerrada;
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
		this.desativada = false; //abandono ou invalidez
		this.encerrada = false; // concluida
		this.ativa = true;
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
	public void adicionaTarefa(Tarefa tarefa) {
		tarefas.add(tarefa);
		this.quantidadeTarefas ++;
	}
	public void desativar() {
		if (this.desativada) {
			throw new IllegalStateException("A atividade já está desativada");
		} else if (this.encerrada) {
			throw new IllegalStateException("Esta atividade já foi concluída");
		}
		if (quantidadeTareafasRealizadas() == this.quantidadeTarefas) {
			this.desativada = true;
			this.encerrada = false;
			this.ativa = false;
		}
		
	}
	public void encerrar() {
		if (!this.ativa) {
			throw new IllegalStateException("A atividade já está encerrada");
		}
		if (quantidadeTareafasRealizadas() == this.quantidadeTarefas) {
			this.ativa = false;
			this.encerrada = true;
			this.desativada = false;
		}
	}

	public boolean getStatusDesativada() {
		return this.desativada;
	}
	public boolean getStatusEncerrada() {
		return this.encerrada;
	}
	
	public void reabrir() {
		if (this.ativa) {
			throw new IllegalStateException("A atividade está ativa!");
		}
		this.desativada= false;
		this.encerrada = false;
		this.ativa = true;
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
