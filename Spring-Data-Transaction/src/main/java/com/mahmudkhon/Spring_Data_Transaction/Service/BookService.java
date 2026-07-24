package com.mahmudkhon.Spring_Data_Transaction.Service;

import com.mahmudkhon.Spring_Data_Transaction.DTOs.BookCreationRequest;
import com.mahmudkhon.Spring_Data_Transaction.DTOs.BookResponse;
import com.mahmudkhon.Spring_Data_Transaction.Exception.AlreadyAvailableException;
import com.mahmudkhon.Spring_Data_Transaction.Exception.NotFoundBookException;
import com.mahmudkhon.Spring_Data_Transaction.Mapper.BookMapper;
import com.mahmudkhon.Spring_Data_Transaction.Repository.BookRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class BookService {

    private final BookRepository repository;
    private final BookMapper mapper;

    public BookService(BookRepository repository, BookMapper mapper) {
        this.repository = repository;
        this.mapper = mapper;
    }


    public BookResponse createBook(BookCreationRequest request){
        if(repository.existsByUniqueNumber(request.getUniqueNumber())){
            throw new AlreadyAvailableException("Unique numbered book is already available");
        }
        var book=mapper.createBook(request);
        var total=book.getTotalCopies();
        book.setAvailableCopies(total);
        repository.save(book);

        return mapper.sendBookResponse(book);
    }

    @Transactional(readOnly = true)
    public List<BookResponse>getAllBook(){
        return mapper.sendBooksResponse(repository.findAll());
    }

    @Transactional(readOnly = true)
    public BookResponse getById(Long id){
        if(repository.existsById(id)){
            var book=repository.findById(id);
            return mapper.sendBookResponse(book.get());
        }
        else {
            throw new NotFoundBookException("Book is not Found!");
        }
    }

}
