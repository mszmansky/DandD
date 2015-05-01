package org.agileandbeyond.dandd.tddexercise;

public class DandDCharacter {
	
	private String name;
	private Alignment alignment;
	private int armorClass = 10;
	private int hitPoints = 5;
	private Ability strength;
	
	private static int CRITICAL_HIT = 20;

	public Alignment getAlignment() {
		return alignment;
	}

	public void setAlignment(Alignment alignment) {
		this.alignment = alignment;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getArmorClass() {
		return armorClass;
	}

	public void setArmorClass(int armorClass) {
		if (armorClass < 0) {
			armorClass = 0;
		}
		
		this.armorClass = armorClass;
		
	}

	public int getHitPoints() {
		return hitPoints;
	}

	public void setHitPoints(int hitPoints) {
		if (hitPoints < 0) {
			hitPoints = 0;
		}
		
		this.hitPoints = hitPoints;
	}

	public boolean attack(DandDCharacter combatant, int attackRoll) {
		boolean hit = false;
		int damage = 1;
		
		if (attackRoll >= combatant.getArmorClass()) {
			hit = true;
			if (attackRoll == CRITICAL_HIT) {
				damage = damage * 2;
			}
			combatant.setHitPoints(combatant.getHitPoints()-damage);
		}
		
		return hit;
	}

	public boolean isDead() {
		return hitPoints <= 0;
	}

	public Ability getAbility(AbilityType strength) {
		return new Ability();
	}

}
