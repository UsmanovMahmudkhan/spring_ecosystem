package com.mahmudkhon.Bicycle_Repair_Tracker.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "customer")
public class Customer {

    @Id
    @Column(name = "id", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name",nullable = false,length = 40)
    private String name;

    @Column(name = "email",unique = true,nullable = false,length = 40)
    private String email;

    @JsonIgnore
    @OneToMany(mappedBy = "customer")
    private List<RepairTicket> repairTicket;

    public Customer(String name, String email) {
        this.name = name;
        this.email = email;
    }
}
