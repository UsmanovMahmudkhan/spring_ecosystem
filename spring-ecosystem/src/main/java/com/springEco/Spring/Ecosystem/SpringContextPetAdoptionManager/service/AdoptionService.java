package com.springEco.Spring.Ecosystem.SpringContextPetAdoptionManager.service;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Component;

@Component
public class AdoptionService {

    PetRegistry petRegistry;

    public AdoptionService(PetRegistry petRegistry) {
        this.petRegistry = petRegistry;
    }

    public PetRegistry getPetRegistry() {
        return petRegistry;
    }

    public void setPetRegistry(PetRegistry petRegistry) {
        this.petRegistry = petRegistry;
    }

    @Override
    public String toString() {
        return "AdoptionService{" +
                "petRegistry=" + petRegistry +
                '}';
    }
}
