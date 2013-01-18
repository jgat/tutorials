package week11;

import java.util.*;

import week11.village.Village;

public class Warden extends Person {

	/**
	 * Oppress a villager 
	 */
	public void mistreat(Person victim, List<? extends Person> bystanders) {
		List<Person> allPresent = new ArrayList<Person>();
		allPresent.addAll(bystanders);
		allPresent.add(this);
		
		victim.mistreated(allPresent);
		for (Person p : bystanders) {
			p.observedMistreatment(victim);
		}		
	}
	
	public void mistreat(Warden victim, List<? extends Person> bystanders) {
		// Do nothing		
	}
	
	public Response escapeWithMe(Person p) {
		// Warden's always report the request
		return Village.INSTANCE.reportConspiracy(p);
	}	
}
