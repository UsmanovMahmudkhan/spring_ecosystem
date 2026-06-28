package com.springEco.Spring.Ecosystem.Aspects.JoinPoint;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.logging.Logger;

@org.aspectj.lang.annotation.Aspect
@Component
public class Aspect {
    private final Logger logger=Logger.getLogger(Aspect.class.getName());

    @Around("execution(* com.springEco.Spring.Ecosystem.Aspects.JoinPoint.*.*(..))")
    public Object object(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
        logger.warning("Method to intercept: "+proceedingJoinPoint.getSignature().getName());
        logger.warning("Parameter used: "+ Arrays.toString(proceedingJoinPoint.getArgs()));
        var result=proceedingJoinPoint.proceed();
        return result;
    }
}
