package com.falynsky.financial_organizer.repository;

import com.falynsky.financial_organizer.model.DTO.LoansDTO;
import com.falynsky.financial_organizer.model.Loans;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface LoansRepository extends JpaRepository<Loans, Integer> {

    Loans findByLoanId(Integer id);

    @Modifying
    @Query("update Loans l " +
            "set l.name = :#{#loan.getName()}, " +
            "l.value = :#{#loan.getValue()} " +
            "where l.loanId = :#{#loan.getLoanId()}")
    void updateLoan(@Param("loan") Loans loan);

    @Query("SELECT l FROM Loans AS l")
    List<Loans> findAll();

    @Query("SELECT new com.falynsky.financial_organizer.model.DTO.LoansDTO(l.loanId, l.name, l.value, l.accountsByAccountId.accountId, l.loanTypesByLoanTypesId.loanTypeId ) FROM Loans l")
    List<LoansDTO> retrieveLoansAsDTO();

    @Query("SELECT new com.falynsky.financial_organizer.model.DTO.LoansDTO(l.loanId, l.name, l.value, l.accountsByAccountId.accountId, l.loanTypesByLoanTypesId.loanTypeId ) FROM Loans l WHERE l.loanId = :loanId")
    LoansDTO retrieveLoanAsDTOById(@Param("loanId") Integer loanId);
}

