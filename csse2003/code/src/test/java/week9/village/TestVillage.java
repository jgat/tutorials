package week9.village;

import static org.junit.Assert.*;

import org.junit.*;
import week9.Answer;
import week9.NumberSix;
import week9.village.Village;

public class TestVillage {

	private NumberSix johnDrake = new NumberSix();
	
	@Before 
	public void before() {
		/*
		 *  We can only call this because the test is in the same package as the village.
		 *  The prisoners can't call it.
		 */
		Village.INSTANCE.clear();
	}		
	
	
	
	/*
	 * Number Six wants to escape. The Village wants him to answer the question
	 * "Why did you resign?"
	 */
	

	/**
	 * Checks that if NumberSix was not in the village, he would
	 * answer truthfully
	 */
	@Test
	public void testAnswersIfNotInVillage() {		
		assertEquals(
			"John Drake lies even when not in the Village",
			Answer.TRUTH, 
			johnDrake.whyDidYouResign()
		);		
	}

	/**
	 * Checks that NumberSix will not answer in the Village
	 */
	@Test
	public void testDoesntAnswerInVillage() {		
		johnDrake.enterVillage();		
		assertEquals(
			"John Drake answered in the Village",
			Answer.SILENCE, 
			johnDrake.whyDidYouResign()
		);		
	}

	/*
	 * Number Six and and Number Eight come up with a way of escaping that 
	 * involves an art competition, a sculpture, and a massive painting of Number Two...
	 * 
	 * Number Eight tells Six that the Village is somewhere in Eastern Europe, but if
	 * they can escape, her contacts can smuggle them back to the UK.
	 */
	
	/**
	 * Number Six puts his plan into action...
	 */
	@Test
	public void testEscape() {
		// Set this up with Drake in the Village.
		johnDrake.enterVillage();		
		
		// Use the escape route
		johnDrake.escape();

		assertTrue(
			"John Drake doesn't think he escaped",
			johnDrake.hasEscaped()
		);
	}
	

	/**
	 * They put their plan into action, escape, and then hide in a wooden container
	 * while they are smuggled by boat from Eastern Europe back to London...
	 */	
	@Test
	public void testAskedInLondon() {
		// Set this up with Drake in the Village.
		johnDrake.enterVillage();		
		
		// Use the escape route
		johnDrake.escape();
 
		/*
		 * Hide in the container and get shipped to the UK
		 */
		johnDrake.beShippedByBoat();		
		
		/*
		 * Drake is unpacked from the box in the London office of the British
		 * secret service. He tells his old mentor all about the Village, and then
		 * the mentor asks him out of curiosity why he resigns... 
		 * 
		 * only before he can answer Big Ben strikes the hour... 
		 */	
		johnDrake.hearChimes();
		
		/*
		 * ... and Number Six stops answering ...
		 */
		assertEquals(
			Answer.SILENCE,
			johnDrake.whyDidYouResign()				
		);
		
		/* 
		 * ... and he opens the door of the "office" and walks back out 
		 * into the Village ... 
		 * 
		 * Have a look at the contents of:
		 * johnDrake.escape
		 * johnDrake.beShippedByBoat
		 * johnDrake.hearChimes
		 * to find out how he knew he hadn't escaped after all
		 * 
		 * And then look at 
		 * Village.getOccupants()
		 * to see why his escape only appeared to succeed.
		 */
	}
	
	
}
