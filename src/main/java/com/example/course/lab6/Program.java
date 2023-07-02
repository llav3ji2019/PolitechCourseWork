package com.example.course.lab6;

import static com.example.course.lab6.Utils.generateRandomState;
import static com.example.course.lab6.Utils.pause;

public class Program {
    private static final String DAEMON_STATE_MESSAGE = "Daemon state is ";
    private static final String ABSTRACT_PROGRAM_STARTED_MESSAGE = "Abstract program and Demon have been started";
    private static final String SUPERVISOR_STARTED_MESSAGE = "Supervisor started";
    private static final String SUPERVISOR_RUNNING_MESSAGE = "Supervisor is running";
    private static final String SUPERVISOR_REBOOT_MESSAGE = "Supervisor has been rebooted";
    private static final String SUPERVISOR_INTERRUPT_MESSAGE = "Supervisor has been interrupted";
    private static State state = State.UNKNOWN;
    private static final Object LOCK = new Object();
    private static final Thread ABSTRACT_PROGRAM_THREAD = new Thread(new AbstractProgram());

    private static final StringBuffer RESULT = new StringBuffer();

    public static String getResult() {
        return RESULT.toString();
    }

    public static State getState() {
        return state;
    }

    static class AbstractProgram implements Runnable {

        @Override
        public void run() {
            Thread daemon = new Thread(() -> {
                while (!ABSTRACT_PROGRAM_THREAD.isInterrupted()) {
                    pause(1000, 5000);
                    synchronized (LOCK) {
                        state = state != State.UNKNOWN ? generateRandomState() : state;
                        RESULT.append(DAEMON_STATE_MESSAGE).append(state).append("\n");
                        LOCK.notify();
                    }
                }
            });
            daemon.setDaemon(true);
            daemon.start();
            RESULT.append(ABSTRACT_PROGRAM_STARTED_MESSAGE + "\n");
        }
    }

    static class Supervisor implements Runnable {

        @Override
        public void run() {
            RESULT.append(SUPERVISOR_STARTED_MESSAGE + "\n");
            ABSTRACT_PROGRAM_THREAD.start();
            while (!ABSTRACT_PROGRAM_THREAD.isInterrupted()) {
                synchronized (LOCK) {
                    try {
                        LOCK.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    switch (state) {
                        case FATAL_ERROR -> interruptProgram();
                        case UNKNOWN, STOPPING -> rebootProgram();
                        default -> RESULT.append(SUPERVISOR_RUNNING_MESSAGE + "\n");
                    }
                }
            }
        }

        private void rebootProgram() {
            state = State.RUNNING;
            RESULT.append(SUPERVISOR_REBOOT_MESSAGE + "\n");
        }

        private void interruptProgram() {
            ABSTRACT_PROGRAM_THREAD.interrupt();
            RESULT.append(SUPERVISOR_INTERRUPT_MESSAGE + "\n");
        }
    }
}
