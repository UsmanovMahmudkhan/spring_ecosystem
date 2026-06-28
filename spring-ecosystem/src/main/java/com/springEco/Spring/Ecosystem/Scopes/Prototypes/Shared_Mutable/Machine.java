package com.springEco.Spring.Ecosystem.Scopes.Prototypes.Shared_Mutable;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope("prototype")
public class Machine {
    int counter=0;

    public int brew(){
       return counter++;
    }

    public int getCounter() {
        return counter;
    }

}
