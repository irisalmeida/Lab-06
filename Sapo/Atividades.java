package SAPO;

import java.util.*;


public class Atividades {

	private String nome;
	private String descricao;
	private String cpfResponsavel;
	private int quantAtv = 0;
	private List<Tarefas> tarefas;
	private List<String> vogais;
	
	
	public Atividades(String nome, String descricao, String cpf) {
		this.nome = nome;
		this.descricao = descricao;
		this.cpfResponsavel = cpf;
		this.quantAtv ++;
		this.tarefas = new ArrayList<>();
		this.vogais = new ArrayList<>(Arrays.asList("a", "e", "i", "o", "u"));
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
		return codigo.toUpperCase() + "-" + Integer.toString(quantAtv);
	}
	
	private String completaCodigo(int quantidade) {
		String retorno = "";
		for (int i = 0; i < quantidade; i++) {
			retorno += "x";
		}
		return retorno;
	}
	public void salvaTarefas(Tarefa tarefa) {
		tarefas.add(null);
	}
}
