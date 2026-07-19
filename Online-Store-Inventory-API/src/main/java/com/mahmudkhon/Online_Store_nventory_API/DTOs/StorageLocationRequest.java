package com.mahmudkhon.Online_Store_nventory_API.DTOs;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class StorageLocationRequest {
    private String aisle;
    private String shelf;
    private String bin;
}
