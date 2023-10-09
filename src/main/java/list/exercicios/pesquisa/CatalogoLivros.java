package main.java.list.exercicios.pesquisa;

import java.util.ArrayList;
import java.util.List;

public class CatalogoLivros {

  private List<Livro> livrosList;

  public CatalogoLivros() {
    this.livrosList = new ArrayList<>();
  }

  public void adicionarLivro(String titulo, String autor, int anoPublicacao) {
    livrosList.add(new Livro(titulo, autor, anoPublicacao));
  }

  public List<Livro> pesquisarPorAutor(String autor) {
    List<Livro> livrosPorAutor = new ArrayList<>();
    if (!livrosList.isEmpty()) {
      for (Livro livro : livrosList) {
        if (livro.getAutor().equalsIgnoreCase(autor)) {
          livrosPorAutor.add(livro);
        }
      }
    }
    return livrosPorAutor;
  }

  public List<Livro> pesquisarPorIntervaloAnos(int anoInicial, int anoFinal) {
    List<Livro> livrosPorIntervaloAnos = new ArrayList<>();
    if (!livrosList.isEmpty()) {
      for (Livro livro : livrosList) {
        if (livro.getAnoPublicacao() >= anoInicial && livro.getAnoPublicacao() <= anoFinal) {
          livrosPorIntervaloAnos.add(livro);
        }
      }
    }
    return livrosPorIntervaloAnos;
  }

  public Livro pesquisarPorTitulo(String titulo) {
    Livro livroPorTitulo = null;
    if (!livrosList.isEmpty()) {
      for (Livro livro : livrosList) {
        if (livro.getTitulo().equalsIgnoreCase(titulo)) {
          livroPorTitulo = livro;
          break;
        }
      }
    }
    return livroPorTitulo;
  }

  public static void main(String[] args) {
    CatalogoLivros cLivros = new CatalogoLivros();

    cLivros.adicionarLivro("título 1", "autor 1", 2000);
    cLivros.adicionarLivro("outro título", "autor 1", 2020);
    cLivros.adicionarLivro("título 2", "autor 2", 2010);
    cLivros.adicionarLivro("título 3", "autor 3", 2015);

    System.out.println(cLivros.pesquisarPorAutor("autor 1"));
    System.out.println(cLivros.pesquisarPorIntervaloAnos(2000, 2010));
    System.out.println(cLivros.pesquisarPorTitulo("título 3"));

  }
}
