package com.myapp.doctorvisit.common;

import com.myapp.doctorvisit.common.exception.AbstractException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@RestControllerAdvice
public class GlobalExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(AbstractException.class)
    ResponseEntity<ErrorDto> handleAbstractExceptions(AbstractException e) {
        var error = new ErrorDto(e.getMessage(), e.getStatus().name(), null);

        return ResponseEntity.status(e.getStatus()).body(error);
    }
}
