package com.springEco.Spring.Ecosystem.Relationships.Config;

import com.springEco.Spring.Ecosystem.Relationships.Beans.Car;
import com.springEco.Spring.Ecosystem.Relationships.Beans.Parrot;
import com.springEco.Spring.Ecosystem.Relationships.Beans.Person;
import com.springEco.Spring.Ecosystem.Relationships.Beans.User;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@Configuration
@ComponentScan("com.springEco.Spring.Ecosystem.Relationships")
public class Config {

    @Bean("parrot1")
    public Parrot parrot1(){
        return new Parrot("Perato");
    }

    @Bean("parrot2")
    public Parrot parrot2(){
        return new Parrot("Perato-2");
    }

    @Bean("parrot3")
    @Primary
    public Parrot parrot3(){
        return new Parrot("Perato-3");
    }


    @Bean
    public Person person(@Qualifier("parrot2") Parrot parrot){
        return new Person("Ali", parrot);
    }



}
