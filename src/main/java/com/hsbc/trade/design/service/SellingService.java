package com.hsbc.trade.design.service;

import com.hsbc.trade.design.exception.StockException;
import com.hsbc.trade.design.model.Stock;
import com.hsbc.trade.design.model.Trade;
import com.hsbc.trade.design.model.TradeTransaction;
import com.hsbc.trade.design.model.Wallet;
import java.util.Optional;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class SellingService extends AbstractService {




    @Transactional
    public Long processSelling(Trade trade) {
        Optional<Wallet> byTraderId = walletRepository.findByTraderId(trade.getTraderId());
        Wallet wallet = byTraderId.orElse(new Wallet());
         Stock stock = stockService.getStockDetails(trade.getTraderId(),
            trade.getName()).orElseThrow(StockException::new);
         stock.validate(trade.getQuantity());
        trade = tradeRepository.save(trade);
        wallet.addBalance(trade.getPrice(), trade.getQuantity());
        tradeTransactionRepository.save(TradeTransaction.build(trade));
        stockService.reduceStockOfTrader(trade);
        return trade.getId();
    }
}
