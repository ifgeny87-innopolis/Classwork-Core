package ru.innolearn.day08.myappender;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.List;

/**
 * Задача:
 * Реализовать свой аппендер, реализующий отправку на почту.
 */
public class Task {
	private static Logger logger = LoggerFactory.getLogger(Task.class);

	public static void main(String[] args) {
		logger.trace("Hello");
		System.out.println("- Program says: First line");
		logger.debug("Kitty");
		logger.info("Its me");
		System.out.println("- Program says: Second line");
		logger.warn("Terminator");
		logger.error("I'l kill you");
	}
}