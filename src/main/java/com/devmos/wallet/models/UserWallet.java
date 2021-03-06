package com.devmos.wallet.models;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.devmos.wallet.models.dto.UserWalletDTO;

@Entity
public class UserWallet {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@JoinColumn(name = "user", referencedColumnName = "id")
	@ManyToOne(fetch = FetchType.LAZY)
	private User user;
	@JoinColumn(name = "wallet", referencedColumnName = "id")
	@ManyToOne(fetch = FetchType.LAZY)
	private Wallet wallet;
	
	public UserWallet(User user, Wallet wallet) {
		this.user = user;
		this.wallet = wallet;
	}
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public Wallet getWallet() {
		return wallet;
	}
	public void setWallet(Wallet wallet) {
		this.wallet = wallet;
	}

	public UserWalletDTO entityToDto(UserWallet userWallet) {
		return new UserWalletDTO(userWallet.getUser().getId(), userWallet.getWallet().getId());
	}
	
	

}
