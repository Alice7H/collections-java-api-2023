package main.java.list.exercicios.operacoesBasicas;

import java.util.ArrayList;
import java.util.List;

public class CarrinhoDeCompras {
  private List<Item> itemList;

  public CarrinhoDeCompras() {
    this.itemList = new ArrayList<Item>();
  }

  public void adicionarItem(String nome, double preco, int quantidade) {
    itemList.add(new Item(nome, preco, quantidade));
  }

  public void removerItem(String nome) {
    List<Item> itensParaRemover = new ArrayList<>();
    if (!itemList.isEmpty()) {
      for (Item it : itemList) {
        if (it.getNome().equalsIgnoreCase(nome)) {
          itensParaRemover.add(it);
        }
      }
      itemList.removeAll(itensParaRemover);
    } else {
      System.out.println("Carrinho vazio");
    }
  }

  public double calcularValorTotal() {
    double total = 0d;
    if (!itemList.isEmpty()) {
      for (Item item : itemList) {
        double valorItem = item.getPreco() * item.getQuantidade();
        total += valorItem;
      }
      return total;
    } else {
      throw new RuntimeException("Carrinho vazio");
    }
  }

  public void exibirItens() {
    if (!itemList.isEmpty()) {
      System.out.println(itemList);
    } else {
      System.out.println("Carrinho vazio");
    }
  }

  public static void main(String[] args) {
    CarrinhoDeCompras carrinho = new CarrinhoDeCompras();
    carrinho.exibirItens();

    carrinho.adicionarItem("item 1", 20.50, 1);
    carrinho.adicionarItem("item 2", 10.25, 2);
    carrinho.adicionarItem("item 3", 50, 1);
    System.out.println(carrinho.calcularValorTotal());

    carrinho.removerItem("item 1");
    System.out.println(carrinho.calcularValorTotal());
    carrinho.exibirItens();
  }
}
