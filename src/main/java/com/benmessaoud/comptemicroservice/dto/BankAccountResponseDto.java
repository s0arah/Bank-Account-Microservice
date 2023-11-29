package com.benmessaoud.comptemicroservice.dto;

import com.benmessaoud.comptemicroservice.enums.AccountType;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


import java.util.Date;
@Data @AllArgsConstructor @NoArgsConstructor @Builder
public class BankAccountResponseDto {
    private String id;
    private Double balance;
    private Date createdAt;
    private String currency;
    private AccountType type;
}
