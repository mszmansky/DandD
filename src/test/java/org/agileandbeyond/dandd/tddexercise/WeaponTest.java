package org.agileandbeyond.dandd.tddexercise;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

public class WeaponTest {
	
	private Weapon weapon;
	
	@Before
	public void setup() {
		
	}

	@Test
	public void shouldCreateAWeaponWithAName() {
		weapon = createDagger();
		
		assertEquals("Dagger", weapon.getName());
	}
	
	@Test
	public void shouldSetTheAttackModifier() {
		weapon = createDagger();
		
		assertEquals(1, weapon.getAttackModifier());
	}
	
	@Test
	public void shouldSetTheDamageModifier() {
		weapon = createDagger();
		
		assertEquals(1, weapon.getDamageModifier());
	}
	
	@Test
	public void shouldHitArmorClassOfTwoWhenUsingDagger() {
		
		Character blorhoff = new Character();
		blorhoff.setWeapon(createDagger());
		Character monster = new Character();
		monster.setArmorClass(2);
		
		assertTrue(blorhoff.attack(monster, 1));
		
	}
	
	@Test
	public void shouldNotHitArmorClassOfThreeWhenUsingDagger() {
		Character blorhoff = new Character();
		blorhoff.setWeapon(createDagger());
		Character monster = new Character();
		monster.setArmorClass(3);
		
		assertFalse(blorhoff.attack(monster, 1));
		
	}
	
	@Test
	public void shouldIncreaseDamageByOneWhenUsingDagger() {
		Character blorhoff = new Character();
		blorhoff.setWeapon(createDagger());
		Character monster = new Character();
		monster.setArmorClass(2);
		
		blorhoff.attack(monster, 1);
		
		assertEquals(3, monster.getHitPoints());
	}
	
	@Test
	public void shouldIncreaseDamageByTwoWhenUsingDaggerAndCriticalHit() {
		Character blorhoff = new Character();
		blorhoff.setWeapon(createDagger());
		Character monster = new Character();
		monster.setArmorClass(2);
		
		blorhoff.attack(monster, Character.CRITICAL_HIT);
		
		assertEquals(2, monster.getHitPoints());
	}
	
	@Test
	public void shouldHoldADaggerWithOneHand() {
		Weapon dagger = createDagger();
		assertFalse(dagger.isTwoHanded());
	}
	
	@Test
	public void shouldHoldALongSwordWithTwoHands() {
		Weapon sword = createLongSword();
		assertTrue(sword.isTwoHanded());
	}
	
	
	private Weapon createLongSword() {
		Weapon weapon = new Weapon();
		
		weapon.setName("Long Sword");
		weapon.setAttackModifier(5);
		weapon.setDamageModifier(5);
		weapon.setTwoHanded(true);
		
		return weapon;
	}
	
	private Weapon createDagger() {
		Weapon weapon = new Weapon();
		
		weapon.setName("Dagger");
		weapon.setAttackModifier(1);
		weapon.setDamageModifier(1);
		weapon.setTwoHanded(false);
		
		return weapon;
	}
}
