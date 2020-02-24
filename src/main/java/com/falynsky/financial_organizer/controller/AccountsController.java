package com.falynsky.financial_organizer.controller;

import com.falynsky.financial_organizer.model.Accounts;
import com.falynsky.financial_organizer.repository.AccountsRepository;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/accounts/")
public class AccountsController {

    final AccountsRepository accountsRepository;

    public AccountsController(AccountsRepository accountsRepository) {
        this.accountsRepository = accountsRepository;
    }

    @GetMapping("/all")
    public List<Accounts> getAllAccounts() {
        return accountsRepository.findAll();
    }

    @GetMapping("/{id}")
    public Accounts getAccount(@PathVariable("id") Integer id) {
        return accountsRepository.findByAccountId(id);
    }

    @Transactional
    @PostMapping("/update/account")
    public void updateAccount(@RequestBody Accounts data) {
        accountsRepository.updateAccount(data);
    }
}
