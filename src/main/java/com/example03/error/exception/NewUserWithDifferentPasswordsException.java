package com.example03.error.exception;

public class NewUserWithDifferentPasswordsException extends RuntimeException {

    public NewUserWithDifferentPasswordsException() {
        super("Passwords do not match");
    }
}
