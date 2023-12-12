package com.hsbc.trade.design.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.hsbc.trade.design.exception.TradeException;
import com.hsbc.trade.design.model.Trade.TradeType;
import lombok.Getter;
import lombok.Setter;
import org.springframework.lang.NonNull;
import org.springframework.util.StringUtils;

@Getter
@Setter
@JsonIgnoreProperties(ignoreUnknown = true)
public class TradeRequestDto {
    @NonNull
    private String name;
    @NonNull
    private Integer quantity;
    @NonNull
    private Double price;

    private String traderId;

    private Long id;
    @NonNull
    private TradeType tradeType;

    public void validate()  {
        if(!StringUtils.hasText(this.name)){
            throw new TradeException("Name Cannot be Empty");
        }

        if(this.quantity<1){
            throw new TradeException("Minimum quantity expected to be one");
        }

        if(Double.compare(this.price,0)<0){
            throw new TradeException("Price of share cannot be less than 0");
        }

    }
}
