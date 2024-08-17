package com.myapp.doctorvisit.professional.exception;

import com.myapp.doctorvisit.common.exception.AbstractNotFoundException;

public class ProffesionalNotFoundException extends AbstractNotFoundException {
    @Override
    public String getMessage() {
        return "حرفه مورد نظر یافت نشد.";
    }
}
