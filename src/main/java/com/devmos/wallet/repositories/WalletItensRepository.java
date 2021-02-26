package com.devmos.wallet.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.devmos.wallet.models.WalletItem;

@Repository
public interface WalletItensRepository extends JpaRepository<WalletItem, Long>{

}
