package main.java.set.exercicios.ordenacao;

import java.util.Comparator;
import java.util.Objects;

public class Produto implements Comparable<Produto> {
  private String nome;
  private long cod;
  private double preco;
  private int quantidade;

  public Produto(String nome, long cod, double preco, int quantidade) {
    this.nome = nome;
    this.cod = cod;
    this.preco = preco;
    this.quantidade = quantidade;
  }

  public String getNome() {
    return nome;
  }

  public long getCod() {
    return cod;
  }

  public double getPreco() {
    return preco;
  }

  public int getQuantidade() {
    return quantidade;
  }

  @Override
  public String toString() {
    return "\n Nome=" + nome + ", cod=" + cod + ", preco=" + preco + ", quantidade=" + quantidade;
  }

  @Override
  public int hashCode() {
    return Objects.hash(getCod());
  }

  @Override
  public boolean equals(Object obj) {
    if (this == obj)
      return true;
    if (!(obj instanceof Produto produto))
      return false;
    return getCod() == produto.getCod();
  }

  @Override
  public int compareTo(Produto p) {
    return nome.compareToIgnoreCase(p.getNome());
  }
}

class CompararProdutosPorPreco implements Comparator<Produto> {

  @Override
  public int compare(Produto p1, Produto p2) {
    return Double.compare(p1.getPreco(), p2.getPreco());
  }

}
