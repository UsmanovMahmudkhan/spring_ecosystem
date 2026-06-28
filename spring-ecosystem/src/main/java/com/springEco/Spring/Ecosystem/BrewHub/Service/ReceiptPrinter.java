package com.springEco.Spring.Ecosystem.BrewHub.Service;

import com.springEco.Spring.Ecosystem.BrewHub.Model.Order;
import org.springframework.stereotype.Component;

@Component
public class ReceiptPrinter {

    private final OrderService orderService;

    public ReceiptPrinter(OrderService orderService) {
        this.orderService = orderService;
    }

    public void print() {
        Order order = orderService.createOrder();

        System.out.println("===== BrewHub Receipt =====");
        System.out.println("Customer: " + order.getCustomer().getName());
        System.out.println("Coffee:   " + order.getCoffee().getName());
        System.out.println("Made by:  " + orderService.getBarista().makeCoffee());
        System.out.println("Price:    " + orderService.getBarista().getCoffee().getPrice());
        System.out.println("Total:    " + order.getTotal());
        System.out.println("===========================");
    }
}
