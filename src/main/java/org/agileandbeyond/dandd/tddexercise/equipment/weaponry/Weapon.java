package org.agileandbeyond.dandd.tddexercise.equipment.weaponry;

import org.agileandbeyond.dandd.tddexercise.equipment.Equipment;

public class Weapon extends Equipment{

	private int attackModifier;
	private int damageModifier;
	private boolean twoHanded = false;

	public int getDamageModifier() {
		return damageModifier;
	}

	public void setDamageModifier(int damageModifier) {
		this.damageModifier = damageModifier;
	}

	public int getAttackModifier() {
		return attackModifier;
	}

	public void setAttackModifier(int attackModifier) {
		this.attackModifier = attackModifier;
	}

	public boolean isTwoHanded() {
		return twoHanded;
	}

	public void setTwoHanded(boolean twoHanded) {
		this.twoHanded = twoHanded;
	}
	
	
}
