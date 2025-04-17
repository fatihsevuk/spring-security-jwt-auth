package com.fatihsevuk.springsecurityjwtauth.util.exception;

public class InvalidTokenException extends RuntimeException {
    public InvalidTokenException(String message) {
        super(message); // Passing the message to the parent RuntimeException
    }
}
