package com.springEco.Spring.Ecosystem.Aspects.JoinPoint;

import org.slf4j.LoggerFactory;

import java.util.logging.Logger;

@org.springframework.stereotype.Service
public class Service {

    private Logger logger= Logger.getLogger(Service.class.getName());

    public void publishComment(Comment comment) {
        logger.info("Comment: "+comment.getText());
    }
}
