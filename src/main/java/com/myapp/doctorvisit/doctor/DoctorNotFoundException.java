package com.myapp.doctorvisit.doctor;

import com.myapp.doctorvisit.common.exception.AbstractNotFoundException;

public class DoctorNotFoundException extends AbstractNotFoundException {
    @Override
    public String getMessage() {
        return "دکتر یافت نشد.";
    }
}
