package com.practice.qualifiers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
public class Sudhanshu {
	
	
	@Autowired
	@Qualifier("sudhanshuPlan")
	private Plan myPlan;
	
	public String getMyPlan() {
		return myPlan.getPlan();
	}
}
