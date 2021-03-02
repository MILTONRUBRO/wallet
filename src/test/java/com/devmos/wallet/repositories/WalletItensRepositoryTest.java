package com.devmos.wallet.repositories;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.math.BigDecimal;
import java.util.Date;
import java.util.Optional;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;

import com.devmos.wallet.models.Wallet;
import com.devmos.wallet.models.WalletItem;
import com.devmos.wallet.util.TypeEnum;

@RunWith(SpringRunner.class)
@SpringBootTest
@ActiveProfiles("test")
public class WalletItensRepositoryTest {
	
	private static final Date DATE = new Date();
	private static final TypeEnum TYPE = TypeEnum.EN;
	private static final String DESCRIPTION = "Conta de Luz";
	private static final BigDecimal VALUE = new BigDecimal(75.40);
	private Long savedWalletItemId = null; 
	private Long savedWalletId = null; 

	
	@Autowired
	private WalletItensRepository walletItensRepository;
	
	@Autowired
	private WalletRepository walletRepository;
	
	@Before
	public void setUp() {
		Wallet wallet = new Wallet("Carteira 1", new BigDecimal(500));
		walletRepository.save(wallet);
		
		WalletItem walletItem = new WalletItem(DATE, TYPE, DESCRIPTION, VALUE, wallet);
		
		WalletItem response = walletItensRepository.save(walletItem);
		
		savedWalletId = wallet.getId();
		savedWalletItemId = response.getId();
	}
	
	@After
	public void tearDown() {
		walletItensRepository.deleteAll();
		walletRepository.deleteAll();
	}
	
	@Test
	public void testSave() {
		Wallet wallet = new Wallet("Carteira 1", new BigDecimal(500));
		walletRepository.save(wallet);
		
		WalletItem walletItem = new WalletItem(DATE, TYPE, DESCRIPTION, VALUE, wallet);
		
		WalletItem response = walletItensRepository.save(walletItem);
		
		assertNotNull(response);
		assertEquals(TYPE, response.getType());
		assertEquals(DESCRIPTION, response.getDescription());
		assertEquals(VALUE, response.getValue());
	}
	
	@Test
	public void testUpdate() {
		Optional<WalletItem> savedWalletItens = walletItensRepository.findById(savedWalletItemId);
		
		String description = "informacao alterada";
		
		WalletItem walletItem = savedWalletItens.get();
		walletItem.setDescription(description);
		
		walletItensRepository.save(walletItem);
		
		Optional<WalletItem> changedWalletItem = walletItensRepository.findById(savedWalletItemId);
		
		assertEquals(description, changedWalletItem.get().getDescription());
	}
	
	@Test
	public void deleteWalletItem() {
		Optional<Wallet> wallet = walletRepository.findById(savedWalletId);
		WalletItem walletItem = new WalletItem(DATE, TYPE, DESCRIPTION, VALUE, wallet.get());
		
		walletItensRepository.save(walletItem);
		
		walletItensRepository.deleteById(walletItem.getId());
		Optional<WalletItem> response = walletItensRepository.findById(walletItem.getId());
		
		assertFalse(response.isPresent());
	}

}
