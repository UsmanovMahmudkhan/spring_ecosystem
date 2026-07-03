package com.Payment.Client.Service.Payment.Client.Service;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@RestController
public class Controller {
    private PaymentClientFeign paymentClientFeign;

    public Controller(PaymentClientFeign paymentClientFeign) {
        this.paymentClientFeign = paymentClientFeign;
    }

    @PostMapping("/api/")
    public ResponseEntity<Payment>createPayment(@RequestHeader(name = "requestID") String header,@RequestBody PaymentRequest payment){
        return paymentClientFeign.responseEntity(header,payment);
}
}

