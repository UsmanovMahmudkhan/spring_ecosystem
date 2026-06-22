package com.springEco.Spring.Ecosystem.SpringContextPetAdoptionManager;

import com.springEco.Spring.Ecosystem.SpringContextPetAdoptionManager.Config.Config;
import com.springEco.Spring.Ecosystem.SpringContextPetAdoptionManager.model.Pet;
import com.springEco.Spring.Ecosystem.SpringContextPetAdoptionManager.reports.AdoptionReportPrinter;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.function.Supplier;

@SpringBootApplication(scanBasePackages = "com.springEco.Spring.Ecosystem.SpringContextPetAdoptionManager")
public class App {
    public static void main(String[] args) {
        SpringApplication.run(App.class,args);

        var context=new AnnotationConfigApplicationContext(Config.class);
        var report=context.getBean(AdoptionReportPrinter.class);

        System.out.println(report.printReport());


        Pet pet=new Pet();
        pet.setAvailable(true);
        pet.setName("Alowka");
        pet.setSpecies("Home animal");

        // Programmatic registration based on a condition:
        // only register the extra Pet when it is actually available.
        if(pet.isAvailable()){
            Supplier<Pet> petSupplier=()->pet;
            context.registerBean("pet",Pet.class,petSupplier);

            // Retrieve it back to prove it really entered the Spring context.
            Pet registeredPet=context.getBean("pet",Pet.class);
            System.out.println("\nProgrammatically registered pet from context: "+registeredPet);
        }
    }
}
