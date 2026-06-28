package com.springEco.Spring.Ecosystem.Aspects.Before;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

import java.util.logging.Logger;

@Aspect
@Component
public class CommentAspect {
    private final Logger log= Logger.getLogger(CommentAspect.class.getName());

    @Before("execution(* com.springEco.Spring.Ecosystem.Aspects.Before.*.*(..))")
    public void aspect() {
        log.info("@Before: About to run");
    }
}
