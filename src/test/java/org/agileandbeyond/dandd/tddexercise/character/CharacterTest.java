package org.agileandbeyond.dandd.tddexercise.character;

import static org.junit.Assert.*;

import java.util.Map;

import org.agileandbeyond.dandd.tddexercise.character.Ability;
import org.agileandbeyond.dandd.tddexercise.character.AbilityType;
import org.agileandbeyond.dandd.tddexercise.character.Alignment;
import org.agileandbeyond.dandd.tddexercise.character.Character;
import org.agileandbeyond.dandd.tddexercise.equipment.weaponry.Dagger;
import org.agileandbeyond.dandd.tddexercise.equipment.weaponry.Weapon;
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
	public void shouldHaveALevelOfOneWhenCharacterIsCreated() {
		assertEquals(1, character.getLevel());
	}
	
	@Test
	public void shouldHaveALevelOfTwoWhenCharacterReaches1000ExperiencePoints() {
		character.increaseExperiencePoints(1000);
		
		assertEquals(2, character.getLevel());
	}
	
	@Test
	public void shouldHaveALevelOfThreeWhenCharacterReaches2000ExperiencePoints() {
		character.increaseExperiencePoints(2000);
		
		assertEquals(3, character.getLevel());
	}
	
	@Test
	public void shouldHaveALevelOfThreeWhenCharacterReaches2999ExperiencePoints() {
		character.increaseExperiencePoints(2999);
		
		assertEquals(3, character.getLevel());
	}
	
	@Test
	public void shouldIncreaseHitPointsByFiveWhenConstitutionModifierIsZeroAndLevelIncreases() {
		character.increaseLevel(1);
		
		assertEquals(10, character.getHitPoints());
	}
	
	@Test
	public void shouldIncreaseHitPointsByNineWhenConstitutionModifierIsPlusFourAndLevelIncreases() {
		character.setConstitution(18);
		character.increaseLevel(1);
		
		assertEquals(14, character.getHitPoints());
	}
	
	@Test
	public void shouldHaveAttackRollLevelBonusOfZeroWhenCharacterIsLevelOne() {
		assertEquals(0, character.getAttackRollLevelBonus());
	}
	
	@Test
	public void shouldHaveAttackRollLevelBonusOfOneWhenCharacterIsLevelTwo() {
		character.increaseLevel(1);
		assertEquals(1, character.getAttackRollLevelBonus());
	}
	
	@Test
	public void shouldHaveAttackRollLevelBonusOfOneWhenCharacterIsLevelThree() {
		character.increaseLevel(2);
		assertEquals(1, character.getAttackRollLevelBonus());
	}
	
	@Test
	public void shouldHaveAttackRollLevelBonusOfTwoWhenCharacterIsLevelFour() {
		character.increaseLevel(3);
		assertEquals(2, character.getAttackRollLevelBonus());
	}
	
	@Test
	public void shouldHaveAttackRollLevelBonusOfTwoWhenCharacterIsLevelFive() {
		character.increaseLevel(4);
		assertEquals(2, character.getAttackRollLevelBonus());
	}
	
	
	// Weapon tests
	
	@Test
	public void shouldHaveWeaponSetToNullByDefault() {
		assertNull(character.getWeapon());
	}
	
	@Test
	public void shouldHaveWeaponSetToTheSameWhenSet() throws Exception {
		Weapon dagger = new Dagger();
		character.wieldWeapon(dagger);
		
		Weapon weapon = character.getWeapon();
		assertSame(weapon, dagger);
	}
	
	@Test
	public void shouldGetCorrectValuesForAllHumanAttributes() {
		Human human = new Human();
		character.setRace(human);
		
		assertEquals(RaceType.HUMAN, character.getRace().getRaceType());
		assertEquals(0, character.getRace().getArmorClassModifier());
		assertEquals(0, character.getRace().getStrengthModifier());
		assertEquals(0, character.getRace().getDexterityModifier());
		assertEquals(0, character.getRace().getConstitutionModifier());
		assertEquals(0, character.getRace().getWisdomModifier());
		assertEquals(0, character.getRace().getIntelligenceModifier());
		assertEquals(0, character.getRace().getCharismaModifier());
		assertEquals(0, character.getRace().getCriticalRangeBonus());
	}
	
	@Test
	public void shouldGetCorrectValuesForAllOrcAttributes() {
		Orc orc = new Orc();
		character.setRace(orc);
		
		assertEquals(RaceType.ORC, character.getRace().getRaceType());
		assertEquals(2, character.getRace().getArmorClassModifier());
		assertEquals(2, character.getRace().getStrengthModifier());
		assertEquals(0, character.getRace().getDexterityModifier());
		assertEquals(0, character.getRace().getConstitutionModifier());
		assertEquals(-1, character.getRace().getWisdomModifier());
		assertEquals(-1, character.getRace().getIntelligenceModifier());
		assertEquals(-1, character.getRace().getCharismaModifier());
		assertEquals(0, character.getRace().getCriticalRangeBonus());
	}
	
	@Test
	public void shouldGetCorrectValuesForAllDwarfAttributes() {
		Dwarf dwarf = new Dwarf();
		character.setRace(dwarf);
		
		assertEquals(RaceType.DWARF, character.getRace().getRaceType());
		assertEquals(0, character.getRace().getArmorClassModifier());
		assertEquals(0, character.getRace().getStrengthModifier());
		assertEquals(0, character.getRace().getDexterityModifier());
		assertEquals(1, character.getRace().getConstitutionModifier());
		assertEquals(0, character.getRace().getWisdomModifier());
		assertEquals(0, character.getRace().getIntelligenceModifier());
		assertEquals(-1, character.getRace().getCharismaModifier());
		assertEquals(0, character.getRace().getCriticalRangeBonus());
	}
	
	@Test
	public void shouldGetCorrectValuesForAllElfAttributes() {
		Elf elf = new Elf();
		character.setRace(elf);
		
		assertEquals(RaceType.ELF, character.getRace().getRaceType());
		assertEquals(0, character.getRace().getArmorClassModifier());
		assertEquals(0, character.getRace().getStrengthModifier());
		assertEquals(1, character.getRace().getDexterityModifier());
		assertEquals(-1, character.getRace().getConstitutionModifier());
		assertEquals(0, character.getRace().getWisdomModifier());
		assertEquals(0, character.getRace().getIntelligenceModifier());
		assertEquals(0, character.getRace().getCharismaModifier());
		assertEquals(1, character.getRace().getCriticalRangeBonus());
	}
	
	@Test
	public void shouldLandACriticalHitWithAnAttackRollOf19AsAnElfBecauseElvesAreOverpowered() throws Exception {
		int initialCombatantHp = 20;
		int weaponDamage = 0;
		
		character.setRace(new Elf());
		character.wieldWeapon(new Dagger());
		combatant.setRace(new Human());
		combatant.setArmorClass(10);
		
		weaponDamage = character.getWeapon().getDamageModifier();
		
		combatant.setHitPoints(initialCombatantHp);
		character.attack(combatant, 19);
		
		assertEquals(initialCombatantHp - ((1 + weaponDamage)*2), combatant.getHitPoints());
	}
	
	@Test
	public void shouldMissWhenAnOrcAttacksAnElfDueToPlusTwoToArmorClassWhenElvesAreAttackedByOrcs() {
		character.setRace(new Orc());
		combatant.setRace(new Elf());
		combatant.setArmorClass(10);
		
		assertFalse(character.attack(combatant, 10));
	}
	
	@Test
	public void shouldHitOrcWhenDwarfReceivesRacialAttackModifier() {
		character.setRace(new Dwarf());
		combatant.setRace(new Orc());
		combatant.setArmorClass(10);
		
		assertTrue(character.attack(combatant, 8));
	}
	
	@Test
	public void shouldMissOrcWhenHumanReceivesRacialAttackModifierOfZero() {
		character.setRace(new Human());
		combatant.setRace(new Orc());
		combatant.setArmorClass(10);
		
		assertFalse(character.attack(combatant, 8));
	}
	
	@Test
	public void shouldAddRacialDamageModifierWhenDwarfAttacksOrc() {
		character.setRace(new Dwarf());
		combatant.setRace(new Orc());
		combatant.setArmorClass(10);
		
		combatant.setHitPoints(20);
		character.attack(combatant, 10);
		
		assertEquals(17, combatant.getHitPoints());
	}
}
