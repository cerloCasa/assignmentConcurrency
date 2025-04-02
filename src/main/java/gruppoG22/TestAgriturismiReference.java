package gruppoG22;

import java.io.IOException;
import java.util.Comparator;
import java.util.Iterator;

public class TestAgriturismiReference {
    public static void main(String[] args) {
        try {
            ElencoAgriturismi elenco = ElencoAgriturismi.carica("C:\\Users\\cerlo\\OneDrive - Università di Salerno\\CARLO\\Codici\\JAVA\\AssignmentConcurrency\\src\\main\\resources\\gruppoG22\\Agriturismi-Napoli.csv");

            elenco.aggiorna(TestAgriturismiReference::aggiornaPernottamento);

            elenco.aggiorna(TestAgriturismiReference::aggiornaCamping);

            Iterator<String> comuni = elenco.esporta(Agriturismo::getComune).iterator();
            System.out.println("Comuni con agriturismi: ");
            while (comuni.hasNext())
                System.out.println("- " + comuni.next());

            int postiLettoGragnano = elenco.somma(TestAgriturismiReference::getPostiLettoGragnano);
            System.out.println("\n\nPosti letto complessivi a Gragnano:\n" + postiLettoGragnano);

            elenco.ordina(Comparator.comparing(Agriturismo::getDenominazione));
            System.out.println("\nElenco ordinato per denominazione:\n" + elenco);

        } catch (IOException e) {
            System.err.println("Errore nella lettura del file: " + e.getMessage());
        }
    }

    private static int getPostiLettoGragnano(Agriturismo a) {
        if (a.getComune().equalsIgnoreCase("Gragnano"))
            return a.getPostiLetto();
        return 0;
    }

    private static void aggiornaPernottamento(Agriturismo a) {
        a.setPernottamento(a.getPostiLetto() > 0);
    }

    private static void aggiornaCamping(Agriturismo a) {
        a.setCamping(a.getPostiTenda() > 0 || a.getPostiRoulotte() > 0);
    }
}