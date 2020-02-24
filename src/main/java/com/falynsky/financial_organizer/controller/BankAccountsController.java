package com.falynsky.financial_organizer.controller;

import com.falynsky.financial_organizer.model.BankAccounts;
import com.falynsky.financial_organizer.repository.BankAccountsRepository;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/bankAccounts/")
public class BankAccountsController {
    final BankAccountsRepository bankAccountsRepository;

    public BankAccountsController(BankAccountsRepository bankAccountsRepository) {
        this.bankAccountsRepository = bankAccountsRepository;
    }

    @GetMapping("/all")
    public List<BankAccounts> getAllBankAccounts() {
        return bankAccountsRepository.findAll();
    }

    @GetMapping("/{id}")
    public BankAccounts getBankAccount(@PathVariable("id") Integer id) {
        return bankAccountsRepository.findByBankAccountId(id);
    }

    @Transactional
    @PostMapping("/bankAccount/update")
    public void updateBankAccount(@RequestBody BankAccounts data) {
        bankAccountsRepository.updateBankAccount(data);
    }
}
