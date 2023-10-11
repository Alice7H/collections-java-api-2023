package main.java.set.exercicios.ordenacao;

import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;

public class GerenciadorAlunos {
  private Set<Aluno> alunosSetList;

  public GerenciadorAlunos() {
    this.alunosSetList = new HashSet<>();
  }

  public void adicionarAluno(String nome, Long matricula, double media) {
    alunosSetList.add(new Aluno(nome, matricula, media));
  }

  public void removerAluno(long matricula) {
    Aluno alunoParaRemover = null;
    if (!alunosSetList.isEmpty()) {
      for (Aluno aluno : alunosSetList) {
        if (aluno.getMatricula() == matricula) {
          alunoParaRemover = aluno;
          break;
        }
      }
      if (alunoParaRemover != null) {
        alunosSetList.remove(alunoParaRemover);
      } else {
        System.out.println("Aluno não encontrado");
      }
    } else {
      System.out.println("Lista de alunos vazia");
    }
  }

  public Set<Aluno> exibirAlunosPorNome() {
    Set<Aluno> alunosPorNome = new TreeSet<>(alunosSetList);
    return alunosPorNome;
  }

  public Set<Aluno> exibirAlunosPorNota() {
    Set<Aluno> alunosPorNota = new TreeSet<>(new ComparaAlunoPorNota());
    alunosPorNota.addAll(alunosSetList);
    return alunosPorNota;
  }

  public void exibirAlunos() {
    if (!alunosSetList.isEmpty()) {
      System.out.println(alunosSetList);
    } else {
      System.out.println("Lista de alunos vazia");
    }
  }

  public static void main(String[] args) {
    GerenciadorAlunos alunos = new GerenciadorAlunos();
    alunos.exibirAlunos();

    alunos.adicionarAluno(" Maria Cristina", 123L, 10.00);
    alunos.adicionarAluno(" Maria João", 213L, 9.7);
    alunos.adicionarAluno(" Maria Joaquina", 13L, 8.67);
    alunos.adicionarAluno(" Mariana", 71L, 9.45);
    alunos.adicionarAluno(" Maria Do Carmo", 21L, 9.00);
    alunos.adicionarAluno(" Luana Batista", 21L, 10.00);
    System.out.println("Quantidade de alunos na lista: " + alunos.alunosSetList.size());
    alunos.exibirAlunos();

    alunos.removerAluno(71L);
    System.out.println("Quantidade de alunos na lista: " + alunos.alunosSetList.size());
    alunos.exibirAlunos();

    System.out.println(alunos.exibirAlunosPorNome());
    System.out.println(alunos.exibirAlunosPorNota());
  }
}
