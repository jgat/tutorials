package week8.mediator;

import org.junit.Test;

public class TestTelephoneExchange {

	@Test
	public void testSendMessage() {
		Person a = new Person();
		Person b = new Person();

		a.enterVillage();
		b.enterVillage();

		a.sendMessage(b.getNumber(), "Hello from Person A");
		b.sendMessage(a.getNumber(), "Hello from Person B");
	}

}
