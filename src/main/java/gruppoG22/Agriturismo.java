package gruppoG22;

public class Agriturismo {
    private String comune;
    private String titolare;
    private String denominazione;
    private String indirizzo;
    private int postiLetto;
    private int postiMacchina;
    private int postiTenda;
    private int postiRoulotte;
    private String recapiti;
    private boolean pernottamento;
    private boolean camping;

    public Agriturismo(String comune, String titolare, String denominazione, String indirizzo,
                       int postiLetto, int postiMacchina, int postiTenda, int postiRoulotte,
                       String recapiti) {
        this.comune = comune;
        this.titolare = titolare;
        this.denominazione = denominazione;
        this.indirizzo = indirizzo;
        this.postiLetto = postiLetto;
        this.postiMacchina = postiMacchina;
        this.postiTenda = postiTenda;
        this.postiRoulotte = postiRoulotte;
        this.recapiti = recapiti;
        this.pernottamento = postiLetto > 0;
        this.camping = postiTenda > 0 || postiRoulotte > 0;
    }

    public String getComune() { return comune; }
    public void setComune(String comune) { this.comune = comune; }
    public String getTitolare() { return titolare; }
    public void setTitolare(String titolare) { this.titolare = titolare; }
    public String getDenominazione() { return denominazione; }
    public void setDenominazione(String denominazione) { this.denominazione = denominazione; }
    public String getIndirizzo() { return indirizzo; }
    public void setIndirizzo(String indirizzo) { this.indirizzo = indirizzo; }
    public int getPostiLetto() { return postiLetto; }
    public void setPostiLetto(int postiLetto) { this.postiLetto = postiLetto; }
    public int getPostiMacchina() { return postiMacchina; }
    public void setPostiMacchina(int postiMacchina) { this.postiMacchina = postiMacchina; }
    public int getPostiTenda() { return postiTenda; }
    public void setPostiTenda(int postiTenda) { this.postiTenda = postiTenda; }
    public int getPostiRoulotte() { return postiRoulotte; }
    public void setPostiRoulotte(int postiRoulotte) { this.postiRoulotte = postiRoulotte; }
    public String getRecapiti() { return recapiti; }
    public void setRecapiti(String recapiti) { this.recapiti = recapiti; }
    public boolean isPernottamento() { return pernottamento; }
    public void setPernottamento(boolean pernottamento) { this.pernottamento = pernottamento; }
    public boolean isCamping() { return camping; }
    public void setCamping(boolean camping) { this.camping = camping; }

    @Override
    public String toString() {
        return "***\n" + denominazione.toUpperCase() + " di " + titolare.toUpperCase() + "\n\n" +
                indirizzo + "\n" + comune + "\n" +
                (camping ? "\nDisponibile area camping" : "") +
                (pernottamento ? "\nDisponibili camere pernottamento" : "") +
                (recapiti.equals("nd") ? "" : "\n" + recapiti);
    }
}