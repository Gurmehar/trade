package com.hsbc.trade.design.model;

import com.hsbc.trade.design.model.Trade.Status;
import com.hsbc.trade.design.model.Trade.TradeType;
import java.util.Date;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.lang.NonNull;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class TradeTransaction {

    private String name;
    private Integer quantity;
    private Double price;
    private Long traderId;
    private Long tradeId;
    private Long id;
    @NonNull
    private TradeType tradeType;
    private Date tradedOn;
    private Status status;
    private Date createdDate;


    public static TradeTransaction build(Trade trade){
       return TradeTransaction.builder().tradedOn(trade.getTradedOn())
            .tradeId(trade.getId())
            .traderId(trade.getTraderId())
            .name(trade.getName())
            .price(trade.getPrice())
            .quantity(trade.getQuantity())
            .status(trade.getStatus())
            .tradeType(trade.getTradeType())
            .createdDate(new Date()).build();
    }

}
