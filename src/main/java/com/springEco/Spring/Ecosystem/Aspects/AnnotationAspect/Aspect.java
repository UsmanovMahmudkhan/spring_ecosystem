package com.springEco.Spring.Ecosystem.Aspects.AnnotationAspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@org.aspectj.lang.annotation.Aspect
@Component
public class Aspect {

    private static final Logger log = LoggerFactory.getLogger(Aspect.class);

    @Around("@annotation(ToLog)")
    public Object obj(ProceedingJoinPoint joinPoint) throws Throwable {

        log.info("About to run");
        var result= joinPoint.proceed();
        log.info("Finish");

        return result;
    }
}
