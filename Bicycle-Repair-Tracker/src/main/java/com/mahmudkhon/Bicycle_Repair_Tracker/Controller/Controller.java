package com.mahmudkhon.Bicycle_Repair_Tracker.Controller;

import com.mahmudkhon.Bicycle_Repair_Tracker.DTOs.TicketRequest;
import com.mahmudkhon.Bicycle_Repair_Tracker.model.RepairTicket;
import com.mahmudkhon.Bicycle_Repair_Tracker.repository.RepairTicketRepo;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class Controller {

    private final RepairTicketRepo ticketRepo;

    public Controller(RepairTicketRepo ticketRepo) {
        this.ticketRepo = ticketRepo;
    }

    @PostMapping("/add")
    public boolean add(@RequestBody TicketRequest request){
        ticketRepo.save(new RepairTicket(request.getTitle()));
        return true;
    }

    @GetMapping("/")
    public List<RepairTicket>getAll(){
        return (List<RepairTicket>) ticketRepo.findAll();
    }
}
