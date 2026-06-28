package com.springEco.Spring.Ecosystem.Scopes.Singleton.Lazy;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

@SpringBootApplication(scanBasePackages = "com.springEco.Spring.Ecosystem.Scopes.Singleton.Lazy")
public class App {
    public static void main(String[] args) {
        var context=new AnnotationConfigApplicationContext(Config.class);
        System.out.println("Context is created and ready to use");

        var car=context.getBean(Car.class);
    }
}
