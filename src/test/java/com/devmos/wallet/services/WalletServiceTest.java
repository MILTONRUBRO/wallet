package com.devmos.wallet.services;

import static org.junit.Assert.assertTrue;

import java.util.Optional;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.BDDMockito;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;

import com.devmos.wallet.models.Wallet;
import com.devmos.wallet.repositories.WalletRepository;

@RunWith(SpringRunner.class)
@SpringBootTest
@ActiveProfiles("test")
public class WalletServiceTest {
	
	@MockBean
	private WalletRepository walletRepository;
	
	@Before
	public void setUp() {
		BDDMockito.given(walletRepository.findById(Mockito.anyLong())).willReturn(Optional.of(new Wallet()));
	}
	
	@Test
	public void testFindWalletById() {
		Optional<Wallet> possibleWallet = walletRepository.findById(1L);
		
		assertTrue(possibleWallet.isPresent());
		
	}

}
