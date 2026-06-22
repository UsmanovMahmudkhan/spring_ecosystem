package com.springEco.Spring.Ecosystem.Relationships.Beans;

public class Parrot {
    private String name;

    public Parrot(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Parrot{" +
                "name='" + name + '\'' +
                '}';
    }
}
