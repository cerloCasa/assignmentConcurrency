package gruppoG22;

public class Utente {
    private final String nome;
    private final String cognome;

    public Utente(String nome, String cognome) {
        if (!isValido(nome))
            throw new IllegalArgumentException("Il nome non è valido");
        if (!isValido(cognome))
            throw new IllegalArgumentException("Il cognome non è valido");
        this.nome = nome;
        this.cognome = cognome;
    }

    public String getNome() {
        return nome;
    }

    public String getCognome() {
        return cognome;
    }

    private boolean isValido(String s) {
        if (s == null || s.trim().isEmpty()) return false;
        if (s.length() < 2 || s.length() > 12) return false;
        return s.matches("[A-Za-zÀ-ÖØ-öø-ÿ' -]+");
    }

    public String toString() {
        return nome + " " + cognome;
    }

}