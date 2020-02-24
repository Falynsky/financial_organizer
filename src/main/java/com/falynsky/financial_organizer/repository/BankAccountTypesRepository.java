package com.falynsky.financial_organizer.repository;

import com.falynsky.financial_organizer.model.BankAccountTypes;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface BankAccountTypesRepository extends JpaRepository<BankAccountTypes, Integer> {

    BankAccountTypes findByBankAccountTypeId(Integer id);

    @Modifying
    @Query("update BankAccountTypes bat " +
            "set bat.name = :#{#bankAccountType.getName()} " +
            "where bat.bankAccountTypeId = :#{#bankAccountType.bankAccountTypeId()}")
    void updateBankAccountType(@Param("bankAccountType") BankAccountTypes bankAccountType);
}

