package Sapo;

import Sapo.atividade.Atividades;
import Sapo.atividade.AtividadesController;
import Sapo.atividade.AtividadesRepository;
import Sapo.pessoa.Pessoa;
import Sapo.pessoa.PessoaController;
import Sapo.pessoa.PessoaRepository;
import Sapo.tarefa.Tarefa;
import Sapo.tarefa.TarefaController;
import Sapo.tarefa.TarefaRepository;

import java.util.List;

public class Facade {

    private PessoaController pc;

    private AtividadesController ac;

    private TarefaController tc;

    private PessoaRepository pr;

    private AtividadesRepository ar;

    private TarefaRepository tr;

    public Facade() {

        this.pc = new PessoaController(new PessoaRepository());

        this.ac = new AtividadesController(new AtividadesRepository());

        this.tc = new TarefaController(new TarefaRepository());

        }

        public void cadastrarPessoa(String cpf, String nome, String[] habilidades) {
            this.pc.cadastrarPessoa(cpf, nome, habilidades);
        }

        public void alterarHabilidadesPessoa(String cpf, String[] novasHabilidades) {
        this.pc.alterarHabilidadesPessoa(cpf, novasHabilidades);
        }

        public void adicionarComentarioPessoa(String cpf, String comentario, String autorCpf) {
            this.pc.adicionarComentarioPessoa(cpf, comentario, autorCpf);
        }

        public void listarComentariosPessoa(String cpf) {
            this.pc.listarComentariosPessoa(cpf);
        }

        public void removerPessoa(String cpf) {
            this.pc.removerPessoa(cpf);
        }

        public String exibirPessoa(String cpf) {
            return this.pc.exibirPessoa(cpf);
        }

        public void cadastraAtividade(String nome, String descricao, String cpf) {
            this.ac.cadastraAtividade(nome, descricao, cpf);
        }

        public void encerrarAtividade(String atividadeId) {
            this.ac.encerrarAtividade(atividadeId);
        }

        public void desativarAtividade(String atividadeId) {
            this.ac.desativarAtividade(atividadeId);
        }

        public void reabrirAtividade(String atividadeId) {
            this.ac.reabrirAtividade(atividadeId);
        }

        public String exibirAtividade(String atividadeId) {
            return ac.exibirAtividade(atividadeId);
        }

        public void alterarDescricaoAtividade(String atividadeId, String descricao) {
            this.ac.alterarDescricaoAtividade(atividadeId, descricao);
        }

        public void alterarResponsavelAtividade(String atividadeId, String cpf) {
            this.ac.alterarResponsavelAtividade(atividadeId, cpf);
        }


        public String cadastrarTarefa( String atividadeId, String nome, String[] habilidades) {
            return this.tc.cadastrarTarefa(atividadeId, nome, habilidades);
        }

        public void alteraNomeTarefa(String tarefaId, String novoNome) {
        this.tc.alteraNomeTarefa(tarefaId, novoNome);
        }

        public void alterarHabilidades(String tarefaId, String[] novasHabilidades) {
            this.tc.alterarHabilidades(tarefaId, novasHabilidades);
        }

        public void adicionarHorasTarefa(String idTarefa, int horas) {
        this.tc.adicionarHorasTarefa(idTarefa, horas);
        }

        public void removerHorasTarefa(String idTarefa, int horas) {
            this.tc.removerHorasTarefa(idTarefa, horas);
        }

        public String retornaAtividadeAssociada(String idTarefa){
            return this.tc.retornaAtividadeAssociada(idTarefa);
        }

        public void associarPessoaTarefa(String cpf, String tarefaId ) {
            this.tc.associarPessoaTarefa(cpf, tarefaId);
        }
        public void removePessoaTarefa(String cpf ) {
            this.tc.removePessoaTarefa(cpf);
        }

        public String retornaCodigoAtividadeAssociada(String tarefaId) {
            return this.tc.retornaCodigoAtividadeAssociada(tarefaId);
        }

        public String representacaoTarefa(String idTarefa) {

            Tarefa tarefa = this.tc.retornaTarefa(idTarefa);
            List<String> responsaveisTarefa = this.tc.retornaResponsaveis(idTarefa);
            Atividades atividade = this.ac.retornaAtividade(tarefa.getAtividadeId());

            String representacao =  tarefa.getNomeTarefa() +" - " + tarefa.getId() + "\n" + "- " + atividade.getNome() + "\n" + String.join(",", tarefa.getHabilidadesNecessarias())
                    + "\n" + "(" + tarefa.getHorasTotais() + " hora(s) executada(s)" + "\n" + "===" + "\n" + "Equipe:" + "\n"
                    ;

            for (String cpf: responsaveisTarefa) {
                representacao += this.pc.retornaPessoa(cpf).getNome() +" – " + cpf + "\n";
            }

            return representacao;



    }

}


