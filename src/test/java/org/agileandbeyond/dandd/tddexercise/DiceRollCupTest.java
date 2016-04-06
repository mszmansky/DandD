package org.agileandbeyond.dandd.tddexercise;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class DiceRollCupTest {

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
		
		assertTrue(d10.getValue() >= 0 && d10.getValue() <=9);
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
		assertTrue(diceCup.getValue() >= 0 && diceCup.getValue() <= 9);
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
		assertTrue(diceCup.getValue() >= 0 && diceCup.getValue() <= 18);
	}
	
	@Test
	public void shouldCreateAValidPercentile() {
		DiceRollCup diceCup = new DiceRollCup("d100");
		assertEquals(1, diceCup.getDiceCount());
		diceCup.throwDice();
		assertTrue(diceCup.getValue() >= 1 && diceCup.getValue() <= 100);
		System.out.println(diceCup.toString() + "%");
	}
	
	@Test
	public void shouldGetTheDiceInTheCup() {
		DiceRollCup diceCup = new DiceRollCup();
		Die d10 = new Die(10);
		diceCup.addDie(d10);
		
		assertTrue(diceCup.getDice().contains(d10));
	}
	
	@Test
	public void shouldGetTheCorrectDesignatedDice() {
		Die tensDigit = new Die(10, "tens");
		Die onesDigit = new Die(10, "ones");
		int tens = 0;
		int ones = 0;
		
		DiceRollCup cup = new DiceRollCup();
		cup.addDie(tensDigit);
		cup.addDie(onesDigit);
		cup.throwDice();
		for (Die die : cup.getDice()) {
			if (die.getDesignator().equals("tens")) {
				tens = die.getValue() * 10;
			} else {
				ones = die.getValue();
			}
		}
		int percent = tens + ones;
		
		assertTrue(percent >= 1 && percent <= 100);
	}
	
}
