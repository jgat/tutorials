package week9.village;

import java.util.HashSet;
import java.util.Set;

import week9.Person;

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
	 * Checks if someone is in The Village
	 * @param p
	 * @return
	 */
	public boolean contains(Person p) {
		return occupants.contains(p);
	}

}
