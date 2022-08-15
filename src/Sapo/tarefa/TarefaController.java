package Sapo.tarefa;


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


}
