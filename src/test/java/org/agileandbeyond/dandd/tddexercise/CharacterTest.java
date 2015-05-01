package org.agileandbeyond.dandd.tddexercise;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

import java.util.Map;

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
		
		assertEquals(AbilityType.STRENGTH, strength.getType());
	}
	
	@Test
	public void characterDexterityAbilityShouldHaveCorrectType() {
		Ability strength = character.getAbility(AbilityType.DEXTERITY);
		
		assertEquals(AbilityType.DEXTERITY, strength.getType());
	}
	@Test
	public void characterCharismaAbilityShouldHaveCorrectType() {
		Ability strength = character.getAbility(AbilityType.CHARISMA);
		
		assertEquals(AbilityType.CHARISMA, strength.getType());
	}
	@Test
	public void characterConstitutionAbilityShouldHaveCorrectType() {
		Ability strength = character.getAbility(AbilityType.CONSTITUTION);
		
		assertEquals(AbilityType.CONSTITUTION, strength.getType());
	}
	@Test
	public void characterIntelligenceAbilityShouldHaveCorrectType() {
		Ability strength = character.getAbility(AbilityType.INTELLIGENCE);
		
		assertEquals(AbilityType.INTELLIGENCE, strength.getType());
	}
	@Test
	public void characterWisdomAbilityShouldHaveCorrectType() {
		Ability strength = character.getAbility(AbilityType.WISDOM);
		
		assertEquals(AbilityType.WISDOM, strength.getType());
	}
	
	@Test
	public void characterShouldHaveAllSixAbilities() {
		Map<AbilityType, Ability> abilities = character.getAbilities();
		
		assertEquals(6, abilities.size());
	}
	
	@Test
	public void shouldBeAbleToSetTheCharactersStrength() {
		character.setStrength(15);
		
		assertEquals(15, character.getAbility(AbilityType.STRENGTH).getScore());
	}
	
//	abilities.put(AbilityType.STRENGTH, new Ability(AbilityType.STRENGTH));
//	abilities.put(AbilityType.DEXTERITY, new Ability(AbilityType.DEXTERITY));
//	abilities.put(AbilityType.CHARISMA, new Ability(AbilityType.CHARISMA));
//	abilities.put(AbilityType.CONSTITUTION, new Ability(AbilityType.CONSTITUTION));
//	abilities.put(AbilityType.INTELLIGENCE, new Ability(AbilityType.INTELLIGENCE));
//	abilities.put(AbilityType.WISDOM, new Abili
	@Test
	public void shouldBeAbleToSetTheCharactersDexterity() {
		character.setDexterity(12);
		
		assertEquals(12, character.getAbility(AbilityType.DEXTERITY).getScore());
	}
	@Test
	public void shouldBeAbleToSetTheCharactersCharisma() {
		character.setCharisma(11);
		
		assertEquals(11, character.getAbility(AbilityType.CHARISMA).getScore());
	}
	@Test
	public void shouldBeAbleToSetTheCharactersConstitution() {
		character.setConstitution(9);
		
		assertEquals(9, character.getAbility(AbilityType.CONSTITUTION).getScore());
	}
	@Test
	public void shouldBeAbleToSetTheCharactersIntelligence() {
		character.setIntelligence(8);
		
		assertEquals(8, character.getAbility(AbilityType.INTELLIGENCE).getScore());
	}
	@Test
	public void shouldBeAbleToSetTheCharactersWisdom() {
		character.setWisdom(7);
		
		assertEquals(7, character.getAbility(AbilityType.WISDOM).getScore());
	}
	
}
