package com.springEco.Spring.Ecosystem.SpringContextPetAdoptionManager.Config;

import com.springEco.Spring.Ecosystem.SpringContextPetAdoptionManager.model.Adopter;
import com.springEco.Spring.Ecosystem.SpringContextPetAdoptionManager.model.AdoptionCenter;
import com.springEco.Spring.Ecosystem.SpringContextPetAdoptionManager.model.AdoptionRecord;
import com.springEco.Spring.Ecosystem.SpringContextPetAdoptionManager.model.Pet;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.yaml.snakeyaml.external.com.google.gdata.util.common.base.Escaper;

import javax.swing.text.BadLocationException;

@Configuration
@ComponentScan(basePackages = "com.springEco.Spring.Ecosystem.SpringContextPetAdoptionManager")
public class Config {

    @Bean(name = "krilishka")
    public Pet pet(){
        Pet pet=new Pet();
        pet.setName("Krilishka");
        pet.setSpecies("bad animal");
        pet.setAvailable(true);
        return pet;
    }

    @Bean
    public Adopter adopter(@Qualifier("krilishka") Pet pet){
        Adopter adopter=new Adopter();
        adopter.setName("Xan");
        adopter.setPet(pet);
        return adopter;
    }

    @Bean
    public AdoptionCenter adoptionCenter(){
        AdoptionCenter center=new AdoptionCenter();
        center.setName("Seoul it clinic");
        return center;
    }

    @Bean
    public AdoptionRecord adoptionRecord(@Qualifier("krilishka")Pet pet,Adopter adopter,AdoptionCenter center){
        AdoptionRecord record=new AdoptionRecord();
        record.setPet(pet);
        record.setAdopter(adopter);
        record.setAdoptionCenter(center);
        return record;
    }
}
