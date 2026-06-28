package com.springEco.Spring.Ecosystem.Scopes.Singleton.eager;

import org.springframework.stereotype.Component;

@Component
public class Machine {
    public Machine() {
        System.out.println("Created");
    }
}
