package com.springEco.Spring.Ecosystem.Relationships.Config;

import com.springEco.Spring.Ecosystem.Relationships.Beans.Parrot;
import com.springEco.Spring.Ecosystem.Relationships.Beans.Person;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class Config {

    @Bean
    public Parrot parrot(){
        return new Parrot("Perato");
    }

    @Bean
    public Person person(){
        return new Person("Ali",parrot());
    }

}
