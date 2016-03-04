package org.agileandbeyond.dandd.tddexercise;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class RaceTest {

	@Before
	public void setUp() {
		
	}
	
	@Test
	public void getAbilityModifierForOrcStrengthShouldBe2() {
		Race race = new Race();
		
		race.setRaceType(RaceType.ORC);
		assertEquals(race.getAbilityModifier(AbilityType.STRENGTH), 2);		
	}
	
	public void getAbilityModifierForDwarfCharismaShouldBeNegative1() {
		Race race = new Race();
		
		race.setRaceType(RaceType.DWARF);
		assertEquals(race.getAbilityModifier(AbilityType.CHARISMA),-1);
	}
}
