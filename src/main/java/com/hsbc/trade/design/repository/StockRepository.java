package com.hsbc.trade.design.repository;

import com.hsbc.trade.design.model.Stock;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StockRepository extends JpaRepository<Stock,Long> {

    List<Stock> findByTraderId(Long traderId);
}
