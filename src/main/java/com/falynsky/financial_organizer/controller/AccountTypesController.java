package com.falynsky.financial_organizer.controller;

import com.falynsky.financial_organizer.model.AccountTypes;
import com.falynsky.financial_organizer.repository.AccountTypesRepository;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/accountTypes/")
public class AccountTypesController {
    final AccountTypesRepository accountTypesRepository;

    public AccountTypesController(AccountTypesRepository accountTypesRepository) {
        this.accountTypesRepository = accountTypesRepository;
    }

    @GetMapping("/all")
    public List<AccountTypes> getAllAccountTypes() {
        return accountTypesRepository.findAll();
    }

    @GetMapping("/{id}")
    public AccountTypes getAccountType(@PathVariable("id") Integer id) {
        return accountTypesRepository.findByAccountTypeId(id);
    }

    @Transactional
    @PostMapping("/update/accountType")
    public void updateAccountType(@RequestBody AccountTypes data) {
        accountTypesRepository.updateAccountType(data);
    }

}