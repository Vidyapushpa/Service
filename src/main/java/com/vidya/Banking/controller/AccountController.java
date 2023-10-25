package com.vidya.Banking.controller;

import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.vidya.Banking.Entity.Account;
import com.vidya.Banking.Service.AccountService;

@RestController
@RequestMapping("/api/vp/account")

public class AccountController {
	
	@Autowired
	private AccountService accountService;
	
	
	@PostMapping("/save")
	public void save(@RequestBody Account account) {
		accountService.saveAccountDetail(account);
	}
	
	@GetMapping("/find")
	public List<Account> findAllSaveDetails(){
		return accountService.findAllSaveDetails();
	}
	
	
	@GetMapping("/findId/{id}")
	public Optional<Account> findSaveDeatailsById(@PathVariable("id") Long id){
		return accountService.findTheDetailsById(id);
	}
	
	
	@DeleteMapping("/deleteTheAccount/{id}")
	public void deleteById(@PathVariable("id") Long id) {
		 accountService.deleteById(id);
	}
	
	
	@PostMapping("/{id}/deposit")
	public Account deposit(@PathVariable  Long id, @RequestBody Map<String ,Double> request) {
		double amount=request.get("amount");
		return accountService.deposit(id, amount);
		
	}
	
	
	@PostMapping("/{id}/withdraw")
	public Account withdraw(@PathVariable Long id, @RequestBody Map<String ,Double> request) {
		double amount=request.get("amount");
		return accountService.withdraw(id, amount);
		
	}
	

	@PutMapping("/update/{id}")
		public Account updateById(@PathVariable Long id,@RequestBody Account account) {
			return accountService.updateById(id, account);
		
	}
}
