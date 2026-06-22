package com.springEco.Spring.Ecosystem.Relationships.Beans;

import org.springframework.stereotype.Component;

@Component
public class Car {
    String name="Bmw";

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
