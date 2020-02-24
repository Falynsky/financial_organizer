package com.falynsky.financial_organizer.controller;

import com.falynsky.financial_organizer.model.*;
import com.falynsky.financial_organizer.repository.*;
import org.springframework.web.bind.annotation.*;

import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api/")
public class MainController {

    final AccountsRepository accountsRepository;
    final AccountTypesRepository accountTypesRepository;
    final BankAccountsRepository bankAccountsRepository;
    final BankAccountTypesRepository bankAccountTypesRepository;
    final LoansRepository loansRepository;
    final LoanTypesRepository loanTypesRepository;
    final SubjectsRepository subjectsRepository;


    public MainController(AccountsRepository accountsRepository,
                          AccountTypesRepository accountTypesRepository,
                          BankAccountsRepository bankAccountsRepository,
                          BankAccountTypesRepository bankAccountTypesRepository,
                          LoansRepository loansRepository,
                          LoanTypesRepository loanTypesRepository,
                          SubjectsRepository subjectsRepository) {

        this.accountsRepository = accountsRepository;
        this.accountTypesRepository = accountTypesRepository;
        this.bankAccountsRepository = bankAccountsRepository;
        this.bankAccountTypesRepository = bankAccountTypesRepository;
        this.loansRepository = loansRepository;
        this.loanTypesRepository = loanTypesRepository;
        this.subjectsRepository = subjectsRepository;
    }

    @GetMapping("/accounts")
    public List<Accounts> getAllAccounts() {
        return accountsRepository.findAll();
    }

    @GetMapping("/account/{id}")
    public Accounts getAccount(@PathVariable("id") Integer id) {
        return accountsRepository.findByAccountId(id);
    }

    @GetMapping("/accountTypes")
    public List<AccountTypes> getAllAccountTypes() {
        return accountTypesRepository.findAll();
    }

    @GetMapping("/accountType/{id}")
    public AccountTypes getAccountType(@PathVariable("id") Integer id) {
        return accountTypesRepository.findByAccountTypeId(id);
    }

    @GetMapping("/bankAccounts")
    public List<BankAccounts> getAllBankAccounts() {
        return bankAccountsRepository.findAll();
    }

    @GetMapping("/bankAccount/{id}")
    public BankAccounts getBankAccount(@PathVariable("id") Integer id) {
        return bankAccountsRepository.findByBankAccountId(id);
    }

    @GetMapping("/bankAccountTypes")
    public List<BankAccountTypes> getAllBankAccountTypes() {
        return bankAccountTypesRepository.findAll();
    }

    @GetMapping("/bankAccountType/{id}")
    public BankAccountTypes getBankAccountType(@PathVariable("id") Integer id) {
        return bankAccountTypesRepository.findByBankAccountTypeId(id);
    }

    @GetMapping("/loans")
    public List<Loans> getAllLoans() {
        return loansRepository.findAll();
    }

    @GetMapping("/loan/{id}")
    public Loans getLoan(@PathVariable("id") Integer id) {
        return loansRepository.findByLoanId(id);
    }

    @GetMapping("/loanTypes")
    public List<LoanTypes> getAllLoanTypes() {
        return loanTypesRepository.findAll();
    }

    @GetMapping("/loanType/{id}")
    public LoanTypes getLoanType(@PathVariable("id") Integer id) {
        return loanTypesRepository.findByLoanId(id);
    }

    @GetMapping("/subjects")
    public List<Subjects> getAllSubjects() {
        return subjectsRepository.findAll();
    }

    @GetMapping("/subject/{id}")
    public Subjects getSubject(@PathVariable("id") Integer id) {
        return subjectsRepository.findBySubjectId(id);
    }


    @Transactional
    @PostMapping("/account")
    public void updateAccount(@RequestBody Accounts data) {
        accountsRepository.updateAccount(data);
    }

    @Transactional
    @PostMapping("/accountType")
    public void updateAccountType(@RequestBody AccountTypes data) {
        accountTypesRepository.updateAccountType(data);
    }

    @Transactional
    @PostMapping("/bankAccount")
    public void updateBankAccount(@RequestBody BankAccounts data) {
        bankAccountsRepository.updateBankAccount(data);
    }

    @Transactional
    @PostMapping("/bankAccountType")
    public void updateBankAccountType(@RequestBody BankAccountTypes data) {
        bankAccountTypesRepository.updateBankAccountType(data);
    }

    @Transactional
    @PostMapping("/loan")
    public void updateLoan(@RequestBody Loans data) {
        loansRepository.updateLoan(data);
    }

    @Transactional
    @PostMapping("/loanType")
    public void updateLoan(@RequestBody LoanTypes data) {
        loanTypesRepository.updateLoanType(data);
    }


    @Transactional
    @PostMapping("/subject")
    public void updateSubject(@RequestBody Subjects data) {
        subjectsRepository.updateSubject(data);
    }


}
