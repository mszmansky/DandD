package org.agileandbeyond.dandd.tddexercise;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

public class PurseTest {

	private Purse purse;
	
	@Before
	public void setUp(){
		purse = new Purse();
		purse.setGoldCount(42);
	}
	
	@Test
	public void canSetAndGetGoldCount(){
		purse.setGoldCount(42);
		
		assertEquals(42, purse.getGoldCount());
	}
	
	@Test
	public void canAddGold(){
		purse.addGold(3);
		
		assertEquals(45, purse.getGoldCount());
	}
	
	@Test
	public void canSpendGold() throws InsufficientFundsException{
		purse.spendGold(3);
		
		assertEquals(39, purse.getGoldCount());
	}
	
	@Test(expected=InsufficientFundsException.class)
	public void throwsExceptionWhenNotEnoughGold() throws InsufficientFundsException{
		purse.spendGold(50);
	}
	
}
