package com.practice.javaconfigs;

import org.springframework.stereotype.Component;

@Component
public class TokyoDealer implements DrugDealer{

	@Override
	public int getAmountOfDrugs() {
		// TODO Auto-generated method stub
		return 1000;
	}

}
