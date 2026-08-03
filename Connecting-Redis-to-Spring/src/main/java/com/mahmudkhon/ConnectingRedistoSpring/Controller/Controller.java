package com.mahmudkhon.ConnectingRedistoSpring.Controller;

import com.mahmudkhon.ConnectingRedistoSpring.Model.User;
import com.mahmudkhon.ConnectingRedistoSpring.Service.UserService;
import org.springframework.web.bind.annotation.*;

@RestController
public class Controller {

    private final UserService service;

    public Controller(UserService service) {
        this.service = service;
    }

    @PostMapping
    public void save(@RequestBody User user){
        service.save(user);
    }

    @GetMapping("/get/{key}")
    public String getUser(@PathVariable int key){
        return service.getUser(key);
    }
}
