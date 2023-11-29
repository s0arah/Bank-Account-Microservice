package com.benmessaoud.comptemicroservice.web;

import com.benmessaoud.comptemicroservice.dto.BankAccountRequestDto;
import com.benmessaoud.comptemicroservice.dto.BankAccountResponseDto;
import com.benmessaoud.comptemicroservice.entities.BankAccount;
import com.benmessaoud.comptemicroservice.entities.Customer;
import com.benmessaoud.comptemicroservice.repository.BankAccountRepository;
import com.benmessaoud.comptemicroservice.repository.CustomerRepository;
import com.benmessaoud.comptemicroservice.service.AccountService;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;

import java.util.List;

@Controller
public class BankAccountGraphqlController {
    @Autowired
    private BankAccountRepository bankAccountRepository;
    @Autowired
    AccountService accountService;
    @Autowired
    CustomerRepository customerRepository;

    @QueryMapping
    public List<BankAccount> accountsList() {
        return bankAccountRepository.findAll();
    }

    @QueryMapping
    public BankAccount bankAccountById(@Argument String id) {
        return bankAccountRepository.findById(id)
                .orElseThrow(() ->
                        new RuntimeException(String.format("Account %s not found", id)));
    }

    @MutationMapping
    public BankAccountResponseDto addAccount(@Argument BankAccountRequestDto bankAccount) {
        return accountService.addAccount(bankAccount);
    }

    @MutationMapping
    public BankAccountResponseDto updateAccount(@Argument String id, @Argument BankAccountRequestDto bankAccount) {
        return accountService.updateAccount(id, bankAccount);
    }

    @MutationMapping
    public boolean deleteAccount(@Argument String id) {
        accountService.deleteAccount(id);
        return true;
    }
@QueryMapping
    public List<Customer> customers() {
        return customerRepository.findAll();
    }
}
//@Data @AllArgsConstructor @NoArgsConstructor
//class BankAccountDTO{
//private String type;
//private Double balance;
//private String currency;
//        }
        /*
        record BankAccountDTO2(String type,Double balance,String currency){

        }
*/