package main.java.list.exercicios.ordenacao;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class OrdenacaoNumeros {
  List<Integer> listNumbers;

  public OrdenacaoNumeros() {
    this.listNumbers = new ArrayList<>();
  }

  public void adicionarNumero(int numero) {
    this.listNumbers.add(numero);
  }

  public List<Integer> ordenarAscendente() {
    List<Integer> listAscendente = new ArrayList<>(listNumbers);
    if (!listNumbers.isEmpty()) {
      Collections.sort(listAscendente);
      return listAscendente;
    } else {
      throw new RuntimeException("A lista está vazia");
    }
  }

  public List<Integer> ordenarDescendente() {
    List<Integer> listDescendente = new ArrayList<>(listNumbers);
    if (!listNumbers.isEmpty()) {
      Collections.sort(listDescendente, Collections.reverseOrder());
      return listDescendente;
    } else {
      throw new RuntimeException("A lista está vazia");
    }
  }

  public void exibirLista() {
    if (!listNumbers.isEmpty()) {
      System.out.println(listNumbers);
    } else {
      System.out.println("A lista está vazia");
    }
  }

  public static void main(String[] args) {
    OrdenacaoNumeros ordenacaoNumeros = new OrdenacaoNumeros();

    ordenacaoNumeros.exibirLista();

    ordenacaoNumeros.adicionarNumero(3);
    ordenacaoNumeros.adicionarNumero(2);
    ordenacaoNumeros.adicionarNumero(5);
    ordenacaoNumeros.adicionarNumero(4);
    ordenacaoNumeros.adicionarNumero(1);
    ordenacaoNumeros.adicionarNumero(7);

    ordenacaoNumeros.exibirLista();

    System.out.println("Ascendente: " + ordenacaoNumeros.ordenarAscendente());
    System.out.println("Descendente: " + ordenacaoNumeros.ordenarDescendente());
  }
}
