package com.devmos.wallet.models;

import java.io.Serializable;
import java.math.BigDecimal;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Length;

import com.devmos.wallet.models.dto.WalletDTO;

@Entity
public class Wallet implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@NotNull(message = "O nome não pode ser nulo")
	@Length(min = 3, message = "O nome deve ter no minimo 3 caracteres")
	private String name;
	@NotNull(message = "Insira um valor para a carteira")
	private BigDecimal value;

	public Wallet(@NotNull @Length(min = 3) String name, @NotNull BigDecimal value) {
		this.name = name;
		this.value = value;
	}
	
	@Deprecated
	public Wallet() {
		
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
	
	public WalletDTO entityToDTO(Wallet wallet) {
		return new WalletDTO(wallet.getName(), wallet.getValue());
	}

}
