package com.Purchase.Book_Purchase_JDBC;

import java.math.BigDecimal;
import java.time.LocalTime;

public class PurchaseDTO {

    private Integer id;
    private String name;
    private String category;
    private BigDecimal price;
    private LocalTime created;
    private PaymentMethod paymentMethod;
    private PaymentStatus paymentStatus;

    public PurchaseDTO(Integer id, String name, String category, BigDecimal price, PaymentMethod paymentMethod, PaymentStatus paymentStatus) {
        this.id = id;
        this.name = name;
        this.category = category;
        this.price = price;
        this.paymentMethod = paymentMethod;
        this.paymentStatus = paymentStatus;
    }

    public PurchaseDTO() {
    }

    public int getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public LocalTime getCreated() {
        return created;
    }

    public void setCreated(LocalTime created) {
        this.created = created;
    }

    public PaymentMethod getPaymentMethod() {
        return paymentMethod;
    }

    public void setPaymentMethod(PaymentMethod paymentMethod) {
        this.paymentMethod = paymentMethod;
    }

    public PaymentStatus getPaymentStatus() {
        return paymentStatus;
    }

    public void setPaymentStatus(PaymentStatus paymentStatus) {
        this.paymentStatus = paymentStatus;
    }


}
