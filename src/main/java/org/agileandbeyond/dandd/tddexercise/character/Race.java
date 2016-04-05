package org.agileandbeyond.dandd.tddexercise.character;

public abstract class Race {

	private RaceType raceType;
	private int armorClassModifier;
	private int strengthModifier;
	private int dexterityModifier;
	private int constitutionModifier;
	private int wisdomModifier;
	private int intelligenceModifier;
	private int charismaModifier;
	
	public Race() {
		//Default to Human
		this.raceType = RaceType.HUMAN;
		this.armorClassModifier = 0;
		this.strengthModifier = 0;
		this.dexterityModifier = 0;
		this.constitutionModifier = 0;
		this.wisdomModifier = 0;
		this.intelligenceModifier = 0;
		this.charismaModifier = 0;
	}

	public RaceType getRaceType() {
		return raceType;
	}

	public void setRaceType(RaceType raceType) {
		this.raceType = raceType;
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

	public int getIntelligenceModifier() {
		return intelligenceModifier;
	}

	public void setIntelligenceModifier(int intelligenceModifier) {
		this.intelligenceModifier = intelligenceModifier;
	}

	public int getCharismaModifier() {
		return charismaModifier;
	}

	public void setCharismaModifier(int charismaModifier) {
		this.charismaModifier = charismaModifier;
	}
	
	
}
