package com.falynsky.financial_organizer.repository;

import com.falynsky.financial_organizer.model.BankAccounts;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface BankAccountsRepository extends JpaRepository<BankAccounts, Integer> {

    BankAccounts findByBankAccountId(Integer id);

    @Modifying
    @Query("update BankAccounts at " +
            "set at.name = :#{#bankAccount.getName()}," +
            "at.accountBalance = :#{#bankAccount.getAccountBalance()} " +
            "where at.bankAccountId = :#{#bankAccount.getBankAccountId()}")
    void updateBankAccount(@Param("bankAccount") BankAccounts bankAccount);
}

