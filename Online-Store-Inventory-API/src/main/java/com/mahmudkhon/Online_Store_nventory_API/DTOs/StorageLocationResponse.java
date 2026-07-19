package com.mahmudkhon.Online_Store_nventory_API.DTOs;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class StorageLocationResponse {
    private String aisle;
    private String shelf;
    private String bin;
}
