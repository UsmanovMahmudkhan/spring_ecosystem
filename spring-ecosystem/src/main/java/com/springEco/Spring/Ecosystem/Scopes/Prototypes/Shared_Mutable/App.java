package com.springEco.Spring.Ecosystem.Scopes.Prototypes.Shared_Mutable;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

@SpringBootApplication(scanBasePackages = "com.springEco.Spring.Ecosystem.Scopes.Prototypes.Shared_Mutable")
public class App {
    public static void main(String[] args) {
        var context=new AnnotationConfigApplicationContext(Config.class);
        var machine1=context.getBean(Machine.class);
        machine1.brew();
        machine1.brew();
        var machine2=context.getBean(Machine.class);
        machine2.brew();
        System.out.println(machine2.getCounter());


    }
}
