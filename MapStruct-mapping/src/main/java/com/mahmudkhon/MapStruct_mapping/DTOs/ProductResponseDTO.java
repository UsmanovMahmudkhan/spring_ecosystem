package com.mahmudkhon.MapStruct_mapping.DTOs;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ProductResponseDTO
{
    private Long id;
    private String productName;
    private String description;
    private BigDecimal sellingPrice;
    private BigDecimal availableStock;
    private LocalDateTime createdAt;
}
