package org.agileandbeyond.dandd.tddexercise;

public class Purse {

	private int goldCount;

	public void addGold(int newGold){
		this.goldCount += newGold;
	}
	
	public void spendGold(int cost) throws InsufficientFundsException{
		if(cost > goldCount){
			throw new InsufficientFundsException("The cost of " + cost + " gold coins exceeds the value contained in the purse.");
		}
		this.goldCount -= cost;
	}

	public int getGoldCount() {
		return goldCount;
	}

	public void setGoldCount(int goldCount) {
		this.goldCount = goldCount;
	}
		
}
