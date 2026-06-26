package com.springEco.Spring.Ecosystem.Scopes.Prototypes.Singleton_Holding_Prototype;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

@SpringBootApplication(scanBasePackages = "com.springEco.Spring.Ecosystem.Scopes.Prototypes.Singleton_Holding_Prototype")
public class App {
    public static void main(String[] args) {
        var context=new AnnotationConfigApplicationContext(Config.class);
        var order1=context.getBean(OrderProcessor.class);
        System.out.println(order1.getOrder());
        System.out.println(order1.getOrder());
        System.out.println();
        var order2=context.getBean(OrderProcessor.class);
        System.out.println(order2.getOrder());

    }
}
