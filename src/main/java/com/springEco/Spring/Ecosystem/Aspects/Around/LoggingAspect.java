package com.springEco.Spring.Ecosystem.Aspects.Around;

import org.apache.logging.log4j.LogManager;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

import java.lang.management.ManagementFactory;
import java.util.logging.Logger;

@Component
@Aspect
public class LoggingAspect {

    private final Logger logger=Logger.getLogger(LoggingAspect.class.getName());

    @Around("execution(* com.springEco.Spring.Ecosystem.Aspects.Around.*.*(..))")
    public Object  object(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
        long start=System.currentTimeMillis();
        logger.info("Before: Aspect started");
        var result=proceedingJoinPoint.proceed();
        logger.info("After: Aspect finished");
        long end=System.currentTimeMillis();

        logger.info("Time taken to execute: "+(end-start));
        return result;
    }
}
