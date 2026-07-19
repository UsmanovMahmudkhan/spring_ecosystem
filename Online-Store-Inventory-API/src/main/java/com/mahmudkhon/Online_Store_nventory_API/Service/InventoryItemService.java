package com.mahmudkhon.Online_Store_nventory_API.Service;

import com.mahmudkhon.Online_Store_nventory_API.Repository.InventoryItemRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class InventoryItemService {

    private final InventoryItemRepository repository;


}
