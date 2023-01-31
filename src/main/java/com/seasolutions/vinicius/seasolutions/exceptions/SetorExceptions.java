package com.seasolutions.vinicius.seasolutions.exceptions;

public class SetorExceptions extends Exception {

    private String message;

    public SetorExceptions(String message) {
        super(message);
        this.message = message;
    }

    @Override
    public String getMessage() {
        return message;
    }
}
