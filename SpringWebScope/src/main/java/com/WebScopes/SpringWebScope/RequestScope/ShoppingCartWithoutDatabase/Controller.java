package com.WebScopes.SpringWebScope.RequestScope.ShoppingCartWithoutDatabase;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestParam;

@org.springframework.stereotype.Controller
public class Controller {

    private ShoppingCart cart;

    public Controller(ShoppingCart cart) {
        this.cart = cart;
    }


    @GetMapping("/products")
    public String getProduct(Model model){
        model.addAttribute("products",cart.getCartItems());
        return "Product";
    }


    @PostMapping("/cart/add")
    public String addProduct(@RequestParam String productName,
                             @RequestParam int quantity,
                             @RequestParam int price){
        cart.getCartItems().add(new CartItem(productName,quantity,price));
        return "redirect:/products";
    }


    @PutMapping("/cart/remove")
    public String remove(@RequestParam String name){
        for(CartItem item:cart.getCartItems()){
            if(name.equals(item.getProductName())){
                cart.getCartItems().remove(item);
                break;
            }
        }
       return "redirect:/products";
    }


    @PutMapping("/clear")
    public String clear(Model model){
        cart.getCartItems().clear();
        if(cart.getCartItems().isEmpty()){
            model.addAttribute("clear",true);
        }
        else {
            model.addAttribute("clear",false);
        }

        return "redirect:/products";
    }
}
