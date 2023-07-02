package com.example.course;

import java.io.File;

import com.example.course.lab4.DictionaryHandler;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.image.ImageView;

public class Lab4Controller {
    private static final String PATH_DICT = "C:\\Users\\Pavel\\IdeaProjects\\Politech\\dictionary.txt";
    private static final String PATH_TEXT = "C:\\Users\\Pavel\\IdeaProjects\\Politech\\text.txt";

    @FXML
    private TextArea dictionaryPathInput;

    @FXML
    private Button executeBtn;

    @FXML
    private ImageView homeBtn;

    @FXML
    private TextArea outputLabel;

    @FXML
    private TextArea textPathInput;

    @FXML
    public void initialize() {
        outputLabel.setText("");
        executeBtn.setOnAction(e -> {
            outputLabel.setText(DictionaryHandler.start(new File(dictionaryPathInput.getText()), new File(textPathInput.getText())));
        });
        homeBtn.setOnMouseClicked(SwitcherController::switchToHome);
        dictionaryPathInput.setText(PATH_DICT);
        textPathInput.setText(PATH_TEXT);
    }
}
