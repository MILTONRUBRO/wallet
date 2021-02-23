package com.devmos.wallet.controllers;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.BDDMockito;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import com.devmos.wallet.models.User;
import com.devmos.wallet.models.dto.UserDTO;
import com.devmos.wallet.services.UserService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;


@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
@ActiveProfiles("test")
public class UserControllerTest {
	
	private static final String NAME = "ragnar";
	private static final String EMAIL = "ragnar@email.com";
	private static final String PASSWORD = "whowantbeking";
	private static final String URL = "/user";
	
	@MockBean
	private UserService userService;
	
	@Autowired
	private MockMvc mvc;
	
	@Test
	public void testSave() throws Exception {
		BDDMockito.given(userService.save(Mockito.any(User.class))).willReturn(getMockUser());
		
		mvc.perform(MockMvcRequestBuilders.post(URL).content(getJsonPayLoad())
				.contentType(MediaType.APPLICATION_JSON))
				.andExpect(MockMvcResultMatchers.status().isCreated()); 
		
	}
	
	public User getMockUser() {
		return new User(NAME, EMAIL, PASSWORD);
	}
	
	public String getJsonPayLoad() throws JsonProcessingException {
		UserDTO userDto = new UserDTO(NAME, EMAIL, PASSWORD);
		
		ObjectMapper mapper = new ObjectMapper();
		return mapper.writeValueAsString(userDto);
	}

}
