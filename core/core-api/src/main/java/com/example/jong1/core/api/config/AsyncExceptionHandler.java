package com.example.jong1.core.api.config;

import com.example.jong1.core.api.support.error.CoreApiException;

import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.aop.interceptor.AsyncUncaughtExceptionHandler;

import java.lang.reflect.Method;

@Slf4j
public class AsyncExceptionHandler implements AsyncUncaughtExceptionHandler {

    @Override
    public void handleUncaughtException(Throwable e, Method method, Object... params) {
        if (e instanceof CoreApiException) {
            switch (((CoreApiException) e).getErrorType().getLogLevel()) {
                case ERROR -> log.error("CoreApiException : {}", e.getMessage(), e);
                case WARN -> log.warn("CoreApiException : {}", e.getMessage(), e);
                default -> log.info("CoreApiException : {}", e.getMessage(), e);
            }
        }
        else {
            log.error("Exception : {}", e.getMessage(), e);
        }
    }

}
