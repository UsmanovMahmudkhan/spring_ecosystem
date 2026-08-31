package com.mahmudkhon.CustomFilter;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Controller {

    @GetMapping
    public String getMassage(){
        return "Hi Mahmudkhon";
    }
}
