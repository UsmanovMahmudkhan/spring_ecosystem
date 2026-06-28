package com.springEco.Spring.Ecosystem.Aspects.JoinPoint;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

@SpringBootApplication(scanBasePackages = "com.springEco.Spring.Ecosystem.Aspects.JoinPoint")
public class App {
    public static void main(String[] args) {
        var context=new AnnotationConfigApplicationContext(Config.class);
        var service=context.getBean(Service.class);
        service.publishComment(new Comment("Practiced JointPoint"));
    }
}
