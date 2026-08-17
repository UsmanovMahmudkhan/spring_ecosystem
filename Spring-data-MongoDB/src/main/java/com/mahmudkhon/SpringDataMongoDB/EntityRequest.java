package com.mahmudkhon.SpringDataMongoDB;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Service;

@Getter
@Service
@AllArgsConstructor
@NoArgsConstructor
public class EntityRequest {
    private String name;
    private String description;
}
