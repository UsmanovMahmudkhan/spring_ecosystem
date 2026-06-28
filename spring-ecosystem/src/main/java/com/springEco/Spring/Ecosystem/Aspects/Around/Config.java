package com.springEco.Spring.Ecosystem.Aspects.Around;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@Configuration
@ComponentScan(basePackages = "com.springEco.Spring.Ecosystem.Aspects.Around")
@EnableAspectJAutoProxy
public class Config {

}
