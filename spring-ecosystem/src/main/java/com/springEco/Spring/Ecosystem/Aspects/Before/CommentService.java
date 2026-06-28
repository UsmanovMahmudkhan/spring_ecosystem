package com.springEco.Spring.Ecosystem.Aspects.Before;

import org.apache.commons.logging.Log;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

import java.util.logging.Logger;


@Component
public class CommentService {
    private final Logger log= Logger.getLogger(CommentService.class.getName());

    public void publish(Comment comment){
        log.info("Comment: "+comment.getComment());
    }

}
