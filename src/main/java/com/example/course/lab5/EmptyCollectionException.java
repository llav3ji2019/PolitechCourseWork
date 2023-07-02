package com.example.course.lab5;

public class EmptyCollectionException extends Exception {
    public EmptyCollectionException() {
        super();
    }

    public EmptyCollectionException(String message) {
        super(message);
    }
}
