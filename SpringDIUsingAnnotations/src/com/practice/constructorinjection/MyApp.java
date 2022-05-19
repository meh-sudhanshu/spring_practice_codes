package com.practice.constructorinjection;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MyApp {
	public static void main(String[] args) {
		ClassPathXmlApplicationContext myContext = new ClassPathXmlApplicationContext("applicationContext.xml");
		
		
		Person1 myPerson = (Person1) myContext.getBean("person1");
		
		
		System.out.println(myPerson.getMyAccount().getBalance());
		System.out.println(myPerson.getMyAccount().getName());
		System.out.println(myPerson.getMyAccount().isKycAvailable());
		
		
		myContext.close();
		
	}
}
