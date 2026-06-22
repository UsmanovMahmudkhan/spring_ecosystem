package com.springEco.Spring.Ecosystem.SpringContextPetAdoptionManager.model;

public class Adopter {
    String name;
    Pet pet;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Pet getPet() {
        return pet;
    }

    public void setPet(Pet pet) {
        this.pet = pet;
    }

    @Override
    public String toString() {
        return "Adopter{" +
                "name='" + name + '\'' +
                ", pet=" + pet +
                '}';
    }
}
