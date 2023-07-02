package com.example.course.lab6;

import static com.example.course.lab6.Program.getResult;
import static com.example.course.lab6.Program.getState;
import static java.lang.Thread.sleep;

public class ProgramHandler {
    public static String start() {
        new Thread(new Program.Supervisor()).start();
        try {
            while (getState() != State.FATAL_ERROR) {
                sleep(1000);
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return getResult();
    }
}
