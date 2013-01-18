package week11.village;

import java.util.Arrays;

import week11.*;
import org.junit.*;
import static org.junit.Assert.*;

public class TestCheckmate {

	NumberSix numberSix;
	Warden warden;
	Person number232;
		
	@Before public void before() {
		Village.INSTANCE.clear();
		numberSix = new NumberSix();
		number232 = new Person();
		warden = new Warden();
		
		numberSix.enterVillage();
		number232.enterVillage();
		warden.enterVillage();
	}
	
	/*
	 * Checkmate.
	 * 
	 * Number Six thinks he knows how to tell the wardens from the prisoners: watch their behaviour.
	 * So, he starts watching some of the villagers.
	 * 
	 * At a game of human chess, he witnesses one of the 'pieces' being mistreated (subjected to 
	 * mind control experiments) by a warden 
	 */	
	
	/**
	 * Test that being tortured earns Number Six's trust.
	 */
	@Test public void testTrust() { 
		
		warden.mistreat(number232, Arrays.asList(numberSix));
		
		// Number Six should now trust Number 232
		assertTrue("Six didn't trust the oppressed prisoner", numberSix.trusts(number232));
		
		// Number Six would now be happy to escape with Number 232 if 232 suggested it.
		assertSame("Six wouldn't escape with the oppressed prisoner",
				Escape.class,
				numberSix.escapeWithMe(number232).getClass()
				);		
	}
	
	/*
	 * Having witnessed the villager being oppressed, Number Six tries to arrange an escape
	 * attempt.  It's all looking good until the last moment, when Number Two steps out of 
	 * the shadows to return Number Six to the village.
	 * 
	 * You're going to draw the sequence diagram to find out what went wrong. 
	 * (The log warnings on the output will give you an early hint)
	 */
	@Test public void testCheckmate() {
		warden.mistreat(number232, Arrays.asList(numberSix));
		
		// Number Six should now trust Number 232
		assertNotSame(
				"Six got out",
				Escape.class,
				number232.escapeWithMe(numberSix)
		);
	}
	

	
}
