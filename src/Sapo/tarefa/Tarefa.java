package Sapo.tarefa;



import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Tarefa {
    private String nome;
    private int horasTotais;
    private String[] habilidadesNecessarias;
    private boolean tarefaConcluida;

    private String atividadeId;

    private String id;

    private List<String> responsaveis;

    private static int ordem = 0;

    public Tarefa( String atividadeId, String nome, String[] habilidadesNecessarias) {
        this.nome = nome;
        this.horasTotais = 0;
        this.atividadeId = atividadeId;
        this.habilidadesNecessarias = habilidadesNecessarias;
        this.tarefaConcluida = false;
        this.id = atividadeId + "-" + ordem;
        ArrayList responsaveis = new ArrayList();
        ordem ++;
    }

    public void acrescentaHoras(int Horas) {
        if (this.tarefaConcluida) {
            throw new IllegalStateException("Não é possível alterar a contagem de horas de tarefas concluídas");
        }
        this.horasTotais += Horas;
    }

    public void removeHoras(int Horas) {
        if (this.tarefaConcluida) {
            throw new IllegalStateException("Não é possível alterar a contagem de horas de tarefas concluídas");
        }
        this.horasTotais -= Horas;
    }

    public void concluirTarefa() {
        this.tarefaConcluida = true;
    }

    public boolean statusTarefa() {
        return this.tarefaConcluida;
    }

    public String getNomeTarefa() {
        return this.nome;
    }

    public void renomeiaTarefa(String novoNome) {
        this.nome = novoNome;
    }

    public void alteraHabilidades(String[] habilidades) {
        this.habilidadesNecessarias = habilidades;
    }
    public String getId() {
        return this.id;
    }

    public String getAtividadeId() {
        return this.atividadeId;
    }

    public void adicionaPessoaResponsavel(String cpf) {
        this.responsaveis.add(cpf);
    }

    public void removePessoaResponsavel (String cpf) {
        this.responsaveis.removeIf( name -> name.equals(cpf));
    }



    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Tarefa tarefa = (Tarefa) o;
        return Objects.equals(nome, tarefa.nome);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nome);
    }
}
