package week11.village;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;
import static org.junit.Assert.*;

import week11.*;

/**
 * The following tests are for the Village.testConspire method. You're going to 
 * consider the code coverage in terms of statement coverage, branch coverage,
 * and path coverage. 
 */
public class TestCoverage {

	Person asked;
	Person asking;

	
	@Before public void before() {
		Village.INSTANCE.clear();
		asked = Mockito.mock(Person.class);
		asking = Mockito.mock(Person.class);
	}
	
		
	@Test public void testCase1() {
		Mockito.when(asked.trusts(asking)).thenReturn(true);
		Mockito.when(asked.thinksIsWarden(asking)).thenReturn(false);
		assertSame(
			"Didn't think a villager would escape with someone they trusted",
			Escape.class,
			Village.INSTANCE.couldConspire(asked, asking).getClass()
		);
	}
	
	@Test public void testCase2() {
		Mockito.when(asked.trusts(asking)).thenReturn(false);
		Mockito.when(asked.thinksIsWarden(asking)).thenReturn(true);
		assertSame(
			"Didn't think a villager would report someone they thought was a warden",
			StagedEscape.class,
			Village.INSTANCE.couldConspire(asked, asking).getClass()
		);
	}
}
