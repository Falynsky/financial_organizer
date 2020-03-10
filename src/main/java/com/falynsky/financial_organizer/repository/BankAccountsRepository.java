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
    @Query(value = "update bank_accounts at " +
            "set at.name = :#{#bankAccount.getName()}," +
            "at.account_balance = :#{#bankAccount.getAccountBalance()}, " +
            "at.bank_account_type_id = :#{#bankAccount.getBankAccountTypesByBankAccountTypeId()}, " +
            "at.account_id = :#{#bankAccount.getAccountsByAccountId()} " +
            "where at.bank_account_id = :#{#bankAccount.getBankAccountId()}", nativeQuery = true)
    void updateBankAccount(@Param("bankAccount") BankAccountsDTO bankAccount);

    @Query("SELECT b FROM BankAccounts AS b")
    List<BankAccounts> findAll();

    @Query("SELECT new com.falynsky.financial_organizer.model.DTO.BankAccountsDTO(" +
            "b.bankAccountId, " +
            "b.name, " +
            "b.accountBalance, " +
            "b.bankAccountTypesByBankAccountTypeId.bankAccountTypeId, " +
            "b.accountsByAccountId.accountId) FROM BankAccounts b")
    List<BankAccountsDTO> retrieveBankAccountsAsDTO();

    @Query("SELECT new com.falynsky.financial_organizer.model.DTO.BankAccountsDTO(" +
            "b.bankAccountId, " +
            "b.name, " +
            "b.accountBalance, " +
            "b.bankAccountTypesByBankAccountTypeId.bankAccountTypeId, " +
            "b.accountsByAccountId.accountId) FROM BankAccounts b " +
            "WHERE b.accountsByAccountId.accountId = (select a.accountId from Accounts a where a.login = :login)")
    List<BankAccountsDTO> retrieveMyBankAccountsAsDTO(@Param("login") String login);

    @Query("SELECT new com.falynsky.financial_organizer.model.DTO.BankAccountsDTO(b.bankAccountId, b.name,b.accountBalance, b.bankAccountTypesByBankAccountTypeId.bankAccountTypeId, b.accountsByAccountId.accountId) FROM BankAccounts b WHERE b.bankAccountId = :bankAccountId")
    BankAccountsDTO retrieveBankAccountAsDTOById(@Param("bankAccountId") Integer bankAccountId);
}

