package com.springEco.Spring.Ecosystem.Aspects.JoinPoint;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@Configuration
@ComponentScan(basePackages = "com.springEco.Spring.Ecosystem.Aspects.JoinPoint")
@EnableAspectJAutoProxy
public class Config {

}
