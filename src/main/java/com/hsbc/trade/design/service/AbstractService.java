package com.hsbc.trade.design.service;

import com.hsbc.trade.design.repository.TradeRepository;
import com.hsbc.trade.design.repository.TradeTransactionRepository;
import com.hsbc.trade.design.repository.TraderRepository;
import com.hsbc.trade.design.repository.WalletRepository;
import org.springframework.beans.factory.annotation.Autowired;

public class AbstractService {

    @Autowired
    protected TradeRepository tradeRepository;

    @Autowired
    protected TraderRepository traderRepository;

    @Autowired
    protected TradeTransactionRepository tradeTransactionRepository;

    @Autowired
    protected WalletRepository walletRepository;

    @Autowired
    protected KafkaService kafkaService;

    @Autowired
    protected StockService stockService;
}
