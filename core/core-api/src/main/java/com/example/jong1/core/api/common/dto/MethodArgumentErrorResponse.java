package com.example.jong1.core.api.common.dto;

import jakarta.validation.constraints.NotNull;
import lombok.Getter;

import java.util.HashMap;
import java.util.Map;

@Getter
public class MethodArgumentErrorResponse {

    private final boolean success = false;
    private final int statusCode;
    private final String errorCode;
    private final Map<String, String> fieldError = new HashMap<>();

    public MethodArgumentErrorResponse(int statusCode, @NotNull String errorCode) {
        this.statusCode = statusCode;
        this.errorCode = errorCode;
    }

    public void addFieldError(String field, String message) {
        this.fieldError.put(field, message);
    }
}