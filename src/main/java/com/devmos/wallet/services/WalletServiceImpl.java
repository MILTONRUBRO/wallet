package com.devmos.wallet.services;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.devmos.wallet.models.Wallet;
import com.devmos.wallet.repositories.WalletRepository;

@Service
public class WalletServiceImpl implements WalletService{
	
	@Autowired
	private WalletRepository walletRepository;

	@Override
	@Transactional
	public Wallet save(Wallet wallet) {
		return walletRepository.save(wallet);
	}

}
