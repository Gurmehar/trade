package com.hsbc.trade.design.repository;

import com.hsbc.trade.design.model.TradeTransaction;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TradeTransactionRepository extends JpaRepository<TradeTransaction,Long> {

}
