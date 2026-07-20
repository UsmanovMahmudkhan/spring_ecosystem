package com.mahmudkhon.Online_Store_nventory_API.Service;

import com.mahmudkhon.Online_Store_nventory_API.DTOs.InventoryItemCreateRequest;
import com.mahmudkhon.Online_Store_nventory_API.DTOs.InventoryItemResponse;
import com.mahmudkhon.Online_Store_nventory_API.Exception.AlreadyExist;
import com.mahmudkhon.Online_Store_nventory_API.Mapper.InventoryMapper;
import com.mahmudkhon.Online_Store_nventory_API.Model.InventoryItem;
import com.mahmudkhon.Online_Store_nventory_API.Repository.InventoryItemRepository;
import lombok.*;
import org.springframework.stereotype.Service;

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

    public InventoryItemResponse findById(Long id){
        Optional<InventoryItem> item=repository.findById(id);
        var inventItem=item.get();
        InventoryItemResponse response=mapper.response(inventItem);

        return response;
    }


    public InventoryItemResponse findBySku(String stock_unit){
        var item=repository.findByStockUnit(stock_unit);
        var response=mapper.response(item);

        return response;
    }

    public List<InventoryItemResponse> findAll(){
        return mapper.response(repository.findAll());
    }

    public List<InventoryItemResponse> findByActive(){
        return mapper.response(repository.findByIsActiveTrue());
    }

//    public InventoryItemResponse addStock(Long id,Integer value){
//        if((value > 0) && repository.existsById(id)){
//            Optional<InventoryItem> item=repository.findById(id);
//            int quantity=((InventoryItem)item.get()).getQuantity();
//            item.get().setQuantity(quantity+value);
//
//            return mapper.responseForOptional(item);
//        }
//
//        else {
//            throw new ItemNotFound("Item not found");
//        }
//    }
//
//    public InventoryItemResponse removeStock(Long id,Integer value){
//
//        if(value>0 && repository.existsById(id)){
//            var item=repository.findById(id);
//            if(item.get().getQuantity()>value){
//                item.get().setQuantity(item.get().getQuantity()-value);
//            }
//
//            return mapper.responseForOptional(item);
//        }
//
//        else {
//            throw new ItemNotFound("Not Found");
//        }
//    }

    public boolean delete(Long id){
        if(repository.existsById(id)){
            repository.deleteById(id);
            return true;
        }
        else {
            return false;
        }
    }

}
