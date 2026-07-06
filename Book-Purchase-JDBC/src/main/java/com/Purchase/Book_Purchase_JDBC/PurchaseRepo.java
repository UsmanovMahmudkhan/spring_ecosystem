package com.Purchase.Book_Purchase_JDBC;


import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.time.LocalTime;
import java.util.List;
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


    public List<PurchaseDTO>allPurchase(){
        String sql="SELECT * FROM purchase";

        RowMapper<PurchaseDTO>rowMapper=(r,i)->{
            PurchaseDTO purchase=new PurchaseDTO();
            purchase.setId(r.getInt("id"));
            purchase.setName(r.getString("name"));
            purchase.setCategory(r.getString("category"));
            purchase.setPrice(r.getBigDecimal("price"));
            purchase.setCreated(r.getTime("created").toLocalTime());
            purchase.setPaymentMethod(PaymentMethod.valueOf(r.getString("payment")));
            purchase.setPaymentStatus(PaymentStatus.valueOf(r.getString("status")));

            return purchase;
        };

        return template.query(sql,rowMapper);
    }

    public List<PurchaseDTO> getPurchaseByID(int id){
        String sql="SELECT * FROM purchase WHERE id=?";
        RowMapper<PurchaseDTO>rowMapper=(r,i)->
        {
            PurchaseDTO purchase=new PurchaseDTO();
            purchase.setId(r.getInt("id"));
            purchase.setName(r.getString("name"));
            purchase.setCategory(r.getString("category"));
            purchase.setPrice(r.getBigDecimal("price"));
            purchase.setCreated(r.getTime("created").toLocalTime());
            purchase.setPaymentMethod(PaymentMethod.valueOf(r.getString("payment")));
            purchase.setPaymentStatus(PaymentStatus.valueOf(r.getString("status")));

            return purchase;
        };

        return template.query(sql,rowMapper,id);

    }
}



//Search Purchases By Price Range

//?\id
//name
//category
//price
//created date
//payment method
//status