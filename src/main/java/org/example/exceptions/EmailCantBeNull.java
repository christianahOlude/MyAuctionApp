package org.example.exceptions;

public class EmailCantBeNull extends RuntimeException {
    public EmailCantBeNull(String message) {
        super(message);
    }
}
