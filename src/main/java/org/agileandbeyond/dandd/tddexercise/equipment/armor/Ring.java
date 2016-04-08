package org.agileandbeyond.dandd.tddexercise.equipment.armor;

import org.agileandbeyond.dandd.tddexercise.equipment.WearablePosition;

public class Ring extends Armor {

	public Ring() {
		this.setArmorClassModifier(2);
		this.setPosition(WearablePosition.FINGERS);
		this.setRequiredLevel(1);
		this.setWeight(0);
	}
}
