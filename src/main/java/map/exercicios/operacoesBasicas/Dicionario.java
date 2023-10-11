package main.java.map.exercicios.operacoesBasicas;

import java.util.HashMap;
import java.util.Map;

public class Dicionario {

  private Map<String, String> dicionarioMap;

  public Dicionario() {
    this.dicionarioMap = new HashMap<>();
  }

  public void adicionarPalavra(String palavra, String definicao) {
    dicionarioMap.put(palavra, definicao);
  }

  public void removerPalavra(String palavra) {
    if (!dicionarioMap.isEmpty())
      dicionarioMap.remove(palavra);
    else
      System.out.println("Dicionário vazio");
  }

  public void exibirPalavras() {
    if (!dicionarioMap.isEmpty())
      System.out.println(dicionarioMap);
    else
      System.out.println("Dicionário vazio");
  }

  public String pesquisarPorPalavra(String palavra) {
    String definicao = null;
    if (!dicionarioMap.isEmpty()) {
      definicao = dicionarioMap.get(palavra);
      if (definicao != null)
        return definicao;
      else
        return "Definição não encontrada";
    }
    return "Dicionário vazio";
  }

  public static void main(String[] args) {

    Dicionario dicionario = new Dicionario();
    dicionario.exibirPalavras();

    dicionario.adicionarPalavra("história", "Reunião e análise das informações ou dos conhecimentos sobre o passado");
    dicionario.adicionarPalavra("história", "Reunião das informações acerca de um indivíduo ou coisa.");
    dicionario.adicionarPalavra("subestimar", "Não dar o devido valor ou apreço");
    dicionario.adicionarPalavra("consiste", "Ação de consistir, de ser composto ou formado por alguma coisa");
    dicionario.adicionarPalavra("fazer", "Desenvolver algo a partir de uma certa ação");

    dicionario.exibirPalavras();
    dicionario.removerPalavra("subestimar");
    dicionario.exibirPalavras();

    System.out.println("Pesquisa da palavra 'fazer': " + dicionario.pesquisarPorPalavra("fazer"));

  }

}
