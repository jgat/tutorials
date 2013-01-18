package week8.mediator;

public class Person {

	/**
	 * The telephone exchange to contact other villagers.
	 */
	private static TelephoneExchange telephoneExchange = new TelephoneExchange();
	
	/**
	 * The next number to allocate to a villager.
	 */
	private static int nextNumber = 7;
	
	/**
	 * Your number is your name
	 */
	protected int number;
		
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
		telephoneExchange.addPerson(number, this);
	}
	
	/**
	 * Sorry to see you go.
	 * @param village
	 */
	public void leaveVillage() {
		Village.INSTANCE.leave(this);
	}	
	
	/**
	 * Receive important news about your family...
	 * @param message
	 */
	public void receiveMessage(String message) {
		System.out.println("Number " + number + " received a message: " + message);
	}
	
	/**
	 * Send a message to someone else.
	 * @param recipient who to send the message to.
	 * @param message what to send.
	 */
	public void sendMessage(int recipient, String message) {
		telephoneExchange.sendMessage(recipient, message);
	}
	
	public int getNumber() {
		return number;
	}
}
