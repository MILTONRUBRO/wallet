package com.devmos.wallet.services;

import java.util.Optional;

import com.devmos.wallet.models.User;

public interface UserService {
	
	User save(User user);
	Optional<User> findByEmail(String email);

}
