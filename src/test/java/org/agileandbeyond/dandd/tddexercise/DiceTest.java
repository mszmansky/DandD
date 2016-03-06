package org.agileandbeyond.dandd.tddexercise;

import static org.junit.Assert.*;

import org.junit.Test;

public class DiceTest {

	
	@Test
	public void shouldRollANumberBetweenOneAndSix() {
		Die d6 = new Die(6);
		d6.roll();
		
		assertTrue(d6.getValue() >= 1 && d6.getValue() <=6);
	}
	
	@Test
	public void shouldRollANumberBetweenOneAndTen() {
		Die d10 = new Die(10);
		d10.roll();
		
		assertTrue(d10.getValue() >= 1 && d10.getValue() <=10);
	}
	
	@Test
	public void shouldHaveAValueInProperRange() {
		DiceRollCup diceCup = new DiceRollCup();
		diceCup.addDie(new Die(6));
		diceCup.addDie(new Die(6));
		diceCup.addDie(new Die(6));
		
		diceCup.throwDice();
		
		assertTrue(diceCup.getValue() >= 3 && diceCup.getValue() <= 18);
	}
	
	@Test
	public void shouldPrintDiceRollCupProperly() {
		DiceRollCup diceCup = new DiceRollCup();
		diceCup.addDie(new Die(6));
		diceCup.addDie(new Die(6));
		diceCup.addDie(new Die(6));
		
		diceCup.throwDice();
		System.out.println(diceCup.toString());
	}
	
	@Test
	public void shouldPrintDiceRollCupProperlyWithDifferentDie() {
		DiceRollCup diceCup = new DiceRollCup();
		diceCup.addDie(new Die(4));
		diceCup.addDie(new Die(6));
		diceCup.addDie(new Die(8));
		diceCup.addDie(new Die(10));
		
		diceCup.throwDice();
		System.out.println(diceCup.toString());
	}
}
