package week11;

import week11.village.Village;

import java.util.List;
import java.util.ArrayList;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Person {
	
	private Logger logger = LoggerFactory.getLogger(this.getClass());
	
	/**
	 * The next number to allocate to a villager.
	 */
	private static int nextNumber = 7;
	
	
	/**
	 * Your number is your name
	 */
	protected int number;

	/**
	 * The people this person trusts
	 */
	protected List<Person> trusted = new ArrayList<Person>();

	/**
	 * The people this person thinks must be a Warden
	 */
	protected List<Person> thinksIsWarden = new ArrayList<Person>();
	
	
	/**
	 * Gives this villager a number as they enter the village
	 */
	protected void allocateNumber() {
		this.number = nextNumber;
		nextNumber++;
	}
	
	/**
	 * Welcome to the village.
	 * @param village
	 */
	public void enterVillage() {
		allocateNumber();
		Village.INSTANCE.enter(this);
	}

	/**
	 * A warden is mistreating you, beating you up, etc.
	 */
	public void mistreated(List<? extends Person> present) {
		logger.warn("Help, help, I'm being oppressed!");
		
		// If they didn't do anything to stop it, they must be a Warden!
		for (Person p : present) {
			thinksIsWarden.add(p);
		}
	}
	
	/**
	 * Witness a villager being oppressed
	 * @param p
	 */
	public void observedMistreatment(Person p) {
		trusted.add(p);
	}
	
	/**
	 * Whether or not this person trusts someone
	 * @param p
	 * @return
	 */
	public Boolean trusts(Person p) {
		return trusted.contains(p);
	}

	/**
	 * Whether or not this person trusts someone
	 * @param p
	 * @return
	 */
	public Boolean thinksIsWarden(Person p) {
		return thinksIsWarden.contains(p);
	}
	
	
	/**
	 * A villager asks your help to escape
	 * @param p
	 */
	public Response escapeWithMe(Person p) {
		if (trusted.contains(p)) {
			// I trust this person; I'll try to escape with them.
			return new Escape();
		} else if (thinksIsWarden.contains(p)) { 
			/*
			 *  I think this is a Warden testing me -- I'll get in trouble 
			 *  if I don't report the escape attempt 
			 */
			return Village.INSTANCE.reportConspiracy(p);		
		} else {
			// I don't know anything about this person. Just keep quiet.
			return new KeepQuiet();
		}
	}
	

}
