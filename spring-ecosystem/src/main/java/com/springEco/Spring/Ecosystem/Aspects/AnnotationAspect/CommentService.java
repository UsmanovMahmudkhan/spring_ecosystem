package com.springEco.Spring.Ecosystem.Aspects.AnnotationAspect;

import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.logging.Logger;

@Service
public class CommentService {
    private static final org.slf4j.Logger log = LoggerFactory.getLogger(CommentService.class);
    @ToLog
    public void publishComment(Comment comment) {
        log.info("Comment: "+comment.getComment());
    }
}
