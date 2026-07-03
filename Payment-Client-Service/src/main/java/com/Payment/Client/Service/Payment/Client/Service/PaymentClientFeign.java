package com.Payment.Client.Service.Payment.Client.Service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;

@FeignClient(url = "http://localhost:8080/", name = "payment-service")
public interface PaymentClientFeign {

    @PostMapping("/payment")
    public ResponseEntity<Payment>responseEntity(@RequestHeader(name = "requestID") String requestID,
                                                 @RequestBody PaymentRequest amount);

}
