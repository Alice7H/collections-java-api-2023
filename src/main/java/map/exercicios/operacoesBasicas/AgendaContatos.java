package main.java.map.exercicios.operacoesBasicas;

import java.util.HashMap;
import java.util.Map;

public class AgendaContatos {
  private Map<String, Integer> agendaContatoMap;

  public AgendaContatos() {
    this.agendaContatoMap = new HashMap<>();
  }

  public void adicionarContato(String nome, Integer telefone) {
    agendaContatoMap.put(nome, telefone);
  }

  public void removerContato(String nome) {
    if (!agendaContatoMap.isEmpty()) {
      agendaContatoMap.remove(nome);
    } else {
      System.out.println("Agenda de contatos vazia");
    }
  }

  public void exibirContatos() {
    System.out.println(agendaContatoMap);
  }

  public Integer pesquisarPorNome(String nome) {
    Integer telefonePorNome = null;
    if (!agendaContatoMap.isEmpty()) {
      telefonePorNome = agendaContatoMap.get(nome);
    }
    return telefonePorNome;
  }

  public static void main(String[] args) {
    AgendaContatos ac = new AgendaContatos();
    ac.exibirContatos();
    ac.adicionarContato("Gabriela", 123123123);
    ac.adicionarContato("Manuela", 456456456);
    ac.adicionarContato("Isabela", 789789789);
    ac.adicionarContato("Eduarda", 192837465);
    ac.adicionarContato("Marcela", 109109109);

    System.out.println("Agenda de contatos com " + ac.agendaContatoMap.size() + " contato(s).");
    ac.exibirContatos();

    ac.removerContato("Eduarda");
    System.out.println("Eduarda removida.");

    System.out.println("Agenda de contatos com " + ac.agendaContatoMap.size() + " contato(s).");
    ac.exibirContatos();

    System.out.println("Número de telefone de Eduarda: " + ac.pesquisarPorNome("Eduarda"));
    System.out.println("Número de telefone de Manuela: " + ac.pesquisarPorNome("Manuela"));
  }
}
