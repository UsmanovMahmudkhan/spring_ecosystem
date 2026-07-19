package com.mahmudkhon.MapStruct_mapping.Mapper;

import com.mahmudkhon.MapStruct_mapping.DTOs.ProductRequestDTO;
import com.mahmudkhon.MapStruct_mapping.DTOs.ProductResponseDTO;
import com.mahmudkhon.MapStruct_mapping.Model.Product;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface ProductMapper {

    Product toProduct(ProductRequestDTO productRequestDTO);

    @Mapping(target = "productName",source = "name")
    @Mapping(target = "sellingPrice",source = "price")
    @Mapping(target = "availableStock",source = "stockQuantity")
    ProductResponseDTO toResponse(Product product);
}
