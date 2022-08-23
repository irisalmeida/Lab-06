package Sapo.tarefa;

import java.util.List;

public class TarefaController {

    private TarefaRepository tr;


    public TarefaController(TarefaRepository tr) {
        this.tr = tr;
    }


    public String cadastrarTarefa(String atividadeId, String nome, String[] habilidades) {
        return this.tr.adicionar(new Tarefa(atividadeId, nome, habilidades));
    }

    public void alteraNomeTarefa(String tarefaId, String novoNome) {
        this.tr.renomearTarefa(tarefaId, novoNome);
    }

    public void alterarHabilidades(String tarefaId, String[] novasHabilidades) {
        this.tr.alterarHabilidade(tarefaId, novasHabilidades);
    }

    public void adicionarHorasTarefa(String idTarefa, int horas) {
        this.tr.acrescentaHoras(idTarefa, horas);
    }

    public void removerHorasTarefa(String idTarefa, int horas) {
        this.tr.removeHoras(idTarefa, horas);
    }

    public String retornaAtividadeAssociada(String idTarefa) {
        return this.tr.retornaAtividade(idTarefa);
    }

    public void concluirTarefa(String idTarefa) {
        this.tr.concluirTarefa(idTarefa);
    }

    public void removeTarefa(String idTarefa) {
        this.tr.removeTarefa(idTarefa);
    }

    public void associarPessoaTarefa(String cpf, String tarefaId) {
        this.tr.associarPessoaTarefa(cpf, tarefaId);
    }

    public void removePessoaTarefa(String cpf) {
        this.tr.removerPessoaTarefa(cpf);
    }

    public String retornaCodigoAtividadeAssociada(String tarefaId) {
        return tr.retornaCodigoAtividadeAssociada(tarefaId);
    }

    public String representacaoTarefa(String idTarefa) {
        return tr.representacaoTarefa(idTarefa);

    }
    
        //Inicio de Tarefa Gerencial

    //chamar a atividade que tem o id e adicionar tarefa lá dentro
    //atividade id será o id da atividade que vai conter a tarefa gerencial

    public String cadastrarTarefaGerencial(String atividadeId, String nome, String []habilidades, String []idTarefas) {
        return this.tr.adicionar(new TarefaGerencial(atividadeId, nome, habilidades, idTarefas));
    }

    public void adicionarNaTarefaGerencial(String idTarefaGerencial, String idTarefa){
        // adicionar checagem para:
        // - permitir apenas adição de tarefas em andamento;  X
        // - não permitir adição de tarefas gerenciais que gerem um ciclo.
        TarefaGerencial tarefaGerencial = (TarefaGerencial) this.tr.retornaTarefa(idTarefaGerencial);
        Tarefa tarefa = tr.retornaTarefa(idTarefa);

        if (!tarefa.isConcluida()) {
            throw new IllegalStateException("Não é possível adicionar tarefas concluídas a uma tarefa gerencial");
        }
        if (contemCiclo(tarefaGerencial, tarefa)) {
            throw new IllegalStateException("A adição dessa tarefa na tarefa gerencial acarretaria em um ciclo");
        }

        tarefaGerencial.adicionaTarefa(idTarefa);// Lembrar de terminar o método de adicionatarefa e fazer a relação
    }

    private boolean contemCiclo(TarefaGerencial tarefaGerencial, Tarefa tarefa) {
        if (!(tarefa instanceof TarefaGerencial)) { return false; }

        List<String> tarefasDaTarefa = ((TarefaGerencial) tarefa).getTarefas();
        if (tarefasDaTarefa.contains(tarefaGerencial.getId())) { return true; }

        for (String idSubTarefa : tarefasDaTarefa) {
            Tarefa subtarefa = tr.retornaTarefa(idSubTarefa);
            if (subtarefa instanceof TarefaGerencial) {
                return contemCiclo(tarefaGerencial, subtarefa);
            }
        }

        return false;
    }

    public void removerDaTarefaGerencial(String idTarefaGerencial, String idTarefa) {
        TarefaGerencial tarefaGerencial = (TarefaGerencial) this.tr.retornaTarefa(idTarefaGerencial);
        tarefaGerencial.removeTarefa(idTarefa); // Lembrar de terminar o método de removetarefa e fazer a relação
    }

    public int contarTodasTarefasNaTarefaGerencial(String idTarefaGerencial) {
        TarefaGerencial tarefaGerencial = (TarefaGerencial) this.tr.retornaTarefa(idTarefaGerencial);
        List<String> todasAsTarefas = tarefaGerencial.getTarefas();
        int contadorTarefas = 0;

        for (String idTarefa: todasAsTarefas) {
            Tarefa tarefa = tr.retornaTarefa(idTarefa);
            if (tarefa instanceof TarefaGerencial) {
                contadorTarefas += this.contarTodasTarefasNaTarefaGerencial(idTarefa);
            } else {
                contadorTarefas++;
            }
        }
        return contadorTarefas;
    }
}
