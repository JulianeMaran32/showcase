package com.juhmaran.showcase.exceptions.runtime;

public class DocumentNumberCannotBeNullException extends RuntimeException {

    public DocumentNumberCannotBeNullException() {
    }

    public DocumentNumberCannotBeNullException(String message) {
        super(message);
    }
}
