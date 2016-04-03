package org.agileandbeyond.dandd.tddexercise.equipment.armor;

import org.agileandbeyond.dandd.tddexercise.equipment.WearablePosition;

public class Boots extends Armor {

	public Boots() {
		this.setPosition(WearablePosition.FEET);
		this.setArmorClassModifier(1);
	}
}
