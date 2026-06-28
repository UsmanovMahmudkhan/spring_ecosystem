package com.springEco.Spring.Ecosystem.BrewHub.Service;

import com.springEco.Spring.Ecosystem.BrewHub.Model.Coffee;
import org.springframework.stereotype.Component;

@Component
public class Barista {

    private Coffee coffee;

    // Constructor injection. Two Coffee beans exist, so @Primary on coffee1
    // (Espresso) decides which one Spring passes in here.
    public Barista(Coffee coffee) {
        this.coffee = coffee;
    }

    public Coffee getCoffee() {
        return coffee;
    }

    public void setCoffee(Coffee coffee) {
        this.coffee = coffee;
    }

    public String makeCoffee() {
        return "Barista is making " + coffee.getName() + " coffee";
    }
}
