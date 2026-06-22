package com.springEco.Spring.Ecosystem.SpringContextPetAdoptionManager.service;

import com.springEco.Spring.Ecosystem.SpringContextPetAdoptionManager.model.Pet;
import org.springframework.stereotype.Component;

@Component
public class PetRegistry {

    String registryName="Successfully registered";

    public String getRegistryName() {
        return registryName;
    }

    public void setRegistryName(String registryName) {
        this.registryName = registryName;
    }

    public boolean isPetAvailable(Pet pet){
        return pet.isAvailable();
    }

    @Override
    public String toString() {
        return "PetRegistry{" +
                "registryName='" + registryName + '\'' +
                '}';
    }
}
