package com.hsbc.trade.design.model;

import com.hsbc.trade.design.exception.StockException;
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
public class Stock {

    private String name;
    private Integer quantity;
    private Double price;
    private Long traderId;
    private Long id;

    public void validate(Integer quantity) {
        if(this.quantity<quantity){
            throw new StockException("Trader does not own this much stock, stock available :"+this.quantity);
        }
    }
}
