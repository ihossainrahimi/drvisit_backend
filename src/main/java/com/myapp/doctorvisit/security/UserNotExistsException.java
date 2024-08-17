package com.myapp.doctorvisit.security;

import com.myapp.doctorvisit.common.exception.AbstractException;
import org.springframework.http.HttpStatus;

public class UserNotExistsException extends AbstractException {
    @Override
    public String getMessage() {
        return "کاربر در سیستم ثبت نشده است.";
    }

    @Override
    public HttpStatus getStatus() {
        return HttpStatus.UNAUTHORIZED;
    }
}
