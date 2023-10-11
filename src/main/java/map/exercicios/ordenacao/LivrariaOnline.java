package main.java.map.exercicios.ordenacao;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.NoSuchElementException;

public class LivrariaOnline {
  private Map<String, Livro> livrosMap;

  public LivrariaOnline() {
    this.livrosMap = new HashMap<>();
  }

  public void adicionarLivro(String link, String titulo, String autor, double preco) {
    livrosMap.put(link, new Livro(titulo, autor, preco));
  }

  public void removerLivro(String titulo) {
    List<String> chavesParaRemover = new ArrayList<>();
    for (Map.Entry<String, Livro> entry : livrosMap.entrySet()) {
      if (entry.getValue().getTitulo().equalsIgnoreCase(titulo)) {
        chavesParaRemover.add(entry.getKey());
      }
    }
    for (String chave : chavesParaRemover) {
      livrosMap.remove(chave);
    }
  }

  public void exibirLivrosOrdenadosPorPreco() {
    List<Entry<String, Livro>> livrosParaOrdenarPorPreco = new ArrayList<>(livrosMap.entrySet());
    Collections.sort(livrosParaOrdenarPorPreco, new ComparatorPorPreco());

    Map<String, Livro> livrosOrdenadosPorPreco = new LinkedHashMap<>();
    for (Entry<String, Livro> entry : livrosParaOrdenarPorPreco) {
      livrosOrdenadosPorPreco.put(entry.getKey(), entry.getValue());
    }
    System.out.println(livrosOrdenadosPorPreco);
  }

  public Map<String, Livro> pesquisarLivrosPorAutor(String autor) {
    Map<String, Livro> livrosPorAutor = new LinkedHashMap<>();
    for (Entry<String, Livro> entry : livrosMap.entrySet()) {
      if (entry.getValue().getAutor().equals(autor)) {
        livrosPorAutor.put(entry.getKey(), entry.getValue());
      }
    }
    return livrosPorAutor;
  }

  public List<Livro> obterLivroMaisCaro() {
    List<Livro> livroMaisCaro = new ArrayList<>();
    Double maiorPreco = Double.MIN_VALUE;

    if (!livrosMap.isEmpty()) {
      for (Livro l : livrosMap.values()) {
        if (l.getPreco() > maiorPreco) {
          maiorPreco = l.getPreco();
        }
      }
    } else {
      throw new NoSuchElementException("A livraria está vazia!");
    }

    for (Entry<String, Livro> entry : livrosMap.entrySet()) {
      if (entry.getValue().getPreco() == maiorPreco) {
        Livro livroMaiorPreco = livrosMap.get(entry.getKey());
        livroMaisCaro.add(livroMaiorPreco);
      }
    }

    return livroMaisCaro;
  }

  public List<Livro> exibirLivroMaisBarato() {
    List<Livro> livroMaisBarato = new ArrayList<>();
    Double menorPreco = Double.MAX_VALUE;

    if (!livrosMap.isEmpty()) {
      for (Livro l : livrosMap.values()) {
        if (l.getPreco() < menorPreco) {
          menorPreco = l.getPreco();
        }
      }
    } else {
      throw new NoSuchElementException("A livraria está vazia!");
    }

    for (Entry<String, Livro> entry : livrosMap.entrySet()) {
      if (entry.getValue().getPreco() == menorPreco) {
        Livro livroPrecoBaixo = livrosMap.get(entry.getKey());
        livroMaisBarato.add(livroPrecoBaixo);
      }
    }
    return livroMaisBarato;
  }

  public static void main(String[] args) {
    LivrariaOnline livrariaOnline = new LivrariaOnline();
    System.out.println("Quantidade de livros: " + livrariaOnline.livrosMap.size());

    livrariaOnline.adicionarLivro("https://amzn.to/3EclT8Z", "1984", "George Orwell", 50d);
    livrariaOnline.adicionarLivro("https://amzn.to/47Umiun", "A Revolução dos Bichos", "George Orwell", 7.05d);
    livrariaOnline.adicionarLivro("https://amzn.to/3L1FFI6", "Caixa de Pássaros - Bird Box: Não Abra os Olhos",
        "Josh Malerman", 19.99d);
    livrariaOnline.adicionarLivro("https://amzn.to/3OYb9jk", "Malorie", "Josh Malerman", 5d);
    livrariaOnline.adicionarLivro("https://amzn.to/45HQE1L", "E Não Sobrou Nenhum", "Agatha Christie", 50d);
    livrariaOnline.adicionarLivro("https://amzn.to/45u86q4", "Assassinato no Expresso do Oriente", "Agatha Christie",
        5d);
    System.out.println("Livros adicionados");
    System.out.println("Quantidade de livros: " + livrariaOnline.livrosMap.size());

    System.out.println("Livros ordernados por preço: ");
    livrariaOnline.exibirLivrosOrdenadosPorPreco();

    System.out.println("Livros ordernados pela autora Agatha Christie: \n"
        + livrariaOnline.pesquisarLivrosPorAutor("Agatha Christie"));

    System.out.println("Livro mais caro: " + livrariaOnline.obterLivroMaisCaro());
    System.out.println("Livro mais barato: " + livrariaOnline.exibirLivroMaisBarato());

    livrariaOnline.removerLivro("1984");
    System.out.println("Livro 1984 removido");
    System.out.println("Quantidade de livros: " + livrariaOnline.livrosMap.size());

  }
}
