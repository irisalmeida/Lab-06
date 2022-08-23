package Sapo.tarefa;


import java.util.*;

public class TarefaRepository {

    private Map<String, Tarefa> tarefas;




    public TarefaRepository() {
        this.tarefas = new HashMap<>();
    }
    public String adicionar(Tarefa tarefa) {
        String tarefaId = tarefa.getId();
        tarefas.put(tarefaId, tarefa);
        return tarefaId;
    }



    public void renomearTarefa(String tarefaId, String novoNome) {
        this.tarefas.get(tarefaId).renomeiaTarefa(novoNome);
    }

    public void alterarHabilidade(String tarefaId, String[] novasHabilidades) {
        this.tarefas.get(tarefaId).alteraHabilidades(novasHabilidades);
    }

    public void acrescentaHoras(String tarefaId, int horas) {
        this.tarefas.get(tarefaId).acrescentaHoras(horas);
    }

    public void removeHoras(String tarefaId, int horas) {
        this.tarefas.get(tarefaId).removeHoras(horas);
    }

    public void concluirTarefa(String tarefaId) {
        this.tarefas.get(tarefaId).concluirTarefa();
    }

    public void removeTarefa(String tarefaId) {
        this.tarefas.remove(tarefaId);
    }

    public void associarPessoaTarefa(String cpf, String tarefaId) {
        this.tarefas.get(tarefaId).adicionaPessoaResponsavel(cpf);
    }

    public void removerPessoaTarefa(String cpf) {
        this.tarefas.get(cpf).removePessoaResponsavel(cpf);
    }

    public String retornaAtividade(String idTarefa) {
        return this.tarefas.get(idTarefa).getAtividadeId();
    }


    public String retornaCodigoAtividadeAssociada(String tarefaId) {
        return this.tarefas.get(tarefaId).getAtividadeId();
    }

    public String representacaoTarefa(String idTarefa) {
        return this.tarefas.get(idTarefa).getNomeTarefa() + " - " + this.tarefas.get(idTarefa).getId();
    }
   
     //Tarefa Gerencial:

    public Tarefa retornaTarefa(String idtarefa) {
        return this.tarefas.get(idtarefa);
    }

    public String adicionarTarefaGerencial(Tarefa tarefa) {
        String tarefaId = tarefa.getId();
        tarefas.put(tarefaId, tarefa);
        return tarefaId;
    }
}

