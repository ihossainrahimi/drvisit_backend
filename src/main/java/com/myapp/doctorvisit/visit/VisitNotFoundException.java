package com.myapp.doctorvisit.visit;

import com.myapp.doctorvisit.common.exception.AbstractNotFoundException;

public class VisitNotFoundException extends AbstractNotFoundException {
    @Override
    public String getMessage() {
        return "زمان بندی مورد نظر یافت نشد.";
    }
}
