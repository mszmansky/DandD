package org.agileandbeyond.dandd.tddexercise.character;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;

import org.agileandbeyond.dandd.tddexercise.equipment.armor.Armor;
import org.agileandbeyond.dandd.tddexercise.equipment.armor.Boots;
import org.agileandbeyond.dandd.tddexercise.equipment.armor.Gauntlets;
import org.agileandbeyond.dandd.tddexercise.equipment.armor.Helmet;
import org.agileandbeyond.dandd.tddexercise.equipment.armor.MailArmor;
import org.agileandbeyond.dandd.tddexercise.equipment.armor.Ring;
import org.agileandbeyond.dandd.tddexercise.equipment.armor.Shield;
import org.agileandbeyond.dandd.tddexercise.equipment.weaponry.BroadSword;
import org.agileandbeyond.dandd.tddexercise.equipment.weaponry.Dagger;
import org.agileandbeyond.dandd.tddexercise.equipment.weaponry.Weapon;
import org.agileandbeyond.dandd.tddexercise.exception.CannotUseArmorException;
import org.agileandbeyond.dandd.tddexercise.exception.CannotUseShieldException;
import org.agileandbeyond.dandd.tddexercise.exception.CannotUseWeaponException;
import org.junit.Before;
import org.junit.Test;

public class CharacterArmorTest {
	
	private Character grog;

	@Before
	public void setup() {
		grog = new Character();
	}
	
	@Test
	public void shouldDonHelmetAndIncreaseArmorClassByOne() throws CannotUseArmorException {
		int armorClassBefore = grog.getArmorClass();
		Armor helmet = createHelmet();
		grog.donArmor(helmet);
		
		assertEquals(1, Math.abs(armorClassBefore - grog.getArmorClass()));
	}
	
	@Test
	public void shouldDonHelmetAndBeAHelmetWearer() throws CannotUseArmorException {
		grog.donArmor(createHelmet());
		
		assertTrue(grog.isWearingHelmet());
	}
	
	@Test
	public void shouldNotHaveAHelmetOutOfTheBox() {
		assertFalse(grog.isWearingHelmet());
	}
	
	@Test
	public void shouldDonChainMailAndBeALittleMoreProtected() throws CannotUseArmorException {
		grog.donArmor(createChainMail());
		
		assertTrue(grog.isWearingMail());
	}
	
	@Test
	public void shouldNotHaveChainMailOutOfTheBox() {
		assertFalse(grog.isWearingMail());
	}
	
	@Test
	public void shouldDonGauntletsAndHaveSweetArmoredHands() throws CannotUseArmorException{
		grog.donArmor(createGauntlets());
		
		assertTrue(grog.isWearingGauntlets());
	}
	
	@Test
	public void shouldNotHaveGauntletsOutOfTheBox(){
		assertFalse(grog.isWearingGauntlets());
	}
	
	@Test
	public void shouldDonBootsAndHaveProtectedTreads() throws CannotUseArmorException{
		grog.donArmor(createBoots());
		
		assertTrue(grog.isWearingBoots());
	}
	
	@Test
	public void shouldNotHaveBootsOutOfTheBox(){
		assertFalse(grog.isWearingBoots());
	}
	
	@Test
	public void shouldUseShieldAndIncreaseArmorClassByFour() throws Exception {
		int armorClassBefore = grog.getArmorClass();
		grog.useShield(createShield());
		
		assertEquals(4, Math.abs(armorClassBefore - grog.getArmorClass()));
	}
	
	@Test
	public void shouldUseShieldAndBlockDeadlyBlows() throws Exception {
		grog.useShield(createShield());
		
		assertTrue(grog.isUsingShield());
	}
	
	@Test
	public void shouldNotHaveShieldOutOfTheBox(){
		assertFalse(grog.isUsingShield());
	}
	
	@Test(expected = CannotUseShieldException.class)
	public void shouldNotBeAbleToUseShieldWhenWieldingTwoHandedBroadSword() throws Exception{
		grog.setLevel(2);
		grog.wieldWeapon(createBroadSword());
		grog.useShield(createShield());
	}
	
	@Test(expected = CannotUseWeaponException.class)
	public void shouldNotBeAbleToWieldTwoHandedBroadSwordWhenUsingShield() throws Exception {
		grog.useShield(createShield());
		grog.wieldWeapon(createBroadSword());
	}
	
	@Test
	public void shouldBeAbleToWieldDaggerWhenUsingShield() throws Exception {
		grog.useShield(createShield());
		Weapon dagger = new Dagger();
		grog.wieldWeapon(dagger);
		
		assertSame(dagger, grog.getWeapon());
	}
	
	@Test
	public void shouldNotHaveARingOutOfTheBox() {
		assertFalse(grog.isWearingARing());
	}
	
	@Test
	public void shouldWearARingToIncreaseMyAbilities() throws CannotUseArmorException {
		grog.donArmor(new Ring());
		
		assertTrue(grog.isWearingARing());
	}
	
	@Test
	public void shouldWearTwoRingsToMakeMeReallyBadAss() throws CannotUseArmorException {
		grog.donArmor(new Ring());
		grog.donArmor(new Ring());
		
		assertTrue(grog.isWearingARing());
	}
	
	@Test(expected=CannotUseArmorException.class)
	public void shouldThrowCannotUseArmorExceptionWhenTryingToWearThreeRings() throws CannotUseArmorException {
		grog.donArmor(new Ring());
		grog.donArmor(new Ring());
		grog.donArmor(new Ring());
	}
	
	
	
	
	private Weapon createBroadSword(){
		Weapon broadSword = new BroadSword();
		return broadSword;
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
