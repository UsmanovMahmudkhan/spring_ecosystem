package com.Web.Client.Using.OpenFeign;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

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
}
