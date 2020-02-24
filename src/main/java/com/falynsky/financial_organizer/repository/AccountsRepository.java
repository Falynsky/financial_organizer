package com.falynsky.financial_organizer.repository;

import com.falynsky.financial_organizer.model.Accounts;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
@Repository
public interface AccountsRepository extends JpaRepository<Accounts, Integer> {

    Accounts findByAccountId(Integer id);

    @Modifying
    @Query("update Accounts a " +
            "set a.login = :#{#account.getLogin()}," +
            "a.password = :#{#account.getPassword()} " +
            "where a.accountId = :#{#account.getAccountId()}")
    void updateAccount(@Param("account") Accounts account);

}
