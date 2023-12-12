package com.hsbc.trade.design.service;

import com.hsbc.trade.design.exception.TradeException;
import com.hsbc.trade.design.excpetion.TraderDoesNotExists;
import com.hsbc.trade.design.model.Stock;
import com.hsbc.trade.design.model.Trade;
import com.hsbc.trade.design.model.Trader;
import com.hsbc.trade.design.util.CommonConstants;
import java.util.List;
import java.util.Optional;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TradeService extends AbstractService {
    private static final Logger logger = LoggerFactory.getLogger(TradeService.class);

    @Autowired
    private SellingService sellingService;

    @Autowired
    private BuyingService buyingService;

    @Autowired
    private CancelTradeService cancelTradeService;

    public Long processTrade(Trade trade)  {

        switch(trade.getTradeType()){
            case BUY:
                return buyingService.processBuying(trade);
            case SELL:
                validateTrade(trade);
                return sellingService.processSelling(trade);
            case CANCEL:
                validateTrade(trade);
                return cancelTradeService.processTrade(trade);

            default:
                logger.error("Case not known");
                throw new TradeException();
        }

    }

    private void validateTrade(Trade trade) {
        final Trade tradefromDB = tradeRepository.findById(trade.getId())
            .orElseThrow(TradeException::new);
        CommonConstants.isLockTimeOver(tradefromDB.getLockTime());


    }


    public void validateTrader(Long traderId) {
        Optional<Trader> optionalTrader = traderRepository.findById(traderId);
        optionalTrader.orElseThrow(TraderDoesNotExists::new);
    }

    public List<Trade> getTradeList(Long traderId) {
        validateTrader(traderId);
        return  tradeRepository.findAllByTraderId(traderId);
    }

    public List<Stock> getStockList(Long traderId) {
        validateTrader(traderId);
        return stockService.getByTraderId(traderId);
    }
}
