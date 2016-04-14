package org.agileandbeyond.dandd.tddexercise.character;

public class Dwarf extends Race {

	public Dwarf() {
		super();
		this.setRaceType(RaceType.DWARF);
		
		this.setConstitutionModifier(1);
		this.setCharismaModifier(-1);
	}
	
	@Override
	public int getAttackModifier(Character combatant) {
		int attackModifier = 0;
		
		if (combatant.getRace().getRaceType() == RaceType.ORC) {
			attackModifier = 2;
		}
		return attackModifier;	
	}
	
	@Override
	public int getDamageModifier(Character combatant) {
		int damageModifier = 0;
		
		if (combatant.getRace().getRaceType() == RaceType.ORC) {
			damageModifier = 2;
		}
		
		return damageModifier;
	}
}
