package com.mahmudkhon.Bicycle_Repair_Tracker.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

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

    public RepairTicket(String title) {
        this.problem_title=title;
    }
}
