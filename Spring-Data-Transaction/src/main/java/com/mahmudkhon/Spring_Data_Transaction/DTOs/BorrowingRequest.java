package com.mahmudkhon.Spring_Data_Transaction.DTOs;

import com.mahmudkhon.Spring_Data_Transaction.Entity.Book;
import com.mahmudkhon.Spring_Data_Transaction.Entity.Member;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class BorrowingRequest {
    private Long bookId;
    private Long memberId;
}
