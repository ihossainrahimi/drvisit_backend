package com.myapp.doctorvisit.common.exception;

import org.springframework.http.HttpStatus;

public abstract class AbstractConflictException extends AbstractException {
    public HttpStatus getStatus() {
        return HttpStatus.CONFLICT;
    }
}
