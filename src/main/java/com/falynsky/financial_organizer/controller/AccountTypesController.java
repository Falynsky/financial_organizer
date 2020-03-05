package com.falynsky.financial_organizer.controller;

import com.falynsky.financial_organizer.model.AccountTypes;
import com.falynsky.financial_organizer.model.DTO.AccountTypesDTO;
import com.falynsky.financial_organizer.repository.AccountTypesRepository;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/accountTypes")
public class AccountTypesController {
    final AccountTypesRepository accountTypesRepository;

    public AccountTypesController(AccountTypesRepository accountTypesRepository) {
        this.accountTypesRepository = accountTypesRepository;
    }

    @GetMapping("/all")
    public List<AccountTypesDTO> getAllAccountTypes() {
        return accountTypesRepository.retrieveAccountTypesAsDTO();
    }

    @GetMapping("/{id}")
    public AccountTypesDTO getAccountType(@PathVariable("id") Integer id) {
        return accountTypesRepository.retrieveAccountTypeAsDTOById(id);
    }

    @Transactional
    @PostMapping("/update")
    public void updateAccountType(@RequestBody AccountTypes data) {
        accountTypesRepository.updateAccountType(data);
    }

}
