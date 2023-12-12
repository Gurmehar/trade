package com.hsbc.trade.design.repository;

import com.hsbc.trade.design.model.Trade;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TradeRepository extends JpaRepository<Trade,Long> {

    List<Trade> findAllByTraderId(Long traderId);
}
