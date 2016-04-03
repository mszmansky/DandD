package org.agileandbeyond.dandd.tddexercise;

import static org.junit.Assert.*;

import org.junit.Test;

public class DieTest {
	
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
	
}
