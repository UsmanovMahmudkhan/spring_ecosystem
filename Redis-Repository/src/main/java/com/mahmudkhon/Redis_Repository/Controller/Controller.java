package com.mahmudkhon.Redis_Repository.Controller;

import com.mahmudkhon.Redis_Repository.Entity.User;
import com.mahmudkhon.Redis_Repository.Service.Service;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class Controller {

    private final Service service;

    @PostMapping
    public void save(@RequestBody User user){
        service.save(user);
    }

    @GetMapping("/get")
    public List<User> get(){
        return service.getALL();
    }

    @DeleteMapping("{id}")
    public void delete(@PathVariable Long id){
        service.remove(id);
    }
}


