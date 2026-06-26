package com.springEco.Spring.Ecosystem.Scopes.Prototypes.Singleton_Holding_Prototype;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope("prototype")
public class Order {
    public Order() {
        System.out.println("Order is created!");
    }
}
