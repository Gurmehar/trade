package com.hsbc.trade.design.repository;

import com.hsbc.trade.design.model.Trader;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TraderRepository extends JpaRepository<Trader, Long> {

    Optional<Trader> findById(Long id);

}
