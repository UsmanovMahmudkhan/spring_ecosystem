package com.mahmudkhon.Bicycle_Repair_Tracker.model;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.UUID;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor

@Entity
@Table(name = "problem")
public class RepairTicket {
    @Id
    @Column(name = "id",nullable = false,unique = true)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "title",nullable = true, unique = false, length = 50)
    private String problem_title;

    @Column(name = "description")
    private String description;

    @Column(name = "laborCost",nullable = false)
    private BigDecimal laborCost;

    @Column(name = "urgent",nullable = false)
    private Boolean urgent;

    @CreationTimestamp
    @Column(name = "openedAt", nullable = false,updatable = false)
    private LocalDateTime openedAt;

    @Column(name = "expectedFinishDate")
    private LocalDate expectedFinishDate;

    @Column(name = "customerMessage",length = 50)
    private String customerMessage;

    @Column(name = "photo")
    private Byte photo;

    @Column(name = "referenceNumber",unique = true, nullable = false)
    private Long referenceNumber;

    @Column(name = "createdByBranch",updatable = false)
    private String createdByBranch;

    public RepairTicket(String problem_title) {
        this.problem_title = problem_title;
    }
}
