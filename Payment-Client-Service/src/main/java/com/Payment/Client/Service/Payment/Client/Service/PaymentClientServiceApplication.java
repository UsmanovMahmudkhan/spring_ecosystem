package com.Payment.Client.Service.Payment.Client.Service;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@EnableFeignClients
@SpringBootApplication
public class PaymentClientServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(PaymentClientServiceApplication.class, args);
	}

}
