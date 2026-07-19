package com.mahmudkhon.Online_Store_nventory_API.Model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "inventory")
public class InventoryItem extends BaseEntity{

    @Column(name = "stock_unit",length = 40, unique = true)
    private String stockUnit;

    @Column(name = "name",nullable = false,length = 20)
    private String productName;

    @Column(name = "quantity",nullable = false)
    private Integer quantity;

    @Column(name = "level")
    private Integer reorderLevel;

    @Column(name = "price")
    private BigDecimal unitPrice;

    @Embedded
    private StorageLocation storageLocation;

    @Column(name = "isActive")
    private Boolean isActive;

}
