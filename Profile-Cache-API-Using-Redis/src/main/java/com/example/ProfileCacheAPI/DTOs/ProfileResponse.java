package com.example.ProfileCacheAPI.DTOs;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ProfileResponse {
    private Integer id;
    private String name;
    private String city;
    private String country;
    private LocalDate updatedAt;
}
