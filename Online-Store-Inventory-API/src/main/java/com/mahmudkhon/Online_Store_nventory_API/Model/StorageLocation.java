package com.mahmudkhon.Online_Store_nventory_API.Model;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Embeddable
public class StorageLocation {

    @Column(name = "location_aisle",nullable = false,length = 10)
    private String aisle;

    @Column(name = "location_shelf",nullable = false,length = 10)
    private String shelf;

    @Column(name = "location_bin",nullable = false,length = 10)
    private String bin;
}
