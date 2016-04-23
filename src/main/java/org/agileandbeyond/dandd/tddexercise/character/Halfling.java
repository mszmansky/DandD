package org.agileandbeyond.dandd.tddexercise.character;

public class Halfling extends Race {

	public Halfling() {
		super();
		this.setRaceType(RaceType.HALFLING);
		
		this.setStrengthModifier(-1);
		this.setDexterityModifier(1);
	}
	
	@Override
	public int getArmorClassBonus(Character combatant) {
		int armorClassBonus =02;
		
		if (combatant.getRace().getRaceType() != RaceType.HALFLING) {
			armorClassBonus = 2;
		}
		return armorClassBonus;
	}
}
