package main.java.set.exercicios.ordenacao;

import java.util.Comparator;
import java.util.Objects;

public class Aluno implements Comparable<Aluno> {
  private String nome;
  private long matricula;
  private double media;

  public Aluno(String nome, long matricula, double media) {
    this.nome = nome;
    this.matricula = matricula;
    this.media = media;
  }

  public String getNome() {
    return nome;
  }

  public long getMatricula() {
    return matricula;
  }

  public double getMedia() {
    return media;
  }

  @Override
  public String toString() {
    return "\n Aluno: " + nome + ", matrícula: " + matricula + ", média: " + media;
  }

  @Override
  public int hashCode() {
    return Objects.hash(getMatricula());
  }

  @Override
  public boolean equals(Object obj) {
    if (this == obj)
      return true;
    if (!(obj instanceof Aluno aluno))
      return false;
    return getMatricula() == aluno.getMatricula();
  }

  @Override
  public int compareTo(Aluno a) {
    return nome.compareTo(a.getNome());
  }
}

class ComparaAlunoPorNota implements Comparator<Aluno> {
  @Override
  public int compare(Aluno a1, Aluno a2) {
    return Double.compare(a1.getMedia(), a2.getMedia());
  }

}
