package com.practice.javaconfigs;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class App {
	public static void main(String[] args) {
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(Configurations.class);
		
		
		DrugDealer tokyoDealer = context.getBean("tokyoDealer",DrugDealer.class);
		
		DrugDealer sanghaiDealer = context.getBean("sanghaiDealer",DrugDealer.class);
		
		
		System.out.println(tokyoDealer.getAmountOfDrugs());
		
		
		System.out.println(sanghaiDealer.getAmountOfDrugs());
		
		context.close();
	}
}
