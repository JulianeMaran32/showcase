package com.juhmaran.showcase.exceptions.runtime;

public class CustomerNotLoggedInException extends RuntimeException {

    public CustomerNotLoggedInException() {
    }

    public CustomerNotLoggedInException(String message) {
        super(message);
    }
}
