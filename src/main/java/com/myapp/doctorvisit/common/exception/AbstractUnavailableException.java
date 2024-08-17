package com.myapp.doctorvisit.common.exception;

import org.springframework.http.HttpStatus;

public abstract class AbstractUnavailableException extends AbstractException {
    @Override
    public HttpStatus getStatus() {
        return HttpStatus.SERVICE_UNAVAILABLE;
    }
}
