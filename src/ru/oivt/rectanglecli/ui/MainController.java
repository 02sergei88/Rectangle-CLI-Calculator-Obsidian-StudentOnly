package ru.oivt.rectanglecli.ui;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class MainController {

    @FXML private TextField fieldA;
    @FXML private TextField fieldB;
    @FXML private Label resultLabel;

    @FXML
    private void onPerimeter() {
        resultLabel.setText("Периметр: (пока заглушка)");
    }

    @FXML
    private void onArea() {
        resultLabel.setText("Площадь: (пока заглушка)");
    }

    @FXML
    private void onDiagonal() {
        resultLabel.setText("Диагональ: (пока заглушка)");
    }
}