package com.github.grizzly.exceptions.user;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.UNAUTHORIZED, reason = "Login not found in database")
public class LoginNotFoundException extends RuntimeException {

    public LoginNotFoundException() {
    }

    public LoginNotFoundException(String message) {
        super(message);
    }

    public LoginNotFoundException(Throwable cause) {
        super(cause);
    }
}
