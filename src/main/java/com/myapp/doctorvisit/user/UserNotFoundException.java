package com.myapp.doctorvisit.user;

import com.myapp.doctorvisit.common.exception.AbstractNotFoundException;

public class UserNotFoundException extends AbstractNotFoundException {
    @Override
    public String getMessage() {
        return "کاربر یافت نشد.";
    }
}
