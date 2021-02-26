package com.devmos.wallet.models.dto;

import javax.validation.constraints.NotNull;

import com.devmos.wallet.models.User;
import com.devmos.wallet.models.UserWallet;
import com.devmos.wallet.models.Wallet;

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
	
	

	public UserWalletDTO(@NotNull(message = "informe o id do usuario") Long user,
			@NotNull(message = "informe o id da carteira") Long wallet) {
		this.user = user;
		this.wallet = wallet;
	}

	public UserWallet dtoToEntity() {
		User user = new User();
		Wallet wallet = new Wallet();
		
		user.setId(this.user);
		wallet.setId(this.wallet);
		
		return new UserWallet(user, wallet);
	}

}
