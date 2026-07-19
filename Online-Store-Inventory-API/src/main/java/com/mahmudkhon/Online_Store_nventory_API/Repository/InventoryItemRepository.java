package com.mahmudkhon.Online_Store_nventory_API.Repository;

import com.mahmudkhon.Online_Store_nventory_API.Model.InventoryItem;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;


public interface InventoryItemRepository extends JpaRepository<InventoryItem, Long> {

    InventoryItem findByStockUnit(String stockUnit);
    boolean existsByStockUnit(String stockUnit);
    List<InventoryItem> findByIsActiveTrue();
    List<InventoryItem> findByQuantityLessThanEqual(Integer quantity);

}
