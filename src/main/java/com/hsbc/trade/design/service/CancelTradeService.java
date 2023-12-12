package com.hsbc.trade.design.service;

import com.hsbc.trade.design.exception.TradeException;
import com.hsbc.trade.design.model.Trade;
import com.hsbc.trade.design.model.Trade.TradeType;
import com.hsbc.trade.design.model.TradeTransaction;
import com.hsbc.trade.design.model.Wallet;
import com.hsbc.trade.design.util.CommonConstants;
import java.util.Optional;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class CancelTradeService extends AbstractService{




    @Transactional
    public Long processTrade(Trade trade){
         Trade fromDB = tradeRepository.findById(trade.getId()).get();
         if(TradeType.BUY.equals(fromDB.getTradeType())){
             return cancelBuying(fromDB,trade);
         }
        if(TradeType.SELL.equals(fromDB.getTradeType())){
            return cancelSelling(fromDB, trade);
        }
        throw  new TradeException("trade not found");
    }

    @Transactional
    private Long cancelSelling(Trade fromDB, Trade fromDto) {
        fromDto = tradeRepository.save(fromDto);
        tradeTransactionRepository.save(TradeTransaction.build(fromDto));
        Optional<Wallet> byTraderId = walletRepository.findByTraderId(fromDB.getTraderId());
        Wallet wallet = byTraderId.orElse(new Wallet());
        wallet.updateBalance(fromDto.getPrice(), fromDto.getQuantity());
        kafkaService.send(CommonConstants.getJson(fromDto), "test");
        stockService.reduceStockOfTrader(fromDto);
        return fromDto.getId();
    }

    @Transactional
    private Long cancelBuying(Trade fromDB, Trade fromDto) {
        fromDto = tradeRepository.save(fromDto);
        tradeTransactionRepository.save(TradeTransaction.build(fromDto));
        Optional<Wallet> byTraderId = walletRepository.findByTraderId(fromDB.getTraderId());
        Wallet wallet = byTraderId.orElse(new Wallet());
        wallet.addBalance(fromDto.getPrice(), fromDto.getQuantity());
        kafkaService.send(CommonConstants.getJson(fromDto), "test");
        stockService.addStockToTrader(fromDto);
        return fromDto.getId();
    }

}
