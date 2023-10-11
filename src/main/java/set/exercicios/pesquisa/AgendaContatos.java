package main.java.set.exercicios.pesquisa;

import java.util.HashSet;
import java.util.Set;

public class AgendaContatos {

  private Set<Contato> contatosSetList;

  public AgendaContatos() {
    this.contatosSetList = new HashSet<>();
  }

  public void adicionarContato(String nome, int numeroTelefone) {
    contatosSetList.add(new Contato(nome, numeroTelefone));
  }

  public void exibirContatos() {
    if (!contatosSetList.isEmpty()) {
      System.out.println(contatosSetList);
    } else {
      System.out.println("Agenda de contatos vazia");
    }
  }

  public Set<Contato> pesquisarPorNome(String nome) {
    Set<Contato> contatoPorNome = new HashSet<>();
    for (Contato contato : contatosSetList) {
      if (contato.getNome().startsWith(nome)) {
        contatoPorNome.add(contato);
      }
    }
    return contatoPorNome;
  }

  public Contato atualizarNumeroContato(String nome, int novoNumero) {
    Contato contatoAtualizado = null;
    for (Contato contato : contatosSetList) {
      if (contato.getNome().equalsIgnoreCase(nome)) {
        contato.setNumeroTelefone(novoNumero);
        contatoAtualizado = contato;
        break;
      }
    }
    return contatoAtualizado;
  }

  public static void main(String[] args) {
    AgendaContatos agendaContatos = new AgendaContatos();
    agendaContatos.exibirContatos();
    agendaContatos.adicionarContato("Camila Santos", 123405678);
    agendaContatos.adicionarContato("Laura Santos", 163450789);
    agendaContatos.adicionarContato("Camila Cabelo", 208765439);
    agendaContatos.adicionarContato("Maurício Souza", 192837465);
    agendaContatos.adicionarContato("Maurício Souza", 154321678);
    agendaContatos.adicionarContato("Camila", 118273645);

    agendaContatos.exibirContatos();

    System.out.println("\n Pesquisa por Camila: " + agendaContatos.pesquisarPorNome("Camila"));

    agendaContatos.atualizarNumeroContato("Camila Santos", 213645870);
    agendaContatos.exibirContatos();
  }
}
