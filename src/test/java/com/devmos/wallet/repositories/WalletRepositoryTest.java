package com.devmos.wallet.repositories;

import static org.junit.Assert.assertNotNull;

import java.math.BigDecimal;

import org.junit.After;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;

import com.devmos.wallet.models.Wallet;

@RunWith(SpringRunner.class)
@SpringBootTest
@ActiveProfiles("test")
public class WalletRepositoryTest {
	
	@Autowired
	private WalletRepository walletRepository;
	
	@After
	public void tearDown() {
		walletRepository.deleteAll();
	}
	
	@Test
	public void testSave() {
		Wallet wallet = new Wallet("Teste", new BigDecimal(100));
		Wallet walletSaved = walletRepository.save(wallet);
		
		assertNotNull(walletSaved);
	}

}
