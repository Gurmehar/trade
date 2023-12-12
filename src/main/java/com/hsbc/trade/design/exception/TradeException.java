package com.hsbc.trade.design.exception;

public class TradeException extends RuntimeException {

    public static final String  ERR_MSG="Something bad happen, contact admin";

    public TradeException() {
        this(ERR_MSG);
    }

    public TradeException(String message) {
        super(message);
    }

    public TradeException(String message, Throwable cause) {
        super(message, cause);
    }
}
