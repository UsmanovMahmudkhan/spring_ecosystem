package com.Purchase.Book_Purchase_JDBC;

import java.math.BigDecimal;

public class CreatePurchaseRequest {

    private String name;
    private String category;
    private BigDecimal price;
    private PaymentMethod paymentMethod;

    public CreatePurchaseRequest() {
    }

    public String getName() {
        return name;
    }

    public String getCategory() {
        return category;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public PaymentMethod getPaymentMethod() {
        return paymentMethod;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public void setPaymentMethod(PaymentMethod paymentMethod) {
        this.paymentMethod = paymentMethod;
    }
}