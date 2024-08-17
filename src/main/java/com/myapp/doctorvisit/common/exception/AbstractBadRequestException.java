package com.myapp.doctorvisit.common.exception;

import org.springframework.http.HttpStatus;

public abstract class AbstractBadRequestException extends AbstractException {
    public HttpStatus getStatus() {
        return HttpStatus.BAD_REQUEST;
    }
}
