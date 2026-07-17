package com.mahmudkhon.Bicycle_Repair_Tracker.Controller;

import com.mahmudkhon.Bicycle_Repair_Tracker.DTOs.CustomerRequest;
import com.mahmudkhon.Bicycle_Repair_Tracker.DTOs.TicketRequest;
import com.mahmudkhon.Bicycle_Repair_Tracker.model.Customer;
import com.mahmudkhon.Bicycle_Repair_Tracker.model.RepairTicket;
import com.mahmudkhon.Bicycle_Repair_Tracker.repository.CustomerRepo;
import com.mahmudkhon.Bicycle_Repair_Tracker.repository.RepairTicketRepo;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class Controller {

    private final RepairTicketRepo ticketRepo;
    private final CustomerRepo customerRepo;

    public Controller(RepairTicketRepo ticketRepo,CustomerRepo customerRepo) {
        this.ticketRepo = ticketRepo;
        this.customerRepo=customerRepo;
    }

    // add new ones
    @PostMapping("/add/request")
    public boolean add(@RequestBody TicketRequest request){
        var repair=new RepairTicket();

        Optional<Customer> customerOptional = customerRepo.findById(request.getCustomerId());

        if (customerOptional.isPresent()) {
            Customer customer = customerOptional.get(); // Now safe to call .get()
            repair.setProblem_title(request.getProblem_title());
            repair.setDescription(request.getDescription());
            repair.setLaborCost(request.getLaborCost());
            repair.setUrgent(request.getUrgent());
            repair.setExpectedFinishDate(request.getExpectedFinishDate());
            repair.setCustomerMessage(request.getCustomerMessage());
            repair.setPhoto(request.getPhoto());
            repair.setReferenceNumber(request.getReferenceNumber());
            repair.setCreatedByBranch(request.getCreatedByBranch());
            repair.setStatus(request.getStatus());
            repair.setCustomer(customer);
            ticketRepo.save(repair);

        } else {

            return false;
        }

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


    //save customer
    @PostMapping("/customer/add")
    public void add(@RequestBody CustomerRequest request){
        customerRepo.save(new Customer(request.getName(), request.getMail()));
    }


    @GetMapping("/customer/all")
    private List<Customer> getAllCustomer(){
        return (List<Customer>) customerRepo.findAll();
    }


}
