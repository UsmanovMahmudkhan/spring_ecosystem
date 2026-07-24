package com.mahmudkhon.Spring_Data_Transaction.Repository;

import com.mahmudkhon.Spring_Data_Transaction.Entity.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BookRepository extends JpaRepository<Book,Long> {
    boolean existsByUniqueNumber(String uniqueNumber);
}
