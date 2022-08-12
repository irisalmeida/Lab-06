package Sapo.tarefa;


import java.util.Objects;

public class Tarefa {
    private String nome;
    private int horasTotais;
    private String[] habilidadesNecessarias;
    private boolean tarefaConcluida;

    private String atividadeId;

    private String id;

    private static int ordem = 0;

    public Tarefa(String nome, String[] habilidadesNecessarias, String atividadeId) {
        this.nome = nome;
        this.horasTotais = 0;
        this.atividadeId = atividadeId;
        this.habilidadesNecessarias = habilidadesNecessarias;
        this.tarefaConcluida = false;
        this.id = "STD-0-" + this.ordem;
        ordem ++;
    }

    public void acrescentaHoras(int Horas) {
        this.horasTotais += Horas;
    }

    public void removeHoras(int Horas) {
        this.horasTotais -= Horas;
    }

    public void concliuTarefa() {
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
