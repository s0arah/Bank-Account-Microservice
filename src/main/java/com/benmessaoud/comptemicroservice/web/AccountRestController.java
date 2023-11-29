package com.benmessaoud.comptemicroservice.web;

import com.benmessaoud.comptemicroservice.dto.BankAccountRequestDto;
import com.benmessaoud.comptemicroservice.dto.BankAccountResponseDto;
import com.benmessaoud.comptemicroservice.entities.BankAccount;
import com.benmessaoud.comptemicroservice.mappers.AccountMapper;
import com.benmessaoud.comptemicroservice.repository.BankAccountRepository;
import com.benmessaoud.comptemicroservice.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api")
public class AccountRestController {
    BankAccountRepository bankAccountRepository;
    AccountService accountService;
    AccountMapper accountMapper;
    public AccountRestController(BankAccountRepository bankAccountRepositoryl) {
        this.bankAccountRepository = bankAccountRepositoryl;
        this.accountService = accountService;
        this.accountMapper = accountMapper;
    }


    @GetMapping("/bankaccounts")
    public List<BankAccount> bankaccounts(){
        return bankAccountRepository.findAll();

      }
    @GetMapping("/bankaccounts/{id}")
    public BankAccount bankaccount(@PathVariable String id){
        return bankAccountRepository.findById(id).orElseThrow(()->new RuntimeException(String.format("Account %s not found",id)));

    }

    @PostMapping("/bankAccounts")
    public BankAccountResponseDto save(@RequestBody BankAccountRequestDto requestDto) {

        return accountService.addAccount(requestDto);

    }

    @PutMapping ("/bankAccounts/{id}")
    public BankAccount update(@PathVariable String id, BankAccount bankAccount) {
        BankAccount account = bankAccountRepository.findById(id).orElseThrow();
        if(account.getBalance() != null) account.setBalance(bankAccount.getBalance());
        if(account.getCurrency() != null) account.setCurrency(bankAccount.getCurrency());
        if(account.getCreatedAt()!= null)account.setCreatedAt(bankAccount.getCreatedAt());
            return bankAccountRepository.save(bankAccount);
    }
    @DeleteMapping("/bankAccounts/{id}")
    public void delete(@PathVariable String id){
        bankAccountRepository.findById(id);
    }
}
