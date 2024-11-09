package com.zosh.model;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDate;

import com.zosh.domain.WalletTransactionType;

@Entity
@Data
public class WalletTransaction {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @ManyToOne
    private Wallet wallet;

    private WalletTransactionType type;

    private LocalDate date;

    private String transferId;

    private String purpose;

    private Long amount;


}
