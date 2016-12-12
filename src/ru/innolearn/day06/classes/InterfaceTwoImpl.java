package ru.innolearn.day06.classes;

/**
 * Created by marina on 12.12.2016.
 */
class InterfaceTwoImpl implements InterfaceTwo {
	@Override
	public void doSome(String s) {
		System.out.println("2: String is " + s);
	}
}
