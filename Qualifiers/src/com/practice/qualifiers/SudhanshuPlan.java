package com.practice.qualifiers;

import org.springframework.stereotype.Component;

@Component
public class SudhanshuPlan implements Plan{

	@Override
	public String getPlan() {
		// TODO Auto-generated method stub
		return "earn a lot and travel the world";
	}

}
