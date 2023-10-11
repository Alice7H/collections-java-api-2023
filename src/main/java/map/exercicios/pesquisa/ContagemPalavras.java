package main.java.map.exercicios.pesquisa;

import java.util.HashMap;
import java.util.Map;

public class ContagemPalavras {
  private Map<String, Integer> contagemPalavrasMap;

  public ContagemPalavras() {
    this.contagemPalavrasMap = new HashMap<>();
  }

  public void adicionarPalavra(String palavra, Integer contagem) {
    contagemPalavrasMap.put(palavra, contagem);
  }

  public void removerPalavra(String palavra) {
    if (!contagemPalavrasMap.isEmpty()) {
      contagemPalavrasMap.remove(palavra);
    } else {
      System.out.println("Sem palavras e contagem");
    }
  }

  public void exibirContagemPalavras() {
    if (!contagemPalavrasMap.isEmpty()) {
      System.out.println(contagemPalavrasMap);
    } else {
      System.out.println("Sem palavras e contagem");
    }
  }

  public String encontrarPalavraMaisFrequente() {
    String palavraMaisFrequente = "Sem palavras e contagem";
    int maisFrequente = Integer.MIN_VALUE;
    if (!contagemPalavrasMap.isEmpty()) {
      for (Map.Entry<String, Integer> entry : contagemPalavrasMap.entrySet()) {
        if (entry.getValue() > maisFrequente) {
          maisFrequente = entry.getValue();
          palavraMaisFrequente = entry.getKey();
        }
      }
    }
    return "Palavra: " + palavraMaisFrequente + ", contagem: " + maisFrequente;
  }

  public static void main(String[] args) {
    ContagemPalavras contagemPalavras = new ContagemPalavras();
    contagemPalavras.exibirContagemPalavras();

    contagemPalavras.adicionarPalavra("Java", 25);
    contagemPalavras.adicionarPalavra("Python", 13);
    contagemPalavras.adicionarPalavra("JavaScript", 10);
    contagemPalavras.adicionarPalavra("Kotlin", 12);
    contagemPalavras.adicionarPalavra("C#", 5);
    contagemPalavras.adicionarPalavra("CSS", 25);
    contagemPalavras.adicionarPalavra("HTML", 26);

    contagemPalavras.exibirContagemPalavras();

    contagemPalavras.removerPalavra("CSS");
    contagemPalavras.removerPalavra("HTML");

    contagemPalavras.exibirContagemPalavras();

    System.out.println(contagemPalavras.encontrarPalavraMaisFrequente());
  }
}
