package com.devmos.wallet.services;

import static org.junit.Assert.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.math.BigDecimal;
import java.util.Date;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.BDDMockito;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;

import com.devmos.wallet.models.Wallet;
import com.devmos.wallet.models.WalletItem;
import com.devmos.wallet.repositories.WalletItensRepository;
import com.devmos.wallet.util.TypeEnum;

@RunWith(SpringRunner.class)
@SpringBootTest
@ActiveProfiles("test")
public class WalletItemServiceTest {
	
	private static final Date DATE = new Date();
	private static final String DESCRIPTION = "descricao";
	private static final BigDecimal VALUE = new BigDecimal(250.00);
	private static final TypeEnum TYPE = TypeEnum.EN;
	
	
	@MockBean
	private WalletItensRepository walletItensRepository;
	
	@Autowired
	private WalletItemService walletItemService;
	
	@Test
	public void testSave() {
		BDDMockito.given(walletItensRepository.save(Mockito.any(WalletItem.class))).willReturn(getMockWalletItem());
		WalletItem response = walletItemService.save(new WalletItem());
		
		assertNotNull(response);
		assertEquals(DESCRIPTION, response.getDescription());
		assertEquals(VALUE, response.getValue());
		
	}

	private WalletItem getMockWalletItem() {
		Wallet wallet = new Wallet("Carteira-1", VALUE);
		wallet.setId(1L);
		return new WalletItem(DATE, TYPE, DESCRIPTION, VALUE, wallet);
	}

}
