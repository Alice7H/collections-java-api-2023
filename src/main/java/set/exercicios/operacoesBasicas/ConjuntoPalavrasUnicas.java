package main.java.set.exercicios.operacoesBasicas;

import java.util.HashSet;
import java.util.Set;

public class ConjuntoPalavrasUnicas {

  private Set<String> palavrasUnicas;

  public ConjuntoPalavrasUnicas() {
    this.palavrasUnicas = new HashSet<>();
  }

  public void adicionarPalavra(String palavra) {
    palavrasUnicas.add(palavra);
  }

  public void removerPalavra(String palavra) {
    if (!palavrasUnicas.isEmpty()) {
      if (palavrasUnicas.contains(palavra)) {
        palavrasUnicas.remove(palavra);
      } else {
        System.out.println("Palavra não encontrada");
      }
    } else {
      System.out.println("O conjunto de palavras únicas está vazio");
    }
  }

  public boolean verificarPalavra(String palavra) {
    if (palavrasUnicas.contains(palavra))
      return true;
    return false;
  }

  public void exibirPalavrasUnicas() {
    if (!palavrasUnicas.isEmpty()) {
      System.out.println(palavrasUnicas);
    } else {
      System.out.println("Conjunto de palavras únicas vazia");
    }
  }

  public static void main(String[] args) {
    ConjuntoPalavrasUnicas word = new ConjuntoPalavrasUnicas();
    word.exibirPalavrasUnicas();

    word.adicionarPalavra("olhos");
    word.adicionarPalavra("pescoço");
    word.adicionarPalavra("ombro");
    word.adicionarPalavra("cabeça");

    word.exibirPalavrasUnicas();

    word.removerPalavra("ombro");

    word.exibirPalavrasUnicas();

    System.out.println("A palavra única 'cabeça' está presente no conjunto? " + word.verificarPalavra("cabeça"));
    System.out.println("A palavra única 'ombro' está presente no conjunto? " + word.verificarPalavra("ombro"));
  }
}
