package com.hsbc.trade.design.service;

import com.hsbc.trade.design.exception.TradeException;
import com.hsbc.trade.design.exception.WalletException;
import com.hsbc.trade.design.model.Trade;
import com.hsbc.trade.design.model.Trade.Status;
import com.hsbc.trade.design.model.TradeTransaction;
import com.hsbc.trade.design.model.Wallet;
import com.hsbc.trade.design.util.CommonConstants;
import java.sql.Date;
import java.time.Instant;
import java.time.ZoneOffset;
import java.util.Optional;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class BuyingService extends  AbstractService {



    @Transactional
    public Long initiateRequest(Wallet wallet, Trade trade) {
        wallet.validateBalance(trade.getPrice(), trade.getQuantity());
        trade.setLockTime(Date.from(
            Instant.now().plusSeconds(CommonConstants.VALIDITY).atZone(ZoneOffset.UTC)
                .toInstant()));
        trade = tradeRepository.save(trade);
        wallet.updateBalance(trade.getPrice(), trade.getQuantity());
        tradeTransactionRepository.save(TradeTransaction.build(trade));
        kafkaService.send(CommonConstants.getJson(trade), "test");
        stockService.addStockToTrader(trade);
        return trade.getId();

    }



    public Long processBuying(Trade trade) {
        Optional<Wallet> byTraderId = walletRepository.findByTraderId(trade.getTraderId());
        Wallet wallet = byTraderId.orElseThrow(WalletException::new);
        if (Status.New.equals(trade.getStatus())) {
            return initiateRequest(wallet, trade);
        }
        throw new TradeException("");
    }
}
