package com.benmessaoud.comptemicroservice.service;

import com.benmessaoud.comptemicroservice.dto.BankAccountRequestDto;
import com.benmessaoud.comptemicroservice.dto.BankAccountResponseDto;
import com.benmessaoud.comptemicroservice.entities.BankAccount;
import org.springframework.stereotype.Service;


public interface AccountService {

    BankAccountResponseDto addAccount(BankAccountRequestDto bankAccountDto);
    BankAccountResponseDto updateAccount(String id,BankAccountRequestDto bankAccountDto);
    boolean deleteAccount(String id);
}

