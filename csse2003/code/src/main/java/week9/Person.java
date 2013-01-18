package week9;

import week9.village.Village;

public class Person {
	
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
		System.out.println("Message received!");
	}
	
	
	/**
	 * Another villager (whosAsking) asks what this villager's number is
	 * @return this villager's number (or so we claim...)
	 */
	public int getNumber(Person whosAsking) {
		return number;
	}
	

}
