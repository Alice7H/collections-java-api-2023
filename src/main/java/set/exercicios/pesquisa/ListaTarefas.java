package main.java.set.exercicios.pesquisa;

import java.util.HashSet;
import java.util.Set;

public class ListaTarefas {

  private Set<Tarefa> tarefaSetList;

  public ListaTarefas() {
    this.tarefaSetList = new HashSet<>();
  }

  public void adicionarTarefa(String descricao) {
    tarefaSetList.add(new Tarefa(descricao));
  }

  public void removerTarefa(String descricao) {
    Tarefa tarefaParaRemover = null;
    if (!tarefaSetList.isEmpty()) {
      for (Tarefa tarefa : tarefaSetList) {
        if (tarefa.getDescricao().equalsIgnoreCase(descricao)) {
          tarefaParaRemover = tarefa;
          break;
        }
      }
      tarefaSetList.remove(tarefaParaRemover);
    } else {
      System.out.println("A lista de tarefas está vazia");
    }

    if (tarefaParaRemover == null) {
      System.out.println("Tarefa não encontrada");
    }
  }

  public void exibirTarefas() {
    if (!tarefaSetList.isEmpty()) {
      System.out.println(tarefaSetList);
    } else {
      System.out.println("Lista de tarefas vazia");
    }
  }

  public int contarTarefas() {
    return tarefaSetList.size();
  }

  public Set<Tarefa> obterTarefasConcluidas() {
    Set<Tarefa> tarefasConcluidas = new HashSet<>();
    for (Tarefa tarefa : tarefaSetList) {
      if (tarefa.isTarefaConcluida()) {
        tarefasConcluidas.add(tarefa);
      }
    }
    return tarefasConcluidas;
  }

  public Set<Tarefa> obterTarefasPendentes() {
    Set<Tarefa> tarefasPendentes = new HashSet<>();
    for (Tarefa tarefa : tarefaSetList) {
      if (!tarefa.isTarefaConcluida()) {
        tarefasPendentes.add(tarefa);
      }
    }
    return tarefasPendentes;
  }

  public void marcarTarefaConcluida(String descricao) {
    Tarefa tarefaConcluida = null;
    if (!tarefaSetList.isEmpty()) {
      for (Tarefa tarefa : tarefaSetList) {
        if (tarefa.getDescricao().equalsIgnoreCase(descricao)) {
          tarefaConcluida = tarefa;
          break;
        }
      }
      if (tarefaConcluida != null) {
        if (!tarefaConcluida.isTarefaConcluida()) {
          tarefaConcluida.setTarefaConcluida(true);
        }
      } else {
        System.out.println("Tarefa não encontrada");
      }
    } else {
      System.out.println("Lista de tarefas vazia");
    }
  }

  public void marcarTarefaPendente(String descricao) {
    Tarefa tarefaPendente = null;
    if (!tarefaSetList.isEmpty()) {
      for (Tarefa tarefa : tarefaSetList) {
        if (tarefa.getDescricao().equalsIgnoreCase(descricao)) {
          tarefaPendente = tarefa;
          break;
        }
      }
      if (tarefaPendente != null) {
        if (tarefaPendente.isTarefaConcluida())
          tarefaPendente.setTarefaConcluida(false);
      } else {
        System.out.println("Tarefa não encontrada");
      }
    } else {
      System.out.println("Lista de tarefas vazia");
    }
  }

  public void limparListaTarefas() {
    if (!tarefaSetList.isEmpty()) {
      tarefaSetList.clear();
    } else {
      System.out.println("A lista de tarefas já está vazia");
    }
  }

  public static void main(String[] args) {

    ListaTarefas listaTarefas = new ListaTarefas();
    listaTarefas.exibirTarefas();

    listaTarefas.adicionarTarefa("Terminar curso");
    listaTarefas.adicionarTarefa("Lavar roupa");
    listaTarefas.adicionarTarefa("Preparar almoço");
    listaTarefas.adicionarTarefa("Preparar almoço");
    listaTarefas.adicionarTarefa("Fazer exercícios físicos");
    listaTarefas.adicionarTarefa("Lavar louça");
    listaTarefas.exibirTarefas();

    listaTarefas.marcarTarefaConcluida("Preparar almoço");
    listaTarefas.marcarTarefaConcluida("Lavar louça");
    listaTarefas.marcarTarefaConcluida("Tarefa de teste");

    listaTarefas.marcarTarefaPendente("Lavar louça");
    listaTarefas.marcarTarefaPendente("Tarefa de teste");
    listaTarefas.exibirTarefas();

    listaTarefas.removerTarefa("Fazer exercícios físicos");
    listaTarefas.exibirTarefas();

    System.out.println("Número de tarefas: " + listaTarefas.contarTarefas());
    System.out.println("Tarefas concluídas: " +
        listaTarefas.obterTarefasConcluidas());
    System.out.println("Tarefas pendentes: " +
        listaTarefas.obterTarefasPendentes());

    listaTarefas.limparListaTarefas();
    listaTarefas.exibirTarefas();
  }
}
