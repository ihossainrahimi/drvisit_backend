package com.myapp.doctorvisit.security;

import com.myapp.doctorvisit.common.exception.AbstractBadRequestException;

public class UserExistException extends AbstractBadRequestException {
    @Override
    public String getMessage() {
        return "کاربر قبلا ذر سیستم ثبت نام کرده است.";
    }
}
