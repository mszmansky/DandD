package org.agileandbeyond.dandd.tddexercise;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class DiceRollCup {

	private static final String DICE_PATTERN = "(\\d*)(d)(\\d+)";
	private Set<Die> diceCup;
	private int diceCount;
	private int value;
	
	public DiceRollCup() {
		diceCup = new HashSet<Die>();
	}
	
	public DiceRollCup(String diceNotation) {
		Pattern pattern = Pattern.compile(DICE_PATTERN);
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
			addDieToCup(die);
		}
	}
	
	
	public void throwDice() {
		shake();
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
	
	public Set<Die> getDice() {
		return diceCup;
	}
	
	
	
	
	private void addDieToCup(Die die) {
		diceCup.add(die);
		this.diceCount++;
	}
	
	private void shake() {
		for (Die die : diceCup) {
			die.roll();
		}
	}
}
