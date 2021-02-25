package com.devmos.wallet.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.devmos.wallet.models.UserWallet;

public interface UserWalletRepository extends JpaRepository<UserWallet, Long> {

}
