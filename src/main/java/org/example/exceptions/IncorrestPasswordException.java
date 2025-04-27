package org.example.exceptions;

public class IncorrestPasswordException extends RuntimeException {
    public IncorrestPasswordException(String message) {
        super(message);
    }
}
