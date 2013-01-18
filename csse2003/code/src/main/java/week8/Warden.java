package week8;

import java.util.Random;

/**
 * The secret prison warders. They don't know who else is a warder; they just know that they are one.
 *
 */
public class Warden extends Person {
	
	private Random random = new Random();	
	
	@Override public String toString() {
		return "Warden " + getNumber(this);
	}
	
	/**
	 * Wardens don't like the idea of everyone writing down everyone else's number. What if 
	 * they found out Number One's identity that way! So they pretend that *other* prisoners
	 * lied about their numbers too...
	 */
	@Override protected void notePerson(int n, Person p) {
		if (random.nextDouble() < 0.05d) {
			super.notePerson(2 + random.nextInt(300), p);
			System.out.println("(A warden was unreliable)");
		} else {
			super.notePerson(n, p);
		}
	}

}
