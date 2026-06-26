package com.springEco.Spring.Ecosystem.Scopes.Singleton.eager;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

@SpringBootApplication(scanBasePackages = "com.springEco.Spring.Ecosystem.Scopes.Singleton.eager")
public class App {
    public static void main(String[] args) {

        var context=new AnnotationConfigApplicationContext(Config.class);
        System.out.println("Context is ready");
    }
}
