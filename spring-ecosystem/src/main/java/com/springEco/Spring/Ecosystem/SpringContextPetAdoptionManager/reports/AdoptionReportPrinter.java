package com.springEco.Spring.Ecosystem.SpringContextPetAdoptionManager.reports;

import com.springEco.Spring.Ecosystem.SpringContextPetAdoptionManager.model.AdoptionRecord;
import com.springEco.Spring.Ecosystem.SpringContextPetAdoptionManager.service.AdoptionService;
import org.springframework.stereotype.Component;


@Component
public class AdoptionReportPrinter {

    AdoptionRecord adoptionRecord;
    AdoptionService adoptionService;

    public AdoptionReportPrinter(AdoptionRecord adoptionRecord, AdoptionService adoptionService) {
        this.adoptionRecord = adoptionRecord;
        this.adoptionService = adoptionService;
    }

    public String printReport(){
        return "Center: "+adoptionRecord.getAdoptionCenter().getName()+"\n"+
                "Adapter: "+adoptionRecord.getAdopter().getName()+"\n"+
                "Selected Pet: "+adoptionRecord.getPet().getName()+"\n"+
                "Species: "+adoptionRecord.getPet().getSpecies()+"\n"+
                "Avability: "+adoptionRecord.getPet().isAvailable()+"\n"+
                "Adaptation Status: "+adoptionService.getPetRegistry().getRegistryName()+"\n"+
                "Center Registry (via injected service): "+
                adoptionRecord.getAdoptionCenter().getAdoptionService().getPetRegistry().getRegistryName();




    }
}
