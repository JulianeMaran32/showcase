package com.juhmaran.showcase.exceptions.runtime;

public class DocumentNumberAlreadyExistsException extends RuntimeException {

    public DocumentNumberAlreadyExistsException() {
        super();
    }

    public DocumentNumberAlreadyExistsException(String message) {
        super(message);
    }

}
