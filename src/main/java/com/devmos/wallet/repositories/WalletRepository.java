package com.devmos.wallet.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.devmos.wallet.models.Wallet;

@Repository
public interface WalletRepository extends JpaRepository<Wallet, Long>{

}
