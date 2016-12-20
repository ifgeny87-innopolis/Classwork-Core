package ru.innolearn.day06.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * Created by marina on 15.12.2016.
 */
public class ProxyMain {
	public static void main(String[] args) {
		// Proxy
		Object proxy = Proxy.newProxyInstance(ProxyMain.class.getClassLoader(),
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
