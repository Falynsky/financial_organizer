package com.falynsky.financial_organizer.repository;

import com.falynsky.financial_organizer.model.Accounts;
import com.falynsky.financial_organizer.model.DTO.AccountsDTO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AccountsRepository extends JpaRepository<Accounts, Integer> {

    Accounts findByAccountId(Integer id);

    @Modifying
    @Query("update Accounts a " +
            "set a.login = :#{#account.getLogin()}," +
            "a.password = :#{#account.getPassword()} " +
            "where a.accountId = :#{#account.getAccountId()}")
    void updateAccount(@Param("account") Accounts account);

    @Query("SELECT a FROM Accounts AS a")
    List<Accounts> findAll();

    @Query("SELECT new com.falynsky.financial_organizer.model.DTO.AccountsDTO(a.accountId,a.login, a.password, a.accountTypesByAccountTypeId.accountTypeId, a.subjectsBySubjectId.subjectId) FROM Accounts a")
    List<AccountsDTO> retrieveAccountsAsDTO();

    @Query("SELECT new com.falynsky.financial_organizer.model.DTO.AccountsDTO(a.accountId,a.login, a.password, a.accountTypesByAccountTypeId.accountTypeId, a.subjectsBySubjectId.subjectId) FROM Accounts a WHERE a.accountId = :accountId")
    AccountsDTO retrieveAccountAsDTOById(@Param("accountId") Integer accountId);
}
