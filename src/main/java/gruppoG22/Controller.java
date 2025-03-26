package gruppoG22;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.beans.value.ObservableBooleanValue;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.util.Duration;

import java.net.URL;
import java.util.ResourceBundle;
import java.util.concurrent.atomic.AtomicInteger;

public class Controller implements Initializable {
    private Utente utente;
    private Riepilogo riepilogo = new Riepilogo();

    @FXML
    private VBox accountingPane;

    @FXML
    private VBox domandaPane;

    @FXML
    private VBox riepilogoPane;

    @FXML
    private TextField accountingPane_nome;

    @FXML
    private TextField accountingPane_cognome;

    @FXML
    private TextField accountingPane_domande;

    @FXML
    private Button accountingPane_inizio;

    @FXML
    private Label domandaPane_domanda;

    @FXML
    private TextField domandaPane_risposta;

    @FXML
    private Label domandaPane_contatore;

    @FXML
    private Button domandaPane_pulsante;

    @FXML
    private Label domandaPane_timer;

    @FXML
    public void accountingPane_attivaPulsante() {
        ObservableBooleanValue disattivato = accountingPane_nome.textProperty().isEmpty().or(accountingPane_cognome.textProperty().isEmpty().or(accountingPane_domande.textProperty().isEmpty()));
        accountingPane_inizio.disableProperty().setValue(disattivato.get());
    }

    @FXML
    public void accountingPane_creaUtente() {
        try {
            this.utente = new Utente(accountingPane_nome.getText(), accountingPane_cognome.getText());
        } catch (IllegalArgumentException e) {
            new Alert(Alert.AlertType.ERROR, e.getMessage()).showAndWait();
            return;
        }

        try {
            this.riepilogo.setNumeroDomande(Integer.parseInt(accountingPane_domande.getText()));
        } catch (NumberFormatException e) {
            new Alert(Alert.AlertType.ERROR, "Scegliere un valore intero positivo.").showAndWait();
            return;
        }

        accountingPane.setVisible(false);
        domandaPane.setVisible(true);
        domandaPane_iniziaQuiz();
    }

    @FXML
    public void domandaPane_iniziaQuiz() {
        for (int i = 0; i < riepilogo.getNumeroDomande(); i++)
            domandaPane_generaDomanda();
        domandaPane_chiediDomanda();
    }

    @FXML
    private void domandaPane_generaDomanda() {
        riepilogo.generaDomanda();
    }

    @FXML
    public void domandaPane_chiediDomanda() {
        if (riepilogo.getDomande().isEmpty()) {
            domandaPane.setVisible(false);
            riepilogoPane.setVisible(true);
        }

        var domanda = riepilogo.getDomande().getFirst();
        riepilogo.getDomande().removeFirst();

        AtomicInteger tempo = new AtomicInteger(7);
        Timeline timeline = new Timeline(new KeyFrame(Duration.seconds(1), _ -> {
            tempo.getAndDecrement();
            domandaPane_timer.setText("00:" + String.format("%02d", tempo.get()));
            if (tempo.get() == 0) {
                tentativoErrato();
                domandaPane_chiediDomanda();
            }
        }));
        timeline.setCycleCount(7);
        timeline.play();

        domandaPane_domanda.setText(domanda.toString());
    }

    private void tentativoErrato() {
        System.out.println("Errato");
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        accountingPane.setVisible(true);
        domandaPane.setVisible(false);
        riepilogoPane.setVisible(false);
    }

}