package com.hsbc.trade.design.exception;

public class StockException extends TradeException {

    public StockException() {
        super("Trader Does not own this stock");
    }

    public StockException(String message) {
        super(message);
    }
}
