package com.springEco.Spring.Ecosystem.SpringContextPetAdoptionManager.model;

import com.springEco.Spring.Ecosystem.SpringContextPetAdoptionManager.service.AdoptionService;
import org.springframework.beans.factory.annotation.Autowired;

public class AdoptionCenter {

    String name;
    AdoptionService adoptionService;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public AdoptionService getAdoptionService() {
        return adoptionService;
    }

    @Autowired
    public void setAdoptionService(AdoptionService adoptionService) {
        this.adoptionService = adoptionService;
    }

    @Override
    public String toString() {
        return "AdoptionCenter{" +
                "name='" + name + '\'' +
                ", adoptionService=" + adoptionService +
                '}';
    }
}
