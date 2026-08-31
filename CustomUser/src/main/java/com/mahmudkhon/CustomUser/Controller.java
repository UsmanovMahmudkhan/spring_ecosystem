package com.mahmudkhon.CustomUser;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Controller {

    @GetMapping
    public String customeUser(){
        return "Hello Mahmudkhon";
    }
}
