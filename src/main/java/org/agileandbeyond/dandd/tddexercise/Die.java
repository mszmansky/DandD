package org.agileandbeyond.dandd.tddexercise;

import java.security.SecureRandom;

public class Die {

	private int sides = 6;
	private int value = 0;
	private String designator = "";
	private int valueModifier = 1;
	
	public Die(int sides) {
		setSides(sides);
	}
	
	public Die(int sides, String designator) {
		setSides(sides);
		this.designator = designator;
	}
	
	public void roll(){
		SecureRandom rand = new SecureRandom();
		value = rand.nextInt(this.sides) + valueModifier;
	}

	public int getValue() {
		return value;
	}
	
	public String toString() {
		return "d" + sides + "=" + value;
	}

	public String getDesignator() {
		return designator;
	}

	public void setDesignator(String designator) {
		this.designator = designator;
	}
	
	private void setSides(int sides) {
		this.sides = sides;
		if (sides == 10){
			valueModifier = 0;
		}
	}
	
}
