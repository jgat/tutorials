package week8;

public class LiarException extends RuntimeException {

	private int first;
	private int second;
	private Person person;
	
	@Override public String toString() {
		return String.format("Liar detected! Said he was %d and then that he was %d %s", first, second, person.toString());
	}
	
	public int getFirst() {
		return first;
	}

	public int getSecond() {
		return second;
	}

	public Person getPerson() {
		return person;
	}

	public LiarException(int first, int second, Person person) {
		this.first = first;
		this.second = second;
		this.person = person;
	}
	
}
