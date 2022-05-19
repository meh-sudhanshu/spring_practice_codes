package com.practice.annotations.inverionofcontrol;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MyApp {
	public static void main(String[] args) {
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
		
		
		Account myAccount = (Account) context.getBean("account");
		
		System.out.println(myAccount.getBalance());
		
		
		
		context.close();
	}
}
