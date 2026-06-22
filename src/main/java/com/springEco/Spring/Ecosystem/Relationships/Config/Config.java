package com.springEco.Spring.Ecosystem.Relationships.Config;

import com.springEco.Spring.Ecosystem.Relationships.Beans.Car;
import com.springEco.Spring.Ecosystem.Relationships.Beans.Parrot;
import com.springEco.Spring.Ecosystem.Relationships.Beans.Person;
import com.springEco.Spring.Ecosystem.Relationships.Beans.User;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

@Configuration
@ComponentScan("com.springEco.Spring.Ecosystem.Relationships")
public class Config {

    @Bean
    public Parrot parrot(){
        return new Parrot("Perato");
    }

    @Bean
    public Person person(Parrot parrot){
        return new Person("Ali",parrot);
    }



}
