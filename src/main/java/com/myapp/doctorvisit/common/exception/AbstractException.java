package com.myapp.doctorvisit.common.exception;

import org.springframework.http.HttpStatus;

public abstract class AbstractException extends RuntimeException {

    public String[] getLocalArgs() {
        return new String[0];
    }

    public abstract String getMessage();

    public abstract HttpStatus getStatus();
}
