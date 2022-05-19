package com.practice.setterinjection;

import org.springframework.stereotype.Component;

@Component("myAccount")
public class Account implements Accounts {

	@Override
	public int getBalance() {
		// TODO Auto-generated method stub
		return 2000;

	}

}
