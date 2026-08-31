package com.mahmudkhon.IntroductionToSecurity.Controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Controller {

    @GetMapping("/hi")
    public String getGreet(){
        return "hi Mahmudkhon";
    }

    //Using generated security password: ef50a17a-a23d-4cdb-89f7-d22c6a27adf8
    // username: username
}

