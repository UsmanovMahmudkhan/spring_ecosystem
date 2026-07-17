package com.mahmudkhon.Bicycle_Repair_Tracker.DTOs;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.mahmudkhon.Bicycle_Repair_Tracker.model.TicketStatus;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDate;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class TicketRequest {
   private String problem_title;
   private String description;
   private BigDecimal laborCost;
   private Boolean urgent;
   private LocalDate expectedFinishDate;
   private String customerMessage;
   private Byte photo;
   private Long referenceNumber;
   private String createdByBranch;
   private TicketStatus status;
   private Long customerId;

}
