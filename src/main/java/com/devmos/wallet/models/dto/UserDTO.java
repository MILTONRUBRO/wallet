package com.devmos.wallet.models.dto;

import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.Length;

import com.devmos.wallet.models.User;

public class UserDTO {
	
	private Long id;
	@Length(min=3, max=50, message="O nome deve conter entre 3 e 50 caracteres")
	private String name;
	@Email(message="Email invalido")
	private String email;
	@NotNull
	@Length(min=6, message="A senha deve conter no minimo 6 caracteres")
	private String password;
	
	@Deprecated
	public UserDTO() {
		
	}
	
	public UserDTO(Long id,
			@Length(min = 3, max = 50, message = "O nome deve conter entre 3 e 50 caracteres") String name,
			@Email(message = "Email invalido") String email,
			@NotNull @Length(min = 6, message = "A senha deve conter no minimo 6 caracteres") String password) {
		super();
		this.id = id;
		this.name = name;
		this.email = email;
		this.password = password;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
	public User toModel() {
		return new User(this.name, this.email, this.password);
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
	
}
