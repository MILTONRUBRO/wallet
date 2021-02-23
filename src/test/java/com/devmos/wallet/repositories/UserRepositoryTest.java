package com.devmos.wallet.repositories;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.util.Optional;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;

import com.devmos.wallet.models.User;

@RunWith(SpringRunner.class)
@SpringBootTest
@ActiveProfiles("test")
public class UserRepositoryTest {
	
	private static final String EMAIL = "bjorn@email.com";
	
	@Autowired
	private UserRepository userRepository;
	
	@Before
	public void setup() {
		User user = new User("Bjorn", EMAIL, "ironside");
		userRepository.save(user);
	}
	
	@After
	public void tearDown() {
		userRepository.deleteAll();
	}
	
	@Test
	public void testSave() {
		User user = new User();
		user.setName("Teste");
		user.setPassword("123456");
		user.setEmail("teste@teste.com");
		
		User userSaved = userRepository.save(user);
		
		assertNotNull(userSaved);
	}
	
	@Test
	public void testSearchUserByEmail() {
		Optional<User> possibleUser = userRepository.findByEmailEquals(EMAIL);
		assertTrue(possibleUser.isPresent());
	}

}
