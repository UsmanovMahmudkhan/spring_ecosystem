package com.mahmudkhon.Online_Store_nventory_API.DTOs;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class InventoryItemUpdateRequest {
    private String productName;
    private Integer quantity;
    private Integer reorderLevel;
    private BigDecimal unitPrice;
    private StorageLocationRequest storageLocation;
    private Boolean active;
}
