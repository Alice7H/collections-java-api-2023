package main.java.map.exercicios.pesquisa;

public class Produto {
  private String nome;
  private int quantidade;
  private double preco;

  public Produto(String nome, int quantidade, double preco) {
    this.nome = nome;
    this.quantidade = quantidade;
    this.preco = preco;
  }

  public String getNome() {
    return nome;
  }

  public double getPreco() {
    return preco;
  }

  public int getQuantidade() {
    return quantidade;
  }

  @Override
  public String toString() {
    return "\n nome=" + nome + ", quantidade=" + quantidade + ", preco=" + preco;
  }

}
