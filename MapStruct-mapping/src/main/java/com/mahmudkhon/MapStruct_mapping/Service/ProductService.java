package com.mahmudkhon.MapStruct_mapping.Service;

import com.mahmudkhon.MapStruct_mapping.DTOs.ProductRequestDTO;
import com.mahmudkhon.MapStruct_mapping.DTOs.ProductResponseDTO;
import com.mahmudkhon.MapStruct_mapping.Mapper.ProductMapper;
import com.mahmudkhon.MapStruct_mapping.Repository.ProductRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class ProductService {

    private final ProductRepo repo;


    private final ProductMapper mapper;

    public ProductService(ProductRepo repo, ProductMapper mapper) {
        this.repo = repo;

        this.mapper = mapper;
    }

    public ProductResponseDTO createProduct(ProductRequestDTO requestDTO){

          var product=mapper.toProduct(requestDTO);

          repo.save(product);

          var response=mapper.toResponse(product);

//        Product product=new Product();
//
//        product.setName(requestDTO.getName());
//        product.setDescription(requestDTO.getDescription());
//        product.setPrice(requestDTO.getPrice());
//        product.setInternalCost(requestDTO.getInternalCost());
//        product.setStockQuantity(requestDTO.getStockQuantity());
//
//        repo.save(product);
//
//
//        ProductResponseDTO response=new ProductResponseDTO();
//        response.setId(product.getId());
//        response.setProductName(product.getName());
//        response.setDescription(product.getDescription());
//        response.setCreatedAt(product.getCreatedAt());
//        response.setSellingPrice(product.getPrice());
//        response.setAvailableStock(product.getStockQuantity());

        return response;

    }
}
