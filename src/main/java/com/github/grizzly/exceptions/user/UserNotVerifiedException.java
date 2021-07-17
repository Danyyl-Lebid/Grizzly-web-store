package com.github.grizzly.exceptions.user;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.UNAUTHORIZED, reason = "User not verified")
public class UserNotVerifiedException extends RuntimeException{

    public UserNotVerifiedException() {
    }

    public UserNotVerifiedException(String message) {
        super(message);
    }

    public UserNotVerifiedException(Throwable cause) {
        super(cause);
    }
}
