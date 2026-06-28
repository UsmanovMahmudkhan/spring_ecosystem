package com.springEco.Spring.Ecosystem.Scopes.Singleton.PerBeanConcept;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

@SpringBootApplication(scanBasePackages = "com.springEco.Spring.Ecosystem.Scopes.Singleton.PerBeanConcept")
public class App {
    public static void main(String[] args) {
        var context=new AnnotationConfigApplicationContext(Config.class);

        var a=context.getBean("machine",CoffeeMachine.class);
        var b=context.getBean("machine",CoffeeMachine.class);
        System.out.println("The same bean comparing: "+(a==b));

        var c=context.getBean("machine2",CoffeeMachine.class);
        System.out.println("Different instance bean but the same type: "+(a==c));
    }
}
