package com.practice.dependencyinjection;

public class CricketCoach implements Coach {

	private HappyFortuneService myFortuneService;
	private String bestCoach;
	
	public CricketCoach() {
		super();
	}

	public CricketCoach(HappyFortuneService myFortuneService) {
		this.myFortuneService = myFortuneService;
	}
	
	public void setBestCoach(String value) {
		this.bestCoach=value;
	}

	public String getDailyFortune() {
		return myFortuneService.getDailyFortune();
	}
	
	@Override
	public String getDailyJob() {
		// TODO Auto-generated method stub
		return "Prepare playing 11 for next match";
	}

	@Override
	public String getBestCoach() {
		// TODO Auto-generated method stub
		return this.bestCoach;
	}

}
