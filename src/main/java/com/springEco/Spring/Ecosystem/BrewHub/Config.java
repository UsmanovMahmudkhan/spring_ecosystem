package com.springEco.Spring.Ecosystem.BrewHub;

import com.springEco.Spring.Ecosystem.BrewHub.Model.Coffee;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

@Configuration
@ComponentScan(basePackages = "com.springEco.Spring.Ecosystem.BrewHub")
public class Config {

    @Bean
    @Primary
    public Coffee coffee1() {
        Coffee coffee = new Coffee();
        coffee.setName("Espresso");
        coffee.setPrice(2.5F);
        return coffee;
    }

    @Bean
    public Coffee coffee2() {
        Coffee coffee = new Coffee();
        coffee.setName("latte");
        coffee.setPrice(3.2F);
        return coffee;
    }
}
