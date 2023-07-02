package com.example.course;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.example.course.lab1.HeroHandler;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ContentDisplay;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.image.ImageView;
import javafx.scene.control.ChoiceBox;

public class Lab1Controller {
    private static final String METHOD_COMMAND = "method";
    private static final String POSITION_COMMAND = "position";
    private static final List<String> COMMAND_VARIANTS = new ArrayList<>();
    private static final List<String> METHOD_VARIANTS = new ArrayList<>();
    private static final Map<String, String> PERSON_MOVEMENT = new HashMap<>();

    static {
        PERSON_MOVEMENT.put("walk", "Walker");
        PERSON_MOVEMENT.put("ride", "Rider");
        PERSON_MOVEMENT.put("drive", "Driver");

        COMMAND_VARIANTS.add("method");
        COMMAND_VARIANTS.add("position");
        COMMAND_VARIANTS.add("move");

        METHOD_VARIANTS.add("walk");
        METHOD_VARIANTS.add("ride");
        METHOD_VARIANTS.add("drive");
    }

    @FXML
    private Button executeBtn;

    @FXML
    private TextArea outputLabel;

    @FXML
    private Label methodLbl;

    @FXML
    private Label methodOfMovementLbl;

    @FXML
    private Label positionCounterLbl;

    @FXML
    private ImageView homeBtn;

    @FXML
    private ChoiceBox<String> commandSelection;

    @FXML
    private ChoiceBox<String> methodSelection;

    @FXML
    public void initialize() {
        setUpChoiceBoxes();
        positionCounterLbl.setContentDisplay(ContentDisplay.TOP);
        outputLabel.setText("");
        executeBtn.setOnAction(e -> {
            String argument = commandSelection.getValue();
            if (argument.equals(METHOD_COMMAND)) {
                argument += " " + methodSelection.getValue();
            }
            outputLabel.setText(HeroHandler.start(argument));
            if (!argument.equals(POSITION_COMMAND)) {
                String[] counterData = HeroHandler.start(POSITION_COMMAND).split(" ");
                positionCounterLbl.setText(counterData[counterData.length - 1]);
            }
            commandSelection.setValue(COMMAND_VARIANTS.get(2));
            setMethodElementsVisibility(false);
        });
        homeBtn.setOnMouseClicked(SwitcherController::switchToHome);
    }

    private void setMethodElementsVisibility(boolean visibility){
        methodSelection.setVisible(visibility);
        methodLbl.setVisible(visibility);
    }

    private void updateMethodOfMovement() {
        methodOfMovementLbl.setText(PERSON_MOVEMENT.getOrDefault(methodSelection.getValue(), "Who are you?"));
    }

    private void setUpChoiceBoxes(){
        commandSelection.getItems().addAll(COMMAND_VARIANTS);
        methodSelection.getItems().addAll(METHOD_VARIANTS);
        commandSelection.setValue(COMMAND_VARIANTS.get(0));
        methodSelection.setValue(METHOD_VARIANTS.get(0));
        updateMethodOfMovement();
        commandSelection.setOnAction(e -> {
            boolean shouldBeVisible = commandSelection.getValue().equals(METHOD_COMMAND);
            setMethodElementsVisibility(shouldBeVisible);
        });

        methodSelection.setOnAction(e -> updateMethodOfMovement());
    }
}
