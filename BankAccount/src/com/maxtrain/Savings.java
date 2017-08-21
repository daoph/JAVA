package com.maxtrain;

public class Savings extends Account {
	
	private double intRate = 0.06;
	
	public double getIntRate(){
		return this.intRate;
	}
	public void setIntRate(double intRate) {
		this.intRate = intRate;
	}
	
	
	public double calcInt(int months) {
		double intPerMonth = this.intRate / 12;
		double interest = intPerMonth * months * this.getBalance();
		return interest;
		
	}
	
	public double payInterest(int months) {
		double interest = this.calcInt(months);
		return this.deposit(interest);
	}
	
	public Savings(String desc) {
		super(desc);
	}

}
