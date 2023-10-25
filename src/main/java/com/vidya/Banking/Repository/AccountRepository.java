package com.vidya.Banking.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.vidya.Banking.Entity.Account;

public interface AccountRepository extends JpaRepository<Account, Long>{

}
