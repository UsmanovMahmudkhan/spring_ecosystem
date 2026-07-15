package com.mahmudkhon.Bicycle_Repair_Tracker.Controller;

import com.mahmudkhon.Bicycle_Repair_Tracker.DTOs.TicketRequest;
import com.mahmudkhon.Bicycle_Repair_Tracker.model.RepairTicket;
import com.mahmudkhon.Bicycle_Repair_Tracker.repository.RepairTicketRepo;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class Controller {

    private final RepairTicketRepo ticketRepo;

    public Controller(RepairTicketRepo ticketRepo) {
        this.ticketRepo = ticketRepo;
    }

    // add new ones
    @PostMapping("/add/request")
    public boolean add(@RequestBody TicketRequest request){
        //Saves it through the repository.
        ticketRepo.save(new RepairTicket(request.getTitle()));
        return true;
    }

    //get all ticket titles
    @GetMapping("/tickets")
    public List<RepairTicket>getAll(){
        return (List<RepairTicket>) ticketRepo.findAll();
    }

    //Reads it back using its ID.
    @GetMapping("/ticket/{id}")
    public Optional<RepairTicket> getTicket(@PathVariable Long id){
        return ticketRepo.findById(id);
    }


    //Deletes it.
    @DeleteMapping("/ticket/remove/{id}")
    public boolean delete(@PathVariable Long id){
        if(ticketRepo.existsById(id)) {
            ticketRepo.deleteById(id);
            return true;
        }
        else {
            return false;
        }
    }




}
