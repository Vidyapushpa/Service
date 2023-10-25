package com.vidya.Banking.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vidya.Banking.Entity.Account;
import com.vidya.Banking.Repository.AccountRepository;

@Service
public class AccountService {
	
	
	@Autowired
	private AccountRepository accountRepository;
	
	
	public void saveAccountDetail(Account account) {
		accountRepository.save(account);
		
	}
	
	public List<Account> findAllSaveDetails() {
		return accountRepository.findAll();
	}

	
	public Optional<Account> findTheDetailsById(Long id) {
		return accountRepository.findById(id);
	}
	
	public void deleteById(Long id) {
		 accountRepository.deleteById(id);
		
	}
	
	public Account deposit(Long id, double amount) {
		Account account=findTheDetailsById(id).orElseThrow(()->new RuntimeException("Account not found"));
		account.setBalance(account.getBalance()+amount);
		return accountRepository.save(account);
		
	}
	
	public Account withdraw(Long id, double amount) {
		Account account=findTheDetailsById(id).orElseThrow(()->new RuntimeException("Account not found"));
		if(account.getBalance()<amount) {
			throw new RuntimeException("insufficient balance");
		}
		account.setBalance(account.getBalance()-amount);
		return accountRepository.save(account);
	}
	
	
	public Account updateById(Long id ,Account account) {
		account.setAccNum(id);
		return accountRepository.save(account);
		
	}
}
