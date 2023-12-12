package com.hsbc.trade.design.util;

import com.hsbc.trade.design.dto.TradeRequestDto;
import com.hsbc.trade.design.model.Trade;
import com.hsbc.trade.design.model.Trade.Status;
import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.util.Date;
import org.springframework.util.ObjectUtils;

public class Transformer {

    private Transformer(){}


    public static Trade toModel(TradeRequestDto requestDto,Long traderId) {
        return  Trade.builder().traderId(traderId)
            .name(requestDto.getName())
            .quantity(requestDto.getQuantity())
            .tradeType(requestDto.getTradeType())
            .price(requestDto.getPrice())
            .id(requestDto.getId())
            .tradedOn(Date.from(Instant.now()))
            .status(ObjectUtils.isEmpty(requestDto.getId())? Status.New:Status.Existing)
            .build();
    }
}
