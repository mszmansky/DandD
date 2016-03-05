package org.agileandbeyond.dandd.tddexercise;

public abstract class Armor extends Wearable{

	private int armorClassModifier;

	public int getArmorClassModifier() {
		return armorClassModifier;
	}

	public void setArmorClassModifier(int modifier) {
		this.armorClassModifier = modifier;
	}
	
	
}
