package com.practice.javaconfigs;

import org.springframework.stereotype.Component;

@Component
public class SanghaiDealer implements DrugDealer {

	@Override
	public int getAmountOfDrugs() {
		// TODO Auto-generated method stub
		return 25000;
	}

}
