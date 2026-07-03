package com.Web.Client.Using.OpenFeign;

import org.springframework.stereotype.Component;


public class Payment {
    private String id;
    private int amount;

    public Payment(String id, int amount) {
        this.id = id;
        this.amount = amount;
    }

    public Payment() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }
}
