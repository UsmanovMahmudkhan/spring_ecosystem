package com.springEco.Spring.Ecosystem.Aspects.Before;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@Configuration
@ComponentScan("com.springEco.Spring.Ecosystem.Aspects.Before")
@EnableAspectJAutoProxy
public class Config {
}
