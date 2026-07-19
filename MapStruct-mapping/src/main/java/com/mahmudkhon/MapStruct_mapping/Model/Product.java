package com.mahmudkhon.MapStruct_mapping.Model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;
import java.math.BigDecimal;
import java.time.LocalDateTime;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "product")
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name",nullable = false,length = 40)
    private String name;

    @Column(name = "description")
    private String description;

    @Column(name = "price")
    private BigDecimal price;

    @Column(name = "stockQuantity")
    private BigDecimal stockQuantity;

    @Column(name = "internalCost")
    private BigDecimal internalCost;   // never send as a response to user

    @CreationTimestamp
    @Column(name = "createdAt")
    private LocalDateTime createdAt;
}
