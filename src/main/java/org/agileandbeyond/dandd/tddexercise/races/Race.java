package org.agileandbeyond.dandd.tddexercise.races;

import org.agileandbeyond.dandd.tddexercise.RaceType;

public abstract class Race {
	

	private RaceType name;
	private int armorClassModifier;
	private int strengthModifier;
	private int dexterityModifier;
	private int constitutionModifier;
	private int wisdomModifier;
	private int intelligenceModifer;
	private int charismaModifier;
	
	public Race() {
		//Default modifiers to 0
		armorClassModifier = 0;
		strengthModifier = 0;
		dexterityModifier = 0;
		constitutionModifier = 0;
		wisdomModifier = 0;
		intelligenceModifer = 0;
		charismaModifier = 0;
	}

	public RaceType getName() {
		return name;
	}
	
	public void setName(RaceType name) {
		this.name = name;
	}
	public int getArmorClassModifier() {
		return armorClassModifier;
	}

	public void setArmorClassModifier(int armorClassModifier) {
		this.armorClassModifier = armorClassModifier;
	}

	public int getStrengthModifier() {
		return strengthModifier;
	}

	public void setStrengthModifier(int strengthModifier) {
		this.strengthModifier = strengthModifier;
	}

	public int getDexterityModifier() {
		return dexterityModifier;
	}

	public void setDexterityModifier(int dexterityModifier) {
		this.dexterityModifier = dexterityModifier;
	}

	public int getConstitutionModifier() {
		return constitutionModifier;
	}

	public void setConstitutionModifier(int constitutionModifier) {
		this.constitutionModifier = constitutionModifier;
	}

	public int getWisdomModifier() {
		return wisdomModifier;
	}

	public void setWisdomModifier(int wisdomModifier) {
		this.wisdomModifier = wisdomModifier;
	}

	public int getIntelligenceModifer() {
		return intelligenceModifer;
	}

	public void setIntelligenceModifer(int intelligenceModifer) {
		this.intelligenceModifer = intelligenceModifer;
	}

	public int getCharismaModifier() {
		return charismaModifier;
	}

	public void setCharismaModifier(int charismaModifier) {
		this.charismaModifier = charismaModifier;
	}
}
