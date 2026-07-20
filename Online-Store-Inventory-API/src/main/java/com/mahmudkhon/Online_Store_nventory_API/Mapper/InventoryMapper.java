package com.mahmudkhon.Online_Store_nventory_API.Mapper;

import com.mahmudkhon.Online_Store_nventory_API.DTOs.*;
import com.mahmudkhon.Online_Store_nventory_API.Model.InventoryItem;
import com.mahmudkhon.Online_Store_nventory_API.Model.StorageLocation;
import org.mapstruct.*;

import java.util.List;
import java.util.Optional;

@Mapper(componentModel = "spring")
public interface InventoryMapper {

    //InventoryItemCreateRequest → InventoryItem
    InventoryItem create_item(InventoryItemCreateRequest request);


    //InventoryItem → InventoryItemResponse
    @Mapping(source = "isActive", target = "active")
    @Mapping(source = "createAt", target = "createdAt")
    @Mapping(source = "updateAt", target = "updatedAt")
    InventoryItemResponse response(InventoryItem item);


    //StorageLocationRequest → StorageLocation
    StorageLocation createStorageLocation(StorageLocationRequest request);


    //StorageLocation → StorageLocationResponse
    StorageLocationResponse responseOfStorageLocation(StorageLocation location);

    @Mapping(source = "isActive", target = "active")
    @Mapping(source = "createAt", target = "createdAt")
    @Mapping(source = "updateAt", target = "updatedAt")
    List<InventoryItemResponse> response(List<InventoryItem> all);
    //InventoryItemUpdateRequest + InventoryItem → updated InventoryItem

    @BeanMapping(
            nullValuePropertyMappingStrategy =
                    NullValuePropertyMappingStrategy.IGNORE
    )
    @Mapping(target = "id", ignore = true)
    @Mapping(target = "stockUnit", ignore = true)
    @Mapping(target = "createAt", ignore = true)
    @Mapping(target = "updateAt", ignore = true)
    void update(
            InventoryItemUpdateRequest request,
            @MappingTarget InventoryItem item
    );

}


