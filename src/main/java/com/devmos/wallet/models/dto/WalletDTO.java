package com.devmos.wallet.models.dto;

import java.math.BigDecimal;

import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Length;

import com.devmos.wallet.models.Wallet;

public class WalletDTO {

	private Long id;
	@NotNull
	@Length(min = 3)
	private String name;
	@NotNull
	private BigDecimal value;

	public WalletDTO(String name, BigDecimal value) {
		this.name = name;
		this.value= value;
	}
	
	@Deprecated
	public WalletDTO() {
		
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public BigDecimal getValue() {
		return value;
	}

	public void setValue(BigDecimal value) {
		this.value = value;
	}
	
	public Wallet dtoToEntity() {
		return new Wallet(this.name, this.value);
	}

}
