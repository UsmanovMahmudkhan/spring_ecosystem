package com.mahmudkhon.springRedisLab2;

import org.jspecify.annotations.Nullable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class Controller {

    @Autowired
    private Service service;

    @PostMapping("/add")
    public void add(@RequestBody UserRequest request){
        service.save(request);
    }

    @GetMapping("/add/{key}")
    public @Nullable User get(@PathVariable String key){
        return service.get(key);
    }
}
