package org.agileandbeyond.dandd.tddexercise;

import java.util.HashMap;
import java.util.Map;

public class Character {
	
	private static int CRITICAL_HIT = 20;
	
	private String name;
	private Alignment alignment;
	private int experiencePoints;
	private int armorClass = 10;
	private int hitPoints = 5;
	private Map<AbilityType, Ability> abilities;

	public Character() {
		abilities = new HashMap<AbilityType, Ability>();
		abilities.put(AbilityType.STRENGTH, new Ability(AbilityType.STRENGTH));
		abilities.put(AbilityType.DEXTERITY, new Ability(AbilityType.DEXTERITY));
		abilities.put(AbilityType.CHARISMA, new Ability(AbilityType.CHARISMA));
		abilities.put(AbilityType.CONSTITUTION, new Ability(AbilityType.CONSTITUTION));
		abilities.put(AbilityType.INTELLIGENCE, new Ability(AbilityType.INTELLIGENCE));
		abilities.put(AbilityType.WISDOM, new Ability(AbilityType.WISDOM));
	}
	
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

	public Ability getAbility(AbilityType abilityType) {
		return abilities.get(abilityType);
	}

	protected Map<AbilityType, Ability> getAbilities() {
		return abilities;
	}

	public void setStrength(int score) {
		abilities.get(AbilityType.STRENGTH).setScore(score);
	}

	public void setDexterity(int score) {
		abilities.get(AbilityType.DEXTERITY).setScore(score);
	}

	public void setCharisma(int score) {
		abilities.get(AbilityType.CHARISMA).setScore(score);
	}

	public void setConstitution(int score) {
		abilities.get(AbilityType.CONSTITUTION).setScore(score);
	}

	public void setIntelligence(int score) {
		abilities.get(AbilityType.INTELLIGENCE).setScore(score);
	}

	public void setWisdom(int score) {
		abilities.get(AbilityType.WISDOM).setScore(score);
	}

	public Object getExperiencePoints() {
		return experiencePoints;
	}	

	public boolean isDead() {
		return hitPoints <= 0;
	}
	
	public boolean attack(Character combatant, int attackRoll) {
		boolean hit = false;
		int damage = 1;
		
		if (attackRoll >= combatant.getArmorClass()) {
			hit = true;
			experiencePoints+=10;
			if (attackRoll == CRITICAL_HIT) {
				damage = damage * 2;
			}
			combatant.setHitPoints(combatant.getHitPoints()-damage);
		}
		
		return hit;
	}

}
