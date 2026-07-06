package com.Purchase.Book_Purchase_JDBC;

import org.jspecify.annotations.Nullable;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class PurchaseMapper implements RowMapper {
    @Override
    public @Nullable Object mapRow(ResultSet rs, int rowNum) throws SQLException {

        PurchaseDTO purchase=new PurchaseDTO();
        purchase.setId(rs.getInt("id"));
        purchase.setName(rs.getString("name"));
        purchase.setCategory(rs.getString("category"));
        purchase.setPrice(rs.getBigDecimal("price"));
        purchase.setCreated(rs.getTime("created").toLocalTime());
        purchase.setPaymentMethod(PaymentMethod.valueOf(rs.getString("payment")));
        purchase.setPaymentStatus(PaymentStatus.valueOf(rs.getString("status")));

        return purchase;

    }
}
