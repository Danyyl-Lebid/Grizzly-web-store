package com.github.grizzly.exceptions.user;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.CONFLICT, reason = "There is already database")
public class DuplicatedDataException extends RuntimeException {

    public DuplicatedDataException() {
    }

    public DuplicatedDataException(String message) {
        super(message);
    }

    public DuplicatedDataException(Throwable cause) {
        super(cause);
    }
}
