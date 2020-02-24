package com.falynsky.financial_organizer.repository;

import com.falynsky.financial_organizer.model.AccountTypes;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface AccountTypesRepository extends JpaRepository<AccountTypes, Integer> {

    AccountTypes findByAccountTypeId(Integer id);

    @Modifying
    @Query("update AccountTypes at " +
            "set at.name = :#{#accountType.getName()}," +
            "at.permissionLevel = :#{#accountType.getPermissionLevel()} " +
            "where at.accountTypeId = :#{#accountType.getAccountTypeId()}")
    void updateAccountType(@Param("accountType") AccountTypes accountType);
}

