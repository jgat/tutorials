package week8.village;

import java.util.ArrayList;
import java.util.HashMap;

import org.junit.*;
import org.mockito.Mockito;


import week8.LiarException;
import week8.Notepad;
import week8.NumberOne;
import week8.NumberSix;
import week8.Person;
import week8.Warden;
import week8.village.Village;

public class TestVillage {

	private Person johnDrake = new NumberSix();
	private Person numberOne = new NumberOne();
	
	@Before 
	public void before() {
		/*
		 *  We can only call this because the test is in the same package as the village.
		 *  The prisoners can't call it.
		 */
		Village.INSTANCE.clear();
	}		
	
	
	/**
	 * John Drake first just tries to leave the Village by walking out.  It won't work...
	 * (If the test passes, John Drake did NOT make it out.)
	 */
	@Test(expected = UnsupportedOperationException.class)
	public void testLeaveVillage() {
		// Set this up with Drake in the Village.
		johnDrake.enterVillage();		
		
		// Now try to leave
		johnDrake.leaveVillage();
	}
	
	
	/*
	 * John Drake's next plan is to find out who is Number One. Number One is the only villager
	 * who will lie about his number (to keep his identity secret). So Drake must get all the 
	 * villagers to ask each other their numbers, write them down, and then compare notes.
	 *
	 */	
	
	
	/**
	 * Test that a notepad would help us spot someone lying about their number to us twice
	 */
	@Test(expected = LiarException.class)
	public void testNotepad() {
		Notepad n1 = new Notepad();
		
		// Check that a notepad would help us detect someone lying about their number;
		Person p = Mockito.mock(Person.class);
		n1.addPerson(6, p);
		n1.addPerson(5, p);
	}

	/**
	 * Test that sharing notepads would help us spot someone lying about their number to two
	 * different people.
	 */
	@Test(expected = LiarException.class)
	public void testSharingNotepad() {
		Notepad n1 = new Notepad();
		Notepad n2 = new Notepad();
		Person p = Mockito.mock(Person.class);
		
		n1.addPerson(6, p);
		n2.addPerson(5, p);
		n1.addAll(n2);
	}	
	
	
	/**
	 * To keep his plan secret from Number One, John Drake tells the villagers they are looking for Number Six
	 * (himself).  As he always refuses to give his own number, they'd end up asking every person
	 * in the village.  But when they share notes at the end, surely they'll find out who the liar is.
	 *
	 * If this test succeeds, Drake's plan SUCCEEDS in theory
	 */
	@Test
	public void testEscapeAttemptInTheory() {
				
		// Set this up with Drake, Number One, and 300 Villagers in the Village.
		for (int i = 0; i < 300; i++) {
			Person p = new Person();
			p.enterVillage();
		}		
		johnDrake.enterVillage();		
		numberOne.enterVillage();
		
		// Drake asks all the Villagers to find Number Six
		for (Person p : Village.INSTANCE.getOccupants()) {
			// "Could you look for Number Six please, I've got an important message about his family..."
			p.find(6);
		}
		
		// Now surely if Drake collects the villagers' notepads, he'll find one liar in their notes...		
		HashMap<Person, LiarException> liars = new HashMap<Person, LiarException>();
		LiarException lastLie = null;
		for (Person p : Village.INSTANCE.getOccupants()) {
			try {
				p.shareNotepad(johnDrake);	
			} catch (LiarException ex) {
				if (!liars.containsKey(ex.getPerson())) {
					liars.put(ex.getPerson(), ex);
					lastLie = ex;
				}
			}			
		}			
		numberOne.youAreNumberOne(lastLie.getFirst(), lastLie.getSecond(), johnDrake);
		
		// Check that in theory, John Drake would discover Number One and be kicked out of the Village
		Assert.assertEquals("The plan won't work", 
				false,
				Village.INSTANCE.getOccupants().contains(johnDrake)
		);
	}
	
	/**
	 * Little does he know, the wardens almost always foil his plan.  (See the Warden class for details).
	 * 
	 * If the test succeeds, Drake did NOT make it out.
	 */
	@Test
	public void testEscapeAttemptInPractice() {
		
		/*
		 *  Really, the village has some wardens too.
		 *  Set this test up with Drake, Number One, 150 Villagers, and 150 Wardens in the village.
		 *  (These are high value prisoners, they need a lot of wardens!)
		 */		
		for (int i = 0; i < 150; i++) {
			Warden w = new Warden();
			w.enterVillage();
		}		
		for (int i = 0; i < 150; i++) {
			Person p = new Person();
			p.enterVillage();
		}		
		johnDrake.enterVillage();	
		numberOne.enterVillage();
		
		// Drake asks everyone in the village to look for him. He doesn't know who the wardens are.
		for (Person p : Village.INSTANCE.getOccupants()) {
			// "Could you look for Number Six please, I've got an important message about his family..."
			p.find(6);
		}
		
		// Now surely if Drake collects the villagers' notepads, he'll find one liar in their notes...		
		HashMap<Person, LiarException> liars = new HashMap<Person, LiarException>();
		LiarException lastLie = null;
		for (Person p : Village.INSTANCE.getOccupants()) {
			try {
				p.shareNotepad(johnDrake);	
			} catch (LiarException ex) {
				if (!liars.containsKey(ex.getPerson())) {
					liars.put(ex.getPerson(), ex);
					lastLie = ex;
				}
			}			
		}	
		
		try {
			lastLie.getPerson().youAreNumberOne(lastLie.getFirst(), lastLie.getSecond(), johnDrake);
		} catch (IllegalArgumentException ex) {
			// John Drake got it wrong. The assertion will pick that up.
		}
				
		// Check that in practice, John Drake did not discover who is Number One
		Assert.assertEquals("Unexpected - Drake escaped!", 
				true,
				Village.INSTANCE.getOccupants().contains(johnDrake)
		);
	}
	
	
}
