package com.mahmudkhon.Spring_Data_Transaction.Repository;

import com.mahmudkhon.Spring_Data_Transaction.Entity.Loan;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LoanRepository extends JpaRepository<Loan,Long> {
    boolean existsByBookId(Long id);
}
