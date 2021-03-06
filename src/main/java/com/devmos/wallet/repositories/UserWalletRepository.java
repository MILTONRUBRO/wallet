package com.devmos.wallet.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.devmos.wallet.models.UserWallet;

@Repository
public interface UserWalletRepository extends JpaRepository<UserWallet, Long> {

}
