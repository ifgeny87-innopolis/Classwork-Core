package ru.innolearn.day08.loggggging;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class LoggerTest2 {
	private static Logger logger = LoggerFactory.getLogger(LoggerTest2.class);

	public static void main(String[] args) {
		new LoggerTest2().run();
		new LoggerTest1().run();
	}

	public void run() {
		logger.info(getClass().getSimpleName() + " starts");
		logger.warn("Hello Kitty");
	}
}
