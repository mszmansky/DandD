package org.agileandbeyond.dandd.tddexercise;

import static org.junit.Assert.*;

import java.util.Map;

import org.junit.Before;
import org.junit.Test;

public class CharacterTest {
	
	private Character character;
	private Character combatant;
	
	@Before
	public void before() {
		character = new Character();
		combatant = new Character();
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
		combatant.setArmorClass(12);
		assertTrue(character.attack(combatant, 20));
	}
	
	@Test
	public void charactersAttackIsSuccessfulWhenRollIsEqualToCombatantsArmorClass() {
		combatant.setArmorClass(12);
		assertTrue(character.attack(combatant, 12));
	}
	
	@Test
	public void charactersAttacksFailsWhenRollIsLessThanCombatantsArmorClass() {
		combatant.setArmorClass(12);
		assertFalse(character.attack(combatant, 11));
	}
	
	@Test
	public void whenAttackIsSuccessFullCombtantsTakesOnePointOfDamage () {
		int initHitPoints = combatant.getHitPoints();
		int attackRoll = combatant.getArmorClass();
		
		character.attack(combatant, attackRoll);
		
		assertTrue(initHitPoints-1 == combatant.getHitPoints());
	}
	
	@Test
	public void whenAttackIsSuccessfullAndRoleIsTwentyCambatantTakesDoubleDamage() {
		int initHitPoints = combatant.getHitPoints();
		
		character.attack(combatant, 20);
		
		assertTrue(initHitPoints-2 == combatant.getHitPoints());
	}
	
	@Test
	public void combatantIsDeadWhenHitPointsAreZero() {
		while (combatant.getHitPoints() > 0) {
			character.attack(combatant, combatant.getArmorClass());
		}
		
		assertTrue(combatant.isDead());
	}
	
	@Test
	public void combatantIsNotDeadWhenHitPointsAreGreaterThanZero() {
		assertFalse(combatant.isDead());
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
	
	@Test
	public void shouldHaveZeroExperienceWhenCharacterIsCreated() {
		assertEquals(0, character.getExperiencePoints());
	}
	
	@Test
	public void shouldGainTenExperiencePointsWhenAttackIsSuccessful() {
		character.attack(combatant, 14);
		
		assertEquals(10, character.getExperiencePoints());
	}
	
	@Test
	public void shouldNotGainExperiencePointsWhenAttackIsUnsuccessful() {
		character.attack(combatant, 6);
		
		assertEquals(0, character.getExperiencePoints());
	}
	
	@Test
	public void shouldHaveWeaponSetToNullByDefault() {
		assertNull(character.getWeapon());
	}
	
	@Test
	public void shouldHaveWeaponSetToTheSameWhenSet() {
		Weapon dagger = new Weapon();
		dagger.setName("Dagger");
		dagger.setAttackModifier(1);
		character.setWeapon(dagger);
		
		Weapon weapon = character.getWeapon();
		assertSame(weapon, dagger);
	}

	@Test
	public void willSetTheCharacterClassToPaladin() throws Exception {
		character.setCharacterClass(CharacterClass.PALADIN);
		assertTrue("Character's class should be PALADIN", CharacterClass.PALADIN.equals(character.getCharacterClass()));
	}

	@Test
	public void willSetTheCharacterClassToRogue() throws Exception {
		character.setCharacterClass(CharacterClass.ROGUE);
		assertTrue("Character's class should be Rogue", CharacterClass.ROGUE.equals(character.getCharacterClass()));
	}

	@Test
	public void willSetTheCharacterClassToWarMonk() throws Exception {
		character.setCharacterClass(CharacterClass.WAR_MONK);
		assertTrue("Character's class should be Rogue", CharacterClass.WAR_MONK.equals(character.getCharacterClass()));
	}

	@Test
	public void willSetTheCharacterClassToFighter() throws Exception {
		character.setCharacterClass(CharacterClass.FIGHTER);
		assertTrue("Character's class should be Rogue", CharacterClass.FIGHTER.equals(character.getCharacterClass()));
	}
}
