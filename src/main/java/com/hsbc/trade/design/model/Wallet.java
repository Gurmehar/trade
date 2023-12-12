package com.hsbc.trade.design.model;

import com.hsbc.trade.design.exception.WalletException;
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
public class Wallet {
    private String id;
    private String traderId;
    private Double balance;

    public void validateBalance(Double price, Integer quantity) {
        Double requiredBalance=price*quantity;
        if(Double.compare(balance,requiredBalance)<0)
            throw  new WalletException("Insufficient Balance");

    }

    public void updateBalance(Double price, Integer quantity) {
        this.balance=this.balance-(price*quantity);
    }

    public void addBalance(Double price, Integer quantity) {
        this.balance=this.balance+(price*quantity);
    }
}
