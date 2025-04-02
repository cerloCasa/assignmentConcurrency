package gruppoG22;

import java.util.*;
import java.util.function.*;
import java.util.stream.Collectors;
import java.io.*;

public class ElencoAgriturismi {
    private final List<Agriturismo> agriturismi;

    public ElencoAgriturismi() {
        this.agriturismi = new ArrayList<>();
    }

    public void aggiungi(Agriturismo a) {
        agriturismi.add(a);
    }

    public <T> Set<T> esporta(Function<Agriturismo, T> mapper) {
        return agriturismi.stream().map(mapper).collect(Collectors.toSet());
    }

    public List<Agriturismo> filtra(Predicate<Agriturismo> criterio) {
        return agriturismi.stream().filter(criterio).toList();
    }

    public void ordina(Comparator<Agriturismo> comparator) {
        agriturismi.sort(comparator);
    }

    public void aggiorna(Consumer<Agriturismo> updateFunction) {
        agriturismi.forEach(updateFunction);
    }

    public int somma(ToIntFunction<Agriturismo> function) {
        return agriturismi.stream().mapToInt(function).sum();
    }

    public static ElencoAgriturismi carica(String nomeFile) throws IOException {
        ElencoAgriturismi elenco = new ElencoAgriturismi();
        try (BufferedReader br = new BufferedReader(new FileReader(nomeFile))) {
            String line;
            br.readLine();
            while ((line = br.readLine()) != null) {
                String[] campi = line.split(";");
                if (campi.length >= 9) {
                    String comune = campi[0];
                    String titolare = campi[1];
                    String denominazione = campi[2];
                    String indirizzo = campi[3];
                    int postiLetto = campi[4].isEmpty() ? 0 : Integer.parseInt(campi[4]);
                    int postiMacchina = campi[5].isEmpty() ? 0 : Integer.parseInt(campi[5]);
                    int postiTenda = campi[6].isEmpty() ? 0 : Integer.parseInt(campi[6]);
                    int postiRoulotte = campi[7].isEmpty() ? 0 : Integer.parseInt(campi[7]);
                    String recapiti = campi[8];

                    elenco.aggiungi(new Agriturismo(comune, titolare, denominazione,
                                                    indirizzo, postiLetto, postiMacchina,
                                                    postiTenda, postiRoulotte, recapiti));
                }
            }
        }
        return elenco;
    }

    @Override
    public String toString() {
        return agriturismi.stream().map(Agriturismo::toString).collect(Collectors.joining("\n"));
    }
}