package com.mahmudkhon.Spring_Data_Transaction.DTOs;

import com.mahmudkhon.Spring_Data_Transaction.Entity.Member;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.validation.beanvalidation.SpringValidatorAdapter;

import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class LoanResponse {
    private Long id;
    private Long memberId;
    private String memberName;
    private Long bookId;
    private String bookTitle;
    private LocalDate borrowingDate;
    private LocalDate dueDate;
    private LocalDate returnDate;
}
