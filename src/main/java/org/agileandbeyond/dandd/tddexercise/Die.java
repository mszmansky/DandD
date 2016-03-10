package org.agileandbeyond.dandd.tddexercise;

import java.security.SecureRandom;

public class Die {

	private int sides = 6;
	private int value = 0;
	
	public Die(int sides) {
		this.sides = sides;
	}
	
	public void roll(){
		SecureRandom rand = new SecureRandom();
		value = rand.nextInt(this.sides) + 1;
	}

	public int getValue() {
		return value;
	}
	
	public String toString() {
		return "d" + sides + "=" + value;
	}
	
}
