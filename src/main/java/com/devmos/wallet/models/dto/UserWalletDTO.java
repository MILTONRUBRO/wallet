package com.devmos.wallet.models.dto;

import javax.validation.constraints.NotNull;

public class UserWalletDTO {

	private Long id;
	@NotNull(message = "informe o id do usuario")
	private Long user;
	@NotNull(message = "informe o id da carteira")
	private Long wallet;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getUser() {
		return user;
	}

	public void setUser(Long user) {
		this.user = user;
	}

	public Long getWallet() {
		return wallet;
	}

	public void setWallet(Long wallet) {
		this.wallet = wallet;
	}

}
