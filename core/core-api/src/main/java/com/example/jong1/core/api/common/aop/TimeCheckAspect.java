package com.example.jong1.core.api.common.aop;

import java.time.Duration;
import java.time.LocalDateTime;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

import lombok.extern.slf4j.Slf4j;

@Aspect
@Slf4j
@Component
public class TimeCheckAspect {

	@Around("@annotation(com.example.jong1.core.api.common.annotation.TimeCheck)")
	public Object DurationTimeCheck(ProceedingJoinPoint pjp) throws  Throwable {
		LocalDateTime startTime = LocalDateTime.now();
		Object obj = pjp.proceed();
		LocalDateTime endTime = LocalDateTime.now();
		Duration duration = Duration.between(startTime, endTime);
		log.info("[AOP] : Calling Method >>> {}.{}", pjp.getSignature().getDeclaringTypeName(), pjp.getSignature().getName());
		log.info("[AOP] : Duration >>> {}ms, StartTime >>> {}, EndTime >>> {}", duration.toMillis(), startTime, endTime);
		return obj;
	}

}
