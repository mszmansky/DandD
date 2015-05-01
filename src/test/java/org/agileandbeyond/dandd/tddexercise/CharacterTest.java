package org.agileandbeyond.dandd.tddexercise;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class CharacterTest {
	
	private DandDCharacter character;
	private DandDCharacter monster;
	
	@Before
	public void before() {
		character = new DandDCharacter();
		monster = new DandDCharacter();
	}

	@Test
	public void shouldReturnNullNameWhenNotSet() {
		assertNull(character.getName());
	}
	
	@Test
	public void shouldSetCharacterNameWhenSet() {
		String name = "Jeff";
		character.setName(name);
		assertEquals(name, character.getName());
	}
	
	@Test
	public void shouldGetGoodCharacterAlignmentWhenSetToGood() {
		character.setAlignment(Alignment.GOOD);
		assertEquals(Alignment.GOOD, character.getAlignment());
	}
	
	@Test
	public void shouldReturnNullAlignmentWhenNotSet() {
		assertNull(character.getAlignment());
	}
	
	@Test
	public void characterShouldHaveADefaultArmorClassOf10() {
		assertEquals(10, character.getArmorClass());
	}
	
	@Test
	public void characterShouldHaveAnArmorClassThatISet() {
		character.setArmorClass(5);
		assertEquals(5, character.getArmorClass());
	}
	
	@Test
	public void characterShouldHaveADefaultHitPointsOf5() {
		assertEquals(5, character.getHitPoints());
	}
	
	@Test
	public void characterShouldHaveHitPointsThatAreSet() {
		character.setHitPoints(25);
		assertEquals(25, character.getHitPoints());
	}
	
	@Test
	public void characterCannotHaveNegativeArmorClass() {
		character.setArmorClass(-5);
		assertEquals(0, character.getArmorClass());
	}
	
	@Test
	public void characterCannotHaveNegativeHitPoints() {
		character.setHitPoints(-4);
		assertEquals(0, character.getHitPoints());
	}
	
	@Test
	public void charactersAttackIsSuccessfulWhenRollIsGreaterThanCombatantsArmorClass() {
		monster.setArmorClass(12);
		assertTrue(character.attack(monster, 20));
	}
	
	@Test
	public void charactersAttackIsSuccessfulWhenRollIsEqualToCombatantsArmorClass() {
		monster.setArmorClass(12);
		assertTrue(character.attack(monster, 12));
	}
	
	@Test
	public void charactersAttacksFailsWhenRollIsLessThanCombatantsArmorClass() {
		monster.setArmorClass(12);
		assertFalse(character.attack(monster, 11));
	}
	
	@Test
	public void whenAttackIsSuccessFullCombtantsTakesOnePointOfDamage () {
		int initHitPoints = monster.getHitPoints();
		int attackRoll = monster.getArmorClass();
		
		character.attack(monster, attackRoll);
		
		assertTrue(initHitPoints-1 == monster.getHitPoints());
	}
	
	@Test
	public void whenAttackIsSuccessfullAndRoleIsTwentyCambatantTakesDoubleDamage() {
		int initHitPoints = monster.getHitPoints();
		
		character.attack(monster, 20);
		
		assertTrue(initHitPoints-2 == monster.getHitPoints());
	}
	
	@Test
	public void combatantIsDeadWhenHitPointsAreZero() {
		while (monster.getHitPoints() > 0) {
			character.attack(monster, monster.getArmorClass());
		}
		
		assertTrue(monster.isDead());
	}
	
	@Test
	public void combatantIsNotDeadWhenHitPointsAreGreaterThanZero() {
		assertFalse(monster.isDead());
	}
	
	@Test
	public void characterShouldHaveStrengthAbility(){
		assertNotNull(character.getAbility(AbilityType.STRENGTH));
	}
	
	@Test
	public void characterStrengthAbilityShouldHaveCorrectType() {
		Ability strength = character.getAbility(AbilityType.STRENGTH);
		assertEquals(AbilityType.STRENGTH, strength);
	}
	
}
