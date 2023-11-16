package com.juhmaran.showcase.exceptions.runtime;

public class CustomerNotActiveException extends RuntimeException {

    public CustomerNotActiveException() {
        super();
    }

    public CustomerNotActiveException(String message) {
        super(message);
    }
}
