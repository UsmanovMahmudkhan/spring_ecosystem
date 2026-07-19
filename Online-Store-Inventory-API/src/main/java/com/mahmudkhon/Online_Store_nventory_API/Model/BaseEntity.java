package com.mahmudkhon.Online_Store_nventory_API.Model;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;

import java.time.Instant;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@MappedSuperclass
public abstract class BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "createAt")
    @CreationTimestamp
    private Instant createAt;

    @Column(name = "updateAt")
    private Instant updateAt;

}
