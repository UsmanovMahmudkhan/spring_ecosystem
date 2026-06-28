package com.springEco.Spring.Ecosystem.Scopes.Singleton;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

@SpringBootApplication(scanBasePackages = "com.springEco.Spring.Ecosystem.Scopes.Singleton")
public class App {
    public static void main(String[] args) {
        var context=new AnnotationConfigApplicationContext(Config.class);
        var a=context.getBean(Singleton.class);
        var b=context.getBean(Singleton.class);
        System.out.println(a);
        System.out.println(b);
        System.out.println(a==b);
    }
}
