package com.github.grizzly.exceptions.user;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.UNAUTHORIZED, reason = "Phone not found in database")
public class PhoneNotFoundException extends RuntimeException {

    public PhoneNotFoundException() {
    }

    public PhoneNotFoundException(String message) {
        super(message);
    }

    public PhoneNotFoundException(Throwable cause) {
        super(cause);
    }
}
