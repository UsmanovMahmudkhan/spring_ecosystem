package com.springEco.Spring.Ecosystem.BrewHub.Model;

import org.springframework.stereotype.Component;

@Component
public class Customer {
    private String name = "Mahmud";

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Customer{" +
                "name='" + name + '\'' +
                '}';
    }
}
