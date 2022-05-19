package com.practice.qualifiers;

import org.springframework.stereotype.Component;

@Component
public class ManishaPlan implements Plan {

	@Override
	public String getPlan() {
		// TODO Auto-generated method stub
		return "live a happy healthy life";
	}

}
