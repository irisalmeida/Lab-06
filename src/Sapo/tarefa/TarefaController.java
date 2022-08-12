package Sapo.tarefa;


public class TarefaController {

    private TarefaRepository tr;

    public TarefaController() {
         this.tr = new TarefaRepository();
    }

    public String cadastrarTarefa(String nome, String[] habilidades, String atividadeId) {
        return this.tr.adicionar(new Tarefa(nome, habilidades, atividadeId));
    }

    public void alteraNomeTarefa(String tarefaId, String novoNome) {
        this.tr.renomeiaTarefa(tarefaId, novoNome);
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

    public String retornaAtividade(String idTarefa){
        return this.tr.retornaAtividade(idTarefa);
    }

    public void concluirTarefa(String idTarefa) {
        this.tr.concluirTarefa(idTarefa);
    }

    public void removeTarefa(String idTarefa) {
        this.tr.removeTarefa(idTarefa);
    }

    public void associarPessoaTarefa(String cpf, String tarefaId ) {
        this.tr.associarPessoaTarefa(cpf, tarefaId);
    }

    public void removePessoaTarefa(String cpf ) {
        this.tr.removePessoaTarefa(cpf);
    }

    public void associarPessoaresponsavelTarefa(String cpf, String idTarefa) {
        this.tr.associarPessoaResponsavelTarefa(cpf, idTarefa);
    }

    public void removerPessoaResponsavelTarefa(String cpf) {
        this.tr.removerPessoaResponsavelTarefa(cpf);
    }
}
