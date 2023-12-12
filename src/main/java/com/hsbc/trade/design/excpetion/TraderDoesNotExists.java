package com.hsbc.trade.design.excpetion;

import com.hsbc.trade.design.exception.TradeException;
import com.hsbc.trade.design.model.Trader;

public class TraderDoesNotExists extends TradeException {

    public TraderDoesNotExists() {
        super("Trader Does not exists");
    }

    public TraderDoesNotExists(Trader trader) {
    }
}
