package com.practice.setterinjection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Customer {
	private Account myAccount;

	public Account getMyAccount() {
		return myAccount;
	}

	@Autowired
	public void setMyAccount(Account myAccount) {
		this.myAccount = myAccount;
	}
	
}
