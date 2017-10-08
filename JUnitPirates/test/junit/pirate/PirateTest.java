package junit.pirate;
import static org.junit.Assert.*;

import org.junit.Test;

import org.junit.Test;
import static org.junit.Assert.*;

public class PirateTest {
	public PirateTest() {
	}

	@Test
	public void testCreatePirate() {
		Pirate p = new Pirate("Davy Jones");
		assertEquals("Davy Jones", p.getName());
		assertEquals(4, p.getLimbsRemaining());
	}

	@Test
	public void testCreateOctopirate() {
		Pirate p = new Pirate("Octopus Pete", 8);
		assertEquals("Octopus Pete", p.getName());
		assertEquals(8, p.getLimbsRemaining());
	}

	@Test(expected = NullPointerException.class)
	public void testNullPirate() {
		Pirate p = null;
		p.loseALimb();
	}

	@Test
	public void testSetName() {
		Pirate p = new Pirate("Long John Silver");
		assertEquals("Long John Silver", p.getName());
		p.setName("Short John Gold");
		assertEquals("Short John Gold", p.getName());
	}

	@Test
	public void testLoseLimb() {
		Pirate p = new Pirate("Stubby Jones");
		assertEquals(4, p.getLimbsRemaining());
		p.loseALimb();
		assertEquals(3, p.getLimbsRemaining());
	}
	
	@Test
	public void testIsDead() {
		Pirate p = new Pirate("Unlucky Fred");
		assertFalse(p.isDead());
		p.loseALimb(); // Limb #1
		assertFalse(p.isDead());
		p.loseALimb(); // Limb #2
		assertFalse(p.isDead());
		p.loseALimb(); // Limb #3
		assertFalse(p.isDead());
		p.loseALimb(); // Limb #4 - uh oh
		assertTrue(p.isDead());
	}

	@Test
	public void testNumPirates()
	{
		int count = Pirate.getNumPirates();
		Pirate p1 = new Pirate("Ship's Mate #1");
		Pirate p2 = new Pirate("Ship's Mate #2");
		assertEquals(count + 2, Pirate.getNumPirates());
		}

	@Test
	public void testTotalLimbsLost() {
		int count = Pirate.getTotalLimbsLost();
		Pirate p1 = new Pirate("Stubby #1");
		Pirate p2 = new Pirate("Stubby #2");
		p1.loseALimb();
		p2.loseALimb();
		p2.loseALimb();
		assertEquals(count + 3, Pirate.getTotalLimbsLost());
	}
}