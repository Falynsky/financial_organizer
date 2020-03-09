package com.falynsky.financial_organizer.controller;

import com.falynsky.financial_organizer.model.BankAccounts;
import com.falynsky.financial_organizer.model.DTO.BankAccountsDTO;
import com.falynsky.financial_organizer.repository.BankAccountsRepository;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/bankAccounts")
public class BankAccountsController {
    final BankAccountsRepository bankAccountsRepository;

    public BankAccountsController(BankAccountsRepository bankAccountsRepository) {
        this.bankAccountsRepository = bankAccountsRepository;
    }

    @GetMapping("/all")
    public List<BankAccountsDTO> getAllBankAccounts() {
        return bankAccountsRepository.retrieveBankAccountsAsDTO();
    }

    @GetMapping("/my")
    public List<BankAccountsDTO> getAllMyBankAccounts(@RequestParam(value = "login") String login) {
        return bankAccountsRepository.retrieveMyBankAccountsAsDTO(login);
    }

    @GetMapping("/{id}")
    public BankAccountsDTO getBankAccount(@PathVariable("id") Integer id) {
        return bankAccountsRepository.retrieveBankAccountAsDTOById(id);
    }

    @Transactional
    @PostMapping("/update")
    public void updateBankAccount(@RequestBody BankAccountsDTO data) {
        bankAccountsRepository.updateBankAccount(data);
    }
}
