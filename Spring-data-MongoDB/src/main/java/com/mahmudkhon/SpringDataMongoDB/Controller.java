package com.mahmudkhon.SpringDataMongoDB;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Controller {

    @Autowired
    private Service service;


    @PostMapping("/add")
    public void add(@RequestBody EntityRequest request){
        service.save(request);
    }
}
