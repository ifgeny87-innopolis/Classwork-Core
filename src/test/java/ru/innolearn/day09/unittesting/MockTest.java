package ru.innolearn.day09.unittesting;

import org.junit.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.lang.reflect.*;

import static org.mockito.Mockito.*;
import static org.junit.Assert.*;

public class MockTest {

	static Logger log = LoggerFactory.getLogger(MockTest.class);

	private Mock mock;
	static StreamReader[] streamReaders;

	@BeforeClass
	static public void beforeClass() {
		log.info("Make three StreamReaders");
		streamReaders = new StreamReader[3];
		streamReaders[0] = getStreamReader1();
		streamReaders[1] = getStreamReader2();
		streamReaders[2] = getStreamReader3();
	}

	@Before
	public void before() {
		log.info("Create new Mock");
		mock = new Mock();
	}

	@Test
	public void calcTest() {
		log.info("Starts calcTest");

		for(StreamReader reader : streamReaders) {
			mock.setStreamReader(reader);
			String result = mock.calc(16);
			log.info("mock.calc returns `{}`", result);
			assertEquals(result, "calculated Tatarstan");
		}
	}

	static StreamReader getStreamReader1() {
		// простой способ обернуть стрим
		// работает очень даже не плохо
		return new StreamReader() {
			@Override
			public String read(int id) {
				if (id == 16)
					return "Tatarstan";
				throw new RuntimeException();
			}
		};
	}

	static StreamReader getStreamReader2() {
		// пробую обернуть через прокси
		return (StreamReader) Proxy.newProxyInstance(Mock.class.getClassLoader(),
				new Class[]{StreamReader.class}, new InvocationHandler() {
					@Override
					public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
						if ((int) args[0] == 16)
							return "Tatarstan";
						throw new RuntimeException();
					}
				});
	}

	static StreamReader getStreamReader3() {
		// моками можно ваще коротко все записать
		StreamReader streamReader = mock(StreamReader.class);
		when(streamReader.read(16)).thenReturn("Tatarstan");
		return streamReader;
	}
}
