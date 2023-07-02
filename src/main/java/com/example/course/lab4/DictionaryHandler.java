package com.example.course.lab4;

import java.io.File;

public class DictionaryHandler {
    private static final File PATH_DICT = new File("dictionary.txt");
    private static final File PATH_TEXT = new File("text.txt");

    public static String start(final File dictionaryPath, final File textFile) {
        StringBuilder result = new StringBuilder();
        try {
            Dictionary myDictionary = new Dictionary(dictionaryPath);
            Translator myTranslator = new Translator(myDictionary, textFile);
            for (var el: myTranslator.getTranslatedText()) {
                if (!el.contains(".")) {
                    result.append(el).append(" ");
                }
                else {
                    result.append("\n");
                    result.append(el).append(" ");
                }
            }
        } catch (InvalidFileFormatException | FileReadException | InvalidDataException e) {
            result.append(e.getMessage()).append("\n");
        }
        return result.toString();
    }
}
