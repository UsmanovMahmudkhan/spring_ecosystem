package com.Web.Client.Using.OpenFeign;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
public class PaymentController {

    @PostMapping("/payment")
    public ResponseEntity<Payment>responseEntity(@RequestHeader String requestID,
                                                 @RequestBody PaymentRequest amount){
        Payment payment=new Payment();
        String random= UUID.randomUUID().toString();
        payment.setId(random);
        payment.setAmount(amount.getAmount());

        return ResponseEntity
                .status(HttpStatus.ACCEPTED)
                .header("requestID",requestID)
                .header("Serive","this is from payment service")
                .body(payment);

    }

    @GetMapping("/payment/{id}")
    public ResponseEntity<Payment>getPayment(@PathVariable String id){
        Payment payment=new Payment();
        if("p-100".equals(id)){
            payment.setId(id);
            payment.setAmount(250);
            return ResponseEntity
                    .status(HttpStatus.ACCEPTED)
                    .header("service","this is from payment service")
                    .body(payment);
        }
        else {
            return (ResponseEntity<Payment>) ResponseEntity.status(HttpStatus.FAILED_DEPENDENCY);
        }
    }
}
