package com.hsbc.trade.design.exception;

public class WalletException extends TradeException {

    public WalletException() {
        super("Wallet for trader Not found");
    }

    public WalletException(String message) {
        super(message);
    }
}
