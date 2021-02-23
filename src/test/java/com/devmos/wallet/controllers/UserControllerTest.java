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
import com.jayway.jsonpath.JsonPath;


@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
@ActiveProfiles("test")
public class UserControllerTest {
	
	private static final Long ID = 1L;
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
		
		mvc.perform(MockMvcRequestBuilders.post(URL).content(getJsonPayLoad(ID, NAME, EMAIL, PASSWORD))
				.contentType(MediaType.APPLICATION_JSON))
				.andExpect(MockMvcResultMatchers.status().isCreated())
				.andExpect(MockMvcResultMatchers.jsonPath("$.data.id").value(ID))
				.andExpect(MockMvcResultMatchers.jsonPath("$.data.name").value(NAME))
				.andExpect(MockMvcResultMatchers.jsonPath("$.data.email").value(EMAIL))
				.andExpect(MockMvcResultMatchers.jsonPath("$.data.password").value(PASSWORD)); 
	}
	
	@Test
	public void testSaveInvalidUser() throws JsonProcessingException, Exception {
		mvc.perform(MockMvcRequestBuilders.post(URL).content(getJsonPayLoad(ID, NAME, "email", PASSWORD))
				.contentType(MediaType.APPLICATION_JSON))
				.andExpect(MockMvcResultMatchers.status().isBadRequest())
				.andExpect(MockMvcResultMatchers.jsonPath("$.errors[0]").value("Email invalido")); 
	}
	
	public User getMockUser() {
		return new User(ID,NAME, EMAIL, PASSWORD);
	}
	
	public String getJsonPayLoad(Long id, String name, String email, String password) throws JsonProcessingException {
		UserDTO userDto = new UserDTO(id, name, email, password);
		
		ObjectMapper mapper = new ObjectMapper();
		return mapper.writeValueAsString(userDto);
	}

}
