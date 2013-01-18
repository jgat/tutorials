package week8.mediator;

import java.util.HashMap;
import java.util.Map;

public class TelephoneExchange {

	private Map<Integer, Person> phonebook = new HashMap<Integer, Person>();
	
	public void addPerson(int id, Person p) {
		phonebook.put(id, p);
	}
	
	public void sendMessage(int recipient, String message) {
		phonebook.get(recipient).receiveMessage(message);
	}
}
