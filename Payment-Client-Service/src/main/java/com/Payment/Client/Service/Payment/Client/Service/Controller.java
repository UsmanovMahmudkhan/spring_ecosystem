package com.Payment.Client.Service.Payment.Client.Service;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
public class Controller {
    private PaymentClientFeign paymentClientFeign;

    public Controller(PaymentClientFeign paymentClientFeign) {
        this.paymentClientFeign = paymentClientFeign;
    }

    @PostMapping("/api/payment")
    public ResponseEntity<Payment>createPayment(@RequestHeader(name = "requestID") String header,@RequestBody PaymentRequest payment){
        return paymentClientFeign.responseEntity(header,payment);
}
    @GetMapping("/api/payment/{id}")
    public ResponseEntity<Payment>getPayment(@PathVariable(name = "id") String id){
        return paymentClientFeign.getPayment(id);
    }

    @GetMapping("/search")
    public ResponseEntity<Payment>getSearchPayment(@RequestParam int min, @RequestParam int max){
        return paymentClientFeign.getSearch(min, max);
    }
}

