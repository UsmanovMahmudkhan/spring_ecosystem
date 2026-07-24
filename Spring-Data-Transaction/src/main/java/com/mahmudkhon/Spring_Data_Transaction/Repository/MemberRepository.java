package com.mahmudkhon.Spring_Data_Transaction.Repository;

import com.mahmudkhon.Spring_Data_Transaction.Entity.Member;
import jakarta.validation.constraints.Email;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MemberRepository extends JpaRepository<Member,Long> {
    boolean existsByEmail(@Email String email);
}
