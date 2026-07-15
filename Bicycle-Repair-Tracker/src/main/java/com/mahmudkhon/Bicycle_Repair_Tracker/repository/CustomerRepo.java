package com.mahmudkhon.Bicycle_Repair_Tracker.repository;

import com.mahmudkhon.Bicycle_Repair_Tracker.model.Customer;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerRepo extends CrudRepository<Customer,Long> {
}
