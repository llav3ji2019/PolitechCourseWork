package com.example.course;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.example.course.lab5.SteamHandler;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.image.ImageView;

public class Lab5Controller {
    private static final Map<Integer, String> DEFAULT_DATA_FOR_FUNCTION = new HashMap<>();
    private static final Map<Integer, String> TYPES_FOR_FUNCTION_INPUT = new HashMap<>();
    private static final Map<Integer, String> DESCRIPTION_FOR_FUNCTION = new HashMap<>();

    static {
        DEFAULT_DATA_FOR_FUNCTION.put(1, "5 55 100 6");
        DEFAULT_DATA_FOR_FUNCTION.put(2, "AAAA bbbb aBc CdC");
        DEFAULT_DATA_FOR_FUNCTION.put(3, "1 1 2 3 4 4 4");
        DEFAULT_DATA_FOR_FUNCTION.put(4, "aaa acc abc dssa berb");
        DEFAULT_DATA_FOR_FUNCTION.put(5, "aaa acc abc dssa berb");
        DEFAULT_DATA_FOR_FUNCTION.put(6, "5 55 100 6");
        DEFAULT_DATA_FOR_FUNCTION.put(7, "aaa acc abc dssa berffffb");

        TYPES_FOR_FUNCTION_INPUT.put(1, "Only Integer type is allowed");
        TYPES_FOR_FUNCTION_INPUT.put(2, "Only String type is allowed");
        TYPES_FOR_FUNCTION_INPUT.put(3, "Only Numeric types are allowed");
        TYPES_FOR_FUNCTION_INPUT.put(4, "Only String type is allowed");
        TYPES_FOR_FUNCTION_INPUT.put(5, "You can use all types");
        TYPES_FOR_FUNCTION_INPUT.put(6, "Only Integer type is allowed");
        TYPES_FOR_FUNCTION_INPUT.put(7, "You can use all types");

        DESCRIPTION_FOR_FUNCTION.put(1, "A method that returns the average value of a list of integers");
        DESCRIPTION_FOR_FUNCTION.put(2, "A method that converts all the lines in the list to uppercase and adds the prefix \"_new_\" to them");
        DESCRIPTION_FOR_FUNCTION.put(3, "A method that returns a list of squares of all the elements of the list that occur only once");
        DESCRIPTION_FOR_FUNCTION.put(4, "A method that accepts a collection of strings as input and returns all strings starting with a given letter, sorted alphabetically");
        DESCRIPTION_FOR_FUNCTION.put(5, "A method that accepts a collection as input and returns its last element or throws an exception if the collection is empty");
        DESCRIPTION_FOR_FUNCTION.put(6, "A method that accepts an array of integers as input, returning the sum of even numbers or 0 if there are no even numbers");
        DESCRIPTION_FOR_FUNCTION.put(7, "A method that converts all the rows in the list to Map, where the first character is the key, the remaining ones are the value");
    }

    @FXML
    private TextArea descriptionField;

    @FXML
    private Button executeBtn;

    @FXML
    private ChoiceBox<String> functionNumber;

    @FXML
    private ImageView homeBtn;

    @FXML
    private Label hintForInput;

    @FXML
    private TextArea inputDataFromUser;

    private static final List<String> VARIANTS = new ArrayList<>();

    static {
        VARIANTS.add("function № 1");
        VARIANTS.add("function № 2");
        VARIANTS.add("function № 3");
        VARIANTS.add("function № 4");
        VARIANTS.add("function № 5");
        VARIANTS.add("function № 6");
        VARIANTS.add("function № 7");
    }

    @FXML
    private TextArea outputLabel;

    @FXML
    public void initialize() {
        setUpFunctionNumber();
        outputLabel.setText(" ");
        functionNumber.setOnAction(e -> {
            outputLabel.setText(" ");
            int variantNumber = convertVariant(functionNumber.getValue());
            String currentDefaultData = DEFAULT_DATA_FOR_FUNCTION.getOrDefault(variantNumber, " ");
            inputDataFromUser.setText(currentDefaultData);
            descriptionField.setText(DESCRIPTION_FOR_FUNCTION.getOrDefault(variantNumber, " "));
        });

        homeBtn.setOnMouseClicked(SwitcherController::switchToHome);

        executeBtn.setOnAction(e -> {
            outputLabel.setText("");
            int variantNumber = convertVariant(functionNumber.getValue());
            outputLabel.setText(SteamHandler.start(variantNumber, inputDataFromUser.getText()));
        });

    }

    private int convertVariant(String variantString) {
        String stringNumberOfVariant = variantString.split(" ")[2];
        return Integer.parseInt(stringNumberOfVariant);
    }

    private void setUpFunctionNumber(){
        functionNumber.getItems().addAll(VARIANTS);
        functionNumber.setValue(VARIANTS.get(0));
        inputDataFromUser.setText(DEFAULT_DATA_FOR_FUNCTION.getOrDefault(1, " "));
        hintForInput.setText(TYPES_FOR_FUNCTION_INPUT.getOrDefault(1, "No rules are required"));
        descriptionField.setText(DESCRIPTION_FOR_FUNCTION.getOrDefault(1, " "));
    }
}
