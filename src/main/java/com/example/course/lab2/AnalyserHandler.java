package com.example.course.lab2;

public class AnalyserHandler {
    public static String start() {
        MethodAnalyser analyser = new MethodAnalyser();
        return analyser.analyse(new Methods());
    }
}




