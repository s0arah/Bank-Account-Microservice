package com.benmessaoud.comptemicroservice.entities;

import com.benmessaoud.comptemicroservice.enums.AccountType;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class BankAccount {
    @Id
    private String id;
    private Double balance;
    private Date createdAt;
    private String currency;
    @Enumerated(EnumType.STRING)
    private AccountType type;
@ManyToOne
    private Customer customer;




}
