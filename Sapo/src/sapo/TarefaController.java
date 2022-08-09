package sapo;

import java.util.HashMap;
import java.util.Map;

public class TarefaController {

    private Map<String, Tarefa> tarefas;
    private Map<String, Tarefa> pessoasTarefa;

    public TarefaController() {
        this.tarefas = new HashMap<>();
    }

    public String cadastrarTarefa(String atividadeId, String nome, String[] habilidades) {
        Tarefa tarefa = new Tarefa(nome, habilidades);
        String tarefaId = "STD-0-" + tarefa.getOrdem();
        this.tarefas.put(tarefaId, tarefa);
        return tarefaId;
    }

    public void alteraNomeTarefa(String tarefaId, String novoNome) {
        this.tarefas.get(tarefaId).renomeiaTarefa(novoNome);
    }

    public void alterarHabilidades(String tarefaId, String[] novasHabilidades) {
        this.tarefas.get(tarefaId).alteraHabilidades(novasHabilidades);
    }

    public void adicionarHorasTarefa(String idTarefa, int horas) {
        this.tarefas.get(idTarefa).acrescentaHoras(horas);
    }

    public void removerHorasTarefa(String idTarefa, int horas) {
        this.tarefas.get(idTarefa).removeHoras(horas);
    }

    public void concluirTarefa(String idTarefa) {
        this.tarefas.get(idTarefa).concliuTarefa();
    }

    public void removeTarefa(String idTarefa) {
        this.tarefas.remove(idTarefa);
    }

    public void associarPessoasTarefa(String cpf, String idTarefa) {
        //TODO
    }

    public void removerPessoaTarefa(String cpf, String idTarefa) {
        //TODO
    }
}
