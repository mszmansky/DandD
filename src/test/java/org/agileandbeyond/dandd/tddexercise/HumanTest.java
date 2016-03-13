package org.agileandbeyond.dandd.tddexercise;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.agileandbeyond.dandd.tddexercise.races.Human;
import org.junit.Before;
import org.junit.Test;

public class HumanTest {
	private Human human;
	
	@Before
	public void before() {
		human = new Human();
	}
	
	@Test
	public void shouldReturnZeroOnGetCharismaModifier() {
		assertEquals(0,human.getCharismaModifier());
	}
	
	@Test
	public void shouldNotReturn1OnGetStrengthModifier() {
		assertTrue(human.getStrengthModifier() != 1);
	}
}
