package com.practice.coach;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MyApp {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		
		@SuppressWarnings("resource")
		ClassPathXmlApplicationContext myContext = new ClassPathXmlApplicationContext("applicationContext.xml");
		
		Coach myCoach = myContext.getBean("myTrackCoach", Coach.class);
		
		System.out.println(myCoach.getDailyWorkout());
	}

}
