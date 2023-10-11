package main.java.set.exercicios.operacoesBasicas;

import java.util.HashSet;
import java.util.Set;

public class ConjuntoConvidados {

  private Set<Convidado> convidadoList;

  public ConjuntoConvidados() {
    this.convidadoList = new HashSet<>();
  }

  public void adicionarConvidado(String nome, int codigoConvite) {
    convidadoList.add(new Convidado(nome, codigoConvite));
  }

  public void removerConvidadoPorCodigoConvite(int codigoConvite) {
    Convidado convidadoParaRemover = null;
    if (!convidadoList.isEmpty()) {
      for (Convidado convidado : convidadoList) {
        if (convidado.getCodigoConvite() == codigoConvite) {
          convidadoParaRemover = convidado;
          break;
        }
      }
      convidadoList.remove(convidadoParaRemover);
    } else {
      System.out.println("Lista de convidados vazia.");
    }
  }

  public int contarConvidados() {
    return convidadoList.size();
  }

  public void exibirConvidados() {
    if (!convidadoList.isEmpty()) {
      System.out.println(convidadoList);
    } else {
      System.out.println("Lista de convidados vazia");
    }
  }

  public static void main(String[] args) {
    ConjuntoConvidados conv = new ConjuntoConvidados();
    conv.exibirConvidados();

    conv.adicionarConvidado("Camila", 123);
    conv.adicionarConvidado("Carlos", 32);
    conv.adicionarConvidado("Cauã", 21);
    conv.adicionarConvidado("Carolina", 12);
    conv.adicionarConvidado("Clara", 12);

    conv.exibirConvidados();
    System.out.println("Existe(m) " + conv.contarConvidados() + " convidado(s) dentro do set ");

    conv.removerConvidadoPorCodigoConvite(12);

    conv.exibirConvidados();
    System.out.println("Existe(m) " + conv.contarConvidados() + " convidado(s) dentro do set ");
  }
}