package com.springEco.Spring.Ecosystem.Scopes.Prototypes.NewRequest;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

@SpringBootApplication(scanBasePackages = "com.springEco.Spring.Ecosystem.Scopes.Prototypes.NewRequest")
public class App {
    public static void main(String[] args) {
        var context =new AnnotationConfigApplicationContext(Config.class);
        var a= context.getBean(Orders.class);
        var b=context.getBean(Orders.class);
        System.out.println(a==b);
    }
}
