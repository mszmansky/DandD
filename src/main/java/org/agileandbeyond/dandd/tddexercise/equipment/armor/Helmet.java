package org.agileandbeyond.dandd.tddexercise.equipment.armor;

import org.agileandbeyond.dandd.tddexercise.equipment.WearablePosition;

public class Helmet extends Armor {

	public Helmet() {
		this.setPosition(WearablePosition.HEAD);
		this.setArmorClassModifier(1);
	}
}
