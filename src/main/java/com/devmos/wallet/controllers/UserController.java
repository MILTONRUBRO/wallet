package com.devmos.wallet.controllers;


import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.devmos.wallet.models.User;
import com.devmos.wallet.models.dto.UserDTO;
import com.devmos.wallet.response.Response;
import com.devmos.wallet.services.UserService;

@RestController
@RequestMapping("/user")
public class UserController {
	
	@Autowired
	private UserService userService;
	
	@PostMapping
	public ResponseEntity<Response<UserDTO>> create(@RequestBody @Valid UserDTO userDto, BindingResult result) {
		Response<UserDTO> response = new Response<>();
		
		if(result.hasErrors()) {
			result.getAllErrors().forEach(error -> response.getErrors().add(error.getDefaultMessage()));
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(response);
		}

		User user = userService.save(userDto.toModel()); 
		
		response.setData(user.convertEntityToDto(user));
		
		return ResponseEntity.status(HttpStatus.CREATED).body(response);
	}

}
