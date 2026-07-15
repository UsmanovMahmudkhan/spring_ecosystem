package com.mahmudkhon.Bicycle_Repair_Tracker.repository;

import com.mahmudkhon.Bicycle_Repair_Tracker.model.Mechanic;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface MechanicRepo extends CrudRepository<Mechanic,Long> {

}
