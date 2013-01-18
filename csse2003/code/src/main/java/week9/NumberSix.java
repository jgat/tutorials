package week9;

import week9.village.Village;

/**
 * John Drake, number 6. 
 */
public class NumberSix extends Person {
	
	boolean thinksIsInVillage = false;
	
	boolean thinksIsInSameTimeZone = true;
	
	@Override 
	public void enterVillage() {
		thinksIsInVillage = true;
		super.enterVillage();
	}
	
	@Override
	protected void allocateNumber() {
		this.number = 6;
	}
	
	@Override 
	public int getNumber(Person whosAsking) {
		// I am not a number, I am a free man!
		throw new UnsupportedOperationException();
	}
	
	/**
	 * Number Six has found the escape route
	 */
	public void escape() {
		Village.INSTANCE.getOccupants().remove(this);
		thinksIsInVillage = false;		
	}

	/**
	 * Ask Number Six why he resigned
	 * @return
	 */
	public Answer whyDidYouResign() {
		if (thinksIsInVillage) {
			return Answer.SILENCE;
		} else {
			return Answer.TRUTH;
		}
	}
	
	/**
	 * Make Drake think he's travelled from "somewhere in Eastern Europe" to London
	 */
	public void beShippedByBoat() {
		thinksIsInSameTimeZone = false;
	}
	
	/**
	 * If you think you're in a different timezone, but the chimes of the clock 
	 * tell the same time as your wristwatch, you are still in the Village!
	 */
	public void hearChimes() {
		if (Village.INSTANCE.contains(this) && !thinksIsInSameTimeZone) {
			thinksIsInVillage = true;
		}
	}
	
	/**
	 * Whether Number Six thinks he has escaped or not.
	 * @return
	 */
	public boolean hasEscaped() {
		return !thinksIsInVillage;
	}
}
