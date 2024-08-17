package com.myapp.doctorvisit.common.exception;

import org.springframework.http.HttpStatus;

public abstract class AbstractUnAuthorizedException  extends AbstractException {

    public HttpStatus getStatus() {
        return HttpStatus.UNAUTHORIZED;
    }
}
