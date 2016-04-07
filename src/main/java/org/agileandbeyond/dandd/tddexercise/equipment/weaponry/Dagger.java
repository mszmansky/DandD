package org.agileandbeyond.dandd.tddexercise.equipment.weaponry;

public class Dagger extends Weapon {

	public Dagger() {
		this.setTwoHanded(false);
		this.setName("Dagger");
		this.setAttackModifier(1);
		this.setDamageModifier(1);
		this.setRequiredLevel(1);
	}
}
