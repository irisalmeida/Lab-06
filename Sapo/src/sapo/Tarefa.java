package sapo;

import java.util.Objects;

public class Tarefa {
    private String nome;
    private int horasTotais;
    private String[] habilidadesNecessarias;
    boolean tarefaConcluida;

    private static int ordem = 0;

    public Tarefa(String nome, String[] habilidadesNecessarias) {
        this.nome = nome;
        this.horasTotais = 0;
        this.habilidadesNecessarias = habilidadesNecessarias;
        this.tarefaConcluida = false;
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

    public void renomeiaTarefa(String novoNome) {
        this.nome = novoNome;
    }

    public void alteraHabilidades(String[] habilidades) {
        this.habilidadesNecessarias = habilidades;
    }
    public int getOrdem() {
        return this.ordem;
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
