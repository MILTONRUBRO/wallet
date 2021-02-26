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

import com.devmos.wallet.models.UserWallet;
import com.devmos.wallet.models.dto.UserWalletDTO;
import com.devmos.wallet.response.Response;
import com.devmos.wallet.services.UserWalletService;

@RestController
@RequestMapping("/user-wallet")
public class UserWalletController {
	
	@Autowired
	private UserWalletService userWalletService;
	
	@PostMapping
	public ResponseEntity<Response<UserWalletDTO>> create(@Valid @RequestBody UserWalletDTO userWalletDTO, BindingResult result){
		Response<UserWalletDTO> response = new Response<>();
		
		if(result.hasErrors()) {
			result.getAllErrors().forEach(error -> response.getErrors().add(error.getDefaultMessage()));
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(response);
		}
		
		UserWallet userWallet = userWalletService.save(userWalletDTO.dtoToEntity());
		response.setData(userWallet.entityToDto(userWallet));
		
		return ResponseEntity.status(HttpStatus.CREATED).body(response);

	}

}
