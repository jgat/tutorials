package week8;

/**
 * John Drake, number 6. 
 */
public class NumberSix extends Person {
	
	@Override
	protected void allocateNumber() {
		this.number = 6;
	}
	
	@Override 
	public int getNumber(Person whosAsking) {
		// I am not a number, I am a free man!
		throw new UnsupportedOperationException();
	}

}
