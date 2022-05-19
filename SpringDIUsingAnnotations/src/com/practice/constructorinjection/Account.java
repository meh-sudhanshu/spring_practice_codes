package com.practice.constructorinjection;

import org.springframework.stereotype.Component;

@Component
public class Account implements Accounts {
	
	
	
	private String name="Sudhanshu Kumar";
	
	private boolean isKycAvailable=false;
	
	
	private long balance=50000;

//	public Account() {
//		
//	}
//	
//	public Account(String name, boolean isKycAvailable, long balance) {
//		super();
//		this.name = name;
//		this.isKycAvailable = isKycAvailable;
//		this.balance = balance;
//	}


	public String getName() {
		return name;
	}


	public boolean isKycAvailable() {
		return isKycAvailable;
	}


	public long getBalance() {
		return balance;
	}




//	
	
	
	
}
