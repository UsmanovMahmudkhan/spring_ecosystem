package com.mahmudkhon.MapStruct_mapping.Repository;

import com.mahmudkhon.MapStruct_mapping.Model.Product;
import org.springframework.data.repository.CrudRepository;


public interface ProductRepo extends CrudRepository<Product,Long> {
}
