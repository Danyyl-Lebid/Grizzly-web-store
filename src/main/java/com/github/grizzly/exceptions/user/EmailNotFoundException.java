package com.github.grizzly.exceptions.user;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.UNAUTHORIZED, reason = "Email not found in database")
public class EmailNotFoundException extends RuntimeException {

    public EmailNotFoundException() {
    }

    public EmailNotFoundException(String message) {
        super(message);
    }

    public EmailNotFoundException(Throwable cause) {
        super(cause);
    }
}
