package com.mahmudkhon.Spring_Data_Transaction.Mapper;

import com.mahmudkhon.Spring_Data_Transaction.DTOs.BookCreationRequest;
import com.mahmudkhon.Spring_Data_Transaction.DTOs.BookResponse;
import com.mahmudkhon.Spring_Data_Transaction.Entity.Book;
import org.mapstruct.Mapper;

import java.util.List;


@Mapper(componentModel = "spring")
public interface BookMapper {

    Book createBook(BookCreationRequest request);
    BookResponse sendBookResponse(Book book);
    List<BookResponse> sendBooksResponse(List<Book>books);

}
