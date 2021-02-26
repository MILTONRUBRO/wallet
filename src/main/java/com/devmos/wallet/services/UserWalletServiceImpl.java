package com.devmos.wallet.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.devmos.wallet.models.UserWallet;
import com.devmos.wallet.repositories.UserWalletRepository;

@Service
public class UserWalletServiceImpl implements UserWalletService {

	@Autowired
	private UserWalletRepository userWalletRepository;

	@Override
	public UserWallet save(UserWallet userWallet) {
		return userWalletRepository.save(userWallet);
	}

}
