package org.example.exceptions;

public class InvalidInput extends RuntimeException {
    public InvalidInput(String message) {
        super(message);
    }
}
