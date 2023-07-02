package com.example.course.lab1;

public class HeroHandler {
    private static final Hero MY_PERSON = new Hero();
    private static final String COMMAND_ERROR = "Incorrect command, try again";

    public static String start(String command) {
        String result = "";
        String[] arguments = command.split(" ");
        if (arguments.length == 0 || arguments.length > 2) {
            return COMMAND_ERROR;
        }
        switch (arguments[0]) {
            case "method" -> {
                if (arguments.length != 2) {
                    return COMMAND_ERROR;
                }
                MY_PERSON.setMethodOfMovement(arguments[1]);
                result = "Hero has changed his method of movement";
            }
            case "position" -> {
                if (arguments.length != 1) {
                    return COMMAND_ERROR;
                }
                result = "Hero position is " + MY_PERSON.getPosition();
            }
            case "move" -> {
                if (arguments.length != 1) {
                    return COMMAND_ERROR;
                }
                MY_PERSON.move();
                result = "Hero has changed his position";
            }
            default -> {
                return COMMAND_ERROR;
            }
        }
        return result;
    }
}
