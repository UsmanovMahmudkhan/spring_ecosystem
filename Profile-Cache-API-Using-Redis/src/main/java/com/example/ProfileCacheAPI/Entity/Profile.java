package com.example.ProfileCacheAPI.Entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDate;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "Profile")
public class Profile {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id",unique = true)
    private Integer id;

    @Column(name = "name",length = 30)
    private String name;

    @Column(name = "city",nullable = true, updatable = true,length = 40)
    private String city;

    @Column(name = "country",nullable = false,columnDefinition = "Write you country name")
    private String country;

    @Column(name = "updated_at")
    @CreationTimestamp
    private LocalDate updatedAt;
}
