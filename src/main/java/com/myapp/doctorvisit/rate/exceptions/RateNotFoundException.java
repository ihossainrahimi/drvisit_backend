package com.myapp.doctorvisit.rate.exceptions;

import com.myapp.doctorvisit.common.exception.AbstractNotFoundException;

public class RateNotFoundException extends AbstractNotFoundException {
    @Override
    public String getMessage() {
        return "امتیاز مورد نظر یافت نشد.";
    }
}
