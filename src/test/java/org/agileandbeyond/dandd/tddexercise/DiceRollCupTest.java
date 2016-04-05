package org.agileandbeyond.dandd.tddexercise;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class DiceRollCupTest {

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
	public void shouldHaveThreeDiceInCup() {
		DiceRollCup diceCup = new DiceRollCup();
		diceCup.addDie(new Die(6));
		diceCup.addDie(new Die(6));
		diceCup.addDie(new Die(6));
		
		assertEquals(3, diceCup.getDiceCount());
	}
	
	@Test
	public void shouldHaveZeroDiceInCupWhenNoDiceAreAddedYet() {
		DiceRollCup diceCup = new DiceRollCup();
		
		assertEquals(0, diceCup.getDiceCount());
	}
	
	@Test
	public void shouldHaveZeroDiceInCupAfterDiceAreThrown() {
		DiceRollCup diceCup = new DiceRollCup();
		diceCup.addDie(new Die(6));
		diceCup.addDie(new Die(6));
		diceCup.addDie(new Die(6));
		diceCup.throwDice();
		
		assertEquals(0, diceCup.getDiceCount());
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
	
	@Test
	public void shouldCreateOneSixSidedDieInDiceRollCupUsingDiceNotation() {
		DiceRollCup diceCup = new DiceRollCup("1d6");
		assertEquals(1, diceCup.getDiceCount());
		diceCup.throwDice();
		assertTrue(diceCup.getValue() >= 1 && diceCup.getValue() <= 6);
	}
	
	@Test
	public void shouldCreateTwoSixSidedDieInDiceRollCupUsingDiceNotation() {
		DiceRollCup diceCup = new DiceRollCup("2d6");
		assertEquals(2, diceCup.getDiceCount());
		diceCup.throwDice();
		assertTrue(diceCup.getValue() >= 2 && diceCup.getValue() <= 12);
	}
	
	@Test
	public void shouldCreateOneTenSidedDieInDiceRollCupUsingDiceNotation() {
		DiceRollCup diceCup = new DiceRollCup("d10");
		assertEquals(1, diceCup.getDiceCount());
		diceCup.throwDice();
		assertTrue(diceCup.getValue() >= 1 && diceCup.getValue() <= 10);
	}
	
	@Test(expected=IllegalArgumentException.class)
	public void shouldThrowIllegalArgumentExceptionWhenNotDiceNotation() {
		new DiceRollCup("Grog");
	}
	
	@Test
	public void shouldCreateTwoTenSidedDiceInDiceRollCupUsingDiceNotation() {
		DiceRollCup diceCup = new DiceRollCup("2d10");
		assertEquals(2, diceCup.getDiceCount());
		diceCup.throwDice();
		assertTrue(diceCup.getValue() >= 2 && diceCup.getValue() <= 20);
	}
	
	@Test
	public void shouldCreateAValidPercentile() {
		DiceRollCup diceCup = new DiceRollCup("d100");
		assertEquals(1, diceCup.getDiceCount());
		diceCup.throwDice();
		assertTrue(diceCup.getValue() >= 1 && diceCup.getValue() <= 100);
		System.out.println(diceCup.toString() + "%");
	}
	
}
