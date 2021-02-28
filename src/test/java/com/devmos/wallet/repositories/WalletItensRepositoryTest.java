package com.devmos.wallet.repositories;

import static org.junit.Assert.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.math.BigDecimal;
import java.util.Date;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;

import com.devmos.wallet.models.Wallet;
import com.devmos.wallet.models.WalletItem;

@RunWith(SpringRunner.class)
@SpringBootTest
@ActiveProfiles("test")
public class WalletItensRepositoryTest {
	
	private static final Date DATE = new Date();
	private static final String TYPE = "ENTRADA";
	private static final String DESCRIPTION = "Conta de Luz";
	private static final BigDecimal VALUE = new BigDecimal(75.40);
	
	@Autowired
	private WalletItensRepository walletItensRepository;
	
	@Test
	public void testSave() {
		Wallet wallet = new Wallet("Carteira 1", new BigDecimal(500));
		
		WalletItem walletItem = new WalletItem(DATE, TYPE, DESCRIPTION, VALUE, wallet);
		
		WalletItem response = walletItensRepository.save(walletItem);
		
		assertNotNull(response);
		assertEquals(response.getType(), TYPE);
		assertEquals(response.getDescription(), DESCRIPTION);
		assertEquals(response.getValue(), VALUE);

	}

}
