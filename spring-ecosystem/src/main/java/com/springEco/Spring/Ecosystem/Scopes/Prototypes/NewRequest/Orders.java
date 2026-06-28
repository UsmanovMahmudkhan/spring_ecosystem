package com.springEco.Spring.Ecosystem.Scopes.Prototypes.NewRequest;

import com.springEco.Spring.Ecosystem.BrewHub.Model.Order;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import java.lang.reflect.Type;

@Component
@Scope("prototype")
public class Orders {
    public Orders() {
        System.out.println("Orders Created!");
    }
}
