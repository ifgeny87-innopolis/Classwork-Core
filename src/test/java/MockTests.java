import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

/**
 * Created by marina on 15.12.2016.
 */
public class MockTests {
	static Logger log = LoggerFactory.getLogger(MockTests.class);

	@Test
	public void test01() {
		log.info("Test test01 starts");

		// Just test methods works
		List mockedList = mock(List.class);
		mockedList.add("one");
		mockedList.add("two");

		// When-then
		when(mockedList.get(0)).thenReturn("first");
		when(mockedList.get(100)).thenReturn("101 dalmatian");

		// второго элемента как бы нет, но я ведь его добавил, хм...
		assertEquals("first", mockedList.get(0));
		assertNull(mockedList.get(1));  // not "two"
		assertEquals("101 dalmatian", mockedList.get(100));

		// Comparable test
		Comparable c = mock(Comparable.class);
		when(c.compareTo(any())).thenReturn(100, 200, 300);
		// на любое значение вернет 100, затем 200, затем каждый раз 300
		assertTrue(c.compareTo(true) == 100);

	}
}
