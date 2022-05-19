package com.practice.constructorinjection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Person1 {
	
	private Account myAccount;
	
	@Autowired
	public Person1(Account myAccount) {
		super();
		this.myAccount = myAccount;
	}
	
	
	public Account getMyAccount() {
		return myAccount;
	}
	
	
	
}
