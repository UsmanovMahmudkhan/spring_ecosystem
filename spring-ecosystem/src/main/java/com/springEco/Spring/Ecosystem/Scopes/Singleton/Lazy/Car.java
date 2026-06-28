package com.springEco.Spring.Ecosystem.Scopes.Singleton.Lazy;

import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

@Component
@Lazy
public class Car {
    public Car() {
        System.out.println("car is created");
    }
}
