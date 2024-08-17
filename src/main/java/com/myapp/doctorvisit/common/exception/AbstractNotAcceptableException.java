package com.myapp.doctorvisit.common.exception;

import org.springframework.http.HttpStatus;

import static org.springframework.http.HttpStatus.NOT_ACCEPTABLE;

public abstract class AbstractNotAcceptableException extends AbstractException {
    public HttpStatus getStatus() {
        return NOT_ACCEPTABLE;
    }
}
