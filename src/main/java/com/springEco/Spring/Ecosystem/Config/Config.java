package com.springEco.Spring.Ecosystem.Config;

import com.springEco.Spring.Ecosystem.Bean.Parrot;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

@Configuration
public class Config {

    @Bean
    public Parrot parrot1(){
        var par1=new Parrot();
        par1.setName("kiki");
        return par1;
    }

    @Bean
    public Parrot parrot2(){
        Parrot parrot=new Parrot();
        parrot.setName("parrot-2");
        return parrot;
    }

    @Bean
    @Primary
    public Parrot parrot3(){
        Parrot parrot=new Parrot();
        parrot.setName("parrot-3");
        return parrot;
    }


}
