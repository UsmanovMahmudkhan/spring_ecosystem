package com.mahmudkhon.Spring_Data_Transaction.Service;

import com.mahmudkhon.Spring_Data_Transaction.DTOs.BorrowingRequest;
import com.mahmudkhon.Spring_Data_Transaction.DTOs.LoanResponse;
import com.mahmudkhon.Spring_Data_Transaction.Entity.Book;
import com.mahmudkhon.Spring_Data_Transaction.Entity.Member;
import com.mahmudkhon.Spring_Data_Transaction.Exception.ExceptionCreatingLoan;
import com.mahmudkhon.Spring_Data_Transaction.Exception.NotEnoughAvailable;
import com.mahmudkhon.Spring_Data_Transaction.Mapper.LoanMapper;
import com.mahmudkhon.Spring_Data_Transaction.Repository.BookRepository;
import com.mahmudkhon.Spring_Data_Transaction.Repository.LoanRepository;
import com.mahmudkhon.Spring_Data_Transaction.Repository.MemberRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class LoanService {

    private final LoanRepository repository;
    private final LoanMapper mapper;
    private final BookRepository bookRepository;
    private final MemberRepository memberRepository;

    public LoanService(LoanRepository repository, LoanMapper mapper, BookRepository bookRepository, MemberRepository memberRepository) {
        this.repository = repository;
        this.mapper = mapper;
        this.bookRepository = bookRepository;
        this.memberRepository = memberRepository;
    }

    @Transactional(rollbackFor = {
            NotEnoughAvailable.class,
            ExceptionCreatingLoan.class
    })
    public LoanResponse borrowBook(BorrowingRequest request) throws NotEnoughAvailable, ExceptionCreatingLoan {

        Book book=bookRepository.findById(request.getBookId()).orElseThrow();
        Member member=memberRepository.findById((request.getMemberId())).orElseThrow();

        if(book.getAvailableCopies()>0){
            var loan=mapper.createLoan(book,member);
            loan.getBook().borrow();
            repository.save(loan);
            return mapper.toResponse(loan);
        }
        else {
            throw new ExceptionCreatingLoan("Could not create Loan contract!");
        }
    }

    public List<LoanResponse> getAll(){
        return mapper.getAll(repository.findAll());
    }
}
