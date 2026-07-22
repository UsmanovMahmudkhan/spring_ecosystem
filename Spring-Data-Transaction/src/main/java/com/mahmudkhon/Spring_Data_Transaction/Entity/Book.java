package com.mahmudkhon.Spring_Data_Transaction.Entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "book")
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "title",length = 30)
    private String title;

    @Column(name = "author",length = 30)
    private String author;

    @Column(name = "uniqueNumber", unique = true)
    private String uniqueNumber;

    @Column(name = "totalCopies")
    private Integer totalCopies;

    @Column(name = "availableCopies")
    private Integer availableCopies;





}
