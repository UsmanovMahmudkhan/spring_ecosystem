package com.mahmudkhon.Spring_Data_Transaction.Controller;

import com.mahmudkhon.Spring_Data_Transaction.DTOs.*;
import com.mahmudkhon.Spring_Data_Transaction.Exception.ExceptionCreatingLoan;
import com.mahmudkhon.Spring_Data_Transaction.Exception.NotEnoughAvailable;
import com.mahmudkhon.Spring_Data_Transaction.Service.BookService;
import com.mahmudkhon.Spring_Data_Transaction.Service.LoanService;
import com.mahmudkhon.Spring_Data_Transaction.Service.MemberService;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.apache.coyote.Response;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/v1")
public class LibraryController {

    private final BookService bookService;
    private final MemberService memberService;
    private final LoanService loanService;


    @PostMapping("/book")
    public ResponseEntity<BookResponse>createBook(@RequestBody BookCreationRequest request){
        return ResponseEntity.ok(bookService.createBook(request));
    }

    @GetMapping("/books")
    public ResponseEntity<List<BookResponse>>getALL(){
        return ResponseEntity
                .status(HttpStatus.FOUND)
                .body(bookService.getAllBook());
    }

    @GetMapping("/book/{id}")
    public ResponseEntity<BookResponse>getById(@PathVariable Long id){
        return ResponseEntity.
                status(HttpStatus.FOUND)
                .body(bookService.getById(id));
    }


    @PostMapping("/member")
    public ResponseEntity<MemberResponse>createMember(@RequestBody MemberCreationRequest request){
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(memberService.createMember(request));
    }


    @GetMapping("/members")
    public ResponseEntity<List<MemberResponse>>all(){
        return ResponseEntity
                .status(HttpStatus.FOUND)
                .body(memberService.getAll());
    }

    //Borrowing a book.

    @PostMapping("/borrow")
    public ResponseEntity<LoanResponse>borrow(@RequestBody BorrowingRequest requests) throws NotEnoughAvailable, ExceptionCreatingLoan {
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(loanService.borrowBook(requests));

    }

    @GetMapping("/all/borrow")
    public ResponseEntity<List<LoanResponse>>getAll(){
        return ResponseEntity.status(HttpStatus.FOUND).body(loanService.getAll());

    }













}
