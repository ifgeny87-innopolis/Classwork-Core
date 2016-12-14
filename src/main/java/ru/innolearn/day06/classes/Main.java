package ru.innolearn.day06.classes;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * Created by marina on 12.12.2016.
 */
public class Main {
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

		// Proxy
		Object proxy = Proxy.newProxyInstance(Main.class.getClassLoader(),
				new Class[]{InterfaceOne.class, InterfaceTwo.class, InterfaceThree.class},
				new InvocationHandler() {
					private InterfaceOne derOne = new InterfaceOneImpl();
					private InterfaceTwo derTwo = new InterfaceTwoImpl();
					private InterfaceThree derThree = new InterfaceThreeImpl();
					@Override
					public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
						System.out.println("logging " + args);
						if(method.getDeclaringClass().equals(derOne.getClass())) {
							return method.invoke(derOne, args);
						}
						else if(method.getDeclaringClass().equals(derTwo.getClass())) {
							return method.invoke(derTwo, args);
						}
						else {
							return method.invoke(derThree, args);
						}
					}
				});
		InterfaceOne one = (InterfaceOne)proxy;
		one.doSome(5);

		InterfaceTwo two = (InterfaceTwo)proxy;
		two.doSome("hello");

		InterfaceThree three = (InterfaceThree)proxy;
		three.doSome(150);
		three.doSome("kitty");

		System.out.println(proxy);
	}
}