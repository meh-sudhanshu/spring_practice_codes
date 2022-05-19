package com.practice.fieldinjection;

import org.springframework.stereotype.Component;

@Component
public class Tata implements Car{

	@Override
	public int getNumberOfTyers() {
		// TODO Auto-generated method stub
		return 4;
	}

}
