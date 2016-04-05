package org.agileandbeyond.dandd.tddexercise.equipment;

public abstract class Wearable extends Equipment {

	private WearablePosition position;

	public WearablePosition getPosition() {
		return position;
	}

	public void setPosition(WearablePosition position) {
		this.position = position;
	}
	
	
}
