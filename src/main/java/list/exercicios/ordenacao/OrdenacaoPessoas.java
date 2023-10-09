package main.java.list.exercicios.ordenacao;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class OrdenacaoPessoas {
  private List<Pessoa> pessoaList;

  public OrdenacaoPessoas() {
    this.pessoaList = new ArrayList<>();
  }

  public void adicionarPessoa(String nome, int idade, double altura) {
    this.pessoaList.add(new Pessoa(nome, idade, altura));
  }

  public List<Pessoa> ordenarPorIdade() {
    List<Pessoa> pessoasPorIdade = new ArrayList<>(pessoaList);
    if (!pessoaList.isEmpty()) {
      Collections.sort(pessoasPorIdade);
      return pessoasPorIdade;
    } else {
      throw new RuntimeException("A lista está vazia!");
    }
  }

  public List<Pessoa> ordenarPorAltura() {
    List<Pessoa> pessoasPorAltura = new ArrayList<>(pessoaList);
    if (!pessoaList.isEmpty()) {
      Collections.sort(pessoasPorAltura, new ComparatorPessoaPorAltura());
      return pessoasPorAltura;
    } else {
      throw new RuntimeException("A lista está vazia!");
    }
  }

  public static void main(String[] args) {
    OrdenacaoPessoas ordenacaoPessoas = new OrdenacaoPessoas();

    ordenacaoPessoas.adicionarPessoa("Mariana", 20, 1.65);
    ordenacaoPessoas.adicionarPessoa("Luíza", 27, 1.60);
    ordenacaoPessoas.adicionarPessoa("Maria", 25, 1.62);
    ordenacaoPessoas.adicionarPessoa("José", 30, 1.92);
    ordenacaoPessoas.adicionarPessoa("Paulo", 21, 1.80);
    ordenacaoPessoas.adicionarPessoa("Pedro", 19, 1.75);

    System.out.println(ordenacaoPessoas.ordenarPorAltura());
    System.out.println(ordenacaoPessoas.ordenarPorIdade());
  }
}
