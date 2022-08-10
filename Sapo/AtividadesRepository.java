package SAPO;

import java.util.*;

public class AtividadesRepository {
	private Map<String, Atividades> atividade;
	private List<Tarefas> tarefas;
	
	public AtividadesRepository() {
		this.atividade = new HashMap<>();
		this.tarefas = new ArrayList<>();
	}
	public void salvaTarefas(Tarefa tarefa) {
		tarefas.add(tarefa);
	}
}
