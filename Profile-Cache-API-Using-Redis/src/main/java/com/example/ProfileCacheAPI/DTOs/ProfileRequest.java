package com.example.ProfileCacheAPI.DTOs;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.resilience.annotation.EnableResilientMethods;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ProfileRequest {
    private String name;
    private String city;
    private String country;
}
