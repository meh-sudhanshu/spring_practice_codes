package com.practice.fieldinjection;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MyApp {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ClassPathXmlApplicationContext myContext = new ClassPathXmlApplicationContext("applicationContext.xml");
		
		
		
		Vehicle myVehicle = (Vehicle) myContext.getBean("vehicle");
		
		
		System.out.println(myVehicle.getMyCar().getNumberOfTyers());
		
		myContext.close();
	}

}
