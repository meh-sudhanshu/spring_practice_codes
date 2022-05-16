package com.practice.dependencyinjection;

public class SadFortuneService implements FortuneService {

	@Override
	public String getDailyFortune() {
		// TODO Auto-generated method stub
		return "Today is Your bad day , can't manage to get messi and ronaldo in our club";
	}

}
