package com.springEco.Spring.Ecosystem.Scopes.Singleton.PerBeanConcept;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class Config {

    @Bean
    public CoffeeMachine machine(){
        return new CoffeeMachine();
    }

    @Bean
    public CoffeeMachine machine2(){
        return new CoffeeMachine();
    }


}
