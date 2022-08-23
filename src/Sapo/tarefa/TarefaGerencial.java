package Sapo.tarefa;

import java.util.ArrayList;
import java.util.List;


import Sapo.tarefa.Tarefa;

public class TarefaGerencial extends Tarefa {

    // Tarefa supertipo e tarefa gerencial como subtipo

    // array de id de tarefa que irá armazenar

    // Coleção para armazenar Tarefa e Tarefa Gerencial

    private List<String> tarefas;

    public TarefaGerencial(String atividadeId, String nome, String[] habilidadesNecessarias, String[] tarefas) {
        super(atividadeId, nome, habilidadesNecessarias);
        this.tarefas = converteArray(tarefas);
    }

    private ArrayList<String> converteArray(String[] tarefas) {
        ArrayList<String> retornaValores = new ArrayList<String>();
        for (String tarefa : tarefas) {
            retornaValores.add(tarefa);
        }
        return retornaValores;
    }

    // método para add tarefas na lista
    public void adicionaTarefa(String idTarefa) {
        this.tarefas.add(idTarefa);
    }

    // método para retirar tarefas na lista
    public void removeTarefa(String idTarefa) {
        tarefas.remove(idTarefa);
    }

    public List<String> getTarefas() {
        return this.tarefas;
    }
}