package org.agileandbeyond.dandd.tddexercise.equipment.armor;

import org.agileandbeyond.dandd.tddexercise.equipment.WearablePosition;

public class MailArmor extends Armor {

	public MailArmor() {
		this.setPosition(WearablePosition.TORSO);
		this.setArmorClassModifier(4);
	}
}
