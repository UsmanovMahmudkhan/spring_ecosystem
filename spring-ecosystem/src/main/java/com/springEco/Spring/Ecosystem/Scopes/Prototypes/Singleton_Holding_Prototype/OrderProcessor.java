package com.springEco.Spring.Ecosystem.Scopes.Prototypes.Singleton_Holding_Prototype;

import org.springframework.stereotype.Component;

@Component
public class OrderProcessor {
    public Order order;

    public OrderProcessor(Order order) {
        this.order = order;
    }

    public Order getOrder() {
        return order;
    }

    public void setOrder(Order order) {
        this.order = order;
    }
}
