package com.devmos.wallet.services;

import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

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

	@Override
	public Wallet getWallet(Long id) {
		 Optional<Wallet> possibleWallet = walletRepository.findById(id);
		 
		 if(!possibleWallet.isPresent()) {
			 throw new ResponseStatusException(HttpStatus.NOT_FOUND); 
		 }
		 return possibleWallet.get();
	}

}
