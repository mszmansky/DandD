package org.agileandbeyond.dandd.tddexercise;

import static org.junit.Assert.*;
import org.junit.Test;

public class CharacterArmorTest {

	@Test
	public void shouldDonHelmetAndIncreaseArmorClassByOne() {
		Character grog = new Character();
		int armorClassBefore = grog.getArmorClass();
		Armor helmet = createHelmet();
		grog.donArmor(helmet);
		
		assertEquals(1, Math.abs(armorClassBefore - grog.getArmorClass()));
	}
	
	@Test
	public void shouldDonHelmetAndBeAHelmetWearer() {
		Character grog = new Character();
		Armor helmet = createHelmet();
		grog.donArmor(helmet);
		
		assertTrue(grog.isWearingHelmet());
	}
	
	@Test
	public void shouldNotHaveAHelmetOutOfTheBox() {
		Character grog = new Character();
		
		assertFalse(grog.isWearingHelmet());
	}
	
	@Test
	public void shouldDonChainMailAndHaveChainMail() {
		Character grog = new Character();
		Armor chainMail = createChainMail();
		grog.donArmor(chainMail);
		
		assertTrue(grog.isWearingMail());
	}
	
	private Armor createHelmet() {
		Helmet helmet = new Helmet();
		return helmet;
	}
	
	private Armor createChainMail() {
		MailArmor chainMail = new MailArmor();
		return chainMail;
	}
}
