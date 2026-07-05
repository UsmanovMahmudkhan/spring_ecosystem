package com.Purchase.Book_Purchase_JDBC;

import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.util.List;

@RestController
public class PurchaseController {

    private  PurchaseRepo purchaseRepo;

    public PurchaseController(PurchaseRepo purchaseRepo) {
        this.purchaseRepo = purchaseRepo;
    }

    @PostMapping("/post")
    public void addPurchaseDTO(@RequestParam String product, @RequestParam BigDecimal price){
        purchaseRepo.addPurchase(product,price);
    }

    @GetMapping("/all")
    public List<PurchaseDTO>getALL(){
        return purchaseRepo.rowSet();
    }
}
