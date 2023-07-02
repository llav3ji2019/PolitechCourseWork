package com.example.course.lab5;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import static com.example.course.lab5.Functions.changeCollection1;
import static com.example.course.lab5.Functions.changeStringList;
import static com.example.course.lab5.Functions.getAverageFromIntegerList;
import static com.example.course.lab5.Functions.getLastItem;
import static com.example.course.lab5.Functions.getSquaredFromIntegerList;
import static com.example.course.lab5.Functions.getSumOfEvenNumbers;
import static com.example.course.lab5.Functions.sortStringList;

public class SteamHandler {
    public static String start(int functionNumber, String input) {
        try {
            return switch (functionNumber) {
                case 1 -> getFirstFunctionResult(input);
                case 2 -> getSecondFunctionResult(input);
                case 3 -> getThirdFunctionResult(input);
                case 4 -> getFourthFunctionResult(input);
                case 5 -> getFifthFunctionResult(input);
                case 6 -> getSixthFunctionResult(input);
                case 7 -> getSeventhFunctionResult(input);
                default -> "Something went wrong";
            };
        }
        catch (WrongTypeException e) {
            return e.getMessage();
        }
    }

    private static String getFirstFunctionResult(String input) throws WrongTypeException {
        StringBuilder result = new StringBuilder();
        try {
            final List<Integer> listWithIntegers = Arrays.stream(input.split(" "))
                    .map(Integer::parseInt).toList();
            result.append("Part 1: ").append(getAverageFromIntegerList(listWithIntegers)).append("\n");
        }
        catch (NumberFormatException  e) {
            throw new WrongTypeException("Invalid type");
        }
        return result.toString();
    }

    private static String getSecondFunctionResult(String input) {
        StringBuilder result = new StringBuilder();
        final List<String> listWithStrings = Arrays.stream(input.split(" "))
                .collect(Collectors.toList());
        result.append("Part 2: ").append(changeStringList(listWithStrings)).append("\n");
        return result.toString();
    }

    private static String getThirdFunctionResult(String input) throws WrongTypeException {
        StringBuilder result = new StringBuilder();
        try {
            final List<Double> listWithIntegers2 =
                    Arrays.stream(input.split(" "))
                            .map(Double::parseDouble)
                            .collect(Collectors.toList());
            result.append("Part 3: ").append(getSquaredFromIntegerList(listWithIntegers2)).append("\n");
        }
        catch (NumberFormatException  e) {
            throw new WrongTypeException("Invalid type");
        }
        return result.toString();
    }

    private static String getFourthFunctionResult(String input) {
        StringBuilder result = new StringBuilder();
        String[] data = input.split(" ");
        final Collection<String> listWithStrings2 = new ArrayList<>();
        Collections.addAll(listWithStrings2, data);
        result.append("Part 4: ").append(sortStringList(listWithStrings2, 'a')).append("\n");
        return result.toString();
    }

    private static String getFifthFunctionResult(String input) {
        StringBuilder result = new StringBuilder();
        final Collection<String> listWithStrings3 = new ArrayList<>(Arrays.asList(input.split(" ")));
        try {
            result.append("Part 5: ").append(getLastItem(listWithStrings3)).append("\n");
        } catch (EmptyCollectionException e) {
            result.append("Part 5: Collection is empty\n");
        }
        return result.toString();
    }

    private static String getSixthFunctionResult(String input) throws WrongTypeException {
        String[] data = input.split(" ");
        final int[] listWithIntegers3 = new int[data.length];
        try {
            for (int i = 0; i < data.length; i++) {
                listWithIntegers3[i] = Integer.parseInt(data[i]);
            }
        }
        catch (NumberFormatException  e) {
            throw new WrongTypeException("Invalid type");
        }
        return "Part 6: " + getSumOfEvenNumbers(listWithIntegers3);
    }

    private static String getSeventhFunctionResult(String input) {
        StringBuilder result = new StringBuilder();
        final List<String> listWithStrings5 = Arrays.stream(input.split(" "))
                .collect(Collectors.toList());
        Map<Character, List<String>> b = changeCollection1(listWithStrings5);
        result.append("Part 7:\n");
        for (Map.Entry<Character, List<String>> el : b.entrySet()) {
            result.append(el.getKey()).append(" ").append(el.getValue()).append("\n");
        }
        return result.toString();
    }
}
