package com.practice.qualifiers;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MyApp {
	public static void main(String[] args) {
		ClassPathXmlApplicationContext myContext = new ClassPathXmlApplicationContext("applicationContext.xml");
		
		Sudhanshu me = (Sudhanshu) myContext.getBean("sudhanshu");
		
		System.out.println(me.getMyPlan());
		
		
		Manisha manisha = (Manisha) myContext.getBean("manisha");
		
		
		System.out.println(manisha.getMyPlan());
		
		myContext.close();
	}
}
