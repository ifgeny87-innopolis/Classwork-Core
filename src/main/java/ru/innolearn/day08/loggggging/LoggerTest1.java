package ru.innolearn.day08.loggggging;

import org.apache.log4j.MDC;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Created by marina on 14.12.2016.
 */
public class LoggerTest1 {
	private static Logger logger = LoggerFactory.getLogger(LoggerTest1.class);

	public static void main(String[] args) {
		new LoggerTest1().run();
		new LoggerTest2().run();
	}

	public void run() {
		logger.info(getClass().getSimpleName() + " starts");
		logger.warn("Hello Buddy");

		login("Makarov", "123");
	}

	void login(String userName, String password) {
		try {
			// mapped diagnostic context
			MDC.put("userName", userName);
			MDC.put("password", password);
			doSome();
		} finally {
			// очистка
			MDC.clear();
		}
	}

	void doSome() {
		logger.error("Login wrong for user");
	}
}
