package com.example.ProfileCacheAPI.Controller;

import com.example.ProfileCacheAPI.DTOs.ProfileRequest;
import com.example.ProfileCacheAPI.DTOs.ProfileResponse;
import com.example.ProfileCacheAPI.Exceptions.ProfileNotFoundException;
import com.example.ProfileCacheAPI.Service.ProfileService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class ProfileContoller {

    private final ProfileService service;

    public ProfileContoller(ProfileService service) {
        this.service = service;
    }

    @PostMapping("/add")
    private ResponseEntity<Boolean>create(@RequestBody ProfileRequest request)  {
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .header("country", request.getCountry())
                .body(service.createProfile(request));
    }

    @GetMapping("/profiles/{id}")
    public ResponseEntity<ProfileResponse>get(@PathVariable Integer id) throws ProfileNotFoundException {
        return ResponseEntity
                .status(HttpStatus.FOUND)
                .body(service.getById(id));
    }
}
