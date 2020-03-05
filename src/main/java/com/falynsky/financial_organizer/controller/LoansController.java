package com.falynsky.financial_organizer.controller;

import com.falynsky.financial_organizer.model.DTO.LoansDTO;
import com.falynsky.financial_organizer.model.Loans;
import com.falynsky.financial_organizer.repository.LoansRepository;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/loans")
public class LoansController {
    final LoansRepository loansRepository;

    public LoansController(LoansRepository loansRepository) {
        this.loansRepository = loansRepository;
    }

    @GetMapping("/all")
    public List<LoansDTO> getAllLoans() {
        return loansRepository.retrieveLoansAsDTO();
    }

    @GetMapping("/{id}")
    public LoansDTO getLoan(@PathVariable("id") Integer id) {
        return loansRepository.retrieveLoanAsDTOById(id);
    }

    @Transactional
    @PostMapping("/update")
    public void updateLoan(@RequestBody Loans data) {
        loansRepository.updateLoan(data);
    }

}
