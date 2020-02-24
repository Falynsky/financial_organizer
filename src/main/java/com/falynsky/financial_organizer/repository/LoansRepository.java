package com.falynsky.financial_organizer.repository;

import com.falynsky.financial_organizer.model.Loans;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface LoansRepository extends JpaRepository<Loans, Integer> {

    Loans findByLoanId(Integer id);

    @Modifying
    @Query("update Loans l " +
            "set l.name = :#{#loan.getName()}, " +
            "l.value = :#{#loan.getValue()} " +
            "where l.loanId = :#{#loan.getLoanId()}")
    void updateLoan(@Param("loan") Loans loan);
}

