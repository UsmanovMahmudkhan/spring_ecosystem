package com.springEco.Spring.Ecosystem.Relationships;

import com.springEco.Spring.Ecosystem.Relationships.Beans.Car;
import com.springEco.Spring.Ecosystem.Relationships.Beans.Person;
import com.springEco.Spring.Ecosystem.Relationships.Beans.User;
import com.springEco.Spring.Ecosystem.Relationships.Config.Config;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

@SpringBootApplication(scanBasePackages = "com.springEco.Spring.Ecosystem.Relationships")
public class App {
    public static void main(String[] args) {
        SpringApplication.run(App.class,args);

        var context=new AnnotationConfigApplicationContext(Config.class);
        var person=context.getBean("person", Person.class);
        System.out.println(person.getName());
        System.out.println(person.getParrot());



        var user1=context.getBean( User.class);
        System.out.println(user1.getName());
        System.out.println(user1.getCar().getName());
    }
}
