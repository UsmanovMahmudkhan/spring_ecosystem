package com.springEco.Spring.Ecosystem.SpringContextPetAdoptionManager.model;

public class AdoptionRecord {

    Adopter adopter;

    Pet pet;

    AdoptionCenter adoptionCenter;

    public Adopter getAdopter() {
        return adopter;
    }

    public void setAdopter(Adopter adopter) {
        this.adopter = adopter;
    }

    public Pet getPet() {
        return pet;
    }

    public void setPet(Pet pet) {
        this.pet = pet;
    }

    public AdoptionCenter getAdoptionCenter() {
        return adoptionCenter;
    }

    public void setAdoptionCenter(AdoptionCenter adoptionCenter) {
        this.adoptionCenter = adoptionCenter;
    }

    @Override
    public String toString() {
        return "AdoptionRecord{" +
                "adopter=" + adopter +
                ", pet=" + pet +
                ", adoptionCenter=" + adoptionCenter +
                '}';
    }
}
