package ru.innolearn.day06.classes;

/**
 * Created by marina on 12.12.2016.
 */
class InterfaceOneImpl implements InterfaceOne {
	@Override
	public void doSome(int number) {
		System.out.println("1: Number is " + number);
	}
}
