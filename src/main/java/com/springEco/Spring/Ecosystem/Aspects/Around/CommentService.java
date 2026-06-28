package com.springEco.Spring.Ecosystem.Aspects.Around;

import org.springframework.stereotype.Service;

import java.util.logging.Logger;

@Service
public class CommentService {

    private final Logger logger= Logger.getLogger(CommentService.class.getName());

    public void publishComment(Comment comment) throws InterruptedException {
        Thread.sleep(3000);
        logger.info( "Publishing text: "+comment.getText()+"\n Author: "+comment.getAuthor());
    }
}
