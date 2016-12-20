package ru.innolearn.day06.refletion;

import java.lang.reflect.Field;

/**
 * Created by marina on 12.12.2016.
 */
public class ReflectionMain {
	public static void main(String[] args) throws IllegalAccessException {
		Class<Human> humanClass = Human.class;
		Human human = new Human("Ivan", 25, "Ingenier");

		// вернет только public fields
		for (Field field : humanClass.getFields()) {
			System.out.println(field);
		}

		// вернет все fields
		for (Field field : humanClass.getDeclaredFields()) {
			// полиморфизм можно обойти если установить следующий флаг
			field.setAccessible(true);

			// изменение protected поля
			if ("age".equals(field.getName()))
				field.set(human, 48);

			// изменение private поля
			if ("state".equals(field.getName()))
				field.set(human, "Programmer");

			// читерство - изменение final поля
			if("money".equals(field.getName()))
				field.set(human, 1000);

			System.out.println(field.getName() + " = " + field.get(human));
		}
	}
}