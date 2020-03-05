package com.falynsky.financial_organizer.controller;

import com.falynsky.financial_organizer.model.BankAccountTypes;
import com.falynsky.financial_organizer.model.DTO.BankAccountTypesDTO;
import com.falynsky.financial_organizer.repository.BankAccountTypesRepository;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/bankAccountTypes")
public class BankAccountTypesController {
    final BankAccountTypesRepository bankAccountTypesRepository;

    public BankAccountTypesController(BankAccountTypesRepository bankAccountTypesRepository) {
        this.bankAccountTypesRepository = bankAccountTypesRepository;
    }

    @GetMapping("/all")
    public List<BankAccountTypesDTO> getAllBankAccountTypes() {
        return bankAccountTypesRepository.retrieveBankAccountTypesAsDTO();
    }

    @GetMapping("/{id}")
    public BankAccountTypes getBankAccountType(@PathVariable("id") Integer id) {
        return bankAccountTypesRepository.findByBankAccountTypeId(id);
    }

    @Transactional
    @PostMapping("/update")
    public void updateBankAccountType(@RequestBody BankAccountTypes data) {
        bankAccountTypesRepository.updateBankAccountType(data);
    }

}
