package com.myapp.doctorvisit.common.exception;

import org.springframework.http.HttpStatus;

public abstract class AbstractNotFoundException extends AbstractException {
    public HttpStatus getStatus() {
        return HttpStatus.NOT_FOUND;
    }
}
