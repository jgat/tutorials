package week11.village;


import java.util.HashSet;
import java.util.Set;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import week11.*;


/**
 * The Village. 
 * 
 * You might be wondering why this is an enum... This is one way of
 * implementing a Singleton pattern (particularly, this is the 
 * unusual way that Joshua Bloch recommends in Effective Java).
 *
 */
public enum Village {
	
	/**
	 * The only instance of the Village class
	 */
	INSTANCE;
	
	private Logger logger = LoggerFactory.getLogger(this.getClass());
	
	/**
	 * Villagers
	 */
	private Set<Person> occupants = new HashSet<Person>();
	
	/**
	 * Adds someone to the Village
	 */
	public void enter(Person p) {
		occupants.add(p);
	}
		
	/**
	 * So you think you're leaving do you...
	 */
	public void leave(Person p) {
		throw new UnsupportedOperationException("Be seeing you.");
	}
	
	/**
	 * Gets the set of occupants
	 */
	public Set<Person> getOccupants() {
		// There is no longer an escape route hidden in this code...
		return new HashSet<Person>(this.occupants);
	}
	
	/**
	 * For calling at the beginning of tests
	 */
	void clear() {
		occupants.clear();
	}
	
	/**
	 * 
	 * @param p
	 */
	public Response reportConspiracy(Person p) {
		logger.warn("Villager {} has been reported!", p);
		
		// Ask the Villager to entrap the conspiring person
		return new StagedEscape(p);
	}
	
	/**
	 * This is the village's thinking on what person "asked" would do if
	 * person "asking" asked them to escape together.
	 * @param asked 
	 * @param asking
	 * @return
	 */
	public Response couldConspire(Person asked, Person asking) {
		
		Response result = null;
		
		if (asked.trusts(asking)) {
			result = new Escape();
		}
		
		if (asked.thinksIsWarden(asking)) {
			result = new StagedEscape(asking);
		}
		
		if (result == null) {
			result = new KeepQuiet();
		}
		return result;
	}
	
	
	/**
	 * Checks if someone is in The Village
	 * @param p
	 * @return
	 */
	public boolean contains(Person p) {
		return occupants.contains(p);
	}

}
