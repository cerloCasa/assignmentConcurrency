module myMathQuiz {
    requires javafx.controls;
    requires javafx.fxml;


    opens gruppoG22 to javafx.fxml;
    exports gruppoG22;
}