package com.devmos.wallet.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.devmos.wallet.models.User;
import com.devmos.wallet.repositories.UserRepository;

@Service
public class UserServiceImpl implements UserService {
	
	@Autowired
	private UserRepository userRepository;
	
	@Override
	public Optional<User> findByEmail(String email) {
		return userRepository.findByEmailEquals(email);
	}

	@Override
	public User save(User user) {
		return userRepository.save(user);
	}

}
