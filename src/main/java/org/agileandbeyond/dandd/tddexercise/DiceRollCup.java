package org.agileandbeyond.dandd.tddexercise;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class DiceRollCup {

	private Set<Die> diceCup;
	private int diceCount;
	private int value;
	
	public DiceRollCup() {
		diceCup = new HashSet<Die>();
	}
	
	public DiceRollCup(String diceNotation) {
		Pattern pattern = Pattern.compile("(\\d*)(d)(\\d+)");
		Matcher m = pattern.matcher(diceNotation);
		int numberOfDice = 1;
		int sides = 0;
		if (m.find()) {
			diceCup = new HashSet<Die>();
			if (!m.group(1).isEmpty()) {
				numberOfDice = Integer.valueOf(m.group(1)).intValue();
			}
			sides = Integer.valueOf(m.group(3)).intValue();
			for (int i=0; i<numberOfDice; i++) {
				addDieToCup(new Die(sides));
			}
		} else {
			throw new IllegalArgumentException("Invalid dice notation");
		}
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
		this.diceCount = 0;
	}
	
	public void addDie(Die die) {
		addDieToCup(die);
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

	public int getDiceCount() {
		return diceCount;
	}
	
	private void addDieToCup(Die die) {
		diceCup.add(die);
		this.diceCount++;
	}
}
