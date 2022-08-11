package SAPO;

import java.util.*;


public class Atividades {
	
	private String nome;
	private String descricao;
	private String cpfResponsavel;
	private int tamanhoTarefas;
	private List<Tarefas> tarefas;
	private List<String> vogais;
	private boolean desativado;
	private boolean encerrada;
	private boolean pendente;
	private boolean reaberta;
	
	
	
	public Atividades(String nome, String descricao, String cpf, int quantidade) {
		this.nome = nome;
		this.descricao = descricao;
		this.cpfResponsavel = cpf;
		this.tamanhoTarefas = quantidade;
		this.tarefas = new ArrayList<>();
		this.vogais = new ArrayList<>(Arrays.asList("a", "e", "i", "o", "u"));
		this.desativado = false;
		this.encerrada = false;
		this.pendente = false;
		this.reaberta = false;
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
			this.encerrada = true;
			this.reaberta = false;
		}
	}
	
	public boolean reaberta() {
		this.reaberta = true;
		this.encerrada = false;
		this.desativado = false;
	}
	public int quantidadeTarefas() {
		return this.tarefas.size();
	}
	public int quantidadeTareafasRealizadas() {
		int realizadas = 0;
		for (Tarefa tarefa : tarefas) {
			if (tarefa.concluiuTarefa()) {
				realizadas ++;
			}
		} return realizadas;
	}
	public String tarefasPendentes() {
		String pendente = "";
		int quantTarefas = 0;
		for (int i = tarefas.size() -1; i >= 0; i--) {
			Tarefa tarefa = tarefas.get(i);
			if (!(tarefa.concluiuTarefa())) {
				pendente += "- " + tarefa.getNome() + " - " + codigo() + "-" + (i+1);
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
