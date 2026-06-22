package com.springEco.Spring.Ecosystem.Config;

import com.springEco.Spring.Ecosystem.Bean.Parrot;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class Config {

    @Bean
    public Parrot parrot1(){
        var par1=new Parrot();
        par1.setName("kiki");
        return par1;
    }
}
