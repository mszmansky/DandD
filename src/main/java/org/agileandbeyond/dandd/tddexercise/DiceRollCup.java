package org.agileandbeyond.dandd.tddexercise;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class DiceRollCup {

	private Set<Die> diceCup;
	private int value;
	
	public DiceRollCup() {
		diceCup = new HashSet<Die>();
	}
	
	public DiceRollCup(List<Die> dice){
		for (Die die : dice) {
			diceCup.add(die);
		}
	}
	
	public void throwDice() {
		for (Die die : diceCup) {
			die.roll();
			value += die.getValue();
		}
	}
	
	public void addDie(Die die) {
		diceCup.add(die);
	}
	
	public String toString(){
		String stringDice = "";
		for (Die die : diceCup) {
			stringDice += die.toString()  + ", ";
		}
		return stringDice.substring(0, stringDice.lastIndexOf(", ")) + " -->" + this.value;
	}

	public int getValue() {
		return value;
	}
}
