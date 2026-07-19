package com.mahmudkhon.Online_Store_nventory_API.Repository;

import com.mahmudkhon.Online_Store_nventory_API.Model.InventoryItem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;


public interface InventoryItemRepository extends JpaRepository<InventoryItem, Long> {

    InventoryItem findBySku(String stock_unit);
    InventoryItem existsByStock_unit(String stock_unit);
    InventoryItem findByActiveTrue();
    InventoryItem findByQuantityLessThanEqual(Integer quantity);
}
