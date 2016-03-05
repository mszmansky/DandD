package org.agileandbeyond.dandd.tddexercise;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class CharacterArmorTest {
	
	private Character grog;

	@Before
	public void setup() {
		grog = new Character();
	}
	
	@Test
	public void shouldDonHelmetAndIncreaseArmorClassByOne() {
		int armorClassBefore = grog.getArmorClass();
		Armor helmet = createHelmet();
		grog.donArmor(helmet);
		
		assertEquals(1, Math.abs(armorClassBefore - grog.getArmorClass()));
	}
	
	@Test
	public void shouldDonHelmetAndBeAHelmetWearer() {
		grog.donArmor(createHelmet());
		
		assertTrue(grog.isWearingHelmet());
	}
	
	@Test
	public void shouldNotHaveAHelmetOutOfTheBox() {
		assertFalse(grog.isWearingHelmet());
	}
	
	@Test
	public void shouldDonChainMailAndBeALittleMoreProtected() {
		grog.donArmor(createChainMail());
		
		assertTrue(grog.isWearingMail());
	}
	
	@Test
	public void shouldNotHaveChainMailOutOfTheBox() {
		assertFalse(grog.isWearingMail());
	}
	
	@Test
	public void shouldDonGauntletsAndHaveSweetArmoredHands(){
		grog.donArmor(createGauntlets());
		
		assertTrue(grog.isWearingGauntlets());
	}
	
	@Test
	public void shouldNotHaveGauntletsOutOfTheBox(){
		assertFalse(grog.isWearingGauntlets());
	}
	
	@Test
	public void shouldDonBootsAndHaveProtectedTreads(){
		grog.donArmor(createBoots());
		
		assertTrue(grog.isWearingBoots());
	}
	
	@Test
	public void shouldNotHaveBootsOutOfTheBox(){
		assertFalse(grog.isWearingBoots());
	}
	
	@Test
	public void shouldUseShieldAndIncreaseArmorClassByFour() {
		int armorClassBefore = grog.getArmorClass();
		grog.useShield(createShield());
		
		assertEquals(4, Math.abs(armorClassBefore - grog.getArmorClass()));
	}
	
	@Test
	public void shouldUseShieldAndBlockDeadlyBlows() {
		grog.useShield(createShield());
		
		assertTrue(grog.isUsingShield());
	}
	
	@Test
	public void shouldNotHaveShieldOutOfTheBox(){
		assertFalse(grog.isUsingShield());
	}
	
	private Shield createShield(){
		Shield shield = new Shield();
		return shield;
	}
	
	private Armor createHelmet() {
		Helmet helmet = new Helmet();
		return helmet;
	}
	
	private Armor createChainMail() {
		MailArmor chainMail = new MailArmor();
		return chainMail;
	}
	
	private Armor createBoots() {
		Boots boots = new Boots();
		return boots;
	}
	
	private Armor createGauntlets() {
		Gauntlets gauntlets = new Gauntlets();
		return gauntlets;
	}
}
