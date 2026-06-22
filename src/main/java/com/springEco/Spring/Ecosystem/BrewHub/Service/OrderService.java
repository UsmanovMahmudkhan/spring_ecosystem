package com.springEco.Spring.Ecosystem.BrewHub.Service;

import com.springEco.Spring.Ecosystem.BrewHub.Model.Coffee;
import com.springEco.Spring.Ecosystem.BrewHub.Model.Customer;
import com.springEco.Spring.Ecosystem.BrewHub.Model.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class OrderService {

    private final Barista barista;          // constructor injection
    private Customer customer;               // setter injection
    @Autowired
    private PriceCatalog priceCatalog;       // field injection

    public OrderService(Barista barista) {
        this.barista = barista;
    }

    @Autowired
    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    // Builds the Order from the injected beans.
    public Order createOrder() {
        Coffee coffee = barista.getCoffee();

        Order order = new Order();
        order.setCoffee(coffee);
        order.setCustomer(customer);
        order.setTotal(priceCatalog.getCoffeePrice(coffee));
        return order;
    }

    public Barista getBarista() {
        return barista;
    }
}
