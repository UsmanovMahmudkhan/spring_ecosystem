package com.mahmudkhon.Spring_Data_Transaction.DTOs;

import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class BookCreationRequest {
    @NotEmpty
    private String title;
    @NotEmpty
    private String author;
    private String uniqueNumber;
    private Integer totalCopies;
}
