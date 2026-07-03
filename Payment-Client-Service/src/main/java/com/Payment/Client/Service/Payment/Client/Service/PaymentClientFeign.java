package com.Payment.Client.Service.Payment.Client.Service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@FeignClient(url = "http://localhost:8080/", name = "payment-service")
public interface PaymentClientFeign {

    @PostMapping("/payment")
    public ResponseEntity<Payment>responseEntity(@RequestHeader(name = "requestID") String requestID,
                                                 @RequestBody PaymentRequest amount);

    @GetMapping("/payment/{id}")
    public ResponseEntity<Payment>getPayment(@PathVariable(name = "id")String id);
}
