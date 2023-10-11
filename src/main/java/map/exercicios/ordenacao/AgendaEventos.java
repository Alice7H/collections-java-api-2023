package main.java.map.exercicios.ordenacao;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

public class AgendaEventos {
  private Map<LocalDate, Evento> agendaEventosMap;

  public AgendaEventos() {
    this.agendaEventosMap = new HashMap<>();
  }

  public void adicionarEvento(LocalDate data, String nome, String atracao) {
    agendaEventosMap.put(data, new Evento(nome, atracao));
  }

  public void exibirAgenda() {
    Map<LocalDate, Evento> eventosTreeMap = new TreeMap<>(agendaEventosMap);
    if (!agendaEventosMap.isEmpty()) {
      System.out.println(eventosTreeMap);
    } else {
      System.out.println("Agenda de eventos vazia");
    }
  }

  public void obterProximoEvento() {
    /*
     * Obter valores e chaves isolados/independentes.
     * Set<LocalDate> dataSet = agendaEventosMap.keySet();
     * Collection<Evento> values = agendaEventosMap.values();
     */
    LocalDate dataAtual = LocalDate.now();
    LocalDate proximaDataEvento = null;
    Evento proximoEvento = null;
    Map<LocalDate, Evento> eventosTreeMap = new TreeMap<>(agendaEventosMap);

    for (Map.Entry<LocalDate, Evento> entry : eventosTreeMap.entrySet()) {
      if (entry.getKey().isEqual(dataAtual) || entry.getKey().isAfter(dataAtual)) {
        proximoEvento = entry.getValue();
        proximaDataEvento = entry.getKey();
        String dataEvento = proximaDataEvento.format(DateTimeFormatter.ofPattern("dd/MM/uuuu"));
        System.out
            .println("O próximo evento '" + proximoEvento.getNome() + "' será realizado na data " + dataEvento);
        break;
      }
    }
  }

  public static void main(String[] args) {
    AgendaEventos agendaEventos = new AgendaEventos();
    agendaEventos.exibirAgenda();

    agendaEventos.adicionarEvento(LocalDate.of(2023, 10, 10), "Museu de Arte - Ikebana",
        "Exposição dos melhores arranjos florais");
    agendaEventos.adicionarEvento(LocalDate.of(2023, 10, 5), "Encontro de Jovens", "Celebração de 10º ano do EJ");
    agendaEventos.adicionarEvento(LocalDate.of(2024, 01, 27), "Chá de bebê da Amanda",
        "Celebração entre amigos e familiares.");
    agendaEventos.adicionarEvento(LocalDate.of(2023, 10, 22), "Noite Estrelada",
        "Festa entre amigos");
    agendaEventos.adicionarEvento(LocalDate.of(2023, 10, 15), "Bootcamp de React JS",
        "Aulas intensivas sobre React usando NextJS");
    agendaEventos.adicionarEvento(LocalDate.of(2022, 10, 22), "Festa de Halloween",
        "Concurso de melhores doces e fantasias");

    agendaEventos.exibirAgenda();
    agendaEventos.obterProximoEvento();
  }

}
