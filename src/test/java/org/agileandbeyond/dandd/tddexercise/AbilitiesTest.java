package org.agileandbeyond.dandd.tddexercise;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class AbilitiesTest {

	@Before
	public void setUp() {
		
	}
	
	@Test
	public void defaultValuesOfStrengthAbilityIsTen() {
		Ability ability = new Ability();
		
		assertTrue(ability.getScore() == 10);
	}
	
	@Test
	public void abilityShouldNotHaveAScoreGreaterThanTwenty() {
		Ability ability = new Ability();
		ability.setScore(25);
		
		assertEquals(20, ability.getScore());
	}
	@Test
	public void abilityShouldNotHaveAScoreLessThanOne() {
		Ability ability = new Ability();
		ability.setScore(0);
		
		assertEquals(1, ability.getScore());
	}
	
	@Test
	public void abilityModifierShouldBeCorrectWhenScoreIsTwenty() {
		Ability ability = new Ability(20);
		assertEquals(5, ability.getModifier());
	}
	
	@Test
	public void abilityModifierSHouldBeCorrectWhenScoreIsNineteen() {
		Ability ability = new Ability(19);
		assertEquals(4, ability.getModifier());
	}
	@Test
	public void abilityModifierSHouldBeCorrectWhenScoreIs1() {
		Ability ability = new Ability(1);
		assertEquals(-5, ability.getModifier());
	}
	
	@Test
	public void abilityShouldHaveTheCorrectTypeWhenTypeIsStrength() {
		Ability ability = new Ability(1);
		ability.setType(AbilityType.STRENGTH);
		
		assertEquals(AbilityType.STRENGTH, ability.getType());
	}
	@Test
	public void abilityShouldHaveTheCorrectTypeIsDexterity() {
		Ability ability = new Ability(1);
		ability.setType(AbilityType.DEXTERITY);
		
		assertEquals(AbilityType.DEXTERITY, ability.getType());
	}
	
	@Test
	public void abilityShouldBeConstructedWithModierMapNotNullUsingDefaultConstructor() {
		Ability ability = new Ability();
		
		assertNotNull(ability.getModifier());
	}
	
}
