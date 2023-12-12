package com.hsbc.trade.design.model;

import java.util.Date;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import org.springframework.lang.NonNull;

@Getter
@Setter
@Builder
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class Trade {

    public enum TradeType{BUY,SELL,CANCEL}
    public enum Status{New,Existing,Cancelled}

    private String name;
    private Integer quantity;
    private Double price;
    private Long traderId;
    private Long id;
    @NonNull
    private TradeType tradeType;
    private Date tradedOn;
    private Status status;
    private Date lockTime;

}
