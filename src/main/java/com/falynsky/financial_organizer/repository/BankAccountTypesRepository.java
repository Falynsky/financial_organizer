package com.falynsky.financial_organizer.repository;

import com.falynsky.financial_organizer.model.BankAccountTypes;
import com.falynsky.financial_organizer.model.DTO.BankAccountTypesDTO;
import com.falynsky.financial_organizer.model.Subjects;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BankAccountTypesRepository extends JpaRepository<BankAccountTypes, Integer> {

    BankAccountTypes findByBankAccountTypeId(Integer id);

    @Modifying
    @Query(value = "update bank_account_types bat " +
            "set bat.name = :#{#bankAccountType.getName()} " +
            "where bat.bank_account_type_id = :#{#bankAccountType.getBankAccountTypeId()}", nativeQuery = true)
    void updateBankAccountType(@Param("bankAccountType") BankAccountTypesDTO bankAccountType);

    @Query("SELECT bt FROM BankAccountTypes AS bt")
    List<BankAccountTypes> findAll();

    @Query("SELECT new com.falynsky.financial_organizer.model.DTO.BankAccountTypesDTO(bt.bankAccountTypeId, bt.name) FROM BankAccountTypes bt")
    List<BankAccountTypesDTO> retrieveBankAccountTypesAsDTO();

}

