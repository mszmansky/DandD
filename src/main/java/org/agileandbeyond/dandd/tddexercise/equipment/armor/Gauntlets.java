package org.agileandbeyond.dandd.tddexercise.equipment.armor;

import org.agileandbeyond.dandd.tddexercise.equipment.WearablePosition;

public class Gauntlets extends Armor {

	public Gauntlets() {
		this.setPosition(WearablePosition.WRISTS);
		this.setArmorClassModifier(1);
	}
}
