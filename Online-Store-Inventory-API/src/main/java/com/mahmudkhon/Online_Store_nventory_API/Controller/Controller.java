package com.mahmudkhon.Online_Store_nventory_API.Controller;

import com.mahmudkhon.Online_Store_nventory_API.DTOs.InventoryItemCreateRequest;
import com.mahmudkhon.Online_Store_nventory_API.DTOs.InventoryItemResponse;
import com.mahmudkhon.Online_Store_nventory_API.Service.InventoryItemService;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/api/inventory")
public class Controller {

    private final InventoryItemService inventoryItemService;

    public Controller(InventoryItemService service) {
        this.inventoryItemService = service;
    }

    @PostMapping
    public ResponseEntity<InventoryItemResponse>createItem(@RequestBody InventoryItemCreateRequest request){
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(inventoryItemService.create(request));
    }

    @GetMapping
    public ResponseEntity<List<InventoryItemResponse>>getAll(){
        return ResponseEntity
                .status(HttpStatus.FOUND)
                .body(inventoryItemService.findAll());
    }



}
