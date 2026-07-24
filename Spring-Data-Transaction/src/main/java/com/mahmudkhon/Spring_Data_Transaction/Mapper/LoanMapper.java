package com.mahmudkhon.Spring_Data_Transaction.Mapper;

import com.mahmudkhon.Spring_Data_Transaction.DTOs.BorrowingRequest;
import com.mahmudkhon.Spring_Data_Transaction.DTOs.LoanResponse;
import com.mahmudkhon.Spring_Data_Transaction.Entity.Book;
import com.mahmudkhon.Spring_Data_Transaction.Entity.Loan;
import com.mahmudkhon.Spring_Data_Transaction.Entity.Member;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.springframework.data.jpa.repository.Meta;

import java.util.List;

@Mapper(componentModel = "spring")
public interface LoanMapper {


    @Mapping(target = "id", ignore = true)
    @Mapping(target = "dueDateTime", ignore = true)
    @Mapping(target = "returnTime", ignore = true)
    Loan createLoan(Book book, Member member);

    @Mapping(source = "member.id", target = "memberId")
    @Mapping(source = "member.name", target = "memberName")
    @Mapping(source = "book.id", target = "bookId")
    @Mapping(source = "book.title", target = "bookTitle")
    @Mapping(source = "date",target = "borrowingDate")
    @Mapping(source = "dueDateTime",target = "dueDate")
    LoanResponse toResponse(Loan loan);

    @Mapping(source = "member.id", target = "memberId")
    @Mapping(source = "member.name", target = "memberName")
    @Mapping(source = "book.id", target = "bookId")
    @Mapping(source = "book.title", target = "bookTitle")
    @Mapping(source = "date",target = "borrowingDate")
    @Mapping(source = "dueDateTime",target = "dueDate")
    List<LoanResponse>getAll(List<Loan>loan);

}
