package org.agileandbeyond.dandd.tddexercise;

public class Orc extends Race {
	public Orc() {
		super();
		this.setRaceType(RaceType.ORC);
		this.setArmorClassModifier(2);
		this.setStrengthModifier(2);
		this.setWisdomModifier(-1);
		this.setIntelligenceModifier(-1);
		this.setCharismaModifier(-1);
	}
}
