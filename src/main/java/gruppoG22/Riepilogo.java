package gruppoG22;

import java.util.List;
import java.util.ArrayList;

public class Riepilogo {
    private final List<NumericQuestionAttempt> tentativi = new ArrayList<>();
    private final List<NumericQuestion> domande = new ArrayList<>();
    private int numeroDomande;

    public void setNumeroDomande(int numeroDomande) {
        if (numeroDomande <= 0)
            throw new NumberFormatException("Scegliere un valore intero positivo.");
        this.numeroDomande = numeroDomande;
    }

    public List<NumericQuestion> getDomande() {
        return domande;
    }

    public int getNumeroDomande() {
        return numeroDomande;
    }

    public void generaDomanda() {
        NumericQuestion question = new NumericQuestion();
        question.randomInit();
        domande.add(question);
    }

    public void aggiungiTentativo(NumericQuestionAttempt tentativo) {
        tentativi.add(tentativo);
    }
}