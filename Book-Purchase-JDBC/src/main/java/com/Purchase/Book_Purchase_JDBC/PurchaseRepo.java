package com.Purchase.Book_Purchase_JDBC;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import javax.sql.rowset.JdbcRowSet;
import java.math.BigDecimal;
import java.util.List;


@Repository
public class PurchaseRepo {

    private final JdbcTemplate template;

    public PurchaseRepo(JdbcTemplate template) {
        this.template = template;
    }

    public void addPurchase(String name, BigDecimal price) {
        String sql = "INSERT INTO purchase (name, price) VALUES (?, ?)";
        template.update(sql, name, price);
    }

    public List<PurchaseDTO> rowSet(){
        String sql="SELECT * FROM purchase";
        RowMapper<PurchaseDTO>rowMapper=(r,i)->{
            PurchaseDTO purchaseDTO=new PurchaseDTO();
            purchaseDTO.setId(r.getInt("id"));
            purchaseDTO.setName(r.getString("name"));
            purchaseDTO.setPrice(r.getBigDecimal("price"));
            return purchaseDTO;
        };

        return template.query(sql,rowMapper);
    }
}
