package com.hsbc.trade.design.model;

import java.util.Date;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@Builder
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class WalletTransaction {

    public enum TransactionType{
        ADD,DEDUCT
    }

    private String walletId;
    private String id;
    private TransactionType transactionType;
    private Double amount;
    private Date transactionDate;

}
