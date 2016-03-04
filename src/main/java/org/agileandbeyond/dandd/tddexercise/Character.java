package org.agileandbeyond.dandd.tddexercise;

import java.util.HashMap;
import java.util.Map;

public class Character {
	
	public static int CRITICAL_HIT = 20;
	
	public Race getRace() {
		return race;
	}

	public void setRace(Race race) {
		this.race = race;
	}

	private String name;
	private Alignment alignment;
	private int experiencePoints = 0;
	private int armorClass = 10;
	private int hitPoints = 5;
	private Map<AbilityType, Ability> abilities;
	private Weapon weapon;
	private Race race;


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

	public int getExperiencePoints() {
		return experiencePoints;
	}	

	public boolean isDead() {
		return hitPoints <= 0;
	}
	
	public boolean attack(Character combatant, int attackRoll) {
		boolean hit = false;
		
		if (weapon != null) {
			attackRoll = attackRoll + weapon.getAttackModifier();
		}
		
		if (attackRoll >= combatant.getArmorClass()) {
			hit = true;
			experiencePoints+=10;
			
			combatant.setHitPoints(combatant.getHitPoints()-calculateDamage(attackRoll));
		}
		
		return hit;
	}
	
	private int calculateDamage(int attackRoll) {
		int damage = 1;
		
		if (attackRoll >= CRITICAL_HIT) {
			damage = damage * 2;
		}
		
		if (weapon != null) {
			damage = damage + weapon.getDamageModifier();
		}
		
		return damage;
	}
	

	public Weapon getWeapon() {
		return weapon;
	}

	public void setWeapon(Weapon weapon) {
		this.weapon = weapon;
	}
}
