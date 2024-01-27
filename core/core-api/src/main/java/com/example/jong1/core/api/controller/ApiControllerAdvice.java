package com.example.jong1.core.api.controller;

import com.example.jong1.core.api.common.dto.MethodArgumentErrorResponse;
import com.example.jong1.core.api.support.error.CoreApiException;
import com.example.jong1.core.api.support.error.ErrorType;
import com.example.jong1.core.api.support.response.ApiResponse;
import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.MessageSource;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@Slf4j
@RequiredArgsConstructor
@RestControllerAdvice
public class ApiControllerAdvice {

    private final MessageSource messageSource;

    @ExceptionHandler(CoreApiException.class)
    public ResponseEntity<ApiResponse<?>> handleCoreApiException(CoreApiException e) {
        switch (e.getErrorType().getLogLevel()) {
            case ERROR -> log.error("CoreApiException : {}", e.getMessage(), e);
            case WARN -> log.warn("CoreApiException : {}", e.getMessage(), e);
            default -> log.info("CoreApiException : {}", e.getMessage(), e);
        }
        return new ResponseEntity<>(ApiResponse.error(e.getErrorType(), e.getData()), e.getErrorType().getStatus());
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<ApiResponse<?>> handleException(Exception e) {
        log.error("Exception : {}", e.getMessage(), e);
        return new ResponseEntity<>(ApiResponse.error(ErrorType.DEFAULT_ERROR), ErrorType.DEFAULT_ERROR.getStatus());
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<MethodArgumentErrorResponse> ArgumentNotValidHandle(
            MethodArgumentNotValidException exception, HttpServletRequest req) {

        log.error("MethodArgumentNotValidException Message >>> {}", exception.getMessage(), exception);
        MethodArgumentErrorResponse response = new MethodArgumentErrorResponse(
                HttpStatus.BAD_REQUEST.value(),
                messageSource.getMessage("error.bad.request", null, req.getLocale())
        );
        exception.getFieldErrors().forEach(error -> {
            String fieldName = error.getField();
            String errorMessage = error.getDefaultMessage();
            response.addFieldError(fieldName, errorMessage);
        });

        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(response);
    }

}
