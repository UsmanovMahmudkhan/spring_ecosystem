package com.mahmudkhon.Online_Store_nventory_API.Service;

import com.mahmudkhon.Online_Store_nventory_API.DTOs.InventoryItemCreateRequest;
import com.mahmudkhon.Online_Store_nventory_API.DTOs.InventoryItemResponse;
import com.mahmudkhon.Online_Store_nventory_API.DTOs.InventoryItemUpdateRequest;
import com.mahmudkhon.Online_Store_nventory_API.Exception.AlreadyExist;
import com.mahmudkhon.Online_Store_nventory_API.Mapper.InventoryMapper;
import com.mahmudkhon.Online_Store_nventory_API.Model.InventoryItem;
import com.mahmudkhon.Online_Store_nventory_API.Repository.InventoryItemRepository;
import jakarta.transaction.Transactional;
import lombok.*;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;


@Getter
@Setter
@Service
public class InventoryItemService {

    private final InventoryItemRepository repository;
    private final InventoryMapper mapper;

    public InventoryItemService(InventoryItemRepository repository, InventoryMapper mapper) {
        this.repository = repository;
        this.mapper = mapper;
    }

    public InventoryItemResponse create(InventoryItemCreateRequest request) {
        String stockUnit = request.getStockUnit();

        if (repository.existsByStockUnit(stockUnit)) {
            throw new AlreadyExist("Item already exists");
        }

        InventoryItem item = mapper.create_item(request);
        InventoryItem savedItem = repository.save(item);
        return mapper.response(savedItem);
    }

    public InventoryItemResponse findById(Long id) {
        Optional<InventoryItem> item = repository.findById(id);
        var inventItem = item.get();
        InventoryItemResponse response = mapper.response(inventItem);

        return response;
    }


    public InventoryItemResponse findBySku(String stock_unit) {
        var item = repository.findByStockUnit(stock_unit);
        var response = mapper.response(item);

        return response;
    }

    public List<InventoryItemResponse> findAll() {
        return mapper.response(repository.findAll());
    }

    public List<InventoryItemResponse> findByActive() {
        return mapper.response(repository.findByIsActiveTrue());
    }


    @Transactional
    public InventoryItemResponse update(
            Long id,
            InventoryItemUpdateRequest request
    ) {
        Optional<InventoryItem> item = repository.findById(id);

        mapper.update(request, item.get());

        repository.flush();

        return mapper.response(item.get());
    }

    @Transactional
    public InventoryItemResponse addStock(
            Long id,
            Integer amount
    ) {
        validateStockAmount(amount);

        Optional<InventoryItem> item = repository.findById(id);

        int currentQuantity = item.get().getQuantity();
        item.get().setQuantity(Math.addExact(currentQuantity, amount));

        repository.flush();

        return mapper.response(item.get());
    }

    @Transactional
    public InventoryItemResponse removeStock(
            Long id,
            Integer amount
    ) {
        validateStockAmount(amount);

        Optional<InventoryItem> item = repository.findById(id);

        int currentQuantity = getCurrentQuantity(item.get());

        if (amount > currentQuantity) {
            throw new ResponseStatusException(
                    HttpStatus.CONFLICT,
                    "Cannot remove more stock than is available"
            );
        }

        item.get().setQuantity(currentQuantity - amount);

        repository.flush();

        return mapper.response(item.get());
    }

    public boolean delete (Long id){
        if (repository.existsById(id)) {
            repository.deleteById(id);
            return true;
        } else {
            return false;
        }
    }

    private void validateStockAmount(Integer amount) {
        if (amount == null || amount <= 0) {
            throw new ResponseStatusException(
                    HttpStatus.BAD_REQUEST,
                    "Stock amount must be greater than zero"
            );
        }
    }

    private int getCurrentQuantity(InventoryItem item) {
        return item.getQuantity() == null
                ? 0
                : item.getQuantity();
    }
}


