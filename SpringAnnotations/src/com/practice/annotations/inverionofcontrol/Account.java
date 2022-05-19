package com.practice.annotations.inverionofcontrol;

import org.springframework.stereotype.Component;

@Component("account")
public class Account {
	private int balance = 100;

	public int getBalance() {
		return balance;
	}

	public void setBalance(int balance) {
		this.balance = balance;
	}
	
	
}
