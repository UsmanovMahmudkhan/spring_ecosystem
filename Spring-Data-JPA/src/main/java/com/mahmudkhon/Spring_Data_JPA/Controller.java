package com.mahmudkhon.Spring_Data_JPA;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Optional;

@RestController
public class Controller {

    @Autowired
    CurrencyDOA currencyDOA;

    @GetMapping("/{id}")
    public Optional<Currency> currency(@PathVariable BigDecimal id){
        return currencyDOA.findById(id);
    }


}
