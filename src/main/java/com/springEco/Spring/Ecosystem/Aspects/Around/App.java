package com.springEco.Spring.Ecosystem.Aspects.Around;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

@SpringBootApplication(scanBasePackages = "com.springEco.Spring.Ecosystem.Aspects.Around")
public class App {
    public static void main(String[] args) {


        var context=new AnnotationConfigApplicationContext(Config.class);
        var service=context.getBean(CommentService.class);
        service.publishComment(new Comment("Salom ","Hoshimbe"));
    }
}
