package org.agileandbeyond.dandd.tddexercise;

import java.util.HashMap;
import java.util.Map;

public class Ability {
	
	private static final int MAX_SCORE = 20;
	private static final int MIN_SCORE = 1;
	
	private int score = 10;
	private Map<Integer, Integer> modifierMap = new HashMap<Integer, Integer>();
	private AbilityType type;

	
	public Ability() {
		initiateModifiers();
	}
	
	public Ability(AbilityType type) {
		initiateModifiers();
		this.type = type;
	}
	
	public Ability(int score) {
		initiateModifiers();
		this.score = score;
	}
	
	public int getScore() {
		return score;
	}

	public void setScore(int score) {
		if (score > MAX_SCORE) {
			score = 20;
		}
		
		if (score < MIN_SCORE) {
			score = 1;
		}
		this.score = score;
	}

	public int getModifier() {
		return modifierMap.get(score);
	}
	
	private void initiateModifiers(){
		modifierMap.put( 1, -5);
		modifierMap.put( 2, -4);
		modifierMap.put( 3, -4);
		modifierMap.put( 4, -3);
		modifierMap.put( 5, -3);
		modifierMap.put( 6, -2);
		modifierMap.put( 7, -2);
		modifierMap.put( 8, -1);
		modifierMap.put( 9, -1);
		modifierMap.put(10, 0);
		modifierMap.put(11, 0);
		modifierMap.put(12, 1);
		modifierMap.put(13, 1);
		modifierMap.put(14, 2);
		modifierMap.put(15, 2);
		modifierMap.put(16, 3);
		modifierMap.put(17, 3);
		modifierMap.put(18, 4);
		modifierMap.put(19, 4);
		modifierMap.put(20, 5);
	}

	public void setType(AbilityType type) {
		this.type = type;
	}

	public AbilityType getType() {
		return type;
	}

}
