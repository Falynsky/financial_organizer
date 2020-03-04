package com.falynsky.financial_organizer.controller;

import com.falynsky.financial_organizer.model.*;
import com.falynsky.financial_organizer.model.DTO.LoanTypesDTO;
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
    public List<LoanTypesDTO> getAllLoanTypes() {
        return loanTypesRepository.retrieveLoanTypesAsDTO();
    }

    @GetMapping("/{id}")
    public LoanTypesDTO getLoanType(@PathVariable("id") Integer id) {
        return loanTypesRepository.retrieveLoanTypeAsDTOById(id);
    }

    @Transactional
    @PostMapping("/update/loanType")
    public void updateLoan(@RequestBody LoanTypes data) {
        loanTypesRepository.updateLoanType(data);
    }

}
