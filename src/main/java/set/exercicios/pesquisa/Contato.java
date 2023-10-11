package main.java.set.exercicios.pesquisa;

import java.util.Objects;

public class Contato {
  private String nome;
  private int numeroTelefone;

  public Contato(String nome, int numeroTelefone) {
    this.nome = nome;
    this.numeroTelefone = numeroTelefone;
  }

  public String getNome() {
    return nome;
  }

  public int getNumeroTelefone() {
    return numeroTelefone;
  }

  public void setNumeroTelefone(int numeroTelefone) {
    this.numeroTelefone = numeroTelefone;
  }

  @Override
  public int hashCode() {
    return Objects.hash(getNome());
  }

  @Override
  public boolean equals(Object obj) {
    if (this == obj)
      return true;
    if (!(obj instanceof Contato contato))
      return false;
    return Objects.equals(getNome(), contato.getNome());
  }

  @Override
  public String toString() {
    return "\n Contato [nome=" + nome + ", numeroTelefone=" + numeroTelefone + "]";
  }

}
