package com.myapp.doctorvisit.common;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import java.util.List;

import static com.fasterxml.jackson.annotation.JsonAutoDetect.Visibility.ANY;

@AllArgsConstructor
@JsonAutoDetect(fieldVisibility = ANY)
public final class ErrorDto {

    private final Error error;

    public ErrorDto(String message, String code, List<ApiValidationError> subErrors) {
        this.error = new Error(code, message, subErrors);
    }

    private record Error(String code, String message, List<ApiValidationError> subErrors) {
        // ignore
    }

    @Data
    @Builder
    @AllArgsConstructor
    public static class ApiValidationError {
        private String object;
        private String field;
        private Object rejectedValue;
        private String message;
    }
}