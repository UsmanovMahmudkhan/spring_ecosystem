package com.mahmudkhon.Bicycle_Repair_Tracker.repository;

import com.mahmudkhon.Bicycle_Repair_Tracker.model.RepairTicket;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RepairTicketRepo extends CrudRepository<RepairTicket, Long> {
}
