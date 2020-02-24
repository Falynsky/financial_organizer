package com.falynsky.financial_organizer.repository;

import com.falynsky.financial_organizer.model.LoanTypes;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface LoanTypesRepository extends JpaRepository<LoanTypes, Integer> {

    LoanTypes findByLoanTypeId(Integer id);

    @Modifying
    @Query("update LoanTypes lt " +
            "set lt.name = :#{#loanType.getName()} " +
            "where lt.loanTypeId = :#{#loanType.getLoanTypeId()}")
    void updateLoanType(@Param("loanType") LoanTypes loanType);
}

