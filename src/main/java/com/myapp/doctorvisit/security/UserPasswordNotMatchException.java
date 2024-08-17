package com.myapp.doctorvisit.security;

import com.myapp.doctorvisit.common.exception.AbstractUnAuthorizedException;

public class UserPasswordNotMatchException extends AbstractUnAuthorizedException {
    @Override
    public String getMessage() {
        return "نام کاربری یا رمز عبور معتبر نمی‌باشد.";
    }
}
