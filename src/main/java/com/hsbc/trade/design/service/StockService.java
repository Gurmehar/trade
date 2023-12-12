package com.hsbc.trade.design.service;

import com.hsbc.trade.design.model.Stock;
import com.hsbc.trade.design.model.Trade;
import com.hsbc.trade.design.repository.StockRepository;
import java.util.List;
import java.util.Optional;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StockService {

    @Autowired
    private StockRepository stockRepository;

    public void addStockToTrader(Trade trade){

    }

    public Optional<Stock> getStockDetails(Long traderId, String name) {
        return  Optional.of(Stock.builder().build());
    }

    public void reduceStockOfTrader(Trade trade) {
    }

    public List<Stock> getByTraderId(Long traderId) {
        return stockRepository.findByTraderId(traderId);
    }
}
