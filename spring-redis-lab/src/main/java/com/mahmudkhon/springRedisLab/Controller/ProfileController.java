package com.mahmudkhon.springRedisLab.Controller;

import com.mahmudkhon.springRedisLab.Model.Address;
import com.mahmudkhon.springRedisLab.Model.Profile;
import com.mahmudkhon.springRedisLab.Service.AddressService;
import com.mahmudkhon.springRedisLab.Service.ProfileService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ProfileController {

    private final ProfileService service;
    private final AddressService addressService;

    public ProfileController(ProfileService service, AddressService addressService) {
        this.service = service;
        this.addressService = addressService;
    }

    @PostMapping("/api/profiles/name")
    public ResponseEntity<Boolean>createProfile(@RequestBody Profile profile){
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(service.createProfile(profile));
    }

    @GetMapping("/api/profiles/{id}")
    public ResponseEntity<String>getById(@PathVariable Integer id){
        return ResponseEntity
                .status(HttpStatus.FOUND)
                .body(service.getProfile(id));
    }

    @DeleteMapping("/api/profiles/{id}")
    public ResponseEntity<String>delete(@PathVariable Integer id){
        return ResponseEntity
                .status(HttpStatus.ACCEPTED)
                .body(service.delete(id));
    }

    @PostMapping("/address")
    public boolean createAddress(@RequestBody Address address){
        return addressService.saveAddress(address);
    }

    @GetMapping("/address/{id}")
    public List<Object> get(@PathVariable int id){
        return addressService.get(id);
    }
}
