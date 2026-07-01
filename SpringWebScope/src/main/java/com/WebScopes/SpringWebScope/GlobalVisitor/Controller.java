package com.WebScopes.SpringWebScope.GlobalVisitor;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@org.springframework.stereotype.Controller
public class Controller {
    private VisitCounter counter;

    public Controller(VisitCounter counter) {
        this.counter = counter;
    }

    @GetMapping("/home")
    public String getVisitor(Model model){
        counter.count();
        model.addAttribute("visitor",counter);
        return "visitor";
    }



}
