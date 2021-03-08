package com.devmos.wallet.controllers;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.devmos.wallet.models.Wallet;
import com.devmos.wallet.models.dto.WalletDTO;
import com.devmos.wallet.response.Response;
import com.devmos.wallet.services.WalletService;

@RestController
@RequestMapping("/wallet")
public class WalletController {
	
	@Autowired
	private WalletService walletService;
	
	@PostMapping
	public  ResponseEntity<Response<WalletDTO>> create(@RequestBody @Valid WalletDTO walletDto, BindingResult result){
		Response<WalletDTO> response = new Response<>();
		
		if(result.hasErrors()) {
			result.getAllErrors().forEach(error -> response.getErrors().add(error.getDefaultMessage()));
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(response);
		}
		
		Wallet wallet = walletService.save(walletDto.dtoToEntity());
		response.setData(wallet.entityToDTO(wallet));
		
		return ResponseEntity.status(HttpStatus.CREATED).body(response);
	}
	
	@GetMapping("/{id}")
	public  ResponseEntity<Response<WalletDTO>> get(@PathVariable("id") Long id){
		Response<WalletDTO> response = new Response<>();
				
		Wallet wallet = walletService.getWallet(id);
		response.setData(wallet.entityToDTO(wallet));
		return ResponseEntity.status(HttpStatus.OK).body(response);
	}
	

}
