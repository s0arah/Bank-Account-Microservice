package com.benmessaoud.comptemicroservice.service;

import com.benmessaoud.comptemicroservice.dto.BankAccountRequestDto;
import com.benmessaoud.comptemicroservice.dto.BankAccountResponseDto;
import com.benmessaoud.comptemicroservice.entities.BankAccount;
import com.benmessaoud.comptemicroservice.mappers.AccountMapper;
import com.benmessaoud.comptemicroservice.repository.BankAccountRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.UUID;

@Transactional
@Service
public class AccountServiceImpl implements AccountService {



    BankAccountRepository bankAccountRepository;
    @Autowired
    AccountMapper accountMapper;

    public AccountServiceImpl(BankAccountRepository bankAccountRepository) {
        this.bankAccountRepository = bankAccountRepository;

    }

    @Override
    public BankAccountResponseDto addAccount(BankAccountRequestDto bankAccountDto) {
        BankAccount bankAccount=BankAccount.builder()
                .id(UUID.randomUUID().toString())
                .createdAt(new Date())
                .balance(bankAccountDto.getBalance())
                .type(bankAccountDto.getType())
                .currency(bankAccountDto.getCurrency())
                .build () ;
        BankAccount savedaccount = bankAccountRepository.save(bankAccount);
        BankAccountResponseDto bankAccountResponseDto = accountMapper.convertToDto(savedaccount);

        return bankAccountResponseDto;
    }

    @Override
    public boolean deleteAccount(String id) {
         bankAccountRepository.deleteById(id);
         return true;
    }

    @Override
    public BankAccountResponseDto updateAccount( String id,BankAccountRequestDto bankAccountDto) {
        BankAccount bankAccount=BankAccount.builder()
                .id(id)
                .createdAt(new Date())
                .balance(bankAccountDto.getBalance())
                .type(bankAccountDto.getType())
                .currency(bankAccountDto.getCurrency())
                .build () ;
        BankAccount savedaccount = bankAccountRepository.save(bankAccount);
        BankAccountResponseDto bankAccountResponseDto = accountMapper.convertToDto(savedaccount);

        return bankAccountResponseDto;
    }
}
