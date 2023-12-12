package com.hsbc.trade.design.repository;

import com.hsbc.trade.design.model.Wallet;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;

public interface WalletRepository extends JpaRepository<Wallet,Long> {

   Optional<Wallet> findByTraderId(Long traderId);

}
