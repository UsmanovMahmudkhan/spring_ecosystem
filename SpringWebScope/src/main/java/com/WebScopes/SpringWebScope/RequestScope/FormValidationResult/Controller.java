package com.WebScopes.SpringWebScope.RequestScope.FormValidationResult;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.context.annotation.RequestScope;

@org.springframework.stereotype.Controller
public class Controller {

    private FormProcessor processor;

    public Controller(FormProcessor processor) {
        this.processor = processor;
    }

    @GetMapping("/contact")
    public String getContact(){
        return "contact";
    }

    @PostMapping("/contact")
    public String createContact(@RequestParam String name,
                              @RequestParam String email,
                              @RequestParam String message,
                              Model model) throws InterruptedException {

        Form form=new Form(name,email,message);
        var processed=processor.process(form);

        model.addAttribute("contact",processed);
        model.addAttribute("processor",processor);
        return "contact";
    }
}
