package com.devmos.wallet.models;

import java.math.BigDecimal;
import java.util.Date;

public class WalletItem {
	

	private Long id;
	private Date date;
	private String type;
	private String description;
	private BigDecimal value;
	private Wallet wallet;
	
	public WalletItem(Date date, String type, String description, BigDecimal value, Wallet wallet) {
		this.date = date;
		this.type = type;
		this.description = description;
		this.value = value;
		this.wallet = wallet;
	}
	
	

	

}
