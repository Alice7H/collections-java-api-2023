package main.java.set.exercicios.pesquisa;

import java.util.Objects;

public class Tarefa {
  private String descricao;
  private boolean tarefaConcluida;

  public Tarefa(String descricao) {
    this.descricao = descricao;
    this.tarefaConcluida = false;
  }

  public String getDescricao() {
    return descricao;
  }

  public boolean isTarefaConcluida() {
    return tarefaConcluida;
  }

  public void setTarefaConcluida(boolean tarefaConcluida) {
    this.tarefaConcluida = tarefaConcluida;
  }

  @Override
  public String toString() {
    return "\n Descricao: " + descricao + ", tarefa concluida: " + tarefaConcluida;
  }

  @Override
  public int hashCode() {
    return Objects.hash(getDescricao());
  }

  @Override
  public boolean equals(Object obj) {
    if (this == obj)
      return true;
    if (!(obj instanceof Tarefa tarefa))
      return false;
    return Objects.equals(getDescricao(), tarefa.getDescricao());
  }

}
