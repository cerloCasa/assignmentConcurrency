package gruppoG22;

import java.util.List;
import java.util.ArrayList;

public class Riepilogo {
    private final List<NumericQuestionAttempt> tentativi = new ArrayList<>();
    private int numeroDomande;

    public void setNumeroDomande(int numeroDomande) {
        if (numeroDomande <= 0)
            throw new NumberFormatException("Scegliere un valore intero positivo.");
        this.numeroDomande = numeroDomande;
    }

    public int getNumeroDomande() {
        return numeroDomande;
    }

    public void aggiungiTentativo(NumericQuestionAttempt tentativo) {
        tentativi.add(tentativo);
    }
}