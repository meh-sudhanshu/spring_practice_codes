package com.practice.dependencyinjection;

public class FootballCoach implements Coach{

	private SadFortuneService sadFortuneService;
	
	
	public void setFortuneService(SadFortuneService sadFortuneService) {
		this.sadFortuneService = sadFortuneService;
	}
	
	@Override
	public String getDailyJob() {
		// TODO Auto-generated method stub
		return "Try to get messi and ronaldo in our club";
	}

	@Override
	public String getDailyFortune() {
		// TODO Auto-generated method stub
		return sadFortuneService.getDailyFortune();
	}

	@Override
	public String getBestCoach() {
		// TODO Auto-generated method stub
		return "false";
	}

}
