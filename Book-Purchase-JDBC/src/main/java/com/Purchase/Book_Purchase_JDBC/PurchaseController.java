package com.Purchase.Book_Purchase_JDBC;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.time.LocalTime;
import java.util.List;

@RestController
public class PurchaseController {

    private PurchaseRepo purchaseRepo;

    public PurchaseController(PurchaseRepo purchaseRepo) {
        this.purchaseRepo = purchaseRepo;
    }

    @PostMapping("/post")
    public ResponseEntity<Boolean>add(@RequestBody CreatePurchaseRequest product){

        var isADDED=purchaseRepo.addPurchase(product);

            return ResponseEntity.status(HttpStatus.ACCEPTED)
                    .body(isADDED);



    }

    @GetMapping("/all")
    public ResponseEntity<List<PurchaseDTO>>getAll(){
        return ResponseEntity
                .status(HttpStatus.FOUND)
                .header("service","this is coming from purchase server")
                .body(purchaseRepo.allPurchase());
    }

    @GetMapping("/{id}")
    public ResponseEntity<List<PurchaseDTO>>getById(@PathVariable int id){
        if(!purchaseRepo.getPurchaseByID(id).isEmpty()){
            return ResponseEntity
                    .status(HttpStatus.FOUND)
                    .body(purchaseRepo.getPurchaseByID(id));
        }
        else {
            return
                    ResponseEntity
                            .status(HttpStatus.NO_CONTENT)
                            .body(null);
        }

    }

}
