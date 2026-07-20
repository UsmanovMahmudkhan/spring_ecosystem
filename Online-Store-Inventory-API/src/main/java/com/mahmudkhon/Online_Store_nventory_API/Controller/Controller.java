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

    @GetMapping("{id}")
    public ResponseEntity<InventoryItemResponse>getByID(@PathVariable Long id){
        return ResponseEntity.ok(inventoryItemService.findById(id));
    }

    @GetMapping("sku/{sku}")
    public ResponseEntity<InventoryItemResponse>getBySku(@PathVariable String sku){
        return ResponseEntity.ok(inventoryItemService.findBySku(sku));
    }

    @GetMapping("/active")
    public ResponseEntity<List<InventoryItemResponse>>getByActive(){
        return ResponseEntity.ok(inventoryItemService.findByActive());
    }


    @GetMapping("/low-stock}")
    public List<InventoryItemResponse>getByLowStock(@RequestParam Long id,
                                                    @RequestParam Integer value){
        inventoryItemService.

    }



}
