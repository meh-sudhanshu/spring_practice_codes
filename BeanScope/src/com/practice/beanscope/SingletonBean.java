package com.practice.beanscope;

public class SingletonBean {
	
	
	private int value = 1;
	
	
	public void setValue() {
		this.value+=1;
	}
	
	public int getValue() {
		return this.value;
	}

}
