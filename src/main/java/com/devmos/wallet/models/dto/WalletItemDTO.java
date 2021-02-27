package com.devmos.wallet.models.dto;

import java.math.BigDecimal;
import java.util.Date;

import javax.validation.constraints.NotNull;

public class WalletItemDTO {

	private Long id;
	@NotNull(message = "Informe uma data")
	private Date date;
	@NotNull(message = "Informe um tipo")
	private String type;
	@NotNull(message = "Informe uma descricao")
	private String description;
	@NotNull(message = "Informe um valor")
	private BigDecimal value;
	@NotNull(message = "informe o id da carteira")
	private Long walletId;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public BigDecimal getValue() {
		return value;
	}

	public void setValue(BigDecimal value) {
		this.value = value;
	}

	public Long getWalletId() {
		return walletId;
	}

	public void setWalletId(Long walletId) {
		this.walletId = walletId;
	}

}
