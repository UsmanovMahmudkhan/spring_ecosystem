package com.mahmudkhon.MapStruct_mapping.Controller;

import com.mahmudkhon.MapStruct_mapping.DTOs.ProductRequestDTO;
import com.mahmudkhon.MapStruct_mapping.DTOs.ProductResponseDTO;
import com.mahmudkhon.MapStruct_mapping.Service.ProductService;
import lombok.Getter;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1")
public class ProductController {

    private final ProductService service;

    public ProductController(ProductService service) {
        this.service = service;
    }

    @PostMapping("/add")
    public ResponseEntity<ProductResponseDTO>response(@RequestBody ProductRequestDTO requestDTO){
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(service.createProduct(requestDTO));
    }
}
