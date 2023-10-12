package com.project.paymentapp.WalletService;

import com.project.paymentapp.WalletService.Entity.Wallet;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface WalletRepository extends CrudRepository<Wallet,Long> {
    Optional<Wallet> findByUsername(String username);
}
