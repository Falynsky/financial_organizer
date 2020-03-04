package com.falynsky.financial_organizer.repository;

import com.falynsky.financial_organizer.model.BankAccounts;
import com.falynsky.financial_organizer.model.DTO.BankAccountsDTO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BankAccountsRepository extends JpaRepository<BankAccounts, Integer> {

    BankAccounts findByBankAccountId(Integer id);

    @Modifying
    @Query("update BankAccounts at " +
            "set at.name = :#{#bankAccount.getName()}," +
            "at.accountBalance = :#{#bankAccount.getAccountBalance()} " +
            "where at.bankAccountId = :#{#bankAccount.getBankAccountId()}")
    void updateBankAccount(@Param("bankAccount") BankAccounts bankAccount);

    @Query("SELECT b FROM BankAccounts AS b")
    List<BankAccounts> findAll();

    @Query("SELECT new com.falynsky.financial_organizer.model.DTO.BankAccountsDTO(b.bankAccountId, b.name,b.accountBalance, b.bankAccountTypesByBankAccountTypeId.bankAccountTypeId, b.accountsByAccountId.accountId) FROM BankAccounts b")
    List<BankAccountsDTO> retrieveBankAccountsAsDTO();

    @Query("SELECT new com.falynsky.financial_organizer.model.DTO.BankAccountsDTO(b.bankAccountId, b.name,b.accountBalance, b.bankAccountTypesByBankAccountTypeId.bankAccountTypeId, b.accountsByAccountId.accountId) FROM BankAccounts b WHERE b.bankAccountId = :bankAccountId")
    BankAccountsDTO retrieveBankAccountAsDTOById(@Param("bankAccountId") Integer bankAccountId);
}

