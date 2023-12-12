package com.hsbc.trade.design.controller;

import com.hsbc.trade.design.dto.TradeRequestDto;
import com.hsbc.trade.design.exception.TradeException;
import com.hsbc.trade.design.model.Stock;
import com.hsbc.trade.design.model.Trade;
import com.hsbc.trade.design.service.TradeService;
import com.hsbc.trade.design.util.Transformer;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/v1/trade")
public class TradeController {

    @Autowired
    private TradeService tradeService;

    @PostMapping("/{traderId}")
    public ResponseEntity<String> makeATrade( @RequestBody(required = true)  TradeRequestDto requestDto,@PathVariable(name = "traderId") Long traderId)
        throws Exception {
        requestDto.validate();
        tradeService.validateTrader(traderId);
        Trade trade=Transformer.toModel(requestDto,traderId);
        return new ResponseEntity<>(tradeService.processTrade(trade).toString(), HttpStatus.ACCEPTED);
    }

    @GetMapping("/{tarderId}/details")
    public ResponseEntity<List<Trade>> getTrade(@PathVariable(name = "traderId") Long traderId)
        throws Exception {
        return  ResponseEntity.ok(tradeService.getTradeList(traderId));

    }

    @GetMapping("/{tarderId}/stock-details")
    public ResponseEntity<List<Stock>> getStockDetails(@PathVariable(name = "traderId") Long traderId)
        throws Exception {
        return  ResponseEntity.ok(tradeService.getStockList(traderId));

    }

}
