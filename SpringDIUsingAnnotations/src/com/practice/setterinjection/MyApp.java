package com.practice.setterinjection;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MyApp {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ClassPathXmlApplicationContext myContext = new ClassPathXmlApplicationContext("applicationContext.xml");
		
		
		Customer myCustomer = (Customer) myContext.getBean("customer");
		
		
		System.out.println(myCustomer.getMyAccount().getBalance());
	}

}
