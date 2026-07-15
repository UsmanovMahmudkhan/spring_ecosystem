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
public class Mechanic {
    @Id
    @Column(name ="id",unique = true,nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name",length = 40,nullable = false)
    private String name;

    @Column(name = "professioin",nullable = false,length = 40)
    private String profession;

}
