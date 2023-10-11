package main.java.set.exercicios.ordenacao;

import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;

public class CadastroProdutos {
  private Set<Produto> produtoSetList;

  public CadastroProdutos() {
    this.produtoSetList = new HashSet<>();
  }

  public void adicionarProduto(long cod, String nome, double preco, int quantidade) {
    produtoSetList.add(new Produto(nome, cod, preco, quantidade));
  }

  public Set<Produto> exibirProdutosPorNome() {
    Set<Produto> produtosPorNome = new TreeSet<>(produtoSetList);
    return produtosPorNome;
  }

  public Set<Produto> exibirProdutosPorPreco() {
    Set<Produto> produtoPorPreco = new TreeSet<>(new CompararProdutosPorPreco());
    produtoPorPreco.addAll(produtoSetList);
    return produtoPorPreco;
  }

  public static void main(String[] args) {
    CadastroProdutos cadastroProdutos = new CadastroProdutos();

    System.out.println("Lista com " + cadastroProdutos.produtoSetList.size() + " produto(s)");

    cadastroProdutos.adicionarProduto(1L, "Pé de moleque", 1.50, 2);
    cadastroProdutos.adicionarProduto(2L, "Coxão mole", 33.49, 1);
    cadastroProdutos.adicionarProduto(3L, "Detergente", 2.50, 2);
    cadastroProdutos.adicionarProduto(4L, "Peito de frango", 14.49, 2);
    cadastroProdutos.adicionarProduto(5L, "Alface crespa", 1.79, 2);

    System.out.println("Lista com " + cadastroProdutos.produtoSetList.size() + " produto(s)");

    System.out.println(cadastroProdutos.exibirProdutosPorNome());
    System.out.println(cadastroProdutos.exibirProdutosPorPreco());
  }
}
