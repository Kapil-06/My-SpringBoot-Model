package com.theskyit.aspect;

import java.util.Arrays;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class LoggingAspect {

	private static final Logger logger = LoggerFactory.getLogger(LoggingAspect.class);
	
	// Logging method entry, parameters, and execution time
    @Before("execution(* com.theskyit.controller.*.*(..)) || execution(* com.theskyit.service.*.*(..))\")")
    public void logMethodEntry(ProceedingJoinPoint joinPoint) {
        String methodName = joinPoint.getSignature().getName();
        Object[] args = joinPoint.getArgs();
        logger.info("Method '{}' started with arguments: {}", methodName, Arrays.toString(args));
    }

    // Logging method return value
    @AfterReturning(value = "execution(* com.theskyit.controller.*.*(..)) || execution(* com.theskyit.service.*.*(..))", returning = "result")
    public void logMethodExit(ProceedingJoinPoint joinPoint, Object result) {
        String methodName = joinPoint.getSignature().getName();
        logger.info("Method '{}' executed successfully, returning: {}", methodName, result);
    }

    // Logging exceptions
    @AfterThrowing(value = "execution(* com.theskyit.controller.*.*(..)) || execution(* com.theskyit.service.*.*(..))", throwing = "exception")
    public void logMethodException(ProceedingJoinPoint joinPoint, Exception exception) {
        String methodName = joinPoint.getSignature().getName();
        logger.error("Method '{}' execution failed with exception: {}", methodName, exception.getMessage(), exception);
    }

    // Logging the execution time of the method (Around advice)
    @Around("execution(* com.theskyit.controller.*.*(..)) || execution(* com.theskyit.service.*.*(..))")
    public Object logExecutionTime(ProceedingJoinPoint joinPoint) throws Throwable {
        String methodName = joinPoint.getSignature().getName();
        long startTime = System.currentTimeMillis();
        try {
            Object result = joinPoint.proceed(); // Proceed with method execution
            long endTime = System.currentTimeMillis();
            logger.info("Method '{}' executed in {} ms", methodName, endTime - startTime);
            return result;
        } catch (Throwable ex) {
            long endTime = System.currentTimeMillis();
            logger.error("Method '{}' failed after {} ms with exception: {}", methodName, endTime - startTime, ex.getMessage(), ex);
            throw ex;  // Re-throw the exception after logging
        }
    }
}
