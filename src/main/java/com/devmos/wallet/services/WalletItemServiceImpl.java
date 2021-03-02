package com.devmos.wallet.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.devmos.wallet.models.WalletItem;
import com.devmos.wallet.repositories.WalletItensRepository;

@Service
public class WalletItemServiceImpl implements WalletItemService{
	
	@Autowired
	private WalletItensRepository walletItensRepository;

	@Override
	public WalletItem save(WalletItem walletITem) {
		return walletItensRepository.save(walletITem);
	}

}
