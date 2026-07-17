package com.mahmudkhon.Bicycle_Repair_Tracker.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Optional;

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

    @JsonFormat(pattern = "yyyy-MM-dd")
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

    @Column(name = "status",nullable = false)
    @Enumerated(EnumType.STRING)
//    @EnumeratedValue
    private TicketStatus status;


    @ManyToOne
    @JoinColumn(name = "customer_id")
    private Customer customer;

    @OneToOne
    @JoinColumn(name = "assigned_id")
    private Mechanic assignedMechanic;

    public RepairTicket(String problem_title,
                        String description,
                        BigDecimal laborCost,
                        Boolean urgent,
                        LocalDate expectedFinishDate,
                        String customerMessage,
                        Byte photo,
                        Long referenceNumber,
                        String createdByBranch,
                        TicketStatus status

    ) {
        this.problem_title = problem_title;
        this.description = description;
        this.laborCost = laborCost;
        this.urgent = urgent;
        this.expectedFinishDate = expectedFinishDate;
        this.customerMessage = customerMessage;
        this.photo = photo;
        this.referenceNumber = referenceNumber;
        this.createdByBranch = createdByBranch;
        this.status=status;


    }

}
