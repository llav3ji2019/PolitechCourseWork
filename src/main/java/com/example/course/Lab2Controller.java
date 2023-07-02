package com.example.course;

import com.example.course.lab2.AnalyserHandler;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.image.ImageView;

public class Lab2Controller {

    @FXML
    private Button executeBtn;

    @FXML
    private TextArea outputLabel;

    @FXML
    private ImageView homeBtn;

    @FXML
    public void initialize() {
        outputLabel.setText("");
        executeBtn.setOnAction(e -> {
            outputLabel.setText(AnalyserHandler.start());
        });
        homeBtn.setOnMouseClicked(SwitcherController::switchToHome);
    }
}
