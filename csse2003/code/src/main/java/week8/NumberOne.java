package week8;

import java.util.ArrayList;
import java.util.Random;
import java.util.Set;

import week8.village.Village;

/**
 * Number One is the secretive villain behind it all...
 */
public class NumberOne extends Person {
		
	/**
	 * Number One hides by pretending to be an ordinary villager.
	 */
	private int pretendingToBe;
	
	/**
	 * All the numbers Number One has pretended to be
	 */
	private ArrayList<Integer> pastIdentities = new ArrayList<Integer>();
	
	/**
	 * Used for choosing a new identity
	 */
	private Random random = new Random();
		
	@Override
	protected void allocateNumber() {
		this.number = 1;
	}
	
	@Override
	public void enterVillage() {
		changeIdentity();
		super.enterVillage();
	}
	
	/**
	 * Change which number Number One pretends to be
	 */
	private void changeIdentity() {		
		int newIdentity = pretendingToBe;
		while(newIdentity == pretendingToBe) {
			// Pretend to be a random villager
			newIdentity = 1 + random.nextInt(Village.INSTANCE.getOccupants().size() - 2);
		}
		pretendingToBe = newIdentity;
		pastIdentities.add(pretendingToBe);
		System.out.printf("(Number One has changed identity and is now pretending to be number %d)%n", pretendingToBe);
	}
	
	@Override public int getNumber(Person whosAsking) {		
		// Change identity randomly, or if we're talking to the person who really has that number
		if (pretendingToBe == whosAsking.getNumber(this) || random.nextDouble() < 0.05d) {			
			changeIdentity();
		}
		return pretendingToBe;
	}
	
	/**
	 * If they haven't caught you in a lie, play innocent...
	 */
	@Override public void youAreNumberOne(int first, int second, Person p) {
		String msg = "";
		if (first == second) {
			// The fool, they have no idea...
			msg = "You just said the same number twice! ";
			throw new IllegalArgumentException(msg + "Are you mad, accusing an innocent villager like this? Medics, take this villager to the clinic!");
		} else if (!pastIdentities.contains(first)) {
			// The fool, they have no idea...
			msg = String.format("I never said I was %d! ", first);
			throw new IllegalArgumentException(msg + "Are you mad, accusing an innocent villager like this? Medics, take this villager to the clinic!");
		} else if (!pastIdentities.contains(second)) {
			// The fool, they have no idea...
			msg = String.format("I never said I was %d! ", second);
			throw new IllegalArgumentException(msg + "Are you mad, accusing an innocent villager like this? Medics, take this villager to the clinic!");
		} else {
			// They've caught me! Get rid of them before they tell someone else!
			getHimOutOfHere(p);			
		}
	}
	
	/**
	 * When Number One needs to get someone out of the Village pronto, he knows how to smuggle them out.
	 */
	private void getHimOutOfHere(Person p) {
		// At least I know how to get rid of them.
		Set<Person> occupants = Village.INSTANCE.getOccupants();
		occupants.remove(p);
		System.out.println("You have been kicked out of the village for discovering my identity!");
	}
	
	
}
