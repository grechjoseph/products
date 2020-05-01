package com.jg.products.api.controller.aspect;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.stream.Collectors;

@Slf4j
@Aspect
@Component
public class ControllerAspect {

    @Before("anyController()")
    public void loggingBefore(JoinPoint joinPoint) {
        final String methodName = getMethodName(joinPoint);
        final String className = getClassName(joinPoint);
        final Object[] args = joinPoint.getArgs();

        String parameters = Arrays.stream(args)
                .map(arg -> "arg " + arg + ", ")
                .collect(Collectors.joining());

        if(args.length > 1) {
            parameters = parameters.substring(0, parameters.length() - 2);
        }

        log.debug("Called {} method of class {} with parameters: {}", methodName, className, parameters);
    }

    @AfterReturning(pointcut = "anyController()", returning = "returnValue")
    public void loggingAfter(JoinPoint joinPoint, Object returnValue) {
        final String methodName = getMethodName(joinPoint);
        final String className = getClassName(joinPoint);

        log.debug("Returned {} method of class {} with value: {}", methodName, className, returnValue);
    }

    @Pointcut("@within(org.springframework.web.bind.annotation.RestController)")
    public void anyController() {
    }

    private String getMethodName(JoinPoint joinPoint) {
        return ((MethodSignature) joinPoint.getSignature()).getMethod().getName();
    }

    private String getClassName(JoinPoint joinPoint) {
        return joinPoint.getTarget().getClass().getName();
    }
}
