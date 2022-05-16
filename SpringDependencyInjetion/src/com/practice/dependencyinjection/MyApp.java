package com.practice.dependencyinjection;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MyApp {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		@SuppressWarnings("resource")
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
		
		Coach myCoach = context.getBean("myCricketCoach",Coach.class);
		
		

		
		System.out.println(myCoach.getDailyJob());
		
		System.out.println(myCoach.getDailyFortune());
		
		System.out.println(myCoach.getBestCoach());
	}

}
