package week8;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

/**
 * Used for writing down identities.
 */
public class Notepad {
	
	private HashMap<Integer, Person> forwardMap = new HashMap<Integer, Person>();

	private HashMap<Person, Integer> reverseMap = new HashMap<Person, Integer>();
	
	/**
	 * Adds a person into the notebook. If the person was already in there, check they still claim to have the same number
	 * @param number
	 * @param p
	 * @return
	 */
	public void addPerson(int number, Person p) {
		forwardMap.put(number, p);
		Integer i = reverseMap.put(p, number);
		if (i != null && i != number) {
			throw new LiarException(i, number, p);
		}
	}
	
	public HashMap<Integer, Person> getForwardMap() {
		return forwardMap;
	}
	
	public Map<Person, Integer> getReverseMap() {
		return this.reverseMap;
	}
	

	public void addAll(Notepad other) {
		if (other != null) {
			for (Entry<Integer, Person> e : other.getForwardMap().entrySet()) {
				this.addPerson(e.getKey(), e.getValue());
			}
		}
	}
	
	public void clear() {
		forwardMap.clear();
		reverseMap.clear();
	}
	
}
