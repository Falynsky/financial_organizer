package com.falynsky.financial_organizer.repository;

import com.falynsky.financial_organizer.model.DTO.LoanTypesDTO;
import com.falynsky.financial_organizer.model.LoanTypes;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface LoanTypesRepository extends JpaRepository<LoanTypes, Integer> {

    LoanTypes findByLoanTypeId(Integer id);

    @Modifying
    @Query(value = "update loan_types lt " +
            "set lt.name = :#{#loanType.getName()} " +
            "where lt.loan_type_id = :#{#loanType.getLoanTypeId()}", nativeQuery = true)
    void updateLoanType(@Param("loanType") LoanTypesDTO loanType);

    @Query("SELECT lt FROM LoanTypes AS lt")
    List<LoanTypes> findAll();

    @Query("SELECT new com.falynsky.financial_organizer.model.DTO.LoanTypesDTO(lt.loanTypeId, lt.name) FROM LoanTypes lt")
    List<LoanTypesDTO> retrieveLoanTypesAsDTO();

    @Query("SELECT new com.falynsky.financial_organizer.model.DTO.LoanTypesDTO(lt.loanTypeId, lt.name) FROM LoanTypes lt WHERE lt.loanTypeId = :loanTypeId")
    LoanTypesDTO retrieveLoanTypeAsDTOById(@Param("loanTypeId") Integer loanTypeId);
}

