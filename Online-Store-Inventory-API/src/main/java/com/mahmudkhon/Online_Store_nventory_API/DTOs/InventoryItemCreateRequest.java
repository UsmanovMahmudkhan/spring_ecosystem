package com.mahmudkhon.Online_Store_nventory_API.DTOs;

import com.mahmudkhon.Online_Store_nventory_API.Model.StorageLocation;
import lombok.*;

import java.math.BigDecimal;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class InventoryItemCreateRequest {
    private String stockUnit;
    private String productName;
    private Integer quantity;
    private Integer reorderLevel;
    private BigDecimal unitPrice;
    private StorageLocation storageLocation;
    private Boolean isActive;
}
