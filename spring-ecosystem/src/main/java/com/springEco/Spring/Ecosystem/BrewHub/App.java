package com.springEco.Spring.Ecosystem.BrewHub;

import com.springEco.Spring.Ecosystem.BrewHub.Model.Coffee;
import com.springEco.Spring.Ecosystem.BrewHub.Service.ReceiptPrinter;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.function.Supplier;

public class App {
    public static void main(String[] args) {
        var context = new AnnotationConfigApplicationContext(Config.class);

        var printer = context.getBean(ReceiptPrinter.class);
        printer.print();

        // Programmatic registration based on a condition:
        // only register the coffee of the day if it is affordable.
        Coffee special = new Coffee();
        special.setName("Cappuccino");
        special.setPrice(3.0F);

        if (special.getPrice() < 5.0F) {
            Supplier<Coffee> supplier = () -> special;
            context.registerBean("coffeeOfTheDay", Coffee.class, supplier);

            Coffee fromContext = context.getBean("coffeeOfTheDay", Coffee.class);
            System.out.println("\nCoffee of the day (from context): " + fromContext);
        }
    }
}
