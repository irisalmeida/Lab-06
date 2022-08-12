package Sapo.tarefa;

import Sapo.pessoa.Pessoa;

import java.util.*;

public class TarefaRepository {

    private Map<String, Tarefa> tarefas;
    private Map<String, String> responsavelTarefa;

    private Map<Tarefa, List<Pessoa>> pessoasTarefa; //seria isso mesmo?

    public TarefaRepository() {
        this.tarefas = new HashMap<>();
    }
    public String adicionar(Tarefa tarefa) {
        String tarefaId = tarefa.getId();
        tarefas.put(tarefaId, tarefa);
        return tarefaId;
    }

    public void renomeiaTarefa(String tarefaId, String novoNome) {
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
        this.tarefas.get(tarefaId).concliuTarefa();
    }

    public void removeTarefa(String tarefaId) {
        this.tarefas.remove(tarefaId);
    }

    public void associarPessoaResponsavelTarefa(String cpf, String idTarefa) {
        responsavelTarefa.put(cpf, idTarefa);
    }

    public void removerPessoaResponsavelTarefa(String cpf) {
        responsavelTarefa.remove(cpf);
    }

    public String retornaAtividade(String idTarefa) {
        return this.tarefas.get(idTarefa).getAtividadeId();
    }


    /* big mistake down below
    //public void associarPessoaTarefa(String cpf, String tarefaId) {
        this.pessoasTarefa.put();
    //}
    //public void removePessoaTarefa(String cpf) {
        this.pessoasTarefa.remove(cpf);
    }
    */


}

