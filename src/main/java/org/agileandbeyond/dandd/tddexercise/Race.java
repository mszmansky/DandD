package org.agileandbeyond.dandd.tddexercise;

public class Race {

	private RaceType raceType;

	public Race() {
		// Race defaults to Human
		this.raceType = RaceType.HUMAN;
	}

	public RaceType getRaceType() {
		return raceType;
	}

	public void setRaceType(RaceType raceType) {
		this.raceType = raceType;
	}

	public int getAbilityModifier(AbilityType abilityType) {
		int abilityModifier = 0;

		switch (this.raceType) {
		case HUMAN:
			abilityModifier = getHumanModifiers(abilityType);
			break;
		case ORC:
			abilityModifier = getOrcModifiers(abilityType);
			break;
		case DWARF:
			abilityModifier = getDwarfModifiers(abilityType);
			break;
		case ELF:
			abilityModifier = getElfModifiers(abilityType);
			break;
		case HALFLING:
			abilityModifier = getHalflingModifiers(abilityType);
			break;
		}
		return abilityModifier;
	}

	private int getHumanModifiers(AbilityType AbilityType) {
		// No modifiers for human race
		return 0;
	}

	private int getOrcModifiers(AbilityType abilityType) {
		int abilityModifier = 0;
		switch (abilityType) {
		case STRENGTH:
			abilityModifier = 2;
			break;
		case DEXTERITY:
			abilityModifier = 0;
			break;
		case CHARISMA:
			abilityModifier = -1;
			break;
		case CONSTITUTION:
			abilityModifier = 0;
			break;
		case INTELLIGENCE:
			abilityModifier = -1;
			break;
		case WISDOM:
			abilityModifier = -1;
			break;
		}
		return abilityModifier;
	}

	private int getDwarfModifiers(AbilityType abilityType) {
		int abilityModifier = 0;
		switch (abilityType) {
		case STRENGTH:
			abilityModifier = 0;
			break;
		case DEXTERITY:
			abilityModifier = 0;
			break;
		case CHARISMA:
			abilityModifier = -1;
			break;
		case CONSTITUTION:
			abilityModifier = 1;
			break;
		case INTELLIGENCE:
			abilityModifier = 0;
			break;
		case WISDOM:
			abilityModifier = 0;
			break;
		}
		return abilityModifier;
	}

	private int getElfModifiers(AbilityType abilityType) {
		int abilityModifier = 0;
		switch (abilityType) {
		case STRENGTH:
			abilityModifier = 0;
			break;
		case DEXTERITY:
			abilityModifier = 1;
			break;
		case CHARISMA:
			abilityModifier = 0;
			break;
		case CONSTITUTION:
			abilityModifier = -1;
			break;
		case INTELLIGENCE:
			abilityModifier = 0;
			break;
		case WISDOM:
			abilityModifier = 0;
			break;
		}
		return abilityModifier;
	}

	private int getHalflingModifiers(AbilityType abilityType) {
		int abilityModifier = 0;
		switch (abilityType) {
		case STRENGTH:
			abilityModifier = -1;
			break;
		case DEXTERITY:
			abilityModifier = 1;
			break;
		case CHARISMA:
			abilityModifier = 0;
			break;
		case CONSTITUTION:
			abilityModifier = 0;
			break;
		case INTELLIGENCE:
			abilityModifier = 0;
			break;
		case WISDOM:
			abilityModifier = 0;
			break;
		}
		return abilityModifier;
	}
}
