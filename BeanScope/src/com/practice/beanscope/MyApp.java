package com.practice.beanscope;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MyApp {
	
	public static void main(String[] args) {
		ClassPathXmlApplicationContext myContext = new ClassPathXmlApplicationContext("applicationContext.xml");
		
//		SingletonBean myBean = (SingletonBean) myContext.getBean("singletonBean");
//		
//		SingletonBean myBean2 = (SingletonBean) myContext.getBean("singletonBean");
//		
//		System.out.println(myBean.getValue());
//		myBean.setValue();
//		System.out.println(myBean.getValue());
//		
//		System.out.println(myBean2.getValue());
		
		
		PrototypeBean myBean = (PrototypeBean) myContext.getBean("prototypeBean");
		
		
		System.out.println(myBean.getValue());
		myBean.setValue();
		System.out.println(myBean.getValue());
		
		PrototypeBean myBean2 = (PrototypeBean) myContext.getBean("prototypeBean");
		System.out.println(myBean2.getValue());
	}

}
