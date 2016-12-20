package ru.innolearn.day09.unittesting;

import org.junit.Before;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static org.junit.Assert.assertEquals;

/**
 * Created by marina on 15.12.2016.
 */
public class CalculatorTest {
	Logger logger = LoggerFactory.getLogger(CalculatorTest.class);

	private Calculator calc;

	@Before
	public void before() {
		calc = new Calculator();
	}

	@Test
	public void sumTest() {
		logger.info("Starts sumTest");
		int num = this.calc.sum(1, 3);
		assertEquals(num, 4);
	}

	@Test(expected = Exception.class)
	public void doSomeTest() throws Exception {
		logger.info("Starts doSomeTest");
		calc.doSome(5);

		/*final StreamWriter streamWriter = context.mock(StreamWriter.class);

		context.checking(new Expectations() {{
		oneOf(streamWriter.write("Tatarstan");
		will(returnValue(new Long(16)));
		}});*/
	}
}
