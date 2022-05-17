package com.practice.beanscope;

public class PrototypeBean {
	int value = 2;

	public int getValue() {
		return value;
	}

	public void setValue() {
		this.value = this.value+1;
	}
	
	
}
