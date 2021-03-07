package com.devmos.wallet.controllers;

import java.math.BigDecimal;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.BDDMockito;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import com.devmos.wallet.models.Wallet;
import com.devmos.wallet.services.WalletService;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
@ActiveProfiles("test")
public class WalletControllerTest {
	
	private static final Long ID = 1L;
	private static final String NAME = "carteira";
	private static final BigDecimal VALUE = new BigDecimal(50);
	private static final String URL = "/wallet/";

	@MockBean
	private WalletService walletService;
	
	@Autowired
	private MockMvc mvc;
	
	@Test
	public void testGetWallet() throws Exception {
		BDDMockito.given(walletService.getWallet(Mockito.anyLong())).willReturn(getMockWallet());
		
		mvc.perform(MockMvcRequestBuilders.get(URL,ID))
		.andExpect(MockMvcResultMatchers.status().isOk())
		.andExpect(MockMvcResultMatchers.jsonPath("$.data.id").value(ID))
		.andExpect(MockMvcResultMatchers.jsonPath("$.data.name").value(NAME))
		.andExpect(MockMvcResultMatchers.jsonPath("$.data.value").value(VALUE));

	}

	private Wallet getMockWallet() {
		return new Wallet(ID, NAME, VALUE);
	}

}
