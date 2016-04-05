package org.agileandbeyond.dandd.tddexercise.equipment.armor;

import org.agileandbeyond.dandd.tddexercise.equipment.WearablePosition;

public class Shield extends Armor {

	public Shield(){
		this.setArmorClassModifier(4);
		this.setPosition(WearablePosition.SHIELD);
	}
}
