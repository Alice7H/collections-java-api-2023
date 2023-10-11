package main.java.map.exercicios.pesquisa;

import java.util.HashMap;
import java.util.Map;

public class EstoqueProdutos {

  private Map<Long, Produto> estoqueProdutosMap;

  public EstoqueProdutos() {
    this.estoqueProdutosMap = new HashMap<>();
  }

  public void adicionarProduto(long cod, String nome, int quantidade, double preco) {
    estoqueProdutosMap.put(cod, new Produto(nome, quantidade, preco));
  }

  public void exibirProdutos() {
    if (!estoqueProdutosMap.isEmpty()) {
      System.out.println(estoqueProdutosMap);
    } else {
      System.out.println("Sem estoque de produtos");
    }
  }

  public double calcularValorTotalEstoque() {
    Double totalEstoque = 0d;
    if (!estoqueProdutosMap.isEmpty()) {
      for (Produto p : estoqueProdutosMap.values()) {
        totalEstoque += p.getQuantidade() * p.getPreco();
      }
    }
    return totalEstoque;
  }

  public Produto obterProdutoMaisCaro() {
    Produto produtoMaisCaro = null;
    double maiorPreco = Double.MIN_VALUE;

    if (!estoqueProdutosMap.isEmpty()) {
      for (Produto p : estoqueProdutosMap.values()) {
        if (p.getPreco() > maiorPreco) {
          maiorPreco = p.getPreco();
          produtoMaisCaro = p;
        }
      }
    }
    return produtoMaisCaro;
  }

  public Produto obterProdutoMaisBarato() {
    Produto produtoMaisBarato = null;
    double menorPreco = Double.MAX_VALUE;

    if (!estoqueProdutosMap.isEmpty()) {
      for (Produto p : estoqueProdutosMap.values()) {
        if (p.getPreco() < menorPreco) {
          menorPreco = p.getPreco();
          produtoMaisBarato = p;
        }
      }
    }
    return produtoMaisBarato;
  }

  public Produto obterProdutoMaiorQuantidadeValorTotalNoEstoque() {
    Produto produtoMaiorValorEstoque = null;
    double maiorProdutoEstoque = Double.MIN_VALUE;

    if (!estoqueProdutosMap.isEmpty()) {
      for (Produto p : estoqueProdutosMap.values()) {
        double valorProdutoEstoque = p.getPreco() * p.getQuantidade();
        if (valorProdutoEstoque > maiorProdutoEstoque) {
          maiorProdutoEstoque = valorProdutoEstoque;
          produtoMaiorValorEstoque = p;
        }
      }
    }
    return produtoMaiorValorEstoque;
  }

  public static void main(String[] args) {
    EstoqueProdutos estoqueProdutos = new EstoqueProdutos();
    estoqueProdutos.exibirProdutos();

    estoqueProdutos.adicionarProduto(1L, "macarrão", 5, 3.25);
    estoqueProdutos.adicionarProduto(2L, "carne", 3, 32.20);
    estoqueProdutos.adicionarProduto(3L, "arroz", 5, 21.32);

    estoqueProdutos.exibirProdutos();

    System.out.println("Produto mais barato: " + estoqueProdutos.obterProdutoMaisBarato());
    System.out.println("Produto mais caro: " + estoqueProdutos.obterProdutoMaisCaro());
    System.out.println("Produto de maior valor: " + estoqueProdutos.obterProdutoMaiorQuantidadeValorTotalNoEstoque());

    System.out.println("Valor total de estoque: " + estoqueProdutos.calcularValorTotalEstoque());
  }
}
