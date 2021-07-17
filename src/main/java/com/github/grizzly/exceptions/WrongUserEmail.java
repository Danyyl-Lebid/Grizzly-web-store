package com.github.grizzly.exceptions;

public class WrongUserEmail extends RuntimeException{
    public WrongUserEmail() {
    }

    public WrongUserEmail(String message) {
        super(message);
    }

    public WrongUserEmail(Throwable cause) {
        super(cause);
    }
}
