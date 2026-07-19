package com.mahmudkhon.MapStruct_mapping.DTOs;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ProductRequestDTO {
     private String name;
     private String description;
     private BigDecimal price;
     private BigDecimal stockQuantity;
     private BigDecimal internalCost;
}
