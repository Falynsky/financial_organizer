package com.falynsky.financial_organizer.controller;

import com.falynsky.financial_organizer.model.*;
import com.falynsky.financial_organizer.repository.*;
import org.springframework.web.bind.annotation.*;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/loanTypes/")
public class LoanTypesController {

    final LoanTypesRepository loanTypesRepository;

    public LoanTypesController(LoanTypesRepository loanTypesRepository) {
        this.loanTypesRepository = loanTypesRepository;
    }

    @GetMapping("/all")
    public List<LoanTypes> getAllLoanTypes() {
        return loanTypesRepository.findAll();
    }

    @GetMapping("/{id}")
    public LoanTypes getLoanType(@PathVariable("id") Integer id) {
        return loanTypesRepository.findByLoanTypeId(id);
    }

    @Transactional
    @PostMapping("/update/loanType")
    public void updateLoan(@RequestBody LoanTypes data) {
        loanTypesRepository.updateLoanType(data);
    }

}
