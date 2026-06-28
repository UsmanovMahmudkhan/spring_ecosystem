package com.springEco.Spring.Ecosystem.BrewHub.Service;

import com.springEco.Spring.Ecosystem.BrewHub.Model.Coffee;
import org.springframework.stereotype.Component;

@Component
public class PriceCatalog {

    public float getCoffeePrice(Coffee coffee) {
        return coffee.getPrice();
    }
}
