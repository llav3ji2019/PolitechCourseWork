package com.example.course;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.example.course.lab3.AnimalHandler;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TextArea;
import javafx.scene.image.ImageView;

public class Lab3Controller {
    private static final Map<Integer, String> VARIANT_DATA_INFO = new HashMap<>();

    static {
        VARIANT_DATA_INFO.put(0, getFirstVariantDataInfo());
        VARIANT_DATA_INFO.put(1, getSecondVariantDataInfo());
        VARIANT_DATA_INFO.put(2, getThirdVariantDataInfo());
    }

    @FXML
    private TextArea  dataLabel;

    @FXML
    private Button executeBtn;

    @FXML
    private TextArea outputLabel;

    @FXML
    private ChoiceBox<String> funcVariant;

    private static final List<String> VARIANTS = new ArrayList<>();

    static {
        VARIANTS.add("variant № 1");
        VARIANTS.add("variant № 2");
        VARIANTS.add("variant № 3");
    }

    @FXML
    private ImageView homeBtn;

    @FXML
    public void initialize() {
        funcVariant.getItems().addAll(VARIANTS);
        funcVariant.setValue(VARIANTS.get(0));
        dataLabel.setText(getFirstVariantDataInfo());
        funcVariant.setOnAction(e -> {
            int variantNumber = convertVariant(funcVariant.getValue());
            dataLabel.setText(VARIANT_DATA_INFO.getOrDefault(variantNumber, "Something went wrong"));
        });
        outputLabel.setText("");
        executeBtn.setOnAction(e -> {
            int variantNumber = convertVariant(funcVariant.getValue());
            outputLabel.setText(AnimalHandler.start(variantNumber));
        });
        homeBtn.setOnMouseClicked(SwitcherController::switchToHome);
    }

    private int convertVariant(String variantString) {
        String stringNumberOfVariant = variantString.split(" ")[2];
        return Integer.parseInt(stringNumberOfVariant) % 3;
    }


    private static String getFirstVariantDataInfo() {
        return "Lynx - 3, Manul - 2, CommonHedgehog - 4\nFunction is segregate(Manuls, Hedgehogs, Feline, Predatory)";
    }

    private static String getSecondVariantDataInfo() {
        return "Lynx - 3, Manul - 2, CommonHedgehog - 0\nFunction is segregate(Predatory, Chordal, Manul, Feline)";
    }

    private static String getThirdVariantDataInfo() {
        return "Lynx - 0, Manul - 0, CommonHedgehog - 4\nFunction is segregate(Hedgehogs, Insectivorous, Predatory, Predatory)";
    }
}
