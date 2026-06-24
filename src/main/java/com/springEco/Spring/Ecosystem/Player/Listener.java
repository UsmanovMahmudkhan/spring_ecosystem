package com.springEco.Spring.Ecosystem.Player;

import org.springframework.stereotype.Component;

@Component
public class Listener
{
    private String name="Mahmudkhon";

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Listener{" +
                "name='" + name + '\'' +
                '}';
    }
}
