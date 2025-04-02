package gruppoG22;

import java.io.IOException;
import java.util.Comparator;
import java.util.Iterator;

public class TestAgriturismiLambda {
    public static void main(String[] args) {
        try {
            ElencoAgriturismi elenco = ElencoAgriturismi.carica("C:\\Users\\cerlo\\OneDrive - Università di Salerno\\CARLO\\Codici\\JAVA\\AssignmentConcurrency\\src\\main\\resources\\gruppoG22\\Agriturismi-Napoli.csv");

            elenco.aggiorna(a -> a.setPernottamento(a.getPostiLetto() > 0));

            elenco.aggiorna(a -> a.setCamping(a.getPostiTenda() > 0 || a.getPostiRoulotte() > 0));

            Iterator<String> comuni = elenco.esporta(a -> a.getComune()).iterator();
            System.out.println("Comuni con agriturismi: ");
            while (comuni.hasNext()) {
                System.out.println("- " + comuni.next());
            }

            int postiLettoGragnano = elenco.filtra(a -> a.getComune().equalsIgnoreCase("Gragnano")).stream().mapToInt(a->a.getPostiLetto()).sum();
            System.out.println("\nPosti letto complessivi a Gragnano:\n" + postiLettoGragnano);

            elenco.ordina(Comparator.comparing(a -> a.getDenominazione()));
            System.out.println("\nElenco ordinato per denominazione:\n" + elenco);

        } catch (IOException e) {
            System.err.println("Errore nella lettura del file: " + e.getMessage());
        }
    }
}