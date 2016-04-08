package org.agileandbeyond.dandd.tddexercise.equipment.armor;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;
import org.agileandbeyond.dandd.tddexercise.character.Character;
import org.agileandbeyond.dandd.tddexercise.equipment.WearablePosition;
import org.agileandbeyond.dandd.tddexercise.exception.CannotUseArmorException;

public class RingTest {

	private Character gorg;
	private Ring ring1;
	private Ring ring2;
	
	@Before
	public void setup() {
		gorg = new Character();
		ring1 = new Ring();
		ring2 = new Ring();
	}
	
	@Test(expected = CannotUseArmorException.class)
	public void shouldThrowCannotUseArmorException() throws CannotUseArmorException {
		ring1.setPosition(WearablePosition.UNKNOWN);
		
		gorg.donArmor(ring1);
		
		assertEquals(12, gorg.getArmorClass());
	}
	
	@Test
	public void shouldIncreaseArmorClassByTwoWhenWearingARing() throws CannotUseArmorException{
		gorg.donArmor(ring1);
		
		assertEquals(12, gorg.getArmorClass());
	}
	
	@Test
	public void shouldIncreaseArmorClassByFourWhenWearingTwoRings() throws CannotUseArmorException {
		gorg.donArmor(ring1);
		gorg.donArmor(ring2);
		
		assertEquals(14, gorg.getArmorClass());
	}
}
