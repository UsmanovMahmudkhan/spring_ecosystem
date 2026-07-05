package com.Purchase.Book_Purchase_JDBC;


import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.time.LocalTime;
import java.util.logging.Logger;


@Repository
public class PurchaseRepo {

    private final JdbcTemplate template;

    public PurchaseRepo(JdbcTemplate template) {
        this.template = template;
    }

    public boolean addPurchase(CreatePurchaseRequest request) {

        PurchaseDTO purchaseDTO=new PurchaseDTO();
        purchaseDTO.setName(request.getName());
        purchaseDTO.setCategory(request.getCategory());
        purchaseDTO.setPrice(request.getPrice());
        purchaseDTO.setCreated(LocalTime.now());
        purchaseDTO.setPaymentMethod(PaymentMethod.CASH);
        purchaseDTO.setPaymentStatus(PaymentStatus.ACTIVE);
        String sql = """
            INSERT INTO purchase (name, category, price, created, payment, status)
            VALUES (?, ?, ?, ?, ?, ?)
            """;

        try {
            template.update(
                    sql,
                    purchaseDTO.getName(),
                    purchaseDTO.getCategory(),
                    purchaseDTO.getPrice(),
                    purchaseDTO.getCreated(),
                    purchaseDTO.getPaymentMethod().name(),
                    purchaseDTO.getPaymentStatus().name()
            );

            return true;
        } catch (Exception e) {
            Logger.getLogger(PurchaseRepo.class.getName()).severe(e.getMessage());
            return false;
        }
    }
}



//?\id
//name
//category
//price
//created date
//payment method
//status