package com.example.course.lab3;

import java.util.ArrayList;
import java.util.List;

public class AnimalHandler {
    public static String start(int functionVariant) {
        return switch (functionVariant) {
            case 0 -> startThirdVariant();
            case 1 -> startFirstVariant();
            case 2 -> startSecondVariant();
            default -> "Something go wrong";
        };
    }

    private static String startFirstVariant() {
        List<Mammals> srcList1 = new ArrayList<>();
        srcList1.add(new Lynx("a", 1));
        srcList1.add(new Lynx("b", 2));
        srcList1.add(new Lynx("c", 3));
        srcList1.add(new Manul("d", 4));
        srcList1.add(new Manul("e", 5));
        srcList1.add(new CommonHedgehog("f", 6));
        srcList1.add(new CommonHedgehog("g", 7));
        srcList1.add(new CommonHedgehog("h", 8));
        srcList1.add(new CommonHedgehog("i", 9));

        List<Hedgehogs> collection11 = new ArrayList<>();
        List<Feline> collection21 = new ArrayList<>();
        List<Predatory> collection31 = new ArrayList<>();
        segregate(srcList1, collection11, collection21, collection31);
        return String.format("%20s%12s%20s\n", "CommonHedgehogSize", "ManulSize", "CommonHedgehogSize") +
                String.format("%20d%30d%20d\n", collection11.size(), collection21.size(), collection31.size());
    }

    private static String startSecondVariant() {
        List<Predatory> srcList2 = new ArrayList<>();
        srcList2.add(new Lynx("a", 1));
        srcList2.add(new Lynx("b", 2));
        srcList2.add(new Lynx("c", 3));
        srcList2.add(new Manul("d", 4));
        srcList2.add(new Manul("e", 5));
        List<Chordal> collection12 = new ArrayList<>();
        List<Manul> collection22 = new ArrayList<>();
        List<Feline> collection32 = new ArrayList<>();
        segregate(srcList2, collection12, collection22, collection32);
        return String.format("%12s%10s%11s\n", "ChordalSize", "ManulSize", "FelineSize")
                + String.format("%12d%18d%12d\n", collection12.size(), collection22.size(), collection32.size());
    }

    private static String startThirdVariant() {
        List<Hedgehogs> srcList3 = new ArrayList<>();
        srcList3.add(new CommonHedgehog("f", 6));
        srcList3.add(new CommonHedgehog("g", 7));
        srcList3.add(new CommonHedgehog("e", 8));
        srcList3.add(new CommonHedgehog("i", 9));
        List<Insectivorous> collection13 = new ArrayList<>();
        List<Predatory> collection23 = new ArrayList<>();
        List<Predatory> collection33 = new ArrayList<>();
        segregate(srcList3, collection13, collection23, collection33);
        return String.format("%18s%15s%15s\n", "InsectivorousSize", "PredatorySize", "PredatorySize")
                + String.format("%18d%25d%25d\n", collection13.size(), collection23.size(), collection33.size());
    }

    private static void segregate(List<? extends Mammals> srcCollection, List<? super Hedgehogs> collection1, List<? super Manul> collection2, List<? super Feline> collection3) {
        for (Mammals animal : srcCollection) {
            if (animal instanceof CommonHedgehog) {
                collection1.add((CommonHedgehog) animal);
            } else if (animal instanceof Manul) {
                collection2.add((Manul) animal);
            } else if (animal instanceof Lynx) {
                collection3.add((Feline) animal);
            } else {
                throw new IllegalArgumentException();
            }
        }
    }
}
